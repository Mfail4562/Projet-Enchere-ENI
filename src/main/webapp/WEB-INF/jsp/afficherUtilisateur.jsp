<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,fr.eni.mahm.projetencheres.bo.ArticleVendu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Vendeur</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<section>
		<br>
		<h1 class="text-center">Utilisateur</h1>
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-4">
						<div class="card-body text-center">
							<img
								src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp"
								alt="avatar" class="rounded-circle img-fluid"
								style="width: 150px" />
							<h5 class="my-3">${utilisateur.pseudo }</h5>
							<p class="text-muted mb-1">${utilisateur.nom} ${utilisateur.prenom}</p>
							<p class="text-muted mb-4">Credit : ${utilisateur.credit}</p>
							<div class="d-flex justify-content-center mb-2"></div>
						</div>
					</div>
				</div>
				<div>
					<div class="card-body text-center">
						<a class="btn btn-secondary m-2 my-sm-0"
							href="/ProjetEncheresENI/accueil" role="button">Retour</a>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Pseudo :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.pseudo}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">nom :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.nom}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Prénom :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.prenom}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Email :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.email}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Téléphone :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.telephone}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Rue :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.rue}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Code postal :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.codePostal}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Ville :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${utilisateur.ville}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>
