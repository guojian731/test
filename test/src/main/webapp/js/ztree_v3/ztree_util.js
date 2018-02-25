/**
 * 
 */

var path = $("#path_").val();

/** 单位添加/编辑 所属父级单位 */
var SET_1 = {
	check : {
		enable : true,
		chkStyle : "radio",
		radioType : "all"
	},
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey:"pid"
		}
	},
	ajax: {
		url : path+"/ztree/aj_get.htm",
		args : ""
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
//			var check = (treeNode && !treeNode.isParent);
//			if (!check) alert("只能选择城市...");
//			return check;
			return true;
		},
		onClick: function(e, treeId, treeNode) {
			
		}
	}
};
var SET_2 = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_get_dept.htm",
			args : ""
		}
	};

var SET_3 = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_ztree3.htm",
			args : ""
		}
	};



var SET_4 = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_ztree4.htm",
			args : ""
		}
	};

var DDCLOTH_CREATE = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_user_list.htm",
			args : ""
		}
};

var DDCLOTH_LIST = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_ddcloth_list.htm",
			args : ""
		}
};
var DUBGET_LIST = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_clothDubget_list.htm",
			args : ""
		}
};
var ALL_MARINE3_LIST = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_all_marine3_list.htm",
			args : ""
		}
};
 
var ALL_MARINE_BY_USER = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_getMarine_list.htm",
			args : ""
		}
};
var DDCLOTH_MULIT_CREATE = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_dd_mulit_create.htm",
			args : ""
		}
};
var MARINE_BJ = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_marine_bj.htm",
			args : ""
		}
};

//获取所有单位树
var ALL_MARINE = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey:"pid"
			}
		},
		ajax: {
			url : path+"/ztree/aj_all_marine.htm",
			args : ""
		}
};
var CONF_SETTING = { 
		"SET_1": SET_1, "SET_2":SET_2, "SET_3":SET_3, "SET_4":SET_4,
		"DDCLOTH_CREATE": DDCLOTH_CREATE,
		"DDCLOTH_LIST" : DDCLOTH_LIST,
		"DDCLOTH_MULIT_CREATE" : DDCLOTH_MULIT_CREATE,
		"DUBGET_LIST":DUBGET_LIST,
		"ALL_MARINE3_LIST":ALL_MARINE3_LIST,
		"ALL_MARINE_BY_USER":ALL_MARINE_BY_USER,
		"MARINE_BJ":MARINE_BJ,
		"ALL_MARINE":ALL_MARINE
};

function InitZTree(itemId, setting, appset, jsonData){
	var jQitem = $(itemId);
	if(jQitem.length <= 0){
		return;
	}
	if(typeof(setting) == 'string'){
		setting = CONF_SETTING[setting];
	}
	setting.view = {
		showIcon: false,
		txtSelectedEnable: true
	};
	if(!appset.callback){
		appset.callback ={};
	}
	appset.callback.onClick = function(event, treeId, treeNode, clickFlag) {
		var zTree = $.fn.zTree.getZTreeObj(treeId);
		var checked_ = true;//!treeNode.checked;
		zTree.checkNode(treeNode, checked_, true, true);
		zTree.selectNode(treeNode)
	};
	setting = jQuery.extend(true, setting, appset);
	if(setting.ajax){
		$.post(setting.ajax.url,setting.ajax.args,function(jdata){
			if(jdata.result == "true"){
				$.fn.zTree.init(jQitem, setting, jdata.rdata);
			}else{
				alert("ZTree 加载错误!");
			}
		},"json");
	}else{
		$.fn.zTree.init(jQitem, setting, jsonData);
	}
	
	//hideMenu(itemId, null);
}

	if (!(evtTarget == thiz || ("#"+evtTarget.id) == itemId || $(evtTarget).parents(itemId).length>0)) {
		hideMenu(itemId, thiz);
	}

