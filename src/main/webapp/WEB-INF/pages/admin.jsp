<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="row">

	<div class="col-md-3 right-tab">
		<ul class="nav nav-tabs nav-stacked">
			<li class="active"><a href="#addArticle" data-toggle="tab">Створити
					статтю</a></li>
			<li><a href="#downloadImage" data-toggle="tab">Завантажити
					зображення</a></li>
			<li><a href="#editArticle" data-toggle="tab">Редагувати
					статтю</a></li>
			<li><a href="#deleteArticle" data-toggle="tab">Видалити
					статтю</a></li>
			<li class="divider"></li>
			<li><a href="#statictic" data-toggle="tab">Статистика</a></li>
			<li class="divider"></li>
			<li><a href="#other" data-toggle="tab">Інше</a></li>
		</ul>
	</div>

	<div class="col-md-offset-1 col-md-8 central-tab">
		<div class="tab-content">

			<!-- Pane Create the article -->
			<div class="tab-pane active" id="addArticle">
				<fieldset>
					<!-- Form Name -->
					<legend class="text-center">Створити статтю</legend>

					<div>
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
								<sf:textarea class="form-control" rows="10" cols=""
									path="content" placeholder="Введіть статтю"
									data-error="Введіть статтю !" required="required" />
								<div class="help-block with-errors"></div>
							</div>

							<!-- Add images to the article -->
							<div class="form-group" id="addImageIntoArticle"></div>

							<div class="form-group">
								<button type="button" id="addAnotherImageIntoArticle"
									class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-plus"></span> Додати
									зобрвження
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

			<!-- Pane download the images -->
			<div class="tab-pane" id="downloadImage">
				<fieldset>
					<!-- Pane Name -->
					<legend class="text-center">Завантажити зображення</legend>

					<div>
						<sf:form action="admin/saveImage" method="POST"
							class="form-horizontal add-file" modelAttribute="uploadImage"
							role="form" enctype="multipart/form-data">

							<div class="form-group">
								<table id="fileTable">
									<tr>
										<td><input type="file" class="filestyle"
											data-buttonBefore="true" name="files[0]" /></td>
									</tr>
								</table>
							</div>

							<div class="form-group">
								<button type="button" id="chooseImage"
									class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-plus"></span> Ще одне
								</button>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-danger btn-lg center-block">
									<span class="glyphicon glyphicon-ok"></span> Завантажити
								</button>
							</div>
						</sf:form>
					</div>
				</fieldset>
			</div>

			<!-- Pane edit the article -->
			<div class="tab-pane" id="editArticle">
				<fieldset>
					<!-- Pane Name -->
					<legend class="text-center">Редагувати статтю</legend>

					<h1>Edit</h1>
				</fieldset>
			</div>

			<!-- Pane delete the article -->
			<div class="tab-pane" id="deleteArticle">
				<fieldset>
					<!-- Pane Name -->
					<legend class="text-center">Видалити статтю</legend>

					<form action="/Blog/admin/deleteArticles" method="post" role="form">
						<div class="form-group">
							<table class="table table-striped" id="articleTable">
								<thead>
									<tr>
										<th class="col-md-1">#</th>
										<th class="col-md-7">Назва статті</th>
										<th class="col-md-3">Дата створення</th>
										<th class="col-md-1">Видалити</th>
									</tr>
								</thead>
								<tbody>
									<!-- 	<tr>
								<td>1</td>
								<td>Mark</td>
								<td>Otto</td>
								<td class="article-delete">
									<div class="checkbox">
										<input type="checkbox" value="">
									</div>
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Jacob</td>
								<td>Thornton</td>
								<td class="article-delete">
									<div class="checkbox">
										<input type="checkbox" value="">
									</div>
								</td>
							</tr> -->
								</tbody>
							</table>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-danger btn-lg center-block">
								<span class="glyphicon glyphicon-ok"></span> Видалити статті
							</button>
						</div>
					</form>
				</fieldset>
			</div>

			<div class="tab-pane" id="statictic">
				<h1>Statistic</h1>
			</div>

			<div class="tab-pane" id="other">
				<h1>other</h1>
			</div>

		</div>

	</div>

</div>
