package service.impl;

import java.util.List;

import dao.CommentsDao;
import dao.impl.CommentDaoImpl;
import entity.Comments;
import service.CommentsService;


public class CommentsServiceImpl implements CommentsService  {
	CommentsDao commentdao=new CommentDaoImpl();
	
	
	/**
	 * ��ѯ(String field, Object a, Object orderby,int limit, String order)
	 */
	public List<Comments> query(String field, Object a, Object orderby,int limit, String order) {
		List<Comments> list=commentdao.query(field, a, orderby, limit, order);
		return list;
	}

	
	/**
	 * ���(Comments comments)
	 */
	public int addComments(Comments comments) {
		int a=commentdao.addComment(comments);
		return a;
	}
        
}
