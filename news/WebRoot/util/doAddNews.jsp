<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.News"%>
<%@page import="java.io.*"%>
<%@page import="service.impl.NewsServiceImpl"%>
<%@page import="service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doaddnews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <% 
     NewsService newsService=new NewsServiceImpl();
   	 request.setCharacterEncoding("utf-8");
   	 String uploadFileName="";//上传文件名
   	 String fieldName="";//表单字段元素的name属性
   	 News news=new News();
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
					 news.setnTitle(item.getString("UTF-8"));
				 }else if(item.getFieldName().equals("nauthor")){
					news.setnAuthor( item.getString("UTF-8")) ;
				 }else if(item.getFieldName().equals("nsummary")){
					news.setnSummary(item.getString("UTF-8"));
				 }else if(item.getFieldName().equals("ncontent")){
					news.setnContent(item.getString("UTF-8"));
				 }else if(item.getFieldName().equals("ntid")){
					 news.setnTID(Integer.parseInt(item.getString("UTF-8")));
				 }

   	 	}else{//文件表单字段
	   	 	String fileName=item.getName();
	   	 	if(fileName!=null&&!fileName.equals("")){
   	 			File fullFile=new File(item.getName());
   	 			File saveFile=new File
   	 			(uploadFilePath,fullFile.getName());
   	 			item.write(saveFile);
   	 			//uploadFileName=fullFile.getName();
   	 			news.setnPicpath(fullFile.getName());
   	 	    }
   	 	}
   	 	}
   	 	}catch(Exception e){
   	 	e.printStackTrace();
   	 	
   	 }int i=newsService.addnews(news);
   	 if(i>0){
   	 %>
   	 <script type="text/javascript">
   	 alert("添加新闻成功");
   	 location.href="../admin.jsp";
   	 </script>
   
	<%} else{%>
	 <script type="text/javascript">
   	 alert("添加失败");
   	 location.href="../admin.jsp";
   	 </script>
	<%}}%>
   
  </body>
</html>
