<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<!-- Test de la présence d'un produit dans le Model pour savoir si c'est de la création ou modification -->
			<c:choose>
				<c:when test="${not empty Ingredients}">
					<h1>Modifier un ingredients existant :</h1>
				</c:when>
				<c:otherwise>
					<h1>Créer un nouveau ingredient :</h1>
				</c:otherwise>
			</c:choose>
		<form action="<c:url value="/Ingredients/edit.html" />" method="post">
			<c:if test="${not empty Ingredients}">
				<input type="hidden" name="id" value="${Ingredients.id}">			
			</c:if>
			<div class="form-group">
				<label for="noms">Nom :</label>
				<input class="form-control" id="noms" name="noms"
					value="${not empty Ingredients ? Ingredients.noms : '' }">
			</div>
			<div class="form-group">
				<label for="Unit">Unités :</label>
				<input class="form-control" id="Unit" name="Unit"
					value="${not empty Ingredients ? Ingredients.Unit : '' }">
			</div>
			<button>Valider</button>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>