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
	href="<c:url value="/resources/css/iconFont.css" />" 
	type="text/css">
<link rel="stylesheet" 
	href="<c:url value="/resources/css/docs.css" />" 
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/stockInward.css" />" 
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/prettify.css" />" 
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.office.css" />" 
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" 
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/jqwidgets/styles/jqx.bootstrap.css" />" 
	type="text/css">

<!-- Load JavaScript Libraries -->
<script src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery/jquery.widget.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery/jquery.mousewheel.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"
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
<script src="<c:url value="/resources/jqwidgets/jqxcore.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/jqwidgets/jqx-all.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/jqwidgets/globalization/globalize.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/jqwidgets/globalization/globalize.culture.vi.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/jqwidgets/globalization/globalize.culture.vi-VNs.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/generatedata.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/demos.js" />"
	type="text/javascript"></script>
	
<!-- Inline code -->
<style type="text/css">
	.jqx-icon {
    position: absolute;
}
</style>
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
												<option data-id="
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
												<option data-value="
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
									<td class="td-resize">
										<input type="text" class="form-control" placeholder="Người nhận">
									</td>
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
											<input type="text" class="form-control" placeholder="Điện thoại">
										</div>
									</td>	
								</tr>
								<tr>
									<td><label>Lý do nhập:</label></td>
									<td>
										<div class="input-control text  info-state">
											<input type="text" class="form-control" placeholder="Lý do nhập">
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
											<input id="ngayNhap" type="datetime" class="form-control" disabled="disabled">
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="content-resize">
<!-- Bảng dữ liệu -->
				<div id='jqxWidget'>
					<div id='jqxgrid'></div>
					<div style="font-size: 12px; font-family: Verdana, Geneva, 'DejaVu Sans', sans-serif; margin-top: 30px;">
			            <div id="cellbegineditevent"></div>
			            <div style="margin-top: 10px;" id="cellendeditevent"></div>
			       </div>
			  	</div>
<!-- Tổng số, tổng tiền -->
					<table class="table no-border dock-right">
						<tbody>
							<tr>
								<td>
									<div class="input-control text info-state">
										<span> Tổng số: 
											<input type="number" class="form-control" placeholder="Tổng số">
										</span>
									</div>
								</td>
								<td>
									<div class="input-control text info-state"
										data-role="input-control">
										<span> Tổng tiền: 
											<input type="number" class="form-control" placeholder="Tổng tiền">
										</span>
									</div>
								</td>
							</tr>
						</tbody>
					</table>

				</div>
<!-- Nút bấm lưu -->
				<div class="status-bar-resize">
					<table class="table no-border dock-right">
						<tbody>
							<tr>
								<td>
									<button type="submit" class="btn btn-primary">Lưu và thêm</button>
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
</body>
</html>