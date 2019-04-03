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
		
			<form:form  modelAttribute="new_eleve" action="resultAjoutEleve" id="formulaire_ajout_eleve">
				<c:if test="${ !empty errors }">
					<div class="alert alert-danger " role="alert">
						<c:forEach items="${errors}" var ="error">
							<c:out value="${error.defaultMessage }"/>
						</c:forEach>
					</div>			
				</c:if>
			
				<div class="form-group" >
					<form:label path="numEleve">NUMERO ELEVE</form:label>
					<form:input path = "numEleve" type="text" name ="numEleve" id ="numEleve" placeholder ="Ajouter numero Eleve de l'elève" required="required" value="" class="form-control"/>
					<form:errors path = "numEleve"/>		
				</div>
				
				<button type = "submit" class="btn btn-info">FINALISER L'AJOUT DE L'ELEVE</button>				
			</form:form>
	
		</div>
			
			<script src="resources/js/jquery-3.2.1.min.js"></script>
	  		<script src="resources/js/bootstrap.min.js"></script>
	</body>
	
</html>