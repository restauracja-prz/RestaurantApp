<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<spring:url value="/ordercomment" var="saveOrderCommentUrl" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Oceń swoje zamówienie:</h1>
<c:out value="${order.orderId}"/>
<form:form method="GET" modelAttribute="commentForm"  action="${showOrderCommentUrl}">
W skali 1-5 oceń jakość przygotowanych potraw: <br>
<form:radiobutton path="mealQuality" name="mealQuality" value="1"/> 1 
<form:radiobutton path="mealQuality" name="mealQuality" value="2"/> 2 
<form:radiobutton path="mealQuality" name="mealQuality" value="3"/> 3 
<form:radiobutton path="mealQuality" name="mealQuality" value="4"/> 4 
<form:radiobutton path="mealQuality" name="mealQuality" value="5"/> 5 
<br><br>
W skali 1-5 oceń długość oczekiwania na zamówienie:<br>
<form:radiobutton path="serviceQuickness" name="serviceQuickness" value="1"/> 1 
<form:radiobutton path="serviceQuickness" name="serviceQuickness" value="2"/> 2 
<form:radiobutton path="serviceQuickness" name="serviceQuickness" value="3"/> 3 
<form:radiobutton path="serviceQuickness" name="serviceQuickness" value="4"/> 4 
<form:radiobutton path="serviceQuickness" name="serviceQuickness" value="5"/> 5 
<br><br>
W skali 1-5 oceń obsługę naszej restauracji: <br>
<form:radiobutton path="serviceQuality" name="serviceQuality" value="1"/> 1 
<form:radiobutton path="serviceQuality" name="serviceQuality" value="2"/> 2 
<form:radiobutton path="serviceQuality" name="serviceQuality" value="3"/> 3 
<form:radiobutton path="serviceQuality" name="serviceQuality" value="4"/> 4 
<form:radiobutton path="serviceQuality" name="serviceQuality" value="5"/> 5 
<br><br>
Napisz komentarz: <br>
<form:textarea path="clientComment" name="clientComment" rows="5" cols="30"></form:textarea><br><br>
<input type="submit" value="Dodaj ocenę">
</form:form>
</body>
</html>