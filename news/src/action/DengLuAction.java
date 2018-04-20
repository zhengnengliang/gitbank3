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
		  HttpSession session=request.getSession();//创建这个session方法来时使用session
		       String uname= request.getParameter("uname");
		       String upwd=request.getParameter("upwd");
		      List<Newuser> a= p.register(uname,upwd);//调用登录的方法，向数据库查询有没有这个会员
		      
		      if(a!=null){
		   	
		     	Newuser user=a.get(0);
		      session.setAttribute("login", user);
		     // session.setMaxInactiveInterval(10);自动设置失效时间（10秒	）
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
