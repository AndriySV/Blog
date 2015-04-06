$(document).ready(function() {

	// Make active the latest tab after the page is uploaded.
	$(function() {
		$('.nav-stacked a[data-toggle="tab"]').on("click", function(e) {
			//save the latest tab
			localStorage.setItem('lastTab', $(event.target).attr('id'));
		});

		//go to the latest tab, if it exists:
		var lastTab = localStorage.getItem('lastTab');
		if (lastTab) {
			$('#' + lastTab).tab('show');
		}
	});

});