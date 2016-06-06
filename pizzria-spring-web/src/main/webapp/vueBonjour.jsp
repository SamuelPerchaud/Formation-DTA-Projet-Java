<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test de la vue</title>
</head>
<body>
	<h1>liste de pizzas</h1>


	<c:forEach items="${pizzas}" var="pizza">

		<!-- <a href="edit?id=${person.id}"> -->

${pizza.code} - ${pizza.nom} ${pizza.prix} ${pizza.categorie}



<br />

	</c:forEach>

			<form:form class="form-horizontal"   method="post">
				<fieldset>

					<!-- Form Name -->
					<legend>Form Name</legend>
							<input id="code" name="anciencode" type="hidden" placeholder="   "  value="   " class="form-control input-md">
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Code</label>
						<div class="col-md-4">
							<input id="code" name="code" type="text"
								placeholder="   " class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Nom</label>
						<div class="col-md-4">
							<input id="nom" name="nom" type="text"
								placeholder="   " class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Prix</label>
						<div class="col-md-4">
							<input id="prix" name="prix" type="text"
								placeholder="   "
								class="form-control input-md">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">Catégorie</label>
						<div class="col-md-4">
							<input id="categorie" name="categorie" type="text"
								placeholder="   >"
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
			</form:form>




</body>
</html>