package cn.smbms.dao.bill;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;

public interface BillDao {
	/**
	 * ���Ӷ���
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int add(Bill bill)throws Exception;


	/**
	 * ͨ����ѯ������ȡ��Ӧ���б�-ģ����ѯ-getBillList
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public List<Bill> getBillList(Bill bill)throws Exception;
	
	/**
	 * ͨ��delIdɾ��Bill
	 * @param connection
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteBillById(Integer delId)throws Exception; 
	
	
	/**
	 * ͨ��billId��ȡBill
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bill getBillById(@Param("id")Integer id)throws Exception; 
	
	/**
	 * �޸Ķ�����Ϣ
	 * @param connection
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int modify(Bill bill)throws Exception;

	/**
	 * ���ݹ�Ӧ��ID��ѯ��������
	 * @param connection
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public int getBillCountByProviderId(Integer providerId)throws Exception;

}
