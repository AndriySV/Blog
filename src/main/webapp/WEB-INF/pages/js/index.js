$(document).ready(function(){
	
	$(".blog-post").ready(function() {
		
		$.getJSON("/Blog/showArticles", function(articles) {
			var article = "";

			for (var i = articles.length-1; i >= 0; i--) {
				article += '<h2>' + articles[i].title + '</h2>'
					+ '<p>' + articles[i].content + '</p>'
					+ '<p class="blog-post-meta">' + articles[i].creationDate + '</p>'
					+ '<hr>';
			}
			
			$(".blog-post").html(article);
		})
	})
	
});