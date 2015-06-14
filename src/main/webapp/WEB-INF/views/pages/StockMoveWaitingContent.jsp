<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Customize style CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockMove/StockMoveStyle.css" />"
	type="text/css">

<div class="content-resize page-header">
	<h1>Phiếu chuyển kho</h1>
	<div class="row">
		<div class="col-lg-6">
			<a class="btn btn-primary" name="btnEdit">Chỉnh sửa</a> 
			<a class="btn btn-primary" name="btnCheckAvailable">Kiểm tra hàng có sẵn</a> 
			<a class="btn btn-primary" name="btnProcessAll">Thực hiện tất cả</a>
			<a class="btn btn-danger" name="btnCancel">Hủy Phiếu</a>
		</div>
		<div class="col-lg-6">
			<table>
				<tr>
					<td>
						<div class="my_corner">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Mới
						</div>
					</td>
					<td>
						<div class="my_corner" style="background-color: #4EFF47;">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Chờ có hàng
						</div>
					</td>
					<td>
						<div class="my_corner">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Sẵn sàng
						</div>
					</td>
					<td>
						<div class="my_corner">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Hoàn thành
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div class="content-resize" id="table-stock-move">
	<div class="row">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Sản phẩm</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control">
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
				<input type="date" id="datepicker" name="moveDay"/>
			</div>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Số lượng</label>
			</div>
			<div class="col-sm-5">
				<input type="number" class="form-control" />
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Ưu tiên</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control">
					<option>Khẩn cấp</option>
					<option selected="selected">Không gấp</option>
					<option>Thấp</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Từ kho</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control">
					<option>Kho 1</option>
					<option>Kho 2</option>
					<option>Kho 3</option>
				</select>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Đến kho</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control">
					<option>Kho 1</option>
					<option>Kho 2</option>
					<option>Kho 3</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Mô tả</label>
			</div>
			<div class="col-sm-9">
				<textarea rows="3" cols="100" class="form-control">
				</textarea>
			</div>
		</div>
	</div>
</div>
