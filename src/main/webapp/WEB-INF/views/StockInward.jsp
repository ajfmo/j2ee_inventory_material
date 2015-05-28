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
	href="<c:url value="/resources/css/StockInward/jquery-ui.css" />"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value="/resources/css/iconFont.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/docs.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockInward/stockInward.css" />" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/prettify.css" />" type="text/css">

<!-- Load JavaScript Libraries -->
<script
	src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
	
<script src="<c:url value="/resources/js/jquery/jquery-ui.js" />"
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
<script src="<c:url value="/resources/js/metro.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/docs.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/github.info.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/StockInward.js" />"
	type="text/javascript"></script>


</head>
<body class="metro default">
	<header class="bg-dark">
		<jsp:include page="../views/navbar.jsp"></jsp:include>
	</header>
	<div class="openERP container shadow">
		<form>
			<label><b>Thông tin phiếu nhập</b> </label>
			<div class="row information">
				<div id="col6" class="col-sm-6">
					<!-- Thông tin nhập -->
					<table class="table no-border striped3n table-resize">
						<tbody>
							<tr class="row_1">
								<td><label>Tên:</label>
								<td class="td-resize">
									<div class="input-control select info-state">
										<select id="select_providerN" class="form-control">
											<c:forEach var="item" items="${listProvider}">
												<option
													data-id="
													<c:out value="${item.providerID}">
													</c:out>">
													<c:out value="${item.providerName}">
													</c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</td>
								<td><label>Mã:</label></td>
								<td class="td-resize">
									<div class="input-control select info-state">
										<select id="select_providerID" class="form-control">
											<c:forEach var="item" items="${listProvider}">
												<option
													data-value="
													<c:out value="${item.providerName}">
													</c:out>">
													<c:out value="${item.providerID}">
													</c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</td>
								<td><label>Người nhận:</label></td>
								<td class="td-resize"><input type="text"
									class="form-control" placeholder="Người nhận"></td>
							</tr>
							<tr>
								<td><label>Địa chỉ:</label></td>
								<td>
									<div class="input-control text  info-state">
										<input type="text" class="form-control" placeholder="Địa chỉ">
									</div>
								</td>
								<td><label>Điện thoại:</label></td>
								<td>
									<div class="input-control text  info-state">
										<input type="text" class="form-control"
											placeholder="Điện thoại">
									</div>
								</td>
							</tr>
							<tr>
								<td><label>Lý do nhập:</label></td>
								<td>
									<div class="input-control text  info-state">
										<input type="text" class="form-control"
											placeholder="Lý do nhập">
									</div>
								</td>
								<td><label>Ghi chú:</label></td>
								<td>
									<div class="input-control text  info-state">
										<input type="text" class="form-control" placeholder="Ghi chú">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="col4" class="col-sm-4">
					<!-- Mã phiếu, ngày -->
					<table class="table no-border">
						<tbody>
							<tr>
								<td><label>Mã phiếu:</label></td>
								<td>
									<div class="input-control text info-state">
										<input type="text" class="form-control" disabled="disabled">
									</div>
								</td>
							</tr>
							<tr>
								<td><label>Ngày:</label></td>
								<td>
									<div class="input-control text info-state">
										<input id="ngayNhap" type="datetime" class="form-control"
											disabled="disabled">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- Begin page content -->
			<div class="content-resize">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<table id="tbData" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th width="2%"><input id="check_all" class="formcontrol"
										type="checkbox"></th>
									<th>S. No</th>
									<th width="10%">Product ID</th>
									<th width="20%">Product Name</th>
									<th width="15%">Stock</th>
									<th width="10%">Unit</th>
									<th width="10%">Price</th>
									<th width="10%">Quantity</th>
									<th width="15%">Total</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6 col-md-4">
						<button class="btn btn-danger delete" type="button">-
							Delete</button>
						<button class="btn btn-success addmore" type="button">+
							Add More</button>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-8">
						<form class="form-inline">
							<div class="form-group ">
								<label>Total Amount: &nbsp;</label>
								<div class="input-group">
									<div class="input-group-addon"></div>
									<input class="form-control" id="amountTotal"
										placeholder="Total Amount"
										onkeypress="return IsNumeric(event);" ondrop="return false;"
										onpaste="return false;" type="number"
										readonly='readonly'>
								</div>
							</div>
							<div class="form-group">
								<label>Total Money: &nbsp;</label>
								<div class="input-group">
									<div class="input-group-addon">$</div>
									<input class="form-control" id="subTotal"
										placeholder="Total Money"
										onkeypress="return IsNumeric(event);" ondrop="return false;"
										onpaste="return false;" type="number"
										readonly='readonly'>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Nút bấm lưu -->
			<div class="status-bar-resize">
				<table class="table no-border dock-right">
					<tbody>
						<tr>
							<td>
								<button type="submit" class="btn btn-primary">Lưu và
									thêm</button>
							</td>
							<td>
								<button type="submit" class="btn btn-success">Tạo mới</button>
							</td>
							<td>
								<button type="submit" class="btn btn-danger">Hủy</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</div>
	
		<script>
		function loadData(count, i){
			var html = "<tr>";
			html += "<td><input class='case' type='checkbox'/></td>";
			html += "<td><span id='snum" + i + "'>" + count + ".</span></td>";
			html += "<td><input readonly='readonly'readonly='readonly' type='text' data-type='productID' name='productID[]' id='productID_"+i+"' class='form-control searchID' autocomplete='off'></td>";
			html += "<td><input type='text' data-type='productName' name='productName[]' id='productName_"+i+"' class='form-control searchName' autocomplete='off'></td>";
			html += "<td>" +
						"<select id='select_StockName' class='form-control'>" +
							"<c:forEach var='item' items='${listStock}'>" +
								"<option data-id='<c:out value='${item.stockID}'>" +
								"</c:out>'><c:out value='${item.stockName}'>" +
							"</c:out></option></c:forEach>" +
						"</select>" +
					"</td>";
			html += "<td><input readonly='readonly' type='text' data-type='unitName' name='unitName[]' id='unitName_"+i+"' class='form-control' autocomplete='off'></td>";
			html += "<td><input readonly='readonly' type='text' name='price[]' id='price_"+i+"' class='form-control price' autocomplete='off' onkeypress='return IsNumeric(event);' ondrop='return false;' onpaste='return false;'></td>";
			html += "<td><input type='text' name='quantity[]' id='quantity_"+i+"' class='form-control changesNo' autocomplete='off' onkeypress='return IsNumeric(event);' ondrop='return false;' onpaste='return false;'></td>";
			html += "<td><input readonly='readonly' type='text' name='total[]' id='total_"+i+"' class='form-control totalLinePrice' autocomplete='off' onkeypress='return IsNumeric(event);' ondrop='return false;' onpaste='return false;'></td>";
			html += "</tr>";
			
			return html;
		}
	</script>
	<script src="<c:url value="/resources/js/StockInwardTable.js" />"
		type="text/javascript"></script>
</body>
</html>