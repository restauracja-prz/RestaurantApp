<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/menu" var="saveMenuUrl" />

<html>

<head>
<link rel="stylesheet" type="text/css" href="resources/order.css">
</head>

<body>

<%@include file="/screens/index.jsp"%>

<br>
<br>


<h1>Menu</h1>

	<fieldset>
		<form:form method="post" modelAttribute="menuForm" action="${saveMenuUrl}">
	  		Meal Id:
  			<form:input type="text" path="menuId" readonly="true" cssStyle="background-color: #d1d1d1;" />
  			<form:errors path="menuId">Please enter meal id</form:errors>
  			<br>
  			
	  		Meal Description PL:
  			<form:input type="text" path="mealTranslation.mealDescPl" />
  			<form:errors path="mealTranslation.mealDescPl">Please enter meal description</form:errors>
  			<br>
  			
  			Meal Description EN:
  			<form:input type="text" path="mealTranslation.mealDescEn" />
  			<form:errors path="mealTranslation.mealDescEn">Please enter meal description</form:errors>
  			<br>
  			
	  		Meal cost:
  			<form:input type="text" path="unitPrice" />
  			<form:errors path="unitPrice">Please enter meal cost</form:errors>
			<br>
  			
  			<form:input type="hidden" path="isVisible" />
  			<input type="submit" value="Submit">
  			<c:if test="${menuForm.menuId != null}">
  				<a href="<c:url value="/menu/cancelEdit" />">Cancel edit</a>
  			</c:if>
		</form:form> 
	</fieldset>
	
	<table cellspacing="0" cellpadding="0">
		<tr>
			<th><b>Meal Id</b></th>
			<th><b>Meal Description PL</b></th>
			<th><b>Meal Description EN</b></th>
			<th><b>Cost</b></th>
			<th><b>Is Visible</b></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${menuItems}" var="menu">
			<tr>
				<td><c:out value="${menu.menuId}" /></td>
				<td><c:out value="${menu.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${menu.mealTranslation.mealDescEn}" /></td>
				<td><c:out value="${menu.unitPrice}" /></td>
				<td><c:out value="${menu.isVisible}" /></td>
				<td><a href="<c:url value="/menu/enable/${menu.menuId}" />">Enable</a><br /></td>
				<td><a href="<c:url value="/menu/disable/${menu.menuId}" />">Disable</a><br /></td>
				<td><a href="<c:url value="/menu/edit/${menu.menuId}" />">Edit</a><br /></td>
			</tr>
		</c:forEach>
</table>
	
</body>

</html>