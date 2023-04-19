package fr.eni.mahm.projetencheres.bo;

import java.util.List;

/**
 * Classe categorisant une enchere
 * @author Mfail4562
 * @version 1.0.0
 */
public class Categorie {
	private int noCategorie ;
	private String libelle;
	private List<ArticleVendu> articles;
	
	//-------------------- CONSTRUCTOR ZONE --------------------//

	/**
	 * pour DB
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
	this.noCategorie = noCategorie;
	this.libelle = libelle;
}
	
	
	/**
	 * pour inscription article
	 * @param noCategorie
	 */
	public Categorie(int noCategorie) {
		super();
		this.noCategorie = noCategorie;
	}


	//-------------------- CONSTRUCTOR ZONE --------------------//
	
	public void ajouterArticle(ArticleVendu article) {
		this.articles.add(article);
	}
	
	//-------------------- GETTER/SETTER ZONE --------------------//

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the article
	 */
	public List<ArticleVendu> getArticles() {
		return articles;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
	}
	
}
