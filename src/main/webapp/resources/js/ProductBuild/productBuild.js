$(document).ready(function() {
	
	// Date picker
	$('#sandbox-container').datepicker({
		format: "mm/dd/yyyy"
	});
	
	// Product select change
    $("#select_productN").change(function(){
    	// get value of ProductID
    	var productID = $(this).find(':selected').data('value').trim();
    	
    	// calling Ajax
    	// khai bao bien.
    	var success = function(response) {
    		var obj = jQuery.parseJSON(response);

    		$('#tableComponent').dataTable({
    			"aaData" : obj,
    			"aoColumns" : [ {
    				"mDataProp" : "componentID.productID"
    			}, {
    				"mDataProp" : "componentID.productName"
    			}, {
    				"mDataProp" : "quantity"
    			}, {
    				"mDataProp" : "price"
    			}, {
    				"mDataProp" : "price"
    			} ]
    		});

    		// hide show entri.
    		$('#tableComponent_length').hide();
    		$('#tableComponent_info').hide();
    		
    	};

    	// dinh nghia ham error
    	var error = function() {
    		alert("Can't get list Product Component!");
    	};
    	var ajaxObject = {
    		url : 'getProductComponent',
    		data: { 
    	        'productID' : productID
    	    },
    		type : 'POST',
    		success : success,
    		error : error
    	};
    	// Thuc thi ajax
    	$.ajax(ajaxObject);
    });

});