<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<spring:url value="/orderdetails" var="saveYourOrderUrl" />

<head>
<link rel="stylesheet" type="text/css" href="resources/order.css">
</head>

<html>
<body>	

	<%@include file="/screens/index.jsp"%>
	<br>
	<br>
	<br>

<h1>Twoje aktywne zamowienia:</h1>
<c:forEach items="${orderNumbers}" var="x" varStatus="orderLoop">		
	
	<c:if test = "${fn:length(orderNumbers) != 0}">
	<c:set var = "count" value="${0}"/>
<fieldset><legend><h2>Zamowienie numer: ${x}</h2></legend>
		<table>
		<tr>
			<th><b>Pozycja</b></th>
			<th><b>Meal</b></th>
			<th><b>Unit Price</b></th>
			<th><b>Status</b></th>
		</tr>
		<c:set var = "count" value="${0}"/>
		<c:set var = "sum" value="${0}"/>
		<c:set var = "lastOrderStatus" value="NEW"/>
		
		<c:forEach items="${orderItems}" var="orders" varStatus="loop">
			
			<c:if test = "${x == orders.order.orderId}">
			<c:set var = "count" value="${count + 1}"/>
			<tr>
				<td><c:out value="${count}"/></td>
				<td><c:out value="${orders.menu.mealTranslation.mealDescPl}" /></td>
				<td><c:out value="${orders.unitPrice}" /></td>
				<td><c:out value="${orders.order.orderStatus}"/></td>
			</tr>
				<c:set var="sum" value="${sum + orders.unitPrice}"/>
				<c:set var = "lastOrderStatus" value = "${orders.order.orderStatus}"/>
		<c:if test="${orders.order.waiterNeed}">
			<c:out value="Kelnera wezwał: ${orders.order.userId}" />
		</c:if>
			</c:if>
		
		</c:forEach>
		
			<tr>
				<td></td>
				<td align="right"><b>Suma:</b></td>
				<td><c:out value="${sum}"/></td>
			</tr>
	</table>
<c:if test="${lastOrderStatus == 'SERVICED' }">
	<a href="<c:url value="/ordercomment/${orderNumbers[orderLoop.index]}"/>">Oceń zamówienie</a>
</c:if>
</fieldset>
</c:if>
</c:forEach>

<p>*Gdy kelner dostarczy zamówione przez Ciebie potrawy do stolika, będziesz miał mozliwość oceny swojego zamówienia.</p>

</body>
</html>
