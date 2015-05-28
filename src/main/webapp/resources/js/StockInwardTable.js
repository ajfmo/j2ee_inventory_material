/**
 * @author: thaint
 */

$(document).ready(function() {
	var i = $('#tbData tr').length;
	calculateTotal();
	//deletes the selected table rows
	$(".delete").on('click', function() {
		i --;
		$('.case:checkbox:checked').parents("tr").remove();
		$('#check_all').prop("checked", false); 
		calculateTotal();
	});

	////to check all checkboxes
	$(document).on('change','#check_all',function(){
		$('input[class=case]:checkbox').prop("checked", $(this).is(':checked'));
	});
	
	////price change
	$(document).on('change keyup blur','.changesNo',function(){
		id_arr = $(this).attr('id');
		id = id_arr.split("_");
		quantity = $('#quantity_'+elementId).val();
		price = $('#price_'+elementId).val();
		if( quantity!='' && price !='' ) $('#total_'+elementId).val( (parseFloat(price)*parseFloat(quantity)).toFixed(2) );	
		calculateTotal();
	});
	
	//adds extra table rows
	$(".addmore").on('click',function(){
		
		count = $('#tbData tr').length;
		var productID = 'productID_' + (count - 1); 
		var productIDValue = $('#' + productID).val();
		
		if (count <= 1 || productIDValue) {
			//
			var html =loadData(count, i);
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
    $(".searchID").change(function(){
    	type = $(this).data('type');

    	if(type =='productID' )autoTypeNo=0;
    	if(type =='productName' )autoTypeNo=1; 	

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
    			$('#productID_'+elementId).val(names[0]);
    			$('#productName_'+elementId).val(names[1]);
    			$('#unitName_'+elementId).val(names[2]);
    			$('#price_'+elementId).val(names[3]);
    			$('#total_'+elementId).val( 1*names[3] );
    			calculateTotal();
    		}	
        });

        $.ui.autocomplete.filter = function(array, term) {
            var matcher = new RegExp("^" + $.ui.autocomplete.escapeRegex(term), "i");
            return $.grep(array, function(value) {
                return matcher.test(value.label || value.value || value);
            });
        };
    });
    
    //auto-complete script
    $(document).on('focus','.searchName',function(){
    	type = $(this).data('type');

    	if(type =='productID' )autoTypeNo=0;
    	if(type =='productName' )autoTypeNo=1; 	

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
    			$('#productID_'+elementId).val(names[0]);
    			$('#productName_'+elementId).val(names[1]);
    			$('#unitName_'+elementId).val(names[2]);
    			$('#price_'+elementId).val(names[3]);
    			$('#total_'+elementId).val( 1*names[3] );
    			calculateTotal();
    		}	
        });

        $.ui.autocomplete.filter = function(array, term) {
            var matcher = new RegExp("^" + $.ui.autocomplete.escapeRegex(term), "i");
            return $.grep(array, function(value) {
                return matcher.test(value.label || value.value || value);
            });
        };
    });
});
//total price calculation 
function calculateTotal(){
	subTotal = 0 ; amountTotal = 0; 
	$('.totalLinePrice').each(function(){
		if($(this).val() != '' )subTotal += parseFloat( $(this).val() );
	});
	$('#subTotal').val( subTotal.toFixed(2) );
	
	$('.changesNo').each(function(){
		if($(this).val() != '' )amountTotal += parseFloat( $(this).val() );
	});
	$('#amountTotal').val( amountTotal.toFixed(2) );
}
//It restrict the non-numbers
var specialKeys = new Array();
specialKeys.push(8,46); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode;
    console.log( keyCode );
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    return ret;
}

