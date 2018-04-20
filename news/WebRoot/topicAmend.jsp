<%@page import="service.TopicService"%>
<%@page import="service.impl.TopicServiceImpl"%>
<%@page import="entity.Topic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
	 		+ path + "/";
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
	<div id="header">
		<div id="welcome">欢迎使用新闻管理系统！</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
		</div>


	</div>
	<div id="admin_bar">
		<input type="checkbox" name="cbl" value="sports" checked />运动
		<div id="status">
			管理员：${sessionScope.login.uName} 登录 &#160;&#160;&#160;&#160; <a
				href="index.jsp">login out</a>
		</div>
		<div id="channel"></div>
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
			<h1 id="opt_type">修改主题：</h1>
			<form action="indexServlet?namename=amendtopic" method="post" onsubmit="">

				<p>
					<label> 主题名称 </label>
					
					<input name="tname" type="text" class="opt_input" id="tname"
						value=${requestScope.topic2.tName}/>
						<input name="tid" type="hidden" class="opt_input" id="tname" value=${requestScope.topic2.tID} />
				</p>
				<input name="action" type="hidden" value="addtopic" /> <input
					type="submit" value="提交" class="opt_sub" /> <input type="reset"
					value="重置" class="opt_sub" />
			</form>
		</div>
	</div>
	<div id="footer">
		<div id="site_link">
			<a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span>
			<a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span>
			<a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span>
			<a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span>
			<a href="#">留言反馈</a>
		</div>
		<div id="footer">
			<p class="">
				24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a>
				&#160;&#160;&#160;&#160; 新闻热线：010-627488888<br />
				文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a>
			</p>
			<p class="copyright">
				Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
				新闻中国 版权所有
			</p>
		</div>
	</div>





</body>
</html>
