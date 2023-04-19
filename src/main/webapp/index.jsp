<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,fr.eni.mahm.projetencheres.bo.ArticleVendu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Page d'accueil</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body>


	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<br>
	<div class="container">
		<form class="form-inline" action="RechercheArticle" method="post">
			<div class="input-group">
				<div class="input-group-prepend">
					<select name="categories" id="categories" class=" form-select">
						<option value="0" selected disabled>Toutes catégories :</option>
						<option value="1">Hygiène et Santé</option>
						<option value="2">Animalerie</option>
						<option value="3">Maison</option>
						<option value="4">Jardin</option>
						<option value="5">Sports et Loisirs</option>
						<option value="6">Jeux et Jouets</option>
						<option value="7">Bricolage</option>
						<option value="8">Mode</option>
						<option value="9">High-Tech</option>
						<option value="10">Véhicules</option>
						<option value="11">Autres</option>
					</select>
				</div>
				<input id="nomArticle" name="nomArticle" type="text"
					class="form-control" aria-label="Saisie de mots clés"
					placeholder="le nom de l'article contient">
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit">Recherche</button>
				</div>
			</div>
			<br>
			<c:if test="${!empty userConnected}">
				<div class="container-fluid">
					<div class="row">
						<div class="col">
							<input type="hidden" id="userConnected" name="userConnected"
								value=${userConnected.noUtilisateur }>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="optionsRadios" id="optionsRadios1" value="achat" checked
									onclick="disableVenteRadios()"> <label
									class="form-check-label" for="optionsRadios1"> Achats </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="achatsEncheresOuvertes" id="inputCheckAchat1"
									name="achatsEncheresOuvertes"> <label
									class="form-check-label" for="flexCheckDefault">
									enchères ouvertes </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="achatsDejaEncherie" id="inputCheckAchat2"
									name="achatsDejaEncherie"> <label
									class="form-check-label" for="flexCheckDefault"> mes
									encheres </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="achatsEncheresGagnantes" id="inputCheckAchat3"
									name="achatsEncheresGagnantes"> <label
									class="form-check-label" for="flexCheckDefault"> mes
									encheres remportés </label>
							</div>
						</div>
						<div class="col">
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="optionsRadios" id="optionsRadios2" value="vente"
									onclick="disableAchatRadios()"> <label
									class="form-check-label" for="optionsRadios2"> Ventes </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="ventesEnCours" id="inputCheckVente1"
									name="ventesEnCours" disabled> <label
									class="form-check-label" for="flexCheckDefault"> mes
									ventes en cours </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="ventesNonCommences" id="inputCheckVente2"
									name="ventesNonCommences" disabled> <label
									class="form-check-label" for="flexCheckDefault"> ventes
									non débutées </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="ventesTerminees" id="inputCheckVente3"
									name="ventesTerminees" disabled> <label
									class="form-check-label" for="flexCheckDefault"> ventes
									terminées </label>
							</div>
						</div>
					</div>
				</div>
				<br>
			</c:if>
		</form>
	</div>
	<br>
	<c:if test="${empty listeArticleVendu}">
		<div class="container">
			<div class="card">
				<div class="card-header">Attention</div>
				<div class="card-body">
					<h5 class="card-title">Aucune enchere</h5>
					<p class="card-text">Aucune enchere ne correspond a vos
						criteres de recherches actuellement</p>
					<a href="<%=request.getContextPath()%>" class="btn btn-primary">Retour</a>
				</div>
			</div>
		</div>
	</c:if>

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
									href="<%=request.getContextPath() %>/detailsArticle?noArticle=${ArticleVendu.noArticle}"
									class="btn btn-primary">Voir l'enchère</a>
							</c:if>
						</div>
						<c:if test="${ArticleVendu.dateFinEncheres}>LocalDate.now" >
						</c:if>
						<div class="card-footer text-muted"><%-- ${ArticleVendu.tempRestant} a finir  --%></div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/html/piedDePage.html"%>
	<script type="text/javascript"
		src="vendor/javascript/disableCheckbox.js"></script>

</body>

</html>
