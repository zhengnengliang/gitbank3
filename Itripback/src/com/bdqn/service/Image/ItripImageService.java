package com.bdqn.service.Image;

import java.util.List;

import com.bdqn.pojo.ItripImage;

public interface ItripImageService {
	int deleteByPrimaryKey(Long id);

	// int insert(ItripImage record);

	int insertSelective(ItripImage record);

	 List<ItripImage> selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ItripImage record);

	// int updateByPrimaryKey(ItripImage record);
}
