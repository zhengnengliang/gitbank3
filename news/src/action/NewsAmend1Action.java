package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import service.impl.NewsServiceImpl;
import entity.News;

public class NewsAmend1Action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	String id = request.getParameter("id");
	 	int nnid=Integer.parseInt(id);//ªÒ»°id
	 	NewsService newsService =new NewsServiceImpl(); 
		List<News> listNews=newsService .newscenter("Nid", nnid, null, -1, null);
	    News newss=listNews.get(0);
	    request.setAttribute("newss", newss);
	    try {
			request.getRequestDispatcher("newsAmend.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
