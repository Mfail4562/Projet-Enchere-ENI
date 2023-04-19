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
 * Servlet implementation class AfficherUtilisateur
 */
@WebServlet("/AfficherUtilisateur")
public class AfficherUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Utilisateur u;
		UtilisateurManager utilisateurMgr = new UtilisateurManager();
		
		u= utilisateurMgr.selectionnerParId(Integer.parseInt(request.getParameter("id")));
		session.setAttribute("utilisateur", u);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/afficherUtilisateur.jsp");
		rd.forward(request, response);
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
