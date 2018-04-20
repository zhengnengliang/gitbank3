package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TopicService;
import service.impl.TopicServiceImpl;
import entity.Topic;

public class TopicAddAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		   String  tname=request.getParameter("tname");
		   PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Topic topic1 =new Topic();//公用的调用topic（标题类对象）
			TopicService topicservice = new TopicServiceImpl();//调用标题业务层
		  	List<Topic> list=topicservice.find("tName",tname,null,-1,null);
		  	if(list.size()==0){
		  	topic1.settName(tname);
		  	   topicservice.addtitle(topic1);
		  	   out.println("<script type='text/javascript'>");
		  	   out.println("alert ('当前列表创建成功，点击确认返回主题');");
		  	   out.println("location.href='topicList.jsp';");
		  	   out.println(" </script>");
		  	   out.close();
		  	}else {
		  		out.println("<script type='text/javascript'>");
		  		out.println("alert ('当前主题已经存在，请重新添加');");
		  		out.println("location.href='topicList.jsp';");
		  		out.println("</script>");
		  		out.flush();
		  		out.close();
		    } 
	}
}
