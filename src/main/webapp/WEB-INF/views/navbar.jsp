<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open ERP</title>
<style type="text/css">
	.metro .bg-darker {
		background-color: #333333 !important;
	}
</style>

</head>
<body class="metro">
	<div class="bg-darker fixed-top shadow">
		<div class="container">
			<div class="naviBar">
				<div class="navigation-bar dark">
					<div class="navbar-content">

						<a href="#" class="element"><span class="icon-grid-view"></span>
							OPEN ERP <!--sup>2.0</sup--></a> <span class="element-divider"></span>

						<a class="pull-menu" href="#"></a>
						<ul class="element-menu">
							<li><a class="dropdown-toggle" href="#">Danh mục</a>
								<ul class="dropdown-menu " data-role="dropdown">
									<li><a href="#" class="dropdown-toggle">Đối tác</a>
										<ul class="dropdown-menu " data-role="dropdown">
											<li><a href="#">Nhà phân phối</a></li>
											<li><a href="#">Khách hàng</a></li>
										</ul></li>
									<li class="divider" />
									<li><a href="#" class="dropdown-toggle">Kho hàng</a>
										<ul class="dropdown-menu " data-role="dropdown">
											<li><a href="#">Kho</a></li>
											<li><a href="#">Đơn vị tính</a></li>
											<li><a href="#">Loại mặt hàng</a></li>
											<li><a href="#">Hàng hóa</a></li>
											<li><a href="#">Mã vạch</a></li>
										</ul></li>
									<li class="divider" />
									<li><a href="#" class="dropdown-toggle">Tổ chức</a>
										<ul class="dropdown-menu " data-role="dropdown">
											<li><a href="#">Bộ phận</a></li>
											<li><a href="#">Nhân viên</a></li>
										</ul></li>
								</ul></li>
							<li><a class="dropdown-toggle" href="#">Kho hàng</a>
								<ul class="dropdown-menu " data-role="dropdown">
									<li><a href="#" class="dropdown-toggle">Quản lý kho</a>
										<ul class="dropdown-menu " data-role="dropdown">
											<li class="disabled"><a href="#">Nhập kho</a></li>
											<li><a href="#">Xuất kho</a></li>
											<li><a href="#">Tồn kho</a></li>
										</ul></li>
									<li class="divider"></li>
									<li><a href="#" class="dropdown-toggle">Tiện ích</a>
										<ul class="dropdown-menu " data-role="dropdown">
											<li><a href="#">Chuyển kho</a></li>
											<li><a href="#">Đóng gói</a></li>
											<li><a href="#">Tháo gỡ</a></li>
											<li><a href="#">Kiểm kê</a></li>
										</ul></li>
									<li class="divider"></li>
									<li><a href="#">Lịch sử hàng hóa</a></li>
								</ul></li>
							<li><a class="dropdown-toggle" href="#">Trợ giúp</a>
								<ul class="dropdown-menu " data-role="dropdown">
									<li><a href="#">Hướng dẫn sử dụng</a></li>
								</ul></li>
						</ul>

						<div class="no-tablet-portrait">
							<div class="element place-right">
								<a class="dropdown-toggle" href="#"><span class="icon-cog"></span></a>
								<ul class="dropdown-menu place-right" data-role="dropdown">
									<li><a href="#">Đăng nhập</a></li>
									<li><a href="#">Đăng xuất</a></li>
									<li><a href="#">Cài đặt</a></li>
									<li><a href="#">Thông báo</a></li>
								</ul>
							</div>
							<span class="element-divider place-right"></span>
							<button class="element image-button image-left place-right">
								Toney Lee <img src="<c:url value="/resources/images/me.jpg"/>" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>