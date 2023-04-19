<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/html/link.html"%>
<title>Réinitialisez votre mot de passe</title>
</head>
<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
<body>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image" />
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1"></div>
				<form method="post" action="reinitialisermdp">
					<label> Veuillez saisir votre adresse mail </label> <input
						type="email" name="email" required>
					<button type="submit" class="btn btn-primary btn-block mb-4">
						Valider</button>
				</form>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>