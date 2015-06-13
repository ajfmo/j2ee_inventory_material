<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/StockMoveTable.js" />"
	type="text/javascript"></script>

<!-- Customize style CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockMove/StockMoveStyle.css" />"
	type="text/css">

<script type="text/javascript">
	$(function() {
		$('#dtpExpectedDay').datetimepicker();
	});
</script>

<div class="content-resize page-header">
	<h1>Phiếu chuyển kho mới</h1>
	<div class="row">
		<div class="col-lg-12">
			<a class="btn btn-primary" name="ProcessLater">Thực hiện sau</a> <a
				class="btn btn-primary" name="CheckAvailable">Kiểm tra hàng có
				sẵn</a> <a class="btn btn-primary" name="Cancel">Hủy</a>
		</div>
	</div>
</div>
<!-- Begin page content -->
<div class="content-resize" id="table-stock-move">
	<div class="row">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Sản phẩm</label>
			</div>
			<div class="col-sm-5">
				<select class="selectpicker">
					<option>...</option>
					<option>123</option>
					<option>abc</option>
				</select>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Ngày chuyển</label>
			</div>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="dtpExpectedDay" />
			</div>
		</div>
	</div>
</div>


