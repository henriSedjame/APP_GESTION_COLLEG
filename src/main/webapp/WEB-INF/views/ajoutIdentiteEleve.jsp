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
		<title>AJOUT_NOUVEL_ELEVE</title>
	</head>
	<body>
		
		<div id="bloc_page" >

			<form:form  modelAttribute="new_eleve_identite" action="adresseForm" id="formulaire_ajout_eleve">
			
				<c:if test="${ !empty errors }">
					<div class="alert alert-danger " role="alert">
						<c:forEach items="${errors}" var ="error">
							<c:out value="${error.defaultMessage }"/>
						</c:forEach>
					</div>	
					
				</c:if>	
				
			
				<div class="form-group" >
					<label for="civilite">CIVILITE </label>
					<select name="civilite" id="civilite" required="required" >
						<option value="" disabled="disabled" selected="selected">Choisissez une civilite</option>
	
						<c:forEach items="${civilites}" var="civ" >
							
							<option value="${civ}" >${civ.label}</option>
						</c:forEach>
					</select>
					<form:errors path = "civilite"/>
				</div>
					
				<div class="form-group" >
					<label for="nom">NOM </label>
					<input type="text" name ="nom" id ="nom" placeholder ="Ajouter le nom de l'elève" required ="required" value="${new_eleve_identite.nom}" class="form-control"/>
					<form:errors path = "nom" class="erreur"/>
				</div>
				
				<div class="form-group" >
					<label for="prenom">PRENOM </label>
					<input type="text" name ="prenom" id ="prenom" placeholder ="Ajouter le prenom de l'elève" required ="required" value="${new_eleve_identite.prenom}" class="form-control"/>
					<form:errors path = "prenom" class="erreur"/>
				</div>
				
				<div class="form-group" >
					<label for="dateNaissance">DATE DE NAISSANCE </label>
					<input type="date" name ="dateNaissance" id ="dateNaissance" placeholder ="Ajouter le date de Naissance de l'elève" required ="required" value="${new_eleve_identite.dateNaissance}" class="form-control"/>
					<form:errors path = "dateNaissance" class="erreur"/>
				</div>
				
				<button type = "submit" class="btn btn-info">SUIVANT</button>

						
			</form:form>

			
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>