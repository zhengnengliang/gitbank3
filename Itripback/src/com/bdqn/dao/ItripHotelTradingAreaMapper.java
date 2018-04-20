package com.bdqn.dao;

import com.bdqn.pojo.ItripHotelTradingArea;

public interface ItripHotelTradingAreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripHotelTradingArea record);

    int insertSelective(ItripHotelTradingArea record);

    ItripHotelTradingArea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripHotelTradingArea record);

    int updateByPrimaryKey(ItripHotelTradingArea record);
}