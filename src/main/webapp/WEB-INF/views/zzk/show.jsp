<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script src="/resources/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	<script src="/resources/js/zdybq.js"></script>
	
	<link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/customtable.css">
	<link rel="stylesheet" href="/resources/css/dlg.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/zdybq.css" />
<style type="text/css">
.qxgl-head {
	padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
}

.qxgl-head span {
	margin: 0 20px;
}

.ui-datepicker {
	z-index: 1200;
}

.operation {
	float: right;
}

.addinput table tr {
	height: 45px;
}

.addinput table .odd_td {
	text-align: right;
	width: 100px;
}

.namelist {
	text-align: center;
}

.controllabel{
	display: inline-block;
	width: 90px;
	height: 24px;
	text-align:center;
}

.selectArea{
	display: inline-block;
	width: 250px;
	height: 30px;
}
</style>
<script type="text/javascript">
function zzktableBind(){
	/*active选中的dataTable中的行*/
	function activeSelectTr($node) {
		// 它只是简单地添加一个  class 作为标识，表示选中一行，也就是在 <tr> 添加  class 属性
		$node.parent().parent().addClass("active");
	}
	/*清除dataTable中选中行的active类*/
	function removeSelectTrActive(id) {
		// 当窗口关闭时，把添加的  class 属性进行删除
		$("#" + id + "_list #dataTable tbody .active")
				.removeClass("active");
	}
	/*删除选中的dataTable中的行*/
	function removeSelectTr($oTableLocal) {
		$oTableLocal.fnDeleteRow($oTableLocal
				.$("tr.active")[0]);
	}
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
	/*$('.ckyjda').click(
			function() {
				var showKey = $(this).parent().data(
						"showkey");
				var isOnlyLook = $(this).parent().data(
						"isonlylook");
				window.open("/gryjda.do?showKey=" + showKey
						+ "&isOnlyLook=" + isOnlyLook);
			});*/
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
						$("#jbbbxz_dlg").html(html).dialog(
								"open");
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
						activeSelectTr($(this));
						var temp = $(this);
						$(".ex_dlg")
								.html(
										'<p>确定要删除？删除后不能恢复</p>')
								.dialog(
										{
											'close' : function() {
											},
											'buttons' : {
												"确定" : function() {
													$
															.ajax({
																url : "/main/ryxx/rysc.aj",
																type : "post",
																dataType : "html",
																data : {
																	fydm : fydm,
																	rybh : rybh
																},
																success : function(
																		html) {
																	if (html) {
																		temp
																				.parent()
																				.parent()
																				.remove();
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
		var rybhList, nameList;
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
		$('#lskyr').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 300,
			width : 400,
			title : '',
			close : function() {

			}
		});
		$("#zzkyr").click(function(){
			var fydm = $('.xzfy_fybh').val();
			var bm = $("#select-xzbm").val();
			if (isNaN(fydm)) {
				alert("请先选择法院");
			}else if(bm == -1 || bm == -2){
				alert("请先选择要引入人员的部门");
			}else{
				$('#lskyr').dialog({
					'buttons' : {
						'确定' : function() {
							var fy = $(".xzfyyr_fybh").val();
							var bm = $("#yrbm").val();
							var ry = $("#yrry").val();
							if (isNaN(ry) || ry == -1) {
								alert("请先选择人员");
								return;
							}
							$(".yrfy_div").hide();
							$(".yrbm_div").hide();
							$(".yrry_div").hide();
							$("#loadingSpinner_lskyr").show();
							$.ajax({
								url : '/main/ryxx/lskyr.aj',
								type : 'post',
								data : {
									rybh : ry,
									fydst : $(".xzfy_fybh").val(),
									bmdst : $("#select-xzbm").val(),
									fysrc : fy
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
				}).dialog("open");
			}
		});
		$("#zzksy")
				.click(
						function() {
							
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
									$
											.ajax({
												url : "/main/ryxx/swap.aj",
												type : "get",
												async : false,
												dataType : "json",
												data : {
													fydm : fydm,
													rybh1 : rybh1,
													rybh2 : rybh2
												},
												success : function(json) {
													if (json == true) {
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
														zzktableBind();
													}
												}
											});

								}
							} else {
								alert("请先勾选一个人员");
							}
							$(".checkedMark").eq(0).attr("checked", "checked");
							$(".checkedMark").eq(0).next().eq(0).attr("checked","none");
							$(".checkedMark").removeClass("checkedMark");
							
						});
		$("#zzkxy")
				.click(
						function() {
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
									$
											.ajax({
												url : "/main/ryxx/swap.aj",
												type : "get",
												async : false,
												dataType : "json",
												data : {
													fydm : fydm,
													rybh1 : rybh1,
													rybh2 : rybh2
												},
												success : function(json) {
													if (json == true) {
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
														zzktableBind();
													}
												}

											});
								}
							} else {
								alert("请先勾选一个人员");
							}
							$(".checkedMark").eq(0).attr("checked", "checked");
							$(".checkedMark").eq(0).prev().eq(0).attr("checked","none");
							$(".checkedMark").removeClass("checkedMark");
							
						});
		$('#zzktj').click(function() {
			var fydm = $('.xzfy_fybh').val();
			if (isNaN(fydm)) {
				alert("请先选择法院");
			} else {
				window.open("/addryjbxx.do?fydm=" + fydm);
			}
		});
		$("#jrrck").click(function() {
			var checked = $(".check:checked").parent().parent();
			if (checked[0]) {
				rybhList = "", nameList = "";
				checked.each(function() {
					rybhList += $(this).find('.operations').data('rybh');
					rybhList += ",";
					nameList += $(this).find('.xmtd').text();
					nameList += ",";
				});
				rybhList = rybhList.substring(0, rybhList.length - 1);
				nameList = nameList.substring(0, nameList.length - 1);
				$('.rclist').html(nameList);
				$(".jrrck_dlg").dialog({
					'buttons' : {
						'确定' : function() {
							if ($("#selectRclx").val() == -1) {
								alert("请选择人才库类型");
								return;
							}
							$.ajax({
								url : '/main/ryxx/jrrck.aj',
								type : 'post',
								data : {
									rybhList : rybhList,
									fydm : $(".xzfy_fybh").val(),
									rcklx : $("#selectRclx").val()
								},
								dataType : 'json',
								success : function(json) {
									if (json) {
										$(".jrrck_dlg").dialog("close");
									} else {
										alert("加入人才库失败，请刷新后重试");
									}
								}
							});
						},
						'取消' : function() {
							$(".jrrck_dlg").dialog("close");
						}
					}
				}).dialog("open");
			} else {
				alert("请先勾选至少一个人员");
			}
		});
		$("#zzkplxg").click(function() {
			var checked = $(".check:checked").parent().parent();
			if (checked[0]) {
				rybhList = "", nameList = "";
				checked.each(function() {
					rybhList += $(this).find('.operations').data('rybh');
					rybhList += ",";
					nameList += $(this).find('.xmtd').text();
					nameList += ",";
				});
				rybhList = rybhList.substring(0, rybhList.length - 1);
				nameList = nameList.substring(0, nameList.length - 1);
				$('.namelist').html(nameList);

				$(".ex_dlg").dialog({
					autoOpen : false,
					bgiframe : true,
					modal : true,
					resizable : false,
					height : 520,
					width : 540,
					'z-index' : 900,
					title : '批量修改',
					'close' : function() {
					}
				}).dialog("open");
			} else {
				alert("请先勾选至少一个人员");
			}

		});

		$('#selectAdd')
				.change(
						function() {
							if ($(this).val() == -1) {
								alert("请选择一个批量修改的项目");
								return;
							}
							var href = $(this).find('option:selected').data(
									'href');
							$
									.ajax({
										url : "/" + href + ".aj",
										type : "post",
										dataType : "html",
										data : {
											btnType : 0
										},
										success : function(html) {
											$('.addinput').html(html);
											$('#i_close')
													.live(
															'click',
															function() {
																$(".ex_dlg").dialog('close');
															});
											$("#i_save")
													.live(
															"click",
															function() {
																//检查必填项是否已经填写完整：true.填写完整 false.不完整
																var result = checkInputRequired("zzmm");
																if (!result) {
																	$(".J_dlg")
																			.html(
																					'<p>数据填写不完整，请返回重填！</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$(
																										".J_dlg")
																										.dialog(
																												"close");
																							}
																						}
																					})
																			.dialog(
																					"open");
																} else {
																	//type:0.添加 2.修改
																	var timeReady = true;
																	$(
																			'.myDate_label')
																			.each(
																					function() {
																						timeReady = timeReady
																								&& checkTime($(
																										this)
																										.val());
																					});
																	if (!timeReady) {
																		$(
																				".J_dlg")
																				.html(
																						'<p>时间格式不正确</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$(
																											".J_dlg")
																											.dialog(
																													"close");
																								}
																							}
																						})
																				.dialog(
																						"open");
																	} else {//处理添加请求
																		//var type=$(this).data("type");
																		//var type_txt=type==0?"添加":"修改";
																		//var type_url=type==0?"addZzmm.aj":"saveZzmm.aj";
																		//var value={'showKey':$('#menu_list').data('showkey'),'NFy':$("#zzmm_table").data("fydm"),'NRybh':$("#zzmm_table").data("rybh"),'NId':$("#zzmm_table").data("keyid"),'NZzmm':$("#zzmm_table").children().children().first().children().first().next().children().children().first().val(),'DJrrq':$("#zzmm_table").children().children().first().children().last().children().val(),'DZzrq':$("#zzmm_table").children().children().first().next().children().first().next().children().val(),'NDqxx':$("#zzmm_table").children().children().first().next().children().last().children().children().val()};
																		var value = {
																			rybhList : rybhList,
																			fydm : $(
																					".xzfy_fybh")
																					.val(),
																			plxglx : $('#selectAdd').val()
																		};
																		$(
																				'.plxgUp')
																				.each(
																						function() {
																							value[$(this).attr('name')] = $(this).val();
																						});
																		
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定保存？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : '/main/ryxx/plxg.aj',
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													
																												

																													if (json) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>保存成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(".ex_dlg").dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = '保存操作没有执行成功，请重试！';
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p class="error">'
																																				+ sError
																																				+ '</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													}
																												}
																											});
																								},
																								'取消' : function() {
																									$(
																											".J_dlg")
																											.dialog(
																													"close");
																								}
																							}
																						})
																				.dialog(
																						"open");
																	}
																}
															});//copied
										}
									});
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
		$('.xzfy_yr').click(function() {
			$.ajax({
				url : "/xzfyyrShow.aj",
				type : 'post',
				dataType : 'html',
				data : {},
				success : function(html) {
					$('.xzfy_dlg').html(html).dialog('open');
				}
			});
		});

	}); // jquery
	//  初始化表格
	var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " #dataTable").dataTable({
			'iDisplayLength' : 10,
			"sPaginationType" : "full_numbers",
			"bStateSave" : true,
			'bPaginate' : true,
			'bAutoWidth' : false,
			"aoColumnDefs" : [ {
				"bSortable" : false,
				"aTargets" : [ 0, 3, 4, 5, 6, 7, 8, 9]
			} ],
			//"sScrollY" : "300px",
			"bLengthChange" : false,
			"bFilter" : false,
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
		var selectValue = $("#select-xzbm option:selected").attr("value");
		if (-1 == selectValue) {
			alert("请选择一个部门");
			return;
		}
		$("#loadingSpinner").show();
		$
				.ajax({
					url : "/main/ryxx/zzkTable.aj",
					type : 'post',
					dataType : 'html',
					data : {
						'fydm' : $(".xzfy_fybh").val(),
						'bmdm' : $("#select-xzbm option:selected")
								.attr("value")
					},
					success : function(str) {
						var json = JSON.parse(str);
						var html = '<table id="dataTable" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th></th><th>序号</th><th>姓名</th><th>性别</th><th>年龄</th><th>行政职务</th><th>职级</th><th>学历</th><th>报表</th><th>操作</th></tr></thead><tbody>';
						for ( var i = 0; i < json.length; i++) {
							var ryjbxx = json[i];
							html += "<tr>";
							html += '<td class="center"><input style="float:left" class="check" type="checkbox" rid=' + ryjbxx.rybh + '></td>';
							html += '<td class="center">' + (i + 1) + '</td>';
							html += '<td class="center xmtd">' + ryjbxx.xm
									+ '</td>';
							html += '<td class="center">' + ryjbxx.xb + '</td>';
							html += '<td class="center">' + ryjbxx.nl + '</td>';
							html += '<td class="center">' + ryjbxx.xzzw
									+ '</td>';
							html += '<td class="center">' + ryjbxx.zj + '</td>';
							html += '<td class="center">' + ryjbxx.xl + '</td>';
							html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify jbbb" href="javascript:void(0);">基本</a></td>';
							/*html += '<td class="center operations" data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'" data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify ckyjda" href="javascript:void(0);">查看</a></td>'; */
							if (!ryjbxx.isOnlyLook) {
								html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a><span>|</span> <a class="ry_delete zzksc" href="javascript:void(0);">删除</a></td>';
							} else {
								html += '<td class="center operations"  data-showKey="'+ryjbxx.showKey+'" data-isOnlyLook="'+ryjbxx.isOnlyLookEncode+'"  data-fydm="'+ryjbxx.fy+'" data-rybh="'+ryjbxx.rybh+'"><a class="ry_modify zzkxg" href="javascript:void(0);">查看</a></td>';
							}
							html += "</tr>";
						}
						html += '</tbody></table>';
						// $("#qxgl_list #dataTable").remove();
						$("#zzk_list  #dataTable_wrapper").remove();
						$("#zzk_list").append(html);
						initTable("zzk_list");
						$("#loadingSpinner").hide();//隐藏加载图片
						zzktableBind();

					}
				});
	};

	function checkInputRequired(id) {
		var result = 0;
		$("#" + id + "_table").find('.keyValue').each(function() {
			if ($.trim($(this).val()) == "") {
				result++;
			}
		});
		return result == 0 ? true : false;
	}
	//函数检查必须为数字，可以为浮点数
	function checkDouble(str) {
		var reg = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
		return reg.test(str);
	}
	//检查为正整数
	function checkInteger(str) {
		var reg = /^[0-9]*[1-9][0-9]*$/;
		return reg.test(str);
	}
	//检查时间格式
	function checkTime(str) {
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
</script>
</head>
<body>
	<div class="qxgl-head form-horizontal">
		<div class="form-group">
			<label class="controllabel">法院：</label>
			<div  class="selectArea">
				<input type="text" class="xzfy_ipt input-sm form-control" value="请选择一个法院" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="320000 A00" type="hidden" />
			</div>
			
			<label class="controllabel">部门：</label>
			<div class="selectArea">
				<select id="select-xzbm" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">请先选择部门</option>
				</select>
			</div>
		</div>
	</div>
	<div class="operation btn-group">
		<button type="button" class="btn btn-primary btn-sm" id="zzktj">
			<span class="glyphicon glyphicon-plus"></span> 添加
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="zzkyr">
			<span class="glyphicon glyphicon-plus"></span> 从其他法院引入
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="jrrck" style="display:none;">
			<span class="glyphicon glyphicon-plus"></span> 加入人才库
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="zzkplxg">
			<span class="glyphicon glyphicon-refresh"></span> 批量修改
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="zzksy">
			<span class="glyphicon glyphicon-arrow-up"></span> 上移
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="zzkxy">
			<span class="glyphicon glyphicon-arrow-down"></span> 下移
		</button>
	</div>
	<img src="/resources/images/loading.gif" id="loadingSpinner"
		style="display:none;" />
	<div id="zzk_list" class="main_list" width="80%">
		<table id="dataTable" class="dataTable">
			<thead>
				<tr>
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
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1"></div>
	<div id="ownRoles_dlg"></div>
	<div class="ex_dlg" style="display:none;">
		<div class="namelist"></div>
		<div class="addselection row form-group">
			<div class="col-sm-6 col-md-6 col-sm-offset-3 col-md-offset-3">
				<select id="selectAdd" class="input-sm form-control">
					<option value="-1">请先选择要添加的项目</option>
					<c:forEach items="${dmbAddList}" var="dmb">
						<option value="${dmb.NDm}" data-href="${dmb.CBz}">${dmb.CMc}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="addinput"></div>
	</div>
	<div class="J_dlg" style="display:none;"></div>
	<div class="jrrck_dlg" style="display:none;">
		<div class="rclist"></div>
		<div class="notice">
			<select id="selectRclx" class="input-sm form-control">
				<option value="-1">请先选择要加入的人才库</option>
				<c:forEach items="${dmbRcList}" var="dmb">
					<option value="${dmb.NDm}">${dmb.CMc}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div id="jbbbxz_dlg" style="display:none;"></div>
	<div id="lskyr" style="display:none;text-align:center;">
		<div class="yrfy_div" style="margin-bottom:20px;display:inline-block;margin-top:20px;">
			<label for="yrfy">引入法院:</label>
			<input type="text" class="xzfy_yr input-sm form-control" value="请选择一个法院" style="display:inline-block;width:200px;"/>
			<input class="xzfyyr_fybh" name="fybh" value="320000 A00" type="hidden" />
		</div>
		<img src="/resources/images/loading.gif" id="loadingSpinner_lskyr" style="display:none;width:100px;height:100px;margin-top:50px;"/>
		<div class="yrbm_div" style="margin-bottom:20px;display:inline-block;">
			<label for="yrbm">引入部门:</label>
			<select name="yrbm" id="yrbm" class="input-sm form-control" style="display:inline-block;width:200px;">
				<option value="-1">请先选择部门</option>
			</select>
		</div>
		<div class="yrry_div" style="display:inline-block;">
			<label for="yrry">引入人员:</label>
			<select name="yrry" id="yrry" class="input-sm form-control" style="display:inline-block;width:200px;">
				<option value="-1">请先选择人员</option>
			</select>
		</div>
	</div>
</body>
</html>
