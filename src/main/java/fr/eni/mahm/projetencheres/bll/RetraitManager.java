package fr.eni.mahm.projetencheres.bll;

import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.retrait.RetraitDAO;

public class RetraitManager {
	private static RetraitDAO retraitDAO;
	
	//----------CONSTRUCTEUR ZONE----------//
	public RetraitManager() {
		retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	//-----------FONCTION------------//
	public void ajouter(Retrait lieuRetrait) {
		retraitDAO.ajouter(lieuRetrait);
	}
}
