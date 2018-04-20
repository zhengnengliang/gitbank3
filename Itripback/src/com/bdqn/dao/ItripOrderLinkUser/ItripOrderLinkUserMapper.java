package com.bdqn.dao.ItripOrderLinkUser;

import java.util.List;

import com.bdqn.pojo.ItripOrderLinkUser;

public interface ItripOrderLinkUserMapper {
    int deleteByPrimaryKey(Long id);

   // int insert(ItripOrderLinkUser record);

    int insertSelective(ItripOrderLinkUser record);

    List<ItripOrderLinkUser> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItripOrderLinkUser record);

    //int updateByPrimaryKey(ItripOrderLinkUser record);
}