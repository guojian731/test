<%@ page contentType="text/html; charset=UTF-8"%>
<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="<%=path%>/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=path%>/js/layer-v1.8.5/layer.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引

	var tpop = null;

	$(function(){
		var tip = "${tip}";
		var url = "${url}";
		if(tip!="" && tip!="null"){
			if(tip=="CREATE_OK"){
				parent.window.location.href	= "<%=path%>"+url;
			}else if(tip=="OPT_OK"){
				parent.layer.msg('操作成功！', 1, {type:1,shade:false}, function(){
					parent.window.location.href	= "<%=path%>"+url;
				});
			}else{
				layer.msg('操作失败！', 2, {type:3,shade:false});
			}
		}
	});
</script>