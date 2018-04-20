<%@page import="service.TopicService"%>
<%@page import="service.impl.TopicServiceImpl"%>
<%@page import="entity.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topicAmend.jsp' starting page</title>
    
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
   request.setCharacterEncoding("utf-8");
   String tid=request.getParameter("tid");
   String name=request.getParameter("tname");
   Topic topic =new Topic();
   topic.settID(Integer.parseInt(tid));
   topic.settName(name);
   TopicService topicservice=new TopicServiceImpl();
   int i=topicservice.amend(topic);
   if(i>0){%>
      <script type="text/javascript">
	   alert ("当前列表修改成功，点击确认返回主题");

	   location.href="../topicList.jsp";
	   </script>
  <%  }else{%>
   <script type="text/javascript">
	   alert ("当前列表修改失败，点击确认返回主题");
	   location.href="../topicAdd.jsp";
	   </script>
  <% }%>
   
   
   
   
  </body>
</html>
