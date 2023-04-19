<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- zone non connecté -->
<c:if test="${empty userConnected}">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="/ProjetEncheresENI/accueil">ENI
				Encheres</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active"
						href="<%=request.getContextPath()%>">Encheres <span
							class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/login">Vendre un article</a></li>
				</ul>
				<form class="d-flex">
					<a class="btn btn-secondary m-2 my-sm-0"
						href="/ProjetEncheresENI/inscription" role="button">S'inscrire</a>

					<a class="btn btn-secondary m-2 my-sm-0"
						href="/ProjetEncheresENI/login" role="button">Se connecter</a>
				</form>
			</div>
		</div>
	</nav>
</c:if>

<!-- zone connecté  -->
<c:if test="${!empty userConnected}">
	<nav class="navbar navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="/ProjetEncheresENI/accueil">ENI
				Encheres</a>
			<ul class="navbar-nav me-auto list-inline">
				<div id="navbarColor01">
					<li class="nav-item list-inline-item me-5 ms-1"><a
						class="nav-link active" href="<%=request.getContextPath()%>">Encheres</a>
					</li>
					<li class="nav-item list-inline-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/VendreUnArticle">Vendre un
							article</a></li>
					<li class="nav-item list-inline-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/listeUtilisateur">Liste
							Utilisateur</a></li>
				</div>
			</ul>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-primary" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title text-light"
						id="offcanvasDarkNavbarLabel">${userConnected.pseudo}</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/ProjetEncheresENI/monCompte">Mon
								profil</a></li>
						<li class="nav-item">
							<p>Mon crédit : ${userConnected.credit}</p>
						</li>
						<li class="nav-item">nombre articles achetés : ${userConnected.articlesAchetes.size()}</li>


						<li class="nav-item">nombre articles vendus : ${userConnected.articlesVendus.size()}</li>
					</ul>

					<form action="logout" method="get" class="d-flex mt-3">
						<button class="btn btn-danger" type="submit">Déconnexion</button>
					</form>
				</div>
			</div>
		</div>
	</nav>
</c:if>
