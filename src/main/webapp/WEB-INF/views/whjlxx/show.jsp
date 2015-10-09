<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
   <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
   <script src="/resources/jstree/jquery.jstree.js"></script>
   
   <link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
     #whjlxx_xzfy
     {
         text-align: center;
         padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
		 font-size: 120%;
     }
      #whjlxx_list
      {
         /*height: 470px;
         overflow: auto;*/
      }
      .operationDiv button{
      	 float:right;
      }
   </style>
    <script type="text/javascript">
     $(function(){
         initTable("whjlxx_list");
  
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
  		// 添加奖励
  		$("#whjlxx_add,.dlg_modify").live("click",function(){
  		    var fydm = $(".xzfy_fybh").val();
  			if(fydm == -1)
  				{
  				  alert("请选择要添加奖励的法院！");
  				  return;
  				}
  			var bmbh = $("#select-xzbm option:selected").val();
  			if(bmbh == -1 | bmbh == -2)
  				{
  				  bmbh = "0";
  				}
  			var btnType = $(this).data("btntype");
  			var nid = -1;
  			if(btnType == 2)
  				{
  				  removeSelectTrActive("whjlxx_list");
  				  activeSelectTr($(this));
  				  nid =  $(this).parent().data("nid");
  				  bmbh = $(this).parent().data("bmbh");
  				}
  			$.ajax({
  	   		   url : "/main/dwxx/addJlxxPop.aj",
  	 				type : 'POST',
  	 				dataType : 'html',
  	 				data :{fydm:fydm,bmbh:bmbh,btnType:btnType,nid:nid},
  	 				success : function(html) { 	 				   				  
  	  				   $(".whnsjgJl_dlg").html("").html(html).dialog("open");
  	 				}
  	   	   });
  		});
  		
  		$('.whnsjgJl_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 450,
			width : 400,
			title : '添加机构',
			close:function(){
				// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
			     removeSelectTrActive("whjlxx_list");
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
		// 实现删除功能
		$("#whjlxx_list .i_delete").live('click',function(){
			activeSelectTr($(this));
			var  fydm = $(this).parent().data("fydm");
		    var  nid = $(this).parent().data("nid");
		    
			$(".ex_dlg").html('<p>是否确定删除该数据？</p>').dialog({
				'close':function(){
					removeSelectTrActive("whnsjg");
				},
				'buttons':{
					"确定":function(){
						$.ajax({
							url:'/main/dwxx/deleteJlxx.aj',
							type:"post",
							data:{fydm:fydm,nid:nid},
							dataType:'html',
							success:function(html){
								if(html.trim().match(/^success*/))
							     {
									removeSelectTr($roles_oTable);																								
									$(".ex_dlg").dialog("close");
							     }								
								else
								{							    
								  var sError = "删除操作没有执行成功，请重试或刷新页面！";
								  $(".ex_dlg").children("p").remove();
								  $(".ex_dlg").append('<p class="error">'+ sError + '</p>').dialog({
									  'buttons':{
										  "确定":function(){
											  $(".ex_dlg").dialog("close");
										  }
									  }
								  }).dialog("open");
								}
							}
						});
					},
					"取消":function(){
						$(this).dialog("close");
					}
				}
			}).dialog("open");
		});
     }); // jquery
     var initTable = function(dataTableId){
   	  $roles_oTable=$("#"+dataTableId+" #dataTable").dataTable({
   		   "sPaginationType" : "full_numbers",
   		   "sScrollX" : "100%", // 横向滚动条
		   //"sScrollY" : "300px",
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
   	  	adjustLR("whjlxx_list");
     };
     // 当法院被选择后
     var selectFyAfter = function(){
  	 var fydm = $(".xzfy_fybh").val();
  	 initDataTable(fydm,-1);
     };
     // 当部门被选择后
      var selectBmAfter = function(){
    	  var fydm = $(".xzfy_fybh").val();
    	  var bmbh = $("#select-xzbm option:selected").val();
    	  if(bmbh == -2)
    		  {
    		    bmbh = -1;
    		  }
    	  initDataTable(fydm,bmbh);
      };
     var initDataTable = function(fydm,bmbh){
    	 $("#loadingSpinner").show();
		 $.ajax({
	    	  url:"/main/dwxx/whjlxxDetail.aj",
	    	  type:"POST",
	    	  data:{fydm:fydm,bmbh:bmbh},
	    	  dataType:"json",
	    	  success:function(json){
	    		  
	    		  var html = '<table id="dataTable" data-maxlength="'+json.length+'" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="40px">序号</th><th width="120px">单位名称</th><th width="30px">全院奖励</th><th width="80px">奖励部门</th><th width="140px">集体奖励类别</th><th>奖励名称</th><th width="80px">奖励级别</th><th width="70px">奖励时间</th><th width="70px">操作</th></tr></thead><tbody>';
				  for(var i = 0; i < json.length; i++)
					  {
					    var jlwh = json[i];
					    html += "<tr>";
					    html += '<td class="center">'+(i+1)+'</td>';					   
					    html += '<td class="center">'+jlwh.NFyMc+'</td>';
					    html += '<td class="center">'+jlwh.NQyjl+'</td>';
					    html += '<td class="center">'+jlwh.NJlbmMc+'</td>';
					    html += '<td class="center">'+jlwh.NJtjllbMc+'</td>';
					    html += '<td class="center">'+jlwh.CJlmc+'</td>';
					    html += '<td class="center">'+jlwh.NJljbMc+'</td>';
					    html += '<td class="center">'+jlwh.DJlsjMc+'</td>';
					    html += '<td class="center" data-nid="'+jlwh.NId+'" data-fyDm="'+jlwh.NFy+'" data-bmbh="'+jlwh.NJlbm+'"><a class="dlg_modify" data-btnType="2" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
					    html += "</tr>";											    
					  }
				  html += '</tbody></table>';
				  $("#whjlxx_list  #dataTable_wrapper").remove();
				  $("#whjlxx_list").append(html);
				  initTable("whjlxx_list");
				  $("#loadingSpinner").hide();
	    	  }
	      }); 
	 };
   </script>
</head>
<body>
    <div id="whjlxx_xzfy" class="form-horizontal">
    	<div class="form-group">
    		<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院：</label>
    		<div style="display:inline-block;width:250px;height:30px;">
    			<input type="text" class="xzfy_ipt input-sm form-control"value="请选择一个法院" style="display:inline-block;"/>
    			<input class="xzfy_fybh" name="fybh" value="-1" type="hidden" />
			</div>
		
			<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center">部门：</label>
			<div style="display:inline-block;width:250px;heigth:30px;">
				<select id="select-xzbm" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">请先选择法院</option>
				</select>
			</div>
		</div>
 	</div>
	<div class="operationDiv clearfix">
		<button type="button" class="btn btn-primary" id="whjlxx_add" data-btnType="0">
			<span class="glyphicon glyphicon-plus"></span> 添加奖励
		</button>
	</div>
	<img src="/resources/images/loading.gif" id="loadingSpinner"
		style="display:none;" />
	<div id="whjlxx_list" class="main_list" >
		<table id="dataTable" class="dataTable" cellspacing="0"  width="100%">
			<thead>
				<tr>
					<th width="40px">序号</th>
					<th width="120px">单位名称</th>
					<th width="80px">全院奖励</th>
					<th width="80px">奖励部门</th>
					<th width="100px">集体奖励类别</th>
					<th>奖励名称</th>
					<th width="60px">奖励级别</th>
					<th width="70px">奖励时间</th>
					<th width="80px">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1" isFyAndBm="1"></div>
	<div class="whnsjgJl_dlg"></div>
	<div class="ex_dlg"></div>
</body>
</html>
