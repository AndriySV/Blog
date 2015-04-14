$(document).ready(function() {
	
	//Display all articles on the deleteArticle.jsp
	if( $('#articleDeleteTable tbody').length){

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
				
				$('#articleDeleteTable tbody').append(row);
			}
		});
	}
	
	// Sent article Id on the server to delete this article.
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