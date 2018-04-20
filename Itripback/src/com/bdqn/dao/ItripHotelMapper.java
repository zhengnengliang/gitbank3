package com.bdqn.dao;

import com.bdqn.pojo.ItripHotel;
import com.bdqn.pojo.ItripHotelWithBLOBs;

public interface ItripHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelWithBLOBs record);

    int insertSelective(ItripHotelWithBLOBs record);

    ItripHotelWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripHotelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ItripHotelWithBLOBs record);

    int updateByPrimaryKey(ItripHotel record);
}