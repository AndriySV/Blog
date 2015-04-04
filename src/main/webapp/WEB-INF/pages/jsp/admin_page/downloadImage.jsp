<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
		
		<!-- TODO Add modal window, that image was downloaded  -->
	</fieldset>
</div>