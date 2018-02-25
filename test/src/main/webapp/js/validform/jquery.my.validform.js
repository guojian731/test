/*  通用表单验证方法
 	<VFRules target="name" rule=["*","*[6-16]"], msg=["用户名不能为空!","用户名长度为6-16"] />
	{target:"name", rule:["*","*6-16"], msg:["用户名不能为空!","用户名长度为6-16"], ajax:"", args:"", inull:true}
	inull 是否允许为空值， 作用于  rule:["!-int"]这样直接验证value，但允许为空的情况。
	Demo:
	$(".demoform").ValidForm({
		TipType:1, //可选项 1=>$(object).parent().append(),其他=>指定内容，默认为1，也可以传入一个function函数，自定义提示信息的显示方式
		TipSweep:true,//可选项 true | false ，为true时提示信息将只会在表单提交时触发显示，各表单元素blur时不会被触发显示;
		ValidMode : true,  // 可选项 true | false , 为true表示 按顺序进行验证时遇到验证失败就立即停止其他未验证的项
		RuleConfig:[],
		SubmitCallBack:null, //设置 验证完成（全部通过）后回调函数  function($vform){ return true;}
		AjaxPost:true, //使用ajax方式提交表单数据，默认false，提交地址就是action指定地址;
		rules:{//传入自定义datatype类型，可以是正则，也可以是函数（函数内会传入参数）;
			"*6-20": /^[^\s]{6,20}$/,
			"s2-4" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,4}$/,
			"username":function(vfval,obj,obj1){  
				//vfval 当前验证值 如果是checkbox 则 val,val2,val3..
				//obj 当前验证的jQuery对象  如果是checkbox、radio 多个
				//obj1  只有当前验证为checkbox、radio 有值，    当前验证对象的：checked对象
				var reg1=/^[\w\.]{4,16}$/,
					reg2=/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,8}$/;
				
				if(reg1.test(gets)){return true;}
				if(reg2.test(gets)){return true;}
				return false;
			}
		}
	});

	注意 AjaxPost 这个参数还未使用，待完善
*/

