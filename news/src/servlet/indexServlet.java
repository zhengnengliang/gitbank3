package servlet;
/*��δ���properties�ļ���
���紴��find.properties�ļ���new - file- ���봴�����ļ�������find.properties��ok����
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
		  HttpSession session=request.getSession();//�������session������ʱʹ��session
		  PrintWriter out=response.getWriter();
		  Topic topic1 =new Topic();//���õĵ���topic�����������
		  News news1=new News();//���õĵ���news�����������
		  String  namename=request.getParameter("namename");
		  NewsService news=new NewsServiceImpl();//��������newҵ����ʵ��
		  List<News> national=news.nationalnews("nTID",1,"nCreatedate",6,"ASC");//�������� 
		  session.setAttribute("national", national);
		  List<News> worldNews=news.nationalnews("nTID",2,"nCreatedate",6,"ASC");//��������
		  session.setAttribute("worldNews",worldNews);//��������
		  List<News> happyNews=news.nationalnews("nTID",3,"nCreatedate",6,"ASC");//��������
		  session.setAttribute("happyNews", happyNews);//��������
	  	  TopicService duixiang=new TopicServiceImpl();
		  List<Topic> topic=duixiang.find(1, 1,null,-1,"null");//�������ű���
		  request.setAttribute("topic",topic);//��������
		  TopicService topicservice = new TopicServiceImpl();//���ñ���ҵ���
		  List<Topic> alltopic= duixiang.find(1, 1, null, -1, "null");//��ѯ���б���
		  session.setAttribute("alltopic", alltopic);//�洢���б���
	      List<News> allnews= news.allfind();//��ȡ��������
	      session.setAttribute("allnews",allnews);//�洢��������
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
//		   * ��ҳ
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
//		   *1. ��¼
//		   * ����Ǵ���������response����ύ������������ҳ����ʾ����Ȼ������ת�������
//		   * ������˵������return֮ǰ���Ѿ�ִ������ת����ִ�й�response
//		   */
//		  if("denglu".equals(namename)){
//			 
//			 	NewUserServiceImpl p=new NewUserServiceImpl();
//		       String uname= request.getParameter("uname");
//		       String upwd=request.getParameter("upwd");
//		      List<Newuser> a= p.register(uname,upwd);//���õ�¼�ķ����������ݿ��ѯ��û�������Ա
//		      
//		      if(a!=null){
//		   	
//		     	Newuser user=a.get(0);
//		      session.setAttribute("login", user);
//		     // session.setMaxInactiveInterval(10);�Զ�����ʧЧʱ�䣨10��	��
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
//		   *2 ��ӱ���
//		   */
//		  else if("addtopic".equals(namename)){
//		    String  tname=request.getParameter("tname");
//		  	List<Topic> list=topicservice.find("tName",tname,null,-1,null);
//		  	if(list.size()==0){
//		  	topic1.settName(tname);
//		  	   topicservice.addtitle(topic1);
//		  	   out.println("<script type='text/javascript'>");
//		  	   out.println("alert ('��ǰ�б����ɹ������ȷ�Ϸ�������');");
//		  	   out.println("location.href='topicList.jsp';");
//		  	   out.println(" </script>");
//		  	   out.close();
//		  	}else {
//		  		out.println("<script type='text/javascript'>");
//		  		out.println("alert ('��ǰ�����Ѿ����ڣ����������');");
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
//		   *3. �޸ı��⣨��Ĭ��ֵ���л�ȡ��
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
//		   * 4.�޸ı��⣨�Ը���ֵ���и��ģ�
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
//				   out.println("alert ('��ǰ�б��޸ĳɹ������ȷ�Ϸ�������');");
//				   out.println("  location.href='topicList.jsp';");
//				   out.println("</script>");
//				   out.flush();
//				   out.close();
//			    }else{
//			    	 out.println("<script type='text/javascript'>");
//			    	 out.println("alert ('��ǰ�б��޸�ʧ�ܣ����ȷ�Ϸ�������');");
//			    	 out.println("location.href='topicAdd.jsp';");
//			    	 out.println("</script>");
//			    	 out.flush();
//			    	 out.close();
//			     }
//		  
//		}
//		  
//		  /**
//		   *5. ɾ������
//		   */
//		  else if("deletetopic".equals(namename)){
//			   String tid=request.getParameter("tid");
//			   int id=Integer.parseInt(tid);//��tid ��Stringֵת����int��ֵ���������
//			   int a= topicservice.deletetopic(id);
//			   if(a!=0){
//				   out.println("<script type='text/javascript'>");
//				   out.println("alert ('ɾ���ɹ�');");
//				   out.println("location.href='topicList.jsp';");
//				   out.println("</script>");
//				   out.flush();
//				   out.close();
//			   }else{
//				   out.println("<script type='text/javascript'>");
//				   out.println("alert ('ɾ��ʧ��');");
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
//		   *6. �������
//		   */
//		  else if("addnews".equals(namename)){
//			     NewsService newsService=new NewsServiceImpl();
//			   	 request.setCharacterEncoding("utf-8");
//			   	 String uploadFileName="";//�ϴ��ļ���
//			   	 String fieldName="";//���ֶ�Ԫ�ص�name����
//			   	 //������Ϣ�������Ƿ�multipartlei����
//			   	 boolean isMultipart=ServletFileUpload.isMultipartContent(request);
//			   	 //�ϴ��ļ��Ĵ洢··��
//			   	 String uploadFilePath =request.getSession().getServletContext().getRealPath("images/");
//			   	 if(isMultipart){
//			   	 	FileItemFactory factory=new DiskFileItemFactory();
//			   	 	ServletFileUpload upload=new ServletFileUpload(factory);
//			   	 	try{
//			   	 	//����form���������ļ�
//			   	 	List<FileItem> items=upload.parseRequest(request);
//			   	 	Iterator<FileItem> iter=items.iterator();//���İ���֪���Ƿ���ȷ
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
//			   	 	}else{//�ļ����ֶ�
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
//				    out.println("alert ('������ųɹ�');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			        out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('���ʧ��');");
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
//          * 7. ��ʼҳ����޸�����
//          */
//		  else if("amentnews1".equals(namename)){
//			request.setCharacterEncoding("UTF-8");
//		 	String id = request.getParameter("id");
//		 	int nnid=Integer.parseInt(id);//��ȡid
//		 	NewsService newsService =new NewsServiceImpl(); 
//    		List<News> listNews=newsService .newscenter("Nid", nnid, null, -1, null);
//    	    News newss=listNews.get(0);
//    	    request.setAttribute("newss", newss);
//    	    request.getRequestDispatcher("newsAmend.jsp").forward(request,response);
//			
//			
//		}
//		  /**
//		   * 8.�޸�����
//		   */
//		  else 	if("amentnews".equals(namename)){
//		
//		        request.setCharacterEncoding("UTF-8");
//			 	String id = request.getParameter("id");
//			 	 int id1=Integer.parseInt(id);
//			   	 request.setCharacterEncoding("utf-8");
//			   	 String uploadFileName="";//�ϴ��ļ���
//			   	 String fieldName="";//���ֶ�Ԫ�ص�name����
//			   	 //News news=new News();
//			   	  NewsService  newsServic=new NewsServiceImpl();
//			   	  List<News> list= newsServic.entertainmentnews("NID", id1, null, -1, "");
//			   	 //������Ϣ�������Ƿ�multipartlei����
//			   	 boolean isMultipart=ServletFileUpload.isMultipartContent(request);
//			   	 //�ϴ��ļ��Ĵ洢··��
//			   	 String uploadFilePath =request.getSession().getServletContext().getRealPath("images/");
//			 
//			   	 if(isMultipart){
//			   		
//			   	 	FileItemFactory factory=new DiskFileItemFactory();
//			   	 	ServletFileUpload upload=new ServletFileUpload(factory);
//			   	 	try{
//			   	 	//����form���������ļ�
//			   	 	List<FileItem> items=upload.parseRequest(request);
//			   	 	Iterator<FileItem> iter=items.iterator();
//			   	 	while(iter.hasNext()){
//			   	 	FileItem item=(FileItem) iter.next();
//			   	 	if(item.isFormField()){
//			   	 	out.println("<script type='text/javascript'>");
//				    out.println("alert ('����');");
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
//			   	 	}else{//�ļ����ֶ�
//			   	 	out.println("<script type='text/javascript'>");
//				    out.println("alert ('����');");
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
//				    out.println("alert ('�޸����ųɹ�');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('�޸�����ʧ��');");
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
//		   *9. ɾ������
//		   */
//		  else if("deletenews".equals(namename)){
//			String id=request.getParameter("id"); 
//		    NewsService newsservice=new NewsServiceImpl();
//		    int b=Integer.parseInt(id);
//		    int a=newsservice.deletenews(b);
//		   	 if(a>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('ɾ�����ųɹ�');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('ɾ������ʧ��');");
//				    out.println("location.href='admin.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}
//		   	 }
//		
//		/**
//		 * 10.��ȡ����ҳ��ĳ�ʼֵ
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
//			List<Comments> commentlist = commentsservice.query("CNID", a, null,-1, "DESC");//��ȡ����
//			request.setAttribute("commentlist", commentlist);
//			request.getRequestDispatcher("contest.jsp").forward(request,response);
//			return;}
////		    }else{out.println("<script type='text/javascript'>");
////		    out.println("alert ('���¼');");
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
//		 *11. ��������
//		 */
//		  else if("doContest".equals(namename)){
//			
//			   request.setCharacterEncoding("UTF-8");
//			   String tid=request.getParameter("id");
//			   String ccontent=request.getParameter("ccontent");
//			   Comments comments=new Comments();
//			   Date date=new Date();//��ȡ��ǰʱ���
//			   long time=date.getTime();
//			   SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			   String dateString=formatter.format(date);
//			   Date time1 = null;
//			   try {
//				   time1 = formatter.parse(dateString);
//			   } catch (ParseException e) {
//				// TODO Auto-generated catch block
//				   e.printStackTrace();
//			   }//����ȡ��ǰʱ��
//			   int a=Integer.parseInt(tid);
//			   comments.setcDate(time1);//ʱ��
//			   InetAddress ia=null;//1.��ȡ����id
//			   ia=ia.getLocalHost();//2.��ȡ����id
//			   String localip=ia.getHostAddress();//3.��ȡ����id
//			  //  username=(Newuser)session.getAttribute("login");
//			 //  comments.setcAuthor(username);//˭��ӵ�?????????
//			   comments.setcIp( localip);//��ӵ�IP��ַ?????????
//			   comments.setcContent(ccontent);//��ӵ�����
//			   comments.setcNID(a);//����cnid���
//			   CommentsService commentsService=new  CommentsServiceImpl(); 
//			   NewsService newservice=new  NewsServiceImpl();
//		       int add=commentsService.addComments(comments);
//		       if(add>0){
//			   		out.println("<script type='text/javascript'>");
//				    out.println("alert ('������۳ɹ�');");
//				    out.println("location.href='index.jsp';");
//			   	    out.println("</script>");
//			   	    out.flush();
//			   	    out.close();
//				}else{
//					out.println("<script type='text/javascript'>");
//				    out.println("alert ('�������ʧ��');");
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
