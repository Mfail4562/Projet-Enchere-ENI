package fr.eni.mahm.projetencheres.bll;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.bo.Utilisateur;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.article.ArticleDAO;

public class ArticleManager {

	private static ArticleDAO articleDAO;
	private static EnchereManager enchereMgr = new EnchereManager();
	private static UtilisateurManager utilisateurMgr = new UtilisateurManager();

	// -----------CONSTRUCTEUR ZONE-----------//
	public ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}

	// -----------FUNCTION-----------//
	/**
	 * ajoute un article en BD
	 * 
	 * @param articleAVendre
	 */
	public void ajouter(ArticleVendu articleAVendre) {
		articleDAO.ajouter(articleAVendre);
	}

	/**
	 * recupere tout les articles en BD
	 * 
	 * @return
	 */
	public List<ArticleVendu> articlesEnVente() {
		return articleDAO.selectionArticles();
	}

	/**
	 * supprime l'article en BD via son numero unique
	 * 
	 * @param noArticle
	 */
	public void supprimer(int noArticle) {
		articleDAO.supprimer(noArticle);
	}

	/**
	 * recupere les informations d'un article precis en BD
	 * 
	 * @param noArticle
	 * @return
	 */
	public ArticleVendu articleSelectionne(int noArticle) {
		return articleDAO.selectionParNoArticle(noArticle);
	}

	/**
	 * modifie l'article en BD
	 * 
	 * @param articleAModifie
	 */
	public void modifier(ArticleVendu articleAModifie) {
		articleDAO.modifier(articleAModifie);
	}
	

	public List<ArticleVendu>selectionParcategorie(int categorie){	
		 return articleDAO.selectionParcategorie(categorie);
	}
	public List<ArticleVendu>selectionArticleParNom(String nomArticle){	
		 return articleDAO.selectionArticleParNom(nomArticle);
	}

	
	public void faireEnchere(int montant, int noArticle) {
		articleDAO.nouvelleEnchere(montant, noArticle);
	}

	public ArticleVendu assignerAcquereur(ArticleVendu articleVendu) {
		Enchere derniereEnchere = enchereMgr.recupererDerniereEnchere(articleVendu);
		System.out.println("recuperation bll articleMgr : "+articleVendu.getNoVendeur());
		Utilisateur vendeur = utilisateurMgr.selectionnerParId(articleVendu.getNoVendeur());
		if (derniereEnchere != null) {
			int nouveauSoldeVendeur = vendeur.getCredit() + derniereEnchere.getMontantEnchere();
			
			utilisateurMgr.miseAJourSolde(nouveauSoldeVendeur, vendeur.getNoUtilisateur());
			
			articleDAO.assignerAcquereur(derniereEnchere.getNoArticle(), derniereEnchere.getEncherisseur().getNoUtilisateur());
		}
		
	ArticleVendu articleTest = articleDAO.selectionParNoArticle(articleVendu.getNoArticle());
	System.out.println("article recupere pour ajout dans la liste : "+ articleTest.getNomArticle() + ";" + articleTest.getNoAcquereur());
	
	return articleTest;
		
	}

}
