/**
 * 依赖 jquery.base64.js, layer.js
 */

$(function()
{
	/* 合理调整列表所占区域高度 */
	InitAreaHeight();
});

function InitAreaHeight()
{
	var jQdtarea = $("#dt_area");
	if (jQdtarea.height() < $(window).height() - 48 - 5)
	{
		jQdtarea.css(
		{
			height : $(window).height() - 48 - 5
		});
	}
}

var jQform = null;
var QUERY_ARGS = "";

function InitPage(jQFormStor)
{
	jQform = $(jQFormStor);
	if (jQform.length <= 0)
	{
		layer.msg("脚本错误：未找到的 JQForm选择器!  [" + jQFormStor
		        + " at list.js function InitPage]", 2,
		{
		    type : 3,
		    shade : false
		});
		return;
	}
	var PG_HTML = "<input id='cpage'  type='hidden' name='cpage'  value='" + $("#cpage_").val()  + "'/>";
	PG_HTML    += "<input id='pernum' type='hidden' name='pernum' value='" + $("#pernum_").val() + "'/>";
	jQform.append(PG_HTML);
	
	var cpage = parseInt($("#cpage_").val());
	var tpage = parseInt($("#tpage_").val());
	if (cpage > tpage)
	{
		GoPage(tpage);
	}
	
	QUERY_ARGS = jQform == null ? "" : new Base64().encode(jQform.serialize());
}

/**
 * 去某页 #缺 计算最大最小页
 * 
 * @param page
 */
function GoPage(page, domobj)
{
	page = $.trim(page + "");
	if (!(/^[1-9]\d*$/.test(page)))
	{
		if (domobj)
		{
			layer.tips('请输入正确的页码!', domobj,
			{
			    guide : 0,
			    time : 2
			});
		}
		else
		{
			layer.msg("请输入正确的页码!", 2,
			{
			    type : 3,
			    shade : false
			});
		}
		return;
	}
	var itpage = parseInt($("#tpage_").val());
	var ipage = parseInt(page);
	if (ipage > itpage)
	{
		page = itpage;
	}
	if (ipage < 1)
	{
		page = 1;
	}
	$("#cpage").val(page);
	jQform.submit();
}

/**
 * 删除操作，含提示，自动带args_参数 #DoSite #layer.min.js
 * 
 * @param url
 * @param msg
 */
function DoDel(url, msg)
{
	var cfmcon = msg ? msg : '确定要删除此项吗?';
	layer.confirm(cfmcon, function(index)
	{
		DoSite(url);
	});
}

/**
 * 弹出方式 查看操作 #layer.min.js
 * 
 * @param url
 */
function DoView(url, parentReload)
{
	DoViewHW(url, parentReload, '800px', '440px');
}

/**
 * 弹出方式 查看操作宽度,高度自己设置 #layer.min.js
 * 
 * @param url
 */
function DoViewHW(url, parentReload, width, height)
{// 马恩方 添加 parentReload 参数，当值为true时，表明该弹出框在关闭时，其父页面需要重新加载。当不传入或传入其他值时，父页面不刷新。
	// 2015年4月8日17:24:22
	var wh = [ width, height ];
	var idx = url.indexOf("w_h_=");
	if (idx > -1)
	{
		var w_h = url.substring(idx + 5);
		var whs = w_h.split(",", -1);
		if (whs[0] && whs[0] != "") wh[0] = whs[0] + "px";
		if (whs[1] && whs[1] != "") wh[1] = whs[1] + "px";
	}
	$.layer(
	{
	    type : 2,
	    shade : [ 0.3, '#000' ],
	    fix : true,
	    title : '查看',
	    maxmin : false,
	    iframe :
	    {
		    src : url
	    },
	    area : [ wh[0], wh[1] ],
	    close : function(index)
	    {
		    // 当parentReload 为true时，刷新父页面， 马恩方 2015年4月8日17:23:13
		    if (parentReload) 
		    	window.parent.location.reload();
	    }
	});
}
/**
 * 跳转到某Url，自动带args_参数
 * 
 * @param url
 */
function DoSite(url)
{
	/* 记录查询参数信息 args_ */
	var frmhtml = "<form id='frm_0_' action='" + url + "' method='post'>";
	frmhtml += "<input name='args_' type='hidden' value='" + QUERY_ARGS
	        + "'/></form>";
	$("#frm_0_").remove();
	$("body").append(frmhtml);
	$("#frm_0_").submit();
}
//弹出窗体  显示机构列表
var rootPath = getRootPath();
function getOrgList(fname){
    $.dialog({
	title: "机构信息", 
	content: "url:" + rootPath + "/cbOrg/getList.htm",
	//content: "url:<%=path%>/cbOrg/getList.htm", //如果以后不好使换成这个
	min:false,
	max:false,
	width : '1000px',
	height : '600px'
    });
}

function getShipList(){
	rootPath = $("#path_").val();
    $.dialog({
	title: "快捷船舶信息录入", 
	content: "url:" + rootPath + "/cbSysShip/to_info2.htm",
	//content: "url:<%=path%>/cbOrg/getList.htm", //如果以后不好使换成这个
	min:false,
	max:false,
	width : '1000px',
	height : '400px'
    });
}

// 关闭机构列表 并返回值
function returnCborg(){
	var api = frameElement.api, W = api.opener;
   	var radioVaule=$("input[type='radio']:checked").val();
    if (radioVaule!=null && typeof(radioVaule)!="undefined") {
       	var valArray = radioVaule.split("@#");
		//alert($("input[type='radio']:checked").val());
		//W.document.getElementById('OrgName').value=$("input[type='radio']:checked").val();
		W.document.getElementById('orgId').value=valArray[0];
		W.document.getElementById('OrgName').value=valArray[1];
		api.close();
	}else{
		layer.msg('请选择机构', 2, {type:3,shade:false});
  	   	return false;
	}
}
//弹出窗体  显示机构列表
var rootPath = getRootPath();
function getBerchList(status){
	rootPath = rootPath = $("#path_").val();
    $.dialog({
	title: "泊位信息",
	content: "url:" + rootPath + "/cbBerch/getList.htm?status="+status,
	//content: "url:<%=path%>/cbOrg/getList.htm", //如果以后不好使换成这个
	min:false,
	max:false,
	stack:true,
	zIndex:10000,
	width : '1000px',
	height : '600px'
    });
}
// 关闭机构列表 并返回值
function returnCbberch(status){
	var api = frameElement.api, W = api.opener;
   	var radioVaule=$("input[type='radio']:checked").val();
    if (radioVaule!=null && typeof(radioVaule)!="undefined") {
       	var valArray = radioVaule.split("@#");
		//alert($("input[type='radio']:checked").val());
		//W.document.getElementById('OrgName').value=$("input[type='radio']:checked").val();
		W.document.getElementById('berchID').value=valArray[0];
		W.document.getElementById('berchName').value=valArray[1];
		if (status != "undefined" ) {
			W.showShipByBoWei(valArray[0]);
		}
		api.close();
		
	}else{
		layer.msg('请选择泊位', 2, {type:3,shade:false});
  	   	return false;
	}
}

function getRootPath(){
    //获取当前网址，如： http://localhost:8088/test/test.jsp
    var curPath=window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    var pathName=window.document.location.pathname;
    var pos=curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    var localhostPaht=curPath.substring(0,pos);
    //获取带"/"的项目名，如：/test
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
