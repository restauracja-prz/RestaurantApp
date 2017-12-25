
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<link rel="stylesheet" type="text/css" href="resources/test.css">
</head>

<body>
	<h2>RestaurantApp</h2>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    <input id="logoutButton" type="submit" value="Logout" />
	</form:form>
<!-- 
	<a id="menuManagementLink" href="<c:url value="/menu" />">Menu management</a><br />
	<a id="orderLink" href="<c:url value="/order" />">Order</a><br />
	<a id="ordersLink" href="<c:url value="/orders" />">Orders</a><br />
	<a id="reportsLink" href="<c:url value="/report" />">Reports</a><br />
	<a id="userManagementLink" href="<c:url value="/user" />">User management</a><br />
=======
	 -->
<div class="btn-group">
	<a id="menuManagementLink" href="<c:url value="/menu" />" class="button">Menu management</a>
	<a id="orderLink" href="<c:url value="/order" />" class="button">Order</a>
	<a id="ordersLink" href="<c:url value="/orderdetails/filtrByStatus" />" class="button">Orders</a>
	<a id="reportsLink" href="<c:url value="/report" />" class="button">Reports</a>
	<a id="userManagementLink" href="<c:url value="/user" />" class="button">User management</a>
	<a id="orderDetailsLink" href="<c:url value="/orderdetails" />" class="button">Order details</a>
	</div>
</body>
</html>
