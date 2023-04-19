package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * Servlet implementation class ModifierArticle
 */
@WebServlet("/modifierArticle")
public class ModifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		ArticleVendu article;
		ArticleManager articleMgr = new ArticleManager();
		
		article = (ArticleVendu) session.getAttribute("article");
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArticleVendu articleModifie	=	(ArticleVendu) session.getAttribute("article");
		ArticleManager articleMgr =new ArticleManager();
		
		try {
			System.out.println("coucou");
			
			articleModifie.setNomArticle(request.getParameter("nomArticle")) ;
			
			articleModifie.setDescription(request.getParameter("description"));
			articleModifie.setDateDebutEncheres(Date.valueOf( request.getParameter("dateDebutEncheres")));
			articleModifie.setDateFinEncheres(Date.valueOf( request.getParameter("dateFinEncheres")));
			articleModifie.setMiseAPrix( Integer.parseInt(request.getParameter("miseAPrix")));
			articleModifie.getCategorie().setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
			
			articleMgr.modifier(articleModifie);
			session.setAttribute("validation", "Vos modifications ont bien étés bien pris en compte");
			session.setAttribute("article", articleModifie);
			response.sendRedirect("/ProjetEncheresENI/modifierArticle"); 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
