package fr.eni.mahm.projetencheres.dal.retrait;

import fr.eni.mahm.projetencheres.bo.Retrait;

/**
 * 
 * @author MFail4562
 * @version 1.0.0
 */
public interface RetraitDAO {

	void supprimer(int noArticle);
	void ajouter(Retrait lieuRetrait);
	void modifier(Retrait nouveauLieuRetrait);
	
}
