<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/html/link.html"%>
<meta charset="UTF-8" />
<title>Détail enchere</title>
</head>
<body style="background-color: #eee;">
	<%@include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<h1>Détail de l'enchère</h1>
	<form action="<%=request.getContextPath()%>/enchereEffectuee"
		method="post">
		<h2>${article.getNomArticle()}</h2>
		<label for="description">description : </label>
		<textarea rows="3" cols="20" id="description">{article.getDescription()}</textarea>
		<br /> <label for="categorie">categorie : </label> <input type="text"
			id="categorie" value="${article.getCategorie().getLibelle()}" /> <br />
		<label for="meilleureEnchere">Meilleure offre :</label> <input
			type="text" value="${article.getPrixVente() }" id="meilleureEnchere" />
		<br /> <label for="prixDepart">Mise à prix : </label> <input
			type="text" value="${article.getMiseAPrix() }" id="prixDepart" /> <br />
		<label for="fin">Fin de l'enchère : </label> <input type="text"
			value="${article.getDateFinEncheres() }" id="fin" /> <br /> <label
			for="retrait">Lieu de retrait : </label> <input type="text"
			value="${article.getLieuRetrait().getRue() }" id="retrait" /> <br />
		<input type="text"
			value="${article.getLieuRetrait().getCodePostal() } ${article.getLieuRetrait().getVille()}"
			id="retrait" /> <br /> <label for="vendeur">Vendeur : </label> <input
			type="text" value="${article.pseudo }" id="vendeur" /> <br /> <label
			for="monEnchere">Ma proposition : </label> <input type="number"
			value="${article.getPrixVente() }" id="monEnchere" name="monEnchere" />
		<br /> <input type="submit" class="btn btn-secondary"
			value="Enchérir" />
	</form>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>
