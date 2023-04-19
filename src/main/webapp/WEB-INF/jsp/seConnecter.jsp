<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Page de connexion</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image" />
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
				<br>
				<h3 class="text-center">Connectez vous ou <a href="/ProjetEncheresENI/inscription" role="button">creez un compte</a></h3>
				<br>
					<%
					if (request.getAttribute("alert alert-danger") != null) {
					%>  
					         
					<div class="alert alert-danger">
						<strong class="icon-remove-sign"> <%=request.getAttribute("alert alert-danger")%>
						</strong>
					</div>
					<%
					}
					%>
					<form action="login" method="post">
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" id="form3Example3" name="login"
								value="${cookie.lastLogin.value}"
								class="form-control form-control-lg"
								placeholder="Pseudo / Adresse email" required />
						</div>
						<!-- Password input -->
						<div class="form-outline mb-3">
							<input type="password" id="form3Example4" name="password"
								class="form-control form-control-lg"
								placeholder="Entrer votre mot de passe" required />
						</div>
						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox"
									name="sesouvenirdemoi" value="coche" id="form2Example3" />
								<label class="form-check-label" for="form2Example3"> Se
									souvenir de moi </label>
									
							</div>
							<a href="/ProjetEncheresENI/inscription" class="text-body">Mot de passe oublié</a>
						</div>
						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								
									
							</div>
							<a href="/ProjetEncheresENI/inscription" class="text-body">Nouveau compte ?</a>
						</div>
						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-md"
								style="padding-left: 2.5rem; padding-right: 2.5rem">
								Login</button>
							<a class="btn btn-warning my-2 my-sm-0"
								href="/ProjetEncheresENI/login" role="button">annuler</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>
