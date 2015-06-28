/**
 * 
 */
//It restrict the non-numbers
var specialKeys = new Array();
specialKeys.push(8,46); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    return ret;
}

$(function() {

	// on load
	$('#btnEdit').css('display', 'none');

	// event on page
	$('#i_file').change( function(event) {
	    var tmppath = URL.createObjectURL(event.target.files[0]);

	    //$("#disp_tmp_path").html("["+tmppath+"]");
	    var imgBase64 = getBase64Image(URL.createObjectURL(event.target.files[0]));
	    
	    abf(imgBase64);
	});
	
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
		if ($("#inputProduct").val() == "") {
			alert("Please insert value for Product field!");
			return;
		}
		if ($("#inputOrgPrice").val() < 0) {
			alert("Please insert value more than or equals to 0 for Origin Price field!");
			return;
		}
		if ($("#inputMinStock").val() < 0) {
			alert("Please insert value more than or equals to 0 for Min Stock field!");
			return;
		}
		if ($("#inputMaxStock").val() <= $("#inputMinStock").val()) {
			alert("Max stock must more than min stock!");
			return;
		}

		// disable all input
		$('#btnEdit').css('display', 'inline-block');
		$('#btnSave').css('display', 'none');
		$('.input-info').prop("disabled", true);

		var product = {
			"productID" : $("#productIDHidden").val(),
			"productName" : $("#inputProduct").val(),
			"orgPrice" : $("#inputOrgPrice").val(),
			"productTypeID" : $("#listProductType option:selected").attr('data-id').trim(),
			"productUnitID" : $("#listProductUnit option:selected").attr('data-id').trim(),
			"manufactureID" : $("#listManufacture option:selected").attr('data-id').trim(),
			"providerID" : $("#listProvider option:selected").attr('data-id').trim(),
			"minStock" : $("#inputMinStock").val(),
			"maxStock" : $("#inputMaxStock").val(),
			"description" : $("#inputDescription").val(),
			"isEdit" : $("#isEdit").val()
		};
		var data = {};
		data[0] = JSON.stringify(product);

		$.ajax({
			type : "POST",
			url : "saveProduct",
			data : data,
			dataType : "json",
			success : function(data) {
				if (data.result == "1") {
					
					//set is further process is edit
					$("#isEdit").val(1);
					alert("Save successful!");
					window.location = "product";
				} else if(data.result == "2"){
					alert("Updated successful!");
					window.location = "product";
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

function getBase64Image(imgURL) {
    imgsss = new Image();
    imgsss.src = imgURL;
    alert(imgsss);
    // Create an empty canvas element
    var canvas = document.createElement("canvas");
    canvas.width = imgsss.width;
    canvas.height = imgsss.height;
    // Copy the image contents to the canvas
    var ctx = canvas.getContext("2d");
    ctx.drawImage(imgsss, 0, 0);
    var dataURL = canvas.toDataURL("image/png");

    return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
}

function abf(imgBase64) {
  $("#productImage").fadeIn("fast").attr('src', "data:image/(jpg|png);base64," + imgBase64);
}