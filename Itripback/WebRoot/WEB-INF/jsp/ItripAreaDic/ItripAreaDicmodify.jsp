<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>区域管理页面 >> 区域修改页</span>
	</div>
	<div class="itripAreaDicAdd">
		<form id="itripAreaDicForm" name="itripAreaDicForm" method="post"
			action="${pageContext.request.contextPath }/admin/ItripAreaDic/ItripAreaDicmodify.do">
			<input type="hidden" name="id" value="${itripAreaDic.id }" />
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="id">编号：</label> <input type="text" name="id" id="id"
					value="${itripAreaDic.id }" readonly="readonly">
			</div>
			<div>
				<label for="name">区域名称：</label> <input type="text" name="name"
					id="name" value="${itripAreaDic.name }"> <font color="red"></font>
			</div>

			<div>
				<label for="areNo">区域编号：</label> <input type="text" name="areNo"
					id="areNo" value="${itripAreaDic.areano }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="parent">父级区域ID：</label> <input type="text"
					name="parent" id="parent" value="${itripAreaDic.parent }">
				<font color="red"></font>
			</div>

			<div>
				<label for="isActivated">是否激活：</label> <input type="text"
					name="isActivated" id="isActivated"
					value="${itripAreaDic.isactivated }">
			</div>

			<div>
				<label for="isTradingArea">是否是商圈：</label> <input type="text"
					name="isTradingArea" id="isTradingArea"
					value="${itripAreaDic.istradingarea }">
			</div>

			<div>
				<label for="isHot">是否是热门城市：</label> <input type="text" name="isHot"
					id="isHot" value="${itripAreaDic.ishot }">
			</div>
			<div class="">
				<label for="level">区域级别 (0: 国家级 1: 省 级 2: 市级 3: 县/区)：</label> <input
					type="text" name="level" id="level" value="${itripAreaDic.level }">
			</div>
			<div>
				<label for="isChina">是否在国内(1: 国内 2：国外)：</label> <input type="text"
					name="isChina" id="isChina" value="${itripAreaDic.ischina }">
				<font color="red"></font>
			</div>

			<div>
				<label for="pinyin">区域名称拼音：</label> <input type="text" name="pinyin"
					id="pinyin" value="${itripAreaDic.pinyin }"> <font
					color="red"></font>
			</div>

			<div>
				<label for="creationDate">创建时间：</label> <input type="text"
					name="creationDate" id="creationDate"
					value="${itripAreaDic.creationdate }"> <font color="red"></font>
			</div>

			<div>
				<label for="createBy">创建人：</label> <input type="text"
					name="createBy" id="createBy" value="${itripAreaDic.createdby }">
			</div>

			<div>
				<label for="modifyDate">修改时间：</label> <input type="text"
					name="modifyDate" id="modifyDate"
					value="${itripAreaDic.modifydate }">
			</div>

			<div>
				<label for="modifyBy">修改人：</label> <input type="text"
					name="modifyBy" id="modifyBy" value="${itripAreaDic.modifiedby }">
			</div>

			<div class="itripAreaDicAddBtn">
				<input type="button" name="save" id="save" value="保存"> <input
					type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/itripAreaDicmodify.js"></script>