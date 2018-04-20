package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.CommentsDao;
import dao.NewsDao;
import entity.Comments;
import entity.News;

public class CommentDaoImpl extends BaseDao implements CommentsDao {

	/**
	 * 条件查询
	 */
	public List<Comments> query(String field, Object a, Object orderby,int limit, String order) {
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<Comments> list=new ArrayList<Comments>();
		  try {				
				  StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`comments`  WHERE "+field+" = '"+a+"'");
				  if(orderby!=null){
					  sql.append(" " +"ORDER BY" + " "+orderby +" "+ order+"  ");
				  }
				  if(limit>=0){
					  sql.append("limit" +" "+ limit);
				  }
				  stat=con.prepareStatement(sql.toString());
				  rs =stat. executeQuery(sql.toString());
                while(rs.next()){
                	Comments comments=new  Comments();
                	comments.setcNID(rs.getInt(2));
                	comments.setcContent(rs.getString(3));
                	comments.setcDate(rs.getTimestamp(4));
                	comments.setcIp(rs.getString(5));
                	comments.setcAuthor(rs.getString(6));
				 list.add(comments);
            }
                
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
	}

    /**
     * 添加（Comments comments）
     */
	public int addComment(Comments comments) {
		System.out.println(comments.getcContent());
		Connection con=getConnection2();
		PreparedStatement pstmt=null;
		int x=0;
	    try {
			 //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
			 String sql="INSERT INTO  `newsystem`.`comments`(`cNID`,`cContent`,`cDate`,`cIp`,`cAuthor`)VALUES(?,?,?,?,?)";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1,comments.getcNID());
			 pstmt.setString(2,comments.getcContent());
			 pstmt.setDate(3,new java.sql.Date(comments.getcDate().getTime()));
			 pstmt.setString(4,comments.getcIp());//
			 pstmt.setString(5, comments.getcAuthor());//?????????????????????????????????
			 String test=pstmt.toString();
			 x= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll2(pstmt,con);
		}
	    return x;
	}

}
