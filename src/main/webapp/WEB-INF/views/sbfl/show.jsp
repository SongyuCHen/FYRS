<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
   <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
   <script src="/resources/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
   <script type="text/javascript" src="/resources/js/ryjbxx.js"></script>
   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   <link rel="stylesheet" href="/resources/css/dlg.css" />
   <link rel="stylesheet" href="/resources/css/zdybq.css" />
   <link rel="stylesheet" href="/resources/css/common.css" />
   <link rel="stylesheet" href="/resources/css/demo_table.css" />
   <link rel="stylesheet" href="/resources/css/ryjbxx.css" />
   
   <style type="text/css">
   
      #sbgl_xzfy{
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
   	function checkInputRequired(id) {
		var result = 0;
		$("#" + id + "_table").find('.keyValue').each(function() {
			if ($.trim($(this).val()) == "") {
				result++;
			}
		});
		return result == 0 ? true : false;
	}
	function updateMaxIndex(id, value) {
		$node = $("#" + id + "_list .dataTable");
		if (value > $node.data("maxindex")) {
			$node.data("maxindex", value);
		} else if (value = $node.data("maxindex")) {
			$node.data("maxindex", value - 1);
		}
	}
     $(function(){
     	var operation_html = "<a class='dlg_view' data-btn_type='1'>查看</a><span>|</span>\t<a class='dlg_modify' data-btn_type='2'>修改</a><span>|</span>\t<a class='i_delete'>删除</a>";
         initTable("sbgl_list");
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
  		//添加工资条目
  		$('#sbgl_list .dlg_view,#sbgl_list  .dlg_modify,#sbgl_add').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var fydm = $('.xzfy_fybh').val();
		if (isNaN(fydm)) {
				alert("请先选择法院");
			}else{
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——社保记录", "查看——社保记录", "修改——社保记录" ];
		$.ajax({
			url : "sbgl.aj",
			type : "post",
			dataType : "html",
			data : {
					btnType : $(this).data("btn_type"),
					keyid : $(this).parent().data("keyid"),
					fydm : $(".xzfy_fybh").val(),
					rybh : $(this).parent().data("rybh")
				
			},
			success : function(html) {
				$('#sbgl_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#sbgl_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("sbgl")) {
						$("#J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$("#J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$("#J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$("#J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addSbgl.aj": "saveSbgl.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#sbgl_table").data("fydm"),
								'NId' : $("#sbgl_table").data("keyid"),
								'NRybh':$("#sbgl_table").find(".even_td").eq(1).children().children().val(),						
								'NType':$("#sbgl_table").find(".even_td").eq(2).children().children().val(),
								'MGryj':$("#sbgl_table").find(".even_td").eq(3).children().val(),
								'MDwyj':$("#sbgl_table").find(".even_td").eq(4).children().val(),
								'DKssj':$("#sbgl_table").find(".even_td").eq(5).children().val(),
								'DJssj':$("#sbgl_table").find(".even_td").eq(6).children().val()
							};
							$("#J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$.ajax({
											url : type_url,
											type : 'post',
											data : value,
											dataType : 'json',
											success : function(json) {
												// -1.失败
												// 0.成功
												// 其他：bh
												if (json != null) {
													$('#J_dlg').children('p').remove();
													$('#J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#sbgl_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.CXm);
																	$current_node.find("td:nth-child(3)").text(json.NZj);
																	$current_node.find("td:nth-child(4)").text(json.NType);
																	$current_node.find("td:nth-child(5)").text(json.MGryj);
																	$current_node.find("td:nth-child(6)").text(json.MDwyj);
																	$current_node.find("td:nth-child(7)").text(json.DKssj);
																	$current_node.find("td:nth-child(8)").text(json.DJssj);
																	$current_node.find("td:nth-child(9)").text(json.MFyhj);
																} else {
																	var index = $("#sbgl_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("sbgl",index);
																	$sbgl_oTable.fnAddData([index,json.CXm,json.NZj,json.NType,json.MGryj,json.MDwyj,json.DKssj,json.DJssj,json.MFyhj,operation_html]);
																	$new_row = $($sbgl_oTable.fnGetNodes($("#sbgl_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('#J_dlg').dialog('close');
																$('#sbgl_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('#J_dlg').children('p').remove();
													$('#J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('#J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$("#J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	}});
  		
  		$('#sbgl_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 400,
			width : 400,
			title : '',
			close:function(){
				// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
			    removeSelectTrActive("sbgl");
			}
		}); // dialog
		$('#sbgl_list .i_delete').live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$("#J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("sbgl");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deleteSbgl.aj',
						type : 'post',
						data : {
							keyid : keyid,
							fydm : fydm,
							rybh : rybh
						},
						dataType : 'json',
						success : function(json) {
							// 0.失败 1.成功
							if (json == "1") {
								var value = $("#sbgl_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("sbgl",value);
								removeSelectTr($sbgl_oTable);
								$('#J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('#J_dlg').children('p').remove();
									$('#J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('#J_dlg').dialog('close');
											}
										}
									}).dialog("open");
							}
						}
					});
		},
				'取消' : function() {
					$(this).dialog('close');
				}
			}
		}).dialog('open');
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
		
     }); // jquery
     var initTable = function(dataTableId){
   	  $sbgl_oTable=$("#"+dataTableId+" #dataTable").dataTable({
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
   	  adjustLR("sbgl_list");
     };
     var selectFyAfter = function(){
  	   var fydm = $(".xzfy_fybh").val();
  	   initDataTable(fydm);
     };
     var initDataTable = function(fydm){
		 $.ajax({
	    	  url:"/main/yygl/sbflDetail.aj",
	    	  type:"POST",
	    	  data:{fydm:fydm},
	    	  dataType:"json",
	    	  success:function(json){
	    		  var html = '<table id="dataTable" data-maxindex="'+json.length+'" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><tr><th width="50px">序号</th><th width="150px">姓名</th><th width="150px">职级</th><th width="80px">保险类型</th><th>个人应缴</th><th>单位应缴</th><th>开始时间</th><th>结束时间</th><th>小计</th><th width="100px">操作</th></tr></thead><tbody>';
				  for(var i = 0; i < json.length; i++)
					  {
					    var sbgl = json[i];
					    html += "<tr>";
					    html += '<td class="center">'+(i+1)+'</td>';
					    html += '<td class="center">'+sbgl.CXm+'</td>';
					    html += '<td class="center">'+sbgl.NZj+'</td>';
					    html += '<td class="center">'+sbgl.NType+'</td>';
					    html += '<td class="center">'+sbgl.MGryj+'</td>';	
					    html += '<td class="center">'+sbgl.MDwyj+'</td>';
					    html += '<td class="center">'+sbgl.DKssj+'</td>';
					    html += '<td class="center">'+sbgl.DJssj+'</td>';
					    html += '<td class="center">'+sbgl.MFyhj+'</td>';
					    html += '<td class="center" data-fyDm="'+sbgl.NFy+'" data-keyid="'+sbgl.NId+'" data-rybh="'+sbgl.NRybh+'"><a class="dlg_view" data-btn_Type="1" href="javascript:void(0)">查看</a><span>|</span><a class="dlg_modify" data-btn_Type="2" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
					    html += "</tr>";											    
					  }
				  html += '</tbody></table>';
				  $("#sbgl_list  #dataTable_wrapper").remove();
				  $("#sbgl_list").append(html);
				  initTable("sbgl_list");
	    	  }
	      }); 
	 };
   </script>
</head>
<body>
 <div id="sbgl_xzfy" class="form-horizontal">
 		<div class="form-group">
 			<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院或部门：</label>
 			<div style="display:inline-block;width:250px;height:30px;">
	 			<input type="text" class="xzfy_ipt form-control" value="请选择一个法院或部门" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="-1" type="hidden" />
			</div>
		</div>
 </div>
 <div class="operationDiv clearfix">
 	<button type="button" class="btn btn-primary" id="sbgl_add" data-btn_Type="0">
		<span class="glyphicon glyphicon-plus"></span> 添加
	</button>
	<!-- <button type="button" class="btn btn-primary" id="sbgl_add" data-btn_Type="0">
		<span class="glyphicon glyphicon-plus"></span> 添加员工条目
	</button> -->
	
 </div>
	<div id="sbgl_list">
		<table id="dataTable" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr>
				    <th><input type="checkbox" name=""></th>
					<th>姓名</th>
					<th>职级</th>
					<th>社保类型</th>
					<th>个人应缴</th>
					<th>单位应缴</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>小计</th>					
					<th width="100px">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="0" isFyAndBm="0"></div>
	<div id="sbgl_dlg"></div>
	<div id="J_dlg"></div>
	<div class="ex_dlg"></div>
</body>
</html>

