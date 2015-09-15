<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>年度考核具体信息</title>
<script type="text/javascript"
	src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.treeview.js"></script>
<script type="text/javascript" src="resources/js/zdybq.js"></script>

<link rel="stylesheet" type="text/css"
	href="/resources/css/ndkhjtxx.css">
<link rel="stylesheet"
	href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
<!-- bootstrap -->
<script type="text/javascript"
	src="/resources/bootstrap/js/bootstrap.min.js">
</script>
<link rel="stylesheet" type="text/css" media="screen"
	href="/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="/resources/bootstrap/css/bootstrap-theme.min.css" />
<!-- 兼容IE8 -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="resources/css/dlg.css" />

<script type="text/javascript">
	$(function() {
		var sfkbj = $(".content").data("sfkbj");
		if (sfkbj == "0") {
			var s = $("#niandu").text();
			var nd = s.substr(1, 4);
			var selectObj = document.getElementById("select-jieguo");
			selectObj.value = $("#select-jieguo").data("khjg");
			$("#grzjimg").html(
					"<img src='/main/yjda/getSign.do?rybh="
							+ $("#tableCont").data("bh") + "&nd=" + nd
							+ "&pic=grzjimg' onerror="+"this.src="+"'/resources/images/white_background.PNG'"+">");
			$(".myDate_label").prop({
				"disabled" : true
			});
			$("#fggz").attr("readonly", "readonly");
			$("#grzjnr").attr("readonly", "readonly");
			$("#sign_button").prop({
				disabled : true
			});

			$("#select-jieguo").prop({
				disabled : true
			});
			$("#zgldpy").attr("readonly", "readonly");
			$("#ldpy_button").prop({
				disabled : true
			});
			$("#jgfzrhkhwyhyj").attr("readonly", "readonly");
			$("#jgfzrkh_button").prop({
				disabled : true
			});
			$("#gryjnr").attr("readonly", "readonly");
			$("#gryj_button").prop({
				disabled : true
			});
			$("#wqddchbcjkhqksm").attr("readonly", "readonly");
			$("#wqddc_button").prop({
				disabled : true
			});
			$("#tjbg").prop({
				disabled : true
			});
		} else if(sfkbj != ""){
			$zdybq.changeDateFromLabelToPicker();
			$("#select-jieguo").prop({
				disabled : true
			});
			$("#zgldpy").attr("readonly", "readonly");
			$("#ldpy_button").prop({
				disabled : true
			});
			$("#jgfzrhkhwyhyj").attr("readonly", "readonly");
			$("#jgfzrkh_button").prop({
				disabled : true
			});
			$("#gryjnr").attr("readonly", "readonly");
			$("#gryj_button").prop({
				disabled : true
			});
			$("#wqddchbcjkhqksm").attr("readonly", "readonly");
			$("#wqddc_button").prop({
				disabled : true
			});
			$("#dybg").prop({
				disabled : true
			});
		}
		var qx = $("#tableCont").data("qx");
		if (qx == "1") {
			var s = $("#niandu").text();
			var nd = s.substr(1, 4);
			var selectObj = document.getElementById("select-jieguo");
			selectObj.value = $("#select-jieguo").data("khjg");
			$("#grzjimg").html(
					"<img src='/main/yjda/getSign.do?rybh="
							+ $("#tableCont").data("bh") + "&nd=" + nd
							+ "&pic=grzjimg' onerror="+"this.src="+"'/resources/images/white_background.PNG'"+">");
			$(".myDate_label").prop({
				"disabled" : true
			});
			$("#fggz").attr("readonly", "readonly");
			$("#grzjnr").attr("readonly", "readonly");
			$("#sign_button").prop({
				disabled : true
			});
			$("#jgfzrhkhwyhyj").attr("readonly", "readonly");
			$("#jgfzrkh_button").prop({
				disabled : true
			});
			$("#gryjnr").attr("readonly", "readonly");
			$("#gryj_button").prop({
				disabled : true
			});
			$("#wqddchbcjkhqksm").attr("readonly", "readonly");
			$("#wqddc_button").prop({
				disabled : true
			});
		}else if(qx == "2"){
			var s = $("#niandu").text();
			var nd = s.substr(1, 4);
			var selectObj = document.getElementById("select-jieguo");
			selectObj.value = $("#select-jieguo").data("khjg");
			$("#grzjimg").html(
					"<img src='/main/yjda/getSign.do?rybh="
							+ $("#tableCont").data("bh") + "&nd=" + nd
							+ "&pic=grzjimg' onerror="+"this.src="+"'/resources/images/white_background.PNG'"+">");
			$(".myDate_label").prop({
				"disabled" : true
			});
			$("#fggz").attr("readonly", "readonly");
			$("#grzjnr").attr("readonly", "readonly");
			$("#sign_button").prop({
				disabled : true
			});

			$("#select-jieguo").prop({
				disabled : true
			});
			$("#zgldpy").attr("readonly", "readonly");
			$("#ldpy_button").prop({
				disabled : true
			});
			$("#gryjnr").attr("readonly", "readonly");
			$("#gryj_button").prop({
				disabled : true
			});
			$("#wqddchbcjkhqksm").attr("readonly", "readonly");
			$("#wqddc_button").prop({
				disabled : true
			});
		}
		$("#tjbg").click(function() {
				if(qx=="1"){
					$(".J_dlg").html('<p>确认审批报告？</p>').dialog(
							{
								'buttons' : {
										'确定' : function() {
														$.ajax({
															url : "/main/yjda/spNdkhjtxx.aj",
															type : 'post',
															data : {
																'rybh' : $("table").data("bh"),
																'nd' : document.getElementById("niandu").innerText,
																'zgldpy':$("#zgldpy").val(),
																'select-jieguo':$("#select-jieguo").val()
																	},
															success : function() {
																		$(".J_dlg").html('<p>提交成功</p>').dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									window.location.href = "/main/yjda/ndkh.do";
																								}
																							}
																						})
																				.dialog(
																						"open");
																	}
																});
													},
										'取消' : function() {
												$(".J_dlg").dialog("close");
												}
											}
										}).dialog("open");
				}else if(qx=="2"){
					$(".J_dlg").html('<p>确认审批报告？</p>').dialog(
							{
								'buttons' : {
										'确定' : function() {
														$.ajax({
															url : "/main/yjda/yldspNdkhjtxx.aj",
															type : 'post',
															data : {
																'rybh' : $("table").data("bh"),
																'nd' : document.getElementById("niandu").innerText,
																'jgfzrhkhwyhyj':$("#jgfzrhkhwyhyj").val()
																	},
															success : function() {
																		$(".J_dlg").html('<p>提交成功</p>').dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									window.location.href = "/main/yjda/ndkh.do";
																								}
																							}
																						})
																				.dialog(
																						"open");
																	}
																});
													},
										'取消' : function() {
												$(".J_dlg").dialog("close");
												}
											}
										}).dialog("open");
				}else{
					$(".J_dlg").html('<p>确认提交报告？</p>').dialog(
							{
								'buttons' : {
										'确定' : function() {
														$.ajax({
															url : "/main/yjda/addNdkhjtxx.aj",
															type : 'post',
															data : {
																'rybh' : $("table").data("bh"),
																'nd' : document.getElementById("niandu").innerText,
																'xm' : $("table").children().children().first().children().eq(1).text(),
																'xb' : $("table").children().children().first().children().eq(3).text(),
																'csny' : $("table").children().children().first().children().eq(5).children().val(),
																'zzmm' : $("table").children().children().eq(1).children().eq(1).text(),
																'rxzsj' : $("table").children().children().eq(1).children().eq(3).children().val(),
																'dwjzw' : $("table").children().children().eq(2).children().eq(1).text(),
																'cshfggz' : $("table").children().children().eq(3).children().eq(1).children().val(),
																'grzj' : $("table").children().children().eq(4).children().eq(1).children().first().children().val()
																	},
															success : function() {
																		$(".J_dlg").html('<p>提交成功</p>').dialog(
																						{
																							'buttons' : {
																								'确定' : function() {
																									window.location.href = "/main/yjda/ndkh.do";
																								}
																							}
																						})
																				.dialog(
																						"open");
																	}
																});
													},
										'取消' : function() {
												$(".J_dlg").dialog("close");
												}
											}
										}).dialog("open");
				}
			});
		$("#dybg").click(function() {
			var s = $("#niandu").text();
			var nd = s.substr(1, 4);
			window.location.href = "/main/yjda/dyNdkhjtxx.aj?yhbh="+$("#tableCont")[0].attributes["data-bh"].value+"&khnd="+nd;
		});

		$("#sign_button").click(function() {
			$("#grzjimg").html("<img src='/main/yjda/showSignPic.do'>");
		});
		
		$("#ldpy_button").click(function() {
			$("#zgldimg").html("<img src='/main/yjda/showSignPic.do'>");
		});
		
		$("#jgfzrkh_button").click(function() {
			$("#jgfzrimg").html("<img src='/main/yjda/showSignPic.do'>");
		});
	});
