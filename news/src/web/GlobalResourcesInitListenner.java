package web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import dao.TopicDao;
import dao.impl.TopicDaoImpl;
import service.TopicService;
import service.impl.TopicServiceImpl;
import entity.Topic;
/*初始化数据资源*/
public class GlobalResourcesInitListenner implements ServletContextListener {
 private final Logger logger=Logger.getLogger(GlobalResourcesInitListenner.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 logger.info("application已经被销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 logger.info("application已经被初始化");
			ServletContext application=arg0.getServletContext();
			TopicDao topicservice=new TopicDaoImpl();
			List<Topic> topics = topicservice.query(1, 1, null, -1, " ");
			logger.info("application已经被初始化"+topics .size()+"个新闻");
			application.setAttribute("all_topics", topics);
		
		
		
		
	}

}
