package fr.eni.mahm.projetencheres.ihm.servlet.utilisateur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.Utilisateur;


/**
 * Servlet implementation class ModifierUtilisateur
 */
@WebServlet("/modifier")
public class ModifierUtilisateur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifier.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		
		
		int id;
		UtilisateurManager userMgr = new UtilisateurManager(); 
		try {
			request.setCharacterEncoding("UTF-8");
			id=Integer.parseInt(request.getParameter("id"));
			String ancienMotDePasseEcrit =request.getParameter("ancienMotDePasse"); 
			String nouveauMotDePasse = request.getParameter("nouveauMotDePasse"); 
			String nouveauMotDePasseconfirme = request.getParameter("nouveauMotDePasseConfirme"); 
			Utilisateur u = new Utilisateur(); 
			u=userMgr.selectionnerParId(id); 
			
			if (u!=null) {
					
				if(u.getMotDePasse().equals(Utilisateur.hashagePwd(ancienMotDePasseEcrit))) {
					Utilisateur	 utilisateurModifie = new Utilisateur(request.getParameter("pseudo"),
							request.getParameter("nom"), 
							request.getParameter("prenom"),
							request.getParameter("email"),
							request.getParameter("numero"),
							request.getParameter("rue"),
							request.getParameter("codePostal"),
							request.getParameter("ville"),
							ancienMotDePasseEcrit);
		
					utilisateurModifie.setNoUtilisateur(u.getNoUtilisateur());
					

					
					if(nouveauMotDePasse != null && !nouveauMotDePasse.isEmpty() && !nouveauMotDePasse.isBlank() &&
					   nouveauMotDePasseconfirme != null && !nouveauMotDePasseconfirme.isEmpty() && !nouveauMotDePasseconfirme.isBlank() &&
					   nouveauMotDePasse.equals(nouveauMotDePasseconfirme)){
						
						
						utilisateurModifie.setMotDePasse(nouveauMotDePasseconfirme);
						userMgr.modifier(utilisateurModifie); 
						session.setAttribute("userConnected", utilisateurModifie);
						response.sendRedirect("/ProjetEncheresENI/monCompte"); 
						
						
					}else if(nouveauMotDePasse != null && !nouveauMotDePasse.isEmpty() && !nouveauMotDePasse.isBlank() &&
							   nouveauMotDePasseconfirme != null && !nouveauMotDePasseconfirme.isEmpty() && !nouveauMotDePasseconfirme.isBlank() &&
							   !nouveauMotDePasse.equals(nouveauMotDePasseconfirme)) {
						request.setAttribute("nosimilairesmdp", "Les nouveaux mots de passe ne sont pas exactes, veuillez recommencer."); 
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier.jsp");
						rd.forward(request, response);
					}else {
						userMgr.modifier(utilisateurModifie); 
						session.setAttribute("userConnected", utilisateurModifie);
						response.sendRedirect("/ProjetEncheresENI/monCompte"); 
					}
					
					
			}	else {
				request.setAttribute("mdpincorrect", "Votre mot de passe est incorrect, veuillez réessayer."); 
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier.jsp");
				rd.forward(request, response);
				
				  }
				
			} else {
				request.setAttribute("invalid-feedback","Une erreur est survenue"); 
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	

	}

