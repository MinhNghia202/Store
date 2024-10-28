package database;

import java.util.ArrayList;

import model.SanPham;

public class SanPhamDAO implements DAOInterface<SanPham>{
	private ArrayList<SanPham> listsp = new ArrayList<SanPham>();
	@Override
	public ArrayList<SanPham> selectAll()
	{
		return listsp;
	}
	@Override
	public SanPham selectById(String ma)
	{
		SanPham tim = new SanPham();
		tim.setMaSanPham(ma);
		for(SanPham sp : listsp)
		{
			if(sp.equals(tim))
			{
				return sp;
			}
		}
		return null;
	}
	@Override
	public int insert(SanPham sanpham)
	{
		SanPham kiemtratontai = this.selectById(sanpham.getMaSanPham());
		if(kiemtratontai == null)
		{
			listsp.add(sanpham);
			return 1;
		}
		return 0;
	}
	@Override
	public int insertAll(ArrayList<SanPham> list)
	{
		int dem = 0;
		for(SanPham sp : list)
		{
			dem += this.insert(sp);
		}
		return dem;
	}
	@Override
	public int delete(SanPham sanpham)
	{
		SanPham kiemtratontai = this.selectById(sanpham.getMaSanPham());
		if(kiemtratontai != null)
		{
			listsp.remove(sanpham);
			return 1;
		}
		return 0;
	}
	@Override
	public int deleteAll(ArrayList<SanPham> list)
	{
		int dem = 0;
		for(SanPham sp : list)
		{
			dem += delete(sp);
		}
		return dem;
	}
	@Override
	public int update(SanPham sanpham)
	{
		SanPham kiemtratontai = this.selectById(sanpham.getMaSanPham());
		if(kiemtratontai != null)
		{
			listsp.remove(kiemtratontai);
			listsp.add(sanpham);
			return 1;
		}
		return 0;
	}
}
