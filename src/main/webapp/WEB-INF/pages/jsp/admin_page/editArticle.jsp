<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Pane edit the article -->
<div class="tab-pane" id="editArticle">
	<fieldset>
		<!-- Pane Name -->
		<legend class="text-center">Редагувати статтю</legend>

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
		
				<!-- Field Title -->
				<form role="form" data-toggle="validator">
					<div class="form-group required">
						<textarea class="form-control" rows="3" cols="" name="title" id="articleTitleToEdit"
								placeholder="Введіть заголовок статті"
								data-error="Введіть заголовок !" required="required"></textarea>
						<div class="help-block with-errors"></div>
					</div>
				</form>
			
				<!-- Field Content -->
				<div class="form-group">
					<textarea class="form-control" rows="10" cols="" 
						id="articleContentToEdit" name="content"></textarea>
				</div>
			
				<!-- Article Id -->	
				<div class="form-group" hidden="">
					<input id="articleIdToEdit" name="id"/>
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
					<button type="submit" class="btn btn-danger btn-lg center-block"
						id="articleUpdateButton">
						<span class="glyphicon glyphicon-ok"></span> Редагувати статтю
					</button>
				</div>
		</div>
		
			<!-- Modal window that contains information about the article updating. -->
		<div class="modal fade" id="modalArticleUpdate">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">StayFit</h4>
					</div>
					<div class="modal-body"></div>
					
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
	</fieldset>
</div>