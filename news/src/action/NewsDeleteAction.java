package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import service.impl.NewsServiceImpl;

public class NewsDeleteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String id=request.getParameter("id"); 
		    NewsService newsservice=new NewsServiceImpl();
		    int b=Integer.parseInt(id);
		    int a=newsservice.deletenews(b);
		   	 if(a>0){
			   		out.println("<script type='text/javascript'>");
				    out.println("alert ('删除新闻成功');");
				    out.println("location.href='admin.jsp';");
			   	    out.println("</script>");
			   	    out.flush();
			   	    out.close();
				}else{
					out.println("<script type='text/javascript'>");
				    out.println("alert ('删除新闻失败');");
				    out.println("location.href='admin.jsp';");
			   	    out.println("</script>");
			   	    out.flush();
			   	    out.close();
				}
	}

}
