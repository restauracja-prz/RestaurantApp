<!-- NAVBAR -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
      
      <c:if test="${currentUser.userPosition == 'admin'}">
        <li><a id="menuManagementLink" href="<c:url value="/menu" />">Edycja Menu</a></li>
      </c:if>
      <c:if test="${(currentUser.userPosition == 'admin') or (currentUser.userPosition == 'client')}">
        <li><a id="orderLink" href="<c:url value="/order" />">Zamów</a></li>
      </c:if>
      <c:if test="${(currentUser.userPosition == 'admin') or (currentUser.userPosition == 'kitchen')}">
        <li><a id="ordersLink" href="<c:url value="/ordersFiltered" />">Zamówienia</a></li>
      </c:if>
      <c:if test="${currentUser.userPosition == 'admin'}">
        <li><a id="reportsLink" href="<c:url value="/report" />">Raporty</a></li>
        <!-- <li><a id="userManagementLink" href="<c:url value="/user" />">Users</a></li> -->
      </c:if>
      <c:if test="${(currentUser.userPosition == 'admin') or (currentUser.userPosition == 'client')}">
        <li><a id="orderDetailsLink" href="<c:url value="/orderdetails" />">Twoje Zamówienia</a></li>
      </c:if>
      </ul>
     <!--  
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
        		<button class="btn-link btn-logout" id="logoutButton" type="submit" /><span class="glyphicon glyphicon-log-out glyphicon-s"></span></button>
        	</form:form>   
        </li>
      </ul>
      -->
    </div>
  </div>
</nav>





	    
	