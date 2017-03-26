<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/report/orders-and-status-report" var="showReportUrl" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order and status report</title>
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.min.css" />
	<script src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
	<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	
	<script>
	  $(function() {
	    $(".date-picker").datepicker();
	  });
	</script>
</head>

<body>

	<h3>Order and status report</h3>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    	<input type="submit" value="Logout" />
		</form:form>
	
		<a href="<c:url value="/" />">Home</a><br />
	
		<fieldset>
			<form:form method="post" modelAttribute="reportForm" action="${showReportUrl}">
		  		Choose date from:
		  			<form:input type="text" path="dateFrom" class="date-picker" />
		  			<form:errors path="dateFrom">Please enter date from</form:errors>
		  				<br>
		  		Choose date to:
		  			<form:input type="text" path="dateTo" class="date-picker" />
		  			<form:errors path="dateTo">Please enter date to</form:errors>
		  				<br>
		  			<input type="submit" value="Show report">
			</form:form> 
		</fieldset>

</body>

</html>