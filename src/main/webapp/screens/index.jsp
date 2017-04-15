
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<h2>RestaurantApp</h2>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    <input type="submit" value="Logout" />
	</form:form>

	<a href="<c:url value="/menu" />">Menu management</a><br />
	<a href="<c:url value="/order" />">Order</a><br />
	<a href="<c:url value="/orders" />">Orders</a><br />		
	<a href="<c:url value="/report" />">Reports</a><br />
	<a href="<c:url value="/user" />">User management</a><br />
</body>
</html>
