<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<h1>Liste des recettes :</h1>
		<table id="RecettesTable" class="stripe selectable">
			<thead>
				<tr>
					<th>Id</th>
					<th>titre</th>
					<th>Recettes</th>
					<th>difficultes</th>
					<th>types</th>
					<th>veg</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/images" var="imgUrlPrefix" />
				<c:url value="/Recettes/edit" var="editUrlPrefix" />
				<c:url value="/Recettes/delete.html" var="deleteUrlPrefix" />
				<c:url value="/RecettesIngredients/" var="RecettesIngredientsUrl" />
				<c:forEach items="${RecettesList}" var="Recettes">
					<tr id="Recettes_${Recettes.ID}">
						<td>${Recettes.ID}</td>
						<td>${Recettes.titre}</td>
						<td>${Recettes.recettes}</td>
						<td>${Recettes.types}</td>
						<td>${Recettes.veg}</td>
						<td>
							<a href="${editUrlPrefix}/${Recettes.ID}.html">
								<img src="${imgUrlPrefix}/edit.png">
							</a>
							<a href="${RecettesIngredientsUrl}/edit.html?RecettesID=${Recettes.ID}">
								<img src="${imgUrlPrefix}/configure.png">
							</a>
							<a href="${deleteUrlPrefix}?id=${Recettes.ID}">
								<img src="${imgUrlPrefix}/delete.png">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="RecettesIngredientsDialog"></div>
	</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
		$("#RecettesTable").DataTable();
		$('#RecettesTable tbody tr').each(
			(index, line) => $(line).click(
				(event) => {
					var RecettesID = event.currentTarget.ID.split('_')[1];
					$("#RecettesIngredientsDialog").load('${RecettesIngredientsUrl}?RecettesID=' + RecettesID);
					$("#RecettesIngredientsDialog").dialog({
						width: '60%',
						maxWidth: 800
					});
				}));
	</script>
</body>
</html>