<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Editer Pizza</title>
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
			<h1>page d'edition de pizzas</h1>
			<p>Bootstrap is the most popular pizza framework for developing
				responsive, mobile-first pizza on the web.</p>
		</div>

		<div class="container">
			<h2>Basic Table</h2>
			<p>The .table class adds basic styling (light padding and only
				horizontal dividers) to a table:</p>

			<%
				Pizza pizza = (Pizza) request.getAttribute("Pizza");
			%>
			<form class="form-horizontal" action="<%=request.getContextPath() %>/pizzas/editer"  method="post">
				<fieldset>

					<!-- Form Name -->
					<legend>Form Name</legend>
							<input id="code" name="anciencode" type="hidden" placeholder="<%=pizza.getCode()%>"  value="<%=pizza.getCode()%>" class="form-control input-md">
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Code</label>
						<div class="col-md-4">
							<input id="code" name="code" type="text"
								placeholder="<%=pizza.getCode()%>" class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Nom</label>
						<div class="col-md-4">
							<input id="nom" name="nom" type="text"
								placeholder="<%=pizza.getNom()%>" class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Prix</label>
						<div class="col-md-4">
							<input id="prix" name="prix" type="text"
								placeholder="<%=pizza.getPrix()%>"
								class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Catégorie</label>
						<div class="col-md-4">
							<input id="categorie" name="categorie" type="text"
								placeholder="<%=pizza.getCategorie()%>"
								class="form-control input-md"> <span class="help-block">VIANDE
								; SANS-VIANDE ; POISSON ; INDEFINI</span>
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="button"></label>
						<div class="col-md-4">
							<button id="button" name="button" class="btn btn-primary">Valider</button>
						</div>
					</div>

				</fieldset>
			</form>
















		</div>




	</div>

</body>
</html>
