package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.AbstractSocketConnection;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{

	private ArrayList<TheLoai> list = new ArrayList<TheLoai>();
	
	@Override
	public ArrayList<TheLoai> selectAll()
	{
		ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTheLoai = rs.getNString("matheloai");
				String tenTheLoai = rs.getNString("tentheloai");
				
				TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);
				ketQua.add(theLoai);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public TheLoai selectById(String ma)
	{
		TheLoai ketQua = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai WHERE matheloai = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ma);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTheLoai = rs.getNString("matheloai");
				String tenTheLoai = rs.getNString("tentheloai");
				
				ketQua = new TheLoai(maTheLoai, tenTheLoai);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public TheLoai selectById(TheLoai theLoai)
	{
		TheLoai ketQua = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM theloai WHERE matheloai = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, theLoai.getMaTheLoai());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String maTheLoai = rs.getNString("matheloai");
				String tenTheLoai = rs.getNString("tentheloai");
				
				ketQua = new TheLoai(maTheLoai, tenTheLoai);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int insert(TheLoai theloai)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO theloai(matheloai, tentheloai)"
					+ "VALUE ( ? , ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, theloai.getMaTheLoai());
			ps.setString(2, theloai.getTenTheLoai());
			
			ketQua = ps.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int insertAll(ArrayList<TheLoai> list)
	{
		int dem = 0;
		for(TheLoai theloai : list)
		{
			dem += insert(theloai);
		}
		return dem;
	}
	@Override
	public int delete(TheLoai theloai)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM theloai WHERE matheloai = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, theloai.getMaTheLoai());
			ketQua = ps.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public int deleteAll(ArrayList<TheLoai> list)
	{
		int dem = 0;
		for(TheLoai theloai : list)
		{
			dem += delete(theloai);
		}
		return dem;
	}
	@Override
	public int update(TheLoai theloai)
	{
		int ketQua = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			
			String sql = "UPDATE theloai SET tentheloai = ? WHERE matheloai = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, theloai.getTenTheLoai());
			ps.setString(2, theloai.getMaTheLoai());
			
			ketQua = ps.executeUpdate();
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	public static void main(String[] args) {
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		TheLoai theLoai = new TheLoai("CT" , "Minh Nghia");
		theLoaiDAO.update(theLoai);
	}
}
