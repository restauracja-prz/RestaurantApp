<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- KONTENER MENU -->
  <div class="container" id="container-menu">
    <h2><p class="text-center">Raporty</p></h2>
      
    <ul class="list-group">
        <li class="list-group-item">Raport Zamówień i Statusów
            <a class="btn btn-primary pull-right" href="<c:url value="/report/orders-and-status-report" />">Wybierz</a>
        </li>
        <li class="list-group-item">Raport Szczegółów Zamówień
            <a class="btn btn-primary pull-right" href="<c:url value="/report/order-details-report" />">Wybierz</a>
        </li>
        <li class="list-group-item">Raport Sprzedaży
            <a class="btn btn-primary pull-right" href="<c:url value="/report/sales-report" />">Wybierz</a>
        </li> 
    </ul>
  </div>
  
	
<%@include file="/screens/footer.jsp"%>
