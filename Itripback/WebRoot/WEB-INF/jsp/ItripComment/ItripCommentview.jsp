<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>评论管理页面 >> 评论信息查看</span>
        </div>
        <div class="itripCommentView">
            <p><strong>编号：</strong><span>${itripComment.id }</span></p>
            <p><strong>酒店iD：</strong><span>${itripComment.hotelid }</span></p>
            <p><strong>房间iD：</strong><span>${itripComment.productid }</span></p>
            <p><strong>订单iD：</strong><span>${itripComment.orderid }</span></p>
            <p><strong>订单类型：</strong><span>${itripComment.producttype }</span></p>
            <p><strong>评论内容：</strong><span>${itripComment.content }</span></p>
            <p><strong>评论用户iD：</strong><span>${itripComment.userid }</span></p>
            <p><strong>是否含有图片：</strong><span>${itripComment.ishavingimg }</span></p>
            <p><strong>位置评分：</strong><span>${itripComment.positionscore }</span></p>
            <p><strong>特色评分：</strong><span>${itripComment.facilitiesscore }</span></p>
            <p><strong>服务评分：</strong><span>${itripComment.servicescore }</span></p>
            <p><strong>卫生评分：</strong><span>${itripComment.hygienescore }</span></p>
            <p><strong>总平均分：</strong><span>${itripComment.score }</span></p>
            <p><strong>出游类型：</strong><span>${itripComment.tripmode }</span></p>
            <p><strong>是否满意：</strong><span>${itripComment.isok }</span></p>
            <p><strong>创建时间：</strong><span>${itripComment.creationdate }</span></p>
            <p><strong>创建人：</strong><span>${itripComment.createdby }</span></p>
            <p><strong>修改时间：</strong><span>${itripComment.modifydate }</span></p>
            <p><strong>修改人：</strong><span>${itripComment.modifiedby }</span></p>
			<div class="itripCommentAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/itripCommentview.js"></script>
