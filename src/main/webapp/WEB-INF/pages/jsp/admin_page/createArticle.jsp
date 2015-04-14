<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Pane Create the article -->
<div class="tab-pane active" id="createArticle">
	<fieldset>
		<!-- Form Name -->
		<legend class="text-center">Створити статтю</legend>

		<!-- Form for creating article -->
		<div id="createArticleForm">
			<sf:form action="admin/add" method="POST" class="form-horizontal"
				role="form" modelAttribute="article" data-toggle="validator">

				<!-- Field Title -->
				<div class="form-group required">
					<sf:textarea class="form-control" rows="3" cols="" path="title"
						placeholder="Введіть заголовок статті"
						data-error="Введіть заголовок !" required="required" />
					<div class="help-block with-errors"></div>
					<sf:errors path="title" class="error" />
				</div>

				<!-- Field Content -->
				<div class="form-group">
					<sf:textarea class="form-control" rows="10" cols="" path="content"
						placeholder="Введіть статтю" data-error="Введіть статтю !"
						required="required" />
					<div class="help-block with-errors"></div>
				</div>

				<!-- Add images to the article -->
				<div class="form-group" id="addImageToCreate"></div>

				<div class="form-group">
					<button type="button" id="addAnotherImageToCreate"
						class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-plus"></span> Додати зображення
					</button>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-danger btn-lg center-block">
						<span class="glyphicon glyphicon-ok"></span> Додати статтю
					</button>
				</div>
			</sf:form>
		</div>
	</fieldset>
</div>