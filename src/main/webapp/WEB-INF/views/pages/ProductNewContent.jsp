<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="productNewContent content-resize">
	<h1>New Product</h1>
	<div class="row page-header">
		<div class="col-lg-6" style="margin-left: -15px;">
			<button id="btnSave" class="btn btn-primary">Save</button>
			<button id="btnEdit" class="btn btn-primary">Edit</button>
			<button id="btnCreate" class="btn btn-success">Create New</button>
			<button id="btnCancel" class="btn btn-danger">Cancel</button>
		</div>
	</div>
	<div class="row information">
		<div class="col-lg-3">
			<img class="img-thumbnail" id="productPic" src="resources/images/1.jpg"
				alt="some_text"> <input id="input-4" type="file">
		</div>
		<div class="col-lg-9">
			<!-- Thông tin nhập -->
			<table class="table no-border striped3n table-resize">
				<tbody>
					<tr class="row_1">
						<td><label>Product</label></td>
						<td class="td-resize">
							<div class="input-control select info-state">
								<input type="text" id="product" class="form-control" placeholder="Product's name">
							</div>
						</td>
						<td><label>Origin Price</label></td>
						<td colspan="1">
							<div class="input-control text  info-state">
								<input class="form-control" id="price" value="1"
									onkeypress="return IsNumeric(event);" ondrop="return false;"
									type="number">
							</div>
						</td>
					</tr>
					<tr class="row_1">
						<td><label>Product Type</label></td>
						<td class="td-resize">
							<div class="input-control select info-state">
								<select id="listProductType" class="form-control">
									<c:forEach var="productType" items="${listProductType}">
										<option data-id="${productType.typeID}">
											${productType.typeName}
										</option>
									</c:forEach>
								</select>
							</div>
						</td>
						<td><label>Product Unit</label></td>
						<td class="td-resize">
							<div class="input-control select info-state">
								<select id="listProductUnit" class="form-control">
									<c:forEach var="productUnit" items="${listProductUnit}">
										<option data-id="${productUnit.unitID}">
											${productUnit.unitName}
										</option>
									</c:forEach>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td><label>Manufacturer</label></td>
						<td class="td-resize">
							<div class="input-control select info-state">
								<select id="manufacture" class="form-control">
									<c:forEach var="manufacture" items="${listManufacture}">
										<option data-id="${manufacture.manufactureID}">
											${manufacture.name}
										</option>
									</c:forEach>
								</select>
							</div>
						</td>
						<td><label>Provider</label></td>
						<td class="td-resize">
							<div class="input-control select info-state">
								<select id="provider" class="form-control">
									<c:forEach var="provider" items="${listProvider}">
										<option data-id="${provider.providerID}">
											${provider.providerName}
										</option>
									</c:forEach>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td><label>Min Stock</label></td>
						<td>
							<div class="input-control text  info-state">
								<input class="form-control" id="minStock" value="1"
									onkeypress="return IsNumeric(event);" ondrop="return false;"
									type="number">
							</div>
						</td>
						<td><label>Max Stock</label></td>
						<td><input class="form-control" id="maxStock" value="1"
							onkeypress="return IsNumeric(event);" ondrop="return false;"
							type="number"></td>
					</tr>
					<tr>
						<td><label>Description</label></td>
						<td colspan="3">
							<div class="input-control text  info-state">
								<textarea class="form-control" rows="5" id="description"
									placeholder="Description" maxlength="100" style="resize: none;"></textarea>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$("#input-4").fileinput({
		showCaption : false
	});
</script>