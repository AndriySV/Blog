$(document).ready(function(){
	
	var allArticles="";
	
	$(".blog-post").ready(function() {
		
		$.getJSON("/Blog/showArticles", function(articles) {
			for (var int = 0; int < articles.length-1; int++) {
				
				fillArticles(articles[int]);
			}
			
		});
	});
	
	function fillArticles(article) {
		$.post("/Blog/showImages", article, function(images) {
			
			var allArticles="";
			
			var title = "<div  class='row text-justify div-article'><h2>" + article.title + "</h2>";
			
			var image = "<img class='img-rounded img-responsive pull-left image-article' "
				+ "src='image_article/" + images[0].name + "' alt='Responsive image'> ";
			
			allArticles = title + image  		
				+ "<p>" + article.content + "</p>"
				+ "<p class='blog-post-meta'>" + article.creationDate + "</p>"
				+ "</div><hr>";
			
			$(".blog-post").append(allArticles);
		});
	}
	

});