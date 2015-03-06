
// When the document is ready
$(document).ready(function () {

	$('#birthday').focus(function() {
		$(this).datepicker({
			format:"yyyy-mm-dd",
			viewMode:"years"
			
		});
	  $(this).datepicker("show");
	})
  
	$("#birthday").blur(function() {
		$(this).popover("hide");
	});
	
});
