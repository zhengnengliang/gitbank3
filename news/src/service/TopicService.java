package service;

import java.util.List;

import entity.Topic;

public interface TopicService {
	/**
	 * 查询(String field,Object a,Object orderby,int limit ,String order)
	 */
		public List<Topic> find(Object field,Object a,Object orderby,int limit ,String order);


     /**
      * 添加标题
      */
		public int addtitle(Topic topic);
		
		/**
		 * 修改标题
		 */
		public int amend(Topic topic);
		/**
		 * 删除标题
		 */
		public int deletetopic(int a );

}
