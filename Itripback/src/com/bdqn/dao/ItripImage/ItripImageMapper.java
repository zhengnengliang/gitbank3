package com.bdqn.dao.ItripImage;

import java.util.List;

import com.bdqn.pojo.ItripImage;

public interface ItripImageMapper {
    int deleteByPrimaryKey(Long id);

    //int insert(ItripImage record);

    int insertSelective(ItripImage record);

    List<ItripImage> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripImage record);

    //int updateByPrimaryKey(ItripImage record);
}