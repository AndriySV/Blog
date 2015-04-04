<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Pane delete the article -->
<div class="tab-pane" id="deleteArticle">
	<fieldset>
		<!-- Pane Name -->
		<legend class="text-center">Видалити статті</legend>

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
				<tbody></tbody>
			</table>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-danger btn-lg center-block"
				id="articleDeleteButton">
				<span class="glyphicon glyphicon-ok"></span> Видалити статті
			</button>
		</div>
		
		<!-- Modal window no article to delete -->
		<div class="modal fade" id="noArticleDelete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">StayFit</h4>
					</div>
					<div class="modal-body">
						<p>
							Жодна стаття не була видалена. <br>Обервть будь-ласка статті
							які бажаєте видалити.
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger center-block"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-record"></span> Дякую за пораду
						</button>
					</div>
				</div>
			</div>
		</div>

	</fieldset>

</div>