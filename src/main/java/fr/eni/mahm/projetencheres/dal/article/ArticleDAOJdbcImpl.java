/**
 * 
 */
package fr.eni.mahm.projetencheres.dal.article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bll.RetraitManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Categorie;
import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;
import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {
	private final String SUPPRIMER = "DELETE FROM articles_vendus, retraits WHERE no_article=?";
	private final String SELECTION_TOUT_ARTICLES = "SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville,u.pseudo FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie=av.no_categorie INNER JOIN utilisateurs u  ON u.no_utilisateur=av.no_utilisateur";
	private final String AJOUTER = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	private final String UPDATE_PRIX_ARTICLE = " UPDATE articles_vendus SET prix_vente = ? WHERE (no_article = ?)";
	private final String MODIFIER = "update articles_vendus set nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?, no_categorie=? where no_article=?";
	private final String SELECTION_ARTICLE = "SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville, u.pseudo FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie = av.no_categorie INNER JOIN utilisateurs u  ON u.no_utilisateur=av.no_utilisateur WHERE av.no_article=?";
	private final String SELECTION_ARTICLE_PAR_CATEGORIE ="SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville, u.pseudo FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie = av.no_categorie INNER JOIN utilisateurs u  ON u.no_utilisateur=av.no_utilisateur WHERE av.no_categorie=?";
	private final String SELECTION_ARTICLE_PAR_NOM ="SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville, u.pseudo FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie = av.no_categorie INNER JOIN utilisateurs u  ON u.no_utilisateur=av.no_utilisateur WHERE av.nom_article LIKE ? ";
	private final String ASSIGNER_ACQUEREUR = "UPDATE articles_vendus SET no_acquereur = ? WHERE (no_article = ?)";
	@Override
	public void supprimer(int noArticle) {
		Connection cnx = ConnectBDD.getConnection();
		try {
			cnx.setAutoCommit(false);
			PreparedStatement pstmt = cnx.prepareStatement(SUPPRIMER);
			pstmt.setInt(1, noArticle);
			pstmt.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void ajouter(ArticleVendu article) {

		try (Connection cnx = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(AJOUTER, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, article.getDateDebutEncheres());
			pstmt.setDate(4, article.getDateFinEncheres());
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getNoVendeur());
			pstmt.setInt(8, article.getCategorie().getNoCategorie());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.getLieuRetrait().setNoArticle(rs.getInt(1));
			}

			try {
				RetraitManager retraitMgr = new RetraitManager();
				retraitMgr.ajouter(article.getLieuRetrait());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifier(ArticleVendu article) {
		Connection cnx;
		PreparedStatement stmt;
		cnx=ConnectBDD.getConnection();
		try {
			cnx.setAutoCommit(false);
			stmt = cnx.prepareStatement(MODIFIER );
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, article.getDateDebutEncheres());
			stmt.setDate(4, article.getDateFinEncheres());
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getCategorie().getNoCategorie());
			stmt.setInt(8, article.getNoArticle());
			stmt.executeUpdate();
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
	}
	@Override
	public List<ArticleVendu> selectionArticles() {
		List<ArticleVendu> articlesEnVente = new ArrayList<>();

		try (Connection cnx = ConnectBDD.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTION_TOUT_ARTICLES);

			while (rs.next()) {
				articlesEnVente.add(new ArticleVendu(rs.getString("pseudo"),rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")), rs.getInt("no_acquereur")));
			}
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}
		return articlesEnVente;
	}

	@Override
	public ArticleVendu selectionParNoArticle(int noArticle) {
		ArticleVendu article = null;

		try (Connection cnx = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTION_ARTICLE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new ArticleVendu(rs.getString("pseudo"), rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"),
								rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")), rs.getInt("no_acquereur"));

			}

		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}

		return article;
	}
	
	@Override
	public List<ArticleVendu> selectionParcategorie(int categorie) {
		List<ArticleVendu> articlesEnVente = new ArrayList<>();

		try (Connection cnx = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTION_ARTICLE_PAR_CATEGORIE);
			pstmt.setInt(1, categorie);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				articlesEnVente.add(new ArticleVendu(rs.getString("pseudo"),rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")),rs.getInt("no_acquereur")));
			}
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}
		return articlesEnVente;

		
	}

	@Override
	public List<ArticleVendu> selectionArticleParNom(String nomArticle) {
		List<ArticleVendu> articlesEnVente = new ArrayList<>();
		try (Connection cnx = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTION_ARTICLE_PAR_NOM);
			pstmt.setString(1, '%'+nomArticle+'%');
		
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				articlesEnVente.add(new ArticleVendu(rs.getString("pseudo"),rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")), rs.getInt("no_acquereur")));
			}
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}
		return articlesEnVente;
	}

	
	public void nouvelleEnchere(int montantEnchere, int noArticle) {
		
		try(Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PRIX_ARTICLE);
			pstmt.setInt(1, montantEnchere);
			pstmt.setInt(2, noArticle);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();		}
		
	}

	@Override
	public ArticleVendu assignerAcquereur(int noArticle, int noAcquereur) {
		ArticleVendu article = null;
		try (Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(ASSIGNER_ACQUEREUR);
			pstmt.setInt(1, noAcquereur);
			pstmt.setInt(2, noArticle);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
	}

}



















