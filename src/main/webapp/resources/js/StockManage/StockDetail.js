/**
 * 
 */
$(function() {

	// on load
	$('#btnEdit').css('display', 'none');

	// event on page
	$("#btnEdit").click(function() {

		$('#btnEdit').css('display', 'none');
		$('#btnSave').css('display', 'inline-block');
		$('.input-info').prop("disabled", false);
	});

	$("#btnCancel").click(function() {
		window.location = "product";

	});

	$("#btnSave").click(function() {

		// validate input data
		if ($("#inputStockName").val() == "") {
			alert("Please insert value for Stock Name field!");
			return;
		}
		if ($("#inputAddress").val() == "") {
			alert("Please insert value for Stock Name field!");
			return;
		}
		if ($("#inputSize").val() <= 0) {
			alert("Please insert value more than 0 for Size field!");
			return;
		}
		
		if ($("#inputDescription").val() == "") {
			alert("Please insert value for Stock Name field!");
			return;
		}

		var stock = {
			"stockID" : $("#stockIDHidden").val(),
			"stockName" : $("#inputStockName").val(),
			"managerID" : $("#listStaff option:selected").attr('data-id').trim(),
			"address" : $("#inputAddress").val(),
			"size" : $("#inputSize").val(),
			"description" : $("#inputDescription").val(),
			"isEdit" : $("#isEdit").val()
		};
		var data = {};
		data[0] = JSON.stringify(stock);

		$.ajax({
			type : "POST",
			url : "saveStock",
			data : data,
			dataType : "json",
			success : function(data) {
				if (data.result == "1") {
					
					//set is further process is edit
					$("#isEdit").val(1);
					alert("Save successful!");
					
					// disable all input
					$('#btnEdit').css('display', 'inline-block');
					$('#btnSave').css('display', 'none');
					$('.input-info').prop("disabled", true);
					
					//navigate to stock list
					window.location = "listStock";
				} else if(data.result == "2"){
					alert("Updated successful!");
					
					// disable all input
					$('#btnEdit').css('display', 'inline-block');
					$('#btnSave').css('display', 'none');
					$('.input-info').prop("disabled", true);
					
					//navigate to stock list
					window.location = "listStock";
				} else {
					alert("Save Fail!");
				}
			},
			error : function(status) {
				console.log(status);
			}
		});
	});

});