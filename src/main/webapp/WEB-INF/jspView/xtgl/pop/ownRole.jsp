<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.lang.Math" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#rolePop{
    margin-top:10px;
}
.role-span{
	margin-bottom: 10px;
}
</style>
<script type="text/javascript">
	$(function(){
		//uniform对多选框进行美化
		$('input:checkbox, input:radio, .uniform-file').uniform();
		
		$("#ownRole_ok").live('click',function(){
			if("" == $("#userName").val())
				{
				   alert("用户名不能为空");
				   return;
				}
			var roleIds = "";
			var roleNames = "";
			$("#rolePop input:checked").each(function(){
				roleIds += $(this).attr("name")+",";
				roleNames += $(this).val()+" | ";
			});
			$current_node=$("#qxgl_list #dataTable tbody .active");
			$.ajax({
				url : "/main/xtgl/updateRoles.aj",
  				type : 'post',
  				dataType : 'html',
  				data : {fydm:$("#userName").attr("data-fydm"),rybh:$("#userName").attr("data-rybh"),roleIds:roleIds,userName:$("#userName").val(),realName:$current_node.find("td:nth-child(2)").text()},
  				success:function(html){
  					if(html == -1)
  						{
  						  alert("用户名已经存在，请重新输入！");
  						  return ;
  						}
  					if(html == 1)
  						{
  					    if(roleNames.length > 3)
  						{
  						  roleNames = roleNames.substring(0,roleNames.length - 3);
  						}
  					     $current_node.find("td:nth-child(3)").text($("#userName").val());
						 $current_node.find("td:nth-child(4)").text(roleNames);
  						 $('#ownRoles_dlg').dialog("close");
  						}
  					
  				}
			});
		}); // ok
		// cancel
		$("#ownRole_cancel").live('click',function(){
			$('#ownRoles_dlg').dialog("close");
		});
		// 当加载完成后，获得原来有的角色的ID
		$.ajax({
			url : "/main/xtgl/ownRoleIds.aj",
				type : 'post',
				dataType : 'html',
				data : {fydm:$("#userName").attr("data-fydm"),rybh:$("#userName").attr("data-rybh")},
				success:function(json){
					if(json == -1)
						{
						  return;
						}
					var arrayJsonId = json.split(",");
					for(var i = 0; i < arrayJsonId.length; i++)
						{
						  $("#rolePop input[name="+arrayJsonId[i]+"]").attr("checked","checked");
						  $.uniform.update();//更新uniform选中样式
						}
				}
		});
	});
</script>
<div id="rolePop" class="form-horizontal" data-bh="${role.id}">
	<div class="form-group">
    	<label class="col-md-3 control-label">登录用户名：</label>
    	<div class="col-md-9">
    		<input class="form-control" type="text" name="userName" id="userName" value="${username}" data-fydm="${fydm}" data-rybh="${rybh}"> <br>
    	</div>
    </div>
    <div class="form-group">
		 <label class="col-md-3 control-label">拥有角色：</label>
		 <div class="col-md-9">
		 	<c:set var="itemPerRow" value="2" /><!-- 每行显示元素个数 -->
		 	<c:set var="col" value="${12/itemPerRow}" /><!-- 栅格一共12列 -->
		  <c:forEach items="${roles}" var="role" varStatus="i">
			  <c:if test="${i.count % itemPerRow == 1 }">
			  	<div class="row"> 
			  </c:if>
			  	<span class="role-span col-md-${col.toString().substring(0,1)}"><!-- Math.floor不起作用？ -->
			  		<input id="role-${role.id}" type="checkbox" name="${role.id}" value="${role.roleName}" />
			  		<label for="role-${role.id}">${role.roleName}</label>
			  	</span>
			  <c:if test="${i.count % itemPerRow == 0 || i.last }">
			  	</div> 
			  </c:if>
		  </c:forEach>
		 </div>
   </div>
	<div class="bottom-btn-bar">
		<div class="btn-group">
		    <button id="ownRole_ok" class="btn btn-primary">
		    	<span class="glyphicon glyphicon-ok"></span> 确定
		    </button>
		    <button id="ownRole_cancel" class="btn btn-primary">
		    	<span class="glyphicon glyphicon-remove"></span> 取消
		    </button>
	    </div>
	</div>
	</div>