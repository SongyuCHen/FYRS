<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="/resources/jstree/themes/default/style.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
<style type="text/css">
	.qxgl-head{
		padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
	}
	.operation{
		float: right;
	}
</style>
<script type="text/javascript">
	$(function() {
		initTable("zzk_list");

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
		});
		$('#selectfzbryklx').change(function(){
			var val = $(this).val();
			var selectBm = $("#select-xzbm option:selected").val();
			if(val == -1){
				alert("请选择一个非在编人员库类型");
				return;
			}
			if(selectBm == -1){
				alert("请选择好法院和部门");
				return;
			}
			$("#loadingSpinner").show();
			$
			.ajax({
				url : "/main/ryxx/fzbrykTable.aj",
				type : 'post',
				dataType : 'html',
				data : {
					'fyDm' : $(".xzfy_fybh").val(),
					'bmDm' : selectBm,
					'fzbryklx': val
				},
				success : function(str) {
					var json = JSON.parse(str);
					var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th></th><th>序号</th><th>姓名</th><th>性别</th><th>年龄</th><th>行政职务</th><th>职级</th><th>学历</th><th>操作</th></tr></thead><tbody>';
					for ( var i = 0; i < json.length; i++) {
						var ryjbxx = json[i];
						html += "<tr>";
						html +=  '<td class="center"><input style="float:left" type="checkbox" rid=' + ryjbxx.rybh + '></td>';
						html += '<td class="center">' + (i + 1) + '</td>';
						html += '<td class="center">' + ryjbxx.xm
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xb
								+ '</td>';
						html += '<td class="center">' + ryjbxx.nl
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xzzw
								+ '</td>';
						html += '<td class="center">' + ryjbxx.zj
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xl
								+ '</td>';
						if(!ryjbxx.isOnlyLook){
							html += '<td class="center"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a><span>|</span> <a class="ry_delete zzksc" href="javascript:void(0);">删除</a></td>';
						}else{
							html += '<td class="center"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a></td>';
						}
						html += "</tr>";
					}
					html += '</tbody></table>';
					// $("#qxgl_list #dataTable").remove();
					$("#zzk_list  #dataTable_wrapper").remove();
					$("#zzk_list").append(html);
					initTable("zzk_list");
					$("#loadingSpinner").hide();
					$(".changebtn").hide();
					if(val == 1){
						$("#fzbryyr").show();
					}else if(val == 2){
						$("#fzbrytj").show();
					}
					$('.zzkxg').click(
							function() {
								if(val == 1){
								//修改请求
								var showKey = $(this).parent().data(
										"showkey");
								var isOnlyLook = $(this).parent().data(
										"isonlylook");
								window.open("/ryjbxx.do?showKey=" + showKey
										+ "&isOnlyLook=" + isOnlyLook);
								}else if(val == 2){
									var showKey = $(this).parent().data(
									"showkey");
									var isOnlyLook = $(this).parent().data(
									"isonlylook");
									window.open("/ryjbxxfzb.do?showKey=" + showKey
									+ "&isOnlyLook=" + isOnlyLook);
								}
					});
					$('.zzksc')
					.click(
							function() {
								var fydm = $(this).parent().data(
										"fydm");
								var rybh = $(this).parent().data(
										"rybh");
								
								var temp = $(this);
								$(".ex_dlg")
										.html(
												'<p>确定要移入历史库？</p>')
										.dialog(
												{
													'close' : function() {
													},
													'buttons' : {
														"确定" : function() {
															$
																	.ajax({
																		url : "/main/ryxx/fzbsc.aj",
																		type : "post",
																		dataType : "html",
																		data : {
																			fydm : fydm,
																			rybh : rybh,
																			fzbrylx : val,
																			bm : $("#select-xzbm option:selected").val()
																		},
																		success : function(html) {
																			if (html) {
																				temp.parent().parent().remove();
																				$(
																						".ex_dlg")
																						.dialog(
																								"close");
																			} else {
																				alert("执行不成功，请重新执行");
																				$(
																						".ex_dlg")
																						.dialog(
																								"close");
																			}
																		}
																	}); // ajax
														},
														"取消" : function() {
															$(this)
																	.dialog(
																			"close");
														}
													}
												}).dialog("open");
							});
				}
			});
		});
		
		$("#fzbrytj").click(function(){
			var fzblx = $("#selectfzbryklx").val();
			if(fzblx == 2){
				var fydm = $(".xzfy_fybh").val();
				var selectBm = $("#select-xzbm").val();
				if (isNaN(fydm)) {
					alert("请先选择法院");
				} else {
					window.open("/addryjbxxfzb.do?fydm=" + fydm);
				}
			}
		});
		$("#fzbryyr").click(function(){
			var fzblx = $("#selectfzbryklx").val();
			if(fzblx == 1){
				var fydm = $(".xzfy_fybh").val();
				var selectBm = $("#select-xzbm").val();
				$
				.ajax({
					url : "/main/ryxx/lskTable.aj",
					type : 'post',
					dataType : 'html',
					data : {
						'fyDm' : fydm,
						'bmDm' : selectBm,
						'lsklx': 1
					},
					success : function(str) {
						var json = JSON.parse(str);
						var html = '<select id="select-lsry" class="input-sm form-control">';
						html += '<option value="-1">请选择人员</option>';
						for ( var i = 0; i < json.length; i++) {
							var ryjbxx = json[i];
							html += '<option value="' + ryjbxx.rybh + '">' + ryjbxx.xm + '</option>';
						}
						html += '</select>';
						$("#lskyr").html(html).dialog({
							title : '请从该部门历史库选择要引入的人员',
							'buttons' : {
								'确定' : function() {
									if ($("#select-lsry").val() == -1) {
										alert("请选择人员");
										return;
									}
									$.ajax({
										url : '/main/ryxx/yrlsry.aj',
										type : 'post',
										data : {
											rybh : $("#select-lsry").val(),
											fydm : fydm,
											bm : selectBm
										},
										dataType : 'json',
										success : function(json) {
											if (json) {
												$("#lskyr").dialog("close");
											} else {
												alert("引入人员失败，请刷新后重试");
											}
										}
									});
								},
								'取消' : function() {
									$("#lskyr").dialog("close");
								}
							}
						});
					}
				});
			}
		});

	}); // jquery
	//  初始化表格
	var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " #dataTable").dataTable({
			"sPaginationType" : "full_numbers",
			'bPaginate': false,
			"aoColumnDefs" : [ {
				"bSortable" : false,
				"aTargets" : [0,3,4,5,6,7,8]
			} ],
			//"sScrollY" : "300px",
			"bAutoWidth": true,
			"bLengthChange" : false,
			"bFilter":false,
			"oLanguage" : {
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
			}
		});
		adjustLR("zzk_list");
	};

	// 当部门被选择时
	var selectBmAfter = function() {
		var selectValue = $("#selectfzbryklx option:selected").val();
		var selectBm = $("#select-xzbm option:selected").attr("value");
		var val = selectValue;
		if (-1 == selectValue) {
				return;
			}
		if (-1 == selectBm) {
			alert("请选择好法院和部门");
			return;
		}
			$("#loadingSpinner").show();
			$
			.ajax({
				url : "/main/ryxx/fzbrykTable.aj",
				type : 'post',
				dataType : 'html',
				data : {
					'fyDm' : $(".xzfy_fybh").val(),
					'bmDm' : selectBm,
					'fzbryklx': val
				},
				success : function(str) {
					var json = JSON.parse(str);
					var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th></th><th>序号</th><th>姓名</th><th>性别</th><th>年龄</th><th>行政职务</th><th>职级</th><th>学历</th><th>操作</th></tr></thead><tbody>';
					for ( var i = 0; i < json.length; i++) {
						var ryjbxx = json[i];
						html += "<tr>";
						html +=  '<td class="center"><input style="float:left" type="checkbox" rid=' + ryjbxx.rybh + '></td>';
						html += '<td class="center">' + (i + 1) + '</td>';
						html += '<td class="center">' + ryjbxx.xm
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xb
								+ '</td>';
						html += '<td class="center">' + ryjbxx.nl
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xzzw
								+ '</td>';
						html += '<td class="center">' + ryjbxx.zj
								+ '</td>';
						html += '<td class="center">' + ryjbxx.xl
								+ '</td>';
						if(!ryjbxx.isOnlyLook){
							html += '<td class="center"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a><span>|</span> <a class="ry_delete zzksc" href="javascript:void(0);">删除</a></td>';
						}else{
							html += '<td class="center"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a></td>';
						}
						html += "</tr>";
					}
					html += '</tbody></table>';
					// $("#qxgl_list #dataTable").remove();
					$("#zzk_list  #dataTable_wrapper").remove();
					$("#zzk_list").append(html);
					initTable("zzk_list");
					$("#loadingSpinner").hide();
					$(".changebtn").hide();
					if(val == 1){
						$("#fzbryyr").show();
					}else if(val == 2){
						$("#fzbrytj").show();
					}
					$('.zzkxg').click(
							function() {
								if(val == 1){
								//修改请求
								var showKey = $(this).parent().data(
										"showkey");
								var isOnlyLook = $(this).parent().data(
										"isonlylook");
								window.open("/ryjbxx.do?showKey=" + showKey
										+ "&isOnlyLook=" + isOnlyLook);
								}else if(val == 2){
									var showKey = $(this).parent().data(
									"showkey");
									var isOnlyLook = $(this).parent().data(
									"isonlylook");
									window.open("/ryjbxxfzb.do?showKey=" + showKey
									+ "&isOnlyLook=" + isOnlyLook);
								}
					});
					$('.zzksc')
					.click(
							function() {
								var fydm = $(this).parent().data(
										"fydm");
								var rybh = $(this).parent().data(
										"rybh");
								
								var temp = $(this);
								$(".ex_dlg")
										.html(
												'<p>确定要移入历史库？</p>')
										.dialog(
												{
													'close' : function() {
													},
													'buttons' : {
														"确定" : function() {
															$
																	.ajax({
																		url : "/main/ryxx/fzbsc.aj",
																		type : "post",
																		dataType : "html",
																		data : {
																			fydm : fydm,
																			rybh : rybh,
																			fzbrylx : val,
																			bm : $("#select-xzbm option:selected").val()
																		},
																		success : function(html) {
																			if (html) {
																				temp.parent().parent().remove();
																				$(
																						".ex_dlg")
																						.dialog(
																								"close");
																			} else {
																				alert("执行不成功，请重新执行");
																				$(
																						".ex_dlg")
																						.dialog(
																								"close");
																			}
																		}
																	}); // ajax
														},
														"取消" : function() {
															$(this)
																	.dialog(
																			"close");
														}
													}
												}).dialog("open");
							});
				}
			});
	};
