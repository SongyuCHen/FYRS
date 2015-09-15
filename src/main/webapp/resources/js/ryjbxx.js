$(function() {
	/* 添加的操作html代码 */
	var operation_html = "<a class='dlg_view' data-btn_type='1'>查看</a><span>|</span>\t<a class='dlg_modify' data-btn_type='2'>修改</a><span>|</span>\t<a class='i_delete'>删除</a>";
	/* ryjbxx_left_menu点击事件 */
	$("#tree_ry li").live("click", function() {
		$href = $(this).data("type") + ".do?type=" + $(this).data("type");
		window.location = $href;
	});
	$(".J_dlg").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false
	});
	/* active选中的dataTable中的行 */
	function activeSelectTr($node) {
		$node.parent().parent().addClass("active");
	}
	/* 清除dataTable中选中行的active类 */
	function removeSelectTrActive(id) {
		$("#" + id + "_list .dataTable tbody .active").removeClass("active");
	}
	/* 删除选中的dataTable中的行 */
	function removeSelectTr($oTableLocal) {
		$oTableLocal.fnDeleteRow($oTableLocal.$("tr.active")[0]);
	}
	/* 刷新dataTable中最大的序号值 */
	function updateMaxIndex(id, value) {
		$node = $("#" + id + "_list .dataTable");
		if (value > $node.data("maxindex")) {
			$node.data("maxindex", value);
		} else if (value = $node.data("maxindex")) {
			$node.data("maxindex", value - 1);
		}
	}
	function checkInputRequired(id) {
		var result = 0;
		$("#" + id + "_table").find('.keyValue').each(function() {
			if ($.trim($(this).val()) == "") {
				result++;
			}
		});
		return result == 0 ? true : false;
	}
	// 函数检查必须为数字，可以为浮点数
	function checkDouble(str) {
		if (str != "") {
			var reg = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
			return reg.test(str);
		} else {
			return true;
		}
	}
	// 检查为正整数
	function checkInteger(str) {
		if (str != "") {
			var reg = /^[0-9]*[1-9][0-9]*$/;
			return reg.test(str);
		} else {
			return true;
		}

	}
	// 检查不超过当前年度
	function checkKHND(str) {
		if (str != "") {
			var date = new Date();
			var year = date.getFullYear();
			if(parseInt(str)>parseInt(year)){
				return false;
			}else{
				return true;
			}
			
		} else {
			return true;
		}

	}
	// 检查时间格式
	function checkTime(str) {
		if (str != "") {
			var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
			return reg.test(str);
		} else {
			return false;
		}

	}

	$rcxx_oTable = $('#rcxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 3 ]
		} ],
		"sScrollY" : "272px",
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

	/* 政治面貌 */
	$zzmm_oTable = $('#zzmm_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 行政职务 */
	$xzzw_oTable = $('#xzzw_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 7 ]
		} ],
		"sScrollY" : "272px",
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
	/* 法律职务 */
	$flzw_oTable = $('#flzw_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 7 ]
		} ],
		"sScrollY" : "272px",
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

	/* 职级信息 */
	$zjxx_oTable = $('#zjxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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

	/* 兼任职务 */
	$jrzw_oTable = $('#jrzw_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 等级信息 */
	$djxx_oTable = $('#djxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 公务员级别 */
	$gwyjb_oTable = $('#gwyjb_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 学历信息 */
	$xlxx_oTable = $('#xlxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 学位信息 */
	$xwxx_oTable = $('#xwxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 在读信息 */
	$zdxx_oTable = $('#zdxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 培训信息 */
	$pxxx_oTable = $('#pxxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 简历信息 */
	$jlxx_oTable = $('#jlxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 7 ]
		} ],
		"sScrollX" : "100%", // 横向滚动条
		"sScrollY" : "272px",
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
	/* 简历信息非在编 */
	$jlxxfzb_oTable = $('#jlxxfzb_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 7 ]
		} ],
		"sScrollX" : "100%", // 横向滚动条
		"sScrollY" : "272px",
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
	/* 家庭信息 */
	$jtxx_oTable = $('#jtxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 考核信息 */
	$khxx_oTable = $('#khxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 3 ]
		} ],
		"sScrollY" : "272px",
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
	/* 奖励信息 */
	$jlixx_oTable = $('#jianglxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 惩处信息 */
	$ccxx_oTable = $('#ccxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 出国信息 */
	$cgxx_oTable = $('#cgxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 外语信息 */
	$wyxx_oTable = $('#wyxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 4 ]
		} ],
		"sScrollY" : "272px",
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
	/* 交流信息 */
	$jliuxx_oTable = $('#jiaolxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 司法考试 */
	$sfks_oTable = $('#sfks_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 4 ]
		} ],
		"sScrollY" : "272px",
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
	/* 专业技术职务 */
	$zyjszw_oTable = $('#zyjszw_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 7 ]
		} ],
		"sScrollY" : "272px",
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
	/* 伤亡信息 */
	$swxx_oTable = $('#swxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 4 ]
		} ],
		"sScrollY" : "272px",
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
	/* 备注信息 */
	$bzxx_oTable = $('#bzxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 2 ]
		} ],
		"sScrollY" : "272px",
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
	/* 声音与影像 */
	$syyyx_oTable = $('#syyx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 3 ]
		} ],
		"sScrollY" : "272px",
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
	/* 工资信息 */
	$gzxx_oTable = $('#gzxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	/* 后备干部 */
	$hbgb_oTable = $('#hbgb_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 通讯录 */
	$txl_oTable = $('#txl_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 6 ]
		} ],
		"sScrollY" : "272px",
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
	/* 领导班子 */
	$ldbz_oTable = $('#ldbz_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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

	//合同信息
	$htxx_oTable = $('#htxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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

	
	/** ********弹窗控制*********** */
	$('#flzw_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——法律职务',
		close : function() {
			// 弹窗属性恢复到初始状态
			$zdybq.refresh();
			removeSelectTrActive("flzw");
		}
	});
	$('#flzw_list .dlg_view,#flzw_list  .dlg_modify,#flzw_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——法律职务", "查看——法律职务", "修改——法律职务" ];
						$
								.ajax({
									url : "flzw.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#flzw_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#flzw_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("flzw")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addFlzw.aj"
																			: "saveFlzw.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#flzw_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#flzw_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#flzw_table")
																				.data(
																						"keyid"),
																		'NRmlb' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NFlzw' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DRmrq' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CDw' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CBm' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NRmyy' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DPzrq' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CPzdw' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CPzwh' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#flzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												var tjqxxx = $(
																														"#flzw_table")
																														.children()
																														.children()
																														.eq(
																																4)
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "是") {
																													$node = $("#flzw_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		6);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#flzw_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NRmlb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.CDw);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.NFlzw);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DRmrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.DPzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(7)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					var index = $(
																																							"#flzw_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"flzw",
																																							index);
																																					$flzw_oTable
																																							.fnAddData([
																																									index,
																																									json.NRmlb,
																																									json.CDw,
																																									json.NFlzw,
																																									json.DRmrq,
																																									json.DPzrq,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($flzw_oTable
																																							.fnGetNodes($(
																																									"#flzw_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#flzw_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#flzw_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("flzw");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteFlzw.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#flzw_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"flzw",
																				value);
																		removeSelectTr($flzw_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#xzzw_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 400,
		width : 540,
		title : '查看——行政职务',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("xzzw");
		}
	});
	$('#xzzw_list .dlg_view,#xzzw_list  .dlg_modify,#xzzw_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——行政职务", "查看——行政职务", "修改——行政职务" ];
						$
								.ajax({
									url : "xzzw.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#xzzw_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#xzzw_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("xzzw")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addXzzw.aj"
																			: "saveXzzw.aj";
																	var value = {
																		'showKey' : $(
																				"#menu_list")
																				.data(
																						"showkey"),
																		'NId' : $(
																				"#xzzw_table")
																				.data(
																						"keyid"),
																		'NFy' : $(
																				"#xzzw_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#xzzw_table")
																				.data(
																						"rybh"),
																		'NRmlb' : $(
																				".mySelect")
																				.first()
																				.children()
																				.val(),
																		'NXzzw' : $(
																				".mySelect")
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DRmrq' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CDw' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CBm' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NRmyy' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DPzrq' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CPzdw' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CPzwh' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#xzzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												var tjqxxx = $(
																														"#xzzw_table")
																														.children()
																														.children()
																														.eq(
																																4)
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "是") {
																													$node = $("#xzzw_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		6);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					// 修改成功后的操作,active行数据的重新绑定
																																					$current_node = $("#xzzw_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NRmlb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.CDw);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.NXzzw);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DRmrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.DPzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(7)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					// 添加成功后的操作，dataTable中第一行添加一条新的记录
																																					var index = $(
																																							"#xzzw_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"xzzw",
																																							index);
																																					$xzzw_oTable
																																							.fnAddData([
																																									index,
																																									json.NRmlb,
																																									json.CDw,
																																									json.NXzzw,
																																									json.DRmrq,
																																									json.DPzrq,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($xzzw_oTable
																																							.fnGetNodes($(
																																									"#xzzw_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#xzzw_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#xzzw_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("xzzw");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteXzzw.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#xzzw_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"xzzw",
																				value);
																		removeSelectTr($xzzw_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#zjxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 320,
		width : 540,
		title : '查看——职级信息',
		clase : function() {
			$zdybq.refresh();
			removeSelectTrActive("zjxx");
		}
	});
	$('#zjxx_list .dlg_view,#zjxx_list  .dlg_modify,#zjxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						$
								.ajax({
									url : "zjxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type")
									},
									success : function(html) {
										$('#zjxx_dlg').html(html)
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#zjxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("zjxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
															}
															// type:0.添加 2.修改
															var type = $(this)
																	.data(
																			"type");
															var type_txt = type == 0 ? "添加"
																	: "修改";
															var type_url = type == 0 ? "addZjxx.aj"
																	: "saveZjxx.aj";
															var value = {
																'rmlb' : '1',
																'zj' : '1',
																'rmrq' : '1',
																'zjxz' : '1',
																'dw' : '1',
																'bm' : '1',
																'rmyy' : '1',
																'pzrq' : '1',
																'pzdw' : '1',
																'pzwh' : '1',
																'dqxx' : '1'
															};
															$(".J_dlg")
																	.html(
																			'<p>是否确定'
																					+ type_txt
																					+ '该数据？</p>')
																	.dialog(
																			{
																				'buttons' : {
																					'确定' : function() {
																						$
																								.ajax({
																									url : type_url,
																									type : 'post',
																									data : value,
																									dataType : 'json',
																									success : function(
																											json) {
																										// -1.失败
																										// 0.成功
																										// 其他：bh
																										if (json != -1) {
																											$(
																													'.J_dlg')
																													.children(
																															'p')
																													.remove();
																											$(
																													'.J_dlg')
																													.append(
																															'<p>'
																																	+ type_txt
																																	+ '成功！</p>')
																													.dialog(
																															{
																																'buttons' : {
																																	'确定' : function() {
																																		if (json == 0
																																				&& type == 2) {
																																			// 修改成功后的操作,active行数据的重新绑定
																																			$current_node = $("#zjxx_list .dataTable tbody .active");
																																			$current_node
																																					.find(
																																							"td:nth-child(2)")
																																					.text(
																																							value.rmlb);
																																			$current_node
																																					.find(
																																							"td:nth-child(3)")
																																					.text(
																																							value.zj);
																																			$current_node
																																					.find(
																																							"td:nth-child(4)")
																																					.text(
																																							value.rmrq);
																																			$current_node
																																					.find(
																																							"td:nth-child(5)")
																																					.text(
																																							value.pzrq);
																																			$current_node
																																					.find(
																																							"td:nth-child(6)")
																																					.text(
																																							value.dqxx);
																																		} else {
																																			// 添加成功后的操作，dataTable中第一行添加一条新的记录
																																			var index = $(
																																					"#zjxx_list .dataTable")
																																					.data(
																																							"maxindex") + 1;
																																			updateMaxIndex(
																																					"zjxx",
																																					index);
																																			$flzw_oTable
																																					.fnAddData([
																																							index,
																																							value.rmlb,
																																							value.zj,
																																							value.rmrq,
																																							value.pzrq,
																																							value.dqxx,
																																							operation_html ]);
																																			$new_row = $($flzw_oTable
																																					.fnGetNodes($(
																																							"#zjxx_list .dataTable tbody tr")
																																							.size() - 1));// 获得刚才新添加的列
																																			$new_row
																																					.find(
																																							"td")
																																					.addClass(
																																							"center");
																																			$new_row
																																					.find(
																																							"td:nth-child(3)")
																																					.removeClass(
																																							"center");
																																			$new_row
																																					.find(
																																							"td:last")
																																					.data(
																																							'zj',
																																							value.zj)
																																					.data(
																																							'zw',
																																							value.zjxz);
																																		}
																																		$(
																																				'.J_dlg')
																																				.dialog(
																																						'close');
																																		$(
																																				'#zjxx_dlg')
																																				.dialog(
																																						'close');
																																	}
																																}
																															})
																													.dialog(
																															"open");
																										} else {
																											var sError = type_txt
																													+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#zjxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var zj = $(this).parent().data('zj');
						var zw = $(this).parent().data('zw');
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("zjxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteZjxx.aj',
																type : 'post',
																data : {
																	zj : zj,
																	zw : zw
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#zjxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"zjxx",
																				value);
																		removeSelectTr($zjxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#jrzw_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——兼职任务',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("jzrw");
		}
	});
	$('#jrzw_list .dlg_view,#jrzw_list  .dlg_modify,#jrzw_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——兼任职务", "查看——兼任职务", "修改——兼任职务" ];
						$
								.ajax({
									url : "jrzw.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#jrzw_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#jrzw_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("jrzw")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addJrzw.aj"
																			: "saveJrzw.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#jrzw_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#jrzw_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#jrzw_table")
																				.data(
																						"keyid"),
																		'NRmlb' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'CJrzw' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.val(),
																		'DRmrq' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NRmyy' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'CDw' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CBm' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'DPzrq' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CPzdw' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CPzwh' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'NTbjl' : $(
																				"#jrzw_table")
																				.children()
																				.children()
																				.eq(
																						5)
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												var tjqxxx = $(
																														"#jrzw_table")
																														.children()
																														.children()
																														.eq(
																																4)
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "1") {
																													$node = $("#jrzw_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		5);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#jrzw_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NRmlb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.CJrzw);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DRmrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DPzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					var index = $(
																																							"#jrzw_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"jrzw",
																																							index);
																																					$jrzw_oTable
																																							.fnAddData([
																																									index,
																																									json.NRmlb,
																																									json.CJrzw,
																																									json.DRmrq,
																																									json.DPzrq,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($jrzw_oTable
																																							.fnGetNodes($(
																																									"#jrzw_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#jrzw_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#jrzw_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("jrzw");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteJrzw.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#jrzw_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"jrzw",
																				value);
																		removeSelectTr($jrzw_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#ccxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 250,
		width : 540,
		title : '查看——惩处信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("ccxx");
		}
	});
	$('#ccxx_list .dlg_view,#ccxx_list  .dlg_modify,#ccxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——惩处信息", "查看——惩处信息", "修改——惩处信息" ];
						$
								.ajax({
									url : "ccxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#ccxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#ccxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("ccxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addCcxx.aj"
																			: "saveCcxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#ccxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#ccxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#ccxx_table")
																				.data(
																						"keyid"),
																		'NCclb' : $(
																				"#ccxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NCcyy' : $(
																				"#ccxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DCcrq' : $(
																				"#ccxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DJcrq' : $(
																				"#ccxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CPzdw' : $(
																				"#ccxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#ccxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NCclb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NCcyy);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DCcrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DJcrq);
																																				} else {
																																					var index = $(
																																							"#ccxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"ccxx",
																																							index);
																																					$ccxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NCclb,
																																									json.NCcyy,
																																									json.DCcrq,
																																									json.DJcrq,
																																									operation_html ]);
																																					$new_row = $($ccxx_oTable
																																							.fnGetNodes($(
																																									"#ccxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#ccxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#ccxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("ccxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteCcxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#ccxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"ccxx",
																				value);
																		removeSelectTr($ccxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#cgxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——出国信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("cgxx");
		}
	});
	$('#cgxx_list .dlg_view,#cgxx_list  .dlg_modify,#cgxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——出国信息", "查看——出国信息", "修改——出国信息" ];
						$
								.ajax({
									url : "cgxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#cgxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#cgxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("cgxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addCgxx.aj"
																			: "saveCgxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#cgxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#cgxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#cgxx_table")
																				.data(
																						"keyid"),
																		'NGb' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NCgxz' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DKssj' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DJssj' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'NCgsf' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'CJfly' : $(
																				"#cgxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#cgxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NGb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NCgxz);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DKssj);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DJssj);
																																				} else {
																																					var index = $(
																																							"#cgxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"cgxx",
																																							index);
																																					$cgxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NGb,
																																									json.NCgxz,
																																									json.DKssj,
																																									json.DJssj,
																																									operation_html ]);
																																					$new_row = $($cgxx_oTable
																																							.fnGetNodes($(
																																									"#cgxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#cgxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#cgxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("cgxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteCgxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#cgxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"cgxx",
																				value);
																		removeSelectTr($cgxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#jtxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 360,
		width : 540,
		title : '查看——家庭信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("jtxx");
		}
	});
	$('#jtxx_list .dlg_view,#jtxx_list  .dlg_modify,#jtxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——家庭信息", "查看——家庭信息", "修改——家庭信息" ];
						$
								.ajax({
									url : "jtxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#jtxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#jtxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("jtxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkInteger($(
																		"#checkNum")
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>住房面积必须为正整数</p>')
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
																	if (!checkTime($(
																			"#checkDate1")
																			.val())) {
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
																	} else {
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addJtxx.aj"
																				: "saveJtxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#jtxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#jtxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#jtxx_table")
																					.data(
																							"keyid"),
																			'CXm' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NYbrgx' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'DCsrq' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NZzmm' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'CJtdh' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'CYzbm' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NZfmj' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'CJtzz' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CDwjzw' : $(
																					"#jtxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						$current_node = $("#jtxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.NYbrgx);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.CXm);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.DCsrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.NZzmm);
																																					} else {
																																						var index = $(
																																								"#jtxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"jtxx",
																																								index);
																																						$jtxx_oTable
																																								.fnAddData([
																																										index,
																																										json.NYbrgx,
																																										json.CXm,
																																										json.DCsrq,
																																										json.NZzmm,
																																										operation_html ]);
																																						$new_row = $($jtxx_oTable
																																								.fnGetNodes($(
																																										"#jtxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);
																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#jtxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#jtxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("jtxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteJtxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#jtxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"jtxx",
																				value);
																		removeSelectTr($jtxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#jlxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——简历信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("jlxx");
		}
	});
	$('#jlxx_list .dlg_view,#jlxx_list  .dlg_modify,#jlxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——简历信息", "查看——简历信息", "修改——简历信息" ];
						$
								.ajax({
									url : "jlxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#jlxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#jlxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("jlxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addJlxx.aj"
																			: "saveJlxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#jlxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#jlxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#jlxx_table")
																				.data(
																						"keyid"),
																		'CSzdw' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CSzbm' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.val(),
																		'DQsrq' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DJzrq' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CZw' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CZj' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CZmr' : $(
																				"#jlxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#jlxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.DQsrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DJzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.CSzdw);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.CSzbm);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.CZw);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.CZj);
																																				} else {
																																					var index = $(
																																							"#jlxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"jlxx",
																																							index);
																																					$jlxx_oTable
																																							.fnAddData([
																																									index,
																																									json.DQsrq,
																																									json.DJzrq,
																																									json.CSzdw,
																																									json.CSzbm,
																																									json.CZw,
																																									json.CZj,
																																									operation_html ]);
																																					$new_row = $($jlxx_oTable
																																							.fnGetNodes($(
																																									"#jlxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#jlxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#jlxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("jlxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteJlxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#jlxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"jlxx",
																				value);
																		removeSelectTr($jlxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#pxxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——培训信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("pxxx");
		}
	});
	$('#pxxx_list .dlg_view,#pxxx_list  .dlg_modify,#pxxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——培训信息", "查看——培训信息", "修改——培训信息" ];
						$
								.ajax({
									url : "pxxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#pxxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#pxxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("pxxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkInteger($(
																		"#checkNum")
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>学制必须为正整数</p>')
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
																	if (!checkTime($(
																			"#checkDate1")
																			.val())
																			|| !checkTime($(
																					"#checkDate2")
																					.val())) {
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
																	} else {
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addPxxx.aj"
																				: "savePxxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#pxxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#pxxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#pxxx_table")
																					.data(
																							"keyid"),
																			'NPxxs' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'DKsrq' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'DJsrq' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NJglb' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'CPxjg' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'CPxbmc' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NZy' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NXz' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CPxcj' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NPxfs' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NPxzl' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NSfqdzs' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NTbjl' : $(
																					"#pxxx_table")
																					.children()
																					.children()
																					.eq(
																							7)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						$current_node = $("#pxxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.NPxxs);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.CPxbmc);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.DKsrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.DJsrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(6)")
																																								.text(
																																										json.NZy);
																																					} else {
																																						var index = $(
																																								"#pxxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"pxxx",
																																								index);
																																						$pxxx_oTable
																																								.fnAddData([
																																										index,
																																										json.NPxxs,
																																										json.CPxbmc,
																																										json.DKsrq,
																																										json.DJsrq,
																																										json.NZy,
																																										operation_html ]);
																																						$new_row = $($pxxx_oTable
																																								.fnGetNodes($(
																																										"#pxxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);
																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#pxxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#pxxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("pxxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deletePxxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#pxxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"pxxx",
																				value);
																		removeSelectTr($pxxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#zdxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——在读信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zdxx");
		}
	});
	$('#zdxx_list .dlg_view,#zdxx_list  .dlg_modify,#zdxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——在读信息", "查看——在读信息", "修改——在读信息" ];
						$
								.ajax({
									url : "zdxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#zdxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#zdxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("zdxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkInteger($(
																		"#checkNum")
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>学制必须为正整数</p>')
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
																	if (!checkTime($(
																			"#checkDate1")
																			.val())) {
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
																	} else {
																		// type:0.添加
																		// 2.修改
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addZdxx.aj"
																				: "saveZdxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#zdxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#zdxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#zdxx_table")
																					.data(
																							"keyid"),
																			'NZdxl' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'DRxrq' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CZdyx' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NSxzy' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'CZdzy' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NJyxs' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NXxxs' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NXz' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NDqxx' : $(
																					"#zdxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													var tjqxxx = $(
																															"#zdxx_table")
																															.children()
																															.children()
																															.eq(
																																	4)
																															.children()
																															.last()
																															.children()
																															.children()
																															.val();
																													if (tjqxxx == "1") {
																														$node = $("#zdxx_list .dataTable tbody tr");
																														for ( var i = 0; i < $node.length; i++) {
																															$tdID = $node
																																	.eq(
																																			i)
																																	.children()
																																	.eq(
																																			5);
																															if ($tdID
																																	.text() == "是") {
																																$tdID
																																		.text("否");
																															}
																														}
																													}
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						$current_node = $("#zdxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.NZdxl);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.CZdzy);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.CZdyx);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.DRxrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(6)")
																																								.text(
																																										json.NDqxx);
																																					} else {
																																						var index = $(
																																								"#zdxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"zdxx",
																																								index);
																																						$zdxx_oTable
																																								.fnAddData([
																																										index,
																																										json.NZdxl,
																																										json.CZdzy,
																																										json.CZdyx,
																																										json.DRxrq,
																																										json.NDqxx,
																																										operation_html ]);
																																						$new_row = $($zdxx_oTable
																																								.fnGetNodes($(
																																										"#zdxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);
																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#zdxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#zdxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("zdxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteZdxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#zdxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"zdxx",
																				value);
																		removeSelectTr($zdxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#xwxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——学位信息',
		close : function() {
			// 弹窗属性恢复到初始状态
			$zdybq.refresh();
			removeSelectTrActive("xwxx");
		}
	});
	$('#xwxx_list  .dlg_view,#xwxx_list  .dlg_modify,#xwxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——学位信息", "查看——学位信息", "修改——学位信息" ];
						$
								.ajax({
									url : "xwxx.aj",
									type : "post",
									dataType : "html",
									/* btnType:0.添加 1.查看 2.修改 */
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#xwxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#xwxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("xwxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkInteger($(
																		"#xwxx_table")
																		.children()
																		.children()
																		.eq(5)
																		.children()
																		.eq(1)
																		.children()
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>学制必须为正整数</p>')
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
																	if (!checkTime($(
																			"#checkDate1")
																			.val())
																			|| !checkTime($(
																					"#checkDate2")
																					.val())
																			|| !checkTime($(
																					"#checkDate3")
																					.val())) {
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
																	} else {
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addXwxx.aj"
																				: "saveXwxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#xwxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#xwxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#xwxx_table")
																					.data(
																							"keyid"),
																			'NXw' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'DSyrq' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NSxzy' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'CSxzy' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CXxmc' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NXxlb' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NJyxs' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NXxxs' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'DRxrq' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'DByrq' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NXz' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NSygj' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NDqxx' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NTbjl' : $(
																					"#xwxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													var tjqxxx = $(
																															"#xwxx_table")
																															.children()
																															.children()
																															.eq(
																																	6)
																															.children()
																															.eq(
																																	1)
																															.children()
																															.children()
																															.val();
																													if (tjqxxx == "1") {
																														$node = $("#xwxx_list .dataTable tbody tr");
																														for ( var i = 0; i < $node.length; i++) {
																															$tdID = $node
																																	.eq(
																																			i)
																																	.children()
																																	.eq(
																																			5);
																															if ($tdID
																																	.text() == "是") {
																																$tdID
																																		.text("否");
																															}
																														}
																													}
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						// 修改成功后的操作,active行数据的重新绑定
																																						$current_node = $("#xwxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.NXw);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.NSxzy);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.CXxmc);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.DByrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(6)")
																																								.text(
																																										json.NDqxx);
																																					} else {
																																						var index = $(
																																								"#xwxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"xwxx",
																																								index);
																																						$xwxx_oTable
																																								.fnAddData([
																																										index,
																																										json.NXw,
																																										json.NSxzy,
																																										json.CXxmc,
																																										json.DByrq,
																																										json.NDqxx,
																																										operation_html ]);
																																						$new_row = $($xwxx_oTable
																																								.fnGetNodes($(
																																										"#xwxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);
																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#xwxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#xwxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("xwxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteXwxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#xwxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"xwxx",
																				value);
																		removeSelectTr($xwxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#xlxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——学历信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("xlxx");
		}
	});
	$('#xlxx_list .dlg_view,#xlxx_list  .dlg_modify,#xlxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——学历信息", "查看——学历信息", "修改——学历信息" ];
						$
								.ajax({
									url : "xlxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#xlxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#xlxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("xlxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkInteger($(
																		"#checkNum")
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>学制必须为正整数</p>')
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
																	if (!checkTime($(
																			"#checkDate1")
																			.val())
																			|| !checkTime($(
																					"#checkDate2")
																					.val())) {
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
																	} else {
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addXlxx.aj"
																				: "saveXlxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#xlxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#xlxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#xlxx_table")
																					.data(
																							"keyid"),
																			'NXl' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NSxzy' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'CSxzy' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CXxmc' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'NXxlb' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			"NJyxs" : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NXxxs' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'DRxrq' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'DByrq' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NXz' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			"CSydw" : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							5)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'NXxszgj' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NJyxl' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							6)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val(),
																			'NDqxx' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							7)
																					.children()
																					.eq(
																							1)
																					.children()
																					.children()
																					.val(),
																			'NTbjl' : $(
																					"#xlxx_table")
																					.children()
																					.children()
																					.eq(
																							7)
																					.children()
																					.last()
																					.children()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													var tjqxxx = $(
																															"#xlxx_table")
																															.children()
																															.children()
																															.eq(
																																	7)
																															.children()
																															.eq(
																																	1)
																															.children()
																															.children()
																															.val();
																													if (tjqxxx == "1") {
																														$node = $("#xlxx_list .dataTable tbody tr");
																														for ( var i = 0; i < $node.length; i++) {
																															$tdID = $node
																																	.eq(
																																			i)
																																	.children()
																																	.eq(
																																			5);
																															if ($tdID
																																	.text() == "是") {
																																$tdID
																																		.text("否");
																															}
																														}
																													}
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						// 修改成功后的操作,active行数据的重新绑定
																																						$current_node = $("#xlxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.NXl);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.NSxzy);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.CXxmc);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.DByrq);
																																						$current_node
																																								.find(
																																										"td:nth-child(6)")
																																								.text(
																																										json.NDqxx);
																																					} else {
																																						// 添加成功后的操作，dataTable中第一行添加一条新的记录
																																						var index = $(
																																								"#xlxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"xlxx",
																																								index);
																																						$xlxx_oTable
																																								.fnAddData([
																																										index,
																																										json.NXl,
																																										json.NSxzy,
																																										json.CXxmc,
																																										json.DByrq,
																																										json.NDqxx,
																																										operation_html ]);
																																						$new_row = $($xlxx_oTable
																																								.fnGetNodes($(
																																										"#xlxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);

																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#xlxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#xlxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("xlxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteXlxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#xlxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"xlxx",
																				value);
																		removeSelectTr($xlxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#zzmm_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——政治面貌',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zzmm");
		}
	});
	$('#zzmm_list .dlg_view,#zzmm_list  .dlg_modify,#zzmm_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——政治面貌", "查看——政治面貌", "修改——政治面貌" ];
						$
								.ajax({
									url : "zzmm.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#zzmm_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#zzmm_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															var result = checkInputRequired("zzmm");
															console.log(result);
															if (!result) {
																$(".J_dlg")
																		.html(
																				'<p>必填项不能为空！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addZzmm.aj"
																			: "saveZzmm.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#zzmm_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#zzmm_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#zzmm_table")
																				.data(
																						"keyid"),
																		'NZzmm' : $(
																				"#zzmm_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.first()
																				.next()
																				.children()
																				.children()
																				.first()
																				.val(),
																		'DJrrq' : $(
																				"#zzmm_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.val(),
																		'DZzrq' : $(
																				"#zzmm_table")
																				.children()
																				.children()
																				.first()
																				.next()
																				.children()
																				.first()
																				.next()
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#zzmm_table")
																				.children()
																				.children()
																				.first()
																				.next()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												console
																														.log(json.NId);
																												var tjqxxx = $(
																														"#zzmm_table")
																														.children()
																														.children()
																														.first()
																														.next()
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "1") {
																													$node = $("#zzmm_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		4);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#zzmm_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NZzmm);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DJrrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DZzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					var index = $(
																																							"#zzmm_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"zzmm",
																																							index);
																																					$zzmm_oTable
																																							.fnAddData([
																																									index,
																																									json.NZzmm,
																																									json.DJrrq,
																																									json.DZzrq,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($zzmm_oTable
																																							.fnGetNodes($(
																																									"#zzmm_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#zzmm_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#zzmm_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("zzmm");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteZzmm.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#zzmm_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"zzmm",
																				value);
																		removeSelectTr($zzmm_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#ldbz_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——领导班子',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("ldbz");
		}
	});
	$('#ldbz_list .dlg_view,#ldbz_list  .dlg_modify,#ldbz_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——领导班子", "查看——领导班子", "修改——领导班子" ];
						$
								.ajax({
									url : "ldbz.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#ldbz_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#ldbz_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("ldbz")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addLdbz.aj"
																		: "saveLdbz.aj";
																var value = {
																	'showKey' : $(
																			'#menu_list')
																			.data(
																					'showkey'),
																	'NFy' : $(
																			"#ldbz_table")
																			.data(
																					"fydm"),
																	'NRybh' : $(
																			"#ldbz_table")
																			.data(
																					"rybh"),
																	'NId' : $(
																			"#ldbz_table")
																			.data(
																					"keyid"),
																	'CQgzdw' : $(
																			"#ldbz_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'CQgzbm' : $(
																			"#ldbz_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.last()
																			.children()
																			.val(),
																	'NZw' : $(
																			"#ldbz_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.eq(
																					1)
																			.children()
																			.children()
																			.val(),
																	'NCjkc' : $(
																			"#ldbz_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.last()
																			.children()
																			.children()
																			.val(),
																	'NZqdzyj' : $(
																			"#ldbz_table")
																			.children()
																			.children()
																			.eq(
																					2)
																			.children()
																			.last()
																			.children()
																			.children()
																			.val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != null) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (type == 2) {
																																				$current_node = $("#ldbz_list .dataTable tbody .active");
																																				$current_node
																																						.find(
																																								"td:nth-child(2)")
																																						.text(
																																								json.CQgzdw);
																																				$current_node
																																						.find(
																																								"td:nth-child(3)")
																																						.text(
																																								json.CQgzbm);
																																				$current_node
																																						.find(
																																								"td:nth-child(4)")
																																						.text(
																																								json.NZw);
																																				$current_node
																																						.find(
																																								"td:nth-child(5)")
																																						.text(
																																								json.NCjkc);
																																			} else {
																																				var index = $(
																																						"#ldbz_list .dataTable")
																																						.data(
																																								"maxindex") + 1;
																																				updateMaxIndex(
																																						"ldbz",
																																						index);
																																				$ldbz_oTable
																																						.fnAddData([
																																								index,
																																								json.CQgzdw,
																																								json.CQgzbm,
																																								json.NZw,
																																								json.NCjkc,
																																								operation_html ]);
																																				$new_row = $($ldbz_oTable
																																						.fnGetNodes($(
																																								"#ldbz_list .dataTable tbody tr")
																																								.size() - 1));// 获得刚才新添加的列
																																				$new_row
																																						.find(
																																								"td")
																																						.addClass(
																																								"center");
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'keyid',
																																								json.NId);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'fydm',
																																								json.NFy);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'rybh',
																																								json.NRybh);
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#ldbz_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#ldbz_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("ldbz");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteLdbz.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#ldbz_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"ldbz",
																				value);
																		removeSelectTr($ldbz_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#txl_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——通讯录',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("txl");
		}
	});
	$('#txl_list .dlg_view,#txl_list  .dlg_modify,#txl_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——通讯录", "查看——通讯录", "修改——通讯录" ];
						$
								.ajax({
									url : "txl.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#txl_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#txl_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("txl")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addTxl.aj"
																		: "saveTxl.aj";
																var value = {
																	'showKey' : $(
																			"#menu_list")
																			.data(
																					"showkey"),
																	'NId' : $(
																			"#txl_table")
																			.data(
																					"keyid"),
																	'NFy' : $(
																			"#txl_table")
																			.data(
																					"fydm"),
																	'NRybh' : $(
																			"#txl_table")
																			.data(
																					"rybh"),
																	'CQh' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'CBgdh' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.last()
																			.children()
																			.val(),
																	'CJtdh' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'CYddh' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.last()
																			.children()
																			.val(),
																	'CYzbm' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.eq(
																					2)
																			.children()
																			.last()
																			.children()
																			.val(),
																	'CTxdz' : $(
																			"#txl_table")
																			.children()
																			.children()
																			.eq(
																					3)
																			.children()
																			.last()
																			.children()
																			.val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != null) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (type == 2) {
																																				$current_node = $("#txl_list .dataTable tbody .active");
																																				$current_node
																																						.find(
																																								"td:nth-child(2)")
																																						.text(
																																								json.CQh);
																																				$current_node
																																						.find(
																																								"td:nth-child(3)")
																																						.text(
																																								json.CBgdh);
																																				$current_node
																																						.find(
																																								"td:nth-child(4)")
																																						.text(
																																								json.CJtdh);
																																				$current_node
																																						.find(
																																								"td:nth-child(5)")
																																						.text(
																																								json.CYddh);
																																				$current_node
																																						.find(
																																								"td:nth-child(6)")
																																						.text(
																																								json.CYzbm);
																																			} else {
																																				var index = $(
																																						"#txl_list .dataTable")
																																						.data(
																																								"maxindex") + 1;
																																				updateMaxIndex(
																																						"txl",
																																						index);
																																				$txl_oTable
																																						.fnAddData([
																																								index,
																																								json.CQh,
																																								json.CBgdh,
																																								json.CJtdh,
																																								json.CYddh,
																																								json.CYzbm,
																																								operation_html ]);
																																				$new_row = $($txl_oTable
																																						.fnGetNodes($(
																																								"#txl_list .dataTable tbody tr")
																																								.size() - 1));// 获得刚才新添加的列
																																				$new_row
																																						.find(
																																								"td")
																																						.addClass(
																																								"center");
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'keyid',
																																								json.NId);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'fydm',
																																								json.NFy);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'rybh',
																																								json.NRybh);
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#txl_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#txl_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("txl");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteTxl.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#txl_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"txl",
																				value);
																		removeSelectTr($txl_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#hbgb_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——后备干部',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("hbgb");
		}
	});
	$('#hbgb_list .dlg_view,#hbgb_list  .dlg_modify,#hbgb_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——后备干部", "查看——后备干部", "修改——后备干部" ];
						$
								.ajax({
									url : "hbgb.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#hbgb_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#hbgb_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("hbgb")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addHbgb.aj"
																			: "saveHbgb.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#hbgb_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#hbgb_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#hbgb_table")
																				.data(
																						"keyid"),
																		'NHbzw' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NDlzw' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DKssj' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DJssj' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CDldw' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CJl' : $(
																				"#hbgb_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#hbgb_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NHbzw);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NDlzw);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.CDldw);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DKssj);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.DJssj);
																																				} else {
																																					var index = $(
																																							"#hbgb_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"hbgb",
																																							index);
																																					$hbgb_oTable
																																							.fnAddData([
																																									index,
																																									json.NHbzw,
																																									json.NDlzw,
																																									json.CDldw,
																																									json.DKssj,
																																									json.DJssj,
																																									operation_html ]);
																																					$new_row = $($hbgb_oTable
																																							.fnGetNodes($(
																																									"#hbgb_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#hbgb_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#hbgb_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("hbgb");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteHbgb.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#hbgb_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"hbgb",
																				value);
																		removeSelectTr($hbgb_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#gzxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——工资信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("gzxx");
		}
	});
	$('#gzxx_list .dlg_view,#gzxx_list  .dlg_modify,#gzxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——工资信息", "查看——工资信息", "修改——工资信息" ];
						$
								.ajax({
									url : "gzxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#gzxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#gzxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("gzxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	if (!checkDouble($(
																			"#checkDoubleNum1")
																			.val())
																			|| !checkDouble($(
																					"#checkDoubleNum2")
																					.val())
																			|| !checkDouble($(
																					"#checkDoubleNum3")
																					.val())
																			|| !checkDouble($(
																					"#checkDoubleNum4")
																					.val())
																			|| !checkDouble($(
																					"#checkDoubleNum5")
																					.val())) {
																		$(
																				".J_dlg")
																				.html(
																						'<p>请检查：级别工资额，职务工资额，职务岗位补贴，津贴，教、护龄津贴必须为数字</p>')
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
																		// type:0.添加
																		// 2.修改
																		var type = $(
																				this)
																				.data(
																						"type");
																		var type_txt = type == 0 ? "添加"
																				: "修改";
																		var type_url = type == 0 ? "addGzxx.aj"
																				: "saveGzxx.aj";
																		var value = {
																			'showKey' : $(
																					'#menu_list')
																					.data(
																							'showkey'),
																			'NFy' : $(
																					"#gzxx_table")
																					.data(
																							"fydm"),
																			'NRybh' : $(
																					"#gzxx_table")
																					.data(
																							"rybh"),
																			'NId' : $(
																					"#gzxx_table")
																					.data(
																							"keyid"),
																			'CZwgzdc' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'DZwgzdcsj' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.first()
																					.children()
																					.last()
																					.children()
																					.val(),
																			'CXjb' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'DXjbsj' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							1)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'MJbgze' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			'MZwgze' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							2)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'MZwgwbt' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.eq(
																							1)
																					.children()
																					.val(),
																			"MJt" : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							3)
																					.children()
																					.last()
																					.children()
																					.val(),
																			'MJhljt' : $(
																					"#gzxx_table")
																					.children()
																					.children()
																					.eq(
																							4)
																					.children()
																					.last()
																					.children()
																					.val()
																		};
																		$(
																				".J_dlg")
																				.html(
																						'<p>是否确定'
																								+ type_txt
																								+ '该数据？</p>')
																				.dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									$
																											.ajax({
																												url : type_url,
																												type : 'post',
																												data : value,
																												dataType : 'json',
																												success : function(
																														json) {
																													// -1.失败
																													// 0.成功
																													// 其他：bh
																													if (json != null) {
																														$(
																																'.J_dlg')
																																.children(
																																		'p')
																																.remove();
																														$(
																																'.J_dlg')
																																.append(
																																		'<p>'
																																				+ type_txt
																																				+ '成功！</p>')
																																.dialog(
																																		{
																																			'buttons' : {
																																				'确定' : function() {
																																					if (type == 2) {
																																						$current_node = $("#gzxx_list .dataTable tbody .active");
																																						$current_node
																																								.find(
																																										"td:nth-child(2)")
																																								.text(
																																										json.CZwgzdc);
																																						$current_node
																																								.find(
																																										"td:nth-child(3)")
																																								.text(
																																										json.DZwgzdcsj);
																																						$current_node
																																								.find(
																																										"td:nth-child(4)")
																																								.text(
																																										json.MZwgze);
																																						$current_node
																																								.find(
																																										"td:nth-child(5)")
																																								.text(
																																										json.MJbgze);
																																					} else {
																																						var index = $(
																																								"#gzxx_list .dataTable")
																																								.data(
																																										"maxindex") + 1;
																																						updateMaxIndex(
																																								"gzxx",
																																								index);
																																						$gzxx_oTable
																																								.fnAddData([
																																										index,
																																										json.CZwgzdc,
																																										json.DZwgzdcsj,
																																										json.MZwgze,
																																										json.MJbgze,
																																										operation_html ]);
																																						$new_row = $($gzxx_oTable
																																								.fnGetNodes($(
																																										"#gzxx_list .dataTable tbody tr")
																																										.size() - 1));// 获得刚才新添加的列
																																						$new_row
																																								.find(
																																										"td")
																																								.addClass(
																																										"center");
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'keyid',
																																										json.NId);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'fydm',
																																										json.NFy);
																																						$new_row
																																								.find(
																																										"td:last")
																																								.data(
																																										'rybh',
																																										json.NRybh);
																																					}
																																					$(
																																							'.J_dlg')
																																							.dialog(
																																									'close');
																																					$(
																																							'#gzxx_dlg')
																																							.dialog(
																																									'close');
																																				}
																																			}
																																		})
																																.dialog(
																																		"open");
																													} else {
																														var sError = type_txt
																																+ '操作没有执行成功，请重试！';
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
															}
														});
									}
								});
					});
	$("#gzxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("gzxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteGzxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#gzxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"gzxx",
																				value);
																		removeSelectTr($gzxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#swxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——伤亡信息',
		close : function() {
			$zdybq.reftresh();
			removeSelectTrActive("swxx");
		}
	});
	$('#swxx_list .dlg_view,#swxx_list  .dlg_modify,#swxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——伤亡信息", "查看——伤亡信息", "修改——伤亡信息" ];
						$
								.ajax({
									url : "swxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#swxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#swxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("swxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addSwxx.aj"
																			: "saveSwxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#swxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#swxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#swxx_table")
																				.data(
																						"keyid"),
																		'NSwcd' : $(
																				"#swxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NSwyy' : $(
																				"#swxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DSwrq' : $(
																				"#swxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#swxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NSwcd);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NSwyy);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DSwrq);
																																				} else {
																																					var index = $(
																																							"#swxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"swxx",
																																							index);
																																					$swxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NSwcd,
																																									json.NSwyy,
																																									json.DSwrq,
																																									operation_html ]);
																																					$new_row = $($swxx_oTable
																																							.fnGetNodes($(
																																									"#swxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#swxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#swxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("swxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteSwxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#swxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"swxx",
																				value);
																		removeSelectTr($swxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#bzxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——备注信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("bzxx");
		}
	});
	$('#bzxx_list .dlg_view,#bzxx_list  .dlg_modify,#bzxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——备注信息", "查看——备注信息", "修改——备注信息" ];
						$
								.ajax({
									url : "bzxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#bzxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#bzxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("bzxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addBzxx.aj"
																		: "saveBzxx.aj";
																var value = {
																	'showKey' : $(
																			"#menu_list")
																			.data(
																					"showkey"),
																	'NId' : $(
																			"#bzxx_table")
																			.data(
																					"keyid"),
																	'NFy' : $(
																			"#bzxx_table")
																			.data(
																					"fydm"),
																	'NRybh' : $(
																			"#bzxx_table")
																			.data(
																					"rybh"),
																	'CBz' : $(
																			"#bzxx_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.last()
																			.children()
																			.val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != null) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (type == 2) {
																																				$current_node = $("#bzxx_list .dataTable tbody .active");
																																				$current_node
																																						.find(
																																								"td:nth-child(2)")
																																						.text(
																																								json.CBz);
																																			} else {
																																				var index = $(
																																						"#bzxx_list .dataTable")
																																						.data(
																																								"maxindex") + 1;
																																				updateMaxIndex(
																																						"bzxx",
																																						index);
																																				$bzxx_oTable
																																						.fnAddData([
																																								index,
																																								json.CBz,
																																								operation_html ]);
																																				$new_row = $($bzxx_oTable
																																						.fnGetNodes($(
																																								"#bzxx_list .dataTable tbody tr")
																																								.size() - 1));// 获得刚才新添加的列
																																				$new_row
																																						.find(
																																								"td")
																																						.addClass(
																																								"center");
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'keyid',
																																								json.NId);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'fydm',
																																								json.NFy);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'rybh',
																																								json.NRybh);
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#bzxx_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#bzxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("bzxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteBzxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#bzxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"bzxx",
																				value);
																		removeSelectTr($bzxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#syyyx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——声音与影像',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("syyyx");
		}
	});
	$('#syyx_list .dlg_view,#syyx_list  .dlg_modify,#syyyx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						$
								.ajax({
									url : "syyyx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										bh : $(this).parent().data("bh")
									},
									success : function(html) {
										$('#syyyx_dlg').html(html).dialog(
												'open');
										$('#i_close').live('click', function() {
											$('#syyyx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("syyyx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addSyyyx.aj"
																		: "saveSyyyx.aj";
																var value = {
																	'NId' : $(
																			"#syyyx_table")
																			.data(
																					"bh"),
																	'CMs' : $(
																			"#syyyx_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.last()
																			.children()
																			.val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != -1) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (json == 0
																																					&& type == 2) {

																																			} else {

																																				window.location.href = "syyyx.do";
																																				//			    											
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#syyyx_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#syyx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var bh = $(this).parent().data("bh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("syyx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteSyyyx.aj',
																type : 'post',
																data : {
																	bh : bh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#syyx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"syyx",
																				value);
																		removeSelectTr($syyyx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#zyjszw_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——专业技术职务',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zyjszw");
		}
	});
	$('#zyjszw_list .dlg_view,#zyjszw_list  .dlg_modify,#zyjszw_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——专业技术职务", "查看——专业技术职务",
								"修改——专业技术职务" ];
						$
								.ajax({
									url : "zyjszw.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#zyjszw_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#zyjszw_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("zyjszw")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addZyjszw.aj"
																			: "saveZyjszw.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#zyjszw_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#zyjszw_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#zyjszw_table")
																				.data(
																						"keyid"),
																		'NQdmc' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NQdtj' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DQdrq' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NPrmc' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DPrrq' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NZcdj' : $(
																				"#zyjszw_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#zyjszw_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NQdmc);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NQdtj);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DQdrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NPrmc);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DPrrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NZcdj);
																																				} else {
																																					var index = $(
																																							"#zyjszw_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"zyjszw",
																																							index);
																																					$zyjszw_oTable
																																							.fnAddData([
																																									index,
																																									json.NQdmc,
																																									json.NQdtj,
																																									json.DQdrq,
																																									json.NPrmc,
																																									json.DPrrq,
																																									json.NZcdj,
																																									operation_html ]);
																																					$new_row = $($zyjszw_oTable
																																							.fnGetNodes($(
																																									"#zyjszw_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#zyjszw_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#zyjszw_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("zyjszw");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteZyjszw.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#zyjszw_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"zyjszw",
																				value);
																		removeSelectTr($zyjszw_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#sfks_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——司法考试',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("sfks");
		}
	});
	$('#sfks_list .dlg_view,#sfks_list  .dlg_modify,#sfks_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——司法考试", "查看——司法考试", "修改——司法考试" ];
						$
								.ajax({
									url : "sfks.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#sfks_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#sfks_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("sfks")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addSfks.aj"
																			: "saveSfks.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#sfks_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#sfks_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#sfks_table")
																				.data(
																						"keyid"),
																		'NZslx' : $(
																				"#sfks_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DBzrq' : $(
																				"#sfks_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CZsbh' : $(
																				"#sfks_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#sfks_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NZslx);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DBzrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.CZsbh);
																																				} else {
																																					var index = $(
																																							"#sfks_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"sfks",
																																							index);
																																					$sfks_oTable
																																							.fnAddData([
																																									index,
																																									json.NZslx,
																																									json.DBzrq,
																																									json.CZsbh,
																																									operation_html ]);
																																					$new_row = $($sfks_oTable
																																							.fnGetNodes($(
																																									"#sfks_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#sfks_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#sfks_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("sfks");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteSfks.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#sfks_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"sfks",
																				value);
																		removeSelectTr($sfks_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#jliuxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——交流信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("jliuxx");
		}
	});
	$('#jiaolxx_list .dlg_view,#jiaolxx_list  .dlg_modify,#jliuxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——交流信息", "查看——交流信息", "修改——交流信息" ];
						$
								.ajax({
									url : "jliuxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#jliuxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#jliuxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("jliuxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())
																		|| !checkTime($(
																				"#checkDate2")
																				.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addJliuxx.aj"
																			: "saveJliuxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#jliuxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#jliuxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#jliuxx_table")
																				.data(
																						"keyid"),
																		'NJllb' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NJlfs' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DKsrq' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'DJsrq' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'NJlzwxz' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'CJlzwmc' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CJlgzdw' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CJlgzbm' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'NTbjl' : $(
																				"#jliuxx_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#jiaolxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NJllb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NJlfs);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.NJlzwxz);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.DKsrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.DJsrq);
																																				} else {
																																					var index = $(
																																							"#jiaolxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"jiaolxx",
																																							index);
																																					$jliuxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NJllb,
																																									json.NJlfs,
																																									json.NJlzwxz,
																																									json.DKsrq,
																																									json.DJsrq,
																																									operation_html ]);
																																					$new_row = $($jliuxx_oTable
																																							.fnGetNodes($(
																																									"#jiaolxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																					//			    											
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#jliuxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#jiaolxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("jiaolxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteJliuxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#jiaolxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"jiaolxx",
																				value);
																		removeSelectTr($jliuxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#khxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——考核信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("khxx");
		}
	});
	$('#khxx_list .dlg_view,#khxx_list  .dlg_modify,#khxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——考核信息", "查看——考核信息", "修改——考核信息" ];
						$
								.ajax({
									url : "khxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#khxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#khxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("khxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkInteger($(
																		"#checkNum")
																		.val()) || !checkKHND($(
																		"#checkNum")
																		.val())) {
																	$(".J_dlg")
																			.html(
																					'<p>年度必须为正整数或年度必须不大于当前年度</p>')
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
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addKhxx.aj"
																			: "saveKhxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#khxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#khxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#khxx_table")
																				.data(
																						"keyid"),
																		'NNd' : $(
																				"#khxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.val(),
																		'NKhjg' : $(
																				"#khxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#khxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NNd);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NKhjg);
																																				} else {
																																					var index = $(
																																							"#khxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"khxx",
																																							index);
																																					$khxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NNd,
																																									json.NKhjg,
																																									operation_html ]);
																																					$new_row = $($khxx_oTable
																																							.fnGetNodes($(
																																									"#khxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#khxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#khxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("khxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteKhxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#khxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"khxx",
																				value);
																		removeSelectTr($khxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#jlixx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——奖励信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("jlixx");
		}
	});
	$('#jianglxx_list .dlg_view,#jianglxx_list  .dlg_modify,#jlixx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——奖励信息", "查看——奖励信息", "修改——奖励信息" ];
						$
								.ajax({
									url : "jlixx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#jlixx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#jlixx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("jlixx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																if (!checkTime($(
																		"#checkDate1")
																		.val())) {
																	$(".J_dlg")
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
																} else {
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addJlixx.aj"
																			: "saveJlixx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $("#jlixx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $("#jlixx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#jlixx_table")
																				.data(
																						"keyid"),
																		'NJllb' : $("#jlixx_table").children().children().first().children().eq(1).children().children().val(),
																		'CJllbsm' :$("#jlixx_table").children().children().first().children().last().children().val() ,
																		'NJlyy' : $("#jlixx_table").children().children().eq(1).children().eq(1).children().children().val(),
																		'CJlyyxx' : $("#jlixx_table").children().children().eq(1).children().last().children().val(),
																		'NGrqk' : $("#jlixx_table").children().children().eq(2).children().eq(1).children().children().val(),
																		'NJljb' : $("#jlixx_table").children().children().eq(2).children().last().children().children().val(),
																		'DJlsj' : $("#jlixx_table").children().children().eq(3).children().eq(1).children().val(),
																		'CPzwh' : $("#jlixx_table").children().children().eq(3).children().last().children().val(),
																		'CPzdw' : $("#jlixx_table").children().children().eq(4).children().last().children().val() 
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#jianglxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NJllb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NJlyy);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.NGrqk);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.NJljb);
																																				} else {
																																					var index = $(
																																							"#jianglxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"jianglxx",
																																							index);
																																					$jlixx_oTable
																																							.fnAddData([
																																									index,
																																									json.NJllb,
																																									json.NJlyy,
																																									json.NGrqk,
																																									json.NJljb,
																																									operation_html ]);
																																					$new_row = $($jlixx_oTable
																																							.fnGetNodes($(
																																									"#jianglxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#jlixx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#jianglxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("jianglxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteJlixx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#jianglxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"jianglxx",
																				value);
																		removeSelectTr($jlixx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#djxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 500,
		width : 540,
		title : '查看——等级信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("djxx");
		}
	});
	$('#djxx_list .dlg_view,#djxx_list  .dlg_modify,#djxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——等级信息", "查看——等级信息", "修改——等级信息" ];
						$
								.ajax({
									url : "djxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#djxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#djxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("djxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addDjxx.aj"
																			: "saveDjxx.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#djxx_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#djxx_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#djxx_table")
																				.data(
																						"keyid"),
																		'NDjlb' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NDjmc' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'DQsrq' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CPzwh' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'NBdlb' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'NBdyy' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'CPzdw' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'CZsbh' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						3)
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CBdyj' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#djxx_table")
																				.children()
																				.children()
																				.eq(
																						4)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												var tjqxxx = $(
																														"#djxx_table")
																														.children()
																														.children()
																														.eq(
																																4)
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "1") {
																													$node = $("#djxx_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		5);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#djxx_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NDjlb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.NDjmc);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.DQsrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.CZsbh);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					var index = $(
																																							"#djxx_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"djxx",
																																							index);
																																					$djxx_oTable
																																							.fnAddData([
																																									index,
																																									json.NDjlb,
																																									json.NDjmc,
																																									json.DQsrq,
																																									json.CZsbh,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($djxx_oTable
																																							.fnGetNodes($(
																																									"#djxx_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																					//			    											 
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#djxx_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#djxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("djxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteDjxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#djxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"djxx",
																				value);
																		removeSelectTr($djxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#gwyjb_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 400,
		width : 540,
		title : '查看——公务员级别',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("gwyjb");
		}
	});
	$('#gwyjb_list .dlg_view,#gwyjb_list  .dlg_modify,#gwyjb_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——公务员级别", "查看——公务员级别", "修改——公务员级别" ];
						$
								.ajax({
									url : "gwyjb.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#gwyjb_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#gwyjb_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("gwyjb")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																if (!checkTime($(
																		"#checkDate1")
																		.val())) {
																	$(".J_dlg")
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
																} else {
																	// type:0.添加
																	// 2.修改
																	var type = $(
																			this)
																			.data(
																					"type");
																	var type_txt = type == 0 ? "添加"
																			: "修改";
																	var type_url = type == 0 ? "addGwyjb.aj"
																			: "saveGwyjb.aj";
																	var value = {
																		'showKey' : $(
																				'#menu_list')
																				.data(
																						'showkey'),
																		'NFy' : $(
																				"#gwyjb_table")
																				.data(
																						"fydm"),
																		'NRybh' : $(
																				"#gwyjb_table")
																				.data(
																						"rybh"),
																		'NId' : $(
																				"#gwyjb_table")
																				.data(
																						"keyid"),
																		'NGwyjb' : $(
																				"#gwyjb_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.eq(
																						1)
																				.children()
																				.children()
																				.val(),
																		'DQsrq' : $(
																				"#gwyjb_table")
																				.children()
																				.children()
																				.first()
																				.children()
																				.last()
																				.children()
																				.val(),
																		'CDw' : $(
																				"#gwyjb_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.eq(
																						1)
																				.children()
																				.val(),
																		'NGzdc' : $(
																				"#gwyjb_table")
																				.children()
																				.children()
																				.eq(
																						1)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val(),
																		'NDqxx' : $(
																				"#gwyjb_table")
																				.children()
																				.children()
																				.eq(
																						2)
																				.children()
																				.last()
																				.children()
																				.children()
																				.val()
																	};
																	$(".J_dlg")
																			.html(
																					'<p>是否确定'
																							+ type_txt
																							+ '该数据？</p>')
																			.dialog(
																					{
																						'buttons' : {
																							'确定' : function() {
																								$
																										.ajax({
																											url : type_url,
																											type : 'post',
																											data : value,
																											dataType : 'json',
																											success : function(
																													json) {
																												// -1.失败
																												// 0.成功
																												// 其他：bh
																												var tjqxxx = $(
																														"#gwyjb_table")
																														.children()
																														.children()
																														.eq(
																																2)
																														.children()
																														.last()
																														.children()
																														.children()
																														.val();
																												if (tjqxxx == "1") {
																													$node = $("#gwyjb_list .dataTable tbody tr");
																													for ( var i = 0; i < $node.length; i++) {
																														$tdID = $node
																																.eq(
																																		i)
																																.children()
																																.eq(
																																		5);
																														if ($tdID
																																.text() == "是") {
																															$tdID
																																	.text("否");
																														}
																													}
																												}
																												if (json != null) {
																													$(
																															'.J_dlg')
																															.children(
																																	'p')
																															.remove();
																													$(
																															'.J_dlg')
																															.append(
																																	'<p>'
																																			+ type_txt
																																			+ '成功！</p>')
																															.dialog(
																																	{
																																		'buttons' : {
																																			'确定' : function() {
																																				if (type == 2) {
																																					$current_node = $("#gwyjb_list .dataTable tbody .active");
																																					$current_node
																																							.find(
																																									"td:nth-child(2)")
																																							.text(
																																									json.NGwyjb);
																																					$current_node
																																							.find(
																																									"td:nth-child(3)")
																																							.text(
																																									json.DQsrq);
																																					$current_node
																																							.find(
																																									"td:nth-child(4)")
																																							.text(
																																									json.CDw);
																																					$current_node
																																							.find(
																																									"td:nth-child(5)")
																																							.text(
																																									json.NGzdc);
																																					$current_node
																																							.find(
																																									"td:nth-child(6)")
																																							.text(
																																									json.NDqxx);
																																				} else {
																																					var index = $(
																																							"#gwyjb_list .dataTable")
																																							.data(
																																									"maxindex") + 1;
																																					updateMaxIndex(
																																							"gwyjb",
																																							index);
																																					$gwyjb_oTable
																																							.fnAddData([
																																									index,
																																									json.NGwyjb,
																																									json.DQsrq,
																																									json.CDw,
																																									json.NGzdc,
																																									json.NDqxx,
																																									operation_html ]);
																																					$new_row = $($gwyjb_oTable
																																							.fnGetNodes($(
																																									"#gwyjb_list .dataTable tbody tr")
																																									.size() - 1));// 获得刚才新添加的列
																																					$new_row
																																							.find(
																																									"td")
																																							.addClass(
																																									"center");
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'keyid',
																																									json.NId);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'fydm',
																																									json.NFy);
																																					$new_row
																																							.find(
																																									"td:last")
																																							.data(
																																									'rybh',
																																									json.NRybh);
																																				}
																																				$(
																																						'.J_dlg')
																																						.dialog(
																																								'close');
																																				$(
																																						'#gwyjb_dlg')
																																						.dialog(
																																								'close');
																																			}
																																		}
																																	})
																															.dialog(
																																	"open");
																												} else {
																													var sError = type_txt
																															+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#gwyjb_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("gwyjb");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteGwyjb.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#gwyjb_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"gwyjb",
																				value);
																		removeSelectTr($gwyjb_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#wyxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——外语信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("wyxx");
		}
	});
	$('#wyxx_list .dlg_view,#wyxx_list  .dlg_modify,#wyxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——外语信息", "查看——外语信息", "修改——外语信息" ];
						$
								.ajax({
									url : "wyxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#wyxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#wyxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("wyxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
															}
															// type:0.添加 2.修改
															var type = $(this)
																	.data(
																			"type");
															var type_txt = type == 0 ? "添加"
																	: "修改";
															var type_url = type == 0 ? "addWyxx.aj"
																	: "saveWyxx.aj";
															var value = {
																'showKey' : $(
																		'#menu_list')
																		.data(
																				'showkey'),
																'NFy' : $(
																		"#wyxx_table")
																		.data(
																				"fydm"),
																'NRybh' : $(
																		"#wyxx_table")
																		.data(
																				"rybh"),
																'NId' : $(
																		"#wyxx_table")
																		.data(
																				"keyid"),
																'NWyyz' : $(
																		"#wyxx_table")
																		.children()
																		.children()
																		.first()
																		.children()
																		.last()
																		.children()
																		.children()
																		.val(),
																'NSlcd' : $(
																		"#wyxx_table")
																		.children()
																		.children()
																		.eq(1)
																		.children()
																		.last()
																		.children()
																		.children()
																		.val(),
																'NSpjb' : $(
																		"#wyxx_table")
																		.children()
																		.children()
																		.eq(2)
																		.children()
																		.last()
																		.children()
																		.children()
																		.val()
															};
															$(".J_dlg")
																	.html(
																			'<p>是否确定'
																					+ type_txt
																					+ '该数据？</p>')
																	.dialog(
																			{
																				'buttons' : {
																					'确定' : function() {
																						$
																								.ajax({
																									url : type_url,
																									type : 'post',
																									data : value,
																									dataType : 'json',
																									success : function(
																											json) {
																										// -1.失败
																										// 0.成功
																										// 其他：bh
																										if (json != null) {
																											$(
																													'.J_dlg')
																													.children(
																															'p')
																													.remove();
																											$(
																													'.J_dlg')
																													.append(
																															'<p>'
																																	+ type_txt
																																	+ '成功！</p>')
																													.dialog(
																															{
																																'buttons' : {
																																	'确定' : function() {
																																		if (type == 2) {
																																			$current_node = $("#wyxx_list .dataTable tbody .active");
																																			$current_node
																																					.find(
																																							"td:nth-child(2)")
																																					.text(
																																							json.NWyyz);
																																			$current_node
																																					.find(
																																							"td:nth-child(3)")
																																					.text(
																																							json.NSlcd);
																																			$current_node
																																					.find(
																																							"td:nth-child(4)")
																																					.text(
																																							json.NSpjb);
																																		} else {
																																			var index = $(
																																					"#wyxx_list .dataTable")
																																					.data(
																																							"maxindex") + 1;
																																			updateMaxIndex(
																																					"wyxx",
																																					index);
																																			$wyxx_oTable
																																					.fnAddData([
																																							index,
																																							json.NWyyz,
																																							json.NSlcd,
																																							json.NSpjb,
																																							operation_html ]);
																																			$new_row = $($wyxx_oTable
																																					.fnGetNodes($(
																																							"#wyxx_list .dataTable tbody tr")
																																							.size() - 1));// 获得刚才新添加的列
																																			$new_row
																																					.find(
																																							"td")
																																					.addClass(
																																							"center");
																																			$new_row
																																					.find(
																																							"td:last")
																																					.data(
																																							'keyid',
																																							json.NId);
																																			$new_row
																																					.find(
																																							"td:last")
																																					.data(
																																							'fydm',
																																							json.NFy);
																																			$new_row
																																					.find(
																																							"td:last")
																																					.data(
																																							'rybh',
																																							json.NRybh);
																																		}
																																		$(
																																				'.J_dlg')
																																				.dialog(
																																						'close');
																																		$(
																																				'#wyxx_dlg')
																																				.dialog(
																																						'close');
																																	}
																																}
																															})
																													.dialog(
																															"open");
																										} else {
																											var sError = type_txt
																													+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#wyxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("wyxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteWyxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#wyxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"wyxx",
																				value);
																		removeSelectTr($wyxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});

	$('#rcxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 540,
		title : '查看——人才信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("rcxx");
		}
	});
	$('#rcxx_list .dlg_view,#rcxx_list  .dlg_modify,#rcxx_add_btn')
			.live(
					'click',
					function() {
						if ($(this).data("btn_type") != 0) {
							activeSelectTr($(this));
						}
						var btnType = $(this).data("btn_type");
						var typeStr = [ "添加——人才信息", "查看——人才信息", "修改——人才信息" ];
						$
								.ajax({
									url : "rcxx.aj",
									type : "post",
									dataType : "html",
									data : {
										btnType : $(this).data("btn_type"),
										keyid : $(this).parent().data("keyid"),
										fydm : $(this).parent().data("fydm"),
										rybh : $(this).parent().data("rybh")
									},
									success : function(html) {
										$('#rcxx_dlg').html(html).dialog(
												'option', 'title',
												typeStr[btnType])
												.dialog('open');
										$('#i_close').live('click', function() {
											$('#rcxx_dlg').dialog('close');
										});
										$("#i_save")
												.live(
														"click",
														function() {
															// 检查必填项是否已经填写完整：true.填写完整
															// false.不完整
															if (!checkInputRequired("rcxx")) {
																$(".J_dlg")
																		.html(
																				'<p>数据填写不完整，请返回充填！</p>')
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
																// type:0.添加
																// 2.修改
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addRcxx.aj"
																		: "saveRcxx.aj";
																var value = {
																	'showKey' : $(
																			'#menu_list')
																			.data(
																					'showkey'),
																	'NFy' : $(
																			"#rcxx_table")
																			.data(
																					"fydm"),
																	'NRybh' : $(
																			"#rcxx_table")
																			.data(
																					"rybh"),
																	'NId' : $(
																			"#rcxx_table")
																			.data(
																					"keyid"),
																	'NBm' : $(
																			"#rcxx_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.eq(
																					1)
																			.children()
																			.children()
																			.val(),
																	'NRclx' : $(
																			"#rcxx_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.last()
																			.children()
																			.children()
																			.val(),
																	'DPzsj' : $("#pzsj").val(),
																	'CPzdw' : $("#pzdw").val(),
																	'CPzbm' : $("#pzbm").val(),
																	'CPzwh' : $("#pzwh").val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != null) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (type == 2) {
																																				$current_node = $("#rcxx_list .dataTable tbody .active");
																																				$current_node
																																						.find(
																																								"td:nth-child(2)")
																																						.text(
																																								json.NBm);
																																				$current_node
																																						.find(
																																								"td:nth-child(3)")
																																						.text(
																																								json.NRclx);
																																			} else {
																																				var index = $(
																																						"#rcxx_list .dataTable")
																																						.data(
																																								"maxindex") + 1;
																																				updateMaxIndex(
																																						"rcxx",
																																						index);
																																				$rcxx_oTable
																																						.fnAddData([
																																								index,
																																								json.NBm,
																																								json.NRclx,
																																								operation_html ]);
																																				$new_row = $($rcxx_oTable
																																						.fnGetNodes($(
																																								"#rcxx_list .dataTable tbody tr")
																																								.size() - 1));// 获得刚才新添加的列
																																				$new_row
																																						.find(
																																								"td")
																																						.addClass(
																																								"center");
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'keyid',
																																								json.NId);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'fydm',
																																								json.NFy);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'rybh',
																																								json.NRybh);
																																				//			    											 
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#rcxx_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
														});
									}
								});
					});
	$("#rcxx_list .i_delete")
			.live(
					'click',
					function() {
						activeSelectTr($(this));
						var keyid = $(this).parent().data("keyid");
						var fydm = $(this).parent().data("fydm");
						var rybh = $(this).parent().data("rybh");
						$(".J_dlg")
								.html('<p>是否确定刪除该数据？</p>')
								.dialog(
										{
											close : function() {
												removeSelectTrActive("rcxx");
											},
											'buttons' : {
												'确定' : function() {
													$
															.ajax({
																url : 'deleteRcxx.aj',
																type : 'post',
																data : {
																	keyid : keyid,
																	fydm : fydm,
																	rybh : rybh
																},
																dataType : 'json',
																success : function(
																		json) {
																	// 0.失败 1.成功
																	if (json == "1") {
																		var value = $(
																				"#rcxx_list .dataTable tbody .active")
																				.find(
																						"td:first")
																				.text();
																		updateMaxIndex(
																				"rcxx",
																				value);
																		removeSelectTr($rcxx_oTable);
																		$(
																				'.J_dlg')
																				.dialog(
																						'close');
																	} else {
																		// Todo
																		// Handle
																		// Error
																		// Msg
																		var sError = '删除操作没有执行成功，请重试！';
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
													$(this).dialog('close');
												}
											}
										}).dialog('open');
					});



























$('#jlxxfzb_dlg').dialog({
	autoOpen : false,
	bgiframe : true,
	modal : true,
	resizable : false,
	height : 350,
	width : 540,
	title : '查看——简历信息',
	close : function() {
		$zdybq.refresh();
		removeSelectTrActive("jlxxfzb");
	}
});
$('#jlxxfzb_list .dlg_view,#jlxxfzb_list  .dlg_modify,#jlxxfzb_add_btn')
		.live(
				'click',
				function() {
					if ($(this).data("btn_type") != 0) {
						activeSelectTr($(this));
					}
					var btnType = $(this).data("btn_type");
					var typeStr = [ "添加——简历信息", "查看——简历信息", "修改——简历信息" ];
					$
							.ajax({
								url : "jlxxfzb.aj",
								type : "post",
								dataType : "html",
								data : {
									btnType : $(this).data("btn_type"),
									keyid : $(this).parent().data("keyid"),
									fydm : $(this).parent().data("fydm"),
									rybh : $(this).parent().data("rybh")
								},
								success : function(html) {
									$('#jlxxfzb_dlg').html(html).dialog(
											'option', 'title',
											typeStr[btnType])
											.dialog('open');
									$('#i_close').live('click', function() {
										$('#jlxxfzb_dlg').dialog('close');
									});
									$("#i_save")
											.live(
													"click",
													function() {
														// 检查必填项是否已经填写完整：true.填写完整
														// false.不完整
														if (!checkInputRequired("jlxxfzb")) {
															$(".J_dlg")
																	.html(
																			'<p>数据填写不完整，请返回充填！</p>')
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
															// type:0.添加
															// 2.修改
															if (!checkTime($(
																	"#checkDate1")
																	.val())
																	|| !checkTime($(
																			"#checkDate2")
																			.val())) {
																$(".J_dlg")
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
															} else {
																var type = $(
																		this)
																		.data(
																				"type");
																var type_txt = type == 0 ? "添加"
																		: "修改";
																var type_url = type == 0 ? "addJlxxfzb.aj"
																		: "saveJlxxfzb.aj";
																var value = {
																	'showKey' : $(
																			'#menu_list')
																			.data(
																					'showkey'),
																	'NFy' : $(
																			"#jlxxfzb_table")
																			.data(
																					"fydm"),
																	'NRybh' : $(
																			"#jlxxfzb_table")
																			.data(
																					"rybh"),
																	'NId' : $(
																			"#jlxxfzb_table")
																			.data(
																					"keyid"),
																	'CSzdw' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'CSzbm' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.first()
																			.children()
																			.last()
																			.children()
																			.val(),
																	'DQsrq' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'DJzrq' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.eq(
																					1)
																			.children()
																			.last()
																			.children()
																			.val(),
																	'CZw' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.eq(
																					2)
																			.children()
																			.last()
																			.children()
																			.val(),
																	'CZj' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.eq(
																					3)
																			.children()
																			.eq(
																					1)
																			.children()
																			.val(),
																	'CZmr' : $(
																			"#jlxxfzb_table")
																			.children()
																			.children()
																			.eq(
																					3)
																			.children()
																			.last()
																			.children()
																			.val()
																};
																$(".J_dlg")
																		.html(
																				'<p>是否确定'
																						+ type_txt
																						+ '该数据？</p>')
																		.dialog(
																				{
																					'buttons' : {
																						'确定' : function() {
																							$
																									.ajax({
																										url : type_url,
																										type : 'post',
																										data : value,
																										dataType : 'json',
																										success : function(
																												json) {
																											// -1.失败
																											// 0.成功
																											// 其他：bh
																											if (json != null) {
																												$(
																														'.J_dlg')
																														.children(
																																'p')
																														.remove();
																												$(
																														'.J_dlg')
																														.append(
																																'<p>'
																																		+ type_txt
																																		+ '成功！</p>')
																														.dialog(
																																{
																																	'buttons' : {
																																		'确定' : function() {
																																			if (type == 2) {
																																				$current_node = $("#jlxxfzb_list .dataTable tbody .active");
																																				$current_node
																																						.find(
																																								"td:nth-child(2)")
																																						.text(
																																								json.DQsrq);
																																				$current_node
																																						.find(
																																								"td:nth-child(3)")
																																						.text(
																																								json.DJzrq);
																																				$current_node
																																						.find(
																																								"td:nth-child(4)")
																																						.text(
																																								json.CSzdw);
																																				$current_node
																																						.find(
																																								"td:nth-child(5)")
																																						.text(
																																								json.CSzbm);
																																				$current_node
																																						.find(
																																								"td:nth-child(6)")
																																						.text(
																																								json.CZw);
																																				$current_node
																																						.find(
																																								"td:nth-child(6)")
																																						.text(
																																								json.CZj);
																																			} else {
																																				var index = $(
																																						"#jlxxfzb_list .dataTable")
																																						.data(
																																								"maxindex") + 1;
																																				updateMaxIndex(
																																						"jlxxfzb",
																																						index);
																																				$jlxxfzb_oTable
																																						.fnAddData([
																																								index,
																																								json.DQsrq,
																																								json.DJzrq,
																																								json.CSzdw,
																																								json.CSzbm,
																																								json.CZw,
																																								json.CZj,
																																								operation_html ]);
																																				$new_row = $($jlxxfzb_oTable
																																						.fnGetNodes($(
																																								"#jlxxfzb_list .dataTable tbody tr")
																																								.size() - 1));// 获得刚才新添加的列
																																				$new_row
																																						.find(
																																								"td")
																																						.addClass(
																																								"center");
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'keyid',
																																								json.NId);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'fydm',
																																								json.NFy);
																																				$new_row
																																						.find(
																																								"td:last")
																																						.data(
																																								'rybh',
																																								json.NRybh);
																																			}
																																			$(
																																					'.J_dlg')
																																					.dialog(
																																							'close');
																																			$(
																																					'#jlxxfzb_dlg')
																																					.dialog(
																																							'close');
																																		}
																																	}
																																})
																														.dialog(
																																"open");
																											} else {
																												var sError = type_txt
																														+ '操作没有执行成功，请重试！';
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
													});
								}
							});
				});

$("#jlxxfzb_list .i_delete")
		.live(
				'click',
				function() {
					activeSelectTr($(this));
					var keyid = $(this).parent().data("keyid");
					var fydm = $(this).parent().data("fydm");
					var rybh = $(this).parent().data("rybh");
					$(".J_dlg")
							.html('<p>是否确定刪除该数据？</p>')
							.dialog(
									{
										close : function() {
											removeSelectTrActive("jlxxfzb");
										},
										'buttons' : {
											'确定' : function() {
												$
														.ajax({
															url : 'deleteJlxxfzb.aj',
															type : 'post',
															data : {
																keyid : keyid,
																fydm : fydm,
																rybh : rybh
															},
															dataType : 'json',
															success : function(
																	json) {
																// 0.失败 1.成功
																if (json == "1") {
																	var value = $(
																			"#jlxxfzb_list .dataTable tbody .active")
																			.find(
																					"td:first")
																			.text();
																	updateMaxIndex(
																			"jlxxfzb",
																			value);
																	removeSelectTr($jlxxfzb_oTable);
																	$(
																			'.J_dlg')
																			.dialog(
																					'close');
																} else {
																	// Todo
																	// Handle
																	// Error
																	// Msg
																	var sError = '删除操作没有执行成功，请重试！';
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
												$(this).dialog('close');
											}
										}
									}).dialog('open');
				});



	//合同信息
	$('#htxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——合同信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("htxx");
		}
	});

	$('#htxx_list .dlg_view,#htxx_list  .dlg_modify,#htxx_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——合同信息", "查看——合同信息", "修改——合同信息" ];
		$.ajax({
			url : "htxx.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#htxx_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#htxx_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("htxx")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addhtxx.aj": "savehtxx.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#htxx_table").data("fydm"),
								'NRybh' : $("#htxx_table").data("rybh"),
								'NId' : $("#htxx_table").data("keyid"),
								'CHtbh':$("#htxx_table [name='CHtbh']").val(),
								'DQdrq':$("#htxx_table [name='DQdrq']").val(),
								'CHtqx':$("#htxx_table [name='CHtqx']").val(),
								'CPrzw':$('#htxx_table').children().children().eq(1).children().last().children().children().eq(0).val(),
								'CBz':$("#htxx_table [name='CBz']").val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#htxx_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.CHtbh);
																	$current_node.find("td:nth-child(3)").text(json.DQdrq);
																	$current_node.find("td:nth-child(4)").text(json.CHtqx);
																	$current_node.find("td:nth-child(5)").text(json.CPrzw);
																	$current_node.find("td:nth-child(6)").text(json.CBz);
																} else {
																	var index = $("#htxx_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("htxx",index);
																	$htxx_oTable.fnAddData([index,json.CHtbh,json.DQdrq,json.CHtqx,json.CPrzw,json.CBz,operation_html]);
																	$new_row = $($htxx_oTable.fnGetNodes($("#htxx_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#htxx_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#htxx_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("htxx");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletehtxx.aj',
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
								var value = $("#htxx_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("htxx",value);
								removeSelectTr($htxx_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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
	

	//职级信息
	$('#zjxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 450,
		width : 540,
		title : '查看——职级信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zjxx");
		}
	});

	$('#zjxx_list .dlg_view,#zjxx_list .dlg_modify,#zjxx_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = ["添加——职级信息","查看——职级信息","修改——职级信息"];
		$.ajax({
			url : "zjxx.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#zjxx_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#zjxx_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("zjxx")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addzjxx.aj": "savezjxx.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#htxx_table").data("fydm"),
								'NRybh' : $("#htxx_table").data("rybh"),
								'NId' : $("#htxx_table").data("keyid"),
								'NRmlb': $("#zjxx_table").children().children().first().children().eq(1).children().children().val(),
								'NZj' : $("#zjxx_table").children().children().first().children().last().children().children().val(),
								'DRmrq' : $("#zjxx_table").children().children().eq(1).children().eq(1).children().val(),
								'NZjxz' : $("#zjxx_table").children().children().eq(1).children().last().children().children().val(),
								'CDw' : $("#zjxx_table").children().children().eq(2).children().eq(1).children().val(),
								'CBm' : $("#zjxx_table").children().children().eq(2).children().last().children().val(),
								'NRmyy' : $("#zjxx_table").children().children().eq(3).children().last().children().children().val(),
								'DPzrq': $("#zjxx_table").children().children().eq(4).children().eq(1).children().val(),
								'CPzdw' : $("#zjxx_table").children().children().eq(4).children().last().children().val(),
								'CPzwh' : $("#zjxx_table").children().children().eq(5).children().eq(1).children().val(),
								'NDqxx' : $("#zjxx_table").children().children().eq(5).children().last().children().children().val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#zjxx_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.NRmlb);
																	$current_node.find("td:nth-child(3)").text(json.NZj);
																	$current_node.find("td:nth-child(4)").text(json.DRmrq);
																	$current_node.find("td:nth-child(5)").text(json.NDqxx);
																} else {
																	var index = $("#zjxx_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("zjxx",index);
																	$zjxx_oTable.fnAddData([index,json.NRmlb,json.NZj,json.DRmrq,json.NDqxx,operation_html]);
																	$new_row = $($zjxx_oTable.fnGetNodes($("#zjxx_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#zjxx_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#zjxx_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("zjxx");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletezjxx.aj',
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
								var value = $("#zjxx_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("zjxx",value);
								removeSelectTr($zjxx_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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


	//休假信息
	$xjxx_oTable = $('#xjxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	
	$('#xjxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——休假信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("xjxx");
		}
	});

	$('#xjxx_list .dlg_view,#xjxx_list  .dlg_modify,#xjxx_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——休假信息", "查看——休假信息", "修改——休假信息" ];
		$.ajax({
			url : "xjxx.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#xjxx_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#xjxx_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("xjxx")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addxjxx.aj": "savexjxx.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#xjxx_table").data("fydm"),
								'NRybh' : $("#xjxx_table").data("rybh"),
								'NId' : $("#xjxx_table").data("keyid"),
								'DKssj':$("#xjxx_table").find(".even_td").eq(0).children().val(),
								'DJssj':$("#xjxx_table").find(".even_td").eq(1).children().val(),
								'NXjts':$("#xjxx_table").find(".even_td").eq(2).children().val(),
								'NType':$("#xjxx_table").find(".even_td").eq(3).children().children().val(),
								'CXjsy':$("#xjxx_table").find(".even_td").eq(4).children().val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#xjxx_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.DKssj);
																	$current_node.find("td:nth-child(3)").text(json.DJssj);
																	$current_node.find("td:nth-child(4)").text(json.NXjts);
																	$current_node.find("td:nth-child(5)").text(json.NType);
																	$current_node.find("td:nth-child(6)").text(json.CXjsy);
																} else {
																	var index = $("#xjxx_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("xjxx",index);
																	$xjxx_oTable.fnAddData([index,json.DKssj,json.DJssj,json.NXjts,json.NTypte,json.CXjsy,operation_html]);
																	$new_row = $($xjxx_oTable.fnGetNodes($("#xjxx_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#xjxx_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#xjxx_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("xjxx");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletexjxx.aj',
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
								var value = $("#xjxx_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("xjxx",value);
								removeSelectTr($xjxx_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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
	
	//在岗情况
	$zgqk_oTable = $('#zgqk_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	
	$('#zgqk_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——在岗情况',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zgqk");
		}
	});

	$('#zgqk_list .dlg_view,#zgqk_list  .dlg_modify,#zgqk_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——在岗情况", "查看——在岗情况", "修改——在岗情况" ];
		$.ajax({
			url : "zgqk.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#zgqk_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#zgqk_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("zgqk")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addzgqk.aj": "savezgqk.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#zgqk_table").data("fydm"),
								'NRybh' : $("#zgqk_table").data("rybh"),
								'NId' : $("#zgqk_table").data("keyid"),
								'CPzwh':$("#zgqk_table").find(".even_td").eq(0).children().val(),
								'DBgsj':$("#zgqk_table").find(".even_td").eq(1).children().val(),
								'CBmbefore':$("#zgqk_table").find(".even_td").eq(2).children().children().val(),
								'CBmafter':$("#zgqk_table").find(".even_td").eq(3).children().children().val(),
								'CBz':$("#zgqk_table").find(".even_td").eq(4).children().val(),
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#zgqk_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.CPzwh);
																	$current_node.find("td:nth-child(3)").text(json.DBgsj);
																	$current_node.find("td:nth-child(4)").text(json.CBmbefore);
																	$current_node.find("td:nth-child(5)").text(json.CBmafter);
																	$current_node.find("td:nth-child(6)").text(json.CBz);
																} else {
																	var index = $("#zgqk_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("zgqk",index);
																	$zgqk_oTable.fnAddData([index,json.CPzwh,json.DBgsj,json.CBmbefore,json.CBmafter,json.CBz,operation_html]);
																	$new_row = $($zgqk_oTable.fnGetNodes($("#zgqk_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#zgqk_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#zgqk_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("zgqk");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletezgqk.aj',
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
								var value = $("#zgqk_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("zgqk",value);
								removeSelectTr($zgqk_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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

	//职级变动信息
	$zjbbxx_oTable = $('#zjbbxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	
	$('#zjbbxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——职级变动信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("zjbbxx");
		}
	});

	$('#zjbbxx_list .dlg_view,#zjbbxx_list  .dlg_modify,#zjbbxx_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——职级变动信息", "查看——职级变动信息", "修改——职级变动信息" ];
		$.ajax({
			url : "zjbbxx.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#zjbbxx_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#zjbbxx_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("zjbbxx")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addzjbbxx.aj": "savezjbbxx.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#zjbbxx_table").data("fydm"),
								'NRybh' : $("#zjbbxx_table").data("rybh"),
								'NId' : $("#zjbbxx_table").data("keyid"),
								'CPzwh':$("#zjbbxx_table").find(".even_td").eq(0).children().val(),
								'DBgsj':$("#zjbbxx_table").find(".even_td").eq(1).children().val(),
								'CZjbefore':$("#zjbbxx_table").find(".even_td").eq(2).children().children().val(),
								'CZjafter':$("#zjbbxx_table").find(".even_td").eq(3).children().children().val(),
								'CBz':$("#zjbbxx_table").find(".even_td").eq(4).children().val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#zjbbxx_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.CPzwh);
																	$current_node.find("td:nth-child(3)").text(json.DBgsj);
																	$current_node.find("td:nth-child(4)").text(json.CZjbefore);
																	$current_node.find("td:nth-child(5)").text(json.CZjafter);
																	$current_node.find("td:nth-child(6)").text(json.CBz);
																} else {
																	var index = $("#zjbbxx_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("zjbbxx",index);
																	$zjbbxx_oTable.fnAddData([index,json.CPzwh,json.DBgsj,json.CZjbefore,json.CZjafter,json.CBz,operation_html]);
																	$new_row = $($zjbbxx_oTable.fnGetNodes($("#zjbbxx_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#zjbbxx_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#zjbbxx_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("zjbbxx");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletezjbbxx.aj',
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
								var value = $("#zjbbxx_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("zjbbxx",value);
								removeSelectTr($zjbbxx_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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

	//薪酬福利信息
	$xcflxx_oTable = $('#xcflxx_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	
	$('#xcflxx_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——薪酬福利信息',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("xcflxx");
		}
	});

	$('#xcflxx_list .dlg_view,#xcflxx_list  .dlg_modify,#xcflxx_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——薪酬福利信息", "查看——薪酬福利信息", "修改——薪酬福利信息" ];
		$.ajax({
			url : "xcflxx.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#xcflxx_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#xcflxx_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("xcflxx")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addxcflxx.aj": "savexcflxx.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#xcflxx_table").data("fydm"),
								'NRybh' : $("#xcflxx_table").data("rybh"),
								'NId' : $("#xcflxx_table").data("keyid"),
								'DFfsj':$("#xcflxx_table").find(".even_td").eq(0).children().val(),
								'MJbxc':$("#xcflxx_table").find(".even_td").eq(1).children().val(),
								'MFlbt':$("#xcflxx_table").find(".even_td").eq(2).children().val(),
								'NKq':$("#xcflxx_table").find(".even_td").eq(3).children().val(),
								'CBz':$("#xcflxx_table").find(".even_td").eq(4).children().val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#xcflxx_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.DFfsj);
																	$current_node.find("td:nth-child(3)").text(json.MJbxc);
																	$current_node.find("td:nth-child(4)").text(json.MFlbt);
																	$current_node.find("td:nth-child(5)").text(json.NKq);
																	$current_node.find("td:nth-child(6)").text(json.CBz);
																	
																} else {
																	var index = $("#xcflxx_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("xcflxx",index);
																	$xcflxx_oTable.fnAddData([index,json.DFfsj,json.MJbxc,json.MFlbt,json.CBz,operation_html]);
																	$new_row = $($xcflxx_oTable.fnGetNodes($("#xcflxx_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#xcflxx_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#xcflxx_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("xcflxx");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletexcflxx.aj',
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
								var value = $("#xcflxx_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("xcflxx",value);
								removeSelectTr($xcflxx_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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


	//社保记录
	$sbjl_oTable = $('#sbjl_list .dataTable').dataTable({
		"sPaginationType" : "full_numbers",
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 5 ]
		} ],
		"sScrollY" : "272px",
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
	
	$('#sbjl_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 350,
		width : 540,
		title : '查看——社保记录',
		close : function() {
			$zdybq.refresh();
			removeSelectTrActive("sbjl");
		}
	});

	$('#sbjl_list .dlg_view,#sbjl_list  .dlg_modify,#sbjl_add_btn').live('click',function() {
		if ($(this).data("btn_type") != 0) {
			activeSelectTr($(this));
		}
		var btnType = $(this).data("btn_type");
		var typeStr = [ "添加——社保记录", "查看——社保记录", "修改——社保记录" ];
		$.ajax({
			url : "sbjl.aj",
			type : "post",
			dataType : "html",
			data : {
				btnType : $(this).data("btn_type"),
				keyid : $(this).parent().data("keyid"),
				fydm : $(this).parent().data("fydm"),
				rybh : $(this).parent().data("rybh")
			},
			success : function(html) {
				$('#sbjl_dlg').html(html).dialog('option', 'title',typeStr[btnType]).dialog('open');
				$('#i_close').live('click', function() {
					$('#sbjl_dlg').dialog('close');
				});
				$("#i_save").live("click",function() {
					// 检查必填项是否已经填写完整：true.填写完整
					// false.不完整
					if (!checkInputRequired("sbjl")) {
						$(".J_dlg").html('<p>数据填写不完整，请返回充填！</p>').dialog({
							'buttons' : {
								'确定' : function() {
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
					} else {
						if (!checkTime($("#checkDate1").val())) {
							$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
								'buttons' : {
									'确定' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						} else {
							var type = $(this).data("type");
							var type_txt = type == 0 ? "添加": "修改";
							var type_url = type == 0 ? "addsbjl.aj": "savesbjl.aj";
							var value = {
								'showKey' : $('#menu_list').data('showkey'),
								'NFy' : $("#sbjl_table").data("fydm"),
								'NRybh' : $("#sbjl_table").data("rybh"),
								'NId' : $("#sbjl_table").data("keyid"),
								'NType':$("#sbjl_table").find(".even_td").eq(0).children().children().val(),
								'DKssj':$("#sbjl_table").find(".even_td").eq(1).children().val(),
								'DJssj':$("#sbjl_table").find(".even_td").eq(2).children().val(),
								'MGryj':$("#sbjl_table").find(".even_td").eq(3).children().val(),
								'MDwyj':$("#sbjl_table").find(".even_td").eq(4).children().val(),
								'MFyhj':$("#sbjl_table").find(".even_td").eq(5).children().val()
							};
							$(".J_dlg").html('<p>是否确定'+ type_txt+ '该数据？</p>').dialog({
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
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p>'+ type_txt+ '成功！</p>').dialog({
														'buttons' : {
															'确定' : function() {
																if (type == 2) {
																	$current_node = $("#sbjl_list .dataTable tbody .active");
																	$current_node.find("td:nth-child(2)").text(json.NType);
																	$current_node.find("td:nth-child(3)").text(json.DKssj);
																	$current_node.find("td:nth-child(4)").text(json.DJssj);
																	$current_node.find("td:nth-child(5)").text(json.MGryj);
																	$current_node.find("td:nth-child(5)").text(json.MDwyj);
																	$current_node.find("td:nth-child(5)").text(json.MFyhj);
																} else {
																	var index = $("#sbjl_list .dataTable").data("maxindex") + 1;
																	updateMaxIndex("sbjl",index);
																	$sbjl_oTable.fnAddData([index,json.NType,json.DKssj,json.DJssj,json.MGryj,json.MDwyj,json.MFyhj,operation_html]);
																	$new_row = $($sbjl_oTable.fnGetNodes($("#sbjl_list .dataTable tbody tr").size() - 1));// 获得刚才新添加的列
																	$new_row.find("td").addClass("center");
																	$new_row.find("td:last").data('keyid',json.NId);
																	$new_row.find("td:last").data('fydm',json.NFy);
																	$new_row.find("td:last").data('rybh',json.NRybh);
																}
																$('.J_dlg').dialog('close');
																$('#sbjl_dlg').dialog('close');
															}
														}
													}).dialog("open");
												} else {
													var sError = type_txt+ '操作没有执行成功，请重试！';
													$('.J_dlg').children('p').remove();
													$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
														'buttons' : {
															'确定' : function() {
																$('.J_dlg').dialog('close');
															}
														}
													}).dialog("open");
												}
											}
										});
								},
									'取消' : function() {
										$(".J_dlg").dialog("close");
									}
								}
							}).dialog("open");
						}
					}
				});
			}
		});
	});

	$("#sbjl_list .i_delete").live('click',function() {
		activeSelectTr($(this));
		var keyid = $(this).parent().data("keyid");
		var fydm = $(this).parent().data("fydm");
		var rybh = $(this).parent().data("rybh");
		$(".J_dlg").html('<p>是否确定刪除该数据？</p>').dialog({
			close : function() {
				removeSelectTrActive("sbjl");
			},
			'buttons' : {
				'确定' : function() {
					$.ajax({
						url : 'deletesbjl.aj',
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
								var value = $("#sbjl_list .dataTable tbody .active").find("td:first").text();
								updateMaxIndex("sbjl",value);
								removeSelectTr($sbjl_oTable);
								$('.J_dlg').dialog('close');
							} else {
								var sError = '删除操作没有执行成功，请重试！';
									$('.J_dlg').children('p').remove();
									$('.J_dlg').append('<p class="error">'+ sError + '</p>').dialog({
										'buttons' : {
											'确定' : function() {
												$('.J_dlg').dialog('close');
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
});
