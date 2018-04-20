package cn.smbms.service.provider;

import java.util.List;




import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.smbms.dao.bill.BillDao;
import cn.smbms.dao.provider.ProviderDao;
import cn.smbms.pojo.Provider;
@Service("ProviderService")
public class ProviderServiceImpl implements ProviderService {

	@Resource
	ProviderDao providerDao;
	@Resource
	BillDao  billDao;
	
	
//	private BillDao  billDao;
	
	/*public ProviderServiceImpl(){
		providerDao = new ProviderDaoImpl();
		billDao = new BillDaoImpl();
	}*/
	@Override
	public boolean add(Provider provider) {
		// TODO Auto-generated method stub
//		boolean flag = false;
//		Connection connection = null;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);//����JDBC�������
//			if(providerDao.add(provider) > 0)
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
//			//��service�����connection���ӵĹر�
//			BaseDao.closeResource(connection, null, null);
//		}
		boolean flag = false;
		SqlSession sqlSession=null;
		int i=0;
		 try {
			i= providerDao.add(provider);
			 if(i>0){
				 flag = true;
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���쳣");
		}finally{
			
		}
		return flag;
	}

		
		
		
	@Override
	public List<Provider> getProviderList(String proName,String proCode) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		List<Provider> providerList = null;
//		System.out.println("query proName ---- > " + proName);
//		System.out.println("query proCode ---- > " + proCode);
//		try {
//			connection = BaseDao.getConnection();
//			providerList = providerDao.getProviderList(connection, proName,proCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		List<Provider> providerList = null;
		try {
/*			providerDao=(ProviderDao) new ClassPathXmlApplicationContext("applicationContext-mybatis.xml").getBean("providerDao");
*/			providerList=providerDao.getProviderList(proName,proCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���쳣");
		}finally{
			
		}
		return providerList;
	}

	/**
	 * ҵ�񣺸���IDɾ����Ӧ�̱������֮ǰ����Ҫ��ȥ����������в�ѯ����
	 * �����������޸ù�Ӧ�̵Ķ������ݣ������ɾ��
	 * ���иù�Ӧ�̵Ķ������ݣ��򲻿���ɾ��
	 * ����ֵbillCount
	 * 1> billCount == 0  ɾ��---1 �ɹ� ��0�� 2 ���ɹ� ��-1��
	 * 2> billCount > 0    ����ɾ�� ��ѯ�ɹ���0����ѯ���ɹ���-1��
	 * 
	 * ---�ж�
	 * ���billCount = -1 ʧ��
	 * ��billCount >= 0 �ɹ�
	 */
	@Override
	public int deleteProviderById(String delId) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		int billCount = -1;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);
//			billCount = billDao.getBillCountByProviderId(connection,delId);
//			if(billCount == 0){
//				providerDao.deleteProviderById(connection, delId);
//			}
//			connection.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			billCount = -1;
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		
		
		int billCount = -1;
		int id=Integer.parseInt(delId);
		try {
			
			billCount=billDao.getBillCountByProviderId(id);
			if(billCount == 0){
				providerDao.deleteProviderById(id);
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ϵͳ�����쳣");
		}finally{
			
		}
		return billCount;
	}

	@Override
	public Provider getProviderById(String id) {
		// TODO Auto-generated method stub
//		Provider provider = null;
//		Connection connection = null;
//		try{
//			connection = BaseDao.getConnection();
//			provider = providerDao.getProviderById(connection, id);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			provider = null;
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
		Provider provider = null;
		Integer pid=Integer.parseInt(id);
		try {
			provider=providerDao.getProviderById(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ϵͳ��������쳣");
		}finally{
		}
		
		return provider;
	}

	@Override
	public boolean modify(Provider provider) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(providerDao.modify(connection,provider) > 0)
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
			i=providerDao.modify(provider);
			if (i>0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return flag;
	}

}
