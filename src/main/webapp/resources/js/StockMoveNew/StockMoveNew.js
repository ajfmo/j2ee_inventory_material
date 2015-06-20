/**
 * 
 */
$(function() {
	$('#sandbox-container input').datepicker({
		format : "dd/mm/yyyy"
	});

	var d = new Date();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	var output = (day < 10 ? '0' : '') + day + '/' + (month < 10 ? '0' : '')
			+ month + '/' + d.getFullYear();
	$("#sandbox-container input").val(output);
	$("#quantity").val(1);

	$('#btnEdit').css('display', 'none');
	$("#btnEdit").click(function() {
		$('.input-info').prop("disabled", false);
		$('#btnEdit').css('display', 'none');
		$('#btnSave').css('display', 'inline-block');
	});
	$("#btnSave").click(function() {

		if ($("#quantity").val() < 1) {
			alert("Quantity must more than 0");
		}

		var stockMove = {
			"product" : $("#product").val(),
			"expectedDay" : $("#expectedDay").val(),
			"quantity" : $("#quantity").val(),
			"priority" : $("#priority").val(),
			"fromStock" : $("#fromStock").val(),
			"toStock" : $("#toStock").val(),
			"description" : $("#description").val()
		};

		var data = {};
		data[0] = JSON.stringify(stockMove);

		if ($("#fromStock").val() != $("#toStock").val()) {
			$('.input-info').prop("disabled", true);
			$('#btnSave').css('display', 'none');
			$('#btnEdit').css('display', 'inline-block');
			$.ajax({
				type : "POST",
				url : "saveNewStockMove",
				data : data,
				dataType : "json",
				success : function(data) {
					if (data.result == "1") {
						alert("Successful!");
					} else {
						alert("Failed :( !");
					}
				},
				error : function(status){
	                console.log(status);
	            }
			});
		} else {
			alert("Invalid Destination Location");
			return false;
		}

	});
});