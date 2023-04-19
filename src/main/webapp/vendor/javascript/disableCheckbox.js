/**
function appelé quand un utilisateur click sur le radio Achat, ce qui permet de disable et donc rendre
inaccesible les balises liées a la vente
ici la fonction passe l'attribut disable a false quand ce sont des checkbox liées a l'achat et a true quand
ce sont des balise lié a la vente 
La fonction est appelé via le parametre onClick =""
 */
function disableVenteRadios() {
	
	document.getElementById("inputCheckVente1").disabled = true;
	document.getElementById("inputCheckVente2").disabled = true;
	document.getElementById("inputCheckVente3").disabled = true;
	//passages des input a false
	document.getElementById("inputCheckAchat1").disabled = false;
	document.getElementById("inputCheckAchat2").disabled = false;
	document.getElementById("inputCheckAchat3").disabled = false;
}
/**
function appelé quand un utilisateur click sur le radio Vente, ce qui permet de disable et donc rendre
inaccesible les balises liées a l'Achat
ici la fonction passe l'attribut disable a false quand ce sont des checkbox liées a la vente et a true quand
ce sont des balise lié a l'achat
La fonction est appelé via le parametre onClick =""
 */
function disableAchatRadios() {

	document.getElementById("inputCheckAchat1").disabled = true;
	document.getElementById("inputCheckAchat2").disabled = true;
	document.getElementById("inputCheckAchat3").disabled = true;
	////passages des input a false
	document.getElementById("inputCheckVente1").disabled = false;
	document.getElementById("inputCheckVente2").disabled = false;
	document.getElementById("inputCheckVente3").disabled = false;
}


	
	