package com.bdqn.service.Image;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.ItripImage.ItripImageMapper;
import com.bdqn.pojo.ItripAreaDic;
import com.bdqn.pojo.ItripImage;
@Service
public class ItripImageServiceImpl implements ItripImageService {
	@Resource
	private ItripImageMapper itripImageMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripImage = -1;
		try {
			deleteItripImage = itripImageMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripImage;
	}

	@Override
	public int insertSelective(ItripImage record) {
		int insertItripImage = -1;
		try {
			insertItripImage = itripImageMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripImage;
	}

	@Override
	public List<ItripImage> selectByPrimaryKey(Long id) {
		List<ItripImage> selectItripImage = null;
		try {
			selectItripImage = itripImageMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripImage;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripImage record) {
		int updateItripImage = -1;
		try {
			updateItripImage = itripImageMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripImage;
	}

}
