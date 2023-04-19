package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bll.EnchereManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.bo.Utilisateur;



/**
 * Servlet implementation class detailleArticle
 */
@WebServlet("/detailsArticle")
public class detailsArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailsArticle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ArticleVendu article;
		ArticleManager articleMgr = new ArticleManager();
		
		article =  articleMgr.articleSelectionne(Integer.parseInt(request.getParameter("noArticle")));
		
		session.setAttribute("article", article);
		
		//Date  date = (article.getDateFinEncheres())-(new Date (System.currentTimeMillis()));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsArticle.jsp");
		rd.forward(request, response);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur encherisseur = (Utilisateur) session.getAttribute("userConnected");
		ArticleVendu article = (ArticleVendu) session.getAttribute("article");
		int montant = Integer.parseInt(request.getParameter("monEnchere"));
		EnchereManager enchereMgr = new EnchereManager();
		Enchere nouvelleEnchere;

		try {

			if (encherisseur.getCredit() >= montant && montant != article.getPrixVente()) {
				if (article.getPrixVente() < montant) {
					encherisseur.setCredit(encherisseur.getCredit() - montant);
					nouvelleEnchere = new Enchere(encherisseur, article, montant);

					enchereMgr.faireEnchere(nouvelleEnchere);

					article.setPrixVente(montant);
					session.setAttribute("article", article);
					session.setAttribute("userConnected", encherisseur);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsArticle.jsp");
		rd.forward(request, response);
	}

}
