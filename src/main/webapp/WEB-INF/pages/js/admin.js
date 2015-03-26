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
		
		
		//Receive image names from the database
		$('#selectImage').ready(function() {
			
			$.getJSON("/Blog/admin/recieveImages", function(images) {
				var options = '<option>не обрано</option>';
				
				for (var i = 0; i < images.length; i++) {
					
					options += '<option>' + images[i].name + '</option>'
				}
				
				$('#selectImage').html(options);
				
			});
			
		});
		
		
		
		
});