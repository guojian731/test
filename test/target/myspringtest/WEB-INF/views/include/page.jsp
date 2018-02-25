<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="fenye">
	<div class="pagev">
		<div class="pag_span">
			<span style="position: relative; top: 3px;">共有  ${rpage.count} 条记录，每页  ${rpage.perNum} 条，当前页 ${rpage.currPage}&nbsp;/&nbsp;${rpage.totalPage} 页</span> 
			<span>
				<c:if test="${rpage.currPage==1}">
					<a href="javascript:void(0);" title="首页" style="color: gray;">首页</a>
				</c:if>
				<c:if test="${rpage.currPage!=1}">
					<a href="javascript:void(0);"  title="首页" onclick="GoPage(1)">首页</a>
				</c:if>
			</span>
			<span>
				<c:if test="${rpage.currPage==1}">
				<a href="javascript:void(0);" title="上一页" style="color: gray;">上一页</a>
				</c:if>
				<c:if test="${rpage.currPage!=1}">
				<a href="javascript:void(0);" onclick="GoPage(${rpage.currPage-1})" title="上一页">上一页</a>
				</c:if>
			</span>
			<span>
				<c:if test="${rpage.currPage==rpage.totalPage}">
				<a href="javascript:void(0);" title="下一页" style="color: gray;">下一页</a>
				</c:if>
				<c:if test="${rpage.currPage!=rpage.totalPage}">
				<a href="javascript:void(0);" onclick="GoPage(${rpage.currPage+1})" title="下一页">下一页</a>
				</c:if>
			</span>
			<span>
				<c:if test="${rpage.currPage==rpage.totalPage}">
				<a href="javascript:void(0);" title="末页" style="color: gray;">末页</a>
				</c:if>
				<c:if test="${rpage.currPage!=rpage.totalPage}">
				<a href="javascript:void(0);" onclick="GoPage(${rpage.totalPage})" title="末页">末页</a>
				</c:if>
			</span> 
			<span>跳转到第&nbsp;<input class="fy-input" type="text" id="go_page"/>页
			</span> <span><a href="javascript:void(0);" onclick="javascript: GoPage($('#go_page').val(),$('#go_page')[0]);">跳转</a></span>

		</div>
	</div>
</div>
<input id='cpage_' type='hidden' name='cpage' value='${rpage.currPage}' />
<input id='pernum_' type='hidden' name='pernum' value='${rpage.perNum}' />
<input id='tpage_' type='hidden' name='cpage' value='${rpage.totalPage}' />
