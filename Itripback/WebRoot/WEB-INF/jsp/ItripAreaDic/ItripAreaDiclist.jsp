<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>区域管理页面</span>
        </div>
        <div class="search">
        	<form method="get" action="${pageContext.request.contextPath }/admin/ItripAreaDic/ItripAreaDic.do" method="post">
				<input name="method" value="query" type="hidden">
				
				<span>区域名称：</span>
				<input name="queryProName" type="text" value="${queryProName }">
				
				<input value="查 询" type="submit" id="searchbutton">
				<a href="${pageContext.request.contextPath }/admin/ItripAreaDic/ItripAreaDicadd.do">添加区域</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="itripAreaDicTable" cellpadding="0" cellspacing="0" width="auto">
            <tr class="firstTr">
                <th>编号</th>
                <th>区域名称</th>
                <th>区域编号</th>
                <th>父级区域ID</th>
                <th>是否激活</th>
                <th>是否是商圈</th>
                <th>是否是热门城市</th>
                <th>区域级别 </th>
                <th>是否在国内</th>
                <th>区域名称拼音</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>修改时间</th>
                <th>修改人</th>
                <th width="10%">操作</th>
            </tr>
            <c:forEach var="itripAreaDic" items="${itripAreaDicList }" varStatus="status">
				<tr>
				<%-- ${itripAreaDic.id } --%>
					<td>
					<span>${itripAreaDic.id }</span>
					</td>
					<td>
					<span>${itripAreaDic.name }</span>
					</td>
					<td>
					<span>${itripAreaDic.areano }</span>
					</td>
					<td>
					<span>${itripAreaDic.parent }</span>
					</td>
					<td>
					<span>${itripAreaDic.isactivated }</span>
					</td>
					<td>
					<span>${itripAreaDic.istradingarea }</span>
					</td>
					<td>
					<span>${itripAreaDic.ishot }</span>
					</td>
					<td>
					<span>${itripAreaDic.level }</span>
					</td>
					<td>
					<span>${itripAreaDic.ischina }</span>
					</td>
					<td>
					<span>${itripAreaDic.pinyin }</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${itripAreaDic.creationdate}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</span>
					</td>
					<td>
					<span>${itripAreaDic.createdby }</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${itripAreaDic.modifydate}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</span>
					</td>
					<td>
					<span>${itripAreaDic.modifiedby }</span>
					</td>
					<td>
					<span><a class="viewitripAreaDic" href="javascript:;" proid=${itripAreaDic.id } proname=${itripAreaDic.name }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyitripAreaDic" href="javascript:;" proid=${itripAreaDic.id } proname=${itripAreaDic.name }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteitripAreaDic" href="javascript:;" proid=${itripAreaDic.id } proname=${itripAreaDic.name }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
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
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/statics/js/itripAreaDiclist.js"></script>
