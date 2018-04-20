package com.bdqn.service.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.dao.itripComment.ItripCommentMapper;
import com.bdqn.pojo.ItripComment;
@Service
public class ItripCommentServiceImpl implements ItripCommentService{

	@Resource
	private ItripCommentMapper itripCommentMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		int deleteItripComment = -1;
		try {
			deleteItripComment = itripCommentMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteItripComment;
	}

	@Override
	public int insertSelective(ItripComment record) {
		int insertItripComment = -1;
		try {
			insertItripComment = itripCommentMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertItripComment;
	}

	@Override
	public List<ItripComment> selectByName(String content) {
		List<ItripComment> selectItripComment = null;
		try {
			selectItripComment = itripCommentMapper.selectByName(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripComment;
	}

	@Override
	public ItripComment selectById(String id) {
		ItripComment selectItripComment = null;
		try {
			selectItripComment = itripCommentMapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectItripComment;
	}

	@Override
	public int updateByPrimaryKeySelective(ItripComment record) {
		int updateItripComment = -1;
		try {
			updateItripComment = itripCommentMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateItripComment;
	}

}