</script>
</head>

<body>
	<div class="content" data-sfkbj="${sfkbj}">
		<div class="main_content">
			<div class="main_content_title">
				<span>公务员年度考核登记表</span> <span id="niandu">(${ndkhjtxx.nd}年)</span>
			</div>
			<div class="main_content_menu">
				<table cellspacing="1" width="800" height="1000"
					style="border: 1px solid #000000;" id="tableCont"
					data-bh="${ndkhjtxx.rybh}" data-qx="${qx}">
					<tr width="800" height="50">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">姓名</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">${ndkhjtxx.xm}</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">性别</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">${ndkhjtxx.xb}</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">出生年月</td>
						<td width="200"
							style="border-bottom:1px solid #000000;text-align:center;font-size:20px"><input
							type="text" id="csny" class="myDate_label"
							value="${ndkhjtxx.csny}"></td>
					</tr>
					<tr width="800" height="50">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">政治面貌</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">${ndkhjtxx.zzmm}</td>
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">任现职时间</td>
						<td colspan="3"
							style="border-bottom:1px solid #000000;text-align:center;font-size:20px"><input
							type="text" id="rxzsj" class="myDate_label"
							value="${ndkhjtxx.rxzsj}"></td>
					</tr>
					<tr width="800" height="50">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">单位及职务</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;text-align:center;font-size:20px">${ndkhjtxx.dw}-${ndkhjtxx.bm}-${ndkhjtxx.zw}</td>
					</tr>
					<tr width="800" height="50">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">从事或分管工作</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;text-align:center;font-size:20px"><input
							type="text" id="fggz" value="${ndkhjtxx.cshfggz}"></td>
					</tr>
					<tr width="800" height="500">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px;">个人总结</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;vertical-align: top;position:relative;">
							<div id="grzj">
								<textarea id="grzjnr" cols="89" rows="30">${ndkhjtxx.grzj}</textarea>
							</div>
							<div id="grzj_bottom">
								<div id="grzjimg"></div>
								<button id="sign_button" class="btn btn-primary">
									<span class="glyphicon glyphicon-pencil"></span> 签名
								</button>
							</div>
						</td>
					</tr>
					<tr width="800" height="150">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px;">主管领导评语和考核等次建议</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;vertical-align: top;position:relative;">
							<div id="ldpy">
								<input type="text" id="zgldpy" value="${ndkhjtxx.zgldpyhkhdcjy}">
								<select id="select-jieguo" data-khjg="${ndkhjtxx.jieg}">
									<option value="1">优秀</option>
									<option value="2">称职</option>
									<option value="9">其他</option>
								</select>
							</div>
							<div id="ldpy_bottom">
								<div id="zgldimg"></div>
								<button id="ldpy_button" class="btn btn-primary">
									<span class="glyphicon glyphicon-pencil"></span> 签名
								</button>
							</div>
						</td>
					</tr>
					<tr width="800" height="150">
						<td width="120"
							style="border-bottom:1px solid #000000;border-right:1px solid #000000;text-align:center;font-size:20px">机关负责人和考核委员会意见</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;vertical-align: top;position:relative;">
							<div id="jgfzrkh">
								<input type="text" id="jgfzrhkhwyhyj"
									value="${ndkhjtxx.jgfzrkh}">
							</div>
							<div id="jgfzrkh_bottom">
								<div id="jgfzrimg"></div>
								<button id="jgfzrkh_button" class="btn btn-primary">
									<span class="glyphicon glyphicon-pencil"></span> 签名
								</button>
							</div>
						</td>
					</tr>
					<tr width="800" height="150">
						<td width="120"
							style="border-right:1px solid #000000;border-bottom:1px solid #000000;text-align:center;font-size:20px">本人意见</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;vertical-align: top;position:relative;">
							<div id="gryj">
								<input type="text" id="gryjnr" value="${ndkhjtxx.gryj}">
							</div>
							<div id="gryj_bottom">
								<div id="bryjimg"></div>
								<button id="gryj_button" class="btn btn-primary">
									<span class="glyphicon glyphicon-pencil"></span> 签名
								</button>
							</div>
						</td>
					</tr>
					<tr width="800" height="150">
						<td width="120"
							style="border-right:1px solid #000000;text-align:center;font-size:20px">未确定等次或不参加考核情况说明</td>
						<td colspan="5"
							style="border-bottom:1px solid #000000;vertical-align: top;position:relative;">
							<div id="wqddc">
								<input type="text" id="wqddchbcjkhqksm"
									value="${ndkhjtxx.wqddc}">
							</div>
							<div id="wqddc_bottom">
								<button id="wqddc_button" class="btn btn-primary">
									<span class="glyphicon glyphicon-pencil"></span> 签名
								</button>
							</div>
						</td>
					</tr>
				</table>
				<div id="service_button">
					<button id="dybg" class="btn btn-primary">
						<span class="glyphicon glyphicon-print"></span> 打印报告
					</button>
					<button id="tjbg" class="btn btn-primary">
						<span class="glyphicon glyphicon-ok"></span> 提交报告
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="J_dlg"></div>
</body>
</html>
