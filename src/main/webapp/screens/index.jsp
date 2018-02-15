
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- HEADER -->
    <header class="main">
      <div class="container">
          <div class="intro-text">Jedyna taka<br/>restauracja</div>
            <div><a class="btn btn-intro" href="<c:url value="/order#container-menu" />">ZAMÓW</a></div>
        </div>
    </header>	

<%@include file="/screens/footer.jsp"%>
