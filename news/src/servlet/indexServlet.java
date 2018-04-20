package servlet;
/*如何创建properties文件：
例如创建find.properties文件：new - file- 输入创建的文件名：（find.properties就ok啦）
*/
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import action.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entity.News;

import java.io.*;
import java.net.InetAddress;

import service.impl.CommentsServiceImpl;
import service.impl.NewUserServiceImpl;
import service.impl.NewsServiceImpl;
import service.CommentsService;
import service.NewsService;
import service.TopicService;
import service.impl.TopicServiceImpl;
import entity.Comments;
import entity.News;
import entity.Newuser;
import entity.Topic;
import factory.Commandfactory;

public class indexServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;Charset=utf-8");
		  HttpSession session=request.getSession();//创建这个session方法来时使用session
		  PrintWriter out=response.getWriter();
		  Topic topic1 =new Topic();//公用的调用topic（标题类对象）
		  News news1=new News();//公用的调用news（新闻类对象）
		  String  namename=request.getParameter("namename");
		  NewsService news=new NewsServiceImpl();//创建调用new业务层的实体
		  List<News> national=news.nationalnews("nTID",1,"nCreatedate",6,"ASC");//国内新闻 
		  session.setAttribute("national", national);
		  List<News> worldNews=news.nationalnews("nTID",2,"nCreatedate",6,"ASC");//国际新闻
		  session.setAttribute("worldNews",worldNews);//国际新闻
		  List<News> happyNews=news.nationalnews("nTID",3,"nCreatedate",6,"ASC");//娱乐新闻
		  session.setAttribute("happyNews", happyNews);//娱乐新闻
	  	  TopicService duixiang=new TopicServiceImpl();
		  List<Topic> topic=duixiang.find(1, 1,null,-1,"null");//所有新闻标题
		  request.setAttribute("topic",topic);//国际新闻
		  TopicService topicservice = new TopicServiceImpl();//调用标题业务层
		  List<Topic> alltopic= duixiang.find(1, 1, null, -1, "null");//查询所有标题
		  session.setAttribute("alltopic", alltopic);//存储所有标题
	      List<News> allnews= news.allfind();//获取所有新闻
	      session.setAttribute("allnews",allnews);//存储所有新闻
		 //Commandfactory  factory=new Commandfactory ();
	      //Action action=factory.getAction(namename);
	      //action.excute(request,response);
		if(namename==null){
			response.sendRedirect("index.jsp");
			}else{
		
			Commandfactory factory=new Commandfactory();
			Action action=null;
			try {
				action=factory.getAction(namename);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			action.excute(request, response);
			}
		}
