<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
  .logicTypeDisplay
  {
    visibility: visible;
  }
  .logicTypeHidden
  {  
    display: none;
  }
  #findConditionRoot > div
  {
     margin-top: 25px;
     margin-left: 20px;
  }
  #findConditionRoot select
  {
    width: 200px;
  }
  
-->
</style>
<div>
  
    <script type="text/javascript">
      $(function(){
    	 $("#select-time").datepicker();
    	 var logicType = $("#findConditionRoot").data("logictype"); 
    	 var cm = $("#findConditionRoot").data("columnnamemc"); 
    	 var tm = $("#findConditionRoot").data("tablenamemc"); 
    	 $("#findConditionRoot > div").each(function(){
    		if($(this).attr("id") == "logicType-"+logicType)
    			{
    			  $(this).removeClass("logicTypeHidden");
    			  $(this).addClass("logicTypeDisplay");
  			      
    			}
    		else
    			{
    			  $(this).removeClass("logicTypeDisplay");
    			  $(this).addClass("logicTypeHidden");
    			}
    	 });
    	 $("#logicType-1 select,#logicType-2 select,#logicType-3 select,#logicType-5 select").live("change",function(){
    		 
    		 if($(this).children("option:selected").val().match(/null/))
    			   {
    			     $(this).parent().children("input").removeClass("logicTypeDisplay");
    			     $(this).parent().children("input").addClass("logicTypeHidden");
    			   }
    		   else
    			   {
    			     $(this).parent().children("input").removeClass("logicTypeHidden");
    			     $(this).parent().children("input").addClass("logicTypeDisplay");
    			   }
    	 });
    	 // ok
    	 $("#findCondition-ok").click(function(){
    		 var option_1;
    		 var option_2;
    		 var endSql = "";
    		 var endText = "";
    		 var dataTableName = "";
    		 if(logicType == 1 || logicType == 2 || logicType == 3 || logicType == 5)
    		{
    			 var node = $("#fi-right option:selected");
        	     var name = $("#logicType-"+logicType + " select option:selected").text();
        	     var sql_val = $("#logicType-"+logicType + " select option:selected").val();
        	     if($("#condition-revers").attr("checked"))
        	    	 {
        	    	   sql_val = $("#logicType-"+logicType + " select option:selected").data("invers");
        	    	   name = "不"+name;
        	    	 }
        	     var value = $("#logicType-"+logicType+"  input").val();
        	     var pattern = /like/;
        	     var pattern_2 = /null/;
        	     var pattern_3 = /=|<|>/;
        	     if(!sql_val.match(pattern_2) && value.length == 0)
        	    	 {
        	    	   alert("请输入值！");
        	    	   return;
        	    	 }
        	     if(sql_val.match(pattern))
        	    	 {
        	    	   sql_val += "'%"+value+"%'";
        	    	 }
        	     else if(sql_val.match(pattern_2))
        	    	 {
        	    	   
        	    	 }
        	     else if($.trim(node.val())[0] != 'N' && sql_val.match(pattern_3))
        	    	 {  
        	    	   sql_val += "'"+value+"'";
        	    	 }
        	     else
        	    	 {
        	    	   sql_val += value;
        	    	 }
        	    
        	   
        	    	 option_1 = '<option data-sqlValue="'+node.val() + ' '+sql_val+'" type="condition" value="'+node.val()+'"  data-tableName="'+node.data("tablename")+'"  data-logictype="'+node.data("logictype")+'" data-datatype="'+node.data("datatype")+'">'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+node.text()+name+value+'【'+node.data("tablenamemc")+'】'+'</option>';
            	     option_2 = '<option value="and" type="mark">并且</option>';
        	    	
            	     dataTableName = node.data("tablename");
        	         endSql = ' ' + node.val() + ' '+sql_val;
        	         
        	    	 endText = node.text()+name+value+'【'+node.data("tablenamemc")+'】';
        	    	
        	    
        		    
    		}
    		 if(logicType == 101 || logicType == 103 || logicType == 104 || logicType == 210 )
    	     {
    			
    			 var node = $("#fi-right option:selected");
        	     var cd_name = $("#logicType-"+logicType+"-sel option:selected").text();
        	     var cd_val = $("#logicType-"+logicType+"-sel option:selected").val();
        	     var va_value = $("#logicType-"+logicType+"-sel-value option:selected").val();
        	     var va_name = $("#logicType-"+logicType+"-sel-value option:selected").text();
        	     if(cd_val.match(/in/) && va_name == "")
				 {
        	    	alert("请选择包含的值");
				    return;
				 }
        	     if($("#condition-revers").attr("checked"))
        	    	 {
        	    	  cd_name = "不"+$("#logicType-"+logicType+"-sel option:selected").text();
            	      cd_val = $("#logicType-"+logicType+"-sel option:selected").data("invers");
        	    	 }
        	     if(cd_val.match(/null/))
        	    	 {
        	    	   va_value = "";
        	    	   va_name = '" "';
        	    	 }
        	     
        	   
         	   
         	         
         	    	 option_1 = '<option data-sqlValue="'+ node.val() +' '+cd_val+va_value+'" type="condition" value="'+node.val()+'"  data-tableName="'+node.data("tablename")+'"  data-logictype="'+node.data("logictype")+'" data-datatype="'+node.data("datatype")+'">'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+node.text()+cd_name+va_name+'【'+node.data("tablenamemc")+'】'+'</option>';
              	     option_2 = '<option value="and" type="mark">并且</option>';
              	    
              	    dataTableName = node.data("tablename");
              	    if(cd_val.match(/=|<|>/) && $.trim(node.val())[0] != 'N' )
              	    	{
              	    	  va_value = "'"+va_value+"'";
              	    	}
              	    endSql = ' '+node.val() +' '+cd_val+va_value;
              	    
      	    	    endText = node.text()+cd_name+va_name+'【'+node.data("tablenamemc")+'】';
         	    
        	       
    	     }
    		 addSqlCommon(endText,endSql,dataTableName);
    		 $("#findCondition_dlg").dialog('close');
    	 });
    	 var addSqlCommon = function(text,sql,dataTableName)
    	 {
    		 // 先添加一个节点
    		 if($("#condition-columnsTree > ul > li").length == 0)
    			 {
    			   var firstId = idGenerator("sql");
    			   $("#condition-columnsTree").jstree("create",-1,"last",{"data":{"title":text},"state":"open","attr":{"id":firstId,"data-sql":sql,"data-tableName":dataTableName,"data-topId":-1,"data-parentId":-1}},false,true);
    			   $("#"+firstId + " a:first").addClass("jstree-clicked");
    			   return;
    			 }
    		 
    		 var selectedNode = $("#condition-columnsTree a.jstree-clicked").parent().attr("id");
    		 if(selectedNode == undefined)
    			 {
    			   alert("请选择 已选查询条件 栏目中的  或者、并且 、查询条件  其中一个节点！");
    			   return ;
    			 }
    		 if(selectedNode.match(/^condition*/))
    			 {
    			    $("#condition-columnsTree").jstree("create",'"#'+selectedNode+'"',"last",{"data":{"title":text},"state":"open","attr":{"id":idGenerator("sql"),"data-sql":sql,"data-tableName":dataTableName,"data-topId":$("#"+selectedNode).parent().parent().attr("id"),"data-parentId":selectedNode}},false,true);
    			 }
    		 else
    			 {
    			    var children = $("#"+selectedNode+" > ul > li");
    			    if(children.length == 0)
    			    	{
    			    	    var con = idGenerator("condition");
    	    			    $("#condition-columnsTree").jstree("create",'"#'+selectedNode+'"',"last",{"data":{"title":"并且"},"state":"open","attr":{"id":con,"data-conditionType":"and"}},false,true);
    	    			    $("#condition-columnsTree").jstree("create",'"#'+con+'"',"last",{"data":{"title":text},"state":"open","attr":{"id":idGenerator("sql"),"data-sql":sql,"data-tableName":dataTableName,"data-topId":$("#"+selectedNode).attr("id"),"data-parentId":con}},false,true);
    			    	}
    			    else if(children.length == 1)
    			    	{
    			    	  if($("#"+selectedNode+" > ul > li:first").children("a").text() == "或者")
    			    		  {
    			    		  var con = idGenerator("condition");
      	    			     $("#condition-columnsTree").jstree("create",'"#'+selectedNode+'"',"last",{"data":{"title":"并且"},"state":"open","attr":{"id":con,"data-conditionType":"and"}},false,true);
      	    			     $("#condition-columnsTree").jstree("create",'"#'+con+'"',"last",{"data":{"title":text},"state":"open","attr":{"id":idGenerator("sql"),"data-sql":sql,"data-tableName":dataTableName,"data-topId":$("#"+selectedNode).attr("id"),"data-parentId":con}},false,true);
    			    		  }
    			    	  else
    			    		  {
    			    		     var childrenId = $("#"+selectedNode+" > ul > li:first").attr("id");
    	   			    	     $("#condition-columnsTree").jstree("create",'"#'+childrenId+'"',"last",{"data":{"title":text},"state":"open","attr":{"id":idGenerator("sql"),"data-sql":sql,"data-tableName":dataTableName,"data-topId":$("#"+selectedNode).attr("id"),"data-parentId":childrenId}},false,true);
    			    		  }
    			    	}
    			    else
    			    	{
    			    	 var childrenId = $("#"+selectedNode+" > ul > li:first").attr("id");
   			    	     $("#condition-columnsTree").jstree("create",'"#'+childrenId+'"',"last",{"data":{"title":text},"state":"open","attr":{"id":idGenerator("sql"),"data-sql":sql,"data-tableName":dataTableName,"data-topId":$("#"+selectedNode).attr("id"),"data-parentId":childrenId}},false,true);
    			    	}
    			  
    			 }
    	 };
    	 // ok
    	 // cancel
    	 $("#findCondition-cancel").click(function(){
    		 $("#findCondition_dlg").dialog('close');
    	 });
    	 // cancel
    	 // change logic
    	
    	 
    	 // change logic
      }); // jquery
      var optionTemp = "";
 	  var optionCheckBox = "";
      var changeFun = function(logicType)
      {
    	  var pattern = /null/;
 		 if($("#logicType-"+logicType+"-sel option:selected").val().match(pattern))
 			 {
 			     var node = $("#logicType-"+logicType+"-sel-value");
			         node.addClass("logicTypeHidden");
			         node.removeClass("logicTypeDisplay");
 			 }
 		 else
 			 {
 			     var node = $("#logicType-"+logicType+"-sel-value");
			         node.addClass("logicTypeDisplay");
			         node.removeClass("logicTypeHidden");
 			 }
 		 var pattern_2 = /in/;
 		 if($("#logicType-"+logicType+"-sel option:selected").val().match(pattern_2))
 			 {   			   
 			   optionTemp =  $("#logicType-"+logicType+"-sel-value").html(); 
 			   optionCheckBox = "";
 			   $("#logicType-"+logicType+"-sel-value option").each(function(){
 				   if($(this).val() != "-1")
 					   {
 					     optionCheckBox += '<input type="checkbox" name="'+$(this).text()+'" value="'+$(this).val()+'">'+$(this).text()+'<br> ';
 					   }   						   
 			   });
 			   $("#logicType-"+logicType+"-sel-value").empty();
 			 }
 		 else
 			 {
 			   if(optionTemp != "")
 				   {
 				      $("#logicType-"+logicType+"-sel-value").html("").append(optionTemp);
 				   } 
 			 }
      };
      var clickFun = function(logicType)
      {
    	  var pattern = /in/;
 		 if($("#logicType-"+logicType+"-sel option:selected").val().match(pattern))
 			 {
 			    $('.checkbox_dlg').html(optionCheckBox).dialog({
 			    	'buttons':{
 			    		"确定":function(){
 			    			var result ="";
 			    			var resultValue = "";
 			    		    $('.checkbox_dlg input').each(function(){
 			    				if($(this).attr("checked"))
 			    					{
 			    					result += $(this).attr("name")+",";
 			    					resultValue += $(this).val()+",";
 			    					};
 			    			});
 			    		    if(result != "")
 			    		    	{
 			    		    	  result = result.substring(0,result.length - 1);
 			    		    	 resultValue = resultValue.substring(0,resultValue.length - 1);
 			    		    	}
 			    			$("#logicType-"+logicType+"-sel-value").html("").append('<option value="('+resultValue+')" selected="selected">'+result+'</option>');
 			    			$('.checkbox_dlg').dialog('close');
 			    		},
 			    		"全选":function(){
 			    			$('.checkbox_dlg input').attr("checked",true);
 			    		},
 			    		"全清":function(){
 			    			$('.checkbox_dlg input').attr("checked",false);
 			    		}
 			    	}
 			    }).dialog('open');
 			 }	 
      };
      
    </script>
 </div>
<div id="findConditionRoot" data-columnNameMc="${columnNameMc}"  data-tableNameMc="${tableNameMc}"  data-logicType="${logicType}" >
   <div id="logicType-1">
   	<div class="form-group">
     <select class="input-sm form-control">
        <option value=" = " data-invers="  != ">等于</option>
        <option value=" like " data-invers="  not like ">类似</option>
        <option value=" is null " data-invers="  is not null ">为空</option>
     </select>
     </div>
     <div class="form-group">
     	<input class="input-sm form-control" type="text" name="">
     </div>
   </div>
   <div id="logicType-2">
   	<div class="form-group">
	     <select class="input-sm form-control">
	        <option value=" = " data-invers="  != ">等于</option>
	        <option value=" > " data-invers="  < ">大于</option>
	        <option value=" >= "  data-invers="  < ">大于等于</option>
	        <option value=" < " data-invers="  >= " >小于</option>
	        <option value=" <= " data-invers="  <= " >小于等于</option>
	        <option value=" is null "  data-invers="  is not null ">为空</option>
	     </select>
     </div>
     <div class="form-group">
     	<input class="input-sm form-control" type="text" name="">
     </div>
   </div>
   <div id="logicType-3">
   	<div class="form-group">
	     <select class="input-sm form-control">
	       <option value=" = " data-invers="  != ">等于</option>
	        <option value=" > " data-invers="  < ">大于</option>
	        <option value=" >= "  data-invers="  < ">大于等于</option>
	        <option value=" < " data-invers="  >= " >小于</option>
	        <option value=" <= " data-invers="  <= " >小于等于</option>
	        <option value=" is null "  data-invers="  is not null ">为空</option>
	     </select>
     </div>
     <div class="form-group">
     	<input class="input-sm form-control" type="text" name="">
     </div>
   </div>
   <div id="logicType-5">
   <div class="form-group">
     <select class="input-sm form-control">
       <option value=" = " data-invers="  != ">等于</option>
        <option value=" > " data-invers="  < ">大于</option>
        <option value=" >= "  data-invers="  < ">大于等于</option>
        <option value=" < " data-invers="  >= " >小于</option>
        <option value=" <= " data-invers="  <= " >小于等于</option>
        <option value=" is null "  data-invers="  is not null ">为空</option>
     </select>
     </div>
    <div class="form-group">
     <input class="input-sm form-control" type="text" id="select-time">
     </div>
   </div>
   <div id="logicType-101">
   <div class="form-group">
     <select class="input-sm form-control" id="logicType-101-sel" onchange="changeFun(101);">
        <option value=" = "  data-invers=" != ">等于</option>
        <option value=" is null "  data-invers=" is not null ">为空</option>
        <option value=" in "  data-invers=" not in ">包含</option>
     </select>
     </div>
     <div class="form-group">
      <select class="input-sm form-control" id="logicType-101-sel-value" onclick="clickFun(101);">
         <c:forEach items="${dms}" var="dm">
           <option value="${dm.NDm}">${dm.CMc}</option>
         </c:forEach>
     </select>
     </div>
   </div>
   <div id="logicType-103">
   <div class="form-group">
     <select class="input-sm form-control" id="logicType-103-sel" onchange="changeFun(103);">
        <option value=" = "  data-invers=" != ">等于</option>
        <option value=" is null "  data-invers=" is not null ">为空</option>
        <option value=" in "  data-invers=" not in ">包含</option>
     </select>
     </div>
     
     <div class="form-group">
     <select class="input-sm form-control" id="logicType-103-sel-value" onclick="clickFun(103);">
         <c:forEach items="${dms}" var="dm">
           <option value="${dm.NDm}">${dm.CMc}</option>
         </c:forEach>
     </select>
     </div>
   </div>
   <div id="logicType-104">
   	<div class="form-group">
	     <select class="input-sm form-control" id="logicType-104-sel" onchange="changeFun(104);">
	        <option value=" = "  data-invers=" != ">等于</option>
	        <option value=" is null "  data-invers=" is not null ">为空</option>
	        <option value=" in "  data-invers=" not in ">包含</option>
	     </select>
     </div>
     <div class="form-group">
	     <select class="input-sm form-control" id="logicType-104-sel-value" onclick="clickFun(104);">
	         <c:forEach items="${dms}" var="dm">
	           <option value="${dm.NDm}">${dm.CMc}</option>
	         </c:forEach>
	     </select>
     </div>
   </div>
   <div id="logicType-210">
   	<div class="form-group">
     <select class="input-sm form-control" id="logicType-210-sel" onchange="changeFun(210);">    
        <option value=" = ">等于</option>
     </select>
     </div>
     <div class="form-group">
	     <select class="input-sm form-control" id="logicType-210-sel-value" onclick="clickFun(210);">
	         <c:forEach items="${dms}" var="dm">
	           <option value="${dm.NDm}">${dm.CMc}</option>
	         </c:forEach>
	     </select>
     </div>
   </div>
</div>
<div id="findConditionFoot" class="bottom-btn-bar">

	<input type="checkbox" id="condition-revers">
	<label class="control-label" for="condition-revers">条件取反</label>
	
	<div class="btn-group">
	   	<button id="findCondition-ok" class="btn btn-primary">
			<span class="glyphicon glyphicon-ok"></span> 确定
		</button>
		<button id="findCondition-cancel" class="btn btn-default">
			<span class="glyphicon glyphicon-remove"></span> 取消
		</button>
	</div>
</div>
