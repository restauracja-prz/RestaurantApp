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
        <li><a id="menuManagementLink" href="<c:url value="/menu" />">Menu edit</a></li>
        <li><a id="orderLink" href="<c:url value="/order" />">Order</a></li>
        <li><a id="ordersLink" href="<c:url value="/ordersFiltered" />">Orders</a></li>
        <li><a id="reportsLink" href="<c:url value="/report" />">Reports</a></li>
        <li><a id="userManagementLink" href="<c:url value="/user" />">Users</a></li>
        <li><a id="orderDetailsLink" href="<c:url value="/orderdetails" />">Order details</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login.html"><span class="glyphicon glyphicon-log-out glyphicon-s"></span></a></li>
      </ul>
    </div>
  </div>
</nav>