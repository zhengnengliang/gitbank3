package com.bdqn.dao.itripAreaDic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.ItripAreaDic;

public interface ItripAreaDicMapper {
    int deleteByPrimaryKey(Long id);

   // int insert(ItripAreaDic record);

    int insertSelective(ItripAreaDic record);

    List<ItripAreaDic> selectByName(@Param("name")String name);
    
    ItripAreaDic selectById(@Param("id")String id);

    int updateByPrimaryKeySelective(ItripAreaDic record);

   // int updateByPrimaryKey(ItripAreaDic record);
}