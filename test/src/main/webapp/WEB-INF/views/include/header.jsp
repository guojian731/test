<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/JSPTools.tld" prefix="my"%>
<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
	
	String path = request.getContextPath();
	request.setAttribute("path",path);
	
	String tip = (String)request.getSession(true).getAttribute("tip");
	request.getSession(true).removeAttribute("tip");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta HTTP-EQUIV="pragma" CONTENT="no-cache" />
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate" />
<meta HTTP-EQUIV="expires" CONTENT="0" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/header.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/extra.css">
<script src="<%=path%>/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=path%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=path%>/js/common/base64.js" type="text/javascript"></script>
<script src="<%=path%>/js/layer-v1.8.5/layer.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/laytpl-v1.1/laytpl.js" type="text/javascript"></script>
<script src="<%=path%>/js/common/header.js" type="text/javascript"></script>
<script src="<%=path%>/js/common/index.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/extra/list.js"></script>

<script type="text/javascript">

var tpop = null;

$(function(){
	var tip = "<%=tip%>";
	if(tip!="" && tip!="null"){
		var ntip = new Base64().decode(tip);
		eval("var tipjson="+ntip+";");
		if(tipjson[0] == "T_OK"){ //操作成功提示
			layer.msg('操作成功！', 2, {type:1,shade:false});
		}else if(tipjson[0]=="NO_DEL"){
			layer.msg('操作失败！此单位不可删除', 2, {type:3,shade:false});
		}else{
			layer.msg('操作失败！'+(tipjson[1] ? tipjson[1] : ""), 2, {type:3,shade:false});
		}
	}
});

/** 选择管辖海事局 */
function ChoiceMarine(url){
	var wh = ['800px', '440px'];
	var idx = url.indexOf("w_h_=");
	if(idx > -1){
		var w_h = url.substring(idx+5);
		var whs = w_h.split(",", -1);
		if(whs[0] && whs[0] != "")
			wh[0] = whs[0]+"px";
		if(whs[1] && whs[1] != "")
			wh[1] = whs[1]+"px";
	}
	$.layer({
	    type: 2,
	    shade : [0.3, '#000'],
	    fix: true,
	    title: '选择管辖海事局',
	    maxmin: false,
	    iframe: {src : url},
	    area: [wh[0] , wh[1]],
	    close: function(index){
	    }
	}); 
}

/** 退出登录操作 */
function DoLogout(url){
	layer.confirm("您确定要退出登录吗?", function(){
		window.location.href = url;
		if (window != top)
			top.location.href = window.location.href; 
	});
}

function DoDelImg(url){
	
	layer.confirm("确定要删除此图片吗?", function(){
		window.location.href = url;
		if (window != top)
			top.location.href = window.location.href; 
	});
}

</script>
</head>
<body>
	<input type="hidden" id="path_" value="<%=path%>"/>
	<input type="hidden" id="auth_" value="${M_ACTION_AUTH}"/>
	<input type="hidden" id="page_" value="${PageFlag}" />
</body>
</html>