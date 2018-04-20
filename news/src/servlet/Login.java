package servlet;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import entity.News;
import entity.Newuser;
import entity.Topic;
import service.NewsService;
import service.TopicService;
import service.impl.NewUserServiceImpl;
import service.impl.NewsServiceImpl;
import service.impl.TopicServiceImpl;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html ;charset=UTF-8");
	 	NewUserServiceImpl p=new NewUserServiceImpl();
       String uname= request.getParameter("uname");
       String upwd=request.getParameter("upwd");
       HttpSession session=request.getSession();
       PrintWriter out=response.getWriter();
      List<Newuser> a= p.register(uname,upwd);//���õ�¼�ķ����������ݿ��ѯ��û�������Ա

	  NewsService news=new NewsServiceImpl();
	  List<News> national=news.nationalnews("nTID",1,"nCreatedate",6,"ASC");//�������� 
	  request.setAttribute("national", national);
	  List<News> worldNews=news.nationalnews("nTID",2,"nCreatedate",6,"ASC");//��������
	  request.setAttribute("worldNews",worldNews);//��������
	  List<News> happyNews=news.nationalnews("nTID",3,"nCreatedate",6,"ASC");//��������
	  request.setAttribute("happyNews", happyNews);//��������
  	  TopicService duixiang=new TopicServiceImpl();
	  List<Topic> topic=duixiang.find(1, 1,null,-1,"null");//���ű���
	  request.setAttribute("topic",topic);//��������
      if(a!=null){
     	Newuser user=a.get(0);
      session.setAttribute("login", user);
     // session.setMaxInactiveInterval(10);�Զ�����ʧЧʱ�䣨10��	��
      request.getRequestDispatcher("index.jsp").forward(request,response);
      }else{
     request.getRequestDispatcher("index.jsp").forward(request,response);
      }
	}

}
