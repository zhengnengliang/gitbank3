package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.*;
import java.sql.*;

import dao.NewsDao;
import entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao  {
			/**
			 * 根据字段和字段值来查询
			 */
	public List<News> query( String field,Object a,Object orderby,int limit ,String order){
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<News> list=new ArrayList<News>();
		  try {				
				  StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`news`  WHERE "+field+" = "+a+"");
				  if(orderby!=null){
					  sql.append(" " +"ORDER BY" + " "+orderby +" "+ order+"  ");
				  }
				  if(limit>=0){
					  sql.append("limit" +" "+ limit);
				  }
				  stat=con.prepareStatement(sql.toString());
				  
				  rs =stat.executeQuery(sql.toString());
                  while(rs.next()){
                	 News news=new News();
  					 news.setnID(rs.getInt(1));
  					 news.setnTID(rs.getInt(2));
  					 news.setnTitle(rs.getString(3));
  					 news.setnAuthor(rs.getString(4));
  					 news.setnCreatedate(rs.getTimestamp(5));
  					 news.setnPicpath(rs.getString(6));
  					 news.setnContent(rs.getString(7));
  					 news.setnModifydate(rs.getTimestamp(8));
  					 news.setnSummary(rs.getString(9));
  					 list.add(news);
              }
                  System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	}
	/**
	 * 查询新闻所有
	 */
	public List<News> queryall1( ){
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<News> list=new ArrayList<News>();
		  try {				
				  String sql="SELECT * FROM `newsystem`.`news`";
				  stat=con.prepareStatement(sql);
				  rs =stat. executeQuery();
                  while(rs.next()){
                	 News news=new News();
 					 news.setnID(rs.getInt(1));
 					 news.setnTID(rs.getInt(2));
 					 news.setnTitle(rs.getString(3));
 					 news.setnAuthor(rs.getString(4));
 					 news.setnCreatedate(rs.getTimestamp(5));
 					 news.setnPicpath(rs.getString(6));
 					 news.setnContent(rs.getString(7));
 					 news.setnModifydate(rs.getTimestamp(8));
 					 news.setnSummary(rs.getString(9));
 					 list.add(news);
              }
		} catch (SQLException e) {
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	}

	/**
	 * 添加新闻
	 */
	public int Addnews(News news) {
		Connection con=getConnection2();
		PreparedStatement pstmt=null;
		int x=0;
	    try {
			 //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
			 Object owner2=null;
			 Object owner1=null;
			 String sql="INSERT INTO  `newsystem`.`news`(`NTID`,`NTITLE`,`NAUTHOR`,`NCREATEDATE`,`NPICPATH`,`NCONTENT`,`NMODIFYDATE`,`NSUMMARY`)VALUES(?,?,?,?,?,?,?,?)";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1,news.getnTID());
			 pstmt.setString(2,news.getnTitle());
			 pstmt.setString(3,news.getnAuthor());
			 pstmt.setDate(4,new java.sql.Date(news.getnCreatedate().getTime()));//
			 pstmt.setString(5, news.getnPicpath());//?????????????????????????????????
			 pstmt.setObject(6,news.getnContent());
			 pstmt.setTimestamp(7,news.getnModifydate()==null?null:new java.sql.Timestamp(news.getnModifydate().getTime()));
			 pstmt.setString(8, news.getnSummary());
			 x= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll2(pstmt,con);
		}
	    return x;
	}
	/**
	 * 删除新闻
	 * @param a
	 * @return
	 */
	public int delete(int a) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int i=0;
		try {
			con=getConnection2();
			String sql="DELETE FROM `newsystem`.`news` WHERE `NID`= "+a+"";
			System.out.println(sql);
			 pstmt=con.prepareStatement(sql);
			 System.out.println(sql);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 closeAll2(pstmt,con);
		}return i;
	}
	 /**
	  * 修改新闻
	  * @param news
	  * @return
	  */
	public int amentNews(News news){	
	Connection con=	getConnection2();
	PreparedStatement pstmt=null;
	int x=0;
		try{ String sql="UPDATE `newsystem`.`news`  SET `NTID` = ?,`NTITLE` = ?, `NAUTHOR` = ?,`NCREATEDATE` = ?,`NPICPATH` = ?,`NCONTENT` = ?,`NMODIFYDATE` =?,`NSUMMARY`= ? WHERE `NID`="+news.getnID()+"";
		 pstmt=con.prepareStatement(sql);
		 pstmt.setInt(1,news.getnTID());
		 pstmt.setString(2,news.getnTitle());
		 pstmt.setString(3,news.getnAuthor());
		 pstmt.setTimestamp(4,new java.sql.Timestamp(news.getnCreatedate().getTime()));//
		 pstmt.setString(5, news.getnPicpath());							//
		 pstmt.setObject(6,news.getnContent());
		 pstmt.setTimestamp(7,new java.sql.Timestamp(news.getnModifydate().getTime()));
		 pstmt.setString(8, news.getnSummary());
		 x= pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		    closeAll2( pstmt,con);
	}
    return x;}
	/**
	 * 查询新闻
	 */
	  public List<News>  pagingQuery(String file,Object a,Object orderby,int limit, int paging,String order){
		  Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<News> list=new ArrayList<News>();
		  try {				
				  StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`news`  WHERE "+file+" = "+a+"");
				  if(orderby!=null){
					  sql.append(" " +"ORDER BY" + " "+orderby +" "+ order+"  ");
				  }
				  if(limit>=0){
					  sql.append("limit" +" "+ limit);
				  }
				  stat=con.prepareStatement(sql.toString());
				  
				  rs =stat.executeQuery(sql.toString());
                  while(rs.next()){
                	 News news=new News();
  					 news.setnID(rs.getInt(1));
  					 news.setnTID(rs.getInt(2));
  					 news.setnTitle(rs.getString(3));
  					 news.setnAuthor(rs.getString(4));
  					 news.setnCreatedate(rs.getTimestamp(5));
  					 news.setnPicpath(rs.getString(6));
  					 news.setnContent(rs.getString(7));
  					 news.setnModifydate(rs.getTimestamp(8));
  					 news.setnSummary(rs.getString(9));
  					 list.add(news);
              }
                  System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	}
	  
	  
	  /**
	   * 分页查询
	   */
	  public List<News> fenye(int  id,int dijiye,int zongshu){
		  Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  int q=0;
		  int w=0;
		  List<News> list=new ArrayList<News>();
		  try {	 
			  //判断limit(q,w)
		  if((zongshu-dijiye*10)-10>0)
		  		{q=(dijiye-1)*10;
		  		 w=10;}
		  else{q=(dijiye-1)*10;
		       w=10;} 
				  String sql="SELECT * FROM `newsystem`.`news` WHERE `NTID`="+id+" ORDER BY `NCREATEDATE` DESC LIMIT "+q+","+w+" ";
				  System.out.println(sql);
				  stat=con.prepareStatement(sql);
				  rs =stat. executeQuery();
                  while(rs.next()){
                	 News news=new News();
 					 news.setnID(rs.getInt(1));
 					 news.setnTID(rs.getInt(2));
 					 news.setnTitle(rs.getString(3));
 					 news.setnAuthor(rs.getString(4));
 					 news.setnCreatedate(rs.getTimestamp(5));
 					 news.setnPicpath(rs.getString(6));
 					 news.setnContent(rs.getString(7));
 					 news.setnModifydate(rs.getTimestamp(8));
 					 news.setnSummary(rs.getString(9));
 					 list.add(news);
              }
		} catch (SQLException e) {
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;  
	  }
		  
		  
		  
		  
		  
		  
	  }
	  


