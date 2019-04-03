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

			<form:form  modelAttribute="new_eleve_classe" action="eleveForm" id="formulaire_ajout_eleve">
			
				
				<div class="form-group" >
					<label for="niveau">CLASSE </label>
					<select name="niveau" id="niveau" required="required">
						<option value="" disabled="disabled" selected="selected">Choisissez une classe</option>
						<c:forEach items="${niveaux}" var="niv" >
							<option value="${niv}">${niv.label}</option>
						</c:forEach>
					</select>
				</div>
	
				<button type = "submit" class="btn btn-info">SUIVANT</button>				
			</form:form>
			
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>