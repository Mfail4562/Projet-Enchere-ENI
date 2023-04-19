package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Categorie;
import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class AjoutArticleVente
 */
@WebServlet("/VendreUnArticle")
public class AjoutArticleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticleALaVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ArticleManager articleMgr = new ArticleManager();
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("userConnected");
		ArticleVendu articleAVendre;                             
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("descriptionArticle");
		Categorie categorie = new Categorie(Integer.parseInt(request.getParameter("categorie")));
		int prixBase = Integer.parseInt(request.getParameter("prixinitial"));
		Date finArticle =  Date.valueOf(request.getParameter("datefinencheres"));;
		Date debutEnchere = Date.valueOf(request.getParameter("datedebutencheres"));
		Retrait lieuRetrait = new Retrait(request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"));

		try {

			articleAVendre = new ArticleVendu(nom, description, debutEnchere, finArticle, prixBase,
					utilisateur.getNoUtilisateur(), lieuRetrait, categorie);

			articleMgr.ajouter(articleAVendre);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/ProjetEncheresENI/accueil");

	}

}
