<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-resize" id="table-stock-move">
	<div class="row">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Product</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control input-info" id="product">
					<c:forEach items="${listProducts}" var="product">
						<option>${product.productID }: ${product.productName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Expected Date</label>
			</div>
			<div class='col-sm-5'>
				<div id="sandbox-container">
					<input class="form-control input-info" type="text" id="expectedDay">
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Quantity</label>
			</div>
			<div class="col-sm-5">

				<input type="number" class="form-control input-info" id="quantity">
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Priority</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control input-info" id="priority">
					<option>Urgent</option>
					<option>High</option>
					<option selected="selected">Normal</option>
					<option>Low</option>
				</select>
			</div>
		</div>
	</div>

	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Source Location</label>
			</div>
			<div class="col-sm-5">
				<select class="form-control input-info" id="fromStock">
					<c:forEach items="${listStocks}" var="stock">
						<option>${stock.stockID}: ${stock.stockName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Destination Location</label>
			</div>
			<div class="col-sm-5">

				<select class="form-control input-info" id="toStock">
					<c:forEach items="${listStocks}" var="stock">
						<option>${stock.stockID}: ${stock.stockName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-lg-6">
			<div class="col-sm-3">
				<label>Description</label>
			</div>
			<div class="col-sm-9">
				<textarea rows="3" cols="100" class="form-control input-info"
					id="description" maxlength="200" wrap="hard" style="resize: none;"></textarea>
			</div>
		</div>
	</div>
</div>