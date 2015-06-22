$(document).ready(function() {
	
	// Date picker
	$('#sandbox-container').datepicker({
		format: "mm/dd/yyyy"
	});
	
	
	// variable datatable
	var oTable = $("#tableComponent").dataTable({
		"info":     false,
        "bLengthChange": false
	});
	var objJson = null;
	var tableData = null;
	// Product select change
    $("#select_productN").change(function(){
    	// get value of ProductID
    	var productID = $(this).find(':selected').data('value').trim();
    	
    	// reset quantity value
    	$("#quantity").val('1');
    	
    	// calling Ajax
    	var success = function(response) {
    		if (response != "") {
    			objJson = jQuery.parseJSON(response);
    			tableData = jQuery.parseJSON(response);
    			$('#tableComponent').dataTable().fnDestroy();
    			$('#tableComponent').dataTable({
    		        "info":     false,
    		        "bLengthChange": false, //used to hide the property 
        			"aaData" : objJson,
        			"aoColumns" : [ {
        				"mDataProp" : "componentID.productID"
        			}, {
        				"mDataProp" : "componentID.productName"
        			}, {
        				"mDataProp" : "quantity"
        			}, {
        				"mDataProp" : "price"
        			}, {
        				"mDataProp" : "quantity"
        			} ]
        		});
    		} else {
    			oTable.fnClearTable();
        		$('#tableComponent').dataTable({
        			"info":     false,
    		        "bLengthChange": false
        		}).fnDestroy();
    		}
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
    	
    	// get Product information
    	$.ajax({
    		url: "getProductInfor",
    		data: { 
    	        'productID' : productID
    	    },
    	    dataType: 'json',
    	    type: 'POST',
    	    success: function(response) {
    	    	//var data = jQuery.parseJSON(response);
    			$('#unitPrice').val(response['salePrice']);
    			var price = $('#unitPrice').val();
    			var quantity = $('#quantity').val();
    			if( quantity!='' && price !='' ) $('#subTotal').val( (parseFloat(price)*parseFloat(quantity)) );
    		}
    	});
    });
    
    $("#quantity").bind('keyup mouseup', function () {
		var price = $('#unitPrice').val();
		var quantity = $('#quantity').val();
		if( quantity!='' && price !='' ) $('#subTotal').val( (parseFloat(price)*parseFloat(quantity)) );
		
		var rowCount = oTable.fnSettings().fnRecordsTotal();
		for(var i = 0; i < rowCount; i++){
			
			var quantityCompo = tableData[i].quantity;
			var priceCompo = tableData[i].price;
			
			oTable.fnUpdate((parseInt(quantityCompo)*parseInt(quantity)), parseInt(i), 2);

			var afterQuatity = oTable.fnGetData( i, 2 );
			oTable.fnUpdate((parseInt(afterQuatity)*parseFloat(priceCompo)), parseInt(i), 4);
		}
    });
});

//It restrict the non-numbers
var specialKeys = new Array();
specialKeys.push(8,46); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    return ret;
}