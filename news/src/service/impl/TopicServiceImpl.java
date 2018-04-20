package service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import service.TopicService;
import dao.TopicDao;
import dao.impl.*;
import entity.Topic;
public class TopicServiceImpl  implements TopicService {
	TopicDao Dao=new 	TopicDaoImpl ();
		/**
		 * 查询(Object field,Object a,Object orderby,int limit ,String order )
		 */
		public List<Topic> find(Object field,Object a,Object orderby,int limit ,String order ){
			List<Topic> list1=Dao.query(  field, a, orderby, limit ,order);
			return list1;
			}
	
	/**
	 * 添加标题
	 */
	public int addtitle(Topic topic){
	     int i= Dao.addtitle(topic);
		return i;
	}
	 /**
	  * 修改标题
	  */
	public int amend(Topic topic){
		int a=Dao.modifypet(topic, "tID",topic.gettID());
		return a;
		
	}
	/**
	 * 删除标题
	 */
	public int deletetopic(int a ){
		int e=Dao. delete("Tid", a);
		return e;
	}
}
