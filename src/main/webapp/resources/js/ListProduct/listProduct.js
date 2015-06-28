var oTable;
$(document).ready(function() {
	
	oTable = $('#tableProduct').dataTable();
	
	var productID = null;
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
	    }
    } );
	
	// Product with component
	var i = $('#tbData tr').length;
	//deletes the selected table rows
	$(".delete").on('click', function() {
		i --;
		$('.case:checkbox:checked').parents("tr").remove();
		$('#check_all').prop("checked", false); 
	});

	////to check all checkboxes
	$(document).on('change','#check_all',function(){
		$('input[class=case]:checkbox').prop("checked", $(this).is(':checked'));
	});
	
	//adds extra table rows
	$(".addmore").on('click',function(){
		
		count = $('#tbData tr').length;
		var productID = 'productID_' + (count - 1); 
		var productIDValue = $('#' + productID).val();
		
		if (count <= 1 || productIDValue) {
			//
			var html = loadData(count, i);
			$('#tbData').append(html);
			i++;
		}

	});
	
    var array;
    function getData() {

    	//var ID = request;
        $.ajax({
        	type: 'POST',
            url: './getProduct',
            dataType: 'json',
            data: {},
            success: function(response) {
                array = $.map(response, function(item) {
                    var code = item.split("|");
                    return {
                        label: code[autoTypeNo],
                        value: code[autoTypeNo],
                        data: item
                    }
                });
            },
            error : function(xhr, status){
                console.log(status);
            }
            
        });
        return false;
    }
    
    //auto-complete script
    $(document).on('focus','.searchName',function(){
    	type = $(this).data('type');

    	if(type =='componentID' )autoTypeNo=0;
    	if(type =='componentName' )autoTypeNo=1; 	

        $(this).autocomplete({
            minLength: 0,
            source: function(request, response) {
            	
            	// check request
            	if (request != null || request != "") {
                    getData();
                    //call the filter here
                    if (array != null) {
                        response($.ui.autocomplete.filter(array, request.term));
    				}
				}
            	
            },
            focus: function() {
                // prevent value inserted on focus
                return false;
            },
    		select: function( event, ui ) {
    			var names = ui.item.data.split("|");						
    			id_arr = $(this).attr('id');
    	  		id = id_arr.split("_");
    			elementId = id[id.length - 1];
    			$('#componentID_'+elementId).val(names[0]);
    			$('#componentName_'+elementId).val(names[1]);
    		}	
        });

        $.ui.autocomplete.filter = function(array, term) {
            var matcher = new RegExp("^" + $.ui.autocomplete.escapeRegex(term), "i");
            return $.grep(array, function(value) {
                return matcher.test(value.label || value.value || value);
            });
        };
    });
    
	//save product Component
	$("#saveProductComponent").on('click',function(){		
		var TableData = new Array();
		var idx = 1;
		$('#tbData tr').each(function(row, tr){

			var productIDCompo = productID;
			var compoID = "#componentID_"+ idx;
			var quantity = "#quantity_" + idx;
			
			if ($(compoID).val()) {
				TableData[row]={
			        "productID" : productIDCompo
			        ,"componentID" : $(compoID).val()
			        , "quantity": $(quantity).val()
			    }
			}
			idx++;
		});
		
		// call ajax to save data
		var data = {};
		if (!jQuery.isEmptyObject(TableData)) {
			data[0] = JSON.stringify(TableData);
			$.ajax({
	        	type: 'POST',
	            url: './saveProductComponent',
	            dataType: 'json',
	            data: data,
	            success: function(response) {
	                $('#component').modal('toggle');
	            },
	            error : function(xhr, status){
	                console.log(status);
	            }
	            
	        });
		}
	});
	
	// When component PopUp is hidden.
	$('#component').on('hidden.bs.modal', function (e) {
		// clear table body...
		$("#tbData > tbody").html("");
	});

		// When component PopUp is show.
		$('#component').on('show.bs.modal', function (e) {
			
			// get productType and productID
			var anSelected = fnGetSelected( oTable );
			var productType = oTable.fnGetData( anSelected[0], 6 );
			if (productType != 'Chi tiết') {

				productID = oTable.fnGetData( anSelected[0], 0 );
				// check if have data
		        $.ajax({
		        	type: 'POST',
		            url: './getProductComponent',
		            dataType: 'json',
		    		data: { 
		    	        'productID' : productID
		    	    },
		            success: function(response) {
		            	var html = "";
		            	for (var i = 0; i < response.length; i++) {
		        			html = "<tr id='row_" + (i + 1) + "'>";
		        			html += "<td><input class='case' type='checkbox'/></td>";
		        			html += "<td><span id='snum" + (i + 1) + "'>" + (i + 1) + ".</span></td>";
		        			html += "<td><input readonly='readonly' value='" + response[i].componentID.productID + "' type='text' data-type='componentID' name='componentID[]' id='componentID_"+(i + 1)+"' class='form-control searchID' autocomplete='off'></td>";
		        			html += "<td><input type='text' value='" + response[i].componentID.productName + "' data-type='componentName' name='componentName[]' id='componentName_"+(i + 1)+"' class='form-control searchName' autocomplete='off'></td>";
		        			html += "<td><input type='number' value='" + response[i].quantity + "' name='quantity[]' id='quantity_"
		        				+ (i + 1)
		        				+ "' class='form-control changesNo' autocomplete='off' onkeypress='return IsNumeric(event);' ondrop='return false;' onpaste='return false;' min='1' max='20'></td>";
		        			html += "</tr>";
		                    $('#tbData').append(html);
		                }
		            },
		            error : function(xhr, status){
		                console.log(status);
		            }
		        });
			} else{
				BootstrapDialog.show({
	                type: BootstrapDialog.TYPE_WARNING,
	                title: 'WARNING',
	                message: 'Can not add component for this product!'
	            });     
				e.preventDefault();
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
/* Get the rows which are currently selected */
function fnGetSelected( oTableLocal ){
    return oTableLocal.$('tr.selected');
}
