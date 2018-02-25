/*主导航选中项*/
$(function(){
	
    $(".nav>ul").children(".mli").each(function(){ 
       $(this).click(function(){
    	   $(this).addClass("current").siblings().removeClass("current");
		   var view = $(this).attr('data-nav');
		   $('.subnav[data-view=' + view+ ']').show().siblings('.subnav').hide();
		   if(view=='index0'){
			   	$('.subnav[data-view=' + view+ ']').hide().siblings('.subnav').hide();
		   }
       });
     }); 
});
/*二级导航选中项*/
$(function(){
    $(".subnav>ul").children().each(function(){ 
       $(this).click(function(){
    	   $(this).addClass("current").siblings().removeClass("current");
       });
     }); 
});

var auth = "";
/* 权限处理 */
$(function(){
	var jQauth = $("#auth_");
	var auth64 = $.trim(jQauth.val());
	if(auth64 == ""){
		return;
	}
	auth = new Base64().decode(auth64);
	if(auth == ""){
		return;
	}
    $("*[auth]").each(function(k,m){
    	var vauth = $(this).attr("auth");
    	var sauth = $(this).attr("authsame");
    	if($.trim(vauth) == ""){
	    	return false;
    	}
    	if(vauth.indexOf("&") != -1 || vauth.indexOf("|") != -1){
    		var group = vauth.match(/\[#[\da-zA-Z_]*#\]/g); //匹配//"sdf[#k8889m#]sfsdf[#k8ddddd889m#]sf"
    		if(group){
	    		for(var i=0; i < group.length; i++){
	    			var m = group[i];
	    			var mauth = group[i].replace("[#","").replace("#]","");
	    			var v = IS_AUTH(mauth);
	    			vauth = vauth.replace(m, v+"");
	    		}
	    		eval("var result = "+vauth+";");
	    		if(!result){
	    			$(this).remove();
	    			if(sauth && $.trim(sauth) != ""){
	    				$(sauth).remove();
	    			}
	    		}
    		}
    	}else{
    		if(!IS_AUTH(vauth)){
        		$(this).remove();
        		if(sauth && $.trim(sauth) != ""){
    				$(sauth).remove();
    			}
        	}
    	}
    });
});

function IS_AUTH(vauth){
	if(auth == ""){
		return;
	}
	if(auth.indexOf(",all,") != -1 || auth.indexOf(","+vauth+",") != -1){
		return true;
	}
	return false;
}