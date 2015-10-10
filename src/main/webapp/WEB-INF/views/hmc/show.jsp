<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
     <script src="/resources/jstree/jquery.jstree.js"></script>
     <script type="text/javascript" src="/resources/js/jsMap.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" /> 
	<style>
	#rylh-head
      {
       padding: 15px;
	margin-bottom: 50px;
	color: black;
	background-color:#EDEDED;
		font-size: 120%;
      }
      #columsSelectTable {
	
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
#columsCanSelected select {
	width: 279px;
	height: 400px;
}
#columsCanSelect #se-left {
	width: 139px;
	height: 400px;
}
#columsCanSelect #se-right {
	width: 167px;
	height: 400px;
}

#hmc_list
{

}

.contentLeftWrap{
	height:650px;
}

.contentRightWrap{
	height:650px;
}
	</style>
	<script type="text/javascript">
	 var headTh = "";
	 var tableTitle = "";
	  $(function(){
		  $('#dbTab a[href="#hmcShowItemSelected"]').tab('show');
		  
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
					// findColumsCondtion(firstTable.CTablename,firstTable.CCnname);
				}
			}); // 查询出表
			// 声明一个自定义的 map 对象
			var rootMap = new FyrsMap();
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
		
			 // 点击触发事件 ,选择法院
	  	  $('.xzfy_ipt').click(function() {
				$.ajax({
					url : "/xzfyShow.aj",
					type : 'post',
					dataType : 'html',
					data : {},
					success : function(html) {
					    $('.xzfy_dlg').html(html).dialog('open');
					}
				});
			});
		// 初始化表格
	  	initTable("hmc_list");
		// 生成花名册
		$("#hmc_ge").click(function(){
			 var selectValue = $("#select-xzbm option:selected").attr("value");
		  	  if(-1 == selectValue || (1 == selectValue && $(".xzfy_fybh") == -1))
		  		  {
		  		     alert("请选择一个部门,查询出结果再打印！");
		  		     return;
		  		  }
		  	tableTitle = $.trim($(".xzfy_ipt").val())+$.trim($("#select-xzbm option:selected").text())+"花名册";
			window.open("hmcresult.do");
		});
	  }); // jquery
	  // 当部门被选择时
	    var selectBmAfter = function(){
	  	  var selectValue = $("#select-xzbm option:selected").attr("value");
	  	  if(-1 == selectValue)
	  		  {
	  		     alert("请选择一个部门");
	  		     return;
	  		  }
	      showLoading();
	  	  var selKu = $("#rylh-head-ku option:selected").val();
	  	 // 构造显示的字段
    	var showColumns = '[';
    	$("#selected-columns option").each(function(){
    		showColumns += '{"columnName":"'+$(this).val()+'",'+'"tableName":"'+$(this).data("tablename")+'",'+'"nmaincode":"'+$(this).data("nmaincode")+'"},';
    	});
    	showColumns = showColumns.substring(0,showColumns.length - 1);
    	showColumns += ']';
    	 // 构造显示的字段
	  	 $.ajax({
		      url : "/main/ryxx/getHmcList.aj",
			  type : 'post',
			  dataType : 'json',
			  data : {'fyDm':$(".xzfy_fybh").val(),'bmDm':$("#select-xzbm option:selected").attr("value"),'ku':selKu,showColumns:showColumns},
			  success:function(json){	
				  
				  var html = '<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead">';
				  headTh = '<th>序号</th>';
				  var jbxxColumnsLength = 0;
   			   $("#selected-columns option").each(function(){
   				   if($.trim($(this).data("tablename")) =="T_RYJBXX")
   					   {
   					     headTh += '<th>'+$(this).data("columnmc")+'</th>'; 
   					     jbxxColumnsLength++;
   					   }
   			   });
   			     			
   			   html += headTh;
   			   html += '</tr></thead><tbody>'; 
   			   for(var i = 0; i < json.length; i++)
   				   {
   				     html += '<tr>';
   				     html += '<td>'+(i+1)+'</td>';
   				     var j = 0;
   				     for(j; j < json[i].length; j++)
   				    	 {
   				    	   html += '<td>'+json[i][j]+'</td>';
   				    	 }  				       		    	  
   				     html += '</tr>';
   				   }
   			   
					  html += '</tbody></table>';
					  $("#hmc_list  #dataTable_wrapper").remove();
					  $("#hmc_list").append(html);					  
   		              initTable("hmc_list");			              	
   		              hiddenLoading();		  				
			  }
	  	 });
	 };
	 
	 // 初始化表格
	 var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " #dataTable").dataTable({
			"sPaginationType" : "full_numbers",
			'bFilter' : true,
			'bSort' : false,
			'bLengthChange' : false,
			"bAutoWidth": true,
			'oLanguage' : {
				"columnDefs":[{"visible":false,"targets":-1}],
				"sProcessing" : "处理中...",
				"sLengthMenu" : "显示 _MENU_ 项结果",
				"sZeroRecords" : "没有匹配结果",
				"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
				"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
				"sInfoPostFix" : "",
				"sSearch" : "",
				"sUrl" : "",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "上页",
					"sNext" : "下页",
					"sLast" : "末页"
				}
			},
			'bSortClasses' : false,
			'iDisplayLength' : 8,
			'bRetrieve' : true,
			'bDestory' : true
		});
		//adjustLR("hmc_list");
		//搜索框中摆个放大镜
		$("#dataTable_filter").append("<div class='searching-icon'><span class='glyphicon glyphicon-search'></span></div>");
	};
	</script>
</head>
<body>
     <ul id="dbTab" class="nav nav-tabs" role="tablist">
      <li>
		<a href="#hmcShowItemSelected" role="tab" data-toggle="tab">
			<span class="glyphicon glyphicon-th-list"></span> 花名册列选择
		</a>
      <li>
		<a href="#hmcShow" role="tab" data-toggle="tab">
			<span class="glyphicon glyphicon-cloud-upload"></span> 花名册显示
		</a>
	</li>
    </ul>
     
<div class="tab-content">
   <div class="tab-pane" id="hmcShowItemSelected">
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
					<td style="vertical-align: top">
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
   <div class="tab-pane" id="hmcShow">
        <div id="rylh-head" class="form-horizontal">
     	<div class="row">
	     	<div class="col-sm-6 col-md-6 form-group" style="display:inline-block;width:350px;">
		     <label class="col-sm-3 col-md-3 control-label" style="display: inline-block;width: 90px;height: 27px;text-align:right;">所在库:</label>
		     <div class="col-sm-9 col-md-9" style="display: inline-block;width: 200px;height: 30px;">
			     <select class="input-sm form-control" id="rylh-head-ku">
			         <c:forEach items="${kus}" var="ku">
			         <option value="${ku.NDm}">${ku.CMc}</option>
			      </c:forEach>
			     </select>
			  </div>
	     	</div>
	     	<div class="col-sm-6 col-md-6 form-group" style="display:inline-block;width:350px;">
	     		<label class="col-sm-3 col-md-3 control-label" style="display: inline-block;width: 90px;height: 27px;text-align:right;">法院：</label>
	     		<div class="col-sm-9 col-md-9" style="display: inline-block;width: 200px;height: 30px;">
		     		<input class="input-sm form-control xzfy_ipt" type="text"
									value="请选择一个法院" />
					<input class="input-sm form-control xzfy_fybh" name="fybh"
									value="-1" type="hidden" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 col-md-6 form-group" style="display:inline-block;width:350px;">
				<label class="col-sm-3 col-md-3 control-label" style="display: inline-block;width: 90px;height: 27px;text-align:right;">部门：</label>
				<div class="col-sm-9 col-md-9" style="display: inline-block;width: 200px;height: 30px;">
					<select class="input-sm form-control" id="select-xzbm">
						<option value="1">请先选择法院</option>
					</select>
				</div>
			</div>
			
			<div id="hmc_ge_span" class="col-sm-3 col-md-3" style="display:inline-block;">
				
				<button type="button" class="btn btn-primary" id="hmc_ge">
					<span class="glyphicon glyphicon-print"></span> 生成花名册
				</button>
			</div>
		</div>
  </div>
	<div id="hmc_list">
	  <div id="loading" class="element-display-none"><img src='/resources/images/loading.gif'/></div>
	   <table id="dataTable" class="dataTable" width="100%">
	      <thead>
				<tr class="tableHead">
				    <th width="80px">序号</th>
					<th width="140px">姓名</th>
					<th width="80px">性别</th>
					<th width="80px">年龄</th>
					<th width="160px">行政职务</th>
					<th width="160px">法律职务</th>
					<th width="120px">法官等级</th>
					<th width="100px">职级</th>
					<th width="140px">学历</th>					
				</tr>
			</thead>
			<tbody>
			   
			</tbody>
	   </table>
	</div>
	
   </div>
</div>     
     
   
  <div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1" isFyAndBm="0"></div>
</body>
</html>
