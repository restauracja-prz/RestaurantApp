<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<h2>RestaurantApp : Orders</h2>

	<a href="<c:url value="/" />">Home</a>
	<br />
	<form action="/restaurant/orderdetails/filtrByStatus" method='post'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <select name="statusToFiltr"
			id="statusToFiltr">
			<option value="DEFAULT"> - </option>
			<option value="IN_PROGRESS"> IN_PROGRESS </option>
			<option value="CANCEL"> CANCEL </option>
			<option value="NEW"> NEW </option>
			<option value="CLOSED"> CLOSED </option>
		</select> <input type="submit" />
	</form>
	<table>
		<c:forEach items="${ord}" var="ord">
			<tr>
				<td><c:out value="Dane dla zamowienia ${ord.orderId}" /></td>
			<tr>
			<tr>
				<th><b>Pozycja</b></th>
				<th><b>Meal</b></th>
				<th><b>Unit Price</b></th>
				<th><b>Status</b></th>
			</tr>


			<c:set var="count" value="${0}" />
			<c:forEach items="${ord.orderDetails}" var="orders">

				<c:set var="count" value="${count + 1}" />
				<tr>
					<td><c:out value="${count}" /></td>
					<td><c:out value="${orders.menu.mealTranslation.mealDescPl}" /></td>
					<td><c:out value="${orders.unitPrice}" /></td>
					<td><c:out value="${ord.orderStatus}" /></td>
					<td><c:out value="${ord.orderId}" /></td>
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
					<c:if test="${ord.waiterNeed}">
						<td><c:out value="Kelnera wezwał: ${ord.userId}" /></td>
					</c:if>
					<!-- <td><form action="/restaurant/orders/changeStatus/${orders.order.orderId}" method='post'>
				 		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					    <select name="status" id="status">
					    <option value="IN_PROGRESS"> IN_PROGRESS </option>
					    <option value="CANCEL"> CANCEL </option>
					    <option value="NEW"> NEW </option>
						<option value="CLOSED"> CLOSED </option>
					    
					    </select>       
					
					    <input type="submit"/>
					</form>
			<br /></td> -->
				</tr>
			</c:forEach>
		</c:forEach>

	</table>

	<!-- <table>
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
				 </tr>
			</c:forEach>
		</table>-->

</body>
</html>
