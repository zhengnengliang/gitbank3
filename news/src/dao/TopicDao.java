package dao;

import java.util.List;

import entity.News;
import entity.Topic;

public  interface TopicDao {
	/**
	 * topic
	 * ������WHERE "field"  = "a" ORDER BY "orderby" LIMINT "limit"+order(order������)
	 */
	public List<Topic> query(Object field,Object a,Object orderby,int limit ,String order );


	/**
	 * ��ӱ���
	 */
	public int addtitle(Topic topic);
	/**
	 * �޸����ű���
	 */
	public int modifypet(Topic topic,String  b,Object a);
	/**
	 * ɾ�����ű���
	 */
	public int delete(String pro,Object o) ;
}


