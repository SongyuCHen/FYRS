<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
       #dmwh_head
       {
         text-align: center;
         padding: 15px 0;
	     background-color: #EEF7FD;
		 border-bottom: 2px solid #96C8EB;
		 margin-bottom: 5px;
		 color: #166092;
		 font-size: 120%;
       }
      .sfzdy-1
      {
        color: red;
      }
   </style>
   <script type="text/javascript">
     $(function(){
    	 $("#operBeginTime,#endTime").datepicker();
    	 initTable("dmwh_list");
    	 $("#dmwh_select").change(function(){
    		 if($("#dmwh_select option:selected").val() == -1)
    			 {
    			   alert("请选择代码名称进行更新！");
    			 }
    			 getData();    		
    	 });
    	 var getData = function(){
    		 $.ajax({
   	    	  url:"/main/xtgl/dmwhDetail.aj",
   	    	  type:"post",
   	    	  data:{nBxh:$("#dmwh_select option:selected").val()},
   	    	  dataType:"json",
   	    	  success:function(json){
   	    		  var html = '<table id="dataTable"  class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="100px">代码</th><th>名称</th><th width="120px">操作 </th></tr></thead><tbody>';
					  for(var i = 0; i < json.length; i++)
						  {
						    var dm = json[i];
						    html += '<tr class="sfzdy-'+dm.NSfzdy+'">';
						    html += '<td class="center">'+dm.NDm+'</td>';
						    html += '<td class="center">'+dm.CMc+'</td>';
						    if(dm.NSfzdy == "1")
						    	{
						    	  html += '<td class="center" data-dm="'+dm.NDm+'"><a class="dlg_modify" href="javascript:void(0)" data-btn_type="2">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
						    	}
						    else
						    	{
						    	  html += '<td class="center"></td>';
						    	}
						   
						    html += '</tr>';
						  }
					  html += '</tbody></table>';
					  // $("#qxgl_list #dataTable").remove();
					  $("#dmwh_list  #dataTable_wrapper").remove();
					  $("#dmwh_list").append(html);
					  initTable("dmwh_list");
   	    	  }
   	      });
    	 };
    	 // 查询按钮事件
    	 $("#dmwh_find").click(function(){
    		 getData();
    	 });
    	 // 添加自定义代码事件
    	 $("#btnCustomDm,.dlg_modify").live("click",function(){
    		 var nbxh = $("#dmwh_select option:selected").val();
    		 var btnType = $(this).data("btn_type");
    		 var dm = "";
    		 if(btnType == "2")
    			 {
    			 removeSelectTrActive("dmwh_list");
    			   dm = $(this).parent().data("dm");
    			   activeSelectTr($(this));
    			 }
    		 if(nbxh == -1)
			 {
			   alert("请选择自定义的代码类型");
			   return ;
			 }
			 var titles = ["添加自定义代码","","修改自定义代码"];
    		 $.ajax({
    			  url:"/main/xtgl/addCustomeDm.aj",
      	    	  type:"POST",
      	    	  data:{nbxh:nbxh,btnType:btnType,dm:dm},
      	    	  dataType:"html",
      	    	  success:function(html)
      	    	{
      	    	   $(".customeDmAdd_dlg").html("").html(html).dialog("option","title",titles[btnType]).dialog('open');
      	    	}
    		 });
    		 
    	 });
    	 //
    	 $('.customeDmAdd_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 300,
				width : 500,
				title : '添加自定义代码',
				close:function(){
					removeSelectTrActive("dmwh_list");
				}
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
			$(".i_delete").live('click',function(){
				 var nbxh = $("#dmwh_select option:selected").val();
				 if(nbxh == -1)
				 {
				   alert("请选择自定义的代码类型");
				   return ;
				 }
				 var dm = $(this).parent().data("dm");
	    		 removeSelectTrActive("dmwh_list");  			   
  			     activeSelectTr($(this));
  			     
				 $(".delete_dlg").html('<p>是否确定删除该数据？</p>').dialog({
						'close':function(){
							removeSelectTrActive("dmwh_list");
						},
						'buttons':{
							"确定":function(){
								 
				  			   $.ajax({
				     			  url:"/main/xtgl/deleteCustomeDm.aj",
				       	    	  type:"POST",
				       	    	  data:{nbxh:nbxh,dm:dm},
				       	    	  dataType:"html",
				       	    	  success:function(html)
				       	    	{
				       	    	   if(html == "1")
				       	    		   {
				       	    		     removeSelectTr($roles_oTable);
				       	    		     $(".delete_dlg").dialog('close');
				       	    		   }
				       	    	   else
				       	    		   {
				       	    		     alert("删除失败,请重新操作！");
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
    <div id="dmwh_head" class="form-horizontal">
	    	<div class="form-group">
		        <label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">代码名称：</label>
		        <div style="display:inline-block;width:250px;height:30px;">
			        <select class="form-control" id="dmwh_select" style="display:inline-block;">
			          <option value="-1">请选择代码名称</option>
			          <c:forEach var="mc" items="${mcs}">
			             <option value="${mc.NBxh}">${mc.CMc}</option>
			          </c:forEach>
			        </select>
			    </div>
			    
			    <button id="btnCustomDm" class="btn btn-primary" data-btn_type="0" style="display:inline-block;">
	        		<span class="glyphicon glyphicon-pencil"></span> 自定义代码
	        	</button>
	        </div>
    </div>
	<div id="dmwh_list" class="main_list">
		<table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th width="100px">代码</th>
					<th>名称</th>
					<th width="120px">操作 </th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="customeDmAdd_dlg"></div><div class="delete_dlg"></div>
</body>
</html>
