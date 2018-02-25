<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<title>${PAGE_TITLE}-登录</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/denglu.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/js/validform/jquery.validform.css"/>
<script src="<%=path %>/js/validform/jquery.my.validform.js" type="text/javascript"></script>


</script>
</head>
<body>
	
	<div class="denglu_main">
       <form id="login_frm" method="post" action="<%=path%>/system/do_login.htm">
          <div style="position:absolute; right:-30px; top:220px; font-size:16px; color:#fff; font-weight:bold;"> </div>
           <div class="from_input">
               <input name="uname" id = "uname" type="text"  class="user_name" value="admin" onclick="if(this.value=='请输入用户名')this.value='';" onblur="if(this.value=='')this.value='请输入用户名';" />
               <input name="upass" id = "upass" type="password" class="user_password" value="admin" onclick="if(this.value=='请输入密码')this.value='';" onblur="if(this.value=='')this.value='请输入密码';" />
           </div>
           <c:if test="${not empty ErrorMsg }" >
           		<div class="error">${ErrorMsg}</div>
           </c:if>
          <!--  <div class="shenfen_leibie">
               <span><input name="lgtype" id = "gr" type="radio" value="1" />个人</span>
               <span><input name="lgtype" id = "gl" type="radio" value="0" checked="checked" />管理员</span>
           </div>--> 
           <input type="submit"  class="dlfrom_tijiao" value="" title = "本项目仅支持火狐、谷歌、IE9及以上版本浏览器"/>
           <div class="browser_version">本项目仅支持火狐、谷歌、IE9及以上版本浏览器</div>
           <div class="dl_banquan">交通部海事局版权©2014-2015</div>
       </form>
    </div>

</body>
</html>