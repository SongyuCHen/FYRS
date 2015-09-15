<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#rolePop{
	margin-top: 10px;
}
</style>
<script type="text/javascript">
  $(function(){
	  if(1 == $("#i_save").data("type"))
		  {
		    $("#i_save").css("display","none");
		    $("#roleInputName").attr("readonly","readonly");
		  }
  });
</script>
<div id="rolePop" data-bh="${role.id}">
 <div id="roleContent" class="form-horizontal">
 	<div class="form-group">
        <label class="col-md-4 control-label" for="roleInputName">角色名称：</label>
        <div class="col-md-8">
        	<input type="text" class="form-control" name="roleName" id="roleInputName" value="${role.roleName}">
        </div>
    </div>
    <div class="bottom-btn-bar">
		<div class="btn-group">
			<button class="btn btn-primary" id="i_save" data-type="${btnType}">
				<span class="glyphicon glyphicon-ok"></span> 保存
			</button>
    		<button class="btn btn-primary" id="i_close">
    			<span class="glyphicon glyphicon-remove"></span> 关闭
    		</button>
		</div>
	</div>
 </div>
</div>