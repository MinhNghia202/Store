package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	
	private ArrayList<ChiTietDonHang> listdh = new ArrayList<ChiTietDonHang>();
	@Override
	public ArrayList<ChiTietDonHang> selectAll()
	{
		return listdh;
	}
	@Override
	public ChiTietDonHang selectById(String ma)
	{
		ChiTietDonHang tim = new ChiTietDonHang();
		tim.setMaChiTietDonHang(ma);
		for(ChiTietDonHang donhang : listdh)
		{
			if(donhang.equals(tim))
			{
				return donhang;
			}
		}
		return null;
	}
	@Override
	public int insert(ChiTietDonHang donhang)
	{
		ChiTietDonHang kiemtratontai = this.selectById(donhang.getMaChiTietDonHang());
		if(kiemtratontai == null)
		{
			listdh.add(donhang);
			return 1;
		}
		return 0;
	}
	@Override
	public int insertAll(ArrayList<ChiTietDonHang> list)
	{
		int dem = 0;
		for(ChiTietDonHang donhang : list)
		{
			dem += this.insert(donhang);
		}
		return dem;
	}
	@Override
	public int delete(ChiTietDonHang donhang)
	{
		ChiTietDonHang kiemtratontai = this.selectById(donhang.getMaChiTietDonHang());
		if(kiemtratontai != null)
		{
			listdh.remove(donhang);
			return 1;
		}
		return 0;
	}
	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> list)
	{
		int dem = 0;
		for(ChiTietDonHang donhang : list)
		{
			dem += delete(donhang);
		}
		return dem;
	}
	@Override
	public int update(ChiTietDonHang donhang)
	{
		ChiTietDonHang kiemtratontai = this.selectById(donhang.getMaChiTietDonHang());
		if(kiemtratontai != null)
		{
			listdh.remove(kiemtratontai);
			listdh.add(donhang);
			return 1;
		}
		return 0;
	}
	
	public int deleteByDonHang(DonHang donhang)
	{
		int dem = 0;
		for(ChiTietDonHang ctdh : listdh)
		{
			if(ctdh.getDonHang().equals(donhang))
			{
				listdh.remove(ctdh);
				dem ++;
			}
		}
		return dem;
	}
}
