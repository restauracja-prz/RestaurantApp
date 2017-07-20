<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/order" var="saveOrderUrl"/>

<html>
<body>


	
		<a href="<c:url value="/" />">Home</a><br />
		
		<h1>Your order:</h1>
		
	<table>
		<tr>
			<td><b>Meal Id</b></td>
			<td><b>Meal Description PL</b></td>
			<td><b>Cost</b></td>
		</tr>
		
		<c:forEach items="${test}" var="ord">
		<tr>
				<td><c:out value="${ord.menuId}" /></td>
				<td><c:out value="${ord.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${ord.unitPrice}" /></td>
				<td><a href="<c:url value="/order/delete/${ord.menuId}" />">Delete</a><br /></td>
			</tr>
		</c:forEach>
		</table>
		<table>
		<tr>
			<td><b>Meal Id</b></td>
			<td><b>Meal Description PL</b></td>
			<td><b>Cost</b></td>
		</tr>
		
		<c:forEach items="${menuItems}" var="menu">
			<tr>
				<td><c:out value="${menu.menuId}" /></td>
				<td><c:out value="${menu.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${menu.unitPrice}" /></td>
				<td><a href="<c:url value="/order/ordermeal/${menu.menuId}" />">Add to order</a><br /></td>
			</tr>
		</c:forEach>
</table>

		

	
</body>
</html>
