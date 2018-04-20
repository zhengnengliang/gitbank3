<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fenye.jsp' starting page</title>
    
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
   <fieldset style="margin: 0 auto;">  
        <legend>分页测试</legend>  
        <div id="pages">  
            <s:if test="currentPage<=1">  
                <a href="#">首页</a>  
                <a href="#" class="pager">上一页</a>  
            </s:if>  
            <s:else>  
                <a href="pager.action?currentPage=1">首页</a>  
                <a  
                    href="pager.action?currentPage=<s:property value="currentPage-1"/>">上一页</a>  
            </s:else>  
            <!-- 页码限制为10页算法 -->  
            <s:iterator  
                begin="currentPage>4?currentPage+5>totalPage?totalPage>10?totalPage-9:1:currentPage-4:1"  
                end="currentPage>4?currentPage+5>totalPage?totalPage:currentPage+5:totalPage>10?10:totalPage"  
                var="i">  
                <s:if test="currentPage==#i">  
                    <a href="#" class="current_page"><s:property value="#i" /></a>  
                </s:if>  
                <s:else>  
                    <a href="pager.action?currentPage=<s:property value="#i"/>"><s:property  
                            value="#i" /></a>  
                </s:else>  
            </s:iterator>  
            <s:if test="currentPage>=totalPage">  
                <a href="#">下一页</a>  
                <a href="#">尾页</a>  
            </s:if>  
            <s:else>  
                <a  
                    href="pager.action?currentPage=<s:property value="currentPage+1"/>">下一页</a>  
                <a href="pager.action?currentPage=<s:property value="totalPage"/>">尾页</a>  
            </s:else>  
        </div>  
    </fieldset>  
  
  </body>
</html>
