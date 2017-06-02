<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<h1>Liste des produits :</h1>
		<table id="IngredientsTable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Unités</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/images" var="imgUrlPrefix" />
				<c:url value="/Ingredients/edit" var="editUrlPrefix" />
				<c:url value="/Ingredients/delete.html" var="deleteUrlPrefix" />
				<c:forEach items="${IngredientsList}" var="Ingredients">
					<tr>
						<td>${Ingredients.id}</td>
						<td>${Ingredients.noms}</td>
						<td>${Ingredients.unit}</td>
						<td><a href="${editUrlPrefix}/${Ingredients.id}.html"> <img
								src="${imgUrlPrefix}/edit.png">
						</a> <a href="${deleteUrlPrefix}?id=${Ingredients.id}"> <img
								src="${imgUrlPrefix}/delete.png">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../footer.jsp" />
	</div>
	<script type="text/javascript">
		$("#IngredientsTable").DataTable();
	</script>
</body>
</html>