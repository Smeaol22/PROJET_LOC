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
			<c:url value="/images" var="imgUrlPrefix" />
			<c:url value="/MenuDuJour/delete.html" var="deleteUrlPrefix" />
			<c:forEach items="${menuDuJourList}" var="menuDujour">
					<tr>
						<td>${menuDujour.id}</td>
						<td>${menuDujour.titre}</td>
						<td>${menuDujour.recettes}</td>
						<td>${menuDujour.difficultes}</td>
						<td>${menuDujour.types}</td>
						<td>${menuDujour.veg}</td>
					</tr>
					<td>
						<a href="${deleteUrlPrefix}?id=${menuDujour.id}">
								<img src="${imgUrlPrefix}/delete.png">
						</a>
						<a href="MenuDuJour/add.html">
								<img src="${imgUrlPrefix}/configure.png">
						</a>
						<a href="MenuDuJour/update.html">
								<img src="${imgUrlPrefix}/configure.png">
						</a>
					</td>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<script type="text/javascript">$("#MenuDuJourTable").DataTable();</script>
</body>
</html>