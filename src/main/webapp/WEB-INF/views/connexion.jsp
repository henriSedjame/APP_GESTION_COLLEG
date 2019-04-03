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

			<form:form modelAttribute="identifiant" action="espace_utilisateur" id ="formulaire_connexion">
				
				<c:if test="${ !empty errorIdentifiant }">
					<div class="alert alert-danger " role="alert">	
						<c:out value="${errorIdentifiant.defaultMessage }"/>		
					</div>	
					
				</c:if>	
			
				<div class="form-group" >
					<label for ="login">LOGIN </label>
					<form:input path = "login" type="text" name ="login" id ="login" placeholder ="Enter your login" value="" class="form-control"/>
				</div>
	
				<div class="form-group">
					<label for ="password">PASSWORD </label>
					<form:input path = "motDePasse" type="password" name ="password" id ="password" placeholder ="Enter your password" value="" class="form-control"/>	
				</div>
				
				<div id="pied_formulaire_connexion" >
					<button type = "submit" class="btn btn-info">LOG IN</button>
					<div>
						Se souvenir de moi...
			    		<input type="checkbox" name="memoire" id="memoire">
					</div>
				</div>	
			
			</form:form>
			
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	  		<script type="text/javascript" src="resources/js/connexion.js"></script>
	</body>
	
</html>