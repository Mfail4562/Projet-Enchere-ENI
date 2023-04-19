<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${article.nomArticle}</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<br>
	<h1 class="text-center">Details Article</h1>
	<form action="<%=request.getContextPath()%>/enchereEffectuee"
		method="post">
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Nom de l'article :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.nomArticle}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Description :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.description}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Categorie :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.categorie.libelle}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Offre initiale:</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.miseAPrix}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Meilleur Offre:</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.prixVente}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Date du début des encheres</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.dateDebutEncheres}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Date de fin des encheres</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.dateFinEncheres}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Etat de la vente :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.etatVente}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Adresse de Retrait</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${article.lieuRetrait}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card mb-4">
						<div class="card-body text-center">
							<img
								src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp"
								alt="avatar" class="rounded-circle img-fluid"
								style="width: 150px;">
							<p class="text-muted mb-1">${article.pseudo}</p>
							<div class="d-flex justify-content-center mb-2">
								<a type="button" class="btn btn-secondary my-2 my-sm-0"
									href="<%=request.getContextPath() %>/compteVendeur?id=${article.noVendeur}"
									role="button">Accedez au compte</a>
							</div>
						</div>
						<c:if test="${ article.noVendeur == userConnected.noUtilisateur}">
																
									<div class="d-flex justify-content-center mb-2">
									<a type="button" class="btn btn-secondary my-2 my-sm-0"
										href="/ProjetEncheresENI/modifierArticle" role="button">modifier Article</a>
									</div>
							
						</c:if>
					</div>
					<div class="card mb-5">
						<div class="card-body text-center">
							<div class="row">

								<div class="nav-item">
									<p>Mon crédit : ${userConnected.credit}</p>
								</div>
								<hr>
								<label class="mb-0" for="monEnchere">Ma proposition : </label> <br>
								<input class="text-center" type="number"
									value="${article.getPrixVente() }" id="monEnchere"
									name="monEnchere" /> <input type="submit"
									class="btn btn-secondary" value="Enchérir" />
							</div>

						</div>
					</div>
					<div>
						<div class="card-body text-center">
							<a class="btn btn-secondary m-2 my-sm-0"
								href="/ProjetEncheresENI/accueil" role="button">Retour</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>