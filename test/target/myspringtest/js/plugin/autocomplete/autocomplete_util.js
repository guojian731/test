
function BindUserAutoComp(basepath,jQElement,jQHidElement){
	jQElement.autocomplete(basepath+'/user/ajaxQuery.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		max:20,
		cacheLength:20,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
				return {
					data: row.display,
					value: row.userid,
					result: row.display
				};
			}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, row, value) {
		if(jQHidElement.length<1){
			alert("Auto Complete jQHidElement error!");
		}
		jQHidElement.val(value);
	});
}

function BindShipAutoComp(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQuery.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.zwcm+"-"+row.ywcm,
						value: row,
						result: row.zwcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}

function BindShipAutoCompMMSI(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryMMSI.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}

function BindShipAutoCompcalSign(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryCalSign.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}
function BindShipAutoCompImo(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryImo.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}
		 
function BindShipAutoCompVesselMark(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryVesselMark.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}

function BindDeptAutoComp(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/dept/ajaxQuery.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.id+"-"+row.deptName,
						value: row,
						result: row.deptName
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(callbackFunc && $.isFunction(callbackFunc)){
			callbackFunc(value.id);
		}
	});
}

function BindShipAutoCompCN(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryMMSI.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.zwcm+"-"+row.ywcm,
						value: row,
						result: row.zwcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value);
			}
		}
	});
}

function BindShipAutoCompEN(basepath,jQElement,callbackFunc){
	jQElement.autocomplete(basepath+'/ship/ajaxQuery2.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm+"-"+row.zwcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+row.vid,function(jdata){
				if(jdata.error == 0){
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value,$(this));
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value,$(this));
			}
		}
	});
}

function BindShipLocAutoComp(basepath,jQElement){
	jQElement.autocomplete(basepath+'/shipJiankong/ajaxQuery.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		showpage:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.display,
						value: row.locid,
						result: row.display
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, row, value) {
		var thisid = $(this).attr("id");
		var thisobj = $(this);
		$("#"+thisid+"_id").val(value);
		$.post(
			basepath+"/shiploc/ajax_get.htm",
			"locid="+value,
			function(jdata){
				if(jdata.error!=0){alert(jdata.result);return;}
				var pobj = thisobj.parent().parent();
				var width = pobj.find("td:eq(5)").text();//船宽
				var draught = pobj.find("td:eq(6)").text();//吃水
				var zaizhong = pobj.find("td:eq(8)").text();//载重
				if(jdata.data.locType == "锚地"){
					if(zaizhong != "" && jdata.data.zaizhong && jdata.data.zaizhong<zaizhong){
						alert("锚地限定载重吨为"+jdata.data.zaizhong+",船舶载重吨超出!");
					}
				}else if(jdata.data.locType == "码头"){
					if(zaizhong != "" && jdata.data.zaizhong && jdata.data.zaizhong<zaizhong){
						alert("码头限定载重吨为"+jdata.data.zaizhong+",船舶载重吨超出!");
					}
					if(draught != "" && jdata.data.shipDraught && jdata.data.shipDraught<draught){
						alert("码头限定吃水为"+jdata.data.shipDraught+",船舶吃水超出!");
					}
				}else if(jdata.data.locType == "航道"){
					if(width != "" && jdata.data.shipWidth && jdata.data.shipWidth<width){
						alert("航道限定船宽为"+jdata.data.shipWidth+",船舶船宽超出!");
					}
					if(draught != "" && jdata.data.shipDraught && jdata.data.shipDraught<draught){
						alert("航道限定吃水为"+jdata.data.shipDraught+",船舶吃水超出!");
					}
				}
			},
			'json'
		);
		if($("#"+thisid+"_id").length<1){
			alert("Auto Complete jQHidElement error!");
		}
		/*if(callbackFunc && $.isFunction(callbackFunc)){
			callbackFunc(value,jQElement);
		}*/
	});
}


function BindShipAutoCompCalsign(basepath,jQElement,jQHidElement,callbackFunc){
	jQElement.autocomplete(basepath+'/cbSysShip/ajaxQueryCalSign.htm', {
		minChars: 1,
		width: 152,
		highlight:false,
		dataType: "json",
		cacheLength:false,
		parse: function(data) {
			return (data && data.length>0) ? $.map(data, function(row) {
					return {
						data: row.ywcm,
						value: row,
						result: row.ywcm
					};
				}) : [];
		},
		formatItem: function(row, i, n) {      
		     return row;            
		}
	}).result(function(event, data, value) {
		if(value.vid && value.vid != ""){
			$.post(basepath+"/ship/ws_ship.htm","vid="+value.vid,function(jdata){
				if(jdata.error == 0){
					//jQHidElement.val(jdata.data[0]);
					jQElement.val(jdata.data[1]);
					if(callbackFunc && $.isFunction(callbackFunc)){
						callbackFunc(value.shipid);
					}
				} else {
					jQElement.val("");
					jQHidElement.val("");
					$.dialog.tips("获取船舶数据失败!",3,"fail.png");
				}
			});
		}else{
			if(callbackFunc && $.isFunction(callbackFunc)){
				callbackFunc(value.shipid);
			}
		}
	});
}



$(function(){
	initjcstyle();
});

function initjcstyle(){
	var jcname = $("#mShipname");
	var jename = $("#ship_ename");
	initjcstyle2(jcname, jename);
}

function initjcstyle2(jcname, jename){
	if(jcname.length > 0){
		var v = jcname.val();
		if($.trim(v) == ""){
			jcname[0].value = '中文船名';
			jcname[0].style.color = "#ccc";
		}else{
			jcname[0].style.color = '';
		}
		jcname.unbind("click").bind("click",function(){
			if(this.value == '中文船名'){
				this.value = '';
				this.style.color = '';
			}
		}).unbind("blur").bind("blur",function(){
			if(this.value == ''){
				this.value = '中文船名';
				this.style.color = "#ccc";
			}
		});
	}
	if(jename.length > 0){
		var v = jename.val();
		if($.trim(v) == ""){
			jename[0].value = '英文船名';
			jename[0].style.color = "#ccc";
		}else{
			jename[0].style.color = '';
		}
		jename.unbind("click").bind("click",function(){
			if(this.value == '英文船名'){
				this.value = '';
				this.style.color = '';
			}
		}).unbind("blur").bind("blur",function(){
			if(this.value == ''){
				this.value = '英文船名';
				this.style.color = "#ccc";
			}
		});
	}
}