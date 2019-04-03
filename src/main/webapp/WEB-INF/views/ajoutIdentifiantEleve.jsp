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

			<form:form  modelAttribute="new_eleve_identifiant" action="classeForm" id="formulaire_ajout_eleve">
			
				<c:if test="${ !empty errors }">
					<div class="alert alert-danger " role="alert">
						<c:forEach items="${errors}" var ="error">
							<c:out value="${error.defaultMessage }"/>
						</c:forEach>
					</div>			
				</c:if>
			
				<div class="form-group" >
					<label for="login">LOGIN </label>
					<input type="text" name ="login" id ="login" placeholder ="Ajouter le login de l'elève" value="${ new_eleve_identifiant.login}" class="form-control"/>
					<form:errors path = "login" />
				</div>
				
				<div class="form-group" >
					<label for="motDePasse">MOT DE PASSE </label>
					<input type="text" name ="motDePasse" id ="motDePasse" placeholder ="Ajouter le mot de passe de l'elève" value="${new_eleve_identifiant.motDePasse}" class="form-control"/>
					<form:errors path = "motDePasse" />
				</div>

				<button type = "submit" class="btn btn-info">ENREGISTRER</button>				
			</form:form>
			
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>