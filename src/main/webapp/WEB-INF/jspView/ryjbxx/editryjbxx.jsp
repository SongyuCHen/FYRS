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
<link rel="stylesheet"
	href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
<script type="text/javascript"
	src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.form.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/ryjbxx.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery/jquery.treeview.js"></script>
<script type="text/javascript" src="/resources/js/zdybq.js"></script>
<!-- bootstrap -->
<script type="text/javascript"
	src="/resources/bootstrap/js/bootstrap.min.js">
	<jsp:text/>
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
									&& $("#bcgl").val() != ""
									&& $("#kjgl").val() != ""
									&& $("#xb").val() != ""
									&& $("#jtj").val() != ""
									&& $("#jly").val() != ""
									&& $("#bz").val()!="") {
								if (($("#cyy").val() == " "
										&& $("#crq").val() == "" && $("#qx")
										.val() == " ")
										|| ($("#cyy").val() != " "
												&& $("#crq").val() != "" && $(
												"#qx").val() != " ")) {
									$(".J_dlg")
											.html('<p>确认保存个人信息？</p>')
											.dialog(
													{
														'buttons' : {
															'确定' : function() {
																$
																		.ajax({
																			url : "/saveryjbxx.aj",
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
																				'NZwlb' : $(
																						"#zwlb")
																						.val(),
																				'DZwlbsj' : $(
																						"#zwlbsj")
																						.val(),
																				'DFgzgrq' : $(
																						"#fgzgrq")
																						.val(),
																				'DDzzwrq' : $(
																						"#dzzwrq")
																						.val(),
																				'NDzzw' : $(
																						"#dzzw")
																						.val(),
																				'NBz' : $(
																						"#bz")
																						.val(),
																				'NZyzs' : $(
																						"#zyzs")
																						.val(),
																				'DHdzsrq' : $(
																						"#hdzsrq")
																						.val(),
																				'DQdfgzgzs' : $(
																						"#qdfgzgzssj")
																						.val(),
																				'NQdfgzgzs' : $(
																						"#qdfgzgzs")
																						.val(),
																				'DGzrq' : $(
																						"#gzrq")
																						.val(),
																				'DZfgzrq' : $(
																						"#zfgzrq")
																						.val(),
																				'DJyrq' : $(
																						"#jyrq")
																						.val(),
																				'NBcgl' : $(
																						"#bcgl")
																						.val(),
																				'NKjgl' : $(
																						"#kjgl")
																						.val(),
																				'NJyqfynx' : $(
																						"#jyqfynx")
																						.val(),
																				'NYjxz' : $(
																						"#yjxz")
																						.val(),
																				'NJtj' : $(
																						"#jtj")
																						.val(),
																				'NJly' : $(
																						"#jly")
																						.val(),
																				'DShrq' : $(
																						"#shrq")
																						.val(),
																				'NYzw' : $(
																						"#yzw")
																						.val(),
																				'NYzj' : $(
																						"#yzj")
																						.val(),
																				'CYdw' : $(
																						"#ydw")
																						.val(),
																				'NCyy' : $(
																						"#cyy")
																						.val(),
																				'DCrq' : $(
																						"#crq")
																						.val(),
																				'NQx' : $(
																						"#qx")
																						.val(),
																				'CSfzh' : $(
																						"#sfzh")
																						.val()
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
																											window.location.href = "/ryjbxx.do?showKey="
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
			url : "/isphoto.aj",
			type : 'post',
			data : {
				'showKey' : $('#menu_list').data('showkey')
			},
			dataType : 'json',
			success : function(json) {
				if (json != 1) {
					$("#perPhoto").attr(
							"src",
							"/photo.do?showKey="
									+ $('#menu_list').data('showkey') + "");
				}
			}
		});
		$("#shanchu").live(
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
														$("#perPhoto").attr("src","/photo.do?showKey="+ $('#menu_list').data('showkey') + "&r=" + Math.random()	);
														$("#upLoad").dialog("close");
													}else if(message == -1){
														alert("文件不存在！");
													}else if(message == -2){
														alert("文件过大，请选择小于1M的文件上传！");
													}
													return false;
												
												}
										};
										$("#fileForm").attr("action","uploadpic.aj").attr("method","POST").ajaxSubmit(options);
									
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
						window.open("/daochuPhoto.aj?showKey="
								+ $('#menu_list').data('showkey'));
				});

	});
