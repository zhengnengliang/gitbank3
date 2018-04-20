package cn.itrip.dao.itriphotel;

import org.apache.ibatis.annotations.Param;

import cn.itrip.beans.pojo.ItripUser;

public interface ItripUserMapper {
	
	/**
	 * 通过userCode查询itripUser
	 * @param connection
	 * @param userCode  
	 * @return   
	 * @throws Exception
	 */
	public ItripUser getLoginUser(@Param("userCode") String userCode)throws Exception;
	
	
	/**
	 * 增加user用户
	 * @param userCode
	 * @return
	 *//*
	public int addItripUser(@Param("userCode") String userCode,@Param("userPassword") String userPassword);*/
	
	/**
	 * 增加user用户
	 * @param itripUser
	 * @return
	 */
	public int addItripUser(ItripUser itripUser);
		
}
