<%@page import="entity.Newuser"%>
<%@page import="service.TopicService"%>
<%@page import="service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
<%@page import="service.impl.NewsServiceImpl"%>   
<%@page import="entity.News"%> 
<%@page import="entity.Topic"%> 
<%@page import="service.impl.TopicServiceImpl"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻中国</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();	
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}
	
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
</script>

  </head>
  
  <body onload="focusOnLogin()">
<div id="header">
  <div id="top_login">
  
  <%    int a= 1;
        int id=0;
    	List <News> slist = new ArrayList();
  		request.setCharacterEncoding("UTF-8");
		String tid  =request.getParameter("id");
		
		
		String dangqianye  =request.getParameter("a");
		if(dangqianye==null){
			dangqianye ="1";
		}
		int dangqianye1=Integer.parseInt(dangqianye );//当前页
		if(tid==null){
		   id=1;
	    }else{
		   id=Integer.parseInt(tid);
			 }
        NewsService news=new NewsServiceImpl();
        List<News> list=news.entertainmentnews("NTID",id , null, -1, "") ;
  		int zhusu=0;
        if( list.size()%10==0){//总页数
            zhusu=  list.size()/10;
        }else{
            zhusu= (int)(list.size()/10+1);
        }
        a=dangqianye1;
        slist = news.fenye1(id ,a, zhusu) ;
			%>

    <c:choose >
    <c:when test="${empty login}">
     <form action="indexServlet?namename=denglu" method="post" onsubmit="return check()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
      </form>
    </c:when>
    <c:otherwise>
    <c:choose>
    			<c:when test="${login.uName eq 'admin'}">
	       		 <!-- <script type="text/javascript">
	              alert("欢迎进入管理员页面内");
		  			// location.href="topicList.jsp";
		  		  </script> -->
		  		   <%response.sendRedirect("admin.jsp");%>
	       		</c:when>
	       		<c:otherwise>
	       		 <c:out value="user.uName"/>
	       		 	<script type="text/javascript">
	       		 		alert(${login.uName});
	       		 	</script>
	       		</c:otherwise>
	       		</c:choose>
		</c:otherwise>
    </c:choose>

 
    
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
<div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>  
            <c:forEach var="product" items="${sessionScope.national}" varStatus="status">
    		  <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>
    		</c:forEach>	
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>      
      
      
    		 <c:forEach var="product" items="${sessionScope.worldNews}" varStatus="status">
    		  <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>

     		</c:forEach>
      	
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
    	 <c:forEach var="product" items="${sessionScope.happyNews}" varStatus="status">
    		  <li> <a href="indexServlet?namename=doContest1&id=${product.nID}"><b> ${product.nTitle}</b></a> </li>
     	 </c:forEach>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
  <div>
     <c:forEach var="product" items="${applicationScope.all_topics}" varStatus="status">
              <c:out value="${product.tName}"/>
      </c:forEach>
    </div> 
    
      <ul class="class_date">
	      	<li id='class_month'>
             <c:forEach var="product" items="${requestScope.topic}" varStatus="status">
    		    <a href="indexServlet?namename=doContest1&id=${product.tID}"></a> 
              <c:out value="${product.tName}"/>
     		 </c:forEach>
          </li>	
      </ul>
   
          
      <ul>
      <c:forEach var="pruduct" items="${sessionScope.allnews }">
      <li><a href="indexServlet?namename=doContest1&id=${pruduct.nID}">${pruduct.nTitle}</a></li>
      </c:forEach>
      </ul>
    </div>   
<div class="picnews">
  <ul>
    <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
    <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">百度</a> </li>
      <li> <a href="#">谷歌</a> </li>
      <li> <a href="#">新浪</a> </li>
      <li> <a href="#">网易</a> </li>
      <li> <a href="#">搜狐</a> </li>
      <li> <a href="#">人人</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>

