$(document).ready(function() {
	
	var fileIndex;
	
	// Choose more images to download
	$('#chooseImage').click(function() {
		setFileIndex();
		setFieldChooseFile();
	});
	
	function setFileIndex() {
		fileIndex = $('#fileTable tr').children().length;
	}
	
	function setFieldChooseFile() {
		var fieldChooseFileHTML = 
				'<tr>'
			+		'<td>'
			+ 			'<input class="filestyle" type="file" name="files['+ fileIndex + ']">'
			+ 		'</td>'
			+	'</tr>';
		
		$('#fileTable').append(fieldChooseFileHTML);
	
		$(".filestyle").filestyle({buttonBefore: true});
	}
	
});