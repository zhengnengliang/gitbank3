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
 * �޸ı��⣨�Ը���ֵ���и��ģ�
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
			   Topic topic1 =new Topic();//���õĵ���topic�����������
			   String tid=request.getParameter("tid");
			   String name=request.getParameter("tname");
			   topic1.settID(Integer.parseInt(tid));
			   topic1.settName(name);
			   TopicService topicservice = new TopicServiceImpl();//���ñ���ҵ���
			   int i=topicservice.amend(topic1);
			   TopicService duixiang=new TopicServiceImpl();
			   List<Topic> list = duixiang.find("tid", tid , null , -1, "null");
			   if(i>0){
				   out.println("");
				   out.println("<script type='text/javascript'>");
				   out.println("alert ('��ǰ�б��޸ĳɹ������ȷ�Ϸ�������');");
				   out.println("  location.href='topicList.jsp';");
				   out.println("</script>");
				   out.flush();
				   out.close();
			    }else{
			    	 out.println("<script type='text/javascript'>");
			    	 out.println("alert ('��ǰ�б��޸�ʧ�ܣ����ȷ�Ϸ�������');");
			    	 out.println("location.href='topicAdd.jsp';");
			    	 out.println("</script>");
			    	 out.flush();
			    	 out.close();
			     }
		}
}
