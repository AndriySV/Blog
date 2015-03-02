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
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Статті<b class="caret"></b></a>
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
				<li><a href="login">Увійти</a></li>
				<li><a href="registration">Зареєструватись</a></li>
			</ul>
		</div>

	</div>
</nav>
