<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
 .children
 {
   margin-top:5px;
   margin-bottom:5px;
   margin-left: 20px;
 }
 
  .children span
  {
    padding: 0px 10px;
  }
  #rolesList
  {
    text-align: center;
  }
-->
</style>
<div>
   <script type="text/javascript">
    $(function(){
    	// 注意放的位置
    	var getMenuIds = function(roleId){
    		 $.ajax({
			      url : "/main/xtgl/qxgl/menusByRolesId.aj",
				  type : 'POST',
				  dataType : 'json',
				  data :{roleId:roleId},
				  success:function(json)
				  {
					  // 先把原来的状态清空
					  $("#allMenus input:checkbox").each(function(){
						  $(this).attr("checked",false);
					  });
					  for(var i = 0; i < json.length; i++)
						  {
						    $("#node-id-"+json[i]).attr("checked",true);
						  }
				  }		 
				});
    	};
    	$("#rolesList select").change(function(){
    		getMenuIds($("#rolesList select :selected").val());
    	});
    	getMenuIds($("#rolesList select :selected").val());
    	// 保存
    	$("#saveMenuIdToRoleId").live("click",function(){
    	     var menuIds = '[';
    		 $("#allMenus input:checkbox").each(function(){
				  if($(this).attr("checked"))
					  {
					    menuIds += $(this).attr("id").trim().split("-")[2]+",";				
					  }
			  });
    		 menuIds = menuIds.substring(0,menuIds.length - 1);
    		 menuIds += "]";
    	     
    		 $.ajax({
			      url : "/main/xtgl/qxgl/saveMenuIdToRoleId.aj",
				  type : 'POST',
				  dataType : 'html',
				  data :{menusId:menuIds,roleId:$("#rolesList select :selected").val()},
				  success:function(html)
				  {
					 if(html == "1")
						 {
						   alert("保存成功！");
						 }
				  }		 
				});
    	});
    }); // jquery
   
    var parentFun = function(elem)
    {
      var nodeId = $(elem).parent().attr("id");
      $("#"+nodeId + " div span input:checkbox").each(function(){
    	  this.checked = elem.checked;
      });  
    };
    var childrenFun = function(elem)
    {
       
       var parentId = $(elem).data("parentid");
       
       if(elem.checked)
    	   {
    	      if(($("#"+parentId +" > div > span > input:checked").length) > 0)
    	    	  {
    	    	    $("#"+parentId+" > input")[0].checked = true;
    	    	  }
    	   }
       else
    	   {
    	   
    	   if($("#"+parentId +" > div >  span >  input:checked").length == 0)
	    	  {
    		    $("#"+parentId+" > input")[0].checked = false;
	    	  }
    	   }
       
    };
   </script>
</div>
<div>
  <div id="rolesList">
     <select style="width: 300px;">
        <c:forEach items="${roles}" var="role">
           <option value="${role.id}">${role.roleName}</option>
        </c:forEach>
     </select>
  </div>
  <div id="allMenus">
     <c:forEach items="${vos}" var="vo">
        <div id="top-id-${vo.id}">
          <input type="checkbox" id="node-id-${vo.id}" onchange="parentFun(this)">
          <label for="node-id-${vo.id}">${vo.menuName}</label>
           <div class="children">
           <c:forEach items="${vo.children}" var="children">
              <span>
              	<input type="checkbox" id="node-id-${children.id}" onchange="childrenFun(this)" data-parentId="top-id-${vo.id}">
              	<label for="node-id-${children.id}">${children.menuName}</label>
              </span>
           </c:forEach>
        </div>
        <hr>
      </div>
     </c:forEach>
  </div>
  <div style="text-align: center;"><input type="button" value="保存" id="saveMenuIdToRoleId"></div>
</div>
