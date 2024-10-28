package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;

import database.KhachHangDAO;

/**
 * Servlet implementation class dangnhap
 */
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau  = request.getParameter("matKhau");
		matKhau = MaHoa.toSHA1(matKhau);
		
		KhachHang khachHang = new KhachHang();
		khachHang.setTenDangNhap(tenDangNhap);
		khachHang.setMatKhau(matKhau);
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHang kh = khachHangDAO.selectByUserNamePassword(khachHang);
		
		String url = "";
		if(kh != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", kh);
			url = "/index.jsp";
		}
		else
		{
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu chưa chính xác");
			url = "/DangNhap.jsp";
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
