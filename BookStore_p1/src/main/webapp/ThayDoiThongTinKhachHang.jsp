<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style type="text/css">
    .rd {
        color: red;
    }
</style>
</head>
<body>
<div class="container">
	<%
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
	    	String baoLoi = request.getAttribute("baoLoi") + "";
	    	baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	        
	        String hoVaTen = khachHang.getHoVaTen();
	    	
	    	String gioiTinh = khachHang.getGioiTinh();
	    	
	    	String ngaySinh = (khachHang.getNgaySinh() != null) ? khachHang.getNgaySinh().toString() : "Không có ngày sinh";
	    	
	    	String diaChi = khachHang.getDiaChi();
	    	
	    	String diaChiMuaHang = khachHang.getDiaChiMuaHang();
	    	
	    	String diaChiNhanHang = khachHang.getDiaChiNhanHang();
	    	
	    	String dienThoai = khachHang.getSoDienThoai();
	    	
	    	String email = khachHang.getEmail();
	    	
	    	boolean nhanEmail = khachHang.isDangKyNhanBangTin();
	 
	%>
	<div class="rd" id="baoLoi"><%=baoLoi %></div>
    <form class="form" action="thaydoithongtin" method="get">
        <div class="row">
            <div class="col-6">
                <div style="font-size: 25px; font-weight: bold;">Thông tin khách hàng</div>
                <div class="mb-3">
                    <label for="hoVaTen" class="form-label">Họ và tên</label>
                    <input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen %>">
                </div>
                <div class="mb-3">
                    <label for="gioiTinh" class="form-label">Giới tính</label>
                    <select class="form-control" id="gioiTinh" name="gioiTinh">
                        <option></option>
                        <option value="nam" <%=(gioiTinh.equals("nam")?"selected='selected'":"") %>>Nam</option>
                        <option value="nu"<%=(gioiTinh.equals("nu")?"selected='selected'":"") %>>Nữ</option>
                        <option value="khac"<%=(gioiTinh.equals("khac")?"selected='selected'":"") %>>Khác</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="ngaySinh" class="form-label">Ngày sinh</label>
                    <input type="datetime-local" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh %>">
                </div>
                <div class="mb-3">
                    <label for="diaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="diaChi" name="diaChi" value="<%=diaChi %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label>
                    <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diaChiMuaHang %>">
                </div>
                <div class="mb-3">
                    <label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                    <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diaChiNhanHang %>">
                </div>
                <div class="mb-3">
                    <label for="dienThoai" class="form-label">Điện thoại</label>
                    <input type="text" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai %>">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=email %>">
                </div>
                <hr>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="nhanEmail" name="nhanEmail" <%= (nhanEmail? "checked" : "") %>>
                    <label class="form-check-label" for="nhanEmail">Đồng ý nhận Email</label>
                </div>
                <button type="submit" class="btn btn-primary" id="capNhat" name="capNhat">Cập nhật</button>
            </div>
        </div>
    </form>
    <% } %>
</div>
</body>
</html>