<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
        #xtrz-head
        {
        	padding: 15px 0;
	        background-color: #EEF7FD;
			border-bottom: 2px solid #96C8EB;
			margin-bottom: 5px;
			color: #166092;
			font-size: 110%;
        }
   </style>
   <script type="text/javascript">
     $(function(){
    	 $("#endTime").datepicker();
    	 // 设置时间段
    	 $("#operBeginTime").datepicker({
    		 showButtonPanel:false,
    		 onSelect:function(selectedDate)
    		 {
    			 $("#endTime").datepicker("option","minDate",selectedDate);
    		 }
    	 }); // 设置时间段
    	 
    	 initTable("xtrz_list");
    	 $("#find_btn_xtrz").click(function(){
    		var value = {operUser:$("#operUser").val(),operBeginTime:$("#operBeginTime").val(),operEndTime:$("#endTime").val(),operType:$("#operType option:selected").val()};
    		$.ajax({
    			url : "/main/xtgl/xtrzFind.aj",
				  type : 'post',
				  dataType : 'json',
				  data :value,
				  success:function(json)
				  {
					  var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="60px">序号</th><th width="120px">操作用户</th><th width="140px">操作时间</th><th>操作内容</th><th width="140px">用户IP</th></tr></thead><tbody>';
					  for(var i = 0; i < json.length; i++)
						  {
						    var log = json[i];
						    html += "<tr>";
						    html += '<td class="center">'+(i+1)+'</td>';
						    html += '<td class="center">'+log.CCzyh+'</td>';
						    html += '<td class="center">'+log.DCzsj+'</td>';
						    html += '<td class="center">'+log.CCznr+'</td>';
						    html += '<td class="center">'+log.CIp+'</td>';
						    html += "</tr>";
						  }
					  html += '</tbody></table>';
					  // $("#qxgl_list #dataTable").remove();
					  $("#xtrz_list  #dataTable_wrapper").remove();
					  $("#xtrz_list").append(html);
					  initTable("xtrz_list");
				  }
				  
    		});
    	 });
    	 
     }); // jquery
     var initTable = function(dataTableId){
   	  $roles_oTable=$("#"+dataTableId+" #dataTable").dataTable({
   		   "sPaginationType" : "full_numbers",
   		   'bFilter' : false,
           'bSort' : false,
           'bLengthChange' : false,
 			'oLanguage' : {
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
           'bRetrieve':true,
           'bDestory':true
 		});
     }
   </script>
</head>
<body>
    <div id="xtrz-head" class="form-horizontal">
			<div class="form-group">
			    <label class="control-label" for="operUser" style="display:inline-block;width:100px;height:24px;text-align:center;">操作用户：</label>
			    <div style="display: inline-block;width:200px;heigth:30px;">
			    	<input class="input-sm form-control" type="text" name="operUserName" id="operUser" style="display:inline-block;"/>
			    </div>
			    
			    <label class="control-label" for="operBeginTime" style="display:inline-block;width:90px;height:24px;text-align:center;">操作时间：</label>
			    <div style="display:inline-block;">
	    			<div class="input-group" style="display:inline-table;width:300px;height:30px;top:10px;">
	    				<input class="input-sm form-control" type="text" name="" id="operBeginTime">
	    				<span class="input-group-addon">至</span>
	    				<input class="input-sm form-control" type="text" id="endTime" />
	    			</div>
    			</div>
			</div>
    			
    		<div class="form-group">
    			<label class="control-label" for="operType" style="display:inline-block;width:100px;height:24px;text-align:center;">操作类型：</label>
    			<div style="display:inline-block;width:200px;height:30px;">
	    			<select class="input-sm form-control" id="operType" style="display:inline-block;">
	    				<option value="">全部</option>
	    				<option value="1">修改</option>
	    				<option value="2">清空</option>
	    				<option value="3">登录系统</option>
	    			</select>
    			</div>
    			
    			<div style="display:inline-block;float:right;margin-right:80px;">
					<button type="button" class="btn btn-primary" id="find_btn_xtrz" style="display:inline-block;">
						<span class="glyphicon glyphicon-search"></span> 查询
					</button>	
				</div>
    		</div>
		</div>
	<div id="xtrz_list" class="main_list">
		<table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th width="60px">序号</th>
					<th width="120px">操作用户</th>
					<th width="140px">操作时间</th>
					<th>操作内容</th>
					<th width="140px">用户IP</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>
