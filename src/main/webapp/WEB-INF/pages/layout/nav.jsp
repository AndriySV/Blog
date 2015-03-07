<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:url value="/j_spring_security_check" var="loginUrl" />
<c:url value="j_spring_security_logout" var="logoutUrl" />

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">

		<a class="navbar-brand" href="#">StayFit</a>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
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
				<li><a href="about">Про мене</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="hasRole('ROLE_ANONYMOUS')">
					<li><a href="#login" data-toggle="modal">Увійти</a></li>
					<li><a href="registration">Зареєструватись</a></li>
				</security:authorize>
				
				<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
					<li><a>${pageContext.request.userPrincipal.name}</a></li>
					
					<li><a href="/userProfile" >Мій профіль</a></li>
					<li><a href="${logoutUrl}" >Вийти</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>

	<!-- Login -->
	<div class="modal fade" id="login" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>

				<form name="loginForm" action="${loginUrl}" method="POST" 
					class="form-signin" role="form" data-toggle="validator">
					<fieldset>
						<h2 class="form-signin-heading">Будь ласка увійдіть</h2>

						<div class="form-group required">
							<div class="input-group">
								<input type="text" class="form-control"
									name="email"
									placeholder="Bведіть email" 
									pattern="\b(?!.{31})([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4})\b"
									data-error="Ви ввели некоректний email !"
									required="required"
									autofocus="autofocus">
								<span class="input-group-addon">@</span>
							</div>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group required">
							<div class="input-group">
								<input type="password" class="form-control"
									name="password"
									placeholder="Введіть пароль !" 
									pattern="\b[A-Za-z0-9._%+-]{4,15}\b"
									data-error="Ви ввели некоректний пароль !"
									required="required">
								<span class="input-group-addon glyphicon glyphicon-barcode"></span>
							</div>
							<div class="help-block with-errors"></div>
						</div>
						<button class="btn btn-lg btn-danger btn-block" type="submit">
							<span class="glyphicon glyphicon-ok"></span> Увійти
						</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

</nav>