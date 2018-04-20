<%@page import="entity.Comments"%>
<%@page import="service.impl.CommentsServiceImpl"%>
<%@page import="service.CommentsService"%>
<%@page import="entity.Newuser"%>
<%@page import="entity.News"%>
<%@page import="service.impl.NewsServiceImpl"%>
<%@page import="service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 5.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkComment(){
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if(cauthor.value == ""){
			alert("用户名不能为空！！");
			return false;
		}else if(content.value == ""){
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div id="header">
		<div id="top_login">
		
			<form action="indexServlet?namename=denglu" method="post">
				<label> 登录名 </label> <input type="text" name="uname" id="uname"
					value="" class="login_input" /> <label> 密&#160;&#160;码 </label> <input
					type="password" name="upwd" id="upwd" value="" class="login_input" />
				<input type="submit" class="login_sub" value="登录" /> <label
					id="error"> </label> <img src="images/friend_logo.gif" alt="Google"
					id="friend_logo" />
			</form>
			
		</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
		<li><a href="index.jsp">                          返回首页</a></li>
	</div>
	<div id="container">

		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul> 
				
				 <c:forEach var="product" items="${sessionScope.national}" varStatus="status">
    		            <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>
    		     </c:forEach>  
    		     	
				</ul>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					
    		        <c:forEach var="product" items="${sessionScope.worldNews}" varStatus="status">
    		        <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>
     		        </c:forEach>
    		
				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
				
    		       <c:forEach var="product" items="${sessionScope.happyNews}" varStatus="status">
    		          <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>
     		       </c:forEach>
				</ul>
			</div>
		</div>


		<div class="main">
			<div class="class_type">
				<img src="images/class_type.gif" alt="新闻中心" />
			</div>
			<li><a href="index.jsp">                          返回首页</a></li>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center">
						<tr>

						
							<td colspan="2" align="center">
							${requestScope.newscontest.nTitle}
								</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">作者:${requestScope.newscontest.nAuthor} </td>
							<td align="left">发布时间：${requestScope.newscontest.nCreatedate}</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2"> ${requestScope.newscontest.nContent} </td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<table width="80%" align="center">

						
						<tr>
							<td colspan="6"><hr /></td>
						</tr>  
					</table>
				</ul>
				<form action="indexServlet?namename=doContest&id=${requestScope.ccid}" method="post">
					<ul class="classlist">

						<table width="80%" align="center">
							<tr>
								<td>评 论:
								<c:choose>
								<c:when test="${fn:length(commentlist)!=0}">
								<c:forEach var="pruduct" items="${requestScope.commentlist}">
								<li>${pruduct.cAuthor}:     ${pruduct.cContent}</li>
								</c:forEach>
								</c:when>
								<c:otherwise>
								       暂无评论
								</c:otherwise>
								</c:choose>
								</td>
								
							</tr>
							<tr>
								<td>用户名：
								<c:choose>
								<c:when test="${empty requestScope.newscontest}">
								 匿名
								</c:when>
							    <c:otherwise>
							    ${requestScope.newscontest.nAuthor}
							    </c:otherwise>
								</c:choose>
								
								</td>
								
								IP： <input name="cip" id="cip"
									value="不知道怎么写
								<%--	<c:forEach var="pruduct" items="${requestScope.commentlist}">
									<li>${pruduct.cIp}</li>
									</c:forEach>--%>
									"/>
								
									</td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="ccontent" id="ccontent"
							     placeholder="请填入你的评论"
										cols="70" rows="10"></textarea></td>
							</tr>
							<tr>
								<td><input name="submit" value="发  表" type="submit" /></td>
							</tr>

						</table>

					</ul>
			</div>
		</div>
	</div>

	<div id="friend">
		<h1 class="friend_t">
			<img src="images/friend_ico.gif" alt="合作伙伴" />
		</h1>
		<div class="friend_list">
			<ul>
				<li><a href="#">百度</a></li>
				<li><a href="#">谷歌</a></li>
				<li><a href="#">新浪</a></li>
				<li><a href="#">网易</a></li>
				<li><a href="#">搜狐</a></li>
				<li><a href="#">人人</a></li>
				<li><a href="#">中国政府网</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p class="">
			24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a>
			&#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
			文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a>
		</p>
		<p class="copyright">
			Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
			新闻中国 版权所有
		</p>
	</div>
</body>
</html>
