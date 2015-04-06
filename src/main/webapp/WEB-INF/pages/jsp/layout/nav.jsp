<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:url value="j_spring_security_logout" var="logoutUrl" />

<jsp:include page="../login.jsp" />

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">

		<a class="navbar-brand" href="#"><font color="#CC0099">StayFit</font></a>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			
			<ul class="nav navbar-nav">
				<li class="active"><a href="/Blog">Головна</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Статті<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Действие</a></li>
						<li><a href="#">Другое действие</a></li>
						<li><a href="#">Что-то еще</a></li>
						<li class="divider"></li>
						<li><a href="#">Отдельная ссылка</a></li>
						<li class="divider"></li>
						<li><a href="#">Еще одна отдельная ссылка</a></li>
					</ul></li>
				<li><a href="#">Мотивація</a></li>
				<li><a href="#">Музика</a></li>
				<li><a href="#">Форум</a></li>
				<li><a href="/Blog/about">Про мене</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="hasRole('ROLE_ANONYMOUS')">
					
					<c:if test="${param.error == true}">
						<div id="errorLogin"></div>
					</c:if>
				
					<li><a href="#login" data-toggle="modal">Увійти</a></li>
					<li><a href="/Blog/registration">Зареєструватись</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/Blog/admin">Admin</a></li>
				</security:authorize>
				
				<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
					<li><a class="glyphicon glyphicon-user"> ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href="/Blog/userProfile" >Мій профіль</a></li>
					<li><a href="${logoutUrl}" >Вийти</a></li>
				</security:authorize>
			</ul>
			
		</div>
	</div>
	
</nav>