</script>
<style type="text/css">
	tr{
		line-height:35px;
	}
	
	#table_one_content .table_title{
		width:100px;
	}
	
	#table_one_content .table_content{
		width:200px;
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
						<div id="menu_title" data-current="${index==null?'':index }">
							<div id="cdlb"></div>
						</div>
						<ul id="menu_list" data-showKey="${showKey}">
							<li class="list"><a>常用信息</a>
							</li>
							<li class="sub_list" data-type="ryjbxx"><a>基本信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="zzmm"><a>政治面貌<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="zjxx"><a>职级信息<span class="clicked_a">→</span></a></li>
							<li class="sub_list" data-type="xzzw"><a>行政职务<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="flzw"><a>法律职务<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="xlxx"><a>学历信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="xwxx"><a>学位信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="jlxx"><a>简历信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="jtxx"><a>家庭信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="khxx"><a>考核信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="jlixx"><a>奖励信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="sfks"><a>司法考试<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="jliuxx"><a>交流信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="pxxx"><a>培训信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="rcxx"><a>人才信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="gryjda"><a>个人业绩档案<span
									class="clicked_a">→</span> </a>
							</li>

							<li class="list"><a>其他信息</a>
							</li>
							<li class="sub_list" data-type="djxx"><a>等级信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="gwyjb"><a>公务员级别<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="zyjszw"><a>专业技术职务<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="jrzw"><a>兼任职务<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="ldbz"><a>领导班子<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="hbgb"><a>后备干部<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="gzxx"><a>工资信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="ccxx"><a>惩处信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="swxx"><a>伤亡信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="zdxx"><a>在读信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="cgxx"><a>出国信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="wyxx"><a>外语信息<span
									class="clicked_a">→</span> </a>
							</li>
							<li class="sub_list" data-type="txl"><a>通讯录<span
									class="clicked_a">→</span> </a>
							</li>
							<!-- <li class="sub_list" data-type="syyyx"><a>声音与影像<span class="clicked_a">→</span></a></li> -->
							<li class="sub_list" data-type="bzxx"><a>备注信息<span
									class="clicked_a">→</span> </a>
							</li>
							
							<li class="list"><a>人员数据变动信息</a></li>
						<li class="sub_list" data-type="xjxx"><a>休假信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="htxx"><a>合同信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zjbbxx"><a>职级变动信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zgqk"><a>在岗情况<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="xcflxx"><a>薪酬福利信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="pxjl"><a>培训记录<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="sbjl"><a>社保记录<span class="clicked_a">→</span></a></li>
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
											<button id="shanchu">上传</button>
										</div>
									</div>
									<div id="table_one_content">
										<table class="inner_table" style="line-height:20px;">
											<tr>
												<!--<td rowspan="8" style="width:140px"><img src="resources/img/people_pic.png" /></td>-->
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
															<c:forEach items="${jgxxs}" var="jgxxs">
																<option value="${jgxxs.NCode}"
																	${jgxxs.CName==ryxx1.NBm? 'selected="selected"':""}>${jgxxs.CName}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title">部门性质：</td>
												<td class="table_content">${ryxx1.bmxz}</td>
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
															<c:forEach items="${listDmXb}" var="listDmXb">
																<option value="${listDmXb.NDm}"
																	${listDmXb.CMc==ryxx1.NXb? 'selected="selected"':""}>${listDmXb.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title"><span style="color:red">*</span>民族：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="mz">
															<c:forEach items="${listDmMz}" var="listDmMz">
																<option value="${listDmMz.NDm}"
																	${listDmMz.CMc==ryxx1.NMz? 'selected="selected"':""}>${listDmMz.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>婚姻状况：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="hyzk">
															<c:forEach items="${listDmHyzk}" var="listDmHyzk">
																<option value="${listDmHyzk.NDm}"
																	${listDmHyzk.CMc==ryxx1.NHyzk? 'selected="selected"':""}>${listDmHyzk.CMc}</option>
															</c:forEach>
														</select>
													</div>
												</td>
												<td class="table_title"><span style="color:red">*</span>健康状况：</td>
												<td class="table_content"><div class="mySelect">
														<select class="my_select_s" id="jkzk">
															<c:forEach items="${listDmJkzk}" var="listDmJkzk">
																<option value="${listDmJkzk.NDm}"
																	${listDmJkzk.CMc==ryxx1.NJkzk? 'selected="selected"':""}>${listDmJkzk.CMc}</option>
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
												<td class="table_content">${ryxx1.NNl}</td>
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
											<td class="table_title">职务类别：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="zwlb">
														<option value=" " ${ryxx1.NZwlb==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmZwlb}" var="listDmZwlb">
															<option value="${listDmZwlb.NDm}"
																${listDmZwlb.CMc==ryxx1.NZwlb? 'selected="selected"':""}>${listDmZwlb.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">职务类别日期：</td>
											<td class="table_content"><input type="text" id="zwlbsj"
												class="myDate_label" value="${ryxx1.DZwlbsj}" />
											</td>
											<td class="table_title">法官资格日期：</td>
											<td class="table_content"><input type="text" id="fgzgrq"
												class="myDate_label" value="${ryxx1.DFgzgrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">政治面貌：</td>
											<td class="table_content">${ryxx1.NZzmm}</td>
											<td class="table_title">加入日期：</td>
											<td class="table_content">${ryxx1.DZzmm}</td>
											<td class="table_title">党组职务日期：</td>
											<td class="table_content"><input type="text" id="dzzwrq"
												class="myDate_label" value="${ryxx1.DDzzwrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">法律职务：</td>
											<td class="table_content">${ryxx1.NFlzw}</td>
											<td class="table_title">任职日期：</td>
											<td class="table_content">${ryxx1.DFlzwRzrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
										<tr>
											<td class="table_title">兼职庭长：</td>
											<td class="table_content">${ryxx1.NJrtz}</td>
											<td class="table_title">党组任职：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="dzzw">
														<option value=" " ${ryxx1.NDzzw==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmDzzw}" var="listDmDzzw">
															<option value="${listDmDzzw.NDm}"
																${listDmDzzw.CMc==ryxx1.NDzzw? 'selected="selected"':""}>${listDmDzzw.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
										<tr>
											<td class="table_title">行政职务：</td>
											<td class="table_content">${ryxx1.NXzzw}</td>
											<td class="table_title">任职日期：</td>
											<td class="table_content">${ryxx1.DXzzwRzrq}</td>
											<td class="table_title"><span style="color:red">*</span>编制：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="bz">
														<option value=" " ${ryxx1.NBz==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmBz}" var="listDmBz">
															<option value="${listDmBz.NDm}"
																${listDmBz.CMc==ryxx1.NBz? 'selected="selected"':""}>${listDmBz.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="table_title">职级：</td>
											<td class="table_content">${ryxx1.NZj}</td>
											<td class="table_title">职级日期：</td>
											<td class="table_content">${ryxx1.DZjrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
										<tr>
											<td class="table_title">等级：</td>
											<td class="table_content">${ryxx1.NDj}</td>
											<td class="table_title">等级日期：</td>
											<td class="table_content">${ryxx1.DDjrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
										<tr>
											<td class="table_title">公务员级别：</td>
											<td class="table_content">${ryxx1.NGwyjb}</td>
											<td class="table_title">公务员级别起算日期：</td>
											<td class="table_content">${ryxx1.DGwyrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
								</div>
								<div id="table_three" class="infoTable">
									<table class="inner_table">
										<tr>
											<td class="table_title">学历：</td>
											<td class="table_content">${ryxx1.NXl}</td>
											<td class="table_title">学位：</td>
											<td class="table_content">${ryxx1.NXw}</td>
											<td class="table_title">获得学位日期：</td>
											<td class="table_content">${ryxx1.DHdxwrq}</td>
										</tr>
										<tr>
											<td class="table_title">专业：</td>
											<td class="table_content">${ryxx1.NZy}</td>
											<td class="table_title">专业证书：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="zyzs">
														<option value=" " ${ryxx1.NZyzs==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmZyzs}" var="listDmZyzs">
															<option value="${listDmZyzs.NDm}"
																${listDmZyzs.CMc==ryxx1.NZyzs? 'selected="selected"':""}>${listDmZyzs.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">获得证书日期：</td>
											<td class="table_content"><input type="text" id="hdzsrq"
												class="myDate_label" value="${ryxx1.DHdzsrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">取得法官资格证书时间：</td>
											<td class="table_content"><input type="text"
												id="qdfgzgzssj" class="myDate_label"
												value="${ryxx1.DQdfgzgzs}" />
											</td>
											<td class="table_title">取得法官资格证书类型：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="qdfgzgzs">
														<option value=" " ${ryxx1.NQdfgzgzs==null?
															'selected="selected"':""}></option>
														<c:forEach items="${listDmQdfgzgzs}" var="listDmQdfgzgzs">
															<option value="${listDmQdfgzgzs.NDm}"
																${listDmQdfgzgzs.CMc==ryxx1.NQdfgzgzs?
																'selected="selected"':""}>${listDmQdfgzgzs.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"></td>
											<td class="table_content"><br> <br>
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
											<td class="table_title">政法工作日期：</td>
											<td class="table_content"><input type="text" id="zfgzrq"
												class="myDate_label" value="${ryxx1.DZfgzrq}" />
											</td>
											<td class="table_title"><span style="color:red">*</span>进院日期：</td>
											<td class="table_content"><input type="text" id="jyrq"
												class="myDate_label" value="${ryxx1.DJyrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title"><span style="color:red">*</span>补充工龄：</td>
											<td class="table_content"><input type="text" id="bcgl"
												class="myLabel" value="${ryxx1.NBcgl}" style="width:90px;display:inline-block;"/>年</td>
											<td class="table_title"><span style="color:red">*</span>扣减工龄：</td>
											<td class="table_content"><input type="text" id="kjgl"
												class="myLabel" value="${ryxx1.NKjgl}" style="width:90px;display:inline-block;"/>年</td>
											<td class="table_title">连续工龄：</td>
											<td class="table_content">${ryxx1.lxgl}年</td>
										</tr>
										<tr>
											<td class="table_title">进本院前法院年限：</td>
											<td class="table_content"><input type="text"
												id="jyqfynx" class="myLabel" value="${ryxx1.NJyqfynx}" style="width:90px;display:inline-block;"/>年</td>
											<td class="table_title">法院工作合计年限：</td>
											<td class="table_content">${ryxx1.fygzhjnx}年</td>
											<td class="table_title">应加学制：</td>
											<td class="table_content"><input type="text" id="yjxz"
												class="myLabel" value="${ryxx1.NYjxz}" style="width:90px;display:inline-block;"/>年</td>
										</tr>
									</table>
								</div>
								<div id="table_five" class="infoTable">
									<table>
										<tr>
											<td class="table_title"><span style="color:red">*</span>进途径：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="jtj">
														<option value=" " ${ryxx1.NJtj==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmJtj}" var="listDmJtj">
															<option value="${listDmJtj.NDm}"
																${listDmJtj.CMc==ryxx1.NJtj? 'selected="selected"':""}>${listDmJtj.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title"><span style="color:red">*</span>进来源：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="jly">
														<option value=" " ${ryxx1.NJly==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmJly}" var="listDmJly">
															<option value="${listDmJly.NDm}"
																${listDmJly.CMc==ryxx1.NJly? 'selected="selected"':""}>${listDmJly.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">审核日期：</td>
											<td class="table_content"><input type="text" id="shrq"
												class="myDate_label" value="${ryxx1.DShrq}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">原职务：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="yzw">
														<option value=" " ${ryxx1.NYzw==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmYzw}" var="listDmYzw">
															<option value="${listDmYzw.NDm}"
																${listDmYzw.CMc==ryxx1.NYzw? 'selected="selected"':""}>${listDmYzw.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">原职级：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="yzj">
														<option value=" " ${ryxx1.NYzj==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmYzj}" var="listDmYzj">
															<option value="${listDmYzj.NDm}"
																${listDmYzj.CMc==ryxx1.NYzj? 'selected="selected"':""}>${listDmYzj.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">原单位：</td>
											<td class="table_content"><input type="text" id="ydw"
												class="myLabel" value="${ryxx1.CYdw}" />
											</td>
										</tr>
										<tr>
											<td class="table_title">出原因：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="cyy">
														<option value=" " ${ryxx1.NCyy==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmCyy}" var="listDmCyy">
															<option value="${listDmCyy.NDm}"
																${listDmCyy.CMc==ryxx1.NCyy? 'selected="selected"':""}>${listDmCyy.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											<td class="table_title">出日期：</td>
											<td class="table_content"><input type="text" id="crq"
												class="myDate_label" value="${ryxx1.DCrq}" />
											</td>
											<td class="table_title">去向：</td>
											<td class="table_content"><div class="mySelect">
													<select class="my_select_s" id="qx">
														<option value=" " ${ryxx1.NQx==null? 'selected="selected"':""}></option>
														<c:forEach items="${listDmQx}" var="listDmQx">
															<option value="${listDmQx.NDm}"
																${listDmQx.CMc==ryxx1.NQx? 'selected="selected"':""}>${listDmQx.CMc}</option>
														</c:forEach>
													</select>
												</div>
											</td>
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