//		  /**
//		   * 分页
//		   */
////	      if(1=1){
////	    	  int star=1;+10+10
////	    	  int stop=+10
////	    	  int size=allnews.size();
////	    	  for(star;star<stop){
////	    		  allnews.get(index).
////	    	  }
////	    	  
////	      }
//		  /**
//		   *1. 登录
//		   * 这个是错误是由于response多次提交或者是由于有页面显示后仍然含请求转向产生的
//		   * ，就是说程序在return之前就已经执行了跳转或者执行过response
//		   */
//		  if("denglu".equals(namename)){
//			 
//			 	NewUserServiceImpl p=new NewUserServiceImpl();
//		       String uname= request.getParameter("uname");
//		       String upwd=request.getParameter("upwd");
//		      List<Newuser> a= p.register(uname,upwd);//调用登录的方法，向数据库查询有没有这个会员
//		      
//		      if(a!=null){
//		   	
//		     	Newuser user=a.get(0);
//		      session.setAttribute("login", user);
//		     // session.setMaxInactiveInterval(10);自动设置失效时间（10秒	）
//		      request.getRequestDispatcher("index.jsp").forward(request,response);
//		      return;
//		      }else{
//		    	
//		     request.getRequestDispatcher("index.jsp").forward(request,response);
//		     return;
//		      }
//		  }
//		  
//		  
//		  /**
//		   *2 添加标题
//		   */
//		  else if("addtopic".equals(namename)){
//		    String  tname=request.getParameter("tname");
//		  	List<Topic> list=topicservice.find("tName",tname,null,-1,null);
//		  	if(list.size()==0){
//		  	topic1.settName(tname);
//		  	   topicservice.addtitle(topic1);
//		  	   out.println("<script type='text/javascript'>");
//		  	   out.println("alert ('当前列表创建成功，点击确认返回主题');");
//		  	   out.println("location.href='topicList.jsp';");
//		  	   out.println(" </script>");
//		  	   out.close();
//		  	}else {
//		  		out.println("<script type='text/javascript'>");
//		  		out.println("alert ('当前主题已经存在，请重新添加');");
//		  		out.println("location.href='topicList.jsp';");
//		  		out.println("</script>");
//		  		out.flush();
//		  		out.close();
//		    } 
//		  }
//		  
//		  
//		
//		
//		
//		
//		/**
//		   *3. 修改标题（对默认值进行获取）
//		   */
//		  else if("amendtopic1".equals(namename)){
//			request.setCharacterEncoding("utf-8");
//			String tid = request.getParameter("id");
//			List<Topic> list = topicservice.find("tid", Integer.parseInt(tid) , null , -1, "null"); 
//			Topic topic2=list.get(0);
//			request.setAttribute("topic2", topic2);
//			request.getRequestDispatcher("topicAmend.jsp").forward(request,response);
//			return;
//			
//		}
//
//		/**
//		   * 4.修改标题（对更改值进行更改）
//		   */
//		  else if("amendtopic".equals(namename)){
//			   String tid=request.getParameter("tid");
//			   String name=request.getParameter("tname");
//			   topic1.settID(Integer.parseInt(tid));
//			   topic1.settName(name);
//			   int i=topicservice.amend(topic1);
//			   List<Topic> list = duixiang.find("tid", tid , null , -1, "null");
//			   if(i>0){
//				   out.println("");
//				   out.println("<script type='text/javascript'>");
//				   out.println("alert ('当前列表修改成功，点击确认返回主题');");
//				   out.println("  location.href='topicList.jsp';");
//				   out.println("</script>");
//				   out.flush();
//				   out.close();
//			    }else{
//			    	 out.println("<script type='text/javascript'>");
//			    	 out.println("alert ('当前列表修改失败，点击确认返回主题');");
//			    	 out.println("location.href='topicAdd.jsp';");
//			    	 out.println("</script>");
//			    	 out.flush();
//			    	 out.close();
//			     }
//		  
//		}
//		  
//		  /**
//		   *5. 删除标题
//		   */
//		  else if("deletetopic".equals(namename)){
//			   String tid=request.getParameter("tid");
//			   int id=Integer.parseInt(tid);//将tid 的String值转换成int的值传入对象中
//			   int a= topicservice.deletetopic(id);
//			   if(a!=0){
//				   out.println("<script type='text/javascript'>");
//				   out.println("alert ('删除成功');");
//				   out.println("location.href='topicList.jsp';");
//				   out.println("</script>");
//				   out.flush();
//				   out.close();
//			   }else{
//				   out.println("<script type='text/javascript'>");
//				   out.println("alert ('删除失败');");
//				   out.println("location.href='topicList.jsp';");
//				   out.println("</script>");
//				   out.flush();
//				   out.close();
//			   }
//			   
//		} 
//		
//		  
//		  /**
//		   *6. 添加新闻
//		   */
//		  else if("addnews".equals(namename)){
//			     NewsService newsService=new NewsServiceImpl();
//			   	 request.setCharacterEncoding("utf-8");
//			   	 String uploadFileName="";//上传文件名
//			   	 String fieldName="";//表单字段元素的name属性
//			   	 //请求信息中内容是否multipartlei类型
//			   	 boolean isMultipart=ServletFileUpload.isMultipartContent(request);
//			   	 //上传文件的存储路路径
//			   	 String uploadFilePath =request.getSession().getServletContext().getRealPath("images/");
//			   	 if(isMultipart){
//			   	 	FileItemFactory factory=new DiskFileItemFactory();
//			   	 	ServletFileUpload upload=new ServletFileUpload(factory);
//			   	 	try{
//			   	 	//解析form表单中所有文件
//			   	 	List<FileItem> items=upload.parseRequest(request);
//			   	 	Iterator<FileItem> iter=items.iterator();//导的包不知道是否正确
//			   	 	while(iter.hasNext()){
//			   	 	FileItem item=(FileItem) iter.next();
//			   	 	if(item.isFormField()){
//				   	 	fieldName =item.getFieldName();
//				   	 		if(item.getFieldName().equals("ntitle")){
//								 news1.setnTitle(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("nauthor")){
//								news1.setnAuthor( item.getString("UTF-8")) ;
//							 }else if(item.getFieldName().equals("nsummary")){
//								news1.setnSummary(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("ncontent")){
//								news1.setnContent(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("ntid")){
//								 news1.setnTID(Integer.parseInt(item.getString("UTF-8")));
//							 }
//
//			   	 	}else{//文件表单字段
//				   	 	String fileName=item.getName();
//				   	 	if(fileName!=null&&!fileName.equals("")){
//			   	 			File fullFile=new File(item.getName());
//			   	 			File saveFile=new File
//			   	 			(uploadFilePath,fullFile.getName());
//			   	 			item.write(saveFile);
//			   	 			//uploadFileName=fullFile.getName();
//			   	 			news1.setnPicpath(fullFile.getName());
//			   	 	    }
//			   	 	}
//			   	 	}
//			   	 	}catch(Exception e){
//			   	 	e.printStackTrace();
//			   	 	
//			   	 }int i=newsService.addnews(news1);
//			   	 if(i>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('添加新闻成功');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			        out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('添加失败');");
//				    out.println("  location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//			   	 }
//			   
//			
//			   	 }
//		}
//		  
//         /**
//          * 7. 初始页面的修改新闻
//          */
//		  else if("amentnews1".equals(namename)){
//			request.setCharacterEncoding("UTF-8");
//		 	String id = request.getParameter("id");
//		 	int nnid=Integer.parseInt(id);//获取id
//		 	NewsService newsService =new NewsServiceImpl(); 
//    		List<News> listNews=newsService .newscenter("Nid", nnid, null, -1, null);
//    	    News newss=listNews.get(0);
//    	    request.setAttribute("newss", newss);
//    	    request.getRequestDispatcher("newsAmend.jsp").forward(request,response);
//			
//			
//		}
//		  /**
//		   * 8.修改新闻
//		   */
//		  else 	if("amentnews".equals(namename)){
//		
//		        request.setCharacterEncoding("UTF-8");
//			 	String id = request.getParameter("id");
//			 	 int id1=Integer.parseInt(id);
//			   	 request.setCharacterEncoding("utf-8");
//			   	 String uploadFileName="";//上传文件名
//			   	 String fieldName="";//表单字段元素的name属性
//			   	 //News news=new News();
//			   	  NewsService  newsServic=new NewsServiceImpl();
//			   	  List<News> list= newsServic.entertainmentnews("NID", id1, null, -1, "");
//			   	 //请求信息中内容是否multipartlei类型
//			   	 boolean isMultipart=ServletFileUpload.isMultipartContent(request);
//			   	 //上传文件的存储路路径
//			   	 String uploadFilePath =request.getSession().getServletContext().getRealPath("images/");
//			 
//			   	 if(isMultipart){
//			   		
//			   	 	FileItemFactory factory=new DiskFileItemFactory();
//			   	 	ServletFileUpload upload=new ServletFileUpload(factory);
//			   	 	try{
//			   	 	//解析form表单中所有文件
//			   	 	List<FileItem> items=upload.parseRequest(request);
//			   	 	Iterator<FileItem> iter=items.iterator();
//			   	 	while(iter.hasNext()){
//			   	 	FileItem item=(FileItem) iter.next();
//			   	 	if(item.isFormField()){
//			   	 	out.println("<script type='text/javascript'>");
//				    out.println("alert ('来了');");
//			   	    out.println("</script>");
//				   	 	fieldName =item.getFieldName();
//				   	 		 if(item.getFieldName().equals("ntitle")){
//								 news1.setnTitle(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("nauthor")){
//								news1.setnAuthor( item.getString("UTF-8")) ;
//							 }else if(item.getFieldName().equals("nsummary")){
//								news1.setnSummary(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("ncontent")){
//								news1.setnContent(item.getString("UTF-8"));
//							 }else if(item.getFieldName().equals("ntid")){
//								 news1.setnTID(Integer.parseInt(item.getString("UTF-8")));
//							 }
//
//			   	 	}else{//文件表单字段
//			   	 	out.println("<script type='text/javascript'>");
//				    out.println("alert ('走了');");
//			   	    out.println("</script>");
//				   	 	String fileName=item.getName();
//				   	 	if(fileName!=null&&!fileName.equals("")){
//			   	 			File fullFile=new File(item.getName());
//			   	 			File saveFile=new File
//			   	 			(uploadFilePath,fullFile.getName());
//			   	 			item.write(saveFile);
//			   	 			uploadFileName=fullFile.getName();
//			   	 	    }
//			   	 	}
//			   	 	}
//			   	 	}catch(Exception e){
//			   	 	e.printStackTrace();
//			   	 	 
//			   	 }
//			   	 	int i=newsServic.amentNews(news1);
//			   	 	
//			   	 if(i>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('修改新闻成功');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('修改新闻失败');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}
//			 }
//			 return;
//			
//		}
//		
//		  
//		  /**
//		   *9. 删除新闻
//		   */
//		  else if("deletenews".equals(namename)){
//			String id=request.getParameter("id"); 
//		    NewsService newsservice=new NewsServiceImpl();
//		    int b=Integer.parseInt(id);
//		    int a=newsservice.deletenews(b);
//		   	 if(a>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('删除新闻成功');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('删除新闻失败');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}
//		   	 }
//		
//		/**
//		 * 10.获取评论页面的初始值
//		 */
//		  else if("doContest1".equals(namename)){
//			//if(session.getAttribute("login")!=null){
//			String id = request.getParameter("id");
//			request.setAttribute("ccid",id );
//			NewsService newsservice = new NewsServiceImpl();
//			List<News> newslist = newsservice.entertainmentnews("nid",(Integer.parseInt(id)), null, -1, "null");
//			News newscontest=newslist.get(0);
//			request.setAttribute("newscontest", newscontest);
//			CommentsService commentsservice = new CommentsServiceImpl();
//			int a = newscontest.getnID();
//			List<Comments> commentlist = commentsservice.query("CNID", a, null,-1, "DESC");//获取评论
//			request.setAttribute("commentlist", commentlist);
//			request.getRequestDispatcher("contest.jsp").forward(request,response);
//			return;}
////		    }else{out.println("<script type='text/javascript'>");
////		    out.println("alert ('请登录');");
////		    out.println("location.href='index.jsp';");
////	   	    out.println("</script>");
////	   	    out.flush();
////	   	    out.close();}
////			//}
//			
//		
//		
//		
//		/**
//		 *11. 处理评论
//		 */
//		  else if("doContest".equals(namename)){
//			
//			   request.setCharacterEncoding("UTF-8");
//			   String tid=request.getParameter("id");
//			   String ccontent=request.getParameter("ccontent");
//			   Comments comments=new Comments();
//			   Date date=new Date();//获取当前时间从
//			   long time=date.getTime();
//			   SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			   String dateString=formatter.format(date);
//			   Date time1 = null;
//			   try {
//				   time1 = formatter.parse(dateString);
//			   } catch (ParseException e) {
//				// TODO Auto-generated catch block
//				   e.printStackTrace();
//			   }//到获取当前时间
//			   int a=Integer.parseInt(tid);
//			   comments.setcDate(time1);//时间
//			   InetAddress ia=null;//1.获取本机id
//			   ia=ia.getLocalHost();//2.获取本机id
//			   String localip=ia.getHostAddress();//3.获取本机id
//			  //  username=(Newuser)session.getAttribute("login");
//			 //  comments.setcAuthor(username);//谁添加的?????????
//			   comments.setcIp( localip);//添加的IP地址?????????
//			   comments.setcContent(ccontent);//添加的评论
//			   comments.setcNID(a);//根据cnid添加
//			   CommentsService commentsService=new  CommentsServiceImpl(); 
//			   NewsService newservice=new  NewsServiceImpl();
//		       int add=commentsService.addComments(comments);
//		       if(add>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('添加评论成功');");
//				    out.println("location.href='index.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('添加评论失败');");
//				    out.println("location.href='index.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}
//		       
//			   response.sendRedirect("index.jsp");
//		    
//		}
	
	


	public void init() throws ServletException {
		// Put your code here
	}

}
