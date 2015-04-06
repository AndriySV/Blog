$(document).ready(function() {
	
		// Choose more images if #chooseImage is clicked
		$('#chooseImage').click(function() {
			var fileIndex = $('#fileTable tr').children().length;
			
			$('#fileTable').append(
					'<tr>'
				+		'<td>'
				+ 			'<input class="filestyle" type="file" name="files['+ fileIndex + ']">'
				+ 		'</td>'
				+	'</tr>'
				);
		
			$(".filestyle").filestyle({buttonBefore: true});
		
		});
		
		// If element #selectImage exists than the code will be run
		if( $("#selectImage0").length){
			recieveImages(0);
		}
		
		$('#addAnotherImageIntoArticle').click(function() {
			var imageIndex = $("#addImageIntoArticle div[class='row']").length;

			// Add images to the article
			$('#addImageIntoArticle').append(
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
				+					'<input type="text" class="form-control" id="tip" name="paragraphs" placeholder="№:" '
				+							'pattern="^[1-9]{1}[0-9]{0,1}" data-error="Невірний номер параграфу." '
				+							'required="required">'
				+				'</div>'
				+				'<div class="help-block with-errors"></div>'	
				+			'</div>'
				+			'<button type="button" class="close col-sm-1" data-dismiss="alert" aria-hidden="true">&times;</button>'
				+	'</div>'
				);
			
			recieveImages(imageIndex);
			
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
			
		});
		
		//TODO Maybe use POST method !
		// Recieves images from the database
		function recieveImages(imageIndex) {
			$.getJSON("/Blog/admin/recieveImages", function(images) {
				var options = '<option></option>';
				
				for (var i = 0; i < images.length; i++) {
					
					options += '<option>' + images[i].name + '</option>'
				}

				$('#selectImage' + imageIndex).html(options);
			});
		}
		
		//Show all articles
		if( $('#articleTable tbody').length){

			$.post('/Blog/admin/recieveArticles', function(articles) {
				for (var item = articles.length-1; item >= 0; item--) {
					var row = '<tr>'
					+		'<td>' + ++item + '</td>'
					+		'<td>' + articles[--item].title + '</td>'
					+		'<td>' + articles[item].creationDate + '</td>'
					+		'<td class="article-delete">'
					+			'<div class="checkbox">'
					+				'<input type="checkbox" name="articleId" value="' + articles[item].id + '">'
					+			'</div>'
					+		'</td>'
					+	'</tr>';
					
					$('#articleTable tbody').append(row);
				}
			});
		}
		
		// Make active the latest tab after the page is uploaded.
		$(function() { 
			  $('.nav-stacked a[data-toggle="tab"]').on("click", function (e) {
			    //save the latest tab; use cookies if you like 'em better:
			    localStorage.setItem('lastTab', $(event.target).attr('id'));
			  });

			  //go to the latest tab, if it exists:
			  var lastTab = localStorage.getItem('lastTab');
			  if (lastTab) {
			      $('#'+lastTab).tab('show');
			  }
		});
		
		// Sent article Id on the server which will be deleted.
		$('#articleDeleteButton').click(function() {
			// get all checked the inputs into an array.
		    var inputs = $(':input[name="articleId"]:checked');
		    
		    if (inputs.length == 0) {
		    	
		    	$('#modalArticleDelete .modal-body').html(
		    			'<div class="alert alert-danger">'
					+		'<strong>Жодна стаття не була видалена. '
					+			'<br>Оберіть будь-ласка статті які бажаєте видалити.'
					+		'<strong>'
					+	'</div>');
		    	
		    	$('#modalArticleDelete').modal('show');
		    	
		    } else {
				
		    	$.post('/Blog/admin/deleteArticles', inputs, function(titles) {
					
					var titlesHTML = '';
					for (var int = 0; int < titles.length; int++) {
						titlesHTML += '<li>' + titles[int] + '</li>';
					}
					
					$('#modalArticleDelete .modal-body').html(
							'<div class="alert alert-success">'
						+		'<strong>Статті:</strong>' 
						+			'<ul>'+ titlesHTML + '</ul>'
						+		'<strong>були успішно видалені.</strong>'
						+	'</div>');
					
					$('#modalArticleDelete').modal('show');
					
					$('#buttonModalArticleDelete').click(function() {
						location.reload();
					});
				});
			}
		});
		
});