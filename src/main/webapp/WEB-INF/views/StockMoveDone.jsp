<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Phiếu chuyển kho</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css">

<!-- MetisMenu CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/metisMenu.min.css" />"
	type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/sb-admin-2.css" />" type="text/css">

<!-- Custom Fonts -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css" />"
	type="text/css">

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Quản lý tồn kho - TSQ</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> Thông tin
							cá nhân</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Cài đặt</a></li>
					<li class="divider"></li>
					<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
							Đăng xuất</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav in" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Tìm kiếm...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
							Trang chủ</a></li>
					<!-- Quản lý kho -->
					<li class=""><a href="#"><i
							class="fa fa-bar-chart-o fa-fw"></i> Quản lý kho<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level collapse">
							<li><a href="StockInward"> Nhập kho</a></li>
							<li><a href="StockOutward">Xuất kho</a></li>
							<li><a href="StockMove">Chuyển kho</a></li>
							<li><a href="morris.html">Kiểm kê</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<!-- Quản lý danh mục -->
					<li class=""><a href="#"><i class="fa fa-edit fa-fw"></i>
							Quản lý danh mục<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level collapse">
							<li><a href="panels-wells.html">Sản phẩm</a></li>
							<li><a href="buttons.html">Kho</a></li>
							<li><a href="notifications.html">Đơn vị</a></li>
							<li><a href="typography.html">Nhà phân phối</a></li>
							<li><a href="icons.html">Nhóm hàng</a></li>

						</ul> <!-- /.nav-second-level --></li>

					<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
							Báo cáo</a></li>

					<li><a href="forms.html"><i class="fa fa-wrench fa-fw"></i>
							Cấu hình</a></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper" style="min-height: 346px;">
			<div class="row">
				<div class="col-lg-12">
<!-- Include content of this page  -->
					 <jsp:include page="pages/StockMoveDoneContent.jsp"></jsp:include>
<!-- Include content of this page  -->
				</div>

				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12"></div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
		type="text/javascript"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"
		type="text/javascript"></script>
		
	<script src="<c:url value="/resources/js/moment.min.js" />"
		type="text/javascript"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/resources/js/metisMenu.min.js" />"
		type="text/javascript"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>
	<script src="<c:url value="/resources/js/sb-admin-2.js" />"
		type="text/javascript"></script>
	<script src="<c:url value="/resources/js/StockMoveContent.js" />"
	type="text/javascript"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('.input-info').prop( "disabled", true );
		$('#btnSave').css('display','none');
		$("#btnEdit").click(function() {
			$('#btnEdit').css('display','none');
			$('#btnSave').css('display','inline-block');
			$('#fromStock').prop( "disabled", false );
			$('#description').prop( "disabled", false );
			$('#priority').prop( "disabled", false );
		});
		$("#btnSave").click(function() {
			$('#btnSave').css('display','none');
			$('#btnEdit').css('display','inline-block');
			$('#fromStock').prop( "disabled", true );
			$('#description').prop( "disabled", true );
			$('#priority').prop( "disabled", true );
		});
	});
	
	</script>

</body>
</html>