<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>支付宝交易成功中间表管理页面 >> 支付宝交易成功中间表修改页</span>
	</div>
	<div class="itripTradeEndsAdd">
		<form id="ItripTradeEndsForm" name="itripTradeEndsForm" method="post"
			action="${pageContext.request.contextPath }/admin/ItripTradeEnds/ItripTradeEndsmodify.do">
			<input type="hidden" name="id" value="${ite.id }" />
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="id">编号：</label> <input type="text" name="id" id="id"
					value="${ite.id }" readonly="readonly">
			</div>
			<div>
				<label for="orderno">订单编号：</label> <input type="text" name="name"
					id="name" value="${ite.orderno }"> <font color="red"></font>
			</div>

			<div>
				<label for="flag">操作状态：</label> <input type="text" name="areNo"
					id="areNo" value="${ite.flag }"> <font
					color="red"></font>
			</div>
			<div class="itripCommentAddBtn">
				<input type="button" name="save" id="save" value="保存"> <input
					type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/itripTradeEndsmodify.js"></script>