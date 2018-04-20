package com.bdqn.dao.ItripLabelDic;

import java.util.List;

import com.bdqn.pojo.ItripLabelDic;

public interface ItripLabelDicMapper {
    int deleteByPrimaryKey(Long id);

   // int insert(ItripLabelDic record);

    int insertSelective(ItripLabelDic record);

    List<ItripLabelDic> selectByName(String name);

    int updateByPrimaryKeySelective(ItripLabelDic record);

   // int updateByPrimaryKey(ItripLabelDic record);
}