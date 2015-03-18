$(document).ready(function() {
	
	var fileIndex = 0;
	
		// add more file components if #AddImage is clicked
		$('#AddImage').click(function() {
			fileIndex = $('#fileTable tr').children().length;
			
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