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
   
      #whnsjg_xzfy{
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
         initTable("whnsjg_list");
    	// initDataTable();
    	 
    	   // 点击触发事件 
    	  $('.xzfy_ipt').click(function() {
  			$.ajax({
  				url : "/xzfyBmShow.aj",
  				type : 'post',
  				dataType : 'html',
  				data : {},
  				success : function(html) {
  				    $('.xzfy_dlg').html(html).dialog('open');
  				}
  			});
  		}); // 获得法院
  		
  		//添加机构
  		$("#whnsjg_add,.dlg_modify").live('click',function(){
  			var titles = ["添加机构","","编辑内设机构"];
  			var fydm = $(".xzfy_fybh").val();
  			if(fydm == -1)
  				{
  				  alert("请选择一个法院或部门！");
  				  return;
  				}
  			var lvlevel = $(".xzfy_bmbh").attr("level");
  			
  			if(lvlevel != "" && lvlevel.substring(8,12) != "0000")
  				{
  				   alert("已经是最后一个子机构，不能再添加");
  				   return;
  				}
  			var bmbh = $(".xzfy_bmbh").val();
  			var btnType = $(this).attr("data-btnType");
  			var nlevel = "";
  			var isOnlyBm = 1;
  			alert(btnType);
  			if(btnType != 0)
  				{
  				  activeSelectTr($(this));
  				}
  			
  			// 选择了法院
  			if($(".xzfy_bmbh").attr("level") == "")
  				{
  				  isOnlyBm = 0;
  				}
  			// 选择了部门
  			else
  				{
  				  
  				}
  			if(btnType == 2)
  				{
  				  fydm = $(this).parent().data("fydm");
  				  bmbh = $(this).parent().data("bmbh");
  				  nlevel = $(this).parent().data("nlevel");
  				  if(nlevel == 1)
  					  {
  					    isOnlyBm = 0;
  					  }
  				  
  				}
  			
  			$.ajax({
  			   url:"/main/dwxx/whnsjgBmPop.aj",
  			   type:"POST",
  			   data:{isOnlyBm:isOnlyBm,nlevel:nlevel,fydm:fydm,btnType:btnType,bmbh:bmbh,lvlevel:lvlevel},
  			   dataType:"html",
  			   success:function(html){
  				   $(".whnsjg_dlg div").remove();
  				   $(".whnsjg_dlg").html(html).dialog("option","title",titles[btnType]).dialog("open");
  			   }	   
  			});
  		}); // add
  	// 实现删除功能
		$("#whnsjg_list .i_delete").live('click',function(){
			activeSelectTr($(this));
			var  fydm = $(this).parent().data("fydm");
		    var  bmbh = $(this).parent().data("bmbh");
		    
			$(".ex_dlg").html('<p>是否确定删除该数据？</p>').dialog({
				'close':function(){
					removeSelectTrActive("whnsjg");
				},
				'buttons':{
					"确定":function(){
						$.ajax({
							url:'/main/dwxx/whnsjgDeleteBm.aj',
							type:"post",
							data:{fydm:fydm,bmbh:bmbh},
							dataType:'json',
							success:function(json){
								if(json == "1")
							     {
									removeSelectTr($whnsjg_oTable);									
									if(!$(".xzfy_bmbh").val().trim() == "")
										{
										  $(".xzfy_ipt").val("请选择一个法院或部门");
										  $(".xzfy_fybh").val("-1");
										}								
									$(".ex_dlg").dialog("close");
							     }
								else if(json == "-1")
									{
									  var sError = "该机构有子机构，或机构已经添加人员，不能删除！";
									  $(".ex_dlg").children("p").remove();
									  $(".ex_dlg").append('<p class="error">'+ sError + '</p>').dialog({
										  'buttons':{
											  "确定":function(){
												  $(".ex_dlg").dialog("close");
											  }
										  }
									  }).dialog("open");
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
  		$('.whnsjg_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 400,
			width : 400,
			title : '添加机构',
			close:function(){
				// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
			    removeSelectTrActive("whnsjg");
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
   	  $whnsjg_oTable=$("#"+dataTableId+" #dataTable").dataTable({
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
   	  	adjustLR("whnsjg_list");
     };
     var selectFyOrBmAfter = function(){
  	   var fydm = $(".xzfy_fybh").val();
  	   var bm = $(".xzfy_bmbh").val();
  	   initDataTable(fydm,bm);
     };
     var initDataTable = function(fydm,bmbh){
		 $.ajax({
	    	  url:"/main/dwxx/whnsjgDetail.aj",
	    	  type:"POST",
	    	  data:{fydm:fydm,bmbh:bmbh},
	    	  dataType:"json",
	    	  success:function(json){
	    		  var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="150px">单位</th><th width="150px">部门</th><th width="80px">最高领导职务</th><th width="150px">标准名称</th><th width="150px">部门性质</th><th width="100px">操作</th></tr></thead><tbody>';
				  for(var i = 0; i < json.length; i++)
					  {
					    var jgxx = json[i];
					    html += "<tr>";
					    html += '<td class="center">'+jgxx.NFy+'</td>';
					    html += '<td class="center">'+jgxx.CName+'</td>';
					    html += '<td class="center">'+jgxx.NZgldzw+'</td>';
					    html += '<td class="center">'+jgxx.CStname+'</td>';	
					    html += '<td class="center">'+jgxx.NBmxz+'</td>';
					    html += '<td class="center" data-nlevel = "'+jgxx.NLevel+'" data-fyDm="'+jgxx.fydm+'" data-bmbh="'+jgxx.NCode+'"><a class="dlg_modify" data-btnType="2" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
					    html += "</tr>";											    
					  }
				  html += '</tbody></table>';
				  $("#whnsjg_list  #dataTable_wrapper").remove();
				  $("#whnsjg_list").append(html);
				  initTable("whnsjg_list");
	    	  }
	      }); 
	 };
   </script>
</head>
<body>
 <div id="whnsjg_xzfy" class="form-horizontal">
 		<div class="form-group">
 			<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院或部门：</label>
 			<div style="display:inline-block;width:250px;height:30px;">
	 			<input type="text" class="xzfy_ipt form-control" value="请选择一个法院或部门" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="-1" type="hidden" />
				<input class="xzfy_bmbh" name="bmbh" value="" type="hidden"  level=""/>
			</div>
		</div>
 </div>
 <div class="operationDiv clearfix">
 	<button type="button" class="btn btn-primary" id="whnsjg_add" data-btnType="0">
		<span class="glyphicon glyphicon-plus"></span> 添加
	</button>
 </div>
	<div id="whnsjg_list">
		<table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="150px">单位</th>
					<th width="150px">部门</th>
					<th width="80px">最高领导职务</th>
					<th>标准名称</th>
					<th>部门性质</th>
					<th width="100px">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="0" isFyAndBm="0"></div>
	<div class="whnsjgJl_dlg"></div>
	<div class="ex_dlg"></div>
</body>
</html>
