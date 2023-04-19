package fr.eni.mahm.projetencheres.dal.retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;

public class RetraitDAOJdbcImpl implements RetraitDAO{

	private final String AJOUTER = "INSERT INTO retraits (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";

	@Override
	public void supprimer(int noArticle) {
		
	}

	@Override
	public void ajouter(Retrait lieuRetrait) {
		Connection cnx = ConnectBDD.getConnection();
		try {
			PreparedStatement pstmt = cnx.prepareStatement(AJOUTER);
			pstmt.setInt(1, lieuRetrait.getNoArticle());
			pstmt.setString(2, lieuRetrait.getRue());
			pstmt.setString(3, lieuRetrait.getCodePostal());
			pstmt.setString(4, lieuRetrait.getVille());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Retrait nouveauLieuRetrait) {
		// TODO Auto-generated method stub	
	}

}