/* 匿名函数 */
(function($){
	var posting = false; //防止表单按钮双击提交两次;
	var lastfocus = null;// value = submit, other
	var errorObj = null, msgObj = null, isMsgHide = true, validstatus = {},
	VFConfig = {
		AjaxXHR : null,
		AjaxTimeOut : 5000,
		AjaxDataType : 'json'
	},
	VFSettings = {
		TipType: 0,  //0 ,1 
 		TipSweep:true, //可选项 true | false ，为false时提示信息将只会在表单提交时触发显示，各表单元素blur时不会被触发显示;
		ValidMode:false, // 可选项 true | false , 为true表示 按顺序进行验证时遇到验证失败就立即停止其他未验证的项
		RuleConfig:[],
		SubmitCallBack: null, //设置 验证完成（全部通过）后回调函数($vfForm)   AjaxPost = true  SubmitCallBack(jdata)
        AjaxPost:false
	},
	VFRules = {
		"*":/.+/,
		"*6-16":/^.{6,16}$/,
		"z":/^[\da-zA-Z_]+$/,
		"n":/^\d+$/,
		"s":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/m,
		"s6-18":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,18}$/,
		"+int":/^[0-9]*[1-9][0-9]*$/,
		"-int":/^-[0-9]*[1-9][0-9]*$/,
		"int":/^-?\d+$/,
		"!-int":/^\d+$/,
		"!+int":/^((-\d+)|(0+))$/,
		"float":/^(-?\d+)(\.\d+)?$/, 
		"+float":/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, //正浮点数 
		"-float":/^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/,  //负浮点数
		"!+float":/^((-\d+(\.\d+)?)|(0+(\.0+)?))$/, //非正浮点数（负浮点数 + 0）   
		"!-float":/^\d+(\.\d+)?$/, //非负浮点数（正浮点数 + 0） 
		"p":/^[0-9]{6}$/,
		"m":/^1[0-9][0-9]{9}$/,  ///^13[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$/
		"e":/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
		"idcard" :/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
		"f":/(^([+-]?)\d*\.\d+$)|^([+-]?)[1-9]\d*$/,
		"ph":/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/,//电话和座机
		"p0to100":/^(\d{1,2}(\.\d{1,3})?|100)$/,
		"ph1":/^((1[3584]\d{9}))$/,//电话
		"ph2":/^((0\d{2,3}-\d{7,8}))$/, //座机
		"email":/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/,
		"timestamp": /^(\d{2}|\d{4})(?:\-)?([0]{1}\d{1}|[1]{1}[0-2]{1})(?:\-)?([0-2]{1}\d{1}|[3]{1}[0-1]{1})(?:\s)?([0-1]{1}\d{1}|[2]{1}[0-3]{1})(?::)?([0-5]{1}\d{1})(?::)?([0-5]{1}\d{1})$/
	}, 
	VFFunc = {
		doCreateMsgBox : function($vfObject, vfStatus, BoxHtml){
			var boxid = $vfObject.attr("name").replace(/\./g,"_");
			//样式id
			var STY_ID = ",PASS,CHECKING,".indexOf(","+vfStatus+",") != -1 ? "PASS" : "WRONG";
			var msgObj = $("#poptip_"+STY_ID+"_"+boxid);
			if(msgObj.length == 0){
				var zidx = 99;
				var msgHtml = "<div target_="+boxid+" class='rc_box_"+STY_ID+"1' id='poptip_"+STY_ID+"_"+boxid
					+"' style='display: none; position: absolute; z-index: "+zidx+";'>"
					+ "<div class='rc_box_"+STY_ID+"2'>"
					+ "<div class='rc_box_"+STY_ID+"3'></div>"
					+ "</div>"
					+ "<!-- <div class='lov1'></div>"
					+ "<div class='lov2' style='z-index: "+(zidx+1)+";'></div> -->"
					+ "<div class='bov_"+STY_ID+"1' style='z-index: "+(zidx+1)+";'></div>"
					+ "<div class='bov_"+STY_ID+"2' style='z-index: "+(zidx+1)+";'></div>"
					+ "<div class='bov_"+STY_ID+"3' style='z-index: "+(zidx+1)+";'></div>"
					+ "<div class='bov_"+STY_ID+"4' style='z-index: "+(zidx+1)+";'></div>"
					+ "<div class='bov_"+STY_ID+"5' style='z-index: "+(zidx+1)+";'></div>"
					+ "<div class='bov_"+STY_ID+"6' style='z-index: "+(zidx+1)+";'></div>"
					+ "</div>";
				msgObj = $(msgHtml).appendTo("body");//提示信息框;
			}
			var left0 = $vfObject.offset().left;
			var top0 = $vfObject.offset().top;
			msgObj.find(".rc_box_"+STY_ID+"3").html(BoxHtml);
			var heigth0 = $("#poptip_"+STY_ID+"_"+boxid).outerHeight(true) + 4;//$vfObject.height();
			msgObj.css({left:left0, top: top0 - heigth0 - 4, cursor: "pointer" });
			$("div[target_='"+boxid+"']").hide();
			msgObj.show();
			var box2_h = msgObj.find(".rc_box_"+STY_ID+"2")[0].scrollHeight;//.outerHeight(true);
			msgObj.find(".bov_"+STY_ID+"1").css({top: box2_h, left : 20 });
			msgObj.find(".bov_"+STY_ID+"2").css({top: box2_h+1, left: 20+1});
			msgObj.find(".bov_"+STY_ID+"3").css({top: box2_h+2, left: 20+2});
			msgObj.find(".bov_"+STY_ID+"4").css({top: box2_h+3, left: 20+3});
			msgObj.find(".bov_"+STY_ID+"5").css({top: box2_h+4, left: 20+4});
			msgObj.find(".bov_"+STY_ID+"6").css({top: box2_h+5, left: 20+5});
			msgObj.unbind("click").click(function(){
				$(this).hide();
				return false;
			});
			if(vfStatus == 'PASS'){
				if(posting){ //正在提交中，通过的项 就不显示了。
					msgObj.hide();
				}else{ //其他情况，blur验证时候
					setTimeout(function(){ msgObj.hide(); },1000);
				}
			}
		},
		doCheckRulesAjax : function($vfForm,$vfObject,vfRule){
			if(VFConfig.AjaxXHR){
				VFConfig.AjaxXHR.abort();
			}
			var ajaxUrl = vfRule["ajax"];
			var vfArgs = vfRule["args"];
			var objval = $vfObject.val();
			if(typeof(vfArgs) == 'function'){
				vfArgs = vfArgs();
				if(typeof(vfArgs) != "string"){
					return;
				}
			}
			var ajaxArgs = $vfObject.attr("name") + "=" + objval; 
			ajaxArgs = ajaxArgs + "&" + vfArgs;
			if(ajaxUrl){
				VFConfig.AjaxXHR = $.ajax({
					url : ajaxUrl,
					data : ajaxArgs,
					type : 'post',
					timeout :  VFConfig.AjaxTimeOut,
					dataType : VFConfig.AjaxDataType,
					beforeSend : function(){
						VFFunc.doShowMsg($vfObject, "CHECKING", "正在验证中...");
					},
					success : function(data){
						if(data.result == "true"){
							 $vfObject.attr("vfAjaxResult","true");
							 $vfObject.attr("vfAjaxValue",objval);
							 VFFunc.doShowMsg($vfObject, "PASS", data.rdata ? data.rdata : "验证通过!");
							 validstatus[vfRule.target] = true;//验证成功
							 if(lastfocus == "submit"){
								 var ispost = false;
								 $.each(validstatus,function(k,v){
									 ispost = true; 
									 if(!v){
										ispost = false;
										return false;
									 } 
								 });
								 if(ispost){
									 $vfForm.submit(); //再次提交
								 }
							 }
						}else{
							 $vfObject.attr("vfAjaxResult","false");
							 $vfObject.attr("vfAjaxValue",objval);
							 VFFunc.doShowMsg($vfObject, "WRONG", data.rdata ? data.rdata : "验证失败!");
							 validstatus[vfRule.target] = false;//验证失败
						}
					},
					complete : function(){},
					error : function(){
						$vfObject.attr("vfAjaxResult","false");
						$vfObject.attr("vfAjaxValue",objval);
						VFFunc.doShowMsg($vfObject, "WRONG", "请求异常!");
					}
				});
			}else{
				alert("ValidForm Exception 'VFRules' Object not found Attr 'ajax' vaule!");
				return;
			}
		},
		doCheckRules : function($vfObject,vfRules){
			var vfRule = vfRules["rule"]; 
			var vfMsg = vfRules['msg'];
			var vfNull = vfRules['inull'];
			if(!(vfRule instanceof Array) || vfRule.length <= 0){ return true; }
			var vfVal = "",vfTagName = $vfObject[0].tagName.toUpperCase();
			var $vfObject0 = null;
			var $vfObject1 = null;
			if(vfTagName == 'INPUT'){
				var vfType = $vfObject.attr("type").toUpperCase();
				if(vfType == 'CHECKBOX' || vfType == 'RADIO'){
					$vfObject0 = $vfObject.parents("form").find("input[name='"+$vfObject.attr("name")+"']");
					$vfObject1 = $vfObject0.filter(":checked");
					if(vfType == 'RADIO'){
						vfVal = $vfObject1.val();
					}else{
						vfVal = '';
						$.each($vfObject1,function(){
							vfVal += vfVal == '' ? $vfObject1.val() : ','+$vfObject1.val();
						});
					}
				}else{
					vfVal = $vfObject.val();
				}
			}else if(vfTagName == 'SELECT'){
				vfVal = $vfObject.val();
			}else{
				vfVal = $vfObject.val();
			}
			vfVal = $.trim(vfVal);  
			var isAllPass = false;
			var vfMessage = "";
			$.each(vfRule,function(k,item){
				var isPass = false;
				if(typeof(VFRules[item])!='undefined'){
					if(vfNull && (!vfVal || vfVal == "")){
						isPass = true;
					}else{
						if($.isFunction(VFRules[item])){
							isPass = (VFRules[item])(vfVal, $vfObject0 == null ? $vfObject : $vfObject0, $vfObject1);
						}else{
							isPass = (VFRules[item]).test(vfVal);
						}
					}
				}else{
					isPass = false;
					if(typeof(item) == 'string' && $.trim(item)!='' && item.length>4 
						&& ",*,s,n,z,".indexOf(","+item.charAt(0)+",")!=-1 
						&& (item.charAt(1) == '[')
						&& (item.charAt(item.length - 1) == ']')){
						var find = new RegExp("\\[[\\d\\-]*\\]").exec(item);
						if(find){
							find = find[0].replace("-",",").replace("[","").replace("]","");
							var reg = null;
							switch (item.charAt(0)) {
							case '*':
								reg = new RegExp("^.{"+find+"}$");
								break;
							case 's':
								reg = new RegExp("^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{"+find+"}$");
								break;
							case 'n':
								reg = new RegExp("^\\d{"+find+"}$");
								break;
							case 'z':
								reg = new RegExp("^[\\da-zA-Z_]{"+find+"}$");
								break;
							default:
								break;
							}
							if(reg!=null){
								isPass = reg.test(vfVal);
							}
						}
					}
				}
				isAllPass = !isPass ? false : true;
				if(!isPass){
					if(!vfMsg[k]){
						vfMessage =  "验证失败!";
					}else{
						vfMessage = vfMsg[k];
					}
					return false;
				}
			});
			VFFunc.doShowMsg($vfObject, (isAllPass ? "PASS" : "WRONG"), vfMessage);
			return isAllPass;
		},
		doShowMsg : function($vfObject,vfStatus,vfMessage){
			var DEF_MSG = {'CHECKING':"正在验证...", 'PASS':"通过验证!", 'WRONG':"验证失败!" };
			vfMessage = vfMessage && $.trim(vfMessage) != "" ? vfMessage : DEF_MSG[vfStatus];
			if(VFSettings.TipType == 0){
				var $vfMsg = $vfObject.siblings(".vf_msg");
				if($vfMsg.length == 0){
					$vfMsg = $("<span class='vf_msg' style='margin-left:0px;'></span>");
				}
				if(vfStatus == 'CHECKING'){
					$vfMsg.removeClass("vf_right vf_wrong").addClass("vf_msg vf_loading");//checking;
				}else if(vfStatus == 'PASS'){
					$vfMsg.removeClass("vf_wrong vf_loading").addClass("vf_msg vf_right");//passed;
				}else if(vfStatus == 'WRONG'){
					$vfMsg.removeClass("vf_right vf_loading").addClass("vf_msg vf_wrong");//wrong;
				}else{
					$vfMsg.removeClass("vf_right vf_wrong vf_loading").addClass("vf_msg");//for ignore;
				}
				$vfMsg.text(vfMessage);
				VFFunc.doCreateMsgBox($vfObject, vfStatus, $vfMsg.prop("outerHTML"));
			}else if(VFSettings.TipType == 1){
				var $vfMsg = $vfObject.siblings(".vf_msg");
				if($vfMsg.length == 0){
					$vfMsg = $("<span class='vf_msg'></span>");
					$vfObject.parent().append($vfMsg);
				}
				if(vfStatus == 'CHECKING'){
					$vfMsg.removeClass("vf_right vf_wrong").addClass("vf_msg vf_loading");//checking;
				}else if(vfStatus == 'PASS'){
					$vfMsg.removeClass("vf_wrong vf_loading").addClass("vf_msg vf_right");//passed;
				}else if(vfStatus == 'WRONG'){
					$vfMsg.removeClass("vf_right vf_loading").addClass("vf_msg vf_wrong");//wrong;
				}else{
					$vfMsg.removeClass("vf_right vf_wrong vf_loading").addClass("vf_msg");//for ignore;
				}
				$vfMsg.text(vfMessage);
			}
		},
		doGetTarget : function($vfForm,vfRule){
			var vfTargetAttr = vfRule["target"];
			if($.trim(vfTargetAttr)==''){return null;};
			var vfTargets = null;
			var arrys = vfTargetAttr.split(",");
			$.each(arrys,function(k,item){
				vfTargets = vfTargets == null ? $vfForm.find("[name='"+item+"']") : vfTargets.add("[name='"+item+"']");
			});
			return vfTargets;
		},
		doSubmit : function($vfForm,vfRuleConfig){
			validstatus = {}; 
			var isAllPass = true;
			$.each(vfRuleConfig,function(){
				var vfRule = this;
				var $vfTargets = VFFunc.doGetTarget($vfForm, vfRule);
				if($vfTargets == null){
					return false;
				}
				var vfFlag = true;
				$.each($vfTargets,function(k,item){
					var vf = false;
					$vfObject = $(this);
					var isAjax = vfRule["ajax"];
					if(isAjax){
						var isvaj = true;
						if(vfRule["rule"]){
							isvaj = VFFunc.doCheckRules($(this),vfRule);
							vf = isvaj;
						}
						if(isvaj){
							var vfAjaxResult = $vfObject.attr("vfAjaxResult");
							var vfAjaxValue = $vfObject.attr("vfAjaxValue");
							if(vfAjaxValue == $vfObject.val() && vfAjaxResult && vfAjaxResult=='true'){
								vf = true;
								VFFunc.doShowMsg($(this), "PASS", "验证通过!");
							}else{
								vf = false;
								VFFunc.doCheckRulesAjax($vfForm, $vfObject, vfRule);
							}
						}
					}else{
						vf = VFFunc.doCheckRules($(this),vfRule);
					}
					if(!vf){ //本次验证失败
						vfFlag = false;
						if(VFSettings.ValidMode)
							return false;
					}
				});
				if(!vfFlag){ //本次$vfTargets 验证失败
					isAllPass = false;
					if(VFSettings.ValidMode)
							return false;
				}
				validstatus[vfRule.target] = vfFlag; //记录表单submit  各验证状态
			});
			return isAllPass;
		}
	};
	
	$.fn.ValidForm = function(settings){
		if(typeof(settings) == 'object'){
			VFSettings = $.extend({},VFSettings,settings);
		}
		if(settings && typeof(settings.rules) == 'object'){
			VFRules = $.extend({},VFRules,settings.rules);
		}
		var vfRuleConfig = VFSettings.RuleConfig;
		this.each(function(){
			var $vfForm = $(this);
			var $vfRuleArrys = $vfForm.find("VFRules");
			if($vfRuleArrys && $vfRuleArrys.length > 0){
				$.each($vfRuleArrys, function(){
					var target_ = $(this).attr("target");
					var rule_ = $(this).attr("rule");
					var msg_ = $(this).attr("msg");
					var ajax_ = $(this).attr("ajax");
					var args_ = $(this).attr("args");
					var inull_ = $(this).attr("inull");
					var trule = {
							target:target_ , 
							rule:eval(rule_),
							msg:eval(msg_)
							};
					if(ajax_){
						trule['ajax'] = ajax_;
					}
					if(args_){
						trule['args'] = args_;
					}
					if(inull_){
						trule['ajax'] = (inull_ == "true" || inull_ == "1") ? true : false;
					}
					vfRuleConfig.push(trule);
					VFSettings.RuleConfig.push(trule);
				});
			}
			if(VFSettings.TipSweep){//blur时是否被触发显示
				validstatus = {};
				$.each(vfRuleConfig,function(){
					var vfRule = this;
					//绑定blur事件;
					var $vfTargets = VFFunc.doGetTarget($vfForm, vfRule);
					if($vfTargets == null){return false;};
					$vfTargets.blur(function(){
						var isAjax = vfRule["ajax"];
						if(isAjax){
							var isvaj = true;
							if(vfRule["rule"]){
								isvaj = VFFunc.doCheckRules($(this),vfRule);
							}
							if(isvaj){
								var vfAjaxResult = $(this).attr("vfAjaxResult");
								var vfAjaxValue = $(this).attr("vfAjaxValue");
								if(vfAjaxValue == $(this).val() && vfAjaxResult && vfAjaxResult=='true'){
									//已验证通过
									VFFunc.doShowMsg($(this), "PASS", "验证通过!");
								}else{
									VFFunc.doCheckRulesAjax($vfForm, $(this), vfRule);
								}
							}
						}else{
							VFFunc.doCheckRules($(this),vfRule);
						}
						lastfocus = "other";
					});
					validstatus[vfRule.target] = false;
				});
			}
			if(!VFSettings.AjaxPost){
				$vfForm.submit(function(){
					if(posting)
						return false;
					posting = true; //标记正在提交中, 防止表单按钮双击提交两次
					var vResult = VFFunc.doSubmit($vfForm,vfRuleConfig);
					lastfocus = "submit";
					if(!vResult){
						posting = false;
						return false;
					}
					if(VFSettings.SubmitCallBack && $.isFunction(VFSettings.SubmitCallBack)){
						posting = false;
						return VFSettings.SubmitCallBack($vfForm);
					}
					posting = false;
					return vResult;
				});
			}else{
				$vfForm.submit(function(){
					if(posting)
						return false;
					posting = true; //标记正在提交中, 防止表单按钮双击提交两次
					var vResult = VFFunc.doSubmit($vfForm,vfRuleConfig);
					if(!vResult){
						posting = false;
						return false;
					}
					
					var ajurl = $vfForm.attr("action");
					var ajargs = $vfForm.serialize();
					var ajload = null;
					$.ajax({
						url : ajurl,
						data : ajargs,
						type : 'post',
						cache : false,
						timeout : 5000,
						dataType : 'json',
						beforeSend : function(){
							ajload = layer.load("提交中，请稍等．．．", 0);
						},
						success : function(jdata){
							layer.close(ajload); //关闭提示
							posting = false;
							if(VFSettings.SubmitCallBack && $.isFunction(VFSettings.SubmitCallBack)){
								VFSettings.SubmitCallBack(jdata);
							}
						},
						error : function(XMLHttpRequest, textStatus, errorThrown){
							switch (XMLHttpRequest.status) {
								case 404: // Not Found
									alert("XmlHttpRequest status: [404] \nThe requested URL was not found on this server.");
									break;
								case 500:
									alert("XmlHttpRequest status: [500] Service Unavailable");
									break;
								case 400:
									alert("XmlHttpRequest status: [400] Bad Request");
									break;
								case 503: // Service Unavailable
									alert("XmlHttpRequest status: [503] Service Unavailable");
									break;
								default:
									break;
							}
							posting = false;
						}
					});
					return false;
				});
			}
		});
	};
	
})(jQuery);