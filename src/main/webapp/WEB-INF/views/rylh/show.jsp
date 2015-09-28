<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script src="/resources/jstree/jquery.jstree.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/css/demo_table.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/time-line.css" />

<style type="text/css">
#rylh-head {
	text-align: center;
	    padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
	font-size: 110%;
}

#rylh-head span {
	margin-left: 15px;
}

#line_branch {
	padding: 5px;
}

#m-image {
	float: left;
}

#infoTable {
	float: left;
}

#time-show {
	clear: both;
}

#time-left {
	width: 60px;
	background-image: url("/resources/images/time-select-bg.png");
	background-repeat: repeat-y;
	background-position: 45px;
	float: left;
}

#time-left ul {
	list-style-type: none;
	padding-left: 0px;
}

#time-left ul li {
	margin: 10px 0px;
}

#time-left ul li span {
	width: 40px;
	display: -moz-inline-box;
	display: inline-block;
	vertical-align: middle;
}

#time-right {
	vertical-align: top;
	background-image: url("/resources/images/time-show-bg.png");
	background-repeat: repeat-y;
	background-position: 65px;
	height: 350px;
	overflow: scroll;
	float: left;
	padding-right: 15px;
}

#time-right-ul {
	list-style-type: none;
	padding-left: 0px;
}

#time-right-ul .time-show-circle {
	padding: 0px 0px;
	margin-left: 0px;
	vertical-align: top;
	margin-top: 7px;
}

#time-right-ul .time-show-arrow {
	margin-left: 10px;
	padding: 0px 0px;
}

.time-title {
	display: inline-block;
	vertical-align: top;
	margin-top: 20px;
	width: 60px;
	height: 24px;
}

.time-title-image {
	display: inline-block;
	vertical-align: top;
	margin-top: 20px;
	height: 24px;
}

#time-right-content-ul {
	padding: 0px 0px;
	display: inline-block;
	list-style-type: none;
	background-image: url("/resources/images/time-event-bg2.gif");
	width: 585px;
	background-repeat: no-repeat;
	background-size: cover;
	margin-left: -4px;
	margin-top: 10px;
	margin-bottom: 10px;
}

#time-right-content-ul li {
	margin-top: 10px;
	margin-bottom: 10px;
}

#time-right-content-ul li a {
	margin-left: 15px;
}

.tableHead th{
	text-align:center;
}
</style>
<script type="text/javascript">
	$(function() {
		/* $("#infoTable").dataTable({
   			'sPaginationType' : 'full_numbers',
   			'iDisplayLength' : 10,
			"sPaginationType" : "full_numbers",
			"bStateSave" : true,
			'bPaginate' : true,
			'bAutoWidth' : false,
			"bLengthChange" : false,
			"bFilter" : false,
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
  			}
   		}); */
   		var timeShowHeight = 0;
   		$("#time-show .time-line-time").each(function(){
   			timeShowHeight += $(this).height()+20;
   		});
   		$("#time-show .time-line-panel").each(function(){
   			timeShowHeight += $(this).height();
   		});
		$("#time-line-line").css("height",timeShowHeight);
		
		
		
		
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
		// 当点击姓名时
		$("#nameListSel")
				.change(
						function() {
							var name = $("#nameListSel option:selected").val();
							if (name.length < 0 || name == -1) {
								alert("请选择姓名！");
								return;
							}
							$
									.ajax({
										url : "/main/rslh/getNameInfo.aj",
										type : 'post',
										dataType : 'json',
										data : {
											'fyDm' : $(".xzfy_fybh").val(),
											'bmDm' : $(
													"#select-xzbm option:selected")
													.attr("value"),
											'ku' : $(
													"#rylh-head-ku option:selected")
													.val(),
											'name' : name
										},
										success : function(json) {
											var html = '';
											html += '<td>' + json.CXm + '</td>';
											html += '<td>' + json.xb + '</td>';
											html += '<td>' + json.nl + '</td>';
											html += '<td>' + json.xzzwMc
													+ '</td>';
											html += '<td>' + json.NZj + '</td>';
											html += '<td>' + json.NXl + '</td>';
											html += '<td showKey="'+json.showKey+'"><a href="javascript:void(0)" class="i_bb">基本</a></td>';
											html += '<td showKey="'+json.showKey+'"><a href="javascript:void(0)" class="i_yjdack">查看</a></td>';
											html += '<td showKey="'+json.showKey+'"><a href="javascript:void(0)" class="i_ck">查看</a></td>';
											$("#perPhoto")
													.attr(
															"src",
															"/photo.do?showKey="
																	+ json.showKey
																	+ "");
											$("#infoTr").attr("data-fydm",
													json.NFy);
											$("#infoTr").attr("data-rybh",
													json.NRybh);
											$("#infoTr").html("").html(html);
										}
									});
							$.ajax({
								url : "/main/rslh/getNameEvent.aj",
								type : 'post',
								dataType : 'html',
								data : {
									'fyDm' : $(".xzfy_fybh").val(),
									'bmDm' : $("#select-xzbm option:selected")
											.attr("value"),
									'ku' : $("#rylh-head-ku option:selected")
											.val(),
									'name' : name
								},
								success : function(html) {
									$("#time-show").children().remove();
									$("#time-show").html(html);
								}
							});
						});
		// 滚动事件 
		$("#time-right")
				.scroll(
						function() {

							var i = 0;
							var currenSelect;
							$(".time-title").each(
									function() {
										if ($(this).offset().top > $(
												"#time-right").offset().top
												&& i == 0) {
											currenSelect = $(this);
											i++;
										}

									});

							var html = '<img src="/resources/images/time-select.png" style="margin-left: 5px;vertical-align: middle;">';
							$("#time-left ul li")
									.each(
											function() {
												$(this).children("img")
														.remove();
												if ($(this).children("span")
														.text() == currenSelect
														.children("a").text()) {
													$(this).append(html);
												}
											});
						});
		// 查看事件
		// 查看
		$(".i_ck").live('click', function() {
			var showKey = $(this).parent().attr("showkey");
			window.open("/ryjbxx.do?showKey=" + showKey);
		});
		$(".i_bb").live('click', function() {

			$.ajax({
				url : "/main/ryxx/jbbbxz.aj",
				type : "post",
				data : {
					'showKey' : $(this).parent().attr("showkey")
				},
				dataType : 'html',
				success : function(html) {
					$("#jbbbxz_dlg").html(html).dialog("open");
				}
			});
		});
		$(".i_yjdack").live('click', function() {
			var showKey = $(this).parent().attr("showkey");
			window.open("/gryjda.do?showKey=" + showKey);
		});
	});// jquery
	// 当部门被选择时
	var selectBmAfter = function() {
		var selectValue = $("#select-xzbm option:selected").attr("value");
		if (-1 == selectValue) {
			alert("请选择一个部门");
			return;
		}
		var selKu = $("#rylh-head-ku option:selected").val();
		$.ajax({
			url : "/main/rslh/getNameList.aj",
			type : 'post',
			dataType : 'json',
			data : {
				'fyDm' : $(".xzfy_fybh").val(),
				'bmDm' : $("#select-xzbm option:selected").attr("value"),
				'ku' : selKu
			},
			success : function(json) {
				var html = '<option value="-1">请选择姓名</option>';
				for ( var i = 0; i < json.length; i++) {
					html += '<option value="'+json[i]+'">' + json[i]
							+ '</option>';
				}
				$("#nameListSel").html("").html(html);
			}
		});
	};
</script>
</head>
<body>
	<div id="rylh-head">
		<span>所在库:<select style="width: 80px;" id="rylh-head-ku">
				<c:forEach items="${kus}" var="ku">
					<option value="${ku.NDm}">${ku.CMc}</option>
				</c:forEach>
		</select> </span><span> 法院：<input style="width:175px" type="text"
			class="xzfy_ipt" value="请选择一个法院" /><input class="xzfy_fybh"
			name="fybh" value="320000 A00" type="hidden" /> </span> <span> 部门：<select
			id="select-xzbm" style="width:150px;">
				<option value="1">请先选择法院</option>
		</select> </span> <span>姓名:<select style="width: 120px;" id="nameListSel"></select>
		</span>
	</div>
	<div>
		<span id="m-image"><img alt="个人图片"
			src="/resources/images/moren.png" id="perPhoto" width="97px"
			height="122px"> </span>
		<table id="infoTable" class="dataTable">
			<thead>
				<tr class="tableHead">
					<th width="60px">姓名</th>
					<th width="40px">性别</th>
					<th width="40px">年龄</th>
					<th width="120px">行政职务</th>
					<th width="80px">职级</th>
					<th width="80px">学历</th>
					<th width="80px">报表</th>
					
					<th width="80px">操作</th>
					<th width="80px"></th>
				</tr>
			</thead>
			<tbody>
				<tr style="height: 50px;text-align: center;" id="infoTr"
					data-fydm="" data-rybh="">
				</tr>
			</tbody>
		</table>
	</div>
	<div id="time-show" class="time-line-wrapper">
		<img id="time-line-line" src="/resources/images/time-line.png"/>
		<div class="time-line-day">
			<div class="time-line-time">2015年9月28日</div>
			<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading">Panel heading without title</div>
  						<div class="panel-body">
    						Panel content
  						</div>
  					</div>
				</div>
			</div>
			<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading">Panel heading without title</div>
  						<div class="panel-body">
    						Panel content
  						</div>
  					</div>
				</div>
			</div>
		</div>
		<div class="time-line-day">
			<div class="time-line-time">2015年9月26日</div>
			<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading">Panel heading without title</div>
  						<div class="panel-body">
    						Panel content
  						</div>
  					</div>
				</div>
			</div>
		</div>
		<div class="time-line-day">
			<div class="time-line-time">2015年9月26日</div>
			<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading">Panel heading without title</div>
  						<div class="panel-body">
    						Panel content
  						</div>
  					</div>
				</div>
			</div>
		</div>
		<div class="time-line-day">
			<div class="time-line-time">2015年9月26日</div>
			<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading">Panel heading without title</div>
  						<div class="panel-body">
    						Panel content
  						</div>
  					</div>
				</div>
			</div>
		</div>
	
	
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1" isFyAndBm="0"></div>
	<div id="jbbbxz_dlg" style="display:none;"></div>
</body>
</html>
