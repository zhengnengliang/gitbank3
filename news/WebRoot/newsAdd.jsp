<%@page import="entity.Newuser"%>
<%@page import="entity.Topic"%>
<%@page import="service.TopicService"%>
<%@page import="service.NewsService"%>
<%@page import="service.impl.NewsServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="service.impl.TopicServiceImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath}">
    
    <title>My JSP 'addnews.jsp' starting page</title>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
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
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员用户：${sessionScope.login.uName}&#12288;&#12288;&#12288;<a href="index.jsp" onclick="">返回首页</a>&#12288;<a href="util/do_logout.jsp">注销登陆</a></div>
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
    <h1 id="opt_type"> 添加新闻： </h1>
    <form action="indexServlet?namename=addnews" enctype="multipart/form-data"  method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid" id="ntid">

   	 
   	 <c:forEach var="product" items="${sessionScope.alltopic}">
   	 <option value='${product.tID}'>${product.tName}</option>
   	 </c:forEach>
   	 
   	 
   	 
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" id="ntitle" type="text" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" id="nauthor" type="text" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" id="nsummary" cols="40" rows="3"></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent"  id="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>        
        <input type="file" name="nfile"/>
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</div>

</html>
