<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
				<li><a href="/#login" data-toggle="modal">Увійти</a></li>
				<li><a href="registration">Зареєструватись</a></li>
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

				<form class="form-signin" role="form">
					<h2 class="form-signin-heading">Будь ласка увійдіть</h2>

					<input type="email" class="form-control" placeholder="E-mail"
						required="" autofocus=""> <input type="password"
						class="form-control" placeholder="Пароль" required="">
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Увійти</button>
				</form>
			</div>
		</div>
	</div>
	
</nav>
