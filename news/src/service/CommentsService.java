package service;

import java.util.List;

import entity.Comments;
import entity.News;

public interface CommentsService {
    
	/**
      * ������ѯ(String field, Object a, Object orderby,int limit, String order)
      */
	public List<Comments> query(String field,Object a,Object orderby,int limit ,String order);
	
	
	/**
	 * ���(Comments comments)
	 */
	 public int addComments(Comments comments);
}
