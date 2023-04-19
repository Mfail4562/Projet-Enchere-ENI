<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/html/link.html"%>
<title>vente</title>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<br>
	<h1 class="text-center">Nouvelle vente</h1>
	<div class="card-body px-4 py-5 px-md-5">
		<form class="needs-validation" action="VendreUnArticle" method="post" novalidate>
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Nom Article </label> <input type="text" name="nomArticle" class="form-control" required> <br>
					</div>
					<div class="invalid-feedback">Veuillez saisir un nom d'article</div>
					<label for="photoarticle">Choississez une photo pour l'article</label> 
					<input type="file" id="photoarticle" name="photoarticle" accept="image/png, image/jpeg">
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label style="vertical-align: top"> Description Article </label>
						<textarea rows="5" cols="20" name="descriptionArticle"
							class="form-control" maxlength="300"
							placeholder="Veuillez saisir au moins 10 caractères" required></textarea>
						<br>
					</div>
				</div>
				<div class="invalid-feedback">Veuillez saisir une description d'article</div>
			</div>
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label>Catégorie du produit</label> 
						<select name="categorie" id="categorie" class="form-control" required>
							<option value="">Choississez une catégorie</option>
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
					<div class="invalid-feedback">Veuillez saisir une categorie</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Mise à prix</label> 
						<input type="number"name="prixinitial" class="form-control" min="0" required>
						<br>
					</div>
					<div class="invalid-feedback">Veuillez saisir une description d'article</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Date de début d'enchères </label> 
						<input type="date" name="datedebutencheres" id="datefield" class="form-control" required> 
						<br>
					</div>
					<div class="invalid-feedback">Veuillez saisir un date de début d'enchères</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Date de fin d'enchères </label> 
						<input type="date" name="datefinencheres" class="form-control" required> 
						<br>
					</div>
					<div class="invalid-feedback">Veuillez saisir un date de fin d'enchères</div>
				</div>
			</div>
			<fieldset>
				<legend>Retrait</legend>
				<div class="row">
					<div class="col-md-6 mb-4">
						<div class="form-outline">

							<label for="rue">Rue </label> 
							<input type="text" name="rue" class="form-control" id="rue" value="${userConnected.getRue()}"
								required /> <br> <label for="cp">Code postal </label> <input
								type="number" name="codePostal" class="form-control" id="cp"
								value="${userConnected.getCodePostal()}" required />
						</div>
					</div>
					<br>
					<div class="col-md-6 mb-4">
						<div class="form-outline">
							<label for="ville">Ville </label> <input type="text" name="ville"
								class="form-control" id="ville"
								value="${userConnected.getVille()}" required />
						</div>
					</div>
				</div>

			</fieldset>
			<button type="submit" class="btn btn-primary btn-block mb-4"> Valider</button>
			<a type="button" class="btn btn-primary btn-block mb-4" href="#">Annuler </a>
		</form>
	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
<script type="text/javascript" src="vendor/javascript/checkConfirmationPassword.js"></script>
<script type="text/javascript" src="vendor/javascript/checkRequired.js"></script>
<style type="text/css"> .form-control { border-width: 1.5px;} </style>
</html>
