package com.bdqn.dao;

import com.bdqn.pojo.ItripHotelRoom;

public interface ItripHotelRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelRoom record);

    int insertSelective(ItripHotelRoom record);

    ItripHotelRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripHotelRoom record);

    int updateByPrimaryKey(ItripHotelRoom record);
}