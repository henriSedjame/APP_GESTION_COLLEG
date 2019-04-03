<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="menu">

	
	<div id="avatar">
		<span class="glyphicon glyphicon-user icon-size" ></span>
		<div id="av">
			<div id="identite_user"><c:out value="${sessionScope.nom } ${sessionScope.prenom }"></c:out></div>
			<div> <a href="profil">Voir Profil</a></div>
		</div>
		
	</div>
	
	
	<nav >
		<ul class="nav navbar-nav" >
		  <li class=""><a href="emploi_du_temps">EMPLOI DU TEMPS</a></li>
		  <li><a href="classes">CLASSES</a></li>
		  <li><a href="cours">COURS</a></li>
		  
		</ul>
	</nav>
	
	<div id="bouton_deconnexion">
			<a href="deconnexion"><button  class="btn btn-primary">SE DECONNECTER</button></a>
	</div>
</div>
