<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
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
					<%
						List<Pizza> listPizzas = (List<Pizza>) request.getAttribute("listPizza");

						for (Pizza p : listPizzas) {
					%>
					<tr>
						<td><%=p.getCode()%></td>
						<td><%=p.getNom()%></td>
						<td><%=p.getNouveauPrix()%></td>
						<td><%=p.getCategorie()%></td>
						<td><a href="<%=request.getContextPath() %>/" class="btn btn-info" role="button">supprimer la Pizza</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		
		
		
		<a href="#" class="btn btn-info" role="button">supprimer la Pizza</a>
		
		
	</div>

</body>
</html>
