package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.NewUserServiceImpl;
import entity.Newuser;

public class DengLuAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		NewUserServiceImpl p=new NewUserServiceImpl();
		  HttpSession session=request.getSession();//�������session������ʱʹ��session
		       String uname= request.getParameter("uname");
		       String upwd=request.getParameter("upwd");
		      List<Newuser> a= p.register(uname,upwd);//���õ�¼�ķ����������ݿ��ѯ��û�������Ա
		      
		      if(a!=null){
		   	
		     	Newuser user=a.get(0);
		      session.setAttribute("login", user);
		     // session.setMaxInactiveInterval(10);�Զ�����ʧЧʱ�䣨10��	��
		      try {
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      return;
		      }else{
		    	
		     try {
				request.getRequestDispatcher("index.jsp").forward(request,response);
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

}
