<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="product" content="Metro UI CSS Framework">
<meta name="description" content="Simple responsive css framework">
<meta name="author" content="Sergey S. Pimenov, Ukraine, Kiev">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/metro-bootstrap.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/metro-bootstrap-responsive.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/iconFont.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/docs.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/stockInward.css" />" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/prettify.css" />" type="text/css">
	
	<!-- add one of the jQWidgets styles -->
    <link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.darkblue.css" />" type="text/css">
	<!-- add one of the jQWidgets styles -->
    <link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" type="text/css">

<!-- Load JavaScript Libraries -->
<script src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.widget.min.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.mousewheel.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/prettify/prettify.js" />"
	type="text/javascript"></script>
	
	<!-- add the jQWidgets framework -->
    <script src="<c:url value="/resources/jqwidgets/jqxcore.js" />"
	type="text/javascript"></script>
    <!-- add one or more widgets -->
    <script src="<c:url value="/resources/jqwidgets/jqx-all.js" />"
	type="text/javascript"></script>
	<!-- add one or more widgets -->
    <script src="<c:url value="/resources/jqwidgets/globalization/globalize.js" />"
	type="text/javascript"></script>
	<!-- add one or more widgets -->
    <script src="<c:url value="/resources/js/demos.js" />"
	type="text/javascript"></script>
	<!-- add one or more widgets -->
    <script src="<c:url value="/resources/js/generatedata.js" />"
	type="text/javascript"></script>

<!-- Metro UI CSS JavaScript plugins -->
<script src="<c:url value="/resources/js/metro.min.js" />"
	type="text/javascript"></script>

<!-- Local JavaScript -->
<script src="<c:url value="/resources/js/docs.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/github.info.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/StockInward.js" />"
	type="text/javascript"></script>


<script type="text/javascript">
        $(document).ready(function () {
            // prepare the data
            var data = generatedata(200);
            var source =
            {
                localdata: data,
                datatype: "array",
                updaterow: function (rowid, rowdata, commit) {
                    // synchronize with the server - send update command
                    // call commit with parameter true if the synchronization with the server is successful 
                    // and with parameter false if the synchronization failder.
                    commit(true);
                },
                datafields:
                [
                    { name: 'firstname', type: 'string' },
                    { name: 'lastname', type: 'string' },
                    { name: 'productname', type: 'string' },
                    { name: 'available', type: 'bool' },
                    { name: 'quantity', type: 'number' },
                    { name: 'price', type: 'number' },
                    { name: 'date', type: 'date' }
                ]
            };
            var dataAdapter = new $.jqx.dataAdapter(source);
            // initialize jqxGrid
            $("#jqxgrid").jqxGrid(
            {
                width: 850,
                source: dataAdapter,
                editable: true,
                selectionmode: 'singlerow',
                editmode: 'selectedrow',
                columns: [
                  { text: 'First Name', columntype: 'textbox', datafield: 'firstname', width: 80 },
                  { text: 'Last Name', datafield: 'lastname', columntype: 'textbox', width: 80 },
                  { text: 'Product', columntype: 'dropdownlist', datafield: 'productname', width: 195 },
                  { text: 'Available', datafield: 'available', columntype: 'checkbox', width: 67 },
                  {
                      text: 'Ship Date', datafield: 'date', columntype: 'datetimeinput', width: 110, align: 'right', cellsalign: 'right', cellsformat: 'd',
                  validation: function (cell, value) {
                          if (value == "")
                             return true;
                          var year = value.getFullYear();
                          if (year >= 2015) {
                              return { result: false, message: "Ship Date should be before 1/1/2015" };
                          }
                          return true;
                      }
                  },
                  {
                      text: 'Quantity', datafield: 'quantity', width: 70, align: 'right', cellsalign: 'right', columntype: 'numberinput',
                      validation: function (cell, value) {
                          if (value < 0 || value > 150) {
                              return { result: false, message: "Quantity should be in the 0-150 interval" };
                          }
                          return true;
                      },
                      createeditor: function (row, cellvalue, editor) {
                          editor.jqxNumberInput({ decimalDigits: 0, digits: 3 });
                      }
                  },
                  { text: 'Price', datafield: 'price', align: 'right', cellsalign: 'right', cellsformat: 'c2', columntype: 'numberinput',
                      validation: function (cell, value) {
                          if (value < 0 || value > 15) {
                              return { result: false, message: "Price should be in the 0-15 interval" };
                          }
                          return true;
                      },
                      createeditor: function (row, cellvalue, editor) {
                          editor.jqxNumberInput({ digits: 3 });
                      }
                  }
                ]
            });
            // events
            var rowValues = "";
            $("#jqxgrid").on('cellbeginedit', function (event) {
                var args = event.args;
                if (args.datafield === "firstname") {
                    rowValues = "";
                }
                rowValues += args.value.toString() + "    ";
                if (args.datafield === "price") {
                    $("#cellbegineditevent").text("Begin Row Edit: " + (1 + args.rowindex) + ", Data: " + rowValues);
                }
            });
            $("#jqxgrid").on('cellendedit', function (event) {
                var args = event.args;
                if (args.datafield === "firstname") {
                    rowValues = "";
                }
                rowValues += args.value.toString() + "    ";
                if (args.datafield === "price") {
                    $("#cellbegineditevent").text("End Row Edit: " + (1 + args.rowindex) + ", Data: " + rowValues);
                }
            });            
        });
    </script>


</head>
<body class='default'>
    <div id='jqxWidget'>
        <div id="jqxgrid"></div>
        <div style="font-size: 12px; font-family: Verdana, Geneva, 'DejaVu Sans', sans-serif; margin-top: 30px;">
            
            <div id="cellbegineditevent"></div>
            <div style="margin-top: 10px;" id="cellendeditevent"></div>
       </div>
    </div>
</body>
</html>