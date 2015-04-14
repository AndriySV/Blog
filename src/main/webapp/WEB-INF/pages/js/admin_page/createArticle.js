$(document).ready(function() {
	
	var imageIndex;

	$('#addAnotherImageToCreate').click(function() {
		setImageIndex();
		setFieldImageParagraph();
		retrieveImages();
		setParagraphTip();
	});
	
	function setImageIndex(){
		imageIndex = $("#createArticleForm div[class='row']").length;
		return imageIndex;
	}
	
	// Creates the field for adding an image and paragraph into the article
	function setFieldImageParagraph() {
		var fieldImageParagraphHTML = 
			'<div class="row">'
			+ 			'<label for="selectImageDiv" class="col-sm-2 control-label">Оберіть зображення</label>'
						// Field select image
			+			'<div class="col-sm-6" id="selectImageDiv">'
			+				'<div class="input-group">'
			+					'<span class="input-group-addon glyphicon glyphicon-picture"></span>'
			+					'<select class="form-control" name="imageNames" id="selectImage' + imageIndex + '"></select>'
			+				'</div>'
			+			'</div>'	
						// Field paragraph
			+			'<div class="col-sm-3">'
			+				'<div class="input-group">'
			+					'<span class="input-group-addon glyphicon glyphicon-chevron-right"></span>'
								// Can contains values only from 1 to 99
			+					'<input type="text" class="form-control" name="paragraphs" placeholder="№:" '
			+							'pattern="^[1-9]{1}[0-9]{0,1}" data-error="Невірний номер параграфу." '
			+							'required="required">'
			+				'</div>'
			+				'<div class="help-block with-errors"></div>'	
			+			'</div>'
			+			'<button type="button" class="close col-sm-1" data-dismiss="alert" aria-hidden="true">&times;</button>'
			+	'</div>';
		
		$('#addImageToCreate').append(fieldImageParagraphHTML);
	}
	
	// Retrieves all images
	function retrieveImages() {
		$.post("/Blog/admin/recieveImages", function(images) {
			addImages(images);
		});
	}
	
	// Adds all images name into the field image
	function addImages(images) {
		var options = '<option></option>';
			
		for (var i = 0; i < images.length; i++) {
			options += '<option>' + images[i].name + '</option>'
		}
			
		$('#selectImage' + imageIndex).html(options);
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
	
});