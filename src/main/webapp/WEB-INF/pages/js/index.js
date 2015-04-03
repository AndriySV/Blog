$(document).ready(function(){
	
	if( $(".blog-post").length){
		
		// TODO Maybe delete (ready)
		$(".blog-post").ready(function() {
			
			// Invokes the method from the controller 
			// and get the information from it about all articles. 
			$.post("/Blog/displayArticles", function(articles) {
				
				$(".blog-post").append(articles);
			});
				
		});
	}
});