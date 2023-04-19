/**
 * 
 */
package fr.eni.mahm.projetencheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.enchere.EnchereDAO;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class EnchereManager {
	
	private static EnchereDAO enchereDAO;
	private static ArticleManager articleMgr = new ArticleManager();
	private static UtilisateurManager utilisateurMgr = new UtilisateurManager(); 
	// -----------CONSTRUCTEUR ZONE-----------//
	public EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	// -----------FUNCTION-----------//
	
	public void faireEnchere(Enchere enchere) {
		if(Enchere.enchereValide(enchere.getArticle(), enchere.getMontantEnchere())) {
			
			rendreArgentAncienEncherisseur(enchere.getArticle().getNoArticle());
			
			enchereDAO.ajouter(enchere);
			articleMgr.faireEnchere(enchere.getMontantEnchere(), enchere.getArticle().getNoArticle());
			utilisateurMgr.miseAJourSolde(enchere.getEncherisseur().getCredit(), enchere.getEncherisseur().getNoUtilisateur());
		}
	}
	
	private static void rendreArgentAncienEncherisseur(int noArticle) {
		
		Enchere ancienneEnchere = enchereDAO.recupererDerniereEnchere(noArticle);
		if(ancienneEnchere != null) {
		int credit = ancienneEnchere.getEncherisseur().getCredit() + ancienneEnchere.getMontantEnchere();
		System.out.println("credit actuel ancien encherisseur = " + ancienneEnchere.getEncherisseur().getCredit());
		System.out.println("montant ancienne enchere = " + ancienneEnchere.getMontantEnchere());
		System.out.println("nouveau solde = " + credit);
		
		utilisateurMgr.miseAJourSolde(credit, ancienneEnchere.getEncherisseur().getNoUtilisateur());
		}
	}

	public Enchere recupererDerniereEnchere(ArticleVendu articleVendu) {
		return enchereDAO.recupererDerniereEnchere(articleVendu.getNoArticle());
	}
	
	public List<Enchere> recupererMesEncheres(int noEncherisseur){
		List<Enchere> mesEncheres = new ArrayList<>();
		 mesEncheres = enchereDAO.recupererMesEncheres(noEncherisseur);
		return mesEncheres;
		
	}

}
