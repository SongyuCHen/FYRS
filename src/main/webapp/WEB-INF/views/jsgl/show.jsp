<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
	
   <style type="text/css">
      #jsgl_head
      {
        float:right;
        margin-top: 10px;
        margin-bottom: 5px;
      }
      #line_branch
      {
        padding: 5px;
        clear:both;
      }
      #role_list
      {
        margin-top: 5px;
      }
      
      .ui-button-text-only .ui-button-text
      {
         padding: 0em 0em;
      }
      .ui-dialog .ui-dialog-titlebar
      {
         padding: 0.2em 0.5em;
      }
   </style>
	<script type="text/javascript">
		$(function(){
			var dialogTile = ["添加--角色","查看--角色","修改--角色"];
			/*添加的操作html代码，当重新添加一行时，需要添加的操作*/
			var operation_html="<a class='dlg_view' data-btn_type='1' href='javascript:void(0)'>查看</a><span>|</span>\t<a class='dlg_modify' data-btn_type='2' href='javascript:void(0)'>修改</a><span>|</span>\t<a class='i_delete' href='javascript:void(0)'>删除</a>";
			$roles_oTable=$('#role_list #dataTable').dataTable({
				"sPaginationType" : "full_numbers",
				'bFilter' : true,
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
	            'iDisplayLength' : 10,
	            'bRetrieve':true,
	            'bDestory':true
			});
			adjustLR("role_list");
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
			/*刷新dataTable中最大的序号值*/
			function updateMaxIndex(id,value){
				$node=$("#"+id+"_list #dataTable");
				if(value>$node.data("maxindex")){
					$node.data("maxindex",value);
				}else if(value=$node.data("maxindex")){
					$node.data("maxindex",value-1);
				}
			}
			/*删除选中的dataTable中的行*/
			function removeSelectTr($oTableLocal){
				$oTableLocal.fnDeleteRow($oTableLocal.$("tr.active")[0]);
			}
			// 添加按钮事件
			$("#role_add_btn, .dlg_view, .dlg_modify").live('click',function(){
				if($(this).data("btn_type")!=0){
					activeSelectTr($(this));
				}
				// 设置标题
				var btnType = $(this).data("btn_type");
				var title = dialogTile[btnType];
				// alert($("#oper").data("bh"));
				$.ajax({
					url:"/main/xtgl/roles.aj",
					type:"post",
					dataType:"html",
					data:{
						btnType:$(this).data("btn_type"),id:$(this).parent(".center").data("bh")
					},
					success:function(html){
						$("#role_dlg").html(html).dialog('option','title',title).dialog('open');
						$("#i_close").live('click',function(){
							$("#role_dlg").dialog("close");
						});
						$("#i_save").live('click',function(){
							if($("#roleInputName").val() == '')
								{
								  $(".ex_dlg").html('<p>请输入角色名称</p>').dialog({
									  'buttons':{
										  "确定":function(){
											  $(".ex_dlg").dialog("close");
										  }
									  }
								  }).dialog("open");
								
								}
						     // 开始保存数据
						     var type= $(this).data("type");
						     var type_txt = type == 0  ? "添加":"修改";
							 var type_url = type == 0  ? "/main/xtgl/rolesAdd.aj":"/main/xtgl/rolesUpdate.aj";
							 var value = {"roleName":$("#roleInputName").val(),"id":$("#rolePop").attr("data-bh")};
							 // 显示提示框
							 $(".ex_dlg").html('<p>是否确定'+type_txt+'该数据？</p>').dialog({
								"buttons":{
									"确定":function(){
										$.ajax({
											url:type_url,
											type:"post",
											data:value,
											dataType:"json",
										    success:function(json){
										    	// -1 失败,0 成功，其他 ： id 号
										    	if(json != -1)
										    		{
										    		  $(".ex_dlg").children('p').remove();
										    		  $(".ex_dlg").append('<p>'+type_txt+"成功 </p>").dialog({
										    			  "buttons":{
										    				  "确定":function(){
										    					  if(json == 0 && type==2)
										    						  {
										    						    // 修改成功后，重新绑定数据
										    						     $current_node=$("#role_list #dataTable tbody .active");
						    											 $current_node.find("td:nth-child(2)").text(value.roleName);
										    						  }
										    					  else
										    						  {
										    						    // 在表格中添加一条新的数据
										    						    var index = $("#role_list #dataTable").data("maxindex") + 1;
										    						    // 把元素中记录最大行的值进行修改
										    						    updateMaxIndex("role",index);
										    						    // 对于表格中的每一项都需要填写，不然会报错
										    						    $roles_oTable.fnAddData([index,value.roleName,operation_html]);
										    						  }
										    					  $(".ex_dlg").dialog("close");
										    					  $("#role_dlg").dialog("close");
										    					  
										    				  }
										    			  }
										    		  });
										    		}
										    	else
										    		{
										    		  var sError = type_txt + "操作没有执行成功，请重试！";
										    		  $(".ex_dlg").children("p").remove();
										    		  $(".ex_dlg").append('<p class="error">'+sError+'</p>').dialog({
						    								 'buttons':{
						    									 '确定':function(){
						    										 $(".ex_dlg").dialog('close'); 
						    									 }
						    								 }
						    							 }).dialog("open");
										    		}
										    	
										    	
										    }
										    
										});
										// $(".ex_dlg").dialog("close");
									}, // 确定结束
									"取消":function(){
										$(".ex_dlg").dialog("close");
									}
							        
								}
							 }).dialog("open"); // 显示提示框 
						});
					}
				});
			});
			
			
			$('#role_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 300,
				width : 350,
				title : '查看--角色',
				close:function(){
					// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
					removeSelectTrActive("role");
				}
			});
			$('.authority_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 500,
				width : 800,
				title : '角色授权',
				close:function(){
					
				}
			});
		
			// 实现删除功能
			$("#role_list .i_delete").live('click',function(){
				activeSelectTr($(this));
				var roleId = $(this).parent().data("bh");
				$(".ex_dlg").html('<p>是否确定删除该数据？</p>').dialog({
					'close':function(){
						removeSelectTrActive("role");
					},
					'buttons':{
						"确定":function(){
							$.ajax({
								url:'/main/xtgl/roleDelete.aj',
								type:"post",
								data:{id:roleId},
								dataType:'json',
								success:function(json){
									if(json == "1")
								     {
										// 找到序号
										var value = $("#role_list #dataTable tbody .active").find("td:first").text();
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
			// 实现授权界面的跳转
			$("#role_permit").live('click',function(){
				// window.open("/main/xtgl/qxgl/menus.do");
				  $.ajax({
				      url : "/main/xtgl/qxgl/menus.aj",
					  type : 'get',
					  dataType : 'html',
					  data :{},
					  success:function(html)
					  {
						  $(".authority_dlg").html("").html(html).dialog('open');
					  }		 
					});
			});
		});
	</script>
	<div id="jsgl_head">
		<button type="button" class="btn btn-primary" id="role_add_btn" data-btn_type="0">
			<span class="glyphicon glyphicon-plus"></span> 添加角色</button>
		<button type="button" class="btn btn-success" id="role_permit">
			<span class="glyphicon glyphicon-ok"></span> 授权</button>
	</div>
	<div id="role_list" class="main_list">
		<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th width="100px">序号</th>
					<th>角色名称</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var="role" varStatus="i">
					<tr>
						<td class="center">${i.index+1}</td>
						<td class="center">${role.roleName}</td>
						<td class="center" data-bh="${role.id}"><a
							class="dlg_view" data-btn_type="1" href="javascript:void(0)">查看</a><span>|</span> <a
							class="dlg_modify" data-btn_type="2" href="javascript:void(0)">修改</a><span>|</span> <a
							class="i_delete" href="javascript:void(0)">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="role_dlg"></div><div class="ex_dlg"></div><div class="authority_dlg"></div>
</div>
