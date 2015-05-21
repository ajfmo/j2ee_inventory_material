<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">

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
	href="<c:url value="/resources/jqwidgets/styles/jqx.office.css" />"
	type="text/css">
<!-- add one of the jQWidgets styles -->
<link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />"
	type="text/css">

<!-- Load JavaScript Libraries -->
<script
	src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
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
<script
	src="<c:url value="/resources/jqwidgets/globalization/globalize.js" />"
	type="text/javascript"></script>
<!-- add one or more widgets -->
<script
	src="<c:url value="/resources/jqwidgets/globalization/globalize.culture.vi.js" />"
	type="text/javascript"></script>
<!-- add one or more widgets -->
<script
	src="<c:url value="/resources/jqwidgets/globalization/globalize.culture.vi-VNs.js" />"
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
<%-- <script src="<c:url value="/resources/js/StockInward.js" />" --%>
<!-- 	type="text/javascript"></script> -->


<script type="text/javascript">
	$(document).ready(function() {
		// prepare the data
		//var data = generatedata(200);
		//             var source =
		//             {
		//                 url: "./getProvider",
		//                 datatype: "json",
		//                 updaterow: function (rowid, rowdata, commit) {
		//                     // synchronize with the server - send update command
		//                     // call commit with parameter true if the synchronization with the server is successful 
		//                     // and with parameter false if the synchronization failder.
		//                     commit(true);
		//                 },
		//                 datafields:
		//                 [
		//                     { name: 'ProviderID', type: 'number' },
		//                     { name: 'ProviderName', type: 'string' },
		//                     { name: 'Address', type: 'string' },
		//                     { name: 'Tel', type: 'number' },
		//                     { name: 'Email', type: 'string' },
		//                     { name: 'Website', type: 'string' },
		//                     { name: 'Description', type: 'string' }
		//                 ]
		//             };
		var source =
		{
			url: "./getProvider",
		    datatype: "json",
		    updaterow: function (rowid, rowdata, commit) {
            // synchronize with the server - send update command
           // call commit with parameter true if the synchronization with the server is successful 
           // and with parameter false if the synchronization failder.
            commit(true);
                },
		    datafields: [
		        { name: 'providerID' },
		        { name: 'providerName' },
		        { name: 'address' },
		        { name: 'tel' },
		        { name: 'email' },
		        { name: 'website' },
		        { name: 'description' }
		    ]
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
		// initialize jqxGrid
		$("#jqxgrid").jqxGrid({
			width : 850,
			source : dataAdapter,
 			editable : true,
 			selectionmode : 'singlerow',
 			editmode : 'selectedrow',
			columns : [ {
				text : 'providerID',
				datafield : 'providerID',
				width : 250
			}, {
				text : 'ProviderName',
				datafield : 'providerName',
				width : 250
			}, {
				text : 'Address',
				datafield : 'address',
				width : 180
			}, {
				text : 'Tel',
				datafield : 'tel',
				width : 120
			}, {
				text : 'Email',
				datafield : 'email',
				minwidth : 120
			}, {
				text : 'Website',
				datafield : 'website',
				width : 250
			}, {
				text : 'Description',
				datafield : 'description',
				width : 250
			} ]

		});
	});
</script>


</head>
<body class='default'>
	<div id='jqxWidget'>
		<div id="jqxgrid"></div>
		<div
			style="font-size: 12px; font-family: Verdana, Geneva, 'DejaVu Sans', sans-serif; margin-top: 30px;">

			<div id="cellbegineditevent"></div>
			<div style="margin-top: 10px;" id="cellendeditevent"></div>
		</div>
	</div>
</body>
</html>