<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<spring:url value="/ordercomment" var="saveOrderCommentUrl" />
<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- KONTENER MENU -->
  <div class="container" id="container-menu">
      <h2><p class="text-center">Oceń zamówienie</p></h2>
      
      <c:out value="${order.orderId}"/>
      
    <form:form method="GET" modelAttribute="commentForm"  action="${showOrderCommentUrl}">
      
      <ul class="list-group">
          <li class="list-group-item">Jakość przygotowanych potraw<br/>
			<form:radiobuttons path="mealQuality" name="mealQuality" items="${numberList}"  />
        </li>
        <li class="list-group-item">Czas oczekiwania na zamówienie<br/>
			<form:radiobuttons path="serviceQuickness" name="serviceQuickness" items="${numberList}"  />
        </li>
        <li class="list-group-item">Obsługa w restauracji<br/>
			<form:radiobuttons path="serviceQuality" name="serviceQuality" items="${numberList}"  />
        </li>
        <li class="list-group-item">Pozostaw komentarz&nbsp;
            <form:textarea path="clientComment" name="clientComment" type="text" rows="2" class="form-control input-lg"></form:textarea>
        </li> 
       </ul>
        <li class="list-group-item list-group-item-footer-bg-0">
                <input type="submit" class="btn btn-success pull-right" value="Dodaj ocenę"/>
            </li>
      
    </form:form>
      
    </div>


<%@include file="/screens/footer.jsp"%>