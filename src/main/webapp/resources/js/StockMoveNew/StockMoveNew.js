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
	var output = (month < 10 ? '0' : '') + month + '/' + (day < 10 ? '0' : '')
			+ day + '/' + d.getFullYear();
	$("#sandbox-container input").val(output);
	$("#quantity").val(1);

	$('#btnEdit').css('display', 'none');
	$("#btnEdit").click(function() {
		$('.input-info').prop("disabled", false);
		$('#btnEdit').css('display', 'none');
		$('#btnSave').css('display', 'inline-block');
	});
	
	$("#btnProcessLater").click(function() {

		if ($("#quantity").val() < 1) {
			alert("Quantity must more than 0");
		} else {

			var stockMove = {
				"product" : $("#product").val(),
				"expectedDay" : $("#expectedDay").val(),
				"quantity" : $("#quantity").val(),
				"priority" : $("#priority").val(),
				"fromStock" : $("#fromStock").val(),
				"toStock" : $("#toStock").val(),
				"description" : $("#description").val(),
				"latestID" : $("#latestID").val()
			};

			var data = {};
			data[0] = JSON.stringify(stockMove);

			if ($("#fromStock").val() != $("#toStock").val()) {
				$('.input-info').prop("disabled", true);
				$('#btnSave').css('display', 'none');
				$('#btnEdit').css('display', 'inline-block');
				$.ajax({
					type : "POST",
					url : "processLater",
					data : data,
					dataType : "json",
					success : function(data) {
						if (data.result == "1") {
							window.location = "stockMoveWaiting";
						} else if (data.result == "2") {
							window.location = "stockMoveWaiting";
						} else {
							alert("Failed :( !");
						}
					},
					error : function(status) {
						console.log(status);
					}
				});
			} else {
				alert("Invalid Destination Location");
				return false;
			}
		}

	});
	
	$("#btnSave").click(function() {

		if ($("#quantity").val() < 1) {
			alert("Quantity must more than 0");
		} else {

			var stockMove = {
				"product" : $("#product").val(),
				"expectedDay" : $("#expectedDay").val(),
				"quantity" : $("#quantity").val(),
				"priority" : $("#priority").val(),
				"fromStock" : $("#fromStock").val(),
				"toStock" : $("#toStock").val(),
				"description" : $("#description").val(),
				"latestID" : $("#latestID").val()
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
							alert("Create new bill successful!");
						} else if (data.result == "2") {
							alert("Update new bill successful!");
						} else {
							alert("Failed :( !");
						}
					},
					error : function(status) {
						console.log(status);
					}
				});
			} else {
				alert("Invalid Destination Location");
				return false;
			}
		}

	});
});