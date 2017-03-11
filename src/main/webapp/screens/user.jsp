<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
				<td><c:out value="${user.id}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
