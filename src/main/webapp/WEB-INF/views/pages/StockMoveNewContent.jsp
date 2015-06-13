<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <script src="<c:url value="/resources/js/StockMoveContent.js" />"
	type="text/javascript"></script> --%>

<!-- Customize style CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockMove/StockMoveStyle.css" />"
	type="text/css">

<div class="content-resize page-header">
	<h1>Phiếu chuyển kho mới</h1>
	<div class="row">
		<div class="col-lg-6">
			<a class="btn btn-primary" name="ProcessLater">Thực hiện sau</a> <a
				class="btn btn-primary" name="CheckAvailable">Kiểm tra hàng có
				sẵn</a> <a class="btn btn-primary" name="Cancel">Hủy</a>
		</div>
		<div class="col-lg-6">
			<table>
				<tr>
					<td width="100px">
						<div class="my_corner">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Mới
						</div>
					</td>
					<td>
						<div class="my_corner waiting">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Chờ có hàng
						</div>
					</td>
					<td>
						<div class="my_corner waiting">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Sẵn sàng chuyển
						</div>
					</td>
					<td>
						<div class="my_corner waiting">
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
				<input type="date" class="date-picker" />
			</div>
		</div>
	</div>
</div>
