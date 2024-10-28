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
 * Servlet implementation class doimatkhau
 */
public class doimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doimatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matKhauCu = request.getParameter("matKhauCu");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
		
		String matKhauCuMaHoa = MaHoa.toSHA1(matKhauCu);
		
		String baoLoi = "";
		String url = "";
		
		HttpSession httpSession = request.getSession();
		Object object = httpSession.getAttribute("khachHang");
		KhachHang khachHang = null;
		
		if(object != null)
		{
			khachHang = (KhachHang)object;
		}
		
		if(khachHang == null)
		{
			baoLoi += "Bạn chưa đăng nhập!";
			url = "/DoiMatKhau.jsp";
		}
		else
		{
			System.out.println("Mật khẩu hiện tại (mã hóa): " + khachHang.getMatKhau());
	        System.out.println("Mật khẩu cũ nhập vào (mã hóa): " + matKhauCuMaHoa);
			if(!matKhauCuMaHoa.equals(khachHang.getMatKhau()))
			{
				baoLoi += "Mật khẩu hiện tại không chính xác!";
				url = "/DoiMatKhau.jsp";
			}
			else
			{
				if(!matKhauMoi.equals(matKhauMoiNhapLai))
				{
					baoLoi += "Mật khẩu không khớp. Vui lòng nhập lại";
					url = "/DoiMatKhau.jsp";
				}
				else
				{
					String matKhauMoiMaHoa = MaHoa.toSHA1(matKhauMoiNhapLai);
					khachHang.setMatKhau(matKhauMoiMaHoa);
					KhachHangDAO khachHangDAO = new KhachHangDAO();
					if(khachHangDAO.updatePassword(khachHang))
					{
						baoLoi += "Mật khẩu đã thay đổi thành công";
						url = "/DangNhap.jsp";
					}
					else
					{
						baoLoi += "Quá trình thay đổi mật khẩu không thành công";
						url = "/DoiMatKhau.jsp";
					}
				}
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
		doGet(request, response);
	}

}
