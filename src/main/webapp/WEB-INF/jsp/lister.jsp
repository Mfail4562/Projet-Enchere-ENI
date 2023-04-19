<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.List,fr.eni.mahm.projetencheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste utilisateur</title>
<%@ include file="/WEB-INF/html/link.html"%>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<h1 class="text-center">Liste utilisateur</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="row">#</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Email</th>
				<th scope="col">Telephone</th>
				<th scope="col">rue</th>
				<th scope="col">CodePostal</th>
				<th scope="col">Ville</th>
				<th scope="col">Credit</th>
				<th scope="col">Role</th>
				<th scope="col">action</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a class="btn btn-info" href="/ProjetEncheresENI/modifier"
					role="button">Modifier</a> <a class="btn btn-danger"
					href="/ProjetEncheresENI/supprimer" role="button">Supprimer</a></td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a class="btn btn-info" href="/ProjetEncheresENI/modifier"
					role="button">Modifier</a> <a class="btn btn-danger"
					href="/ProjetEncheresENI/supprimer" role="button">Supprimer</a></td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a class="btn btn-info" href="/ProjetEncheresENI/modifier"
					role="button">Modifier</a> <a class="btn btn-danger"
					href="/ProjetEncheresENI/supprimer" role="button">Supprimer</a></td>
			</tr>
			<tr>
				<th scope="row">4</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Mark</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td><a class="btn btn-info" href="/ProjetEncheresENI/modifier"
					role="button">Modifier</a> <a class="btn btn-danger"
					href="/ProjetEncheresENI/supprimer" role="button">Supprimer</a></td>
			</tr>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>