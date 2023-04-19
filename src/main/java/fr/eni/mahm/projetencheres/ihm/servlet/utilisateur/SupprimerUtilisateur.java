package fr.eni.mahm.projetencheres.ihm.servlet.utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;


/**
 * Servlet implementation class SupprimerUtilisateur
 */
@WebServlet({ "/supprimer", "/delete" })
public class SupprimerUtilisateur extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id;
		HttpSession ses;
		
		id=Integer.parseInt(request.getParameter("id"));
		UtilisateurManager.supprimerParId(id);
		
		ses=request.getSession();
		ses.setAttribute("userConnected", null);
		
		response.sendRedirect("/ProjetEncheresENI/accueil");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id;
		HttpSession ses;
		
		
		id=Integer.parseInt(request.getParameter("id"));
		System.out.println();
		UtilisateurManager.supprimerParId(id);
		
		ses=request.getSession();
		ses.setAttribute("userConnected", null);
		
		response.sendRedirect("/ProjetEncheresENI/accueil");
		
	}

}
