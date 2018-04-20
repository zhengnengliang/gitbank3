package cn.smbms.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionFactory {
   static ApplicationContext ctx=null;
   static{
	   
	   if(ctx==null){
		   ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
	   }
   }
   public static Object factory(String action){
	   return(Object)ctx.getBean(action);
   }
}
