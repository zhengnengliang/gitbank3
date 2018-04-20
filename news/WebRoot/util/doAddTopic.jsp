<%@page import="entity.Topic"%>
<%@page import="service.impl.TopicServiceImpl"%>
<%@page import="service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doAddTopic.jsp' starting page</title>
    
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
<% String  tname=request.getParameter( "tname");
	TopicService topicservice=new TopicServiceImpl();
	List<Topic> list=topicservice.find("tName",tname,null,-1,null);
	if(list.size()==0){
	Topic topic=new Topic();
	topic.settName(tname);
	   topicservice.addtitle(topic);%>
	   <script type="text/javascript">
	   alert ("当前列表创建成功，点击确认返回主题");
	   location.href="../topicList.jsp";
	   </script>
	<% }else {%>
	 <script type="text/javascript">
	   alert ("当前主题已经存在，请重新添加");
	   location.href="../topicList.jsp";
	   </script>
 <%} %>
   
  </body>
</html>
