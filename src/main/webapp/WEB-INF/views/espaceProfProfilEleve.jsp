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
		<title>ESPACE_PROF</title>
	</head>
	<body>
	
		<div id="bloc_page" >
			
			<c:import url="menu.jsp"></c:import>
	
			<h2>PROFIL ELEVE</h2>
			
			<h3>CIVILITE</h3> <c:out value="${eleve.identite.civilite }"/>
			<h3>NOM</h3> <c:out value="${eleve.identite.nom }"/>
			<h3>PRENOM</h3> <c:out value="${eleve.identite.prenom }"/>
			<h3>DATE DE NAISSANCE</h3> <c:out value="${eleve.identite.dateNaissance }"/>
			<h3>ADRESSE</h3> <c:out value="${eleve.identite.adresse.rue } ${eleve.identite.adresse.codePostal } ${eleve.identite.adresse.ville }"/>
			
		</div>
		
		<script src="resources/js/jquery-3.2.1.min.js"></script>
  		<script src="resources/js/bootstrap.min.js"></script>
  		<script type="text/javascript" src="resources/js/espaceProf.js"></script>
</body>
</html>