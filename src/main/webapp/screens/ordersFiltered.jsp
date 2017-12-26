<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
<link rel="stylesheet" type="text/css" href="resources/order.css">
</head>

<html>
<body>
	<%@include file="/screens/index.jsp"%>
	<br><br><br>
		
	<form action="/restaurant/ordersFiltered" method='post'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <select name="statusToFiltr"
			id="statusToFiltr">
			<option value="DEFAULT"> - </option>
			<option value="IN_PROGRESS"> IN PROGRESS </option>
			<option value="CANCEL"> CANCEL </option>
			<option value="NEW"> NEW </option>
			<option value="CLOSED"> CLOSED </option>
		</select> <input type="submit" />
	</form>
	<table>
	
		<c:forEach items="${ord}" var="ord">
		<fieldset><legend><h2>Zamowienie numer: ${ord.orderId}</h2></legend>
			<table>

			<c:if test = "${ord.waiterNeed}"> <c:out value="Kelnera wezwał: ${ord.userId}" />
			   <a href="<c:url value="/order/changeStatus/${ord.orderId}" />">Change status</a><br />
			</c:if>
			<c:if test = "${fn:length(ord.orderDetails) != 0}">
			<tr>
				<th><b>Pozycja</b></th>
				<th><b>Meal</b></th>
				<th><b>Unit Price</b></th>
				<th><b>Status</b></th>
				<th><b>Opcje</b></th>
			</tr>
			</c:if>




			<c:set var="count" value="${0}" />
			
			<c:forEach items="${ord.orderDetails}" var="orders">

				<c:set var="count" value="${count + 1}" />
				
				<tr>
					<td><c:out value="${count}" /></td>
					<td><c:out value="${orders.menu.mealTranslation.mealDescPl}" /></td>
					<td><c:out value="${orders.unitPrice}" /></td>
					<td><c:out value="${ord.orderStatus}" /> </td>
					<td><form
							action="/restaurant/orders/changeStatus/${ord.orderId }"
							method='post'>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <select name="status" id="status">
								<option value="IN_PROGRESS"> IN_PROGRESS </option>
								<option value="CANCEL"> CANCEL </option>
								<option value="NEW"> NEW </option>
								<option value="CLOSED"> CLOSED </option>

							</select> <input type="submit" />
						</form> <br /></td>
					
					
				</tr>
				
			</c:forEach>
			</table>
			</fieldset>
		</c:forEach>

	</table>

</body>
</html>
