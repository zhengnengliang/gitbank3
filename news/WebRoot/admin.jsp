<%@page import="entity.Newuser"%>
<%@page import="entity.News"%>
<%@page import="service.impl.NewsServiceImpl"%>
<%@page import="service.NewsService"%>
<%@page import="service.impl.TopicServiceImpl"%>
<%@page import="service.TopicService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
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
   <div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国"/></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt=""/></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${sessionScope.login.uName} 登录  &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/news/util/do_logout.jsp">login out</a></div>
  <div id="channel"> </div>
</div>



<div id="main">
  <div id="opt_list">
  <ul>
     <li><a href="newsAdd.jsp">添加新闻</a></li>
    <li><a href="newsAmend.jsp">编辑新闻</a></li>
    <li><a href="topicAdd.jsp">添加主题</a></li>
    <li><a href="topicList.jsp">编辑主题</a></li>
  </ul>
</div>

  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
       	 <c:forEach var="product" items="${sessionScope.allnews}">
   	   <li>${product.nTitle}<span> 作者：${product.nAuthor} &nbsp;&nbsp;&nbsp;&nbsp; <a href="indexServlet?namename=amentnews1&id=${product.nID}">修改</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="indexServlet?namename=deletenews&id=${product.nID}" onclick="">删除</a> </span> </li>	      
   	 </c:forEach>
 </ul>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="">关于我们</a><span>|</span> <a href="">Aboue Us</a><span>|</span> <a href="">联系我们</a><span>|</span> <a href="">广告服务</a><span>|</span> <a href="">供稿服务</a><span>|</span> <a href="">法律声明</a><span>|</span> <a href="">招聘信息</a><span>|</span> <a href="">网站地图</a><span>|</span> <a href="">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <a href="">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<br/>
    文明办网文明上网举报电话：010-627488888  &nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<a href="">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright © 1999-2009 News China gov, All Right Reserver<br/>
    新闻中国   版权所有</p>
</div>
</div>
<div></div>
  </body>
</html>
