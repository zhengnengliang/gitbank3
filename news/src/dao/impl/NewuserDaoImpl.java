package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NewuserDao;
import entity.News;
import entity.Newuser;

public class NewuserDaoImpl extends BaseDao implements  NewuserDao {


	public List<Newuser> query(String field, Object a, Object orderby, int limit,String order) {
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<Newuser> list=new ArrayList<Newuser>();
		  try {				
				  StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`news_users`  WHERE "+field+" = '"+a+"'");
				  if(orderby!=null){
					  sql.append(" " +"ORDER BY" + " "+orderby +" "+ order+"  ");
				  }
				  if(limit>=0){
					  sql.append("limit" +" "+ limit);
				  }
				  stat=con.prepareStatement(sql.toString());
				  rs =stat. executeQuery(sql.toString());
                while(rs.next()){
                	Newuser news=new Newuser();
					 news.setuID(rs.getInt(1));
					 news.setuName(rs.getString(2));
					 news.setuPwd(rs.getString(3));
					 list.add(news);
            }
		} catch (SQLException e) {
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	
	}
	public List<Newuser> queryall() {
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<Newuser> list=new ArrayList<Newuser>();
		  try {				
				  StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`news_users` ");
				System.out.println(sql.toString());
				  stat=con.prepareStatement(sql.toString());
				  rs =stat. executeQuery(sql.toString());
                while(rs.next()){
                	Newuser news=new Newuser();
					 news.setuID(rs.getInt(1));
					 news.setuName(rs.getString(2));
					 news.setuPwd(rs.getString(3));
					 list.add(news);
            }
		} catch (SQLException e) {
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	
	}


}
