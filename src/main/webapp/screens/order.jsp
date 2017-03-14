<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<h2>RestaurantApp : Orders</h2>
	
	<a href="<c:url value="/" />">Home</a><br />
	
		<table>
			<c:forEach items="${orderStatus}" var="order">
				 <tr>
				 	<td><c:out value="${order.orderId}" /></td>
				 	<td><c:out value="${order.orderDate}" /></td>
				 	<td><c:out value="${order.orderStatus}" /></td>
				 	<td><c:out value="${order.userId}" /></td>
				 </tr>
			</c:forEach>
		</table>
	
</body>
</html>
