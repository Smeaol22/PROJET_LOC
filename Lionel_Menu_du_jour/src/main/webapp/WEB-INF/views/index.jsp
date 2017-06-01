<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
<body>
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

	<div class="FirstPart">
		<div class="RecetteDuJour">
			<h2>Recette du jour</h2>
			<div class="imgRecdj">
				<a href="MenuDuJour/" ><img class="recdj" src="${appImgUrl}/eating.jpg"></a>
			</div>
		
			<div>
				<p>Truite sauce au beurre et brocollis - Une recette alliant
					simplicité, fraîcheur, et gourmandise.</p>
			</div>
		</div>
		<div class="IngredientsDuJour">
			<ul>
				<li><a href="#">Tomate</a></li>
				<li><a href="#">Saumon</a></li>
				<li><a href="#">Prune</a></li>
				<li><a href="#">Citron</a></li>
				<li><a href="#">Oignon</a></li>
				<li><a href="#">Cerise</a></li>
				<li><a href="#">Coriandre</a></li>
				<li><a href="#">Semoule</a></li>
			</ul>
			<ul>
				<li><a href="#">Aubergine</a></li>
				<li><a href="#">Roquefort</a></li>
				<li><a href="#">Escalope de poulet</a></li>
				<li><a href="#">Basilic</a></li>
				<li><a href="#">Yaourt</a></li>
				<li><a href="#">Cancoillotte</a></li>
				<li><a href="#">Grenade</a></li>
				<li><a href="#">Poivre</a></li>
			</ul>
			<ul>
				<li><a href="#">Crème fraiche</a></li>
				<li><a href="#">Amandes</a></li>
				<li><a href="#">Carottes</a></li>
				<li><a href="#">Boeuf</a></li>
				<li><a href="#">Mouton</a></li>
				<li><a href="#">Tagliatelle</a></li>
				<li><a href="#">Courgette</a></li>
				<li><a href="#">Poivron</a></li>
			</ul>
		</div>
	</div>
	<div class="SecondPart">
		<h2>Choisissez une option...</h2>
		<div class="options">
			<ul>
				<li><a href="#"><img class="Entree" src="${appImgUrl}/entree.jpg"
						width="80"></a></li>
				<li><h3>Entrée</h3></li>
			</ul>
			<ul>
				<li><a href="#"><img class="plat" src="${appImgUrl}/plat.jpg"
						width="80"></a></li>
				<li><h3>Plat</h3></li>
			</ul>
			<ul>
				<li><a href="#"><img class="dessert" src="${appImgUrl}/dessert.jpg"
						width="80"></a></li>
				<li><h3>Dessert</h3></li>
			</ul>
		</div>
	</div>
	<div class="ThirdPart">
		<h2>...ou renseignez directement des ingrédients</h2>
		<form method="post" action="envoi.php">
			<div class="ChampDeRecherche">
				<p>
					<label for="ingredient1">Ingrédients :</label> <input type="text"
						id="ingredient1" value="" placeholder="..." />
				</p>

				<p>
					<label for="ingredient2"> </label> <input type="text"
						id="ingredient2" value="" placeholder="..." />
				</p>

				<p>
					<label for="ingredient3"> </label> <input type="text"
						id="ingredient3" value="" placeholder="..." />
				</p>

				<p>
					<label for="ingredient4"> </label> <input type="tel"
						id="ingredient4" value="" placeholder="..." />
				</p>
			</div>
			<div class="submit right">
				<p>
					<input type="submit" value="Envoyer" />
			</div>
		</form>
	</div>



</body>


</html>