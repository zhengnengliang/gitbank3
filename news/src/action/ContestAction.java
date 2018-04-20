package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommentsService;
import service.NewsService;
import service.impl.CommentsServiceImpl;
import service.impl.NewsServiceImpl;
import entity.Comments;
import entity.News;
import entity.Newuser;

public class ContestAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		   String tid=request.getParameter("id");
		   PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		   String ccontent=request.getParameter("ccontent");
		   Comments comments=new Comments();
		   Date date=new Date();//获取当前时间从
		   long time=date.getTime();
		   SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString=formatter.format(date);
		   Date time1 = null;
		   try {
			   time1 = formatter.parse(dateString);
		   } catch (ParseException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }//到获取当前时间
		   int a=Integer.parseInt(tid);
		   comments.setcDate(time1);//时间
		   InetAddress ia=null;//1.获取本机id
		   try {
			ia=ia.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//2.获取本机id
	
		   String localip=ia.getHostAddress();//3.获取本机id
		  //  username=(Newuser)session.getAttribute("login");
		 //  comments.setcAuthor(username);//谁添加的?????????
		   comments.setcIp( localip);//添加的IP地址?????????
		   comments.setcContent(ccontent);//添加的评论
		   comments.setcNID(a);//根据cnid添加
		   HttpSession session=request.getSession();//创建这个session方法来时使用session
		   Newuser user=(Newuser)session.getAttribute("login");
		   if(user!=null){
		   comments.setcAuthor(user.getuName());}else{
			   comments.setcAuthor("匿名用户");
		   }
		   CommentsService commentsService=new  CommentsServiceImpl(); 
		   NewsService newservice=new  NewsServiceImpl();
	       int add=commentsService.addComments(comments);
	       if(add>0){
		   		out.println("<script type='text/javascript'>");
			    out.println("alert ('添加评论成功');");
			    out.println("location.href='index.jsp';");
		   	    out.println("</script>");
		   	    out.flush();
		   	    out.close();
			}else{
				out.println("<script type='text/javascript'>");
			    out.println("alert ('添加评论失败');");
			    out.println("location.href='index.jsp';");
		   	    out.println("</script>");
		   	    out.flush();
		   	    out.close();
			}
	       
		   try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
