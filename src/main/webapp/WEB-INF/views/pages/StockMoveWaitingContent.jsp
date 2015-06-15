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
			<a class="btn btn-primary" id="btnEdit">Chỉnh sửa</a> 
			<a class="btn btn-success" id="btnSave">Lưu lại</a> 
			<a class="btn btn-primary" href="checkAvailable">Kiểm tra hàng có sẵn</a> 
			<a class="btn btn-primary" href="processAll">Thực hiện tất cả</a>
			<a class="btn btn-danger">Hủy Phiếu</a>
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
<jsp:include page="StockMoveInputField.jsp"></jsp:include>