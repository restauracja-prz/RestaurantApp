<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/report/order-details-report" var="showReportUrl" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order details report</title>
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

	<h3>Order details report</h3>
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
			  			<input type="submit" value="Show report" name="action_show_report">
			  			<input type="submit" value="Export" name="action_export_report">
				</form:form> 
			</fieldset>

	<table>
		<tr>
			<td><b>Order Id</b></td>
			<td><b>Device Id</b></td>
			<td><b>Meal Id</b></td>
			<td><b>Unit Price</b></td>
			<td><b>Client Comment</b></td>
		</tr>
	
		<c:forEach items="${reportResult}" var="report">
				<tr>
					<td><c:out value="${report.orderId}" /></td>
					<td><c:out value="${report.deviceId}" /></td>
					<td><c:out value="${report.mealId}" /></td>
					<td><c:out value="${report.unitPrice}" /></td>
					<td><c:out value="${report.clientComment}" /></td>
				</tr>
		</c:forEach>
	</table>

</body>

</html>