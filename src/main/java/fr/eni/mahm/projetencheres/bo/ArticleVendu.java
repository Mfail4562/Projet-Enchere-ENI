/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import java.sql.Date;

/**
 * @author Thoumire Mathieu & Mathieu Perin
 * @description Classe modélisant la vente d'un article
 * @date 20-03-2023
 * @version POO - V1.2
 */
public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;
	private int noVendeur;
	private int noAcquereur;

	// -----------------lien interclasses-----------------//
	private Enchere enchereGagnante;
	private Utilisateur vendeur;
	private Retrait lieuRetrait;
	private Categorie categorie;
	private String Pseudo;

	// -------------------- CONSTRUCTOR ZONE --------------------//

	/**
	 * Constructeur pour recuperation base de donnee
	 * 
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param vendeur
	 * @param lieuRetrait
	 */
	public ArticleVendu(String Pseudo, int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int noVendeur, Retrait lieuRetrait, Categorie categorie,
			int noAcquereur) {
		this.Pseudo = Pseudo;
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noVendeur = noVendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
		this.noAcquereur = noAcquereur;
	}

	/**
	 * Constructeur pour Base De Donnée
	 * 
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param vendeur
	 * @param lieuRetrait
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int noVendeur, Retrait lieuRetrait, Categorie categorie) {
		this.nomArticle = nomArticle.toLowerCase();
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = miseAPrix;
		this.noVendeur = noVendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
	}

	/**
	 * Constructeur pour tri connecté
	 * 
	 * @param noArticle
	 */
	public ArticleVendu(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @description constructeur
	 */
	public ArticleVendu() {
	}

	// -----------------------------------------GETTER SETTER
	// ZONE----------------------------------------//
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

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebutEncheres
	 */
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * @return the dateFinEncheres
	 */
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the etatVente
	 */
	public int getEtatVente() {
		return etatVente;
	}

	/**
	 * @param etatVente the etatVente to set
	 */
	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}

	/**
	 * @return the enchereGagnante
	 */
	public Enchere getEnchereGagnante() {
		return enchereGagnante;
	}

	/**
	 * @param enchereGagnante the enchereGagnante to set
	 */
	public void setEnchereGagnante(Enchere enchereGagnante) {
		this.enchereGagnante = enchereGagnante;
		this.setPrixVente(enchereGagnante.getMontantEnchere());
	}

	/**
	 * @return the lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	/**
	 * @param lieuRetrait the lieuRetrait to set
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	/**
	 * @return the noVendeur
	 */
	public int getNoVendeur() {
		return noVendeur;
	}

	/**
	 * @param noVendeur the noVendeur to set
	 */
	public void setNoVendeur(int noVendeur) {
		this.noVendeur = noVendeur;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return Pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}

	public int getNoAcquereur() {
		return noAcquereur;
	}

	public void setNoAcquereur(int noAcquereur) {
		this.noAcquereur = noAcquereur;
	}

	// --------------------------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ",no_vendeur=" + noVendeur
				+ "]";
	}

}
