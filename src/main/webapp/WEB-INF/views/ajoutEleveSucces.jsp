<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/styles.css">
		<title>CONNEXION</title>
	</head>
	<body>
		
		<div id="bloc_page" >
			<h3>L'élève <c:out value="${new_eleve.identite.nom} ${new_eleve.identite.prenom}" /> a bien été ajouté </h3> 
			
			<h3> Les informations enregistreés sont les suivantes : </h3>
			
				<h4>Numero Eleve : </h4> 
				<c:out value="${new_eleve.numEleve}" />
			
				<h4>Civilité : </h4> 
				<c:out value="${new_eleve.identite.civilite.label}" />
				
				<h4>Date de naissance : </h4> 
				<c:out value="${new_eleve.identite.dateNaissance}" />
				
				<h4>Adresse : </h4> 
				<c:out value="${new_eleve.identite.adresse.rue} ${new_eleve.identite.adresse.codePostal} ${new_eleve.identite.adresse.ville}" />
				
				<h4>Classe : </h4>
				<c:out value="${new_eleve.classe.niveau.label}" />
		
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>