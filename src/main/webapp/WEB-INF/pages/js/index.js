$(document).ready(function(){
	
	var allArticles="";
	
	$(".blog-post").ready(function() {
		
		$.getJSON("/Blog/showArticles", function(articles) {
			
		/*	articles.sort(function(a, b){
			     var a1= a.id, b1= b.id;

			     if(a1== b1) return 0;
			     return a1> b1? -1: 1;
			});  */  
			
			// TODO Sort by id !
			
		/*	for (var i = articles.length-1; i >= 0; i--) {
				fillArticles(articles[i]);			
			}*/
			
			for (var int = 0; int < articles.length-1; int++) {
				
				var article = articles[int];
				
			$.post("/Blog/showImages", articles[int], function(images) {
				
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