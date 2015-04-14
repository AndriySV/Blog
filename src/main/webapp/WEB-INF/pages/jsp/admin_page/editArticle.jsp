<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Pane edit the article -->
<div class="tab-pane" id="editArticle">
	<fieldset>
		<!-- Pane Name -->
		<legend class="text-center">Редагувати статтю</legend>

		<c:if test="${error == true}">
			<div id="errorEditArticle"></div>
		</c:if>
		
		<table class="table table-striped" id="articleEditTable">
			<thead>
				<tr>
					<th class="col-md-1">#</th>
					<th class="col-md-6">Назва статті</th>
					<th class="col-md-3">Дата створення</th>
					<th class="col-md-2">Редагувати</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>

		<div id="editArticleForm" hidden="">
		
			<!-- Form for editing article -->
			<sf:form action="/Blog/admin/updateArticle" method="POST" class="form-horizontal"
				role="form" modelAttribute="article" data-toggle="validator">
			
				<!-- Field Title -->
				<div class="form-group required">
					<sf:textarea class="form-control" rows="3" cols="" path="title" id="articleTitleToEdit"
							placeholder="Введіть заголовок статті"
							data-error="Введіть заголовок !" required="required"></sf:textarea>
					<div class="help-block with-errors"></div>
					<sf:errors path="title" class="error" />
				</div>
			
				<!-- Field Content -->
				<div class="form-group">
					<sf:textarea class="form-control" rows="10" cols="" id="articleContentToEdit"
						path="content" placeholder="Введіть статтю"
						data-error="Введіть статтю !" required="required" />
					<div class="help-block with-errors"></div>
				</div>
				
				<div class="form-group" hidden="">
					<sf:input id="articleIdToEdit" path="id"/>
				</div>
				
				<!-- Add images to the article -->
				<div class="form-group" id="addImageToEdit"></div>
			
				<div class="form-group">
					<button type="button" id="addAnotherImageToEdit"
						class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-plus"></span> Додати зображення
					</button>
				</div>
			
				<div class="form-group">
					<button type="submit" class="btn btn-danger btn-lg center-block">
						<span class="glyphicon glyphicon-ok"></span> Редагувати статтю
					</button>
				</div>
			</sf:form>
		</div>
	</fieldset>
</div>