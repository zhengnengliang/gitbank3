package web;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;


public class SessionAttributeListenner implements HttpSessionAttributeListener {
	  private final Logger log=Logger.getLogger(SessionAttributeListenner .class);
		@Override
		public void attributeAdded(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			log.info("变量"+arg0.getName()+"被添加在session类型中，其类型为"
					+arg0.getValue().getClass().getName());
					
		}

		@Override
		public void attributeRemoved(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			log.info("变量"+arg0.getName()+"被session移除");
		}

		@Override
		public void attributeReplaced(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			log.info("session中的变量"+arg0.getName()+"被替换，其旧值为"+
			arg0.getValue());
			
		}

	

}
