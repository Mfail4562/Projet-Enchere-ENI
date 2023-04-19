package fr.eni.mahm.projetencheres.dal.enchere;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.Enchere;

public interface EnchereDAO {

	public List<Enchere> recupererMesEncheres(int noEncherisseur);
	public Enchere recupererDerniereEnchere(int noArticle);	
	public void ajouter(Enchere enchere);
	
}
