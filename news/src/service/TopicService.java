package service;

import java.util.List;

import entity.Topic;

public interface TopicService {
	/**
	 * ��ѯ(String field,Object a,Object orderby,int limit ,String order)
	 */
		public List<Topic> find(Object field,Object a,Object orderby,int limit ,String order);


     /**
      * ��ӱ���
      */
		public int addtitle(Topic topic);
		
		/**
		 * �޸ı���
		 */
		public int amend(Topic topic);
		/**
		 * ɾ������
		 */
		public int deletetopic(int a );

}
