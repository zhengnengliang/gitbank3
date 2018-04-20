package cn.itrip.service.itriphotel;

import cn.itrip.beans.pojo.ItripUser;

public interface ItripUserService {
	
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public ItripUser login(String userCode,String userPassword);
	
	/**
	 * 用户增加
	 * @param userCode
	 * @param userPassword
	 * @return
	 *//*
	public int addItripUser(String userCode,String userPassword);*/
	
	
	/**
	 * 增加user用户
	 * @param itripUser
	 * @return
	 */
	public int addItripUser(ItripUser itripUser);
}