<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 class="page-header">Nhập kho</h1>
<div class="openERP container shadow">
	<!-- <form> -->
	<label><b>Thông tin phiếu nhập</b> </label>
	<div class="row information">
		<div id="col6" class="col-lg-9">
			<!-- Thông tin nhập -->
			<table class="table no-border striped3n table-resize">
				<tbody>
					<tr class="row_1">
						<td><label>Mã SP:</label></td>
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
						<td><label>Tên SP:</label></td>
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


					</tr>
					<tr>
						<td><label>Người nhận:</label></td>
						<td class="td-resize"><input type="text" class="form-control"
							placeholder="Người nhận"></td>
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
						<!-- <td><label>Lý do nhập:</label></td>
						<td>
							<div class="input-control text  info-state">
								<input type="text" class="form-control" placeholder="Lý do nhập">
							</div>
						</td> -->
					</tr>
					<tr>
						<td><label>Lý do nhập:</label></td>
						<td><input type="text" class="form-control"
							placeholder="Lý do nhập"></td>
						<td><label>Ghi chú:</label></td>
						<td colspan="3">
							<div class="input-control text  info-state">
								<input id="reason" type="text" class="form-control"
									placeholder="Ghi chú">
							</div>
						</td>
					</tr>
				</tbody>
			</table>

		</div>
		<div id="col4" class="col-lg-3">
			<!-- Mã phiếu, ngày -->
			<table class="table no-border">
				<tbody>
					<tr>
						<td><label>Mã phiếu</label></td>
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
	<!-- <div class="row">
		<div class="col-lg-8">
			<table class="table no-border">
				<tbody>
					<tr>
						<td><label>Lý do nhập:</label></td>
						<td><input type="text" class="form-control"
							placeholder="Lý do nhập"></td>
						<td><label>Ghi chú:</label></td>
						<td><input id="reason" type="text" class="form-control"
							placeholder="Ghi chú"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div> -->
	<!-- Begin page content -->
	<div class="content-resize">
		<div class="row">
			<div class="col-lg-12">
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
				<button class="btn btn-success addmore" type="button">+ Add
					More</button>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-8">
				<form class="form-inline">
					<div class="form-group ">
						<label>Total Number: &nbsp;</label>
						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" id="totalNumber"
								placeholder="Total Amount" onkeypress="return IsNumeric(event);"
								ondrop="return false;" onpaste="return false;" type="number"
								readonly='readonly'>
						</div>
					</div>
					<div class="form-group">
						<label>Total Money: &nbsp;</label>
						<div class="input-group">
							<div class="input-group-addon">$</div>
							<input class="form-control" id="totalMoney"
								placeholder="Total Money" onkeypress="return IsNumeric(event);"
								ondrop="return false;" onpaste="return false;" type="number"
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
						<button id="saveData" type="submit" class="btn btn-primary">Save
							Data</button>
					</td>
					<td>
						<button id="createNew" type="submit" class="btn btn-success">Create
							New</button>
					</td>
					<td>
						<button id="cancel" type="submit" class="btn btn-danger">Cancel</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>