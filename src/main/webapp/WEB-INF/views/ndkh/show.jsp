<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/css/customtable.css">
<link rel="stylesheet" type="text/css" href="/resources/css/ndkh.css">
<script src="/resources/js/fusionCharts/FusionCharts.js"></script>
<script type="text/javascript">
	$(function() {
		$("#add_btn").click(function() {
			window.open("ndkhjtxx.do?sfkbj="+"1");
		});
		$("#bmtj_btn").hide();
		$("#gbcsp_btn").hide();
		$("#spzc_btn").hide();
		$("#spzcyx_btn").hide();
		$("#spbg_btn").hide();
		
		$.ajax({
			url : "ndkhyhqx.aj",
			type : "post",
			dataType : "json",
			success : function(json) {
				if (json[1] == "1") {
					$("#spzc_btn").show();
					$("#spzcyx_btn").show();
				}
				if (json[2] == "1") {
					$("bmtj_btn").show();
					$("#gbcsp_btn").show();
					$("#spbg_btn").show();
				}
				if (json[3] == "1") {
					$("#bmtj_btn").show();
					$("#spbg_btn").show();
				}
			}
		});
		
		$('#spbg_bm_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 500,
			width : 600,
			title : '列表',
			close : function() {

			}
		});
		
		$("#spbg_btn").live("click", function() {
			$.ajax({
				url : "/main/yjda/spbg.aj",
				type : "post",
				dataType : "html",
				success : function(html) {
					$("#spbg_bm_dlg").html(html).dialog("open");
				}
			});
		});
		
		$("#gbcsp_btn").live("click",function(){
			$.ajax({
				url:"/main/yjda/gbcsp.aj",
				type:"post",
				dataType:"html",
				success:function(html){
					$("#spbg_bm_dlg").html(html).dialog("open");
				}
			});
		});
		
		$("#bmtj_btn").live("click",function(){
			$.ajax({
				url:"/main/yjda/bmtj.aj",
				type:"post",
				dataType:"html",
				success:function(html){
					$("#spbg_bm_dlg").html(html).dialog("open");
				}
			});
		});
		
		$("#spzc_btn").live("click",function(){
			$.ajax({
				url:"/main/yjda/spzc.aj",
				type:"post",
				dataType:"html",
				success:function(html){
					$("#spbg_bm_dlg").html(html).dialog("open");
				}
			});
		});
		
		$("#spzcyx_btn").live("click",function(){
			$.ajax({
				url:"/main/yjda/spzcyx.aj",
				type:"post",
				dataType:"html",
				success:function(html){
					$("#spbg_bm_dlg").html(html).dialog("open");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="main_content">
		<div id="content"></div>
		<div id="content_bottom">
			<div id="chart_legend">
				<input type="button" id="youxiu"><span>优秀</span> <input
					type="button" id="chenzhi"><span>称职</span> <input
					type="button" id="qita"><span>其它</span>
			</div>
		</div>
	</div>
	<div class="main_content_bottom">
		<button type="button" class="btn btn-primary" id="bmtj_btn">
			<span class="glyphicon glyphicon-ok"></span> 部门统计
		</button>
		<button type="button" class="btn btn-primary" id="gbcsp_btn">
			<span class="glyphicon glyphicon-ok"></span> 干部处审批
		</button>
		<button type="button" class="btn btn-primary" id="spzc_btn">
			<span class="glyphicon glyphicon-ok"></span> 审批中层
		</button>
		<button type="button" class="btn btn-primary" id="spzcyx_btn">
			<span class="glyphicon glyphicon-ok"></span> 审批中层以下
		</button>
		<button type="button" class="btn btn-primary" id="spbg_btn">
			<span class="glyphicon glyphicon-ok"></span> 审批报告
		</button>
		<button type="button" class="btn btn-primary" id="add_btn">
			<span class="glyphicon glyphicon-search"></span> 填写考核
		</button>
	</div>
</body>
<script type="text/javascript">
	function openWindow(khnd) {
		if (khnd >= 2009) {
			window.open("ndkhjtxx.do?khnd="+khnd+"&sfkbj="+"0");
		} else {
			alert("对不起，执法业绩系统自2009年正式启用，请重新选择较晚时间！");
		}
	}

	$.ajax({
		url : "ndkh.aj",
		type : 'post',
		success : function(data) {
			showChart2("年度考核记录", "content", data);
		}
	});

	function showChart2(title, div, data) {
		var colors = new Array("00FF00", "0000FF", "FF0000");
		var chart = new FusionCharts("/resources/js/fusionCharts/Column3D.swf",
				title, "500", "400");
		chart.addParam("wmode", "transparent");
		var XML = "<graph caption='"+title+"' decimalPrecision='0' outCnvbaseFontSize='12' baseFontSize='11'>";
		for ( var i = 0; i < data.length; i++) {
			var n = 0;
			if (data[i].kh == 1) {
				n = 0;
			} else if (data[i].kh == 2) {
				n = 1;
			} else {
				n = 2;
			}
			XML += "<set name='" + data[i].nd + "' value='" + data[i].kh
					+ "' color='" + colors[n]
					+ "' link='JavaScript:openWindow(" + data[i].nd + ");'/>";
		}
		XML += "</graph>";
		chart.setDataXML(XML);
		chart.render(div);
	}
</script>
<div id="spbg_bm_dlg"></div>
</html>
