package fr.eni.mahm.projetencheres.ihm.servlet.utilisateur;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.Utilisateur;


/**
 * Servlet implementation class ListerUtilisateurs
 */
@WebServlet("/listeUtilisateur")
public class ListerUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  
	{
		
		List<Utilisateur> selectAll;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		selectAll = utilisateurManager.toutLesUtilisateurs();
		if (selectAll != null) {
			request.setAttribute("selectAll", selectAll);
			request.getRequestDispatcher("/WEB-INF/jsp/listeUtilisateur.jsp").forward(request, response);	
		}
			
	} 
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
