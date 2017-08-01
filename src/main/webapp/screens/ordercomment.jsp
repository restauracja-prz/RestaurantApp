<%@page contentType="radio/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/ordercomment" var="saveOrderCommentUrl" />

<html>
<head>
</head>
<body>
<a href="<c:url value="/" />">Home</a><br />

<h1>Ocena zamówienia numer ${order.orderId}</h1>

	<fieldset>
		<form:form method="post" modelAttribute="commentForm" action="/ordercomment">
  			<form:radiobutton path="serviceQuality" value="1"/>1
  			<form:radiobutton path="serviceQuality" value="2"/>2
  			<form:radiobutton path="serviceQuality" value="3"/>3
  			<form:radiobutton path="serviceQuality" value="4"/>4
  			<form:radiobutton path="serviceQuality" value="5"/>5
		</form:form> 
	</fieldset>
</body>
</html>