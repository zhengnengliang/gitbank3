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
			log.info("����"+arg0.getName()+"�������session�����У�������Ϊ"
					+arg0.getValue().getClass().getName());
					
		}

		@Override
		public void attributeRemoved(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			log.info("����"+arg0.getName()+"��session�Ƴ�");
		}

		@Override
		public void attributeReplaced(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			log.info("session�еı���"+arg0.getName()+"���滻�����ֵΪ"+
			arg0.getValue());
			
		}

	

}
