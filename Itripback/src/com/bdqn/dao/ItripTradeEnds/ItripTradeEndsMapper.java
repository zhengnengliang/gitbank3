package com.bdqn.dao.ItripTradeEnds;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.ItripTradeEnds;

public interface ItripTradeEndsMapper {
    int deleteByPrimaryKey(Long id);

    //int insert(ItripTradeEnds record);

    int insertSelective(ItripTradeEnds record);

    List<ItripTradeEnds> selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(ItripTradeEnds record);

    //int updateByPrimaryKey(ItripTradeEnds record);
}