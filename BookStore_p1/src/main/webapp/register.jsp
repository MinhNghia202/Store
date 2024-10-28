<%@page import="java.lang.runtime.TemplateRuntime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
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
<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	
	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
	
	String hoVaTen = request.getAttribute("hoVaTen") + "";
	hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;
	
	String gioiTinh = request.getAttribute("gioiTinh") + "";
	gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;
	
	String ngaySinh = request.getAttribute("ngaySinh") + "";
	ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;
	
	String diaChi = request.getAttribute("diaChi") + "";
	diaChi = (diaChi.equals("null"))?"":diaChi;
	
	String diaChiMuaHang = request.getAttribute("diaChiMuaHang") + "";
	diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;
	
	String diaChiNhanHang = request.getAttribute("diaChiNhanHang") + "";
	diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;
	
	String dienThoai = request.getAttribute("dienThoai") + "";
	dienThoai = (dienThoai.equals("null"))?"":dienThoai;
	
	String email = request.getAttribute("email") + "";
	email = (email.equals("null"))?"":email;
	
	String nhanEmail = request.getAttribute("nhanEmail") + "";
	nhanEmail = (nhanEmail.equals("null"))?"false":nhanEmail;
	
%>
<div style="font-size: 30px; font-weight: bold; text-align: center;">Đăng ký tài khoản</div>
<div class="container">
	<div class="rd" id="baoLoi"><%=baoLoi %></div>
    <form class="form" action="register" method="get">
        <div class="row">
            <div class="col-sm-6">
                <div style="font-size: 25px; font-weight: bold;">Tài Khoản</div>
                <div class="mb-3">
                    <label for="tenDangNhap" class="form-label">Tên đăng nhập <span class="rd">*</span></label>
                    <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required="required" value="<%=tenDangNhap %>">
                </div>
                <div class="mb-3">
                    <label for="matKhau" class="form-label">Mật khẩu<span class="rd" >*</span></label>
                    <input type="password" class="form-control" id="matKhau" name="matKhau" onkeyup="checkMatKhauNhapLai()" required="required">
                </div>
                <div class="mb-3">
                    <label for="matKhauNhapLai" class="form-label" >Nhập lại mật khẩu<span class="rd">* </span> <span id="checkMatKhau" class="rd"></span></label> 
                    <input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai" onkeyup="checkMatKhauNhapLai()" required="required">
                </div>
                <hr>
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
            </div>
            <div class="col-sm-6">
                <div style="font-size: 25px; font-weight: bold;">Địa chỉ</div>
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
                    <input type="checkbox" class="form-check-input" id="dieuKhoanCongTy" name="dieuKhoanCongTy">
                    <label class="form-check-label" for="dieuKhoanCongTy">Đồng ý với điều khoản công ty<span class="rd">*</span></label>
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="nhanEmail" name="nhanEmail" <%= (nhanEmail.equals("true") ? "checked" : "") %>>
                    <label class="form-check-label" for="nhanEmail">Đồng ý nhận Email</label>
                </div>
                <button type="submit" class="btn btn-primary" disabled="disabled" id="dangKy" name="dangKy">Đăng ký</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
	function checkMatKhauNhapLai()
	{
		var matKhau = document.getElementById("matKhau").value;
		var matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
		var checkMatKhau = document.getElementById("checkMatKhau");

        if (matKhauNhapLai !== matKhau) {
            checkMatKhau.innerHTML = "Mật khẩu không trùng khớp";
        } else {
            checkMatKhau.innerHTML = "";
        }

	}
    function enableSubmitButton() {
        var dieuKhoanCongTy = document.getElementById("dieuKhoanCongTy");
        var dangKyButton = document.getElementById("dangKy");
        if (dieuKhoanCongTy.checked) {
            dangKyButton.disabled = false;
        } else {
            dangKyButton.disabled = true;
        }
    }

    window.onload = function() {
        document.getElementById("dieuKhoanCongTy").addEventListener('change', enableSubmitButton);
    }
</script>
</html>
