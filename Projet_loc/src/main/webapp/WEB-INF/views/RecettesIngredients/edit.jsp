<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<c:url value="/images" var="imgUrlPrefix" />
	<c:url value="/RecettesIngredients/edit" var="urlPrefix" />
	<div class="container">
		<h1>Configurer les ingrédients :</h1>
		<table id="RecettesIngredientsTable">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Quantité</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${RecettesIngredientsList}" var="RecettesIngredients">
					<tr>
						<td>${RecettesIngredients.Ingredients.name}</td>
						<td>${RecettesIngredients.quantity}</td>
						<td><a href="${urlPrefix}/remove.html?IngredientsID=${RecettesIngredients.Ingredients.ID}"> <img
								src="${imgUrlPrefix}/delete.png">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<form action="${urlPrefix}/add.html" method="get" class="form-inline">
							<div class="form-group">
								<label for="RecettesIngredientsSelect">Ingrédient :</label> <select
									name="IngredientsId" id="RecettesIngredientsSelect">
									<c:forEach items="${IngredientsList}" var="Ingredients">
										<option value="${Ingredients.ID}">${Ingredients.noms}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="quantity">Quantité : </label> <input type="number"
									id="quantity" name="quantity" value="0">
							</div>
							<button>Ajouter</button>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
		<button onclick="window.location='${urlPrefix}/validate.html'">Valider</button>
	</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
		$("#RecettesIngredientsTable").DataTable();
		$("#RecettesIngredientsSelect").selectmenu();
	</script>
</body>
</html>