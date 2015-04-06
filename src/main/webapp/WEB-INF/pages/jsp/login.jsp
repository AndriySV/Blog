<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/j_spring_security_check" var="loginUrl" />

<!-- Modal window Login -->
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
							<input type="text" class="form-control" name="email"
								placeholder="Bведіть email"
								pattern="\b(?!.{31})([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4})\b"
								data-error="Ви ввели некоректний email !" required="required"
								autofocus="autofocus"> <span class="input-group-addon">@</span>
						</div>
						<div class="help-block with-errors"></div>
					</div>
					<div class="form-group required">
						<div class="input-group">
							<input type="password" class="form-control" name="password"
								placeholder="Введіть пароль !"
								pattern="\b[A-Za-z0-9._%+-]{4,15}\b"
								data-error="Ви ввели некоректний пароль !" required="required">
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