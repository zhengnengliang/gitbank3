package cn.smbms.service.bill;

import java.sql.Connection;
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
import cn.smbms.dao.provider.ProviderDao;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;


@Service("BillService")
public class BillServiceImpl implements BillService {
	 private static final Logger log=Logger.getLogger(BillServiceImpl.class);
	
	 @Resource 
	private BillDao billDao;




	/*public BillServiceImpl(){
		billDao = new BillDaoImpl();
	}*/
	@Override
	public boolean add(Bill bill) {
		// TODO Auto-generated method stub
//		boolean flag = false;
//		Connection connection = null;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);//开启JDBC事务管理
//			if(billDao.add(connection,bill) > 0)
//				flag = true;
//			connection.commit();
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
		int i=0;
			try {
				i=billDao.add(bill);
				if(i>0){
				flag = true;}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			}
		return flag;
	}

	@Override
	public List<Bill> getBillList(Bill bill) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		List<Bill> billList = null;
//		System.out.println("query productName ---- > " + bill.getProductName());
//		System.out.println("query providerId ---- > " + bill.getProviderId());
//		System.out.println("query isPayment ---- > " + bill.getIsPayment());
//		
//		try {
//			connection = BaseDao.getConnection();
//			billList = billDao.getBillList(connection, bill);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		List<Bill> billList = null;
		try {
			billList=billDao.getBillList(bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return billList;
	}

	
	
	@Override
	public boolean deleteBillById(String delId) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(billDao.deleteBillById(connection, delId) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		int i=0;
		int id=Integer.parseInt(delId);
		try {
			i=billDao.deleteBillById(id);
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
	public Bill getBillById(String id) {
		// TODO Auto-generated method stub
//		Bill bill = null;
//		Connection connection = null;
//		try{
//			connection = BaseDao.getConnection();
//			bill = billDao.getBillById(connection, id);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			bill = null;
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		Bill bill = null;
		int delId=Integer.parseInt(id);
		try {
			bill=billDao.getBillById(delId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return bill;
		}
		
	}

	@Override
	public boolean modify(Bill bill) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(billDao.modify(connection,bill) > 0)
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
			i=billDao.modify(bill);
			if(i>0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return flag;
		}
		
	}

}
