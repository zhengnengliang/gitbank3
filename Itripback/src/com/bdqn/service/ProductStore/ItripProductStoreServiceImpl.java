package com.bdqn.service.ProductStore;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.ItripProductStore.ItripProductStoreMapper;
import com.bdqn.pojo.ItripProductStore;
@Service
public class ItripProductStoreServiceImpl implements ItripProductStoreService {
	@Resource
	private ItripProductStoreMapper itripProductStoreMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripProductStore = -1;
		try {
			deleteItripProductStore = itripProductStoreMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripProductStore;
	}

	@Override
	public int insertSelective(ItripProductStore record) {
		int insertItripProductStore = -1;
		try {
			insertItripProductStore = itripProductStoreMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripProductStore;
	}

	@Override
	public List<ItripProductStore> selectByPrimaryKey(Long id) {
		List<ItripProductStore> selectItripProductStore = null;
		try {
			selectItripProductStore = itripProductStoreMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripProductStore;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripProductStore record) {
		int updateItripProductStore = -1;
		try {
			updateItripProductStore = itripProductStoreMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripProductStore;
	}
}
