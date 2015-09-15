<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
#xzfyTree{
	height: 400px;
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
   			height : 500,
   			width : 400,
   			title : '选择法院'
   		});
    	   // 设置树型
    	   $("#xzfyTree").jstree({
               "json_data":{
                   "ajax":{
                       "url":"/xzfyBm.aj",
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
    			    alert("请选择一个法院或一个部门！");
    			    return ;
    			  }
    		  var level = currentSelectNode.parent().attr("level");
    		  if(level == undefined)
    			  {
    			    // 选中法院
    			    $(".xzfy_fybh").val(currentSelectNode.parent().attr("id"));
    			    $(".xzfy_bmbh").val("");
    			    $(".xzfy_bmbh").attr("level","");
    			  }
    		  else
    			  {
    			    // 选择部门
    			    $(".xzfy_fybh").val(currentSelectNode.parent().attr("fydm"));
    			    $(".xzfy_bmbh").val(currentSelectNode.parent().attr("id"));
    			    $(".xzfy_bmbh").attr("level",currentSelectNode.parent().attr("level"));
    			  }
    		  $(".xzfy_ipt").val(currentSelectNode.text());
    		  selectFyOrBmAfter();
    		  // 把窗口关闭
    		  $('.xzfy_dlg').dialog("close");
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
