package service;

import java.util.List;

import entity.Comments;
import entity.News;

public interface CommentsService {
    
	/**
      * 条件查询(String field, Object a, Object orderby,int limit, String order)
      */
	public List<Comments> query(String field,Object a,Object orderby,int limit ,String order);
	
	
	/**
	 * 添加(Comments comments)
	 */
	 public int addComments(Comments comments);
}
