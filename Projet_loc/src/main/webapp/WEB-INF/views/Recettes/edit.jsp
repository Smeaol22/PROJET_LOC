<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<!-- Autre manière de gérer la condition du titre que pour le produit. -->
		<h1>${not empty Recettes ? "Modifier une recette existante :" : "Créer une nouvelle recette :" }</h1>
		<c:url value="/Recettes/edit.html" var="postUrl" />
		 <form:form action="${postUrl}" method="post" modelAttribute="Recettes">
		 	<form:hidden path="ID"/>
		 	<div class="form-group">
		 		<label for="titre">Nom :</label>
		 		<form:input path="titre" id="titre" class="form-control" />
		 	</div>
		 	<div class="form-group">
		 		<label for="Recettes">recettes :</label>
		 		<form:input path="Recettes" id="Recettes" class="form-control" />
		 	</div>
		 	<div class="form-group">
		 		<label for="difficultes">difficultées :</label>
		 		<form:input type="number" path="difficultes" id="difficultes" class="form-control" min ="0" max="5" step="1"/>
		 	</div>
		 	
		 	<div class="form-group">
		 		<label for="types">types :</label>
		 		<form:input type="number" path="types" id="types" class="form-control" min ="1" max="3" step="1"/>
		 	</div>
		 	<div class="form-group">
		 		<label for="veg"> vegetarien :</label>
		 		<form:checkbox path="veg" id="veg" />
		 	</div>
		 	<button>Valider</button>
		 </form:form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>