/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * @author Hind El Moutawakil
 * @description Classe modélisant la vente d'un article
 * @date 20-03-2023
 * @version POO - V1.0
 */
public class Retrait {
	private String rue;
	private String codePostal;
	private String ville;
	
	//---------lien interclasse---------//
	private int noArticle;

	//------------------------------------- CONSTRUCTEUR ----------------------------------//
	/**
	 * pour recuperation en BDD
	 * @param noRetrait
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(int noArticle, String rue, String codePostal, String ville) throws CodePostalException, NoRetraitExeption {
		this.rue = rue;
		this.setCodePostal(codePostal);
		this.ville = ville;
		this.setNoArticle(noArticle);
	}

	/**
	 * pour insertion en BDD
	 * @param parameter
	 * @param parameter2
	 * @param parameter3
	 */
	public Retrait(String rue, String codePostal,String ville) {
		this.ville = ville;
		this.codePostal = codePostal;
		this.rue = rue;
	}
//--------------------------------------------SETTER ET GETTER-----------------------------------------------//


	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) throws CodePostalException {
		if (Integer.parseInt(codePostal) > 1000 && Integer.parseInt(codePostal) <= 99999) {
			this.codePostal = codePostal;
		} else {
			throw new CodePostalException("erreur sur le code postal");
		}
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return  rue+" "+ codePostal+" "+ville;
	}
	
	

}
