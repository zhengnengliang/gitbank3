package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TopicService;
import service.impl.TopicServiceImpl;
import entity.Topic;

public class TopicAmend1Action implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		  TopicService topicservice = new TopicServiceImpl();//调用标题业务层
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tid = request.getParameter("id");
		List<Topic> list = topicservice.find("tid", Integer.parseInt(tid) , null , -1, "null"); 
		Topic topic2=list.get(0);
		request.setAttribute("topic2", topic2);
		try {
			request.getRequestDispatcher("topicAmend.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
	}

}
