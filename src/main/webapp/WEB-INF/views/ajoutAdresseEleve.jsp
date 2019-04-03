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

			<form:form  modelAttribute="new_eleve_adresse" action="identifiantForm" id="formulaire_ajout_eleve">

				<div class="form-group" >
					<label for="rue">RUE </label>
					<input type="text" name ="rue" id ="rue" placeholder ="Ajouter la rue de l'elève" required="required" value="" class="form-control"/>
					<form:errors path = "rue"/>
				</div>
				
				<div class="form-group" >
					<label for="codePostal">CODE POSTAL </label>
					<input type="text" name ="codePostal" id ="codePostal" placeholder ="Ajouter le code postal de l'elève" required="required" value="" class="form-control"/>
					<form:errors path = "codePostal"/>
				</div>
				
				<div class="form-group" >
					<label for="ville">VILLE </label>
					<input type="text" name ="ville" id ="ville" placeholder ="Ajouter la ville de l'elève" required="required" value="" class="form-control"/>
					<form:errors path = "ville"/>
				</div>
				
				<button type = "submit" class="btn btn-info">SUIVANT</button>				
			</form:form>
			
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>