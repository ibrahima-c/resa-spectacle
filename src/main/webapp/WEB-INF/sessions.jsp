<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Les sessions</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

	<div class="w3-container">
	<p>
			<a href="accueil">Accueil</a><br/>
			<a href="listeDesSpectacles">Page précédente</a>
		</p>
		<h1>Liste des Sessions trouvées</h1>

		<c:choose>
			<c:when test="${not empty sessions}">
				<table class="w3-table-all w3-centered">
					<!-- here should go some titles... -->

					<tr class="w3-red">
						<th>Date</th>
						<th>Start Time</th>
						<th>Remaining Places</th>
					</tr>

					<c:forEach items="${sessions}" var="session">
						<tr>
							<td><c:out value="${session.date}" /></td>
							<td><c:out value="${session.startTime}" /></td>
							<td><c:out value="${session.nbRemainingPlaces}" /></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
				<p style="color: red;">Aucune session n'est trouvée.</p>
			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>
