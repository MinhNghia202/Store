package database;

import java.util.ArrayList;

import model.DonHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	
	private ArrayList<DonHang> listdh = new ArrayList<DonHang>();
	@Override
	public ArrayList<DonHang> selectAll()
	{
		return listdh;
	}
	@Override
	public DonHang selectById(String ma)
	{
		DonHang tim = new DonHang();
		tim.setMaDonHang(ma);
		for(DonHang donhang : listdh)
		{
			if(donhang.equals(tim))
			{
				return donhang;
			}
		}
		return null;
	}
	@Override
	public int insert(DonHang donhang)
	{
		DonHang kiemtratontai = this.selectById(donhang.getMaDonHang());
		if(kiemtratontai == null)
		{
			listdh.add(donhang);
			return 1;
		}
		return 0;
	}
	@Override
	public int insertAll(ArrayList<DonHang> list)
	{
		int dem = 0;
		for(DonHang donhang : list)
		{
			dem += this.insert(donhang);
		}
		return dem;
	}
	@Override
	public int delete(DonHang donhang)
	{
		DonHang kiemtratontai = this.selectById(donhang.getMaDonHang());
		if(kiemtratontai != null)
		{
			ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
			ctdh.deleteByDonHang(donhang);
			listdh.remove(donhang);
			return 1;
		}
		return 0;
	}
	@Override
	public int deleteAll(ArrayList<DonHang> list)
	{
		int dem = 0;
		for(DonHang donhang : list)
		{
			dem += delete(donhang);
		}
		return dem;
	}
	@Override
	public int update(DonHang donhang)
	{
		DonHang kiemtratontai = this.selectById(donhang.getMaDonHang());
		if(kiemtratontai != null)
		{
			listdh.remove(kiemtratontai);
			listdh.add(donhang);
			return 1;
		}
		return 0;
	}
}
