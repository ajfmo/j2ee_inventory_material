<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Customize style CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/StockMove/StockMoveStyle.css" />"
	type="text/css">

<div class="content-resize page-header">
	<h1>Stock Move</h1>
	<div class="row">
		<div class="col-lg-6">
			<a class="btn btn-primary" id="btnEdit">Edit</a> 
			<a class="btn btn-success" id="btnSave">Save</a>
			<a class="btn btn-primary" href="processAll">Process Entirely</a>
			<a class="btn btn-danger" >Cancel Move</a>
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
							New
						</div>
					</td>
					<td>
						<div class="my_corner waiting" >
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Waiting Availability
						</div>
					</td>
					<td>
						<div class="my_corner" style="background-color: #4EFF47;">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Available
						</div>
					</td>
					<td>
						<div class="my_corner">
							<div class="bl"></div>
							<div class="br"></div>
							<div class="tl"></div>
							<div class="tr"></div>
							Done
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<jsp:include page="StockMoveInputField.jsp"></jsp:include>