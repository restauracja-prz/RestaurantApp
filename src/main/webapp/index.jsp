<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<h2>RestaurantApp</h2>

	<a href="<c:url value="/admin" />">Admin</a><br />
	<a href="<c:url value="/user" />">Uzytkownicy</a>
</body>
</html>
