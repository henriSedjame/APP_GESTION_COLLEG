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
		<title>ERROR</title>
	</head>
<body>
	
	<div id="bloc_page">
		
		<div class="alert alert-danger" role="alert">
		  <h5><strong>Le formulaire que vous avez soumis contient une erreur de type </strong>: <c:out value="${erreurType}"/></h5>
		</div>
		
		<div class="alert alert-danger" role="alert">
			<h5> <strong>Message d'erreur :</strong> <c:out value="${erreurMessage}"></c:out></h5>
		</div>
	</div>
	
</body>
</html>