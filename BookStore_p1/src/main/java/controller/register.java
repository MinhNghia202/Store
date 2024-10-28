package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import database.KhachHangDAO;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String nhanEmail = request.getParameter("nhanEmail");
		
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChi", diaChi);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("email", email);
		request.setAttribute("nhanEmail", nhanEmail);
		
		String baoLoi = "";
		String url = "";
		
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		if(khachHangDAO.selectByTenKhachHang(tenDangNhap))
		{
			baoLoi += "Tên đăng nhập đã tồn tại, Vui lòng chọn tên đăng nhập khác! <br>";
		}
		if(!matKhau.equals(matKhauNhapLai))
		{
			baoLoi += "Mật khẩu không khớp!";
		}
		else
		{
			matKhau = MaHoa.toSHA1(matKhau);
		}
		java.sql.Date sqlNgaySinh = null;
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	        LocalDateTime localDateTime = LocalDateTime.parse(ngaySinh, formatter);
	        LocalDate localDate = localDateTime.toLocalDate();
	        sqlNgaySinh = java.sql.Date.valueOf(localDate);
	    } catch (DateTimeParseException e) {
	        baoLoi += "Định dạng ngày sinh không hợp lệ!";
	    }
		
		request.setAttribute("baoLoi", baoLoi);
		
		if(baoLoi.length() > 0)
		{
			url = "/register.jsp";
		}
		else {
			Random rd = new Random();
            String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
            if (baoLoi.length() == 0) {
                KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiMuaHang, diaChiNhanHang, sqlNgaySinh, dienThoai, email, nhanEmail != null);
                khachHangDAO.insert(khachHang);
                url = "/thanhcong.jsp";
            }
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
