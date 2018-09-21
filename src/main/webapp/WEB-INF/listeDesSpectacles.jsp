<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Les spectacles</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

	<div class="w3-container">
		<p>
			<a href="accueil">Accueil</a>
		</p>
		<h1>Liste des Spectacles</h1>


		<form method="post" action="affinerListe">
			<p>
				<label>Catégories</label> <select name="categoryTitle">
					<option value="${selected}" selected>${selected}</option>
					<c:forEach items="${categories}" var="category">
						<c:if test="${category != selected}">
							<option value="${category.title}" >${category.title}</option>
						</c:if>
					</c:forEach>
				</select> <label>Date</label> <input type="date" name="date" /> <input class="w3-button w3-black" type="submit" value="Affiner la liste">
			</p>
		</form>


		<c:choose>
			<c:when test="${not empty spectacles}">
				<table class="w3-table-all w3-centered">
					<!-- here should go some titles... -->

					<tr class="w3-red">
						<th>Title</th>
						<th>Description</th>
						<th>Duration</th>
						<th>Price</th>
						<th>Number of Places</th>
						<th>Sessions</th>
					</tr>

					<c:forEach items="${spectacles}" var="spectacle">
						<tr>
							<td><c:out value="${spectacle.title}" /></td>
							<td><c:out value="${spectacle.description}" /></td>
							<td><c:out value="${spectacle.duration} mn" /></td>
							<td><c:out value="${spectacle.price} euros" /></td>
							<td><c:out value="${spectacle.nbPlaces}" /></td>
							<td><a href="sessions?id=${spectacle.id}">Voir les sessions</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<p style="color: red;">Aucun spectacle trouvé.</p>
			</c:otherwise>
		</c:choose>



	</div>

</body>
</html>
