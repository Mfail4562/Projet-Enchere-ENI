package fr.eni.mahm.projetencheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bo.Utilisateur;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.utilisateur.UtilisateurDAO;

public class UtilisateurManager {
	
	private static UtilisateurDAO userDAO;
	
	//-----------CONSTRUCTOR-------------------//
	public UtilisateurManager() {
		userDAO = DAOFactory.getUtilisateurDAO();
	}
	
	//----------FUNCTION---------------------//
	public Utilisateur connexion(String email, String password) {
		Utilisateur userConnected = null;
		
		try {
			userConnected = userDAO.connexion(email, password);
		} catch (Exception e) {
			
		}
		
		return userConnected;
	}
	
	public void modifier(Utilisateur c) {
		userDAO.modifier(c);
	}
	public void inscription(Utilisateur nouvelUtilisateur) {
		userDAO.inserer(nouvelUtilisateur);
		
	}
	public List<Utilisateur> toutLesUtilisateurs(){
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurs = userDAO.selectionnerUtilisateurs();
		
		return utilisateurs;
	}
	public static void supprimerParId(int id) {
		userDAO.supprimer(id);
	}
	public Utilisateur selectionnerParId(int id) {
		Utilisateur userConnected = null;
		
			userConnected = userDAO.selectionnerParId(id);
		
		return userConnected;
	}
	
	public Utilisateur selectionnerParIdPublic(int id) {
		Utilisateur u = null; 
		u = userDAO.selectionnerParIdPublic(id); 
		return u;
		
	}
	
	public Utilisateur verificationMdp(String motDePasse) {
		Utilisateur u = null;
		
		try {
			u = userDAO.verificationMdp(motDePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
		}
	
	public void miseAJourSolde(int nouveauSolde, int noUtilisateur) {
		userDAO.modifierSolde(nouveauSolde, noUtilisateur);
	}


}
