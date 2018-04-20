package com.bdqn.service.LabelDic;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.ItripLabelDic.ItripLabelDicMapper;
import com.bdqn.pojo.ItripLabelDic;
@Service
public class ItripLabelDicServiceImpl implements ItripLabelDicService {
	@Resource
	private ItripLabelDicMapper itripLabelDicMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripLabelDic = -1;
		try {
			deleteItripLabelDic = itripLabelDicMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripLabelDic;
	}

	@Override
	public int insertSelective(ItripLabelDic record) {
		int insertItripLabelDic = -1;
		try {
			insertItripLabelDic = itripLabelDicMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripLabelDic;
	}

	@Override
	public List<ItripLabelDic> selectByName(String name) {
		List<ItripLabelDic> selectItripLabelDic = null;
		try {
			selectItripLabelDic = itripLabelDicMapper.selectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripLabelDic;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripLabelDic record) {
		int updateItripLabelDic = -1;
		try {
			updateItripLabelDic = itripLabelDicMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripLabelDic;
	}

}
