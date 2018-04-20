package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.NewsService;
import service.impl.NewsServiceImpl;
import entity.News;

public class NewsAmendAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		 try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.println("<script type='text/javascript'>");
	    out.println("alert ('来了');");
   	    out.println("</script>");
   	   String id = request.getParameter("id");
   	   int id1=Integer.parseInt(id);
		
		   	 try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   	 String uploadFileName="";//上传文件名
		   	 String fieldName="";//表单字段元素的name属性
		   	 //News news=new News();
		   	  NewsService  newsServic=new NewsServiceImpl();
		   	  List<News> list= newsServic.entertainmentnews("NID", id1, null, -1, "");
		   	  News news1=list.get(0);	
		   	 //请求信息中内容是否multipartlei类型
		   	 boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		   	 //上传文件的存储路路径
		   	 String uploadFilePath =request.getSession().getServletContext().getRealPath("images/");
		 
		   	 if(isMultipart){
		   		
		   	 	FileItemFactory factory=new DiskFileItemFactory();
		   	 	ServletFileUpload upload=new ServletFileUpload(factory);
		   	 	try{
		   	 	//解析form表单中所有文件
		   	 	List<FileItem> items=upload.parseRequest(request);
		   	 	Iterator<FileItem> iter=items.iterator();
		   	 	while(iter.hasNext()){
		   	 	FileItem item=(FileItem) iter.next();
		   	 	if(item.isFormField()){
			   	 	fieldName =item.getFieldName();
			   	 		 if(item.getFieldName().equals("ntitle")){
							 news1.setnTitle(item.getString("UTF-8"));
						 }else if(item.getFieldName().equals("nauthor")){
							news1.setnAuthor( item.getString("UTF-8")) ;
						 }else if(item.getFieldName().equals("nsummary")){
							news1.setnSummary(item.getString("UTF-8"));
						 }else if(item.getFieldName().equals("ncontent")){
							news1.setnContent(item.getString("UTF-8"));
						 }else if(item.getFieldName().equals("ntid")){
							 news1.setnTID(Integer.parseInt(item.getString("UTF-8")));
						 }

		   	 	}else{//文件表单字段
		   	 	out.println("<script type='text/javascript'>");
			    out.println("alert ('走了');");
		   	    out.println("</script>");
			   	 	String fileName=item.getName();
			   	 	if(fileName!=null&&!fileName.equals("")){
		   	 			File fullFile=new File(item.getName());
		   	 			File saveFile=new File
		   	 			(uploadFilePath,fullFile.getName());
		   	 			item.write(saveFile);
		   	 			uploadFileName=fullFile.getName();
		   	 	    }
		   	 	}
		   	 	}
		   	 	}catch(Exception e){
		   	 	e.printStackTrace();
		   	 	 
		   	 }
		   	 	int i=newsServic.amentNews(news1);
		   	 	
		   	 if(i>0){
		   		out.println("<script type='text/javascript'>");
			    out.println("alert ('修改新闻成功');");
			    out.println("location.href='admin.jsp';");
		   	    out.println("</script>");
		   	    out.flush();
		   	    out.close();
			}else{
				out.println("<script type='text/javascript'>");
			    out.println("alert ('修改新闻失败');");
			    out.println("location.href='admin.jsp';");
		   	    out.println("</script>");
		   	    out.flush();
		   	    out.close();
			}
		 }
		 return;
		
		 
	}

}
