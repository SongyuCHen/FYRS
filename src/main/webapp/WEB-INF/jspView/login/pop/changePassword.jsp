<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.ui-dialog .ui-dialog-titlebar
{
   padding: .05em 1em;
   position: relative;
}
.changePassword_content
{
  margin-top:10px;
  margin-left: 20px;
}
.oldPassworld,.newPassworld
{
  margin-left:25px;
}
.oldPassworld,.newPassworld,.repeatNewPassworld
{
  height: 40px;
}
#savePasswordFooter
{
  text-align: center;
  margin-top: 10px;
}
</style>
<div>
  <script type="text/javascript">
     $(function(){
    	 // 设置弹窗
   	  $('.showResult').dialog({
 			autoOpen : false,
 			bgiframe : true,
 			modal : true,
 			resizable : false,
 			height : 200,
 			width : 400,
 			title : '执行结果'
 		});
    	 $("#password_save").click(function(){
    		 var oldPassworld = $(".oldPassword input").val();
    		 var newPassworld = $(".newPassword input").val();
    		 var repeatNewPassworld = $(".repeatNewPassword input").val();
    		 if(newPassworld != repeatNewPassworld)
    			 {
    			   alert("输入新的密码不一致！");
    			   return;
    			 }
    		 $.ajax({
    			 url:"/changePassword.aj",
    			 type:"POST",
    			 data:{oldPassworld:oldPassworld,newPassworld:newPassworld},
    			 dataType:"html",
    			 success:function(html){
    				 if(html == "1")
    					 {
    					    $(".showResult p").remove();
    					    $(".showResult").html('<p style="text-align: center;">密码修改成功！</p>');
    					    $(".showResult").dialog({
    					    	'buttons':{
									  "确定":function(){
										  $(".showResult").dialog("close");
										  $("#changePassword_dlg").dialog("close");
									  }
								  }
    					    }).dialog("open");
    					 } // if
    				 else if(html == "-1")
    					 {
    					    $(".showResult p").remove();
 					        $(".showResult").html('<p style="text-align: center;">旧密码不正确，请重新输入！</p>');
 					        $(".showResult").dialog({
 					    	'buttons':{
									  "确定":function(){
										  $(".showResult").dialog("close");
									  }
								  }
 					    }).dialog("open");
    				} // if
    				else
    					{
    					 $(".showResult p").remove();
					        $(".showResult").html('<p style="text-align: center;">系统出现错误！</p>');
					        $(".showResult").dialog({
					    	'buttons':{
									  "确定":function(){
										  $(".showResult").dialog("close");
									  }
								  }
					    }).dialog("open");
    					}
    			 }
    		 });
    	 });
    	 $("#password_reset").click(function(){
    		 $(".oldPassword input,.newPassword input,.repeatNewPassword input").val("");
    	 });
     });
  </script>
</div>
<div class="form-horizontal">
	<div class="form-group oldPassword">
		<label class="control-label">请输入旧密码：</label>
	 	<input class="input-sm form-control" type="password" name="password" />
	</div>
 	<div class="form-group newPassword">
 		<label class="control-label">请输入新密码：</label>
 		<input class="input-sm form-control" type="password" name="password" />
 	</div>
 	<div class="form-group repeatNewPassword">
 		<label class="control-label">请重新输入新密码：</label>
 		<input class="input-sm form-control" type="password" name="password" />
 	</div>
  <div class="showResult"></div>
</div>
<div class="bottom-btn-bar">
	<div class="btn-group">
		<button id="password_save" class="btn btn-primary">
			<span class="glyphicon glyphicon-ok"></span> 保存
		</button>
		<button id="password_reset" class="btn btn-default">
			<span class="glyphicon glyphicon-refresh"></span> 重置
		</button>
	</div>
</div>
