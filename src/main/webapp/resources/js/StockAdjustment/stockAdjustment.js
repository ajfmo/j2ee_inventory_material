var oTable;
$(document).ready(function() {
	oTable = $('#tableInven').dataTable();

	var stockID = null;
	
	// get list product
	var success = function(response) {
		if (response != "") {
			var objJson = jQuery.parseJSON(response);
			$('#tableInven').dataTable().fnDestroy();
			$('#tableInven').dataTable({
		        "info":     false,
		        "bLengthChange": false, // used to hide the property
	   			"aaData" : objJson,
	   			"aoColumns" : [ {
	   				"mData" : "productID.productID"
	   			}, {
	   				"mData" : "productID.productName"
	   			}, {
					"mData" : null, 'mRender': function() {
						return '<input type="number" class="Q"/>';				    				
					}
	   			}, {
	   				"mData" : "quantity"
	   			}, {
	   				"mData" : null, 'mRender': function() {
						return '<input disabled class="form-control" type="text">';
	   				}
	   			}, {
	   				"mData" : "price"
	   			}, {
	   				"mData" : null, 'mRender': function() {
						return '<input disabled class="form-control" type="text">';				    				
					}
	   			}]
   		});
		} else {
			oTable.fnClearTable();
			$('#tableInven').dataTable().fnDestroy();
		}
	};
	
	// dinh nghia ham error
	var error = function() {
		alert("Can't get list Product!");
	};
	
	var ajaxObject = {
		url : 'getListStockAdjustment',
		type : 'POST',
		success : success,
		error : error
	};
	
	// calling
	$.ajax(ajaxObject);
	
	// select row function
	$('body').on("click", '#tableInven tbody tr' ,function () {
	    if ($(this).hasClass('selected')) {
	    	$(this).removeClass('selected');
	    }
	    else {
	        $(this).siblings('.selected').removeClass('selected');
	        $(this).addClass('selected');
			var anSelected = fnGetSelected( oTable );
			var productType = oTable.fnGetData( anSelected[0], 2 );
			alert(productType)
	    }
    } );
});
/* Get the rows which are currently selected */
function fnGetSelected( oTableLocal ){
    return oTableLocal.$('tr.selected');
}