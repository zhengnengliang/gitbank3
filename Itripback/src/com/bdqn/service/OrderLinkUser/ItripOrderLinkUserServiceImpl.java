package com.bdqn.service.OrderLinkUser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.ItripOrderLinkUser.ItripOrderLinkUserMapper;
import com.bdqn.pojo.ItripOrderLinkUser;
@Service
public class ItripOrderLinkUserServiceImpl implements ItripOrderLinkUserService {
	@Resource
	private ItripOrderLinkUserMapper itripOrderLinkUserMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripOrderLinkUser = -1;
		try {
			deleteItripOrderLinkUser = itripOrderLinkUserMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripOrderLinkUser;
	}

	@Override
	public int insertSelective(ItripOrderLinkUser record) {
		int insertItripOrderLinkUser = -1;
		try {
			insertItripOrderLinkUser = itripOrderLinkUserMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripOrderLinkUser;
	}

	@Override
	public List<ItripOrderLinkUser> selectByPrimaryKey(Long id) {
		List<ItripOrderLinkUser> selectItripOrderLinkUser = null;
		try {
			selectItripOrderLinkUser = itripOrderLinkUserMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripOrderLinkUser;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripOrderLinkUser record) {
		int updateItripOrderLinkUser = -1;
		try {
			updateItripOrderLinkUser = itripOrderLinkUserMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripOrderLinkUser;
	}

}
