package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TopicDao;
import entity.News;
import entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao{
	public List<Topic> query(Object field,Object a,Object orderby,int limit ,String order  ){
		Connection con=getConnection();
		  PreparedStatement stat=null;
		  ResultSet rs=null;
		  List<Topic> list=new ArrayList<Topic>();
		  try {	
				
				 StringBuffer sql=new StringBuffer("SELECT * FROM `newsystem`.`topic` WHERE "+field+" = "+a+"");
				  if(orderby!=null){
					  sql.append(" "+"ORDER BY"  +" "+  orderby +" "+ order+"");
				  }
				 if(limit>=0){
					  sql.append("limit" +" " + limit);
				  }
				 System.out.println(sql.toString());
				 stat=con.prepareStatement(sql.toString());
				 rs =stat. executeQuery(sql.toString());
                  while(rs.next()){
					 Topic topic=new Topic();
					 topic.settID(rs.getInt(1));
					 topic.settName(rs.getString(2));
					 list.add(topic);
                 }
		} catch (SQLException e) {
		}finally{
	           closeAll(rs,stat,con);
	    }
		  return list;
}
   /**
    * 添加新闻标题
    */
	public int addtitle(Topic topic){
			Connection con=getConnection2();
			PreparedStatement pstmt=null;
			int x=0;
		    try {
				 //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
				
				 String sql="INSERT INTO  `newsystem`.`topic`(`tName`)VALUES(?)";
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1,topic.gettName());
				 x= pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll2(pstmt,con);
			}
		    return x;
		}
	
	
	/**
	 * 修改新闻标题
	 */
	public int modifypet(Topic topic,String  b,Object a){
		Connection con= getConnection2();
		PreparedStatement  pstmt=null;
		int x=0;
	    try {
			
			 String sql="UPDATE `newsystem`.`topic` SET  `tName` =? WHERE "+b+" = "+a+"";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,topic.gettName());
			 x= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll2(pstmt,con);
		}
	    return x;
	}
	
	/**
	 * 删除新闻标题
	 */
	public int delete(String pro,Object o) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int i=0;
		try {
			con=getConnection2();
			
			String sql="DELETE FROM `newsystem`.`topic` WHERE "+pro+"= "+o+"";
			pstmt=con.prepareStatement(sql);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 closeAll2(pstmt,con);
		}return i;
	}
	}

