<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>区域管理页面 >> 区域添加页面</span>
        </div>
        <div class="itripAreaDicAdd">
           <%-- <form id="itripAreaDicForm" name="itripAreaDicForm" method="post" action="${pageContext.request.contextPath }/jsp/itripAreaDic.do">
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
                <div class="itripAreaDicAddBtn">
                    <input type="button" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form> --%>
            
        <fm:form method="post" modelAttribute="itripAreaDic">
    	<div class="">编号：        <fm:input path="id"/>   <br/></div>
    	<div class="">区域名称：        <fm:input path="name"/>   <br/></div>
    	<div class="">区域编号：	  	 <fm:input path="areano"/><br/></div>
    	<div class="">父级区域ID：	 <fm:input path="parent"/>   <br/></div>
    	<div class="">是否激活：           <fm:input path="isactivated"/><br/></div>
    	<div class="">是否是商圈：                   <fm:input path="istradingarea"/><br/></div>
    	<div class="">是否是热门城市：                   <fm:input path="ishot"/><br/></div>
    	<div class="">区域级别 (0: 国家级 1: 省 级 2: 市级 3: 县/区)：           <fm:input path="level"/><br/></div>
    	<div class="">是否在国内(1: 国内 2：国外)：                   <fm:input path="ischina"/><br/></div>
    	<div class="">区域名称拼音：                   <fm:input path="pinyin"/><br/></div>
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
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/itripAreaDicadd.js"></script>
 --%>