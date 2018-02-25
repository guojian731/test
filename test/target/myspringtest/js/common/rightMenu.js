var rightClickMenu = 
	"<div id=\"right_click\" class=\"ma1\" >"+
		"<input type=\"button\" value=\"绑定船舶\" id=\"bd\" />"+
		//雷达扫描范围菜单
		"<input type=\"button\" value=\"在泊船舶\"  id=\"gozb\" />"+
		"<input type=\"button\" value=\"离泊船舶\"  id=\"golb\" />"+
		"<input type=\"button\" value=\"锚泊船舶\"  id=\"gomb\" />"+
		"<input type=\"button\" value=\"进港船舶\"  id=\"gojg\" />"+
		"<input type=\"button\" value=\"离港船舶\"  id=\"golg\" />"+
		//船舶计划综合
		"<input type=\"button\" value=\"在航船舶\"  id=\"gozh\" />"+
		
		
		"<input type=\"button\" value=\"允许上线\" id=\"sx\" />"+
		"<input type=\"button\" value=\"允许下线\" id=\"xx\" />"+
		"<input type=\"button\" value=\"允许抛锚\" id=\"pm\" />"+
		"<input type=\"button\" value=\"允许移锚\" id=\"ym\" />"+
		"<input type=\"button\" value=\"允许靠泊\" id=\"kb\" />"+
		"<input type=\"button\" value=\"允许离泊\" id=\"lb\" />"+
		"<input type=\"button\" value=\"允许港池内移泊\" id=\"yb\" />"+
		"<input type=\"button\" value=\"允许离港\" id=\"lg\" />"+
		"<input type=\"button\" value=\"重点船舶\" id=\"zd\" />"+
		"<input type=\"button\" value=\"追踪船舶\" id=\"zz\" />"+
		"<input type=\"button\" value=\"已靠好\"  id=\"kh\" />"+
		"<input type=\"button\" value=\"取消重点\" id=\"qxzd\" />"+
		
		
	"</div>";
var rootPath = $("#path_").val();//getRootPath();

var nowTime = new Date();

window.onload = function(){
	//去掉默认的contextmenu事件，否则会和右键事件同时出现。
	document.oncontextmenu = function(e){
		e.preventDefault();
	};
	//将右键菜单添加到页面中。
	$("div.main").append(rightClickMenu);
	//给当前文档添加点击事件，当点击当前页面空白处时，关闭右键菜单。
	$(document).click(function(event)
	{
		rightMenuHide();
	});
};

/**
	鼠标点击事件。左击时，没有反应，右击时，弹出菜单。菜单内容由typeArr数组决定。
*/
function onmouseClick(event, zt, typeArr, id)
{
	mouseClick(event, typeArr, "onRightClick", [id, zt]);
}

function onmouseClick(event, zt, typeArr, id, tno)
{
	mouseClick(event, typeArr, "onRightClick", [id, zt, tno]);
}

function mouseClick(event, typeArr, clickFunc, paramArr)
{
	rootPath = $("#path_").val();//重新加载路径
	rightMenuHide();
	if(event.button == 2)
	{
		//根据鼠标位置，计算右键菜单弹出位置。
		var e = event || window.event;
		var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
        var scrollY = document.documentElement.scrollTop  || document.body.scrollTop;
        var x = e.pageX || e.clientX + scrollX;
        var y = e.pageY || e.clientY + scrollY;
        
		$("#right_click").css({top: y ,left: x}).show();
		
		var func = clickFunc + "('@VAL', ";
		if(paramArr != null && paramArr.length > 0)
		{
			$.each(paramArr, function(i,val){
				func += "'" + val + "',";
			});
			
			func = func.substr(0, func.length - 1);
		}
		func += ");";
		//循环处理要显示的菜单项。
		$.each(typeArr, function(i,val){
			$("input#" + val).show();
			$("input#" + val).attr("onclick", func.replace("@VAL", val));
		});
	}
}

/**隐藏右键菜单。
*/
function rightMenuHide()
{
	$("#right_click").hide();//将菜单弹出框隐藏。
	$("div#right_click :input").hide();//将菜单选项隐藏。
}

