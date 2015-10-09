<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
   <script src="/resources/jstree/jquery.jstree.js"></script>	
   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/js/jsMap.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />

<style type="text/css">
#findTabs div.ui-tabs-hide {
	display: none
}
  .ui-button-text-only .ui-button-text
      {
         padding: 0em 0em;
      }
      .ui-dialog .ui-dialog-titlebar
      {
         padding: 0.2em 0.5em;
      }
#columsCanSelectHead,#columsFindHead {
	width: 320px;
	text-align: left;
	padding: 5px 0;
}
#columsCanSelect #se-right,#fi-right
{
  margin-left: 10px;
}
#columsCanSelectedHead{
	width: 280px;
	text-align: left;
	padding: 5px 0;
}
#columsFindConditionHead
{
    width: 340px;
	text-align: left;
	padding: 5px 0;
}

#columsCanSelected select {
	width: 279px;
	height: 400px;
}
#condition-columnsTree
{
  width: 339px;
  height: 305px;
  border-left: 1px solid black;
  border-right: 1px solid black;
  overflow: scroll;
}
 

#columsCanSelect #se-left {
	width: 139px;
	height: 400px;
}
#fi-left
{
    width: 139px;
	height: 340px;
}
#columsCanSelect #se-right {
	width: 167px;
	height: 400px;
}
#fi-right
{
  width: 167px;
  height: 340px;
}

#columsSelectTable {
	
}

#selectButton {
	margin: 0 5px;
}
.condition-none
{
  margin-left: 20px;
}
#resultShow_list
{
  text-align: center;
}

