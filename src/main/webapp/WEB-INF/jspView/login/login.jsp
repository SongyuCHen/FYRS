<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>人事信息管理系统</title>
<link rel="stylesheet" href="/resources/css/jquery-ui/custom-theme/jquery-ui-1.9.2.custom.min.css" />
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />

<script type="text/javascript" src="resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.cookie.js"></script>

<!-- bootstrap -->
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap-theme.min.css" />
<!-- 兼容IE8 -->
<!--[if lt IE 9]>
  <script src="/resources/js/html5shiv.min.js"></script>
  <script src="/resources/js/respond.min.js"></script>
<![endif]-->
<!-- uniform -->
  <script type="text/javascript" src="/resources/js/jquery/jquery.uniform.min.js"><jsp:text/></script>
  <link rel="stylesheet" type="text/css" media="screen" href="/resources/uniform/themes/default/css/uniform.default.min.css" />

<link rel="stylesheet" href="resources/css/login.css" />
 <script type="text/javascript">
      $(function(){
    	  //uniform美化多选框
    	  $('input:checkbox, input:radio, .uniform-file').uniform();
    	  /**
         	* 记住法院名称，代码，用户名和密码
         	*/
         function rememberUser(){
        	var checked = $("#rememberPW").attr("checked");
  			if(checked == "checked" || checked) {
      	    	var username = $("#username").val();
      	        var password = $("#pw").val();
      	        var fymc = $(".xzfy_ipt").val();
      	        var fydm = $(".xzfy_fybh").val();
      	        $.cookie("rememberuser", "true", {expires: 30});
      	        $.cookie("username", username, {expires: 30});
      	        $.cookie("password", password, {expires: 30});
      	      	$.cookie("fymc", fymc, {expires: 30});
      	      	$.cookie("fydm", fydm, {expires: 30});
      	    }else{
      	        $.cookie("rememberuser", "false", {expires: -1});
      	        $.cookie("username", "", {expires: -1});
      	        $.cookie("password", "", {expires: -1});
      	      	$.cookie("fymc", "", {expires: -1});
      	      	$.cookie("fydm", "", {expires: -1});
      	    }
      	}
    	  
        // 点击触发事件 
    	  $('.xzfy_ipt').click(function() {
  			$.ajax({
  				url : "/xzfyShow.aj",
  				type : 'post',
  				dataType : 'html',
  				data : {},
  				success : function(html) {
  				    $('.xzfy_dlg').html(html).dialog('open');
  				}
  			});
  		});
       //  当点击登录时
       $("#login_form .login_btn").live('click',function(){
    	   
    	   var fydm = $(".xzfy_fybh").val();
    	   if(fydm == -1)
    		   {
    		     alert("请选择一个法院");
    		     return false;
    		   }
    	   var username = $("#username").val();
    	   if(username == "")
    		   {
    		   alert("用户名不能这空");
  		       return false;
    		   }
    	 	//检查是否需要保存用户名和密码
    	   rememberUser();
    	   return true;
       });
       	
		//已经记住密码，从cookie中取值
		if($.cookie("rememberuser") == "true"){
			$("#rememberPW").attr("checked", true);
           	$("#username").val($.cookie("username"));
           	$("#pw").val($.cookie("password"));
           	$(".xzfy_ipt").val($.cookie("fymc"));
           	$(".xzfy_fybh").val($.cookie("fydm"));
           	$.uniform.update();//通知uniform更新样式
       	}
      });
   </script>  
</head>
<body>
	<div class="login_contain">
		<div class="login_header"></div>
		<div class="login_content">
			<form id="login_form" class="container form-horizontal" action="login.do" method="POST">
					<div class="form-group">
						<!-- <label class="col-md-3 control-label" for="fy" style="display:inline-block;text-align:center">法&nbsp;&nbsp;院</label> -->
						<div class="col-md-12" style="display:inline-block;">
							<input type="text" class="xzfy_ipt form-control input-sm input-control"
								value="${fymc}" name="fymc" style="display:inline-block;"/>
							<input class="xzfy_fybh form-control input-sm" name="fybh"
								value="${fydm}" type="hidden" />
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="col-md-3 control-label" for="username" style="display:inline-block;text-align:center;">用户名</label> -->
						<div class="col-md-12" style="display:inline-block;">
							<input type="text" class="form-control input-sm input-control" id="username" value="${username}" name="username" style="display:inline-block;"/>
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="col-md-3 control-label" for="pw" style="display:inline-block;text-align:center;">密&nbsp;&nbsp;码</label> -->
						<div class="col-md-12" style="display:inline-block;">
							<input type="password" class="form-control input-sm input-control" id="pw" value="${password}" name="password" style="display:inline-block;"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-5 input-control remember-me" style="display:inline-block;">
							<input type="checkbox" id="rememberPW" style="display:inline-block;"/>
							<label for="rememberPW">记住密码&nbsp;</label><span style="color:red;"><c:if test="${result!=null}">${result}</c:if></span>
						</div>
						<div class="btn-group col-md-7" style="display:inline-block;">
							<button type="submit" class="btn btn-primary login_btn" style="display:inline-block;">
								<span class="glyphicon glyphicon-log-in"></span> 登录
							</button>
							<button type="reset" class="btn btn-primary" style="display:inline-block;">
								<span class="glyphicon glyphicon-refresh"></span> 重置
							</button>
						</div>
					</div>
			</form>
			<div class="xzfy_dlg" isOnlyXzFy="1">
			</div>
			<div class="footer">
				<p>版权所有&nbsp;淮安市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持&nbsp;南京铉盈网络科技</p>
			</div>
		</div>
	</div>
</body>
</html>