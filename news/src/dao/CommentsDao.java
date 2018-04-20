package dao;

import java.util.List;

import entity.Comments;

public interface CommentsDao {
    /**
     * 查询（条件）
     */
	public List<Comments> query(String field,Object a,Object orderby,int limit ,String order);

	/**
	 * 修改
	 */
	public int addComment(Comments comments);
		
	
}