.contentLeftWrap{
	height:650px;
}
.contentRightWrap{
	height:650px;
}
</style>
<script type="text/javascript">
//声明一个可以存放树型ID 的 map，生成不重复的 ID 
 var treeIdMap = new FyrsMap();
	$(function() {
		
		// 声明一个自定义的 map 对象
		var rootMap = new FyrsMap();
		
		//return ;
		$("#findTabs").tabs();
		// 查询出表
		$.ajax({
			url:"/main/cxtj/getTable.aj",
			type:"get",
			data:{},
			dataType:"json",
			success:function(json){
				if(json.length == 0)
					{
					  return;
					}
				
				var html = "";
				var firstTable = json[0];
				html += '<option value="'+json[0].CTablename+'" selected="selected">'+json[0].CCnname+'</option>';
				$("#se-left").html("");
				$("#se-left").html(html);
				for(var i = 1; i < json.length; i++)
					{
					  var ddTable = json[i];
					  html += '<option value="'+ddTable.CTablename+'" data-name ="'+ddTable.CCnname+'">'+ddTable.CCnname+'</option>';
					}
				$("#fi-left").html("");
				$("#fi-left").html(html);
				
				findColumsShow(firstTable.CTablename,firstTable.CCnname);
				findColumsCondtion(firstTable.CTablename,firstTable.CCnname);
			}
		}); // 查询出表
		// 查询出列，可以作用为显示的列
		var findColumsShow = function(tableName,tableNameMc)
		{
			if(rootMap.getFun(tableName) != undefined)
				{
				 
				 $("#se-right").html("");
				 $("#se-right").html(rootMap.getFun(tableName).tUnSelect.listFun());
				  return;
				}
			$.ajax({
				url:"/main/cxtj/getColumsShow.aj",
				type:"POST",
				data:{tableName:tableName},
				dataType:"json",
				success:function(json){
					if(json.length == 0)
						{
						  return;
						}
					var html = "";
					var tableColumn = new TableColumns();
					tableColumn.isLoad = true;
					rootMap.putFun(tableName,tableColumn);
					var tUnSelect = tableColumn.tUnSelect;
					for(var i = 0; i < json.length; i++)
					{
					  var ddField = json[i];
					  var line = '<option value="'+ddField.CFieldname+'"  data-tableName="'+tableName+'"  data-NMaincode="'+ddField.NMaincode+'"  data-tableNameMc="'+tableNameMc+'" data-columnMc="'+ddField.CCnname+'">'+ddField.CCnname+'</option>';
					  tUnSelect.putFun(tableName+"_"+ddField.CFieldname,line);
					  html += line;
					}
					
				    
					$("#se-right").html("");
					$("#se-right").html(html);
					//  选择显示默认显示列
					$("#se-right option").each(function(){
						var va = $(this).val();
						if(va == "N_FY" ||  va == "N_BM" || va == "C_XM" || va == "N_XB" || va == "D_CSRQ" ||va == "N_XZZW" || va == "N_FLZW" || va == "N_ZJ" || va == "N_DJ" )
							{
							  $(this).attr("selected",true);
							}
					});
					btnAddShow();
					//  选择显示默认显示列
				}
			});
		};// 查询出列，可以作用为显示的列
		// 查询出列，可以作为条件的列
		var findColumsCondtion = function(tableName,tableNameMc)
		{
			$.ajax({
				url:"/main/cxtj/getColumsCondtion.aj",
				type:"POST",
				data:{tableName:tableName},
				dataType:"json",
				success:function(json){
					if(json.length == 0)
						{
						  return;
						}
					var html = "";
					
					for(var i = 0; i < json.length; i++)
					{
					  var ddField = json[i];
					  var line = '<option  data-mainCode ="'+ddField.NMaincode+'" value="'+ddField.CFieldname+'"  data-tableName="'+tableName+'"  data-logictype="'+ddField.NLogictype+'" data-datatype="'+ddField.NDatatype+'"  data-tableNameMc="'+tableNameMc+'" >'+ddField.CCnname+'</option>';
					  html += line;
					}
					
					$("#fi-right").html("");
					$("#fi-right").html(html);
				}
			});
		};// 查询出列，可以作为条件的列
		// 禁止选择多行
		$("#fi-right option").live('click',function(){
			$("#fi-right option").each(function(){
				$(this).attr("selected",false);
			});
			$(this).attr("selected",true);
		});
		// 禁止选择多行
		// 点击表事件
		$("#se-left option").live('click',function(){
			$("#se-left option").each(function(){
				$(this).attr("selected",false);
			});
			$(this).attr("selected",true);
			findColumsShow($(this).val(),$(this).text());
		});
		// 点击表事件--条件查询
		$("#fi-left option").live('click',function(){
			$("#fi-left option").each(function(){
				$(this).attr("selected",false);
			});
			$(this).attr("selected",true);
			findColumsCondtion($(this).val(),$(this).text());
		});
		// 添加 
		$("#btnAdd").live('click',function(){
			btnAddShow();
		});
		var btnAddShow = function(){
			if($("#se-right option:selected").length == 0)
				{
				   alert("请选择要显示的字段！");
				   return;
				}
			  
			$("#se-right option:selected").remove().each(function(){
				var tableName = $(this).data("tablename");
				var tableNameMc = $(this).data("tablenamemc");
				var column = $(this).val();
				$(this).text($(this).text()+"【"+tableNameMc+"】");
				$("#selected-columns").append($(this));
				var tableColumn = rootMap.getFun(tableName);
				var tUnSelect = tableColumn.tUnSelect;
				var tSelect = tableColumn.tSelect;
				tUnSelect.deleteFun(tableName+"_"+column);
				tSelect.putFun(tableName+"_"+column,tableColumn);
			});
		};
		// 添加 
		// 全选
		$("#btnAllSelect").live('click',function(){
			if($("#se-right option").length == 0)
				{
				  alert("没有数据要选择");
				  return;
				}
			$("#se-right option").remove().each(function(){
				var tableName = $(this).data("tablename");
				var tableNameMc = $(this).data("tablenamemc");
				var column = $(this).val();
				$(this).text($(this).text()+"【"+tableNameMc+"】");
				$("#selected-columns").append($(this));
				var tableColumn = rootMap.getFun(tableName);
				var tUnSelect = tableColumn.tUnSelect;
				var tSelect = tableColumn.tSelect;
				tUnSelect.deleteFun(tableName+"_"+column);
				tSelect.putFun(tableName+"_"+column,tableColumn);
			});
			
		});
		// 全选
		// 删除 
		$("#btnDelete").live('click',function(){
		    if($("#selected-columns option:selected").length == 0)
		    	{
		    	  alert("请选择要删除的字段！");
		    	  return;
		    	}
			$("#selected-columns option:selected").remove().each(function(){
				var tableName = $(this).data("tablename");
				var tableNameMc = $(this).data("tablenamemc");
				var columnMc = $(this).data("columnmc");
				var nmaincode = $(this).data("nmaincode");
				var column = $(this).val();
				var line = '<option value="'+column+'"  data-tableName="'+tableName+'"  data-nmaincode="'+nmaincode+'" data-tableNameMc="'+tableNameMc+'" data-columnMc="'+columnMc+'" selected="selected">'+columnMc+'</option>';
				//$(this).text($(this).text()+"【"+tableNameMc+"】");
				//$("#selected-columns").append($(this));
				var tableColumn = rootMap.getFun(tableName);
				var tUnSelect = tableColumn.tUnSelect;
				var tSelect = tableColumn.tSelect;
				tUnSelect.putFun(tableName+"_"+column,line);
				tSelect.deleteFun(tableName+"_"+column);
				
			});
			
			findColumsShow($("#se-left option:selected").val(),$("#se-left option:selected").text());
		});
		// 删除
		// 全清
		$("#btnAllClear").live('click',function(){
			if($("#selected-columns option").length == 0)
				{
				  alert("没有需要清除的数据！");
				  return;
				}
			$("#selected-columns option").remove().each(function(){
				var tableName = $(this).data("tablename");
				var tableNameMc = $(this).data("tablenamemc");
				var columnMc = $(this).data("columnmc");
				var nmaincode = $(this).data("nmaincode");
				var column = $(this).val();
				var line = '<option value="'+column+'"  data-tableName="'+tableName+'"  data-nmaincode="'+nmaincode+'"  data-tableNameMc="'+tableNameMc+'" data-columnMc="'+columnMc+'" selected="selected">'+columnMc+'</option>';
				//$(this).text($(this).text()+"【"+tableNameMc+"】");
				//$("#selected-columns").append($(this));
				var tableColumn = rootMap.getFun(tableName);
				var tUnSelect = tableColumn.tUnSelect;
				var tSelect = tableColumn.tSelect;
				tUnSelect.putFun(tableName+"_"+column,line);
				tSelect.deleteFun(tableName+"_"+column);
				
			});
			
			findColumsShow($("#se-left option:selected").val(),$("#se-left option:selected").text());
		});
		// 全清
		// 上移
		$("#btnUp").live("click",function(){
			$("#selected-columns option:selected").each(function(){
				var prev = $(this).prev();
				if(prev.val() == undefined || prev.attr("selected") == "selected")
					{
					  return;
					}
				$(this).insertBefore(prev);
			});
			
		});
		// 上移
		// 下移
		$("#btnDown").live("click",function(){
			var $arr = $("#selected-columns option:selected");
			for(var i = $arr.length - 1; i >= 0; i--)
				{
				   var next = $($arr[i]).next();
				   if(next.val() == undefined || next.attr("selected") == "selected")
					   {
					     continue;
					   }
				   $($arr[i]).insertAfter(next);
				}
			
		});
		// 下移

		// 添加查询条件
		$("#btnAddCondition").click(function(){
			var selectOption = $("#fi-right option:selected");
			if(selectOption.text() == "")
			{
				alert("请选择条件字段！");
				return;
			}
			
			
			var logicType = selectOption.data("logictype");
			var tableNameMc = selectOption.data("tablenamemc");
			var columnNameMc = selectOption.text();
			var mainCode = selectOption.data("maincode");
			$.ajax({
				url:"/main/cxtj/findCondition.aj",
				type:"POST",
				data:{logicType:logicType,tableNameMc:tableNameMc,columnNameMc:columnNameMc,mainCode:mainCode},
				dataType:"html",
				success:function(html){
					if(html != "")
						{
						  $("#findCondition_dlg").html(html).dialog('option','title',columnNameMc+"【"+tableNameMc+"】").dialog('open');
						}
					
				}
			});
			
		});
		// 添加查询条件
		  // 查询条件 dialog
        $('#findCondition_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 350,
				width : 500,
				title : '拥有--角色',
				close:function(){
					
				}
			});
        // 查询条件 dialog
          //  添加checkbox dialog
        $('.checkbox_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 350,
				width : 500,
				title : '',
				close:function(){
					
				}
			});
        // 添加checkbox dialog
        // 修改 sql 语句
         $('.changeSQL_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 350,
				width : 500,
				title : '查询条件修改',
				close:function(){
					
				}
			});   
         $('.dataLoading_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 200,
				width : 300,
				title : '数据正在努力加载......',
				close:function(){
					
				}
			}); 
         $('.sdcxConditionName_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 200,
				width : 300,
				title : '深度查询条件保存',
				close:function(){
					
				}
			});   
         $('.sdcxConditionsShow_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 300,
				width : 500,
				title : '曾用查询条件',
				close:function(){
					
				}
			});
		$('#jbbbxz_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 430,
			width : 500,
			title : '选项选择',
			close : function() {

			}
		});   
        // 查询条件列表
        // 条件切换，删除等
      $("#btn-condition-or").live('click',function(){
    	  var selectedNode = $("#condition-columnsTree a.jstree-clicked").parent().attr("id");
    	  if(!selectedNode.match(/^condition*/))
    		  {
    		    alert("不是或者也不是并且，不能切换");
    		    return;
    		  }
    	  if($.trim($("#"+selectedNode+">a").text())!= "或者")
    		  {
    		    if($("#"+selectedNode).siblings().length == 0)
    		    	{
    		    	    $("#"+selectedNode).attr("data-conditiontype","or");
    	        	    $("#"+selectedNode+">a").text("或者");
    		    	}
    		    else
    		    	{
    		    	  alert("或者节点已经存在，不能再切换");
    		    	}
    		   
    		  }
        });
      $("#btn-condition-and").live('click',function(){
    	  var selectedNode = $("#condition-columnsTree a.jstree-clicked").parent().attr("id");
    	  if(!selectedNode.match(/^condition*/))
    		  {
    		    alert("不是或者也不是并且，不能切换");
    		    return;
    		  }
    	  if($.trim($("#"+selectedNode+">a").text()) != "并且")
    		  {
    		    if($("#"+selectedNode).siblings().length == 0)
    		    	{
    		    	    $("#"+selectedNode).attr("data-conditiontype","and");
    	        	    $("#"+selectedNode+">a").text("并且");
    		    	}
    		    else
    		    	{
    		    	  alert("并且节点已经存在，不能再切换");
    		    	}
    		   
    		  }
      });
     
     
      $("#btn-condition-clear").live('click',function(){
    	  $("#condition-columnsTree ul>li").remove(); 
    	  $("#condition-columnsTree ul>ul").remove(); 
      });
      $("#btn-condition-change").live('click',function(){
    	  var selectedNode = $("#condition-columnsTree a.jstree-clicked").parent().attr("id");
    	  if(!selectedNode.match(/^condition*/))
    		  {
    		    alert("不是或者也不是并且，不能切换");
    		    return;
    		  }
    	  if($("#"+selectedNode).siblings().length == 1)
    		  {
    		    alert("或者，并且都存在，所以不能切换！");
    		    return;
    		  }
    	  if($.trim($("#"+selectedNode+">a").text()) != "并且")
    		  {
    		     $("#"+selectedNode).attr("data-conditiontype","and");
      	         $("#"+selectedNode+">a").text("并且");
    		  }
    	  else
    		  {
    		     $("#"+selectedNode).attr("data-conditiontype","or");
       	         $("#"+selectedNode+">a").text("或者");
    		  }
    	  
    	  
      });
      $("#btn-condition-delete").live('click',function(){
    	  var selectedNode = $("#condition-columnsTree a.jstree-clicked").parent().attr("id");
    	   // 如果只有他自己一个节点
    	   if($("#"+selectedNode).siblings().length == 0 && !$("#"+selectedNode).parent().hasClass("jstree-no-dots jstree-no-icons"))
    		   {
    		     if(selectedNode.match(/^sql*/))
    		     {
    		       $("#"+selectedNode).parent().parent().parent().parent().children("a:first").addClass("jstree-clicked");
    		       $("#"+selectedNode).parent().parent().parent().remove();
    		     }
    		     if(selectedNode.match(/^condition*/))
    		     {
    		        $("#"+selectedNode).parent().parent().children("a:first").addClass("jstree-clicked");
    		        $("#"+selectedNode).parent().remove();     
    		     }  		     
    		   }
    	   else
    		   {
    		      $("#"+selectedNode).parent().parent().children("a:first").addClass("jstree-clicked");
    		      $("#"+selectedNode).remove();	      
    		   }
    	  
      });
        // 条件切换，删除等
      // 根据条件查询
       $("#findCondition").click(function(){
    	   if($("#condition-columnsTree > ul > li").length == 0)
    		   {
    		     alert("请设置查询条件！");
    		     return;
    		   }
    	   if($("#selected-columns option").length == 0)
    		   {
    		     alert("请选择要显示的字段！");
    		   }
    	   // 构造查询条件
    	   var sendSql = '[';
    	   $("#condition-columnsTree li[data-conditiontype]").each(function(){
    		   var nodeId = $(this).attr("id");
    		   // 不应该使用 $(this).data("conditiontype") 可能有缓存作用
    		   var andOr = $(this).attr("data-conditiontype");
    		  
    		   if($("#"+nodeId + " > ul").length >= 1)
    			   {
    			   
        		   $("#"+nodeId + " > ul > li ").each(function(){
        			  sendSql += '{';
        			  sendSql += '"sql":"'+$(this).data("sql")+'",';
        			  sendSql += '"tableName":"'+$(this).data("tablename")+'",';
        			  sendSql += '"parentId":"'+$(this).data("parentid")+'",';
        			  sendSql += '"topId":"'+$(this).data("topid")+'",';
        			  sendSql += '"id":"'+$(this).attr("id")+'",';
        			  sendSql += '"andOr":"'+andOr+'"';
        			  sendSql += '},';
        		   });
        		   
    			   }
    		  
    	   });
    	      var ifOnlyOne = $("#condition-columnsTree ul li:first");
    	      sendSql += '{';
			  sendSql += '"sql":"'+ifOnlyOne.data("sql")+'",';
			  sendSql += '"tableName":"'+ifOnlyOne.data("tablename")+'",';
			  sendSql += '"parentId":"'+ifOnlyOne.data("parentid")+'",';
			  sendSql += '"topId":"'+ifOnlyOne.data("topid")+'",';
			  sendSql += '"id":"'+ifOnlyOne.attr("id")+'",';
			  sendSql += '"andOr":"and"';
			  sendSql += '}';
    	   sendSql += ']';
    	  
    	// 构造查询条件
    	// 构造显示的字段
    	var showColumns = '[';
    	$("#selected-columns option").each(function(){
    		showColumns += '{"columnName":"'+$(this).val()+'",'+'"tableName":"'+$(this).data("tablename")+'",'+'"nmaincode":"'+$(this).data("nmaincode")+'"},';
    	});
    	showColumns = showColumns.substring(0,showColumns.length - 1);
    	showColumns += ']';
    	// 设置提示语
    	$(".dataLoading_dlg").html("").html('<div style=" text-align: center;margin-top: 20px"><img src="/resources/images/loading.gif"/></div>').dialog('open');
    	// 设置提示语
    	// 构造显示的字段
    	   $.ajax({
    		   url:"/main/cxtj/findConditionResult.aj",
    		   type:"POST",
    		   data:{queryData:sendSql,showData:showColumns,ryk:$("#findScope option:selected").val()},
    		   dataType:"json",
    		   success:function(json){
    			   if(json.result != undefined && json.result == "dataTooLong")
    				   {
    				     $(".dataLoading_dlg").dialog('close');
    				     alert("当前查询结果超过了 400 条数据，请重新设置查询条件！");
    				     return;
    				   }
    			   
    			   var html = '<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead">';
				   var headTh = '<th>序号</th>';
				   var jbxxColumnsLength = 0;
    			   $("#selected-columns option").each(function(){
    				   if($.trim($(this).data("tablename")) =="T_RYJBXX")
    					   {
    					     headTh += '<th>'+$(this).data("columnmc")+'</th>'; 
    					     jbxxColumnsLength++;
    					   }
    			   });
    			  
    			   headTh += '<th>报表</th>';
    			   headTh += '<th>操作</th>';
    			   html += headTh;
    			   html += '</tr></thead><tbody>'; 
    			   for(var i = 0; i < json.length; i++)
    				   {
    				     html += '<tr>';
    				     html += '<td>'+(i+1)+'</td>';
    				     var j = 0;
    				     for(j; j < json[i].length - 3; j++)
    				    	 {
    				    	   html += '<td>'+json[i][j]+'</td>';
    				    	 }
    				       
					       html += '<td data-showKey="'+json[i][j+1]+'" data-isOnlyLook="'+json[i][j+2]+'"><a class="i_baobiao_base" data-btnType="2" href="javascript:void(0)">基本</a></td>';
					       if(json[i][j] == '0')
				    	   {
					    	   html += '<td data-showKey="'+json[i][j+1]+'" data-isOnlyLook="'+json[i][j+2]+'"><a class="i_ck" data-btnType="2"  href="javascript:void(0)">查看</a><span>|</span> <a class="i_delete_person" href="javascript:void(0)">删除</a></td>';
				    	   }
					       else
					    	   {
					    	     html += '<td data-showKey="'+json[i][j+1]+'" data-isOnlyLook="'+json[i][j+2]+'"><a class="i_ck"  href="javascript:void(0)">查看</a></td>';
					    	   }
				    	  
    				     html += '</tr>';
    				   }
    			   
					  html += '</tbody></table>';
					  $("#resultShow_list  #dataTable_wrapper").remove();
					  $("#resultShow_list").append(html);
					  $(".dataLoading_dlg").dialog('close');
    		       $("#findTabs a[href=#tabs-result]").trigger('click');
    		       initTable("resultShow_list");
    		   }
    	   });
       });
      // 根据条件查询
      // 处理树型节点
      var $nodeTree = $("#condition-columnsTree").jstree(
    		  {
    			  "themes":{"theme":"classic","dots":false,"icons":false},
    			  "plugins" : [ "themes", "html_data","ui","crrm" ],
    			  "ui":{"initially_select":['condition_rootAnd']}
    		  });
       
      // 处理树型节点
     // 初始化表格
     initTable("resultShow_list");
     // 初始化表格
  // 查看
 	$(".i_ck").live('click',function(){
 	    var showKey = $(this).parent().data("showkey");
 	    var isOnlyLook = $(this).parent().data("isonlylook");
 	    window.open("/ryjbxx.do?showKey="+showKey+"&isOnlyLook="+isOnlyLook);
 	});
   // 保存深度查询条件 
   $("#saveCondition").live('click',function(){
	   if($("#condition-columnsTree > ul > li").length == 0)
	   {
	     alert("没有查询条件需要保存，请设置查询条件！");
	     return;
	   }
	  $(".sdcxConditionName_dlg").html("").html('<div style="margin-top:20px;">条件名称：<input type="text" id="conditionName"></div>').dialog({
		  'buttons':{'确定':function(){
			  var conditionName = $.trim($("#conditionName").val());
			  if(conditionName.length == 0)
				  {
				    alert("条件名称不能为空，请输入条件名称！");
				    return ;
				  }
			  $.ajax({
				   url:"/main/cxtj/saveSdcxCondition.aj",
				   type:"POST",
				   data:{sdcxConditionHtml:$("#condition-columnsTree").html(),conditionName:conditionName,ryk:$("#findScope option:selected").val()},
				   dataType:"html",
				   success:function(html)
				   {
					 if(html == "1")
						 {
						   alert("保存成功！");
						 }
					 else
						 {
						    alert("保存失败！");
						 }
					
				   }
			   });
			  $(".sdcxConditionName_dlg").dialog('close');
		  },'取消':function(){
			  $(".sdcxConditionName_dlg").dialog('close');
		  }}
	  }).dialog('open');
   });
   
   // 曾使用查询条件
	 $("#oldCondition").live('click',function(){
		 $.ajax({
			   url:"/main/cxtj/oldSdcxCondition.aj",
			   type:"POST",
			   data:{},
			   dataType:"html",
			   success:function(html)
			   {
				   $(".sdcxConditionsShow_dlg").html("").html(html).dialog('open');
			   }
		 });
	 });
   //  报表打印
   $(".i_baobiao_base").live("click",function(){
       $.ajax({
										url : "/main/ryxx/jbbbxz.aj",
										type : "post",
										data : {
											'showKey' : $(this).parent().data(
													"showkey"),
											'isOnlyLook' : $(this).parent()
													.data("isonlylook")
										},
										dataType : 'html',
										success : function(html) {
											$("#jbbbxz_dlg").html(html).dialog(
													"open");
										}
									});
   });
   
   	/*active选中的dataTable中的行*/
 		function activeSelectTr($node){
 			// 它只是简单地添加一个  class 作为标识，表示选中一行，也就是在 <tr> 添加  class 属性
 			$node.parent().parent().addClass("active");
 		}
 		/*清除dataTable中选中行的active类*/
 		function removeSelectTrActive(id){
 			// 当窗口关闭时，把添加的  class 属性进行删除
 			$("#"+id+"_list #dataTable tbody .active").removeClass("active");
 		}
 		/*删除选中的dataTable中的行*/
 		function removeSelectTr($oTableLocal){
 			$oTableLocal.fnDeleteRow($oTableLocal.$("tr.active")[0]);
 		}
 		
   //  删除一个人
   $(".i_delete_person").live("click",function(){
      	var showKey = $(this).parent().data("showkey");
    		activeSelectTr($(this));
    		  var temp = $(this);
    		  $(".ex_dlg").html('<p>确定要删除？删除后不能恢复</p>').dialog({
					'close':function(){
					},
					'buttons':{
						"确定":function(){
							 $.ajax({
				    			  url:"/main/cxtj/sdcxDelete.aj",
									type:"post",
									dataType:"html",
									data:{
										showKey:showKey
									},
									success:function(html){								   
										if(html.match(/^success$/))
											{
											removeSelectTr($roles_oTable);
											$(".ex_dlg").dialog("close");
											}
										else if(html.match(/^fail$/))
											{
											  alert("执行不成功，请重新执行");
											  $(".ex_dlg").dialog("close");
											}
										else if(html.match(/^deleteSelf$/))
										{
										      alert("不能删除自己!");
											  $(".ex_dlg").dialog("close");
										}
										else
										{
										    alert("系统错误，请联系管理员!");
											$(".ex_dlg").dialog("close");
										}
									}
				    		  }); // ajax
						},
						"取消":function(){
							$(this).dialog("close");
						}
					}
				}).dialog("open");
   });
	}); // jquery
	var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " #dataTable").dataTable({
			"sPaginationType" : "full_numbers",
			'bFilter' : false,
			'bSort' : false,
			'bLengthChange' : false,
			'oLanguage' : {
				"columnDefs":[{"visible":false,"targets":-1}],
				"sProcessing" : "处理中...",
				"sLengthMenu" : "显示 _MENU_ 项结果",
				"sZeroRecords" : "没有匹配结果",
				"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
				"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
				"sInfoPostFix" : "",
				"sSearch" : "搜索:",
				"sUrl" : "",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "上页",
					"sNext" : "下页",
					"sLast" : "末页"
				}
			},
			'bSortClasses' : false,
			'iDisplayLength' : 10,
			'bRetrieve' : true,
			'bDestory' : true,
			//"sScrollY": "300px",
			"sScrollX" : "100%", // 横向滚动条
		});
	};
	 // 生成一个不重复 ID 函数
    var idGenerator = function(prefix){
  	 var num = 0;
  	 var isExist = true;
  	 var nodeId = "";
  	 // 最多只能生成 100 个节点
  	 do
  		 {
  		   num = Math.ceil(Math.random()*100);
  		   nodeId = prefix+"_"+num;
  		   if(treeIdMap.getFun(nodeId) == undefined || treeIdMap.proptertyLengthFun() == 100)
  			   {
  			     isExist = false;
  			   }   
  		 }while(isExist);
  	 treeIdMap.putFun(nodeId,nodeId);
  	 return nodeId;  	 
    };
</script>
</head>
<body>
	<div id="findTabs">
		<ul>
			<li><a href="#tabs-show">显示设置</a></li>
			<li><a href="#tabs-find">查询设置</a></li>
			<li><a href="#tabs-result">查询结果</a></li>
		</ul>
		<div id="tabs-show">
			<table id="columsSelectTable">
				<tr>
					<td width="300px">
						<div id="columsCanSelect">
							<div id="columsCanSelectHead" class="ui-state-active">待选显示字段</div>
							<select multiple="multiple" id="se-left">
								
							</select> 
							<select multiple="multiple" id="se-right">
								
							</select>
						</div>
					</td>
					<td width="100px" style="text-align: center;">
						<div id="selectButton" class="btn-group-vertical">
							<button id="btnAdd" class="btn btn-sm btn-primary">
								<span class="glyphicon glyphicon-plus"></span> 添加
							</button>
							<button id="btnDelete" class="btn btn-sm btn-danger">
								<span class="glyphicon glyphicon-remove"></span> 删除
							</button>
							<button id="btnAllSelect" class="btn btn-sm btn-default">
								<span class="glyphicon glyphicon-ok"></span> 全选
							</button>
							<button id="btnAllClear" class="btn btn-sm btn-default">
								<span class="glyphicon glyphicon-trash"></span> 全清
							</button>
						</div>
					</td>
					<td style="vertical-align: top;">
					   <div id="columsCanSelected">
						<div id="columsCanSelectedHead" class="ui-state-active">已选显示字段</div> 
						<select
						multiple="multiple" id="selected-columns">
							
					</select>
					</div>
					</td>
					<td width="100px" style="text-align: center;">
						<div id="selectButton" class="btn-group-vertical">
							<button id="btnUp" class="btn btn-sm btn-default">
								<span class="glyphicon glyphicon-arrow-up"></span> 上移
							</button>
							<button id="btnDown" class="btn btn-sm btn-default">
								<span class="glyphicon glyphicon-arrow-down"></span> 下移
							</button>
						</div>						
				</td>
				</tr>
			</table>
		</div>
		<div id="tabs-find">
		            <div>
					       查询范围：人员库：<select style="width: 150px;" id="findScope">
					           <c:forEach items="${ryks}" var="ryk">
                                    <option value="${ryk.NDm}">${ryk.CMc}</option>
                               </c:forEach>
					       </select>
					    </div>
					    <div>
					                 查询条件设置：
					    </div>
		   <table id="columsSelectTable">
				<tr>
					<td width="300px">
					 
						<div id="columsFindCondition">
							<div id="columsFindHead" class="ui-state-active">待选查询条件</div>
							<select multiple="multiple" id="fi-left">
								
							</select> 
							<select multiple="multiple" id="fi-right">
								
							</select>
						</div>
					</td>
					<td width="80px" style="text-align: center;">
						<div id="findButton">
							<button id="btnAddCondition" class="btn btn-sm btn-primary">
								<span class="glyphicon glyphicon-plus"></span> 添加
							</button>
							<br>
						</div>
					</td>
					<td style="vertical-align: top">
					   <div id="columsFindSe">
						<div id="columsFindConditionHead" class="ui-state-active">已选查询条件</div> 
						<div id="condition-columnsTree" roleAdd="">
						    
						</div>
					</div>
					<div id="columsFindConditionHead" class="ui-state-active">&nbsp;&nbsp;&nbsp;&nbsp;<span id="btn-condition-or">或者</span>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<span id="btn-condition-and">并且</span>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<span id="btn-condition-change">切换</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="btn-condition-clear">全清</span>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<span id="btn-condition-delete">删除</span></div> 
					</td>
					
				</tr>
			</table>
			<div id="condition" class="btn-group">
				<button id="saveCondition" class="btn btn-success btn-sm">
					<span class="glyphicon glyphicon-save"></span> 保存条件
				</button>
				<button id="findCondition" class="btn btn-primary btn-sm">
					<span class="glyphicon glyphicon-search"></span> 查询
				</button>
				<button id="oldCondition" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-bookmark"></span> 曾用查询
				</button>
			</div>
		</div>
		<div id="tabs-result">
		   <div id="resultShow_list" class="main_list">
		     <table id="dataTable" data-maxindex="${roles.size()}" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead"><th class="sorting_disabled">序号</th><th class="sorting_disabled">法院</th><th class="sorting_disabled">姓名</th><th class="sorting_disabled">性别</th><th class="sorting_disabled">部门</th><th class="sorting_disabled">出生日期</th><th class="sorting_disabled">行政职务</th><th class="sorting_disabled">法律职务</th><th class="sorting_disabled">职级</th><th class="sorting_disabled">等级</th><th class="sorting_disabled">报表</th><th class="sorting_disabled">操作</th></tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	       </div>
		</div>
	</div>
	<div id="findCondition_dlg"></div><div class="checkbox_dlg"></div><div class="changeSQL_dlg"></div><div class="dataLoading_dlg"></div><div class="sdcxConditionName_dlg"></div><div class="sdcxConditionsShow_dlg"></div>
    <div id="jbbbxz_dlg"></div>
    <div class="ex_dlg"></div>
</body>
</html>
