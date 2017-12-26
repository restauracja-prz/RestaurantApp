<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<link rel="stylesheet" type="text/css" href="resources/order.css">
</head>

<html>
<body>
	<h2>RestaurantApp : Orders</h2>
	
	<%@include file="/screens/index.jsp"%>
	<form action="/restaurant/ordersFiltered" method='post'>
				 		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					    <select name="statusToFiltr" id="statusToFiltr">
					    <option value="DEFAULT"> - </option>
					    <option value="IN_PROGRESS"> IN_PROGRESS </option>
					    <option value="CANCEL"> CANCEL </option>
					    <option value="NEW"> NEW </option>
						<option value="CLOSED"> CLOSED </option>
					    </select>       
					
					    <input type="submit"/>
					</form>
					
					
		<table>
			<c:forEach items="${orders}" var="order">
				 <tr>
				 	<td><c:out value="${order.orderId}" /></td>
				 	<td><c:out value="${order.orderDate}" /></td>
				 	<td><c:out value="${order.orderStatus}" /></td>
				 	<td><c:out value="${order.userId}" /></td>
				 	<td><a href="<c:url value="/order/ordermeal/${menu.menuId}" />">Add to order</a><br /></td>
				 	<td><form action="/restaurant/orders/changeStatus/${order.orderId }" method='post'>
				 		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					    <select name="status" id="status">
					    <option value="IN_PROGRESS"> IN_PROGRESS </option>
					    <option value="CANCEL"> CANCEL </option>
					    <option value="NEW"> NEW </option>
						<option value="CLOSED"> CLOSED </option>
					    
					    </select>       
					
					    <input type="submit"/>
					</form>
					<br /></td>
					<c:if test = "${order.waiterNeed}">
						<td><c:out value="Kelnera wezwał: ${order.userId}" /></td>
					</c:if>
				 </tr>
			</c:forEach>
		</table>
	
</body>
</html>

