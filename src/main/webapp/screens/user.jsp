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
		<tr>
			<td><b>Name</b></td>
			<td><b>Login</b></td>
			<td><b>Password</b></td>
			<td><b>Position</b></td>
			<td><b>Is Enabled</b></td>
		</tr>
	
		<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userRealName}" /></td>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.userPosition}" /></td>
					<td><c:out value="${user.isEnabled}" /></td>
					<td><a href="<c:url value="/user/disable/${user.userId}" />">Disable</a><br /></td>
					<td><a href="<c:url value="/user/enable/${user.userId}" />">Enable</a><br /></td>
				</tr>
		</c:forEach>
	</table>
	<br><br>
	
	
	<fieldset>
		<form:form method="post" modelAttribute="userForm" action="${saveUserUrl}">
	  		User name:
	  			<form:input type="text" path="userRealName" />
	  			<form:errors path="userRealName">Please enter User Name</form:errors>
	  				<br>
	  		User Login:
	  			<form:input type="text" path="userId" />
	  			<form:errors path="userId">Please enter user id</form:errors>
	  				<br>
	  		User Password:
	  			<form:input type="password" path="password" />
	  			<form:errors path="userId">Please enter user password</form:errors>
	  				<br>
	  		User position:
	  			<form:input type="text" path="userPosition" />
	  			<form:errors path="userId">Please enter user position</form:errors>
	  				<br>
	  			<input type="submit" value="Submit">
		</form:form> 
	</fieldset>
</body>
</html>
