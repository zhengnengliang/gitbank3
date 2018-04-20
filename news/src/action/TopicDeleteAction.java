package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TopicService;
import service.impl.TopicServiceImpl;

public class TopicDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		 String tid=request.getParameter("tid");
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  TopicService topicservice = new TopicServiceImpl();//调用标题业务层
		   int id=Integer.parseInt(tid);//将tid 的String值转换成int的值传入对象中
		   int a= topicservice.deletetopic(id);
		   if(a!=0){
			   out.println("<script type='text/javascript'>");
			   out.println("alert ('删除成功');");
			   out.println("location.href='topicList.jsp';");
			   out.println("</script>");
			   out.flush();
			   out.close();
		   }else{
			   out.println("<script type='text/javascript'>");
			   out.println("alert ('删除失败');");
			   out.println("location.href='topicList.jsp';");
			   out.println("</script>");
			   out.flush();
			   out.close();
		   }
	}

}
