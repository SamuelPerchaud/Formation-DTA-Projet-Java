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
			<form class="form-horizontal" method="post">
				<fieldset>

					<!-- Form Name -->
					<legend>Form Name</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Login</label>
						<div class="col-md-4">
							<input id="textinput" name="login" type="text"
								placeholder="placeholder" class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">password</label>
						<div class="col-md-4">
							<input id="textinput" name="password" type="text"
								placeholder="placeholder" class="form-control input-md">

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
