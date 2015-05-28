<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="utf-8">
<div class="openERP container shadow col-lg-12">
	<form>
		<label><b>Thông tin phiếu nhập</b> </label>
		<div class="row information">
			<div id="col6" class="col-lg-9">
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
			<div id="col4" class="col-lg-3">
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
		<div class="content-resize">
			<!-- Bảng dữ liệu -->
			<div id='jqxWidget'>
				<div id='jqxgrid'></div>
				<div
					style="font-size: 12px; font-family: Verdana, Geneva, 'DejaVu Sans', sans-serif; margin-top: 30px;">
					<div id="cellbegineditevent"></div>
					<div style="margin-top: 10px;" id="cellendeditevent"></div>
				</div>
			</div>
			<!-- Tổng số, tổng tiền -->
			<div class="col-sm-8">
				<table class="table no-border dock-right">
					<tbody>
						<tr>
							<td>
								<div class="input-control text info-state">
									<span> Tổng số: <input type="number"
										class="form-control" placeholder="Tổng số">
									</span>
								</div>
							</td>
							<td>
								<div class="input-control text info-state"
									data-role="input-control">
									<span> Tổng tiền: <input type="number"
										class="form-control" placeholder="Tổng tiền">
									</span>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Nút bấm lưu -->
		<div class="status-bar-resize col-sm-8">
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