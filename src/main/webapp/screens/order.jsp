<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<h2>RestaurantApp : Order</h2>
	<h3>TODO</h3>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	    <input id="logoutButton" type="submit" value="Logout" />
	</form:form>
	
	<a href="<c:url value="/" />">Home</a><br />
	
</body>
</html>
