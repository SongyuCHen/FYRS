<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
#xzfyTree{
	height: 325px;
	overflow:auto;
}
.ui-dialog .ui-dialog-titlebar
{
   padding: .05em 1em;
   position: relative;
}
  .xzfy_foot
      {
        width:100%;
        text-align: center;
        margin-top: 20px;
      }

-->
</style>
<div>
    <script type="text/javascript">
       $(function(){
    	   // 设置弹窗
     	  $('.xzfy_dlg').dialog({
   			autoOpen : false,
   			bgiframe : true,
   			modal : true,
   			resizable : false,
   			height : 436,
   			width : 400,
   			title : '选择法院'
   		});
    	   // 设置树型
    	   $("#xzfyTree").jstree({
               "json_data":{
                   "ajax":{
                       "url":"/xzfy.aj",
                       "data":{'isOnlyXzFy':$('.xzfy_dlg').attr("isOnlyXzFy")},
                       "type":"POST"
                   }
               },
               "themes":{
                   "theme" : "classic"
               },
               "plugins" : [ "themes", "json_data" ,"ui"]
           });
    	   // 加载法院时，全部展开节点
    	    $("#xzfyTree").bind(
                    "loaded.jstree",
                    function(event){
                        $("#xzfyTree").jstree("open_all",-1); 
                    }
            );
    	   
    	   // 设置点击确定事件
    	   $(".xzfy_ok").click(function(){
    		  var currentSelectNode = $("#xzfyTree li a").filter("[class=jstree-clicked]");
    		  if(currentSelectNode.text() =="")
    			  {
    			    alert("请选择一个法院！");
    			    return ;
    			  }
    		  
    		  $(".xzfy_yr").val(currentSelectNode.text());
    		  $(".xzfyyr_fybh").val(currentSelectNode.parent().attr("id"));
    		  // 把窗口关闭
    		  $('.xzfy_dlg').dialog("close");
    		  // 仅是选择法院
    		  if($('.xzfy_dlg').attr("isOnlyXzFy") == 1)
    			  {
    			    return;
    			  }
    		  // 仅是选择法院，但是需要权限，不选择部门
    		  if($('.xzfy_dlg').attr("isBmSelected") != 1)
    			  {
    			    selectFyAfter();
    			    return;
    			  }
    		  if($('.xzfy_dlg').attr("isFyAndBm") == 1)
    			  {
    			    selectFyAfter();
    			  }
    		  $.ajax({
    			  url : "/xzbm.aj",
  				  type : 'post',
  				  dataType : 'json',
  				  data : {'id':currentSelectNode.parent().attr("id")},
  				  success:function(json){
  					  $("#yrbm option").remove();
  					  var allOption = "<option value='-1'>请选择部门</option><option value='-2'>选择全部部门</option>";
  					  for(var i = 0; i < json.length; i++)
  						  {
  						   var bm = json[i];
  						   allOption += '<option value="'+bm.NCode+'">' + bm.CName+'</option>';
  						  }
  					$("#yrbm").append(allOption);
  					$("#yrbm").change(function(){
  						if($(this).val == -1){
  							alert("请选择引入人员的部门");
  						}else{
  						$.ajax({
  						  url : "/main/ryxx/zzkTable.aj",
  		  				  type : 'post',
  		  				  dataType : 'json',
  		  				  data : {
  		  					  'fydm':currentSelectNode.parent().attr("id"),
  		  					  'bmdm':$("#yrbm").val(),
  		  					  'lsklx':1
  		  					  },
  		  				  success:function(json){
  		  					$("#yrry option").remove();
  		  					var allOption = "<option value='-1'>请选择人员</option>";
  		  					for(var i = 0; i < json.length; i++)
						  	{
						   		var ry = json[i];
						   		allOption += '<option value="'+ry.rybh+'">' + ry.xm+'</option>';
						  	}
  		  					$("#yrry").append(allOption);
  		  				  }
  						});
  						}
  					});
  				  }
    		  });
    	   });
    	   // 取消事件
    	   $(".xzfy_cancel").click(function(){
    		   $('.xzfy_dlg').dialog("close");
    	   });
       });
    </script>
 </div>
 <div id="xzfyTree"></div>
 <div class="xzfy_foot">
 	<div class="btn-group">
		<button class="btn btn-primary xzfy_ok">
			<span class="glyphicon glyphicon-ok"></span> 确定
		</button>
		<button class="btn btn-primary xzfy_cancel">
			<span class="glyphicon glyphicon-remove"></span> 取消
		</button>
	</div>
</div>
