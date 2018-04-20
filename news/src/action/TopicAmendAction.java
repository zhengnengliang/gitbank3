package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TopicService;
import service.impl.TopicServiceImpl;
import entity.Topic;

/**
 * 修改标题（对更改值进行更改）
 */
public class TopicAmendAction implements Action {
	 
		@Override
		public void excute(HttpServletRequest request,HttpServletResponse response) {
			   PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   Topic topic1 =new Topic();//公用的调用topic（标题类对象）
			   String tid=request.getParameter("tid");
			   String name=request.getParameter("tname");
			   topic1.settID(Integer.parseInt(tid));
			   topic1.settName(name);
			   TopicService topicservice = new TopicServiceImpl();//调用标题业务层
			   int i=topicservice.amend(topic1);
			   TopicService duixiang=new TopicServiceImpl();
			   List<Topic> list = duixiang.find("tid", tid , null , -1, "null");
			   if(i>0){
				   out.println("");
				   out.println("<script type='text/javascript'>");
				   out.println("alert ('当前列表修改成功，点击确认返回主题');");
				   out.println("  location.href='topicList.jsp';");
				   out.println("</script>");
				   out.flush();
				   out.close();
			    }else{
			    	 out.println("<script type='text/javascript'>");
			    	 out.println("alert ('当前列表修改失败，点击确认返回主题');");
			    	 out.println("location.href='topicAdd.jsp';");
			    	 out.println("</script>");
			    	 out.flush();
			    	 out.close();
			     }
		}
}
