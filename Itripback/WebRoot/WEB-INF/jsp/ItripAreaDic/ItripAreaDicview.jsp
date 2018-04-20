<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>区域管理页面 >> 区域信息查看</span>
        </div>
        <div class="itripAreaDicView">
            <p><strong>编号：</strong><span>${itripAreaDic.id }</span></p>
            <p><strong>区域名称：</strong><span>${itripAreaDic.name }</span></p>
            <p><strong>区域编号：</strong><span>${itripAreaDic.areano }</span></p>
            <p><strong>父级区域ID：</strong><span>${itripAreaDic.parent }</span></p>
            <p><strong>是否激活：</strong><span>${itripAreaDic.isactivated }</span></p>
            <p><strong>是否是商圈：</strong><span>${itripAreaDic.istradingarea }</span></p>
            <p><strong>是否是热门城市：</strong><span>${itripAreaDic.ishot }</span></p>
            <p><strong>区域级别 (0: 国家级 1: 省 级 2: 市级 3: 县/区)：</strong><span>${itripAreaDic.level }</span></p>
            <p><strong>是否在国内(1: 国内 2：国外)：</strong><span>${itripAreaDic.ischina }</span></p>
            <p><strong>区域名称拼音：</strong><span>${itripAreaDic.pinyin }</span></p>
            <p><strong>创建时间：</strong><span>${itripAreaDic.creationdate }</span></p>
            <p><strong>创建人：</strong><span>${itripAreaDic.createdby }</span></p>
            <p><strong>修改时间：</strong><span>${itripAreaDic.modifydate }</span></p>
            <p><strong>修改人：</strong><span>${itripAreaDic.modifiedby }</span></p>
			<div class="itripAreaDicAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/itripAreaDicview.js"></script>
