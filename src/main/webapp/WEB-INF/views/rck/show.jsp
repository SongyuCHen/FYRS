<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
<link rel="stylesheet" href="/resources/css/dlg.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/zdybq.css" />
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
function rcktableBind(){
	$('.zzkxg').click(
			function() {
				//修改请求
				var showKey = $(this).parent().data(
						"showkey");
				var isOnlyLook = $(this).parent().data(
						"isonlylook");
				window.open("/ryjbxx.do?showKey=" + showKey
						+ "&isOnlyLook=" + isOnlyLook);
			});
	$('.ckyjda').click(
			function() {
				var showKey = $(this).parent().data(
						"showkey");
				var isOnlyLook = $(this).parent().data(
						"isonlylook");
				window.open("/gryjda.do?showKey=" + showKey
						+ "&isOnlyLook=" + isOnlyLook);
			});
	$('.jbbb').click(
			function() {
				$.ajax({
					url : "/main/ryxx/jbbbxz.aj",
					type : "post",
					data : {
						'showKey' : $(this).parent().data(
								"showkey"),
						'isOnlyLook' : $(this).parent()
								.data("isonlylook")
					},
					dataType : 'html',
					success : function(html) {
						$("#jbbbxz_dlg").html(html).dialog("open");
					}
				});
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
								'<p>确定要将' + temp.parent().parent().find('td').eq(2).text() + '移出人才库？</p>')
						.dialog(
								{
									'close' : function() {
									},
									'buttons' : {
										"确定" : function() {
											$
													.ajax({
														url : "/main/ryxx/scrc.aj",
														type : "post",
														dataType : "html",
														data : {
															fydm : fydm,
															rybh : rybh,
															rcklx : $('#selectRcklx').val()
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
	$(function() {
		initTable("zzk_list");

		$('#jbbbxz_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 430,
			width : 500,
			title : '选项选择',
			close : function() {

			}
		});
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
		
		$("#rcksy").click(function(){
			$(".check:checked").eq(0).addClass("checkedMark");
			var checked = $(".check:checked").parent().parent()
					.eq(0);
			if (checked[0]) {
				var prev = checked.prev();
				if (prev[0]) {
					var fydm = checked.find('.operations')
							.data('fydm');
					var rybh1 = checked.find('.operations')
							.data('rybh');
					var rybh2 = prev.find('.operations').data(
							'rybh');
					$.ajax({
		    			  url:"/main/ryxx/swapRc.aj",
							type:"get",
							dataType:"json",
							data:{
								fydm:fydm,rybh1:rybh1,rybh2:rybh2,rcklx:$('#selectRcklx').val()
							},
							success:function(json){
								if(json ){
                                   
									//在datatable中交换两行 并互换序号
									var checkedTdText = checked
											.children("td")
											.eq(1).text();
									checked
											.children("td")
											.eq(1)
											.text(
													prev
															.children(
																	"td")
															.eq(
																	1)
															.text());
									prev.children("td").eq(
											1).text(
											checkedTdText);

									var checkedTrHtml = checked
											.html();
									checked.html(prev
											.html());
									prev
											.html(checkedTrHtml);
									rcktableBind();
								
								}
							}
		    		  });
				}
			}else{
				alert("请先勾选一个人员");
			}
			$(".checkedMark").eq(0).attr("checked", "checked");
			$(".checkedMark").eq(0).next().eq(0).attr("checked","none");
			$(".checkedMark").removeClass("checkedMark");
		});
		$("#rckxy").click(function(){
			$(".check:checked").eq(0).addClass("checkedMark");
			var checked = $(".check:checked").parent().parent()
					.eq(0);
			if (checked[0]) {
				var next = checked.next();
				if (next[0]) {
					var fydm = checked.find('.operations')
							.data('fydm');
					var rybh1 = checked.find('.operations')
							.data('rybh');
					var rybh2 = next.find('.operations').data(
							'rybh');
					$.ajax({
		    			  url:"/main/ryxx/swapRc.aj",
							type:"get",
							dataType:"json",
							data:{
								fydm:fydm,rybh1:rybh1,rybh2:rybh2,rcklx:$('#selectRcklx').val()
							},
							success:function(json){
								
								if(json ){

									//在datatable中交换两行 并互换序号
									var checkedTdText = checked
											.children("td")
											.eq(1).text();
									checked
											.children("td")
											.eq(1)
											.text(
													next
															.children(
																	"td")
															.eq(
																	1)
															.text());
									next.children("td").eq(
											1).text(
											checkedTdText);

									var checkedTrHtml = checked
											.html();
									checked.html(next
											.html());
									next
											.html(checkedTrHtml);
									rcktableBind();
								
								}
							}
		    		  });
				}
			}else{
				alert("请先勾选一个人员");
			}
			$(".checkedMark").eq(0).attr("checked", "checked");
			$(".checkedMark").eq(0).prev().eq(0).attr("checked","none");
			$(".checkedMark").removeClass("checkedMark");
		});
		
		$('#selectRcklx').change(function(){
			var val = $(this).val();
			var selectBm = $("#select-xzbm option:selected").val();
			if(val == -1){
				alert("请选择一个人才库类型");
				return;
			}
			if(selectBm == -1){
				alert("请选择好法院和部门");
				return;
			}
			$("#loadingSpinner").show();
			$
			.ajax({
				url : "/main/ryxx/rckTable.aj",
				type : 'post',
				dataType : 'html',
				data : {
					'fyDm' : $(".xzfy_fybh").val(),
					'bmDm' : selectBm,
					'rcklx': val
				},
				success : function(str) {
					var json = JSON.parse(str);
					var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th style="background: #3a7a90;" width="10px"></th><th style="background: #3a7a90;" width="30px">序号</th><th style="background: #3a7a90;" width="40px">姓名</th><th style="background: #3a7a90;" width="40px">性别</th><th style="background: #3a7a90;" width="40px">年龄</th><th style="background: #3a7a90;" width="100px">行政职务</th><th style="background: #3a7a90;" width="40px">职级</th><th style="background: #3a7a90;" width="100px">学历</th><th style="background: #3a7a90;" width="90px">报表</th><th style="background: #3a7a90;" width="120px">操作</th></tr></thead><tbody>';
					for ( var i = 0; i < json.length; i++) {
						var ryjbxx = json[i];
						html += "<tr>";
						html +=  '<td class="center"><input class="check" style="float:left" type="checkbox" rid=' + ryjbxx.rybh + '></td>';
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
						html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify jbbb" href="javascript:void(0);">基本</a></td>';
						/* html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify ckyjda" href="javascript:void(0);">查看</a></td>'; */
						if(!ryjbxx.isOnlyLook){
							html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a><span>|</span> <a class="ry_delete zzksc" href="javascript:void(0);">移出</a></td>';
						}else{
							html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a></td>';
						}
						html += "</tr>";
					}
					html += '</tbody></table>';
					// $("#qxgl_list #dataTable").remove();
					$("#zzk_list  #dataTable_wrapper").remove();
					$("#zzk_list").append(html);
					initTable("zzk_list");
					$("#loadingSpinner").hide();
					rcktableBind();

				}
			});
		});

	}); // jquery
	//  初始化表格
	var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " #dataTable").dataTable({
			"sPaginationType" : "full_numbers",
			'bPaginate': false,
			"aoColumnDefs" : [ {
				"bSortable" : false,
				"aTargets" : [0,3,4,5,6,7,8,9]
			} ],
			"sScrollY" : "300px",
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
	};

	// 当部门被选择时
	var selectBmAfter = function() {
		var selectValue = $("#selectRcklx option:selected").val();
		var selectBm = $("#select-xzbm option:selected").attr("value");
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
				url : "/main/ryxx/rckTable.aj",
				type : 'post',
				dataType : 'html',
				data : {
					'fyDm' : $(".xzfy_fybh").val(),
					'bmDm' : $("#select-xzbm option:selected").val(),
					'rcklx':  $("#selectRcklx option:selected").val()
				},
				success : function(str) {
					var json = JSON.parse(str);
					var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th></th><th>序号</th><th>姓名</th><th>性别</th><th>年龄</th><th>行政职务</th><th>职级</th><th>学历</th><th>报表</th><th>操作</th></tr></thead><tbody>';
					for ( var i = 0; i < json.length; i++) {
						var ryjbxx = json[i];
						html += "<tr>";
						html +=  '<td class="center"><input class="check" style="float:left" type="checkbox" rid=' + ryjbxx.rybh + '></td>';
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
						html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify jbbb" href="javascript:void(0);">基本</a></td>';
						/* html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify ckyjda" href="javascript:void(0);">查看</a></td>'; */
						if(!ryjbxx.isOnlyLook){
							html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a><span>|</span> <a class="ry_delete rcksc" href="javascript:void(0);">移出</a></td>';
						}else{
							html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fyDm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a></td>';
						}
						html += "</tr>";
					}
					html += '</tbody></table>';
					// $("#qxgl_list #dataTable").remove();
					$("#zzk_list  #dataTable_wrapper").remove();
					$("#zzk_list").append(html);
					initTable("zzk_list");
					$("#loadingSpinner").hide();
					rcktableBind();
				}
			});
	};
</script>
    <title></title>
</head>
<body>
<body>
	<div class="qxgl-head form-horizontal">
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
			<label class="control-label" style="display: inline-block;width: 90px;height: 24px;text-align:center;">人才库：</label>
			<div style="display: inline-block;width: 250px;height: 30px;">
				<select id="selectRcklx" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">请先选择人才库类型</option>
					<c:forEach items="${dmbList}" var="dmb">
						<option value="${dmb.NDm}">${dmb.CMc}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="operation btn-group">
       <button type="button" class="btn btn-primary btn-sm" id="rcksy">
       		<span class="glyphicon glyphicon-arrow-up"></span> 上移
       </button>
       <button type="button" class="btn btn-primary btn-sm" id="rckxy">
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
				  <!--   <th>业绩档案</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1"></div>
	<div id="ownRoles_dlg"></div>
	<div class="ex_dlg"></div>
	
	<script src="/resources/jstree/jquery.jstree.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<script src="/resources/js/ryxx.js"></script>
	<div id="jbbbxz_dlg"></div>
</body>
</html>
