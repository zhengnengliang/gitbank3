<%@page import="entity.Newuser"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Comments"%>
<%@page import="service.impl.CommentsServiceImpl"%>
<%@page import="service.CommentsService"%>
<%@page import="entity.News"%>
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
    
    <title>My JSP 'doContest.jsp' starting page</title>
    
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
	<% request.setCharacterEncoding("UTF-8");
	   String tid=request.getParameter("id");
	   String cip=request.getParameter("cip");
	   String ccontent=request.getParameter("ccontent");
	   %>
	  
	   <% 
	   
	   Comments comments=new Comments();
	   Date date=new Date();//获取当前时间从
	   long time=date.getTime();
	   SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString=formatter.format(date);
	   Date time1=formatter.parse(dateString);//到获取当前时间
	   int a=Integer.parseInt(tid);
	    Newuser user=(Newuser)session.getAttribute("login"); 
	     comments.setcDate(time1);//时间
	   comments.setcContent(ccontent);//评论
	   if(user!=null){
	   comments.setcAuthor(user.getuName());
	   }else{
	   comments.setcAuthor("匿名用户");
	   }
	   comments.setcIp(cip);//cip
	   comments.setcNID(a);//cnid
	   CommentsService commentsService=new  CommentsServiceImpl(); 
	   NewsService newservice=new  NewsServiceImpl();
       commentsService.addComments(comments);
	   response.sendRedirect("../contest.jsp?id="+a);
       %>
  </body>
</html>
