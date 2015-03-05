<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Reset style -->
<div class="col-md-7" style="padding-top: 30px;">
	<sf:form action="registration" method="POST" class="form-horizontal"
		role="form" data-toggle="validator" modelAttribute="user">

		<fieldset>
			<!-- Form Name -->
			<legend>Реєстрація</legend>

			<div class="form-group required">
				<label for="name" class="col-sm-3 control-label">Ім'я</label>
				<div class="col-sm-9">
					<sf:input class="form-control" id="name" path="name"
						placeholder="Bід 2 до 20 символів" pattern="\b[A-Za-z0-9]{2,20}\b"
						data-error="Ви ввели некоректне ім'я !" required="required" />
					<div class="help-block with-errors"></div>
					<sf:errors path="name" class="error" />
				</div>
			</div>

			<div class="form-group required">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<sf:input class="form-control" id="email" path="email"
						placeholder="Bведіть свій email"
						pattern="\b(?!.{31})([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4})\b"
						data-error="Ви ввели некоректний email !" required="required" />
					<div class="help-block with-errors"></div>
					<sf:errors path="email" class="error" />
				</div>
			</div>

			<div class="form-group required">
				<label for="password" class="col-sm-3 control-label">Пароль</label>
				<div class="col-sm-9">
					<sf:password class="form-control" id="password" path="password"
						placeholder="Bід 4 до 15 символів"
						pattern="\b[A-Za-z0-9._%+-]{4,15}\b"
						data-error="Ви ввели некоректний пароль !" required="required" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group required">
				<label for="confirmPassword" class="col-sm-3 control-label">Підтвердіть
					пароль</label>
				<div class="col-sm-9">
					<sf:password class="form-control" id="confirmPassword" path=""
						placeholder="Підтвердіть ваш пароль" data-match="#password"
						data-match-error="Некоректно підтверджений пароль !"
						required="required" />
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group required">
				<label for="birthday" class="col-sm-3 control-label">Дата
					народження</label>
				<div class="col-sm-9 input-append date" data-date="12-02-2012"
					data-date-format="dd-mm-yyyy" data-date-viewmode="years">
					<sf:input class="form-control" id="birthday" path="birthday"
						placeholder="yyyy-mm-dd"
						pattern="(((19|20)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]))\b"
						data-error="Ви ввели некоректну дату !" required="required" />

					<span class="add-on"><i class="glyphicon-th"></i></span>

					<div class="help-block with-errors"></div>
				</div>
			</div>

			<div class="form-group required">
				<label class="col-sm-3 control-label" for="sex">Стать</label>
				<div class="col-sm-9">
					<div class="radio">
						<label> <sf:radiobutton path="sex" name="sex" value="MALE"
								checked="true" />Чоловік
						</label> <label> <sf:radiobutton path="sex" name="sex"
								value="FEMALE" />Жінка
						</label>
					</div>
				</div>
			</div>

			<div class="input-append date" id="dp3" data-date="12-02-2012"
				data-date-format="dd-mm-yyyy">
				<input class="span2" size="16" type="text" value="12-02-2012">
				<span class="add-on"><i class="icon-calendar"></i></span>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4">
					<button type="submit" class="btn btn-danger btn-lg">
					<span class="glyphicon glyphicon-ok"></span>
					Зареєструватися</button>
					
				</div>
			</div>

		</fieldset>
	</sf:form>
</div>
