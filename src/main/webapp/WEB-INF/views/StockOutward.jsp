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

<!-- Metro UI CSS JavaScript plugins -->
<script src="<c:url value="/resources/js/metro.min.js" />"
	type="text/javascript"></script>

<!-- Local JavaScript -->
<script src="<c:url value="/resources/js/docs.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/github.info.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/hitua.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/StockInward.js" />"
	type="text/javascript"></script>


</head>
<body class="metro">
	<header class="bg-dark">
		<jsp:include page="../views/navbar.jsp"></jsp:include>
	</header>
	<div class="openERP container shadow">
		<div class="content">
			<form>
				<fieldset>
					<div class="container_parent">
						<label><b> Thông tin phiếu xuất </b> </label>
<!-- Các textField input -->
						<div class="row information">
							<div id="col6" class="col-sm-6">
								<table class="table no-border striped3n table-resize">
									<tbody>
										<tr class="">
											<td><span> Tên: </span></td>
											<td class="td-resize">
												<div class="input-control select info-state"
													data-role="input-control">
													<select id="select_oneline">
														<option>Đại Phát</option>
														<option>Tân Thành</option>
													</select>
												</div>
											</td>
											<td><span> Mã: </span></td>
											<td class="td-resize">
												<div class="input-control select info-state"
													data-role="input-control">
													<select id="select_oneline">
														<option>00001</option>
														<option>00002</option>
													</select>
												</div>
											</td>
											<td><span> Người nhận: </span></td>
											<td class="td-resize">
												<div class="input-control text info-state"
													data-role="input-control">
													<span> <input type="text" id="text-resize1">
													</span>
												</div>
											</td>
										</tr>
										<tr>
											<td>Địa chỉ:</td>
											<td>
												<div class="input-control text  info-state"
													data-role="input-control">
													<span> <input id="text-resize1" type="text">
													</span>
												</div>
											</td>
											<td>Điện thoại:</td>
											<td>
												<div class="input-control text  info-state"
													data-role="input-control">
													<span> <input id="text-resize1" type="text">
													</span>
												</div>
											</td>
										</tr>
										<tr>
											<td>Lý do nhập:</td>
											<td>
												<div class="input-control text  info-state"
													data-role="input-control">
													<span> <input id="text-resize1" type="text">
													</span>
												</div>
											</td>
											<td>Ghi chú:</td>
											<td>
												<div class="input-control text  info-state"
													data-role="input-control">
													<span> <input id="text-resize1" type="text">
													</span>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="col4" class="col-sm-4">
								<table class="table no-border">
									<tbody>
										<tr>
											<td>Mã phiếu:</td>
											<td>
												<div class="input-control text info-state"
													data-role="input-control">
													<input id="text_oneline" type="text">
												</div>
											</td>
										</tr>
										<tr>
											<td>Ngày:</td>
											<td>
												<div class="input-control text info-state"
													data-role="input-control">
													<input id="text_oneline" type="text">
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="content-resize">
							
							
							<table class="table no-border dock-right">
								<tbody>
									<tr>
										<td>
											<div class="input-control text info-state"
												data-role="input-control">
												<span> Tổng số: <input type="text" id="text-resize3">
												</span>
											</div>
										</td>
										<td>
											<div class="input-control text info-state"
												data-role="input-control">
												<span> Tổng tiền: <input type="text"
													id="text-resize3">
												</span>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="status-bar-resize">
							<table class="table no-border dock-right">
								<tbody>
									<tr>
										<td>
											<button class="default" id="button_oneline">Lưu và
												thêm</button>
										</td>
										<td>
											<button class="default" id="button_oneline">Tạo mới
											</button>
										</td>
										<td>
											<button class="default" id="button_oneline">Hủy</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>