/**
 * 
 */
package fr.eni.mahm.projetencheres.dal.utilisateur;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * @author audreypercherancier
 *
 */
public interface UtilisateurDAO {

	void supprimer(int noUtilisateur); 
	Utilisateur connexion(String email,String pwd);
	void inserer(Utilisateur u); 
	void modifier(Utilisateur u); 
	List<Utilisateur> selectionnerUtilisateurs(); 
	Utilisateur selectionnerParId(int noUtilisateur);
	Utilisateur selectionnerParIdPublic(int noUtilisateur); 
	Utilisateur verificationMdp(String motDePasse);
	void modifierSolde(int nouveauSolde, int noUtilisateur);
}
