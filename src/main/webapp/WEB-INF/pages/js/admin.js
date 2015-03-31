$(document).ready(function() {
	
		// Choose more images if #chooseImage is clicked
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
		
		// If element #selectImage exists than the code will be run
		if( $('#selectImage').length){
			$.getJSON("/Blog/admin/recieveImages", function(images) {
				var options = '<option></option>';
				
				for (var i = 0; i < images.length; i++) {
					
					options += '<option>' + images[i].name + '</option>'
				}
				
				$('#selectImage').html(options);
				
			});
		}
		
});