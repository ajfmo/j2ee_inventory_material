<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/StockMoveTable.js" />"
	type="text/javascript"></script>

<!-- Customize style CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockMove/StockMoveStyle.css" />"
	type="text/css">


<div class="content-resize page-header">
	<h1>Stock Move</h1>
	<div class="row">
		<div class="col-lg-12">
			<a class="btn btn-success" href="NewStockMoveBill">Create</a>
			<a class="btn btn-primary" href="NewStockMoveBill">Export</a>
		</div>
	</div>
</div>
<!-- Begin page content -->
<div class="content-resize" id="table-stock-move">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<table id="tbData" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th width="2%"><input id="check_all" class="formcontrol"
							type="checkbox"></th>
						<th width="4%">No.</th>
						<th width="10%">Bill No</th>
						<th width="12%">Product</th>
						<th width="7%">Quantity</th>
						<th width="20%">Source Location</th>
						<th width="15%">Destination Location</th>
						<th width="15%">Description</th>
						<th width="8%">Status</th>
					</tr>
				</thead>
				<tbody>
					<!-- Load all data about stock move from database -->
					<tr>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


