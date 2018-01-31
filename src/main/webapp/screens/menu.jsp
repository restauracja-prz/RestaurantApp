<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/menu" var="saveMenuUrl" />
<%@include file="/screens/header.jsp"%>
<%@include file="/screens/navbar.jsp"%>


<!-- KONTENER MENU -->
  <div class="container" id="container-menu">
    <h2><p class="text-center">Edycja menu</p></h2>
      
    <ul class="list-group">
        <c:forEach items="${menuItems}" var="menu">
        	<li class="list-group-item" id="menuid-<c:out value="${menu.menuId}" />"><c:out value="${menu.mealTranslation.mealDescPl}" />
           	 <a class="btn btn-primary btn-margin-s pull-right" href="<c:url value="/menu/edit/${menu.menuId}" />#container-edit"><span class="glyphicon glyphicon-cog"></a>
           	 <a class="btn btn-danger btn-margin-s pull-right" href="<c:url value="/menu/disable/${menu.menuId}" />">Off</a>
           	 <a class="btn btn-success btn-margin-s pull-right" href="<c:url value="/menu/enable/${menu.menuId}" />">On</a>
           	 <span class="label label-default label-margin-s"><c:out value="${menu.unitPrice}" /></span>
           	 <span class="glyphicon visible-<c:out value="${menu.isVisible}" /> glyphicon-eye-open"></span>
           	 <span class="glyphicon visible-<c:out value="${menu.isVisible}" /> glyphicon-eye-close"></span>
        	</li>
        </c:forEach>
    </ul>
  </div>


<!-- KONTENER ZMIEŃ MENU -->
<div class="bg-1">
<div class="container" id="container-edit">
  <h2><p class="text-center">Zmień menu</p></h2>
    
<form:form method="post" modelAttribute="menuForm" action="${saveMenuUrl}">
    
    <form:input type="hidden" path="menuId" readonly="true" />
  	<form:errors path="menuId">Please enter meal id</form:errors>
  	
    <ul class="list-group">
            <li class="list-group-item">
                <div class="row">
                    <div class="col-sm-2">Nazwa</div>
                    <div class="col-sm-8">
                   	 <form:input type="text" path="mealTranslation.mealDescPl" class="form-control input-lg" placeholder="nazwa potrawy" />
  					 <form:errors path="mealTranslation.mealDescPl">Podaj nazwę</form:errors>
                   	</div>
                    <div class="col-sm-2"></div>
                </div>
            </li>
            <li class="list-group-item">
                <div class="row">
                    <div class="col-sm-2">Cena</div>
                    <div class="col-sm-8">
                   	 <form:input type="number" path="unitPrice" class="form-control input-lg" id="cena" placeholder="cena w pln" />
  					 <form:errors path="unitPrice">Podaj cenę</form:errors>
                    </div>
                    <div class="col-sm-2"></div>
                </div>
            </li>
            <li class="list-group-item">
                <div class="row">
                    <div class="col-sm-2">Kategoria</div>
                    <div class="col-sm-8">
                        <div class="form-group">
                            <select path="mealType" name="mealType.mealTypeId" class="form-control" id="kategoria">
                                <c:forEach items="${mealTypes}" var="types">
									<option value="${types.mealTypeId}">${types.mealTypePl}</option>
								</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-2"></div>
                </div>
            </li>
    </ul>    
    		<li class="list-group-item list-group-item-footer-bg-1">
		  	 <form:input type="hidden" path="isVisible" />
		  	 	<c:if test="${menuForm.menuId != null}">
					<a class="btn btn-default btn-margin-s pull-right" href="<c:url value="/menu/cancelEdit" />">Anuluj</a>
				</c:if>
					<input type="submit" value="Zapisz" class="btn btn-success pull-right">
			</li>
		
</form:form>
</div>
</div>

	
<%@include file="/screens/footer.jsp"%>