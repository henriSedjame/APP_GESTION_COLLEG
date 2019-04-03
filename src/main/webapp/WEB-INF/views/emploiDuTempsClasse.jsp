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
	
			<div class="dropdown">
			  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Selectionnez une classe
			  <span class="caret"></span></button>
			  <ul class="dropdown-menu">
			    <c:forEach items="${classes}" var="classe">
					<li><a href="emploi_du_temps_${classe.id }"> <c:out value = "${classe.niveau.label}" /></a></li>
				</c:forEach>
			  </ul>
			</div>
				
			<h2>EMPLOI DU TEMPS DE LA CLASSE DE <c:out value="${classe.niveau.label }"/> </h2>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>JOUR</th>
						<th>DEBUT</th>
						<th>FIN</th>
						<th>CLASSE</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${planningClasse }" var="cours">
						<tr>
							<td><c:out value="${cours.heureCours.jour.label }"/> </td>
							<td><c:out value="${cours.heureCours.heureDebut} "/> </td>
							<td><c:out value="${cours.heureCours.heureFin} "/> </td>
							<td><c:out value="${cours.classe.niveau.label} "/> </td>
						</tr>
					</c:forEach>
				</tbody>
	
			</table>
			
		</div>
		
		<script src="resources/js/jquery-3.2.1.min.js"></script>
  		<script src="resources/js/bootstrap.min.js"></script>
  		<script type="text/javascript" src="resources/js/espaceProf.js"></script>
</body>
</html>