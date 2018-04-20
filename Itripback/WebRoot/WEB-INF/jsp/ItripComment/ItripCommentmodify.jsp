<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>评论管理页面 >> 评论修改页</span>
	</div>
	<div class="itripCommentAdd">
		<form id="itripCommentForm" name="itripCommentForm" method="post"
			action="${pageContext.request.contextPath }/admin/itripComment/itripCommentmodify.do">
			<input type="hidden" name="id" value="${itripComment.id }" />
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="id">编号：</label> <input type="text" name="id" id="id"
					value="${itripComment.id }" readonly="readonly">
			</div>
			<div>
				<label for="name">酒店iD：</label> <input type="text" name="name"
					id="name" value="${itripComment.hotelid }"> <font color="red"></font>
			</div>
			<div>
				<label for="areNo">房间iD：</label> <input type="text" name="areNo"
					id="areNo" value="${itripComment.productid }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="areNo">订单iD：</label> <input type="text" name="areNo"
					id="areNo" value="${itripComment.orderid }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="parent">订单类型：</label> <input type="text"
					name="parent" id="parent" value="${itripComment.producttype }">
				<font color="red"></font>
			</div>
			<div class="">
				<label for="id">评论内容：</label> <input type="text" name="id" id="id"
					value="${itripComment.content }" readonly="readonly">
			</div>
			<div>
				<label for="name">评论用户iD：</label> <input type="text" name="name"
					id="name" value="${itripComment.userid }"> <font color="red"></font>
			</div>

			<div>
				<label for="areNo">是否含有图片：</label> <input type="text" name="areNo"
					id="areNo" value="${itripComment.ishavingimg }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="parent">>位置评分：</label> <input type="text"
					name="parent" id="parent" value="${itripComment.positionscore }">
				<font color="red"></font>
			</div>
			<div>
				<label for="isActivated">特色评分：</label> <input type="text"
					name="isActivated" id="isActivated"
					value="${itripComment.facilitiesscore }">
			</div>

			<div>
				<label for="isTradingArea">服务评分：</label> <input type="text"
					name="isTradingArea" id="isTradingArea"
					value="${itripComment.servicescore }">
			</div>

			<div>
				<label for="isHot">卫生评分：</label> <input type="text" name="isHot"
					id="isHot" value="${itripComment.hygienescore }">
			</div>
			<div class="">
				<label for="level">总平均分：</label> <input
					type="text" name="level" id="level" value="${itripComment.score }">
			</div>
			<div>
				<label for="isChina">出游类型：</label> <input type="text"
					name="isChina" id="isChina" value="${itripComment.tripmode }">
				<font color="red"></font>
			</div>

			<div>
				<label for="pinyin">是否满意：</label> <input type="text" name="pinyin"
					id="pinyin" value="${itripComment.isok }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="creationDate">创建时间：</label> <input type="text"
					name="creationDate" id="creationDate"
					value="${itripComment.creationdate }"> <font color="red"></font>
			</div>

			<div>
				<label for="createBy">创建人：</label> <input type="text"
					name="createBy" id="createBy" value="${itripComment.createdby }">
			</div>

			<div>
				<label for="modifyDate">修改时间：</label> <input type="text"
					name="modifyDate" id="modifyDate"
					value="${itripComment.modifydate }">
			</div>

			<div>
				<label for="modifyBy">修改人：</label> <input type="text"
					name="modifyBy" id="modifyBy" value="${itripComment.modifiedby }">
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
	src="${pageContext.request.contextPath }/statics/js/itripCommentmodify.js"></script>