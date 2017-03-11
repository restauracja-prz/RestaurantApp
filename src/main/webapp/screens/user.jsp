<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/user" var="saveUserUrl" />

<html>
<body>
	<h2>RestaurantApp : </h2>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    <input type="submit" value="Logout" />
	</form:form>
	
	<a href="<c:url value="/" />">Home</a><br />

	<table>
		<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userRealName}" /></td>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.userPosition}" /></td>
				</tr>
		</c:forEach>
	</table>
	<br><br>
	
	
	<fieldset>
		<form:form method="post" modelAttribute="userForm" action="${saveUserUrl}">
	  		User name:<br>
	  			<form:input type="text" path="userRealName" />
	  				<br>
	  		User Login:<br>
	  			<form:input type="text" path="userId" />
	  				<br><br>
	  		User Password:<br>
	  			<form:input type="password" path="password" />
	  				<br><br>
	  		User position:<br>
	  			<form:input type="text" path="userPosition" />
	  				<br><br>
	  			<input type="submit" value="Submit">
		</form:form> 
	</fieldset>
</body>
</html>
