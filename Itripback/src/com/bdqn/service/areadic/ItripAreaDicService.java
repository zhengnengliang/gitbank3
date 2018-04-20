package com.bdqn.service.areadic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.ItripAreaDic;

public interface ItripAreaDicService {
	int deleteByPrimaryKey(Long id);

    int insertSelective(ItripAreaDic record);

    List<ItripAreaDic> selectByName(String name);
    
    ItripAreaDic selectById(String id);

    int updateByPrimaryKeySelective(ItripAreaDic record);

}
