<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>

</head>

<script src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<html>
<body>
	<%@include file="/screens/index_old.jsp"%>
	<br><br><br>

	
	<h2>List of available reports:</h2><br />
	
	<a href="<c:url value="/report/orders-and-status-report" />">Orders and status report</a><br />
	<a href="<c:url value="/report/order-details-report" />">Order details report</a><br />
	<a href="<c:url value="/report/sales-report" />">Sales report</a><br />		

	
</body>
</html>
