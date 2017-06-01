<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="utf-8">
<link rel="icon" href="turkey3.png">
<title>Les Recettes</title>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
<c:url value="/css" var="appCssUrl" />
<c:url value="/images" var="appImgUrl" />
<c:url value="/RecettesDuJour/" var="menuUrl" />
<link rel="stylesheet" href="${appCssUrl}/accueilStyle.css">

</head>
	<header class="top">
		<div class="Titre">
			<h1>Ho Purée !</h1>
			<h2>Qu'est-ce qu'on mange ?</h2>
		</div>
		<div class="imgLog">
			<a href="#"><img class="log" src="${appImgUrl}/inconnu.png" alt="inc"
				width="100"></a>
		</div>
	</header>
<body>
	<div class="container">
		<h1>Menudujour :</h1>
		<table id="MenuDuJourTable" class="stripe selectable">
			<thead>
				<tr>
					<th>Id</th>
					<th>titre</th>
					<th>recettes</th>
					<th>difficultes</th>
					<th>types</th>
					<th>vegetarien</th>
				</tr>
			</thead>
			<tbody>


				<c:url value="/MenuDuJour/" var="MenuDuJourUrl" />
				<c:forEach items="${menuDuJourList}" var="menuDuJour">
					<tr id="Recettes_${Recettes.id}">
						<td>${Recettes.id}</td>
						<td>${Recettes.titre}</td>
						<td>${Recettes.recettes}</td>
						<td>${Recettes.difficultes}</td>
						<td>${Recettes.types}</td>
						<td>${Recettes.veg}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<script type="text/javascript">
		$("#RecettesTable").DataTable();
		$('#RecettesTable tbody tr').each(
			(index, line) => $(line).click(
				(event) => {
					var RecettesId = event.currentTarget.id.split('_')[1];);
				}));
	</script>
</body>
</html>