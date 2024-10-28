package database;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();
	
	public T selectById(String ma);
	
	public int insert(T t);
	
	public int insertAll(ArrayList<T> t);
	
	public int delete(T t);
	
	public int deleteAll(ArrayList<T> t);
	
	public int update(T t);
}
