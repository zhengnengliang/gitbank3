<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>支付宝交易成功中间表管理页面 >> 支付宝交易成功中间表信息查看</span>
        </div>
        <div class="itripTradeEndsView">
            <p><strong>编号：</strong><span>${ite.id }</span></p>
            <p><strong>订单编号：</strong><span>${ite.orderno }</span></p>
            <p><strong>交易状态：</strong><span>${ite.flag }</span></p>
			<div class="itripTradeEndsAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/itripTradeEndsview.js"></script>
