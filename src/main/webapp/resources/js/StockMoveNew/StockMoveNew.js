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
	$('#btnCheckAvailable').css('display', 'none');
	
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
						if (data.result == "1" || data.result == "2") {
							//change status to waiting available
							$("#sttNew").removeClass("active");
							$("#sttWaiting").addClass("active");
							$("#curStatus").val(2);
							//change button
							$("#btnProcessLater").css('display', 'none');
							$('#btnCheckAvailable').css('display', 'inline-block');
							
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
	
	$("#btnCheckAvailable").click(function() {

		if ($("#quantity").val() < 1) {
			alert("Quantity must more than 0");
		} else {

			var stockMove = {
				"product" : $("#product").val(),
				"quantity" : $("#quantity").val(),
				"fromStock" : $("#fromStock").val(),
				"toStock" : $("#toStock").val()
			};

			var data = {};
			data[0] = JSON.stringify(stockMove);

			if ($("#fromStock").val() != $("#toStock").val()) {
				$('.input-info').prop("disabled", true);
				$('#btnSave').css('display', 'none');
				$('#btnEdit').css('display', 'inline-block');
				$.ajax({
					type : "POST",
					url : "checkAvailable",
					data : data,
					dataType : "json",
					success : function(data) {
						if (data.result == "1") {
							
							//yes, this product is available in fromStock
							//update status in database
							$.ajax({
								type : "POST",
								url : "updateToAvailable",
								data : { "stockTransferID" : $("#latestID").val() },
								dataType : "json",
								success : function(data) {
									if (data.result == "1") {
										//change status to available
										$("#sttWaiting").removeClass("active");
										$("#sttAvailable").addClass("active");
										$("#curStatus").val(3);
										$("#btnCheckAvailable").css('display', 'none');
									} else {
										alert("Update available failed :( !");
									}
								},
								error : function(status) {
									console.log(status);
								}
							});
							
						} else if(data.result == -1){
							
							//warning lower than min stock
							alert("If move, product in source stock will be lower than min value!");
						} else {
							
							//not available
							alert("Product is not enough in source stock!");
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
	
	//btn process entirely
	$("#btnProcessAll").click(function() {

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
				"latestID" : $("#latestID").val(),
				"curStatus" : $("#curStatus").val()
			};

			var data = {};
			data[0] = JSON.stringify(stockMove);

			if ($("#fromStock").val() != $("#toStock").val()) {
				$('.input-info').prop("disabled", true);
				$('#btnSave').css('display', 'none');
				$('#btnEdit').css('display', 'inline-block');
				$.ajax({
					type : "POST",
					url : "processAll",
					data : data,
					dataType : "json",
					success : function(data) {
						if (data.result == "success") {
							//change status to DONE
							$("#sttNew").removeClass("active");
							$("#sttWaiting").removeClass("active");
							$("#sttAvailable").removeClass("active");
							$("#sttDone").addClass("active");
							$("#curStatus").val(4);
							$("#btnCheckAvailable").css('display', 'none');
							$("#btnProcessLater").css('display', 'none');
							$("#btnProcessAll").css('display', 'none');
							$("#btnCancelMove").css('display', 'none');
						} else if (data.result == "lower"){

							//warning lower than min stock
							alert("If move, product in source stock will be lower than min value!");
							
							//change status to DONE
							$("#sttNew").removeClass("active");
							$("#sttWaiting").removeClass("active");
							$("#sttAvailable").removeClass("active");
							$("#sttDone").addClass("active");
							$("#curStatus").val(4);
							$("#btnCheckAvailable").css('display', 'none');
							$("#btnProcessLater").css('display', 'none');
							$("#btnProcessAll").css('display', 'none');
							$("#btnCancelMove").css('display', 'none');
						} else {
							
							//notAvailable
							alert("Product is not enough in source stock!");
						}
					},
					error : function(status) {
						
						//notAvailable
						alert("Failed :( !");
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