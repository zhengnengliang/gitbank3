<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>评论管理页面</span>
        </div>
        <div class="search">
        	<form method="get" action="${pageContext.request.contextPath }/admin/ItripComment/ItripComment.do" method="post">
				<input name="method" value="query" type="hidden">
				
				<span>评论内容：</span>
				<input name="queryProName" type="text" value="${queryProName }">
				
				<input value="查 询" type="submit" id="searchbutton">
				<a href="${pageContext.request.contextPath }/admin/ItripComment/ItripCommentadd.do">添加评论</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="ItripCommentTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th>编号</th>
                <th>酒店ID</th>
                <th>房间ID</th>
                <th>订单ID</th>
                <th>订单类型</th>
                <th width="30%">评论内容</th>
                <th>评论用户ID</th>
                <th>是否含有图片</th>
                <th>位置评分</th>
                <th>特色评分</th>
                <th>服务评分</th>
                <th>卫生评分</th>
                <th>总平均分</th>
                <th>出游类型</th>
                <th>是否满意</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>修改时间</th>
                <th>修改人</th>
                <th width="10%">操作</th>
            </tr>
            <c:forEach var="ItripComment" items="${ItripCommentList }" varStatus="status">
				<tr>
				<%-- ${ItripComment.id } --%>
					<td>
					<span>${ItripComment.id }</span>
					</td>
					<td>
					<span>${ItripComment.hotelid }</span>
					</td>
					<td>
					<span>${ItripComment.productid }</span>
					</td>
					<td>
					<span>${ItripComment.orderid }</span>
					</td>
					<td>
					<span>${ItripComment.producttype }</span>
					</td>
					<td>
					<span>${ItripComment.content }</span>
					</td>
					<td>
					<span>${ItripComment.userid }</span>
					</td>
					<td>
					<span>${ItripComment.ishavingimg }</span>
					</td>
					<td>
					<span>${ItripComment.positionscore }</span>
					</td>
					<td>
					<span>${ItripComment.facilitiesscore }</span>
					</td>
					<td>
					<span>${ItripComment.servicescore }</span>
					</td>
					<td>
					<span>${ItripComment.hygienescore }</span>
					</td>
					<td>
					<span>${ItripComment.score }</span>
					</td>
					<td>
					<span>${ItripComment.tripmode }</span>
					</td>
					<td>
					<span>${ItripComment.isok }</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${ItripComment.creationdate}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</span>
					</td>
					<td>
					<span>${ItripComment.createdby }</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${ItripComment.modifydate}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</span>
					</td>
					<td>
					<span>${ItripComment.modifiedby }</span>
					</td>
					<td>
					<span><a class="viewItripComment" href="javascript:;" proid=${ItripComment.id }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyItripComment" href="javascript:;" proid=${ItripComment.id }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteItripComment" href="javascript:;" proid=${ItripComment.id }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
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
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/statics/js/itripCommentlist.js"></script>
