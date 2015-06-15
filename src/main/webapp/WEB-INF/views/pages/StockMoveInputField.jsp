<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-resize" id="table-stock-move">
	<div class="row">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Sản phẩm</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control input-info">
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
			<div class='col-sm-5'>
				<div id="sandbox-container">
					<input class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Số lượng</label>
			</div>
			<div class="col-sm-5">
				<input type="number" class="form-control input-info" />
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Ưu tiên</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control input-info" id="priority">
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
				<select class="form-control input-info" id="fromStock">
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
				<select class="form-control input-info">
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
				<textarea rows="3" cols="100" class="form-control input-info"
					id="description"></textarea>
			</div>
		</div>
	</div>
</div>