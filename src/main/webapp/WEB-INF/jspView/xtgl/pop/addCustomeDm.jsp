<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#addCustomerHead{
	margin-top: 10px;
}
</style>
<div>
   <script type="text/javascript">
      $(function(){
	    	// cancel
	  		$("#addCustomerDmCancel").live('click',function(){
	  			$('.customeDmAdd_dlg').dialog("close");
	  		});
    	
    	  $("#saveCustomDm").die().live('click',function(){
    		  var saveDm = $("#saveDm").val().trim();
    		  var saveMc= $("#saveMc").val().trim();
    		  if(saveDm == "" || saveMc == "")
    			  {
    			    alert("请输入代码和名称不能为空 ");
    			    return;
    			  }
    		  $.ajax({
    			  url:"/main/xtgl/saveCustomeDm.aj",
      	    	  type:"POST",
      	    	  data:{nbxh:$("#dmwh_select option:selected").val(),saveDm:saveDm,saveMc:saveMc,btnType:$("#addCustomerHead").data("btntype")},
      	    	  dataType:"html",
      	    	  success:function(html)
      	    	{
      	    		if(html == "-1")
      	    			{
      	    			  alert("这个代码已经存在，不能添加！请重新输入！");
      	    			  return;
      	    			}
      	    		if(html == "1" && $("#addCustomerHead").data("btntype") == 0 )
      	    			{
      	    			  var operation_html = '<td class="center" data-dm="'+saveDm+'"><a class="dlg_modify" href="javascript:void(0)" data-btn_type="2">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';  	    			   
   	    			      $roles_oTable.fnAddData([saveDm,saveMc,operation_html]);
   	    			      var tr = $roles_oTable.$("tr:last");
   	    			      tr.addClass("sfzdy-1");
   	    			      tr.children("td:last").attr("data-dm",saveDm);
      	    			  $(".customeDmAdd_dlg").dialog('close');
      	    			  return;
      	    			}
      	    		if(html == "1" && $("#addCustomerHead").data("btntype") == 2)
      	    			{
      	    			  $current_node=$("#dmwh_list #dataTable tbody .active");
					      $current_node.find("td:nth-child(2)").text(saveMc);
      	    			  $(".customeDmAdd_dlg").dialog('close');
      	    			  return;
      	    			};
      	    		
      	    	}
    		 });
    	  });
      });
   </script>
</div>
<div>
    <div id="addCustomerHead" class="form-horizontal" data-btnType="${btnType}">
        <c:choose>
          <c:when test="${btnType == 0}">
          <div class="form-group">
          	<label class="control-label col-md-3" for="saveDm">代码：</label>
          	<div class="col-md-9">
	          	<input class="form-control" type="text" value="${maxDm}" id="saveDm" />
	          	<p class="help-block">当前代码最大值</p>
          	</div>
          </div>
          <div class="form-group">   
             <label class="control-label col-md-3" for="saveMc">代码名称：</label>
             <div class="col-md-9">
             	<input class="form-control" type="text" id="saveMc" />
             </div>
          </div> 
          </c:when>
          <c:otherwise>
          <div class="form-group">
          	<label class="control-label col-md-3" for="saveDm">代码：</label>
          	<div class="col-md-9">
	          	<input class="form-control" type="text" value="${dm.NDm}" id="saveDm" readonly="readonly"/>
          	</div>
          </div>
          <div class="form-group">   
             <label class="control-label col-md-3" for="saveMc">代码名称：</label>
             <div class="col-md-9">
             	<input class="form-control" type="text" id="saveMc" value="${dm.CMc}" />
             </div>
          </div> 
          </c:otherwise>
        </c:choose>     
        
    </div>
    <div class="bottom-btn-bar">
		<div class="btn-group">
		    <button id="saveCustomDm" class="btn btn-primary">
		    	<span class="glyphicon glyphicon-save"></span> 保存
		    </button>
		    <button id="addCustomerDmCancel" class="btn btn-primary">
		    	<span class="glyphicon glyphicon-remove"></span> 取消
		    </button>
	    </div>
	</div>
</div>
