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

<title>人员基本信息</title>

<script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/ryjbxx.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.treeview.js"></script>
<script type="text/javascript" src="/resources/js/zdybq.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js">
	<jsp:text/>
</script>
<link rel="stylesheet" href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap-theme.min.css" />
<!-- 兼容IE8 -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="resources/css/dlg.css" />
<link rel="stylesheet" href="resources/css/zdybq.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/demo_table.css" />
<link rel="stylesheet" href="/resources/css/ryjbxx.css" />
<script type="text/javascript">
	$(function() {
		$zdybq.changeDateFromLabelToPicker();
		$zdybq.changeFromLabelToInput();

		$("#save_btn")
				.click(
						function() {
							if ($("#bm").val() != "" && $("#xm").val() != ""
									&& $("#xb").val() != ""
									&& $("#mz").val() != ""
									&& $("#hyzk").val() != ""
									&& $("#jkzk").val() != ""
									&& $("#csrq").val() != ""
									&& $("#jg").val() != ""
									&& $("#sfzh").val() != ""
									&& $("#xb").val() != ""
									&& $("#gzrq").val() != ""
									&& $("#jyrq").val() != ""
									&& $("#jtj").val() != ""
									&& $("#jly").val() != ""
									&& $("#zzmm1").val() != ""
									&& $("#zzmm2").val() != ""
									&& $("#gz").val() != ""
									&& $("#xl").val() != ""
									&& $("#xw").val() != ""
									&& $("#hdzsrq").val() != "") {
								if (($("#cyy").val() == " "
										&& $("#crq").val() == "")
										|| ($("#cyy").val() != " "
												&& $("#crq").val() != "")) {
									$(".J_dlg")
											.html('<p>确认保存个人信息？</p>')
											.dialog(
													{
														'buttons' : {
															'确定' : function() {
																$
																		.ajax({
																			url : "/saveryjbxxfzb.aj",
																			type : 'post',
																			data : {
																				'showKey' : $(
																						"#menu_list")
																						.data(
																								"showkey"),
																				'NBm' : $(
																						"#bm")
																						.val(),
																				'CXm' : $(
																						"#xm")
																						.val(),
																				'CCym' : $(
																						"#cym")
																						.val(),
																				'NXb' : $(
																						"#xb")
																						.val(),
																				'NMz' : $(
																						"#mz")
																						.val(),
																				'NHyzk' : $(
																						"#hyzk")
																						.val(),
																				'NJkzk' : $(
																						"#jkzk")
																						.val(),
																				'DCsrq' : $(
																						"#csrq")
																						.val(),
																				'CJg' : $(
																						"#jg")
																						.val(),
																				'CCsd' : $(
																						"#csd")
																						.val(),
																				'NZzmm' :$("#zzmm1").val(),
																				'DZzmm' :$("#zzmm2").val(),
																				'NGz' : $("#gz").val(),
																				'NXl' : $("#xl").val(),
																				'NXw' : $("#xw").val(),
																				'DHdxwrq':$("#hdxwrq").val(),
																				'NZy' : $("#zy").val(),
																				'CZyzs':$("#zyzs").val(),
																				'DHdzsrq':$("#hdzsrq").val(),
																				'DGzrq':$("#gzrq").val(),
																				'DJyrq':$("#jyrq").val(),
																				'CJtj' :$("#jtj").val(),
																				'CJly' :$("#jly").val(),
																				'DShrq':$("#shrq").val(),
																				'NCyy' :$("#cyy").val(),
																				'DCrq':$("#crq").val(),
																				'CSfzh':$("#sfzh").val()
																			},
																			success : function() {
																				$(
																						".J_dlg")
																						.html(
																								'<p>保存成功</p>')
																						.dialog(
																								{
																									'buttons' : {
																										'确定' : function() {
																											window.location.href = "/ryjbxxfzb.do?showKey="
																													+ $(
																															"#menu_list")
																															.data(
																																	"showkey");
																										}
																									}
																								})
																						.dialog(
																								"open");
																			}
																		});
															},
															'取消' : function() {
																$(".J_dlg")
																		.dialog(
																				"close");
															}
														}
													}).dialog("open");
								} else {
									alert("请填写（或清空）去原因，去日期和去向信息项");
								}
							} else {
								alert("标星号的为必填项，请补充完整！");
							}
						});
		$.ajax({
			url : "/isphotofzb.aj",
			type : 'post',
			data : {
				'showKey' : $('#menu_list').data('showkey')
			},
			dataType : 'json',
			success : function(json) {
				if (json != 1) {
					$("#perPhoto").attr(
							"src",
							"/photofzb.do?showKey="
									+ $('#menu_list').data('showkey') + "");
				}
			}
		});
		$("#shangchuan").live(
				"click",
				function() {
					$("#upLoad").dialog({
						'buttons' : {
							'确定' : function() {
								var filepath= $("#filePicker").val();
								if(filepath == ""){
									alert("请选择要上传的文件");
								}else{
									var subname = filepath.substring(filepath.length-3).toLowerCase();
									if((filepath.slice(-4,-3) == '.')&&(subname == "png" || subname == "jpg")){
										var options = {
												async: false,
												success: function(message){
													if(message == 0){
														$("#perPhoto").attr("src","/photofzb.do?showKey="+ $('#menu_list').data('showkey') + "&r=" + Math.random()	);
														$("#upLoad").dialog("close");
													}else if(message == -1){
														alert("文件不存在！");
													}else if(message == -2){
														alert("文件过大，请选择小于1M的文件上传！");
													}
													return false;
												
												}
										};
										$("#fileForm").attr("action","uploadpicfzb.aj").attr("method","POST").ajaxSubmit(options);	
									}else{
										alert("请选择正确的文件");
									}
								}
							},
							'取消' : function() {
								$("#upLoad").dialog("close");
							}
						}
					}).dialog("open");
		});

		$("#daochu").live(
				"click",
				function() {
					if (confirm("是否要导出图片？"))
						window.open("/daochuPhotofzb.aj?showKey="
								+ $('#menu_list').data('showkey'));
				});
	});
