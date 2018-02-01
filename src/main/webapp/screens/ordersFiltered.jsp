<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- KONTENER MENU -->
  <div class="container" id="container-menu">
      
      <form action="/restaurant/ordersFiltered" method='post'>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      
      <h2>
        <p class="text-center">Wyświetl zamówienia
          <button class="btn-orderlist pull-right" name="statusToFiltr" id="statusToFiltr" value="DEFAULT"><span class="glyphicon glyphicon-menu-hamburger"></span></button>
        </p>
      </h2>
      
      <div class="btn-group btn-group-justified" role="group">
        <div class="btn-group" role="group"><button class="btn btn-menu" name="statusToFiltr" id="statusToFiltr" value="CANCEL">Anulowane</button></div>
        <div class="btn-group" role="group"><button class="btn btn-menu" name="statusToFiltr" id="statusToFiltr" value="CLOSED">Zamknięte</button></div>
        <div class="btn-group" role="group"><button class="btn btn-menu" name="statusToFiltr" id="statusToFiltr" value="DONE">Gotowe</button></div>
    </div>
      <div class="btn-group btn-group-justified" role="group">
        <div class="btn-group" role="group"><button class="btn btn-menu" name="statusToFiltr" id="statusToFiltr" value="NEW">Nowe</button></div>
        <div class="btn-group" role="group"><button class="btn btn-menu" name="statusToFiltr" id="statusToFiltr" value="IN_PROGRESS">W przygotowaniu</button></div>
    </div>
   </form>
   <br />

   <c:forEach items="${ord}" var="ord">
     
    <c:if test = "${ord.waiterNeed}"> 
    
    <li class="list-group-item list-group-item-header-bg-0">Numer: ${ord.orderId}</li>
    <ul class="list-group">
        <li class="list-group-item">
        	Kelnera wezwał 
        	<span class="btn btn-default btn-margin-s pull-right">Wezwanie kelnera</span>
        	<a class="btn btn-success pull-right" href="<c:url value="/order/changeStatus/${ord.orderId}" />">OK</a>
        	<span class="label label-default label-margin-s"><c:out value="${ord.userId}" /></span>
        </li>
    </ul>
	</c:if>
	
    <c:if test = "${fn:length(ord.orderDetails) != 0}">

       <c:forEach items="${ord.orderDetails}" var="orders"></c:forEach>
       
       <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
       	<li class="list-group-item list-group-item-header-bg-0">Zamówienie numer: ${ord.orderId}
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button class="btn btn-cancel pull-right" name="status" id="status" value="CANCEL"><span class="glyphicon glyphicon-remove"></span></button>
		</li>
		</form>
      
      	<c:choose>
      	 
      	 <c:when test = "${ord.orderStatus == 'NEW'}">
      	  <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      	 	
      	 	<div class="btn-group btn-group-justified" role="group">
      	 	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="IN_PROGRESS">W przygotowaniu</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="DONE">Gotowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="CLOSED">Zamknięte</button></div>
        	</div>
      	 	
      	  </form>	
      	 </c:when>
      	 
      	 <c:when test = "${ord.orderStatus == 'IN_PROGRESS'}">
      	  <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      	 
      	 	<div class="btn-group btn-group-justified" role="group">
      	 	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="NEW">Nowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="DONE">Gotowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="CLOSED">Zamknięte</button></div>
        	</div>
      	 	
      	  </form>
      	 </c:when>
      	 
      	 <c:when test = "${ord.orderStatus == 'DONE'}">
      	  <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      	 	
      	 	<div class="btn-group btn-group-justified" role="group">
      	 	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="NEW">Nowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="IN_PROGRESS">W przygotowaniu</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="CLOSED">Zamknięte</button></div>
        	</div>
      	 	
      	  </form>
      	 </c:when>
      	 
      	 <c:when test = "${ord.orderStatus == 'CLOSED'}">
      	  <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      	 
      	 	<div class="btn-group btn-group-justified" role="group">
      	 	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="NEW">Nowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="IN_PROGRESS">W przygotowaniu</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="DONE">Gotowe</button></div>
        	</div>
      	 	
      	  </form>	
      	 </c:when>
      	 
      	 <c:when test = "${ord.orderStatus == 'CANCEL'}">
      	  <form action="/restaurant/orders/changeStatus/${ord.orderId }" method='post'>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      	 
      	 	<div class="btn-group btn-group-justified" role="group">
      	 	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="IN_PROGRESS">W przygotowaniu</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="DONE">Gotowe</button></div>
        	 <div class="btn-group" role="group"><button class="btn btn-menu" name="status" id="status" value="CLOSED">Zamknięte</button></div>
        	</div>
      	 	
      	  </form>	
      	 </c:when>
      	 
      	</c:choose>
      
    <ul class="list-group">
    
    	<c:forEach items="${ord.orderDetails}" var="orders">
    
        	<li class="list-group-item">
        		<c:out value="${orders.menu.mealTranslation.mealDescPl}" />
            	<c:if test = "${ord.orderStatus == 'NEW'}"><span class="btn btn-info pull-right">Nowe</span></c:if>
            	<c:if test = "${ord.orderStatus == 'IN_PROGRESS'}"><span class="btn btn-success pull-right">W przygotowaniu</span></c:if>
            	<c:if test = "${ord.orderStatus == 'CANCEL'}"><span class="btn btn-danger pull-right">Anulowane</span></c:if>
            	<c:if test = "${ord.orderStatus == 'DONE'}"><span class="btn btn-default pull-right">Gotowe</span></c:if>
            	<c:if test = "${ord.orderStatus == 'CLOSED'}"><span class="btn btn-default pull-right">Zamknięte</span></c:if>
            	<span class="label label-default label-margin-s"><c:out value="${orders.unitPrice}" /></span>
        	</li>
        
        </c:forEach>
        
    </ul>
    <br />
    
   </c:if>
  </c:forEach>
      
  </div>


<%@include file="/screens/footer.jsp"%>
