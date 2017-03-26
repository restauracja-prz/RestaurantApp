<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/menu" var="saveMenuUrl" />

<html>

<body>
<h1>Menu</h1>

<a href="<c:url value="/" />">Home</a><br />

	<fieldset>
		<form:form method="post" modelAttribute="menuForm" action="${saveMenuUrl}">
	  		Meal Id:
	  			<form:input type="text" path="mealId" />
	  			<form:errors path="mealId">Please enter meal id</form:errors>
	  				<br>
	  		Meal Description:
	  			<form:input type="text" path="mealTranslation.mealDescPl" />
	  			<form:errors path="mealTranslation.mealDescPl">Please enter meal description</form:errors>
	  				<br>
	  		Meal cost:
	  			<form:input type="number" path="mealTranslation.cost" />
	  			<form:errors path="mealTranslation.cost">Please enter meal cost</form:errors>
	  				<br>
	  			<input type="submit" value="Submit">
		</form:form> 
	</fieldset>
	
	<table>
	<td><b>Meal Id</b></td>
	<td><b>Meal Description</b></td>
	<td><b>Cost</b></td>
	<td><b>Is Visible</b></td>
		<c:forEach items="${menuItems}" var="menu">
			<tr>
				<td><c:out value="${menu.mealId}" /></td>
				<td><c:out value="${menu.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${menu.mealTranslation.cost}" /></td>
				<td><c:out value="${menu.isVisible}" /></td>
				<td><a href="<c:url value="/menu/enable/${menu.mealId}" />">Enable</a><br /></td>
				<td><a href="<c:url value="/menu/disable/${menu.mealId}" />">Disable</a><br /></td>				
			</tr>
		</c:forEach>
</table>
	
</body>

</html>