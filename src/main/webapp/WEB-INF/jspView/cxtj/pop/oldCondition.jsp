<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
   #oldConditionTable td
   {
     padding-left: 10px;
   }
-->
</style>
<div>
   <script type="text/javascript">
     $(function(){
    	 // 删除一项
    	 $(".i_deleteOld").live('click',function(){
    		 var td = $(this).parent();
    		 $.ajax({
      		   url:"/main/cxtj/deleteOldCondition.aj",
      		   type:"POST",
      		   data:{id:td.data("id"),fydm:td.data("fydm"),rybh:td.data("rybh")},
      		   dataType:"html",
      		   success:function(html){
      		        if(html == "1")
      		        	{
      		        	  td.parent().remove();
      		        	}
      		   }
    		 });
    	 });
    	 // 删除一项
    	 // 删除全部 
    	 $("#deleteAll").live("click",function(){
    		 if($("#oldConditionTable tr td[data-fydm]").length == 0)
    			 {
    			   alert("没有需要删除的查询条件！");
    			   return;
    			 }
    		 var tdDom = $("#oldConditionTable tr td[data-fydm]")[0];
    		 var td = $(tdDom);
    		 $.ajax({
        		   url:"/main/cxtj/deleteOldConditionAll.aj",
        		   type:"POST",
        		   data:{fydm:td.data("fydm"),rybh:td.data("rybh")},
        		   dataType:"html",
        		   success:function(html){
        		        if(html == "1")
        		        	{
        		        	 $("#oldConditionTable tr").each(function(){
        		        		$(this).remove();
        		        	 });
        		        	}
        		   }
      		 });
    	 });
    	 // 删除全部 
    	 // 使用查询条件
    	 $(".i_useOld").live("click",function(){
    		 var td = $(this).parent();
    		 $.ajax({
      		   url:"/main/cxtj/oldConditionHtml.aj",
      		   type:"POST",
      		   data:{id:td.data("id"),fydm:td.data("fydm"),rybh:td.data("rybh")},
      		   dataType:"json",
      		   success:function(json){
      		        var ryk = json.ryk;
      		        var html = json.html;
      		        $('#findScope option[value="'+ryk+'"]').attr("selected",true);
      		        $("#condition-columnsTree").html("").html(html);
      		        $(".sdcxConditionsShow_dlg").dialog('close');
      		   }
    		 });
    	 });
    	 // 使用查询条件
     });
   </script>
</div>
<div>
   <div><input type="button" id="deleteAll" value="全部清除"></div>
   <div>
      <table id="oldConditionTable">
        <c:forEach var="vo" items="${vos}" >
          <tr>
           <td>条件名称：${vo.CTjmc}</td>
           <td>保存时间：${vo.DBcsj}</td>
           <td data-fydm="${vo.NFy}" data-id="${vo.NId}" data-rybh="${vo.NRybh}"><a class="i_useOld" data-btnType="2"  href="javascript:void(0)">使用</a><span>|</span> <a class="i_deleteOld" href="javascript:void(0)">删除</a></td>
          </tr>
        </c:forEach>
        
      </table>
   </div>
</div>
