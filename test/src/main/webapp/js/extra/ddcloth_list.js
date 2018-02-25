/**
 * 
 */

//查看  配料订单  信息
	function ViewDDIngred(url){
		$.layer({
		    type: 2,
		    shade : [0.3, '#000'],
		    fix: true,
		    title: '查看配料及备件订单',
		    maxmin: false,
		    iframe: {src : url },
		    area: ["870px" , "350px"]
		}); 
	}
	
	function DoSiteURL(url, args_){
		var frmhtml = "<form id='frm_0_' action='"+url+"' method='post'>";
			frmhtml += "<input name='args_' type='hidden' value='"+args_+"'/></form>";
		$("#frm_0_").remove();
		$("body").append(frmhtml);
		$("#frm_0_").submit();
	}