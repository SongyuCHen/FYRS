<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="../../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="/resources/css/demo_table.css" />
<style>
<!--
#titleContent {
	padding: 15px 0;
	background-color: #EEF7FD;
	border-bottom: 2px solid #96C8EB;
	color: #166092;
	font-size: 120%;
}

#spbglist{
	width:600px;
}
-->
</style>
<script type="text/javascript">
	
	var initTable = function(dataTableId) {
		$roles_oTable = $("#" + dataTableId + " .dataTable").dataTable({
			"sPaginationType" : "full_numbers",
			"bAutoWidth" : false,
			"sScrollY" : "272px",
			"sScrollX" : "560px",
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
	}
	$(function() {
		initTable("spbglist");
		var date = new Date();
		var year = date.getFullYear();
		var selectObj = document.getElementById("select-xznf");
		for ( var i = 1990; i < year + 10; i++) {
			selectObj.options.add(new Option(i, i));
		}
		selectObj.value = year;
		if ($("#xs").data("sfxs") != "1") {
			$("#xs").hide();
		}
		var strbm = $("#xs").data("bmlist");
		console.log(strbm);
		var s = strbm.substr(1,strbm.length-2);
		console.log(s);
		var bmarray = new Array();
		bmarray = s.split(", "); 
		if(bmarray.length!=0){
			var options = '';
			for ( var i = 0; i < bmarray.length; i+=2) {
				options += '<option value="' + bmarray[i] + '">'
						+ bmarray[i+1] + '</option>';
			}
			$("#select-xzbm option").remove();
			$("#select-xzbm").html(options);
		}
		$("#chaxun").live(
				"click",
				function() {
					if ($("#xs").is(":hidden")) {
						$.ajax({
							url : "ldspzc.aj",
							type : "post",
							data : {
								'year' : $("#select-xznf").val()
							},
							dataType : "json",
							success : function(json) {
								for ( var i = 0; i < json.length; i++) {
									var jsonobj = json[i];
									$roles_oTable.fnAddData([jsonobj[0],
											jsonobj[1], jsonobj[2], jsonobj[3],
											jsonobj[4], jsonobj[5], jsonobj[6],
											jsonobj[7], "<a href=spndkhjtxx.do?rybh="+jsonobj[8]+"&khnd="+jsonobj[9]+"&qx=2 target='_blank'>查看</a>" ]);
								}
							}
						});
					} else {
						$.ajax({
							url : "ldspzcyx.aj",
							type : "post",
							data : {
								'year' : $("#select-xznf").val(),
								'bm':$("#select-xzbm").val()
							},
							dataType : "json",
							success : function(json) {
								for ( var i = 0; i < json.length; i++) {
									var jsonobj = json[i];
									$roles_oTable.fnAddData([jsonobj[0],
											jsonobj[1], jsonobj[2], jsonobj[3],
											jsonobj[4], jsonobj[5], jsonobj[6],
											jsonobj[7], "<a href=spndkhjtxx.do?rybh="+jsonobj[8]+"&khnd="+jsonobj[9]+"&qx=1 target='_blank'>查看</a>" ]);
								}
							}
						});

					}

				});
	});
</script>
<div id="titleContent" class="form-horizontal">
	<div class="row">
		<div class="col-sm-5 col-md-5" style="display:inline-block;">
			<label class="col-sm-4 col-md-4 control-label" for="xzfy_ipt" style="display:inline-block;">年度：</label>
			<div class="col-sm-8 col-md-8" style="display:inline-block;">
				<select id="select-xznf" class="form-control" style="display:inline-block;">
					<option value="-1">请选择...</option>
				</select>
			</div>
		</div>
		<div class="col-sm-5 col-md-5" id="xs" data-sfxs=${gbcsp} data-bmList="${bmList}" style="display:inline-block;">
			<label class="col-sm-4 col-md-4 control-label" for="select-xzbm" style="display:inline-block;">部门：</label>
			<div class="col-sm-8 col-md-8" style="display:inline-block;">
				<select id="select-xzbm" class="form-control" style="display:inline-block;">
					
				</select>
			</div>
		</div>
		<div class="col-sm-2 col-md-2"style="display:inline-block;">
			<button type="button" class="btn btn-primary" id="chaxun" style="display:inline-block;">
				<span class="glyphicon glyphicon-search"></span> 查询
			</button>
		</div>
	</div>
</div>
<div id="spbglist" class="spbg" style="width:100%;">
	<table class="dataTable">
		<thead>
			<th>部门</th>
			<th>姓名</th>
			<th>性别</th>
			<th>政治面貌</th>
			<th>职务</th>
			<th>文化程度</th>
			<th>分管工作</th>
			<th>填表时间</th>
			<th>操作</th>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>