</script>
    <title></title>
</head>
<body>
<body>
	<div class="qxgl-head  form-horizontal">
		<div class="form-group">
			<label class="control-label" style="display: inline-block;width: 90px;height: 24px;text-align:center;">法院：</label>
			<div style="display: inline-block;width: 250px;height: 30px;">
				<input type="text" class="xzfy_ipt input-sm form-control" value="请选择一个法院" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="320000 A00" type="hidden" />
			</div>
			
			<label class="control-label" style="display: inline-block;width: 90px;height: 24px;text-align:center;">部门：</label>
			<div style="display: inline-block;width: 250px;height: 30px;">
				<select id="select-xzbm" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">请先选择部门</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label" style="display: inline-block;width: 90px;height: 24px;text-align:center;">非在编人员库：</label>
			<div style="display: inline-block;width: 250px;height: 30px;">
				<select id="selectfzbryklx" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">请先选择非在编人员库类型</option>
					<c:forEach items="${dmbList}" var="dmb">
						<option value="${dmb.NDm}">${dmb.CMc}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="operation btn-group">
       <button type="button" class="btn btn-primary btn-sm changebtn" id="fzbrytj" style="display:none;">
       		<span class="glyphicon glyphicon-plus"></span> 添加
       </button>
       <button type="button" class="btn btn-primary btn-sm changebtn" id="fzbryyr" style="display:none;">
       		<span class="glyphicon glyphicon-plus"></span> 从历史库引入
       </button>
       <button type="button" class="btn btn-primary btn-sm" id="fzbrysy" style="display:none;" >
       		<span class="glyphicon glyphicon-arrow-up"></span> 上移
       </button>
       <button type="button" class="btn btn-primary btn-sm" id="fzbryxy" style="display:none;" >
       		<span class="glyphicon glyphicon-arrow-down"></span> 下移
       </button>
	</div>
	<img src="/resources/images/loading.gif" id="loadingSpinner" style="display:none;" />
	<div id="zzk_list" class="main_list" width="80%">
		<table id="dataTable" class="cell-border" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th></th>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>行政事务</th>
					<th>职级</th>
					<th>学历</th>
					<th>报表</th>
					<!-- <th>业绩档案</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div id="lskyr" style="display:none">
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1"></div>
	<div id="ownRoles_dlg"></div>
	<div class="ex_dlg"></div>
	<script src="/resources/jstree/jquery.jstree.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<script src="/resources/js/ryxx.js"></script>
</body>
</html>
