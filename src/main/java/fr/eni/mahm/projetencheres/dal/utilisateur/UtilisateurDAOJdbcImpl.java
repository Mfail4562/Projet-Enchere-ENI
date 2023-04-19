package fr.eni.mahm.projetencheres.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bo.Utilisateur;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private final String MYSQLLOGIN = "select no_utilisateur, pseudo, nom, prenom, email, mot_de_passe, telephone, rue, code_postal, ville, credit from utilisateurs where (email like binary ? or pseudo like binary ?) and mot_de_passe=? ";
	private final String MYSQLDELETE = "delete from utilisateurs where no_utilisateur=";
	private final String MYSQLINSERT = "insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)  values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String MYSQLUPDATE = "update utilisateurs set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?, mot_de_passe=? where no_utilisateur=";	
	private final String MYSQLSELECTALL = "select pseudo,nom,prenom,email,telephone,rue,code_postal,ville,credit from utilisateurs";
	private final String MYSQLSELECTBYID = "select * from utilisateurs where no_utilisateur=?";
	private final String MYSQLVERIFMDP = "select no_utilisateur, pseudo, nom, prenom, email, mot_de_passe, telephone, rue, code_postal, ville, credit from utilisateurs where mot_de_passe=?";
	private final String MYSQLSELECTBYIDPUBLIC = "select pseudo,nom,prenom,email,telephone,rue,code_postal,ville from utilisateurs where no_utilisateur=?";
	
	
	private final String MODIFICATION_SOLDE = "UPDATE utilisateurs  SET credit = ? WHERE no_utilisateur = ?";

	// --------------------------------------------Constructeur par
	// défault-------------------------------------------------------------------//

	public UtilisateurDAOJdbcImpl() {
	}

	// --------------------------------LOGIN---------------------------//
	public Utilisateur connexion(String login, String pwd) {
		Utilisateur utilisateur = null;
		try (Connection con = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(MYSQLLOGIN);
			if (login.contains("@")) {
				pstmt.setString(1, login);
				pstmt.setString(2, null);
			} else {
				pstmt.setString(1, null);
				pstmt.setString(2, login);
			}
			pstmt.setString(3, pwd);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				utilisateur = rsToUtilisateur(rs);
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return utilisateur;
	}

	// --------------------------------DELETE---------------------------//
	public void supprimer(int noUtilisateur) {
		Connection cnx;
		Statement stmt;
		cnx = ConnectBDD.getConnection();
		try {
			cnx.setAutoCommit(false);
			stmt = cnx.createStatement();
			stmt.executeUpdate(MYSQLDELETE + noUtilisateur);

			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	// ------------------------INSERT-------------------------------//

	public void inserer(Utilisateur u) {
		Connection cnx = ConnectBDD.getConnection();

		try {
			PreparedStatement pstmt;
			cnx.setAutoCommit(false);
			pstmt = cnx.prepareStatement(MYSQLINSERT);
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11, u.isAdministrateur());
			pstmt.executeUpdate();
			cnx.commit();
			
			PreparedStatement stmt = cnx.prepareStatement("select no_utilisateur from utilisateurs where pseudo=?");
			stmt.setString(1, u.getPseudo());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				u.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}


			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	// ------------------------UPDATE-------------------------------//
	public void modifier(Utilisateur u) {
		Connection cnx;
		PreparedStatement stmt;
		cnx = ConnectBDD.getConnection();
		try {
			cnx.setAutoCommit(false);
			stmt = cnx.prepareStatement(MYSQLUPDATE + u.getNoUtilisateur());
			stmt.setString(1, u.getPseudo());
			stmt.setString(2, u.getNom());
			stmt.setString(3, u.getPrenom());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getTelephone());
			stmt.setString(6, u.getRue());
			stmt.setString(7, u.getCodePostal());
			stmt.setString(8, u.getVille());
			stmt.setString(9, u.getMotDePasse()); 
			stmt.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// ------------------------SELECTALL-------------------------------//
	public List<Utilisateur> selectionnerUtilisateurs() {
		Statement stmt;
		ResultSet rs;
		ArrayList<Utilisateur> lst = new ArrayList<>();
		Connection cnx = ConnectBDD.getConnection();
		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(MYSQLSELECTALL);
			while (rs.next()) {
				lst.add(new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville")));
			}
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	// ------------------------SELECTBYID-------------------------------//
	public Utilisateur selectionnerParId(int noUtilisateur) {
		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		cnx = ConnectBDD.getConnection();
		Utilisateur u = null;
		try {
			stmt = cnx.prepareStatement(MYSQLSELECTBYID);
			stmt.setInt(1, noUtilisateur);
			rs = stmt.executeQuery();
			if(rs.next()) {
				u = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			cnx.close();
		} catch (Exception e) {
			
				try {
					cnx.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
		}
		
		return u;
	}

	public Utilisateur selectionnerParIdPublic(int noUtilisateur) {
		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		cnx = ConnectBDD.getConnection();
		Utilisateur u= null;

		try {
			cnx.setAutoCommit(false);
			stmt = cnx.prepareStatement(MYSQLSELECTBYIDPUBLIC);
			stmt.setInt(1, noUtilisateur);
			rs = stmt.executeQuery();
			u = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
					rs.getString("ville"));
			cnx.commit();
			cnx.close();
		} catch (Exception e) {
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

		return u;
	}
	
	public Utilisateur verificationMdp(String motDePasse) {
		Utilisateur u = null;
		try (Connection con = ConnectBDD.getConnection()) {
			 
			PreparedStatement pstmt = con.prepareStatement(MYSQLVERIFMDP);
			pstmt.setString(1, motDePasse);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
		
	}

	private Utilisateur rsToUtilisateur(ResultSet rs) {
		Utilisateur u = null;
		try {

			u = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
					rs.getString("prenom"), rs.getString("email"), rs.getString("mot_de_passe"),
					rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
					rs.getInt("credit"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void modifierSolde(int nouveauSolde, int noUtilisateur) {

		try(Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(MODIFICATION_SOLDE);
			pstmt.setInt(1, nouveauSolde);
			pstmt.setInt(2, noUtilisateur);
			
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
