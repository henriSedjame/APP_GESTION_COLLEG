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
			<h2>BONJOUR <c:out value="${prof.identite.civilite} ${nom } "/>, BIENVENUE VOTRE ESPACE PROFESSEUR</h2>
	
		</div>

		<script src="resources/js/jquery-3.2.1.min.js"></script>
	  	<script src="resources/js/bootstrap.min.js"></script>
	  	<script type="text/javascript" src="resources/js/espaceProf.js"></script>
	  	
	</body>
</html>