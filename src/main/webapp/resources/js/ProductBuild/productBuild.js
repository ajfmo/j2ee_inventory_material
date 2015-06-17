$(document).ready(function() {

	// Ham Ajax
	// khai bao bien.
	var success = function(response) {
		var obj = jQuery.parseJSON(response);

		$('#example').dataTable({
			"aaData" : obj,
			"aoColumns" : [ {
				"mDataProp" : "providerID"
			}, {
				"mDataProp" : "providerName"
			}, {
				"mDataProp" : "address"
			}, {
				"mDataProp" : "email"
			}, {
				"mDataProp" : "description"
			} ]
		});

		// hide show entri.
		$('#example_length').hide();
		$('#example_info').hide();
		
	};

	// dinh nghia ham error
	var error = function() {
		alert("Can't get list Product Component!");
	};
	var ajaxObject = {
		url : 'getProductComponent',
		type : 'POST',
		success : success,
		error : error
	};
	// Thuc thi ajax
	$.ajax(ajaxObject);
});