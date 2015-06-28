/**
 * 
 */

$(function() {

	$('#btnEdit').css('display', 'none');
	/*$('#btnCreateNew').css('display', 'none');
	$('#btnCheckAvailable').css('display', 'none');*/
	
	$("#btnSave").click(function() {
		
		$('#btnEdit').css('display', 'inline-block');
		$('#btnSave').css('display', 'none');
		
	});
});