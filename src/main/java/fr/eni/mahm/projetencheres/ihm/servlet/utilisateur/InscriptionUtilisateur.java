package fr.eni.mahm.projetencheres.ihm.servlet.utilisateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class AjouterUtilisateur
 */
@WebServlet("/inscription")
public class InscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String mdp = request.getParameter("motDePasse");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		UtilisateurManager userMgr = new UtilisateurManager();
		List<Utilisateur> utilisateurs = userMgr.toutLesUtilisateurs();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getPseudo().equalsIgnoreCase(pseudo)) {
				request.setAttribute("usedPseudo", "Pseudo déjà utilisé");
				doGet(request, response);
			} else if (utilisateur.getEmail().equals(email)) {
				request.setAttribute("usedEmail", "Email déjà connue");
				doGet(request, response);
			}
		}
		if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
			request.setAttribute("erreurPseudo", "Le pseudo ne peux pas contenir de caractères spéciaux");
			doGet(request, response);
		} else {
			Utilisateur nouvelUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp);
			userMgr.inscription(nouvelUtilisateur);
			HttpSession session = request.getSession();
			session.setAttribute("newUser", nouvelUtilisateur);
			response.sendRedirect("/ProjetEncheresENI/login");
		}
	}

}
