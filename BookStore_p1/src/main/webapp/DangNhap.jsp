<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +"/" + request.getContextPath();
%>
<style type="text/css">
    .rd {
        color: red;
    }
</style>
<link href="<%=url %>/css/DangNhap.css" rel="stylesheet">
</head>
<body>
<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;
%>
<main class="form-signin w-100 m-auto">
  <form class="text-center" action="dangnhap" method="post">
    <img class="mb-4" src="<%=url %>/img/logo.png" alt="" width="100">
    <div class="text-center"><span class="rd"><%=baoLoi %></span></div>
    <h1 class="h3 mb-3 fw-normal">Đăng nhập</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap">
      <label for="tenDangNhap">Tên đăng nhập</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="matKhau" name="matKhau">
      <label for="tenDangNhap">Mật khẩu</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        Ghi nhớ tài khoản này
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Đăng nhập</button>
    <a href="register.jsp">Đăng ký tài khoản mới</a>
    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
  </form>
</main>
</body>
</html>