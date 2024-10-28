package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia>{
	private ArrayList<TacGia> data = new ArrayList<TacGia>();
	@Override
	public ArrayList<TacGia> selectAll()
	{
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM tacgia";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			System.out.print(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTacGia = rs.getNString("matacgia");
				String hoVaTen = rs.getNString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getNString("tieusu");
				
				TacGia tacgia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				ketQua.add(tacgia);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public TacGia selectById(String ma)
	{
		TacGia tacGia = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM tacgia WHERE matacgia = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ma);
			
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTacGia = rs.getNString("matacgia");
				String hoVaTen = rs.getNString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getNString("tieusu");
				
				tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;
			}
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tacGia;
	}
	
	public TacGia selectObj(TacGia tacGia)
	{
		TacGia ketQua = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM tacgia WHERE matacgia = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, tacGia.getMaTacGia());
			
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTacGia = rs.getNString("matacgia");
				String hoVaTen = rs.getNString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getNString("tieusu");
				
				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	@Override
	public int insert(TacGia tacgia)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO tacgia(matacgia, hovaten, ngaysinh, tieusu) "
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, tacgia.getMaTacGia());
			ps.setString(2, tacgia.getHoVaTen());
			ps.setDate(3, tacgia.getNgaySinh());
			ps.setString(4, tacgia.getTieuSu());
			
			ketQua = ps.executeUpdate();
		
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int insertAll(ArrayList<TacGia> list)
	{
		int dem = 0;
		for(TacGia tacGia : list)
		{
			dem += insert(tacGia);
		}
		return dem;
	}
	@Override
	public int delete(TacGia tacgia)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM tacgia WHERE matacgia = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, tacgia.getMaTacGia());
			
			ketQua = ps.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int deleteAll(ArrayList<TacGia> list)
	{
		int dem = 0;
		for(TacGia tacgia : list)
		{
			dem += this.delete(tacgia);
		}
		return dem;
	}
	@Override
	public int update(TacGia tacgia)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "UPDATE tacgia "
					+ "SET "
					+ "hovaten = ?"
					+ ", ngaysinh = ?"
					+ ", tieusu = ?"
					+ "WHERE matacgia = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,  tacgia.getHoVaTen());
			ps.setDate(2, tacgia.getNgaySinh());
			ps.setString(3, tacgia.getTieuSu());
			ps.setString(4, tacgia.getMaTacGia());
			
			
			ketQua = ps.executeUpdate();
			
			System.out.println(ketQua + " SQL : " + sql);
			
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	public static void main(String[] args) {
		TacGiaDAO tacGiaDAO = new TacGiaDAO();
		
		
		TacGia tacGia2 = new TacGia("TG6", "Linh Ngan" , null, "khong xinh");
		System.out.println("Ket Qua : " + tacGiaDAO.update(tacGia2));
		ArrayList<TacGia> list = tacGiaDAO.selectAll();
		
		for(TacGia tacgia : list)
		{
			System.out.println(tacgia.toString());
		}
	}
}
