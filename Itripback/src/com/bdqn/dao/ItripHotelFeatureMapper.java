package com.bdqn.dao;

import com.bdqn.pojo.ItripHotelFeature;

public interface ItripHotelFeatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelFeature record);

    int insertSelective(ItripHotelFeature record);

    ItripHotelFeature selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripHotelFeature record);

    int updateByPrimaryKey(ItripHotelFeature record);
}