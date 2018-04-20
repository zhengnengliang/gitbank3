package com.bdqn.dao.ItripProductStore;

import java.util.List;

import com.bdqn.pojo.ItripProductStore;

public interface ItripProductStoreMapper {
    int deleteByPrimaryKey(Long id);

   // int insert(ItripProductStore record);

    int insertSelective(ItripProductStore record);

    List<ItripProductStore> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripProductStore record);

   // int updateByPrimaryKey(ItripProductStore record);
}