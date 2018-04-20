package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	  /**
     * ��ѯ���ӷ���
     * @return
     */
		public Connection getConnection(){
		
				 Context ctx = null;
				try {
					ctx = new InitialContext();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 DataSource ds = null;
				try {
					ds = (DataSource) ctx.lookup("java:comp/env/jdbc/news");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 Connection con = null;
				try {
					con = ds.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			
			return con;
			}
		
		/**
		 * ��ɾ�������
		 * @return
		 */
		public Connection getConnection2(){
			   Connection conn=null;
			   try {
					Class .forName("com.mysql.jdbc.Driver");
			   } catch (ClassNotFoundException e) {
					e.printStackTrace();
			   }
			   try {
					String url="jdbc:mysql://localhost:3306/newsystem?useUnicode=true&characterEncoding=utf-8";
					String username="root";
					String password="123";
					conn= DriverManager.getConnection(url,username,password);
			   } catch (SQLException e) {
				e.printStackTrace();
			  }
			return conn;
		}
		
		
		/**
		 * PreparedStatment��ɾ�������
		 */
		public Connection getConnection3(){
			 Connection conn=null;

			 try {
				 Class .forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				String url="jdbc:mysql://localhost:3306/newsystem?useUnicode=true&characterEncoding=utf-8";
				String username="root";
				String password="123";
						conn= DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			return conn;
		}
		
	   /**
	    * �رղ�ѯ����
	    * @param rs
	    * @param stat
	    * @param con
	    */
		public void  closeAll(ResultSet rs,Statement pstmt,Connection con){
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null!=pstmt){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			
			if(null!=con){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		/**
		 * �ر�Statement���ӣ�ɾ�����޸ĵ�����
		 * @param stat
		 * @param con
		 */
		public void  closeAll2(PreparedStatement stat,Connection con){
			if(null!=stat){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			
			if(null!=con){
				try {
					con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}
			}
		}
		


		/**
		 * �ر�PreparedStatement��ѯ������
		 * @param rs
		 * @param pstat
		 * @param con
		 */
		
		public void  closeAll3(ResultSet rs,PreparedStatement pstat,Connection con){
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			if(null!=pstat){
				try {
					pstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			
			if(null!=con){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	
		
}
