<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">

	<div class="col-md-3 right-tab">
		<ul class="nav nav-tabs nav-stacked">
			<li class="active"><a href="#createArticle" data-toggle="tab"
				id="createArticleTab">Створити статтю</a></li>
			<li><a href="#downloadImage" data-toggle="tab"
				id="downloadImageTab">Завантажити зображення</a></li>
			<li><a href="#editArticle" data-toggle="tab" id="editArticleTab">Редагувати
					статтю</a></li>
			<li><a href="#deleteArticle" data-toggle="tab"
				id="deleteArticleTab">Видалити статті</a></li>
			<li class="divider"></li>
			<li><a href="#statictic" data-toggle="tab" id="staticticTab">Статистика</a></li>
			<li class="divider"></li>
			<li><a href="#other" data-toggle="tab">Інше</a></li>
		</ul>
	</div>

	<div class="col-md-offset-1 col-md-8 central-tab">
		<div class="tab-content">

			<!-- Includes the pane create the article -->
			<jsp:include page="createArticle.jsp" />

			<!-- Includes the pane download the image-->
			<jsp:include page="downloadImage.jsp" />

			<!-- Includes the pane edit the article -->
			<jsp:include page="editArticle.jsp" />

			<!-- Includes the pane delete the article -->
			<jsp:include page="deleteArticle.jsp" />

			<div class="tab-pane" id="statictic">
				<h1>Statistic</h1>
			</div>

			<div class="tab-pane" id="other">
				<h1>other</h1>
			</div>

		</div>

	</div>

</div>
