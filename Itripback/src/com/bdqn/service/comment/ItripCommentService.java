package com.bdqn.service.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.pojo.ItripComment;

public interface ItripCommentService {
	int deleteByPrimaryKey(Long id);

	// int insert(ItripComment record);

	int insertSelective(ItripComment record);

	List<ItripComment> selectByName(@Param("content") String content);

	ItripComment selectById(@Param("id") String id);

	int updateByPrimaryKeySelective(ItripComment record);

	// int updateByPrimaryKeyWithBLOBs(ItripComment record);

	// int updateByPrimaryKey(ItripComment record);
}