</script>
<style type="text/css">
	tr{
		line-height:40px;
	}
	td{
		width:50px;
	}
	#table_one_content{
		width:90%;
	}
	
</style>
</head>

<body>
	<div class="wapper">
		<div class="header">
			<div id="top_left"></div>
		</div>
		<div class="main_contain">
			<div class="top_menu">
			<!--<div class="user_welcome"></div>
			<div class="main_title">
				<div id="title_icon"></div>
				<div id="title_text"></div>
			</div>-->
			</div>
			<div class="main">
				<div class="left_menu">
					<div id="left_border"></div>
					<div id="menu">
						<ul id="menu_list" data-showKey="${showKey}">
						</ul>
					</div>
					<div id="menu_open"></div>
				</div>
				<div class="right_content">
					<div id="current_position">
						<span id="position_text">当前位置：&nbsp;人员信息&nbsp;&gt;人员基本信息</span>
					</div>
					<div id="content_wapper">
						<div id="tree_ry">
							<div>
								<span>人员信息</span>
							</div>
						</div>
						<div id="list_ry">
							<div id="detail">
								<div id="table_one" class="infoTable">
									<div id="ryzp">
										<div id="ryzparea">
											<img alt="个人图片" src="/resources/images/moren.png"
												id="perPhoto" width="97px" height="122px">
										</div>
										<div id="buttonarea">
											<button id="daochu">导出</button>
											<button id="shangchuan">上传</button>
										</div>
									</div>
									<div id="table_one_content">
										<table class="inner_table" style="line-height:20px;">
											<tr>
												<td class="table_title">编号：</td>
												<td class="table_content">${ryxx1.NRybh}</td>
												<td class="table_title"><span style="color:red">*</span>身份证号：</td>
												<td class="table_content"><input type="text" id="sfzh"
													class="myLabel" value="${ryxx1.CSfzh}" />
												</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>部门：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="bm">
															<option value="" ${ryxx1.NBm==null?
															'selected="selected"':""}></option>
															<c:forEach items="${listDmBm}" var="dm">
																<option value="${dm.NDm}"
																	${dm.NDm==ryxx1.NBm? 'selected="selected"':""}>${dm.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title"></td>
												<td class="table_content"></td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>姓名：</td>
												<td class="table_content"><input type="text" id="xm"
													class="myLabel" value="${ryxx1.CXm}" />
												</td>
												<td class="table_title">曾用名：</td>
												<td class="table_content"><input type="text" id="cym"
													class="myLabel" value="${ryxx1.CCym}" />
												</td>
												
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>性别：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="xb">
															<option value="" ${ryxx1.NXb==null?
															'selected="selected"':""}></option>
															<c:forEach items="${listDmXb}" var="dm">
																<option value="${dm.NDm}"
																	${dm.NDm==ryxx1.NXb? 'selected="selected"':""}>${dm.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title"><span style="color:red">*</span>民族：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="mz">
															<option value="" ${ryxx1.NMz==null?
															'selected="selected"':""}></option>
															<c:forEach items="${listDmMz}" var="dm">
																<option value="${dm.NDm}"
																	${dm.NDm==ryxx1.NMz? 'selected="selected"':""}>${dm.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>婚姻状况：</td>
												<td class="table_content"><div class="mySelect">
															<option value="" ${ryxx1.NHyzk==null?
															'selected="selected"':""}></option>
														<select class="my_select_s" id="hyzk">
															<c:forEach items="${listDmHyzk}" var="dm">
																<option value="${dm.NDm}"
																	${dm.NDm==ryxx1.NHyzk? 'selected="selected"':""}>${dm.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title"><span style="color:red">*</span>健康状况：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="jkzk">
															<option value="" ${ryxx1.NJkzk==null?
															'selected="selected"':""}></option>
															<c:forEach items="${listDmJkzk}" var="dm">
																<option value="${dm.NDm}"
																	${dm.NDm==ryxx1.NJkzk? 'selected="selected"':""}>${dm.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>出生日期：</td>
												<td class="table_content"><input type="text" id="csrq"
													class="myDate_label" value="${ryxx1.DCsrq}" />
												</td>
												<td class="table_title">年龄：</td>
												<td class="table_content">${nl}</td>
												
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>籍贯：</td>
												<td class="table_content"><input type="text" id="jg"
													class="myLabel" value="${ryxx1.CJg}" />
												</td>
												<td class="table_title">出生地：</td>
												<td class="table_content"><input type="text" id="csd"
													class="myLabel" value="${ryxx1.CCsd}" />
												</td>
											</tr>
										</table>
									</div>
								</div>
								<div id="table_two" class="infoTable">
									<table class="inner_table">
										<tr>
											<td class="table_title"><span style="color:red">*</span>政治面貌：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="zzmm1">
														<option value="" ${ryxx1.NZzmm==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmZzmm}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NZzmm? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"><span style="color:red">*</span>加入日期：</td>
											<td class="table_content"><input type="text" id="zzmm2"
												class="myDate_label" value="${ryxx1.DZzmm}" />
											</td>
											<td class="table_title"><span style="color:red">*</span>工种：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="gz">
														<option value="" ${ryxx1.NGz==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmGz}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NGz? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
									</table>
								</div>
								<div id="table_three" class="infoTable">
									<table class="inner_table">
										<tr>
											<td class="table_title"><span style="color:red">*</span>学历：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="xl">
														<option value="" ${ryxx1.NXl==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmXl}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NXl? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"><span style="color:red">*</span>学位：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="xw">
														<option value="" ${ryxx1.NGz==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmXw}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NXw? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"><span style="color:red">*</span>获得学位日期：</td>
											<td class="table_content"><input type="text" id="hdxwrq"
												class="myDate_label" value="${ryxx1.DHdxwrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title"><span style="color:red">*</span>专业：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="zy">
														<option value="" ${ryxx1.NZy==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmZy}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NZy? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">证书：</td>
											<td class="table_content"><input type="text" id="zyzs"
												class="myLabel" value="${ryxx1.CZyzs}" />
											</td>
											<td class="table_title">获得证书日期：</td>
											<td class="table_content"><input type="text" id="hdzsrq"
												class="myDate_label" value="${ryxx1.DHdzsrq}" />
											</td>
										</tr>
									</table>
								</div>
								<div id="table_four" class="infoTable">
									<table class="inner_table">
										<tr>
											<td class="table_title"><span style="color:red">*</span>工作日期：</td>
											<td class="table_content"><input type="text" id="gzrq"
												class="myDate_label" value="${ryxx1.DGzrq}" />
											</td>
											<td class="table_title"><span style="color:red">*</span>进院日期：</td>
											<td class="table_content"><input type="text" id="jyrq"
												class="myDate_label" value="${ryxx1.DJyrq}" />
											</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
								</div>
								<div id="table_five" class="infoTable">
									<table>
										<tr>
											<td class="table_title"><span style="color:red">*</span>进途径：</td>
											<td class="table_content"><input type="text" id="jtj"
												class="myLabel" value="${ryxx1.CJtj}" />
											</td>
											<td class="table_title"><span style="color:red">*</span>进来源：</td>
											<td class="table_content"><input type="text" id="jly"
												class="myLabel" value="${ryxx1.CJly}" />
											</td>
											<td class="table_title">审核日期：</td>
											<td class="table_content"><input type="text" id="shrq"
												class="myDate_label" value="${ryxx1.DShrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">出原因：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="cyy">
														<option value=" " ${ryxx1.NCyy==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmCyy}" var="dm">
															<option value="${dm.NDm}"
																${dm.NDm==ryxx1.NCyy? 'selected="selected"':""}>${dm.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">出日期：</td>
											<td class="table_content"><input type="text" id="crq"
												class="myDate_label" value="${ryxx1.DCrq}" />
											</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
								</div>
								<div id="btn_contain">
									<button id="save_btn" type="button" class="btn btn_primary">
										<span class="glyphicon glyphicon-save"></span> 保存
									</button>
								</div>
							</div>
						</div>
					</div>
					<div id="content_footer"></div>
				</div>
			</div>
			<div class="footer">
				<span>版权所有&nbsp;淮安市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持
					南京铉盈网络科技有限公司</span>
			</div>
		</div>
	</div>
	<div class="J_dlg"></div>
	<div id="upLoad" style="display:none">
		<form id="fileForm" enctype="multipart/form-data">
		<input id="filePicker" name="file" type="file" />
		<input type="hidden" name="showkey" value="${showKey}" />
		<div>
			<p>请选择png或jpg文件上传，大小不超过1M</p>
		</div>
		</form>
	</div>
</body>
</html>
