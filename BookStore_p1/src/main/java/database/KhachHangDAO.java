package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{
	
	private ArrayList<KhachHang> listkh = new ArrayList<KhachHang>();
	@Override
	public ArrayList<KhachHang> selectAll()
	{
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM khachhang";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maKhachHang = rs.getNString("makhachhang");
				String tenDangNhap = rs.getNString("tendangnhap");
				String matKhau = rs.getNString("matkhau");
				String hoten = rs.getNString("hoten");
				String gioiTinh = rs.getNString("gioitinh");
				String diaChi = rs.getNString("diachi");
				String diaChiNhanHang = rs.getNString("diachinhanhang");
				String diaChiMuaHang = rs.getNString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getNString("sodienthoai");
				String email = rs.getNString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoten, gioiTinh, diaChi, diaChiMuaHang,
						diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
				ketQua.add(khachHang);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public KhachHang selectById(String ma)
	{
		KhachHang tim = new KhachHang();
		tim.setMaKhachHang(ma);
		for(KhachHang khachhang : listkh)
		{
			if(khachhang.equals(tim))
			{
				return khachhang;
			}
		}
		return null;
	}
	
	public KhachHang selectById(KhachHang khachHang)
	{
		KhachHang ketQua = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM khachhang WHERE makhachhang = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, khachHang.getMaKhachHang());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String maKhachHang = rs.getNString("makhachhang");
				String tenDangNhap = rs.getNString("tendangnhap");
				String matKhau = rs.getNString("matkhau");
				String hoten = rs.getNString("hoten");
				String gioiTinh = rs.getNString("gioitinh");
				String diaChi = rs.getNString("diachi");
				String diaChiNhanHang = rs.getNString("diachinhanhang");
				String diaChiMuaHang = rs.getNString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getNString("sodienthoai");
				String email = rs.getNString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				ketQua = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoten, gioiTinh, diaChi, diaChiMuaHang,
						diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	public KhachHang selectByUserNamePassword(KhachHang khachHang)
	{
		KhachHang ketQua = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM khachhang WHERE tendangnhap = ? AND matkhau = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, khachHang.getTenDangNhap());
			ps.setString(2, khachHang.getMatKhau());
			
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String maKhachHang = rs.getNString("makhachhang");
				String tenDangNhap = rs.getNString("tendangnhap");
				String matKhau = rs.getNString("matkhau");
				String hoten = rs.getNString("hoten");
				String gioiTinh = rs.getNString("gioitinh");
				String diaChi = rs.getNString("diachi");
				String diaChiNhanHang = rs.getNString("diachinhanhang");
				String diaChiMuaHang = rs.getNString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getNString("sodienthoai");
				String email = rs.getNString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				ketQua = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoten, gioiTinh, diaChi, diaChiMuaHang,
						diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int insert(KhachHang khachhang)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO khachhang(makhachhang,tendangnhap, matkhau,hoten,gioitinh,diachi,"
					+ "diachinhanhang, diachimuahang,ngaysinh, sodienthoai,email,dangkinhanbangtin)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, khachhang.getMaKhachHang());
			ps.setString(2, khachhang.getTenDangNhap());
			ps.setString(3, khachhang.getMatKhau());
			ps.setString(4, khachhang.getHoVaTen());
			ps.setString(5, khachhang.getGioiTinh());
			ps.setString(6, khachhang.getDiaChi());
			ps.setString(7, khachhang.getDiaChiNhanHang());
			ps.setString(8, khachhang.getDiaChiMuaHang());
			ps.setDate(9, khachhang.getNgaySinh());
			ps.setString(10, khachhang.getSoDienThoai());
			ps.setString(11, khachhang.getEmail());
			ps.setBoolean(12, khachhang.isDangKyNhanBangTin());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int insertAll(ArrayList<KhachHang> list)
	{
		int dem = 0;
		for(KhachHang khachhang : list)
		{
			dem += this.insert(khachhang);
		}
		return dem;
	}
	@Override
	public int delete(KhachHang khachhang)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM khachhang WHERE makhachhang = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, khachhang.getMaKhachHang());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int deleteAll(ArrayList<KhachHang> list)
	{
		int dem = 0;
		for(KhachHang khachhang : list)
		{
			dem += delete(khachhang);
		}
		return dem;
	}
	@Override
	public int update(KhachHang khachhang)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "UPDATE khachhang SET "
		             + "hoten = ?, "
		             + "gioitinh = ?, "
		             + "diachi = ?, "
		             + "diachinhanhang = ?, "
		             + "diachimuahang = ?, "
		             + "ngaysinh = ?, "
		             + "sodienthoai = ?, "
		             + "email = ?, "
		             + "dangkinhanbangtin = ? "
		             + "WHERE makhachhang = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, khachhang.getHoVaTen());
			ps.setString(2, khachhang.getGioiTinh());
			ps.setString(3, khachhang.getDiaChi());
			ps.setString(4, khachhang.getDiaChiNhanHang());
			ps.setString(5, khachhang.getDiaChiMuaHang());
			ps.setDate(6, khachhang.getNgaySinh());
			ps.setString(7, khachhang.getSoDienThoai());
			ps.setString(8, khachhang.getEmail());
			ps.setBoolean(9, khachhang.isDangKyNhanBangTin());
			ps.setString(10, khachhang.getMaKhachHang());
			
			System.out.println(sql);
			ketQua = ps.executeUpdate();
			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public boolean updatePassword(KhachHang khachHang) {
        String sql = "UPDATE KhachHang SET matKhau = ? WHERE makhachhang = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, khachHang.getMatKhau());
            ps.setString(2, khachHang.getMaKhachHang());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean selectByTenKhachHang(String tenKhachHang)
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM khachhang WHERE tendangnhap = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, tenKhachHang);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		KhachHangDAO khachHangDAO = new KhachHangDAO();
//		ArrayList<KhachHang> khachHangs = khachHangDAO.selectAll();
//		for(KhachHang khachHang : khachHangs)
//		{
//			System.out.println(khachHang.toString());
//		}
		
		KhachHang kh = new KhachHang();
//		kh.setTenDangNhap("nghia");
//		kh.setMatKhau("123");
//		System.out.println(khachHangDAO.selectByUserNamePassword(kh).toString());
//		System.out.println(khachHangDAO.selectById(kh));
//		System.out.println(khachHangDAO.selectByTenKhachHang("minhngh"));
		kh.setMatKhau("1234");
		KhachHang kh1 = new KhachHang(null, null, null, null, null, null, null, null, null, null, null, false);
		khachHangDAO.updatePassword(kh);
	}
}
