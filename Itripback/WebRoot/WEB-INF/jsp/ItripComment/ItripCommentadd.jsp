<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>评论管理页面 >> 评论添加页面</span>
        </div>
        <div class="ItripCommentAdd">
           <%-- <form id="ItripCommentForm" name="ItripCommentForm" method="post" action="${pageContext.request.contextPath }/jsp/ItripComment.do">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <input type="text" name="proCode" id="proCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                   <input type="text" name="proName" id="proName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proContact">联系人：</label>
                    <input type="text" name="proContact" id="proContact" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                    <input type="text" name="proPhone" id="proPhone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                    <input type="text" name="proAddress" id="proAddress" value=""> 
                </div>
                <div>
                    <label for="proFax">传真：</label>
                    <input type="text" name="proFax" id="proFax" value=""> 
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <input type="text" name="proDesc" id="proDesc" value=""> 
                </div>
                <div class="ItripCommentAddBtn">
                    <input type="button" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form> --%>
            
        <fm:form method="post" modelAttribute="itripComment">
    	<div class="">编号：        <fm:input path="id"/>   <br/></div>
    	<div class="">酒店ID：        <fm:input path="hotelid"/>   <br/></div>
    	<div class="">房间ID：	  	 <fm:input path="productid"/><br/></div>
    	<div class="">订单ID：	 <fm:input path="orderid"/>   <br/></div>
    	<div class="">订单类型：           <fm:input path="producttype"/><br/></div>
    	<div class="">评论内容：                   <fm:input path="content"/><br/></div>
    	<div class="">评论用户ID：                   <fm:input path="userid"/><br/></div>
    	<div class="">是否含有图片：           <fm:input path="ishavingimg"/><br/></div>
    	<div class="">位置评分：                   <fm:input path="positionscore"/><br/></div>
    	<div class="">特色评分：                   <fm:input path="facilitiesscore"/><br/></div>
    	<div class="">服务评分：                   <fm:input path="servicescore"/><br/></div>
    	<div class="">卫生评分：                   <fm:input path="hygienescore"/><br/></div>
    	<div class="">总平均分：                   <fm:input path="score"/><br/></div>
    	<div class="">出游类型：           <fm:input path="tripmode"/><br/></div>
    	<div class="">是否满意：           <fm:input path="isok"/><br/></div>
    	<div class="">创建时间：           <fm:input path="creationdate"/><br/></div>
    	<div class="">创建人：                   <fm:input path="createdby"/><br/></div>
    	<div class="">修改时间：                   <fm:input path="modifydate"/><br/></div>
    	<div class="">修改人：           <fm:input path="modifiedby"/><br/></div>
    	<br/>
    	<input type="submit" value="保存"/>
    	<input type="reset" value="返回"/>
    </fm:form>
     </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/itripCommentadd.js"></script>
 --%>