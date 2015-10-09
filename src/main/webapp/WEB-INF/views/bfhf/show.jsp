<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
    <style type="text/css">
    	.tab-pane{
    		padding: 15px;
    	}
      .nav li{
      	font-size: 16px;
      }
      #editWdForm{
        text-align: center;
        padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
		font-size: 110%;
     }
     
     .contentLeftWrap{
     	height:650px;
     }
     .contentRightWrap{
     	height:650px;
     }
   </style>
   <script type="text/javascript">
     $(function(){
         var handLoading = false;
    	 $('#dbTab a[href="#autoBackup"]').tab('show');
    	 
    	 initTable("dataBackup_list");
    	 // 恢复事件
    	 $("#bfhf_ok").live('click',function(){
    		 var frequency = $("#frequency_backup option:selected").val();
    		 var backupNum = $("#backup_num option:selected").val();  		
    		 var nid = $("#frequency_backup").data("nid");
    		 $.ajax({
    			 url : "/main/xtgl/bfConfiguration.aj",
   				type : 'POST',
   				dataType : 'html',
   				data : {frequency:frequency,backupNum:backupNum,nid:nid},
   				success:function(html){
   					if(html.match(/^success*/))
   						{
   						  alert("保存配置成功！");
   						}
   					else
   						{
   						alert("保存失败，请重新保存！");
   						}
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
    	 // 实现删除功能
    	 $("#dataBackup_list .i_delete").click(function(){
    		 activeSelectTr($(this));
 		    var  nid = $(this).parent().data("nid");
 		    
 			$(".ex_dlg").html('<p>是否确定删除该数据？</p>').dialog({
 				'close':function(){
 					removeSelectTrActive("dataBackup_list");
 				},
 				'buttons':{
 					"确定":function(){
 						$.ajax({
 							url:'/main/xtgl/deleteBackup.aj',
 							type:"post",
 							data:{nid:nid},
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
    	$("#bfh_btn_hand").click(function(){
    	   $("#bfh_btn_hand").html('<span class="glyphicon glyphicon-ok"></span> 正在手动备份请等待!');
    	   if(handLoading)
    	   {
    	     alert("正在备份请等待!");
    	     return;
    	   }
    	   handLoading = true;
    	   $('.wait_hand_dlg').dialog('open');
    	   $.ajax({
    	      url:'/main/xtgl/backuphand.aj',
 							type:"post",
 							data:{},
 							dataType:'html',
 							success:function(html){
 							    handLoading = false;
 							    $('.wait_hand_dlg').dialog('close');
 							    $("#bfh_btn_hand").html('<span class="glyphicon glyphicon-ok"></span> 手动备份');
 							     if(html.match(/^success$/))
 							    {
 							       alert("手动备份成功!");
 							    }
 							    else if(html.match(/^fail$/))
 							    {
 							       alert("手动备份失败，请稍后再试！!");
 							    }
 							    else
 							    {
 							      alert("系统错误，请联系管理员!");
 							    }
 							}
    	   });
    	});
    	
    	
     var isGenering = false;
     $(".dlg_recover_backup,.dlg_recover_normal").live("click",function(){
        var backType = $(this).data("backtype");
        var nid = $(this).parent().data("nid");
         if(isGenering)
         {
           alert("系统正在重新生成备份库，请耐心等待！");
           return;
         }
         isGenering = true;
         $('.wait_hand_dlg').dialog('open');
         $(".wait_dlg").dialog('option','title',"正在"+$(this).text()+",请稍候！").dialog('open');
          $.ajax({
    	      url:"/main/xtgl/usedatabaseupOnline.aj",
 							type:"POST",
 							data:{backType:backType,nid:nid},
 							dataType:'html',
 							success:function(html){
 							    isGenering = false;							    
 							    $(".wait_dlg").dialog('close');
 							    if(html.match(/^success$/))
 							    {
 							       alert("系统恢复成功!");
 							    }
 							    else if(html.match(/^fail$/))
 							    {
 							       alert("系统恢复失败，请稍后再试！!");
 							    }
 							    else
 							    {
 							      alert("系统错误，请联系管理员!");
 							    }
 							}
    	   });
     });
     //  提醒 dialog
      $('.wait_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 200,
				width : 250,
				title : '正在加载，请稍候！',
				close:function(){
					
				},
				open:function(event,ui)
				{
				  $(".ui-dialog-titlebar-close",$(this).parent()).hide();
				}
			});
	   //  提醒 dialog
      $('.wait_hand_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 200,
				width : 250,
				title : '正在手动备份数据库，请稍候！',
				close:function(){
					
				},
				open:function(event,ui)
				{
				  $(".ui-dialog-titlebar-close",$(this).parent()).hide();
				}
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
        };
   </script>
</head>
<body>

<ul id="dbTab" class="nav nav-tabs" role="tablist">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" role="tab" data-toggle="dropdown">
			<span class="glyphicon glyphicon-briefcase"></span> 数据备份<span class="caret"></span>
		</a>
		<ul class="dropdown-menu" role="menu">
			<li>
				<a href="#autoBackup" role="tab" data-toggle="tab">
					<span class="glyphicon glyphicon-cog"></span> 自动备份
				</a>
			</li>
			<li>
				<a href="#manualBackup" role="tab" data-toggle="tab">
					<span class="glyphicon glyphicon-user"></span> 手动备份
				</a>
			</li>
		</ul>
	</li>
	<li>
		<a href="#uploadFile" role="tab" data-toggle="tab">
			<span class="glyphicon glyphicon-cloud-upload"></span> 备份文件上传
		</a>
	</li>
</ul>
<div class="tab-content">
  <div class="tab-pane" id="autoBackup">
      <div class="form-horizontal" style="text-align:center;">
      	<div class="form-group">
      		<label class="control-label" style="display:inline-block;width:120px;height:24px;text-align:center;">备份频率：</label>
      		<div style="display:inline-block;width:250px;height:30px;">
      			<select class="form-control" name="frequency" id="frequency_backup" data-nid="${plan.NId}" style="display:inline-block;">
					<option value="1" <c:if test="${plan.NFrequency eq 1}">selected="selected"</c:if>>每天</option>
					<option value="2" <c:if test="${plan.NFrequency eq 2}">selected="selected"</c:if>>每周</option>
					<option value="3" <c:if test="${plan.NFrequency eq 3}">selected="selected"</c:if>>每月</option>
				</select>
      		</div>
      	</div>
      	<div class="form-group">
      		<label class="control-label" style="display:inline-block;width:120px;height:24px;text-align:center;">系统保留自动备份数：</label>
      		<div style="display:inline-block;width:250px;height:30px;">
      			<select class="form-control" id="backup_num" style="display:inline-block;">
          			<c:forEach begin="1" end="10" step="1" var="i" >
          			<option value="<c:out value="${i}"/>" <c:if test="${plan.NBlfs eq i}">selected="selected"</c:if>><c:out value="${i}"/></option>
          			</c:forEach>
          		</select>
      		</div>
      	</div>
      	<div class="form-group">
      		<div class="col-sm-6 col-md-6 col-sm-offset-3 col-md-offset-3">
	      		<button class="btn btn-primary" id="bfhf_ok">
	      			<span class="glyphicon glyphicon-floppy-disk"></span> 保存配置
	      		</button>
      		</div>
      	</div>
      </div>
  </div>
  <div class="tab-pane" id="manualBackup">
      <div class="form-horizontal">
      	<div class="form-group">
      		<div class="alert alert-info" role="alert">
      			<p>手动备份的备份文件系统不会自动删除!</p>
      		</div>
      	</div>
     	<div class="form-group">
      		<button class="btn btn-primary center-block" id="bfh_btn_hand">
      			<span class="glyphicon glyphicon-ok"></span> 手动备份
      		</button>
     	</div>
      </div>
  </div>
  <div class="tab-pane" id="uploadFile">
	<form id="editWdForm" class="form-horizontal" action="dataBaseUpLoad.do" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	    	<div class="col-sm-offset-2 col-md-offset-2 col-sm-6 col-md-6" style="display:inline-block;">
		    	<label class="col-sm-3 col-md-3 control-label" style="display:inline-block;">文件路径</label>
		    	<div class="col-sm-6 col-md-6" style="display:inline-block;">
		    		<input type="file" value="选择文件" name="fileName">
		    	</div>
		    </div>
	    	<div class="col-sm-3 col-md-3" style="display:inline-block;">
		      	<button class="btn btn-primary" type="submit" style="display:inline-block;">
					<span class="glyphicon glyphicon-cloud-upload"></span> 上传
				</button>
			</div>
	    </div>		
	</form>
	
	<div id="dataBackup_list">
	   <table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="40px">序号</th>
					<th width="120px">备份文件</th>
					<th width="80px">备份时间</th>
					<th width="80px">备份方式</th>
				    <th width="80px">操作</th>
				</tr>
			</thead>
			<tbody>
			 <c:forEach items="${vos}" var="vo" varStatus="status">
			    <tr>
			      <td>${status.index+1}</td>			    
			      <td>${vo.CFilename}</td>
			      <td>${vo.DBacktime}</td>
                  <td>${vo.NBacktype}</td>              
                  <td class="center" data-nid="${vo.NId}"><a class="dlg_recover_backup"  href="javascript:void(0)"  data-backType="backup">恢复成备份库</a><span>|</span><a class="dlg_recover_normal"  href="javascript:void(0)" data-backType="normal" >恢复成正常库</a><span>|</span><a class="dlg_download"  href="dataBaseDownload.do?nid=${vo.NId}">下载</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>
			    </tr>
			 </c:forEach>
			</tbody>
		</table>
	</div>
  </div>
</div>
	<div class="ex_dlg"></div>
	<div class="wait_dlg" style="text-align: center;margin-top: 20px;">
	   <img src='/resources/images/loading.gif'/>
	</div>
	<div class="wait_hand_dlg" style="text-align: center;margin-top: 20px;">
	   <img src='/resources/images/loading.gif'/>
	</div>
</body>
</html>
