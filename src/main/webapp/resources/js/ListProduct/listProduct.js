$(document).ready(function() {
	
	 var oTable = $('#tableProduct').dataTable();
	 
	 // diable button create component
	 $('#createComponent').addClass("disabled");
	 
	// get list product
	var success = function(response) {
		if (response != "") {
			var objJson = jQuery.parseJSON(response);
			$('#tableProduct').dataTable().fnDestroy();
			$('#tableProduct').dataTable({
		        //"info":     false,
		        //"bLengthChange": false, //used to hide the property 
    			"aaData" : objJson,
    			"aoColumns" : [ {
    				"mDataProp" : "productID"
    			}, {
    				"mDataProp" : "productName"
    			}, {
    				"mDataProp" : "unitID.unitName"
    			}, {
    				"mDataProp" : "manufactureID.name"
    			}, {
    				"mDataProp" : "salePrice"
    			}, {
    				"mDataProp" : "orgPrice"
    			}, {
    				"mDataProp" : "typeID.typeName"
    			}, {
    				"mDataProp" : "minStock"
    			}, {
    				"mDataProp" : "maxStock"
    			} ]
    		});
		} else {
			oTable.fnClearTable();
    		$('#tableProduct').dataTable({
    		}).fnDestroy();
		}
	};

	// dinh nghia ham error
	var error = function() {
		alert("Can't get list Product!");
	};
	var ajaxObject = {
		url : 'getListProduct',
		type : 'POST',
		success : success,
		error : error
	};
	// calling
	$.ajax(ajaxObject);
	
	// select row function
	$('body').on("click", '#tableProduct tbody tr' ,function () {
	    if ($(this).hasClass('selected')) {
	    	$(this).removeClass('selected');
	    	$('#createComponent').addClass("disabled");
	    }
	    else {
	        $(this).siblings('.selected').removeClass('selected');
	        $(this).addClass('selected');
	        
	        $('#createComponent').removeClass("disabled");
	        // get row index
	        var tr = $(this).closest("tr");
	        var rowindex = tr.index();
	        
	        // get Product Type
	        var productType = oTable.fnGetData( rowindex, 6
	        		);
	        
	        // get productID
	        var productID = oTable.fnGetData( rowindex, 0 );
	        
	        //alert(productID);
	        
	    }
    } );
	
});