package dao;

import java.util.List;

import entity.News;
import entity.Topic;

public  interface TopicDao {
	/**
	 * topic
	 * 条件：WHERE "field"  = "a" ORDER BY "orderby" LIMINT "limit"+order(order升降序)
	 */
	public List<Topic> query(Object field,Object a,Object orderby,int limit ,String order );


	/**
	 * 添加标题
	 */
	public int addtitle(Topic topic);
	/**
	 * 修改新闻标题
	 */
	public int modifypet(Topic topic,String  b,Object a);
	/**
	 * 删除新闻标题
	 */
	public int delete(String pro,Object o) ;
}


