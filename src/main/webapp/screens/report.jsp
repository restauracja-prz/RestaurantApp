<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.min.css" />
<script src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<html>
<body>
	<h2>RestaurantApp</h2>
	<h3>REPORTS</h3>
	
	<a href="<c:url value="/" />">Home</a><br />
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    <input type="submit" value="Logout" />
	</form:form>
	
	<h2>List of available reports:</h2><br />
	
	<a href="<c:url value="/report/orders-and-status-report" />">Orders and status report</a><br />
	<a href="<c:url value="/report/order-details-report" />">Order details report</a><br />
	<a href="<c:url value="/report/sales-report" />">Sales report</a><br />		

	
</body>
</html>
