/**
 * 
 */
package fr.eni.mahm.projetencheres.dal;

import fr.eni.mahm.projetencheres.dal.article.ArticleDAO;
import fr.eni.mahm.projetencheres.dal.article.ArticleDAOJdbcImpl;
import fr.eni.mahm.projetencheres.dal.enchere.EnchereDAO;
import fr.eni.mahm.projetencheres.dal.enchere.EnchereDAOJdbcImpl;
import fr.eni.mahm.projetencheres.dal.retrait.RetraitDAO;
import fr.eni.mahm.projetencheres.dal.retrait.RetraitDAOJdbcImpl;
import fr.eni.mahm.projetencheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.mahm.projetencheres.dal.utilisateur.UtilisateurDAOJdbcImpl;

/**
 * @author groupe Mahm Cookies
 *
 */
public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}

	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
}
