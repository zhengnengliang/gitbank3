package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentsService;
import service.NewsService;
import service.impl.CommentsServiceImpl;
import service.impl.NewsServiceImpl;
import entity.Comments;
import entity.News;


public class Contest1Action implements Action {



	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		NewsService newsservice = new NewsServiceImpl();
		//if(session.getAttribute("login")!=null){
		request.setAttribute("ccid",id );
		List<News> newslist = newsservice.entertainmentnews("nid",(Integer.parseInt(id)), null, -1, "null");
		News newscontest=newslist.get(0);
		request.setAttribute("newscontest", newscontest);
		CommentsService commentsservice = new CommentsServiceImpl();
		int a = newscontest.getnID();
		List<Comments> commentlist = commentsservice.query("CNID", a, null,-1, "DESC");//»ñÈ¡ÆÀÂÛ
		request.setAttribute("commentlist", commentlist);
		try {
			request.getRequestDispatcher("contest.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;}
//	    }else{out.println("<script type='text/javascript'>");
//	    out.println("alert ('ÇëµÇÂ¼');");
//	    out.println("location.href='index.jsp';");
//   	    out.println("</script>");
//   	    out.flush();
//   	    out.close();}
//		//}
	}
	
	
	

