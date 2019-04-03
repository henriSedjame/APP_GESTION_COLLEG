/**
 * 
 */

var saisieLogin = document.getElementById("login");
var saisieMdp = document.getElementById("password");


/* RECUPERER LES COOKIES DE LA PAGE SOUS FORME DE TABLEAU */
var cookies = document.cookie;
var reg = new RegExp("[ =;]");
var tabCookies = cookies.split(reg);

/* AJOUTER UN ECOUTEUR D'EVENEMENT LORS DE LA SAISIE DU LOGIN POUR GENERER AUTOMATIQUEMENT LE MOT DE PASSE ASSOCIE */
saisieLogin.addEventListener("input", function(){
	var login = saisieLogin.value;
	
	tabCookies.forEach(function(cookie){
		if(cookie === login){
			saisieMdp.value = tabCookies[tabCookies.indexOf(login)+1];
		};
	});
}, false);

