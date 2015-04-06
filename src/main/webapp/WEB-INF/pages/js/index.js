$(document).ready(function(){
	
	if( $('.blog-post').length){
		
		// TODO Maybe delete (ready)
		$('.blog-post').ready(function() {
			
			// Invokes the method from the controller 
			// and get the information from it about all articles. 
			$.post('/Blog/displayArticles', function(articles) {
				
				$('.blog-post').append(articles);
			});
				
		});
	}
	
	// Displays error in the window login. 
	if ( $('#errorLogin').length) {
		
		$('.form-signin fieldset').prepend(
				'<div class="alert alert-danger">'
			+	'<h4 class="text-center">Невірний email чи пароль. '
			+	'<br>Повторіть введення !</h4></div>');
		$('#login').modal('show');
	}
	
});