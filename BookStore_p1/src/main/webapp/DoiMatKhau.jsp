<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style type="text/css">
	.red{
		color: red;
	}
</style>
</head>
<body>
<%
    String baoLoi = "";
	HttpSession httpSession = request.getSession();
    Object object = httpSession.getAttribute("khachHang");
    KhachHang khachHang = null;
    if (object != null) {
        khachHang = (KhachHang) object;
    }
    if (khachHang == null) {
%>
    <h3>Bạn chưa đăng nhập vào hệ thống!</h3>
<%
    } else {
        baoLoi = request.getAttribute("baoLoi") + "";
        baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;
 
%>

	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6" style="margin-top: 100px">
				<h2 class="text-center">Đổi mật khẩu</h2>
				<div><span class="red"><%=baoLoi %></span></div>
				<form action="doimatkhau" method="post">
				  <div class="mb-3">
				    <label for="matKhauCu" class="form-label">Mật khẩu cũ</label>
				    <input type="text" class="form-control" id="matKhauCu" name="matKhauCu">
				  </div>
				  <div class="mb-3">
				    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
				    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
				  </div>
				  <div class="mb-3">
				    <label for="matKhauMoiNhapLai" class="form-label">Nhập lại mật khẩu mới</label>
				    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
				  </div>
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Lưu thay đổi</label>
				  </div>
				  <button type="submit" class="btn btn-primary text-center">Lưu mật khẩu</button>
				</form>
			</div>
		</div>
	</div>
	<% } %>
</body>
</html>