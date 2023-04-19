/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import java.sql.Date;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class Enchere {
	private Date dateEnchere;
	private int montantEnchere;
	private int noArticle;

	// ---------lien interclasses---------//

	private ArticleVendu article;
	private Utilisateur encherisseur;

	// ------------------------ CONSTRUCTOR ZONE ------------------------//
	
	
	
	
	/**
	 * pour insertion BD 
	 * @param encherisseur
	 * @param article
	 * @param montantEnchere
	 */
	public Enchere(Utilisateur encherisseur, ArticleVendu article, int montantEnchere) {
		this.article = article;
		this.dateEnchere = new Date(System.currentTimeMillis());
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}

	/**
	 * pour recuperer derniere enchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param encherisseur
	 */
	public Enchere(Utilisateur encherisseur, int montantEnchere, Date dateEnchere, int noArticle) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
		this.noArticle = noArticle;
	}

	/**
	 * pour tri connecté
	 * @param utilisateur
	 * @param articleVendu
	 */
	public Enchere(Utilisateur utilisateur, ArticleVendu articleVendu) {
		this.encherisseur = utilisateur;
		this.article = articleVendu;
	}
	
	
	//------------------------- FUNCTION ZONE------------------------//

	/**
	 * verifie la validité de l'enchere
	 * 
	 * @param article
	 * @param montant
	 * @return
	 */
	public static boolean enchereValide(ArticleVendu article, int montant) {
		Date now = new Date(System.currentTimeMillis());
		boolean valide = true;
		if (article.getMiseAPrix() > montant || article.getPrixVente() > montant
				|| article.getDateFinEncheres().before(now) || article.getDateDebutEncheres().after(now)) {
			valide = false;
		}
		return valide;
	}


	// ------------------------ GETTER/SETTER ZONE------------------------//

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @return the encherisseur
	 */
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}
	
	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	// ------------------to string-----------------//
	@Override
	public String toString() {
		return "le :" + dateEnchere + "pour" + article.getNomArticle() + " : " + montantEnchere + "crédit";
	}


}
