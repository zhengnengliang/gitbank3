package com.bdqn.dao;

import com.bdqn.pojo.ItripHotelOrder;

public interface ItripHotelOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelOrder record);

    int insertSelective(ItripHotelOrder record);

    ItripHotelOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripHotelOrder record);

    int updateByPrimaryKeyWithBLOBs(ItripHotelOrder record);

    int updateByPrimaryKey(ItripHotelOrder record);
}