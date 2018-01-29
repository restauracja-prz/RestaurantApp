<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<spring:url value="/orderdetails" var="saveYourOrderUrl"/>
<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- KONTENER MENU -->
 <div class="container" id="container-menu">
     <h2>
       <p class="text-center">Twoje zamówienia
         <a href="#order-list" class="a-orderlist pull-right"><span class="glyphicon glyphicon-list"></span></a>
       </p>
     </h2>
     <br />

<c:forEach items="${orderNumbers}" var="x" varStatus="orderLoop">
	<c:if test = "${fn:length(orderNumbers) != 0}">
      
        <c:set var = "count" value="${0}"/>
		<c:set var = "sum" value="${0}"/>
		<c:set var = "lastOrderStatus" value="NEW"/>
		<c:forEach items="${orderItems}" var="orders" varStatus="loop">
			<c:if test = "${x == orders.order.orderId}">
				<c:set var="sum" value="${sum + orders.unitPrice}"/>
			</c:if>
		</c:forEach>

        <li class="list-group-item list-group-item-header-bg-0">
      		Zamówienie numer: ${x}
      	 <c:if test = "${sum != 0}">
      		<span class="pull-right">Suma: <c:out value="${sum}"/></span>
       	 </c:if>
        </li>
    <ul class="list-group">
   	 <c:choose>
    	<c:when test = "${sum == 0}">
   			<li class="list-group-item">
   				Twoje zamówienie przyjmiemy osobiście!<span class="btn btn-default pull-right">Obsługa kelnerska</span>
   			</li>
   		</c:when>
     	<c:otherwise>
    	 <c:forEach items="${orderItems}" var="orders" varStatus="loop">
		  <c:if test = "${x == orders.order.orderId}">
		 	<c:set var = "count" value="${count + 1}"/>
    	
        	<li class="list-group-item">
        		<c:out value="${orders.menu.mealTranslation.mealDescPl}" />
            	<c:if test = "${orders.order.orderStatus == 'NEW'}"><span class="btn btn-info pull-right">Nowe</span></c:if>
            	<c:if test = "${orders.order.orderStatus == 'IN_PROGRESS'}"><span class="btn btn-success pull-right">W przygotowaniu</span></c:if>
            	<c:if test = "${orders.order.orderStatus == 'CANCEL'}"><span class="btn btn-danger pull-right">Anulowane</span></c:if>
            	<c:if test = "${orders.order.orderStatus == 'DONE'}"><span class="btn btn-default pull-right">Gotowe</span></c:if>
            	<span class="label label-default label-margin-s"><c:out value="${orders.unitPrice}" /></span>
        	</li>
			<c:set var = "lastOrderStatus" value = "${orders.order.orderStatus}"/>

       	</c:if>
        </c:forEach>
       </c:otherwise>
     </c:choose>
    </ul>
    
    </c:if>
</c:forEach>
      
</div>


<!-- KONTENER ZAMÓWIENIE -->
<div class="bg-1">
<div class="container" id="order-list">
  <h2><p class="text-center">Podsumowanie twoich zamówień</p></h2>
  
  	<ul class="list-group">
  			<c:set var="waiter" value="${0}" />
  	<c:forEach items="${orderNumbers}" var="x" varStatus="orderLoop">
		<c:if test = "${fn:length(orderNumbers) != 0}">
			<c:set var = "sum" value="${0}"/>
			<c:set var = "lastOrderStatus" value="NEW"/>
			<c:forEach items="${orderItems}" var="orders" varStatus="loop">
				<c:if test = "${x == orders.order.orderId}">
					<c:set var="sum" value="${sum + orders.unitPrice}"/>
					<c:set var="status" value="${orders.order.orderStatus}" />
				</c:if>
			</c:forEach>
			
			<c:choose>
			 <c:when test = "${sum == 0}">
			 	<c:set var="waiter" value="${1}" />
			 	<li class="list-group-item">
			 		Zamówienie numer: ${x}<span class="btn btn-default pull-right">Obsługa kelnerska</span>
			 	</li>
			 </c:when>
			 <c:otherwise>
        		<li class="list-group-item">
        			Zamówienie numer: ${x}
        			<c:if test = "${status == 'NEW'}"><span class="btn btn-info pull-right">Nowe</span></c:if>
            		<c:if test = "${status == 'IN_PROGRESS'}"><span class="btn btn-success pull-right">W przygotowaniu</span></c:if>
            		<c:if test = "${status == 'CANCEL'}"><span class="btn btn-danger pull-right">Anulowane</span></c:if>
            		<c:if test = "${status == 'DONE'}"><span class="btn btn-default pull-right">Gotowe</span></c:if>
            		<span class="label label-default label-margin-s"><c:out value="${sum}"/></span>
        		</li>
        	 </c:otherwise>	
        	</c:choose>	
        		
		</c:if>
		<c:if test = "${status != 'CANCEL'}">
			<c:set var="total" value="${total + sum}"/>
		</c:if>
	</c:forEach>
  	</ul>
        		<li class="list-group-item list-group-item-footer-bg-1">
        			Suma całkowita: <span class="pull-right">
        			<c:if test = "${waiter == 1}">zamówienie u obsługi<c:if test = "${total > 0}"> + <c:out value="${total}"/></c:if></c:if>
        			<c:if test = "${waiter == 0}"><c:out value="${total}"/></c:if></span>
        		</li>
		
</div>
</div>


<%@include file="/screens/footer.jsp"%>
