<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<h1>Créer une nouvelle recettes:</h1>
	<div class="container">
	<form:form action="#" method="post" modelAttribute="newMenuDuJour">
		<div class="form-group">
			<label for=titre>titre:</label>	
			<form:input path="titre" id="titre" class="form-control"/>
		</div>
		<div class="form-group">
			<label for=recettes>recettes:</label>	
			<form:input path="recettes" id="recettes" class="form-control"/>
		</div>
		<div class="form-group">
			<label for=difficultes>difficultes:</label>	
			<form:input type="number" step="1" max="5" min="1" path="difficultes" id="difficultes" class="form-control"/>
		</div>
		<div class="form-group">
			<label for=types>types:</label>	
			<form:input type="number" step="1" max="3" min="1" path="types" id="types" class="form-control"/>
		</div>
		<div class="form-group">
			<label for=veg>Vegetarien:</label>
			<form:checkbox path="veg" id=" veg "/>
		</div>
		<button>Valider</button>
	</form:form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>