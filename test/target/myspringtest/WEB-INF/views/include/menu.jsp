<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="header">
	<div class="h_rbg">
		<h1 class="logo L"></h1>
		<div class="header_nav R">
			<ul>
				<li><a href="javascript:void(0);" onclick="DoLogout('${path}/system/logout.htm');">退出</a></li>
				<li>角色：${LoginUser.ROLE_NAME}</li>
				<li>您好：${LoginUser.UNAME}</li>
				<li><a onClick="window.location='${path}/system/go_help.htm';" href="#">相关服务</a></li>
			</ul>
		</div>
	</div>
</div>
<!--nav open-->
<div class="nav">
	<ul class="nav_ul">
	<c:set var="subnav" value=""></c:set>
	<c:if test = "${empty curr_menu}">
		<c:set var="curr_menu" value="1"></c:set>
	</c:if>
	<!-- menuItem 在Constan里的常量更改 -->
	<c:forEach items="${sessionScope.menuItem['0']}" var="menu" varStatus="vsts">
		<c:choose>
			<c:when test="${menu.murl == '#'}">
				<li data-nav="index${menu.id}" 
					class="mli<c:if test = "${curr_menu eq menu.id }"> current</c:if>"
				>
				<c:if test="${menu.mname == '操作告警'}">
					<a href="javascript:void(0);"  >${menu.mname}[${WarnCount}]</a>
				</c:if>
				<c:if test="${menu.mname != '操作告警'}">
					<a href="javascript:void(0);" >${menu.mname}</a>
				</c:if>
				</li>
			</c:when>
			<c:otherwise>
			<li data-nav="index${menu.id}"
				class="<c:if test = "${curr_menu eq menu.id }">current</c:if>"
			>
				<!-- 将当菜单id添加到菜单url后，跳转后使该菜单为当前点击菜单。 -->
				<a href="${path}/${menu.murl}
					<c:choose>
						<c:when test = "${fn:contains(menu.murl, '?')}">
							&
						</c:when>
						<c:otherwise>
							?
						</c:otherwise>
					</c:choose>
					curr_menu=${menu.id}
				" >
				${menu.mname}</a></li>
			</c:otherwise>
		</c:choose>
		<c:set var="subnav" value="${subnav},${menu.id}"></c:set>
	</c:forEach>
	</ul>
	<c:forEach items="${fn:split(subnav,',')}" var="key" varStatus="vsts">
		<div class="subnav" data-view="index${key}">
			<ul>
				<c:forEach items="${sessionScope.menuItem[key]}" var="m2" varStatus="vsts">
					<li>
						<!-- 将当菜单id添加到菜单url后，跳转后使该菜单为当前点击菜单。 -->
						<a href="${path}/${m2.murl}
							<c:choose>
								<c:when test = "${fn:contains(m2.murl, '?')}">
									&
								</c:when>
								<c:otherwise>
									?
								</c:otherwise>
							</c:choose>
							curr_menu=${key}
						">${m2.mname}</a>
						
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:forEach>
</div>