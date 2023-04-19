<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un Article</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<br>
	<form action="Contient" method="post">
		<label for="Filtre">Le nom de l'article contient:</label> <input
			type="search" id="nomArticle" name="nomArticle"
			placeholder="le nom de l'article contient">
		<c:if test="${empty userConnected}">
			<button class="btn btn-primary" type="submit">rechercher</button>
		</c:if>
		<c:if test="${!empty userConnected}">
			<button class="btn btn-primary" type="submit">rechercher</button>
		</c:if>
	</form>
	<br>
	<form action="RechercherPar" method="post">
		<label for="categories">catégories:</label> <select name="categories"
			id="categories">
			<option value="0">Toutes</option>
			<option value="1">Hygiène et Santé</option>
			<option value="2">Animalerie</option>
			<option value="3">Maison</option>
			<option value="4">Jardin</option>
			<option value="5">Sports et Loisirs</option>
			<option value="6">Jeux et Jouets</option>
			<option value="7">Bricolage</option>
			<option value="8">Mode</option>
			<option value="9">High-Tech</option>
			<option value="10">Vehicules</option>
			<option value="11">Autres</option>
		</select>
		<c:if test="${empty userConnected}">
			<button class="btn btn-primary" type="submit">rechercher</button>
		</c:if>
		<c:if test="${!empty userConnected}">
			<button class="btn btn-primary" type="submit">rechercher</button>
		</c:if>
	</form>
	<div class="container">
		<div class="col-8 offset-2">
			<div class="row justify-content-evenly">
				<c:forEach var="ArticleVendu"
					items="${requestScope.listeArticleVendu}">
					<div class="card text-center col-5 my-3 p-0 shadow">
						<c:if test="${empty userConnected}">
							<a href="/ProjetEncheresENI/login"
								class="card-header text-decoration-none">${ArticleVendu.pseudo}</a>
						</c:if>
						<c:if test="${!empty userConnected}">
							<a href="AfficherUtilisateur?id=${ArticleVendu.noVendeur}"
								class="card-header text-decoration-none">${ArticleVendu.pseudo}</a>
						</c:if>
						<img
							src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg"
							class="img-fluid" alt="fuck" />
						<div class="card-body">
							<h5 class="card-title">${ArticleVendu.nomArticle}</h5>
							<hr>
							<p class="card-text">Description: ${ArticleVendu.description}
							</p>
							<hr>
							<p class="card-text">Date debut des encheres:
								${ArticleVendu.dateDebutEncheres}</p>
							<hr>
							<p class="card-text">Date fin des
								encheres:${ArticleVendu.dateFinEncheres}</p>
							<hr>
							<p class="card-text">Prix de l'article
								${ArticleVendu.prixVente}</p>
							<hr>
							<c:if test="${empty userConnected}">
								<a href="/ProjetEncheresENI/login" class="btn btn-primary">Voir
									l'enchère</a>
							</c:if>
							<c:if test="${!empty userConnected}">
								<a
									href="<%=request.getContextPath() %>/detailArticle?noArticle=${ArticleVendu.noArticle}"
									class="btn btn-primary">Voir l'enchère</a>
							</c:if>
						</div>
						<div class="card-footer text-muted">temps restant enchere</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>