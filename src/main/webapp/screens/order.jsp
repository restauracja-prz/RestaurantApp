<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<spring:url value="/order" var="saveOrderUrl"/>
<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- HEADER -->
    <header class="main">
      <div class="container">
          <div class="intro-text">Jedyna taka<br/>restauracja</div>
            <div><a class="btn btn-intro" href="#container-menu">ZAMÓW</a></div>
        </div>
    </header>


<!-- KONTENER MENU -->
  <div class="container" id="container-menu">
    <h2><p class="text-center">MENU</p></h2>
    
    <div class="btn-group btn-group-justified">
    	<c:set var="nofilter" value = "all"/>
    	<c:forEach items="${mealTypes}" var="type" varStatus="loop">
    		<a href="<c:url value="/order/filter/${type.mealTypePl}" />#container-menu" class="btn btn-menu">
    			<c:out value="${type.mealTypePl}"/>
    		</a>	
    			<c:if test = "${loop.count == 3}"></div><div class="btn-group btn-group-justified"></c:if>
    			<c:if test = "${loop.count == 6}"></div><div class="btn-group btn-group-justified"></c:if>
    	</c:forEach>
    </div>
 
      
    <ul class="list-group">
    	<c:forEach items="${menuItems}" var="menu">
    		<li class="list-group-item">
    			<c:out value="${menu.mealTranslation.mealDescPl}" />
            	<a class="btn btn-success pull-right" href="<c:url value="/order/ordermeal/${menu.menuId}" />#container-zamowienie">Dodaj</a>
            	<span class="label label-default label-margin-s"><c:out value="${menu.unitPrice}" /></span>
        	</li>
    	</c:forEach>
    </ul>
    
   </div>


<!-- KONTENER ZAMÓWIENIE -->
<div class="bg-1">
<div class="container" id="container-zamowienie">

	<c:if test = "${fn:length(orderList) == 0}">
		<h2><p class="text-center">Dodaj pozycję do zamówienia</p></h2>
	</c:if>
	
	<c:if test = "${fn:length(orderList) > 0}">
		<h2><p class="text-center">Twoje zamówienie</p></h2>
    	
    	<ul class="list-group">
    		<c:forEach items="${orderList}" var="ord" varStatus="loop">
    			<li class="list-group-item"><c:out value="${ord.mealTranslation.mealDescPl}" />
            		<a class="btn btn-danger pull-right" href="<c:url value="/order/delete/${loop.count}" />#container-zamowienie">Usuń</a>
            		<span class="label label-default label-margin-s"><c:out value="${ord.unitPrice}" /></span>
        		</li>
    		</c:forEach>
    	</ul>
    	<li class="list-group-item list-group-item-footer-bg-1">Suma
            <button class="btn btn-success btn-margin-m pull-right" type="submit" data-toggle="modal" data-target="#myModal">Zamów</button>
            <span class="pull-right"><c:out value="${sum}" /></span>
        </li>
    </c:if>
</div>
</div>
    
<!-- MODAL -->
<div class="bg-1">
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <div class="modal-content">
      <div class="modal-header">
        <h2><button class="btn close" data-dismiss="modal">&times;</button></h2>
        <h3 class="modal-title">Zamówienie</h3>
      </div>
      <div class="modal-body">
        <p>Czy na pewno chcesz złożyć zamówienie o wartości <c:out value="${sum}" />?</p>
      </div>
      <div class="modal-footer">
        <a class="btn btn-success" href="<c:url value="/order/submitorder" />">Złóż zamówienie</a>
        <button class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div>
    </div>

  </div>
</div>
</div>

    
<!-- KONTENER WEZWIJ KELNERA -->
<div class="bg-2">
<div class="container">
  <h2 class="text-center">Obsługa</h2>
      
        <div class="row">
            <div class="col-md-12">
                &nbsp;
            </div>
        </div>
    
        <div class="row">
            <div class="col-sm-6">
                    <p><span class="glyphicon glyphicon-map-marker"></span> Gdańsk, PL</p>
                    <p><span class="glyphicon glyphicon-phone"></span> +48 58 623 01 84</p>
                    <p><span class="glyphicon glyphicon-envelope"></span> restauracja.prz@gmail.com</p>
            </div>
            <div class="col-sm-6">
				<form action="/restaurant/order/callwaiter" method='get'>
					Zamówienie tradycyjne: <input type="submit" class="btn btn-success btn-margin-m" value="Wezwij kelnera" />
				</form>
            </div>
        </div>
</div>
</div>
		

<%@include file="/screens/footer.jsp"%>
