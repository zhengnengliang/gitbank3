package dao;

import java.util.List;

import entity.News;
import entity.Newuser;

public interface  NewuserDao {
	public List<Newuser> query( String field,Object a,Object orderby,int limit ,String order);

}
