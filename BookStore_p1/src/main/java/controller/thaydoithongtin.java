package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import database.KhachHangDAO;

/**
 * Servlet implementation class thaydoithongtin
 */
public class thaydoithongtin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thaydoithongtin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String nhanEmail = request.getParameter("nhanEmail");
		
		String baoLoi = "";
		String url = "";
		
		java.sql.Date sqlNgaySinh = null;
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	        LocalDateTime localDateTime = LocalDateTime.parse(ngaySinh, formatter);
	        LocalDate localDate = localDateTime.toLocalDate();
	        sqlNgaySinh = java.sql.Date.valueOf(localDate);
	    } catch (DateTimeParseException e) {
	        baoLoi += "Định dạng ngày sinh không hợp lệ!";
	    }
	    
		HttpSession httpSession = request.getSession();
		Object object = httpSession.getAttribute("khachHang");
		KhachHang khachHang = null;
		if(object != null)
		{
			khachHang = (KhachHang)object;
		}
		if(khachHang == null)
		{
			baoLoi += "Bạn chưa đăng nhập, Vui lòng đăng nhập trước khi thay đổi thông tin!";
			url = "/index.jsp";
		}else {  
			if(khachHang != null)
			{
				String maKhachHang = khachHang.getMaKhachHang();
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChi, diaChiMuaHang, diaChiNhanHang, sqlNgaySinh, dienThoai, email, nhanEmail != null);
				khachHangDAO.update(kh);
				url = "/index.jsp";
			}
		}
		request.setAttribute("baoLoi", baoLoi);
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
