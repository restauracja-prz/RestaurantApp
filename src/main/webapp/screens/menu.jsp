<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<body>
<h1>Menu</h1>

<a href="<c:url value="/" />">Home</a><br />

<table>
	<c:forEach items="${menuItems}" var="menu">
		<tr>
			<td><c:out value="${menu.mealId}" /></td>
			<td><c:out value="${menu.mealTranslation.mealDescPl}" /></td>
			<td><c:out value="${menu.mealTranslation.cost}" /></td>
		</tr>
	</c:forEach>
</table>
</body>

</html>