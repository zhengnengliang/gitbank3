package com.bdqn.service.LabelDic;

import java.util.List;

import com.bdqn.pojo.ItripLabelDic;

public interface ItripLabelDicService {
	int deleteByPrimaryKey(Long id);

	// int insert(ItripLabelDic record);

	List<ItripLabelDic> selectByName(String name);

	int updateByPrimaryKeySelective(ItripLabelDic record);

	int insertSelective(ItripLabelDic record);

	// int updateByPrimaryKey(ItripLabelDic record);
}