/// 点击右键菜单选项的操作。
function onRightClick(clickName, id, zt, tno){
	rootPath = $("#path_").val();//重新加载路径
	rightMenuHide(); 
	if(clickName.indexOf("go")>=0){
		$.post(rootPath+"/cbLeiDa/saveDateByZt.htm",{tno:id,clickN:clickName,zhid:tno},
				function(data){  
			
			if(data=="T"){
				alert("操作成功！");
			}else{
				alert("操作失败！");
			}
		}) ;
	}else if(clickName=="bd"){
		if( zt=="ld"){
			DoSite(rootPath+"/cbLeiDa/bangding_view.htm?id="+id);
		}else{
			DoViewHW(rootPath+"/cbAllPart/bangding_view.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno,'','800px','500px');//跳转页面
		}
	}
	else if(clickName=="zd" || clickName=="zz" || clickName == "qxzd")
	{
		var stat = 1;
		if(clickName == "zd"){
			stat = 1;
			//添加重点船舶跟踪报告列表
			$.post(rootPath+"/cbAllPart/addorupdzhongdian.htm",{shipId: id, status: stat,zt:zt,clickName:clickName}) ;
		}
		else if(clickName == "zz")
			stat = 2;
		else if(clickName == "qxzd"){
			stat = 0;
			
			//更新重点船舶跟踪报告列表
			$.post(rootPath+"/cbAllPart/addorupdzhongdian.htm",{shipId: id, status: stat,zt:zt,clickName:clickName}) ;
		}
		alert("操作成功！");
		location.reload(true);
//			$.post(rootPath+"/cbAllPart/zhongdian.htm?shipId="+id+"&status="+stat) ;
	}
	else{
		if (clickName=="lg") {
			$.ajax({
		        type: "POST",
		        url: rootPath+"/cbShipSailing/verifylg.htm",
		        data: {"id":id,"zt":zt},
		        success: function(data){
		           if(data!="1"){
			            	layer.confirm(data, function(index)
			            	{
		            		DoViewHW(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno,'','800px','500px');//跳转页面
		            	});
					}else {
						DoViewHW(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno,'','800px','500px');//跳转页面
					}
		       }
		     });
		}else if (clickName=="lb"){
			$.ajax({
		        type: "POST",
		      //  url: rootPath+"/cbShipSailing/verifylb.htm",
		        url: rootPath+"/cbShipSailing/verifylg.htm",
		        data: {"id":id,"zt":zt},
		        success: function(data){
		         if(data!="undefined"){
		        		if(typeof(data.id)!="undefined"){
		        			 var sd = typeof(data.dept)=="undefined"?"该船滞留中！":"该船滞留中！滞留部门:"+data.dept;
		        			var cfmcon = sd+"滞留时间:"+data.detainTime+"接触时间:"+data.removeTime;
			            	layer.confirm(cfmcon, function(index)
			            	{
			            		DoSite(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno);//跳转页面
			            	});
					}else {
						DoView(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno);//跳转页面
					}
		       }
		        }
		     });
		}else if(clickName=='kb' ||clickName=='kh'||clickName=='yb') {
			DoSite(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno);//跳转页面
		}else{
			DoViewHW(rootPath+"/cbAllPart/rightClick.htm?clickName="+clickName+"&id="+id + "&zt=" + zt + "&tno=" + tno,'','800px','500px');//跳转页面
		}
	}
}

//function getRootPath(){
//	  var path=$("#path_").val();
////    //获取当前网址，如： http://localhost:8088/test/test.jsp
////    var curPath=window.document.location.href;
////    //获取主机地址之后的目录，如： test/test.jsp
////    var pathName=window.document.location.pathname;
////    var pos=curPath.indexOf(pathName);
////    //获取主机地址，如： http://localhost:8088
////    var localhostPaht=curPath.substring(0,pos);
////    //获取带"/"的项目名，如：/test
////    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
////	 return(localhostPaht+projectName);
//    return(path);
//}

