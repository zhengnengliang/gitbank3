package dao;

import java.util.List;

import entity.Comments;

public interface CommentsDao {
    /**
     * ��ѯ��������
     */
	public List<Comments> query(String field,Object a,Object orderby,int limit ,String order);

	/**
	 * �޸�
	 */
	public int addComment(Comments comments);
		
	
}
