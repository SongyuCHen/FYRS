<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
   <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
   <script src="/resources/jstree/jquery.jstree.js"></script>

   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
   <style type="text/css">
   
      #gzlgl_xzfy{
        padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
		font-size: 120%;
		text-align:center;
      }
      .operationDiv button{
      	float:right;
      }
      
   </style>
   <script type="text/javascript">
     $(function(){
         initTable("gzlgl_list");
    	// initDataTable();
    	 
    	   // 点击触发事件 
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
  		}); // 获得法院
  		
  		
  		$('.gzlgl_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 400,
			width : 400,
			title : '',
			close:function(){
				// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
			    removeSelectTrActive("gzlgl");
			}
		}); // dialog
		
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
		
     }); // jquery
     var initTable = function(dataTableId){
   	  $yjgl_oTable=$("#"+dataTableId+" #dataTable").dataTable({
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
     };
     var selectFyAfter = function(){
  	   var fydm = $(".xzfy_fybh").val();
  	   initDataTable(fydm);
     };
     var initDataTable = function(fydm){
		 $.ajax({
	    	  url:"/main/gzlgl/gzlglDetail.aj",
	    	  type:"POST",
	    	  data:{fydm:fydm},
	    	  dataType:"json",
	    	  success:function(json){
	    		  var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><tr><th width="150px">编号</th><th width="150px">工作流名称</th><th width="80px">创建时间</th><th>创建者</th><th>最近修改时间</th><th width="100px">修改者</th><th>运行状态</th></tr></thead><tbody>';
				  for(var i = 0; i < json.length; i++)
					  {
					    var yjxx = json[i];
					    html += "<tr>";
					    html += '<td class="center">'+(i+1)+'</td>';
					    html += '<td class="center">'+yjxx.CXm+'</td>';
					    html += '<td class="center">'+yjxx.CBm+'</td>';
					    html += '<td class="center">'+yjxx.CYjsx+'</td>';
					    html += '<td class="center">'+yjxx.DYjsj+'</td>';	
					    html += '<td class="center">'+yjxx.CBz+'</td>';
					    html += '<td class="center" data-fyDm="'+yjxx.fydm+'"><a class="dlg_modify" data-btnType="2" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
					    html += "</tr>";											    
					  }
				  html += '</tbody></table>';
				  $("#gzlgl_list  #dataTable_wrapper").remove();
				  $("#gzlgl_list").append(html);
				  initTable("gzlgl_list");
	    	  }
	      }); 
	 };
   </script>
</head>
<body>
 <div id="gzlgl_xzfy" class="form-horizontal">
 		<div class="form-group">
 			<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院或部门：</label>
 			<div style="display:inline-block;width:250px;height:30px;">
	 			<input type="text" class="xzfy_ipt form-control" value="请选择一个法院或部门" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="-1" type="hidden" />
			</div>
		</div>
 </div>
 <div class="operationDiv clearfix">
 	<button type="button" class="btn btn-primary" id="gzlgl_add" data-btnType="0">
		<span class="glyphicon glyphicon-plus"></span> 添加员工条目
	</button>
 </div>
	<div id="gzlgl_list">
		<table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr>
				   <th>编号</th>
				    <th>工作流名称</th>
					<th>创建时间</th>
					<th>创建者</th>
					<th>最近修改时间</th>
					<th>修改者</th>
					<th>运行状态</th>					
					<th width="100px">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="0" isFyAndBm="0"></div>
	<div class="gzlgl_dlg"></div>
	<div class="ex_dlg"></div>
</body>
</html>

