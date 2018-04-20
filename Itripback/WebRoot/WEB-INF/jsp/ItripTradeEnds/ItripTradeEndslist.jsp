<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>支付宝交易成功中间表管理页面</span>
        </div>
        <div class="search">
        	<form method="get" action="${pageContext.request.contextPath }/admin/ItripTradeEnds/ItripTradeEnds.do" method="post">
				<input name="method" value="query" type="hidden">
				
				<span>支付宝交易成功中间表名称：</span>
				<input name="queryProName" type="text" value="${queryProid }">
				
				<input value="查 询" type="submit" id="searchbutton">
				<a href="${pageContext.request.contextPath }/admin/ItripTradeEnds/ItripTradeEndsadd.do">添加支付宝交易成功中间表</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="ItripAreaDicTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="20%">编号</th>
                <th width="30%">支付宝交易成功中间表名称</th>
                <th width="30%">支付宝交易成功中间表编号</th>
                <th width="20%">操作</th>
            </tr>
            <c:forEach var="ItripTradeEnds" items="${ItripTradeEndsList }" varStatus="status">
				<tr>
				<%-- ${itripAreaDic.id } --%>
					<td>
					<span>${ItripTradeEnds.id }</span>
					</td>
					<td>
					<span>${ItripTradeEnds.orderno }</span>
					</td>
					<td>
					<span>${ItripTradeEnds.flag }</span>
					</td>
					<td>
					<span><a class="viewItripTradeEnds" href="javascript:;" proid=${ItripTradeEnds.id }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyItripTradeEnds" href="javascript:;" proid=${ItripTradeEnds.id }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteItripTradeEnds" href="javascript:;" proid=${ItripTradeEnds.id }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/statics/js/itripTradeEndslist.js"></script>
