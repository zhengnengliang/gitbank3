package cn.smbms.service.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.smbms.MyBatisUtil;
import cn.smbms.dao.BaseDao;
import cn.smbms.dao.bill.BillDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillServiceImpl;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
	 private static final Logger log=Logger.getLogger(UserServiceImpl.class);
		@Resource
	UserDao userDao;

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
//		
//		boolean flag = false;
//		Connection connection = null;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);//开启JDBC事务管理
//			int updateRows = userDao.add(user);
//			connection.commit();
//			if(updateRows > 0){
//				flag = true;
//				System.out.println("add success!");
//			}else{
//				System.out.println("add failed!");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				System.out.println("rollback==================");
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}finally{
//			//在service层进行connection连接的关闭
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		int updateRows=0;
		try {
				updateRows=userDao.add(user);
				if(updateRows > 0){
					flag = true;
					System.out.println("add success!");
				}else{
					System.out.println("add failed!");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return flag;
	}
	
	
	
	
	@Override
	public User login(String userName, String userPassword) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		User user = null;
//		try {
//			
//			user = userDao.getLoginUser( userCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//匹配密码
//		if(null != user){
//			if(!user.getUserPassword().equals(userPassword))
//				user = null;
//		}
		User user = null;
		try {
			user=userDao.getLoginUser(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}
	
	
	
	@Override
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		List<User> userList = null;
//		System.out.println("queryUserName ---- > " + queryUserName);
//		System.out.println("queryUserRole ---- > " + queryUserRole);
//		System.out.println("currentPageNo ---- > " + currentPageNo);
//		System.out.println("pageSize ---- > " + pageSize);
//		try {
//			connection = BaseDao.getConnection();
//			userList = userDao.getUserList( queryUserName,queryUserRole,currentPageNo,pageSize);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		List<User> userList = null;
		int fenye=(currentPageNo-1)*pageSize;
		try {
			userList=userDao.getUserList(queryUserName,queryUserRole,fenye,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return userList;
	}
	
	
	
	
	
	@Override
	public User selectUserCodeExist(String userCode) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		User user = null;
//		try {
//			connection = BaseDao.getConnection();
//			user = userDao.getLoginUser( userCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		User user = null;
		try {
			user=userDao.getLoginUser(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return user;
	}
	
	
	
	
	
	@Override
	public boolean deleteUserById(Integer delId) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(userDao.deleteUserById(delId) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		int i=0;
		try {
			i=userDao.deleteUserById(delId);
			if(i>0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return flag;
	}
	
	
	
	
	
	
	@Override
	public User getUserById(Integer id){
		// TODO Auto-generated method stub
//		User user = null;
//		Connection connection = null;
//		try{
//			connection = BaseDao.getConnection();
//			user = userDao.getUserById(id);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			user = null;
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		User user = null;
		try {
			user=userDao.getUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return user;
	}
		
		
		
	
	
	
	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(userDao.modify(user) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		int i=0;
		try {
			i=userDao.modify(user);
			if(i>0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return flag;
	}
	
	
	
	
	
	@Override
	public boolean updatePwd(int id, String pwd) {
		// TODO Auto-generated method stub
//		boolean flag = false;
//		Connection connection = null;
//		try{
//			connection = BaseDao.getConnection();
//			if(userDao.updatePwd(id,pwd) > 0)
//				flag = true;
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		int i=0;
		try {
			i=userDao.updatePwd(id,pwd);
			if(i > 0){
				flag = true;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return flag;
	}
	
	
	
	@Override
	public int getUserCount(String queryUserName, int queryUserRole) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		int count = 0;
//		System.out.println("queryUserName ---- > " + queryUserName);
//		System.out.println("queryUserRole ---- > " + queryUserRole);
//		try {
//			connection = BaseDao.getConnection();
//			count = userDao.getUserCount(queryUserName,queryUserRole);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		int count = 0;
		try {
			count=userDao.getUserCount(queryUserName,queryUserRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return count;
	}
	

	
}
