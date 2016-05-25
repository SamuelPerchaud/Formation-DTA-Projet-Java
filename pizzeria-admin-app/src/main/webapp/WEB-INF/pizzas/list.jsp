<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Liste des pizzas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>PIZZZZZA ! ! !</h1>
			<p>Bootstrap is the most popular pizza framework for developing
				responsive, mobile-first pizza on the web.</p>
		</div>

		<div class="container">
			<h2>Basic Table</h2>
			<p>The .table class adds basic styling (light padding and only
				horizontal dividers) to a table:</p>
			<table class="table">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>catégorie</th>
					</tr>
				</thead>


				<tbody>


					<c:forEach var="pizza" items="${listPizza}">
						<tr id="tr-${pizza}">

							<td>${pizza.code}</td>
							<td>${pizza.nom}</td>
							<td>${pizza.prix}</td>
							<td>${pizza.categorie}</td>
							<td></td>
							<td><a href="<c:url value='/pizzas/editer?code=${pizza.code}' />">editer</a></td>
							<td></td>
					</c:forEach>




				</tbody>
			</table>
		</div>




	</div>

</body>
</html>
