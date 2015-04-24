$(document).ready(function() {
	
	var images;
	var imageIndex;
	var paragraph = "";
	var imageName = "";
	
	var article;
	var imageParagraphs = [];
	
	if( $('#articleEditTable').length){

		//Displays all articles.
		$.post('/Blog/admin/recieveArticles', function(articles) {
			displayAllArticles(articles);
			
			// Retrieves the selected article.
			$('#articleEditTable button').click(function() {
				$('#articleEditTable').hide();	
				$('#editArticleForm').show();
				
				retrieveImages();
				
				var articleId = $(this).val();
				retrieveArticle(articleId);
			});
		});
		
		// Adds a field in which we can add the an image and paragraph to the article. 
		$('#addAnotherImageToEdit').click(function() {
			imageIndex = getImageIndex();
			setFieldImageParagraph();
			addImages(imageIndex, images);
			setParagraphTip();
		});
		
		$('#articleUpdateButton').click(function() {
			setArticle();
			updateArticle();
		});
		
	}
	
	//Displays all articles on the editArticle.jsp
	function displayAllArticles(articles) {
		for (var item = articles.length-1; item >= 0; item--) {
			var row = '<tr>'
			+			'<td>' + ++item + '</td>'
			+			'<td>' + articles[--item].title + '</td>'
			+			'<td>' + articles[item].creationDate + '</td>'
			+			'<td class="text-center">'
			+				'<button type="button" class="btn btn-warning" value="' 
								+ articles[item].id + '" data-toggle="button">'
			+					'<span class="glyphicon glyphicon-edit"></span>'
			+				'</button>'
			+			'</td>'
			+		'</tr>';
			
			$('#articleEditTable tbody').append(row);
		}
	}
	
	// Retrieves all images
	function retrieveImages() {
		$.post("/Blog/admin/recieveImages", function(img) {
			images = img;
		});
	}
	
	// Retrieves the selected article
	function retrieveArticle(articleId) {
		var objectArticleId = {};
		objectArticleId.id = articleId;
		
		// Receives and fills the title and content of the article.
		$.post('/Blog/admin/receiveArticle', objectArticleId, function(article) {
			$('#articleTitleToEdit').text(article.title);
			$('#articleContentToEdit').text(article.content);
			$('#articleIdToEdit').val(article.id);
			$('#articleCreationDateToEdit').val(article.creationDate);
		});
		
		retieveImagesAndParagraphs(objectArticleId);
	}
	
	// Retrieves all images and all paragraphs of the article.
	function retieveImagesAndParagraphs(objectArticleId) {
		$.post('/Blog/admin/receiveImageParagraphs', objectArticleId, function(imageParagraph) {
			fillImagesAndParagraphs(imageParagraph);
		});
	}
	
	// Fills all image names and all paragraphs into the article.
	function fillImagesAndParagraphs(imageParagraph) {
		for (var int = 0; int < imageParagraph.length; int++) {
			setImageName(imageParagraph[int].imageName)
			setParagraph(imageParagraph[int].paragraph);
			
			imageIndex = getImageIndex();
			setFieldImageParagraph();
			addImages(imageIndex, images);
		}
		setParagraphTip();
	}
	
	function getImageIndex() {
		imageIndex = $("#editArticleForm div[class='row']").length;
		return imageIndex;
	}
	
	// Creates the field for adding an image and paragraph into the article
	function setFieldImageParagraph () {
		var fieldImageParagraphHTML = getFieldImageParagraph();
		$('#addImageToEdit').append(fieldImageParagraphHTML);
	}
	
	// Creates fieldImageParagraphHTML and fills the paragraph
	function getFieldImageParagraph() {
		imageIndex = getImageIndex();
		paragraph = getParagraph();
		
		// TODO Im Par
		var fieldImageParagraphHTML = 
			'<div class="row">'
		+ 			'<label class="col-sm-2 control-label">Оберіть зображення</label>'
				// Field select image
		+			'<div class="col-sm-6">'
		+				'<div class="input-group">'
		+					'<span class="input-group-addon glyphicon glyphicon-picture"></span>'
		+					'<select class="form-control" name="imageNames" id="editImage' + imageIndex + '"></select>'
		+				'</div>'
		+			'</div>'	
				// Field paragraph
		+			'<div class="col-sm-3">'
		+				'<div class="input-group">'
		+					'<span class="input-group-addon glyphicon glyphicon-chevron-right"></span>'
						// Can contains values only from 1 to 99
		+					'<input type="text" class="form-control" name="paragraphs" placeholder="№:" '
		+							'value="' + paragraph + '"'
		+							'pattern="^[1-9]{1}[0-9]{0,1}" data-error="Невірний номер параграфу." '
		+							'required="required">'
		+				'</div>'
		+				'<div class="help-block with-errors"></div>'	
		+			'</div>'
		+			'<button type="button" class="close col-sm-1" data-dismiss="alert" aria-hidden="true">&times;</button>'
		+	'</div>';
		
		paragraph = "";
		return fieldImageParagraphHTML;
	}
	
	// Adds all images name into the field image
	function addImages(imageIndex, images) {
		var options = '<option></option>';
		imageName = getImageName();
			
		for (var i = 0; i < images.length; i++) {
			if (imageName == images[i].name) {
				options += '<option selected>' + images[i].name + '</option>'
				imageName = "";
			} else {
				options += '<option>' + images[i].name + '</option>'
			}
		}

		$('#editImage' + imageIndex).html(options);
	}
	
	// Adds a tip to the field paragraph 
	function setParagraphTip() {
		$("input[name='paragraphs']").focus(function() {
			$(this).popover({
					trigger:"focus",
					container:"body",
					toggle:"popover",
					placement:"right",
					content:"Введіть номер параграфа, перед яким ви хочете розмістити обране зображення."
			});
			$(this).popover("show");
		});
		
		$("input[name='paragraphs']").blur(function() {
			$(this).popover("hide");
		});
	}
	
	function setParagraph(par) {
		paragraph = par;
	}
	
	function getParagraph() {
		return paragraph;
	}
	
	function setImageName(imgName) {
		imageName = imgName;
	}
	
	function getImageName() {
		return imageName;
	}
	
	// TODO Art
	function setArticle() {
		article = {title:$('#articleTitleToEdit').val(),
			content:$('#articleContentToEdit').val(),
			id:$('#articleIdToEdit').val()}; 
		
	}
	
	function getArticle() {
		return article;
	}
	
	// FIXME This method has to pass needed data to the Controller 
	function updateArticle() {
		
		// work if title isn't null
		if (getArticle().title.length) {
			
			var str = ["one", "two"]
			
									//FIXME Pass right data !!!  
			$.post("/Blog/admin/updateArticle", {str:str}, function(isUpdate) {
	
				if (isUpdate == "false") {
					setModalTitleExist(article.title);
					$('#modalArticleUpdate').modal('show');
					
				} else if (isUpdate == "true") {
					
				//	updateImageParagraphs();
					
					setModalArticleUpdated(article.title);
					$('#modalArticleUpdate').modal('show');
				}
			});
		}
	}
	
	function setModalTitleExist(title){
		var modalBody = 
				'<div class="alert alert-danger">'
			+		'<strong>Неможливо здійснити редагування сторінки.<br></strong>'
			+		'<strong>Стаття із заголовком</strong>' 
			+			'<ul>' + title + '</ul>'
			+		'<strong>уже існує.</strong>'
			+	'</div>';
		
		$('#modalArticleUpdate .modal-body').html(modalBody);

		var modalFooter = 
				'<button type="button" class="btn btn-danger" data-dismiss="modal">'
		+			'<span class="glyphicon glyphicon-record"></span> Зрозуміло'
		+		'</button>';
		
		$('#modalArticleUpdate .modal-footer').html(modalFooter);
	}
	
	function setModalArticleUpdated(title) {
		var modalBody = 
				'<div class="alert alert-success">'
			+		'<strong>Стаття</strong>'
			+			'<ul>' + title + '</ul>'
			+ 		'<strong>була успішно оновлена.</strong>'
			+	'</div>';
		
		$('#modalArticleUpdate .modal-body').html(modalBody);
		
		var modalFooter = 
				'<button type="button" class="btn btn-danger" data-dismiss="modal">'
			+		'<span class="glyphicon glyphicon-record"></span> Зрозуміло'
			+	'</button>';
	
		$('#modalArticleUpdate .modal-footer').html(modalFooter);
	}
	
	function updateImageParagraphs() {
		
		
		
	}
	
	function setImageParagraphs() {
		var imageNames = [];
		imageNames = $('#addImageToEdit select[name="imageNames"]');
		
		var paragraphs = [];
		paragraphs = $('#addImageToEdit input[name="paragraphs"]');
		
		for (var int = 0; int < imageNames.length; int++) {
			
			imageParagraphs[int] = {imageName:imageNames[int].value,
									paragraph:paragraphs[int].value};
		}
	}
	
	function getImageParagraphs() {
		return imageParagraphs;
	}
	
	
});