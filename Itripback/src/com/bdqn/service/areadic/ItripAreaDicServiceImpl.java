package com.bdqn.service.areadic;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bdqn.dao.itripAreaDic.ItripAreaDicMapper;
import com.bdqn.pojo.ItripAreaDic;
@Service
public class ItripAreaDicServiceImpl implements ItripAreaDicService {
	
	@Resource
	private ItripAreaDicMapper itripAreaDicMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripAreaDic = -1;
		try {
			deleteItripAreaDic = itripAreaDicMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripAreaDic;
	}

	@Override
	public int insertSelective(ItripAreaDic record) {
		int insertItripAreaDic = -1;
		try {
			insertItripAreaDic = itripAreaDicMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripAreaDic;
	}

	@Override
	public List<ItripAreaDic> selectByName(String name) {
		List<ItripAreaDic> selectItripAreaDic = null;
		try {
			selectItripAreaDic = itripAreaDicMapper.selectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripAreaDic;
	}

	@Override
	public ItripAreaDic selectById(String id) {
		ItripAreaDic selectItripAreaDic = null;
		try {
			selectItripAreaDic = itripAreaDicMapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripAreaDic;
	}

	
	@Override
	public int updateByPrimaryKeySelective(ItripAreaDic record) {
		int updateItripAreaDic = -1;
		try {
			updateItripAreaDic = itripAreaDicMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripAreaDic;
	}

}
