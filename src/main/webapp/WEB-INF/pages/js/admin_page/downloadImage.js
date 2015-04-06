$(document).ready(function() {
	
	// Choose more images to download
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
	
});