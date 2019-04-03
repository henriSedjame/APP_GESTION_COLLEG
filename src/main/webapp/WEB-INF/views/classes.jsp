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
	
			<c:forEach items="${classes}" var="classe">
				
				<div class="alert alert-primary" role="alert">
				  <h3> Liste des élèves de la classe de <c:out value="${classe.niveau.label}" /></h3>
				</div>
				
				<table class="table table-striped">
				
					<thead>
						<tr>
							<th>NUMERO ELEVE</th>
							<th>NOM</th>
							<th>PRENOM</th>
							<th>VOIR LE PROFIL</th>		
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${eleves[classe]}" var="eleve">
							<tr>
								<td> <c:out value="${eleve.numEleve}"/></td>
								<td> <c:out value="${eleve.identite.nom}"/></td>
								<td> <c:out value="${eleve.identite.prenom}"/></td>
								<td> 
									<a href="profil_eleve_${eleve.numEleve}">
										<button type="button" class="btn btn-info ">
											<span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
											Profil
										</button>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				
				</table>
	
			</c:forEach>
			
		</div>
		
		<script src="resources/js/jquery-3.2.1.min.js"></script>
  		<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>