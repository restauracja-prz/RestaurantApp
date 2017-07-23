<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<spring:url value="/order" var="saveOrderUrl"/>

<html>
<body>


	
		<a href="<c:url value="/" />">Home</a><br />
		
		
<fieldset><legend><h1>Twoje zamowienie</h1></legend>
		<c:if test = "${fn:length(orderList) == 0}">
		<p>Dodaj potrawe do zamowienia</p>
		</c:if>
		
	
		<c:if test = "${fn:length(orderList) > 0}">
			

	<table>
		<tr>
			<td><b>Numer</b></td>
			<td><b>MenuId</b></td>
			<td><b>Meal</b></td>
			<td><b>Cost</b></td>
		</tr>
		
		<c:forEach items="${orderList}" var="ord" varStatus="loop">
		<tr>
				<td><c:out value="${loop.count}" />    </td>
				<td><c:out value="${ord.menuId}" /></td>
				<td><c:out value="${ord.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${ord.unitPrice}" /></td>
				<td><a href="<c:url value="/order/delete/${loop.count}" />">Delete</a><br /></td>
			</tr>
		</c:forEach>
		<tr>
		<td></td>
		<td></td>
		<td align="right"><b>Suma: </b></td>
		<td><c:out value="${sum}" /> </td>
		</tr>
		</table>

		<a href="<c:url value="/order/submitorder" />">Submit order</a>

		
		</c:if>
</fieldset>
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
