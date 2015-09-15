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
<meta charset="utf-8" />
<title>个人业绩档案</title>
<link rel="stylesheet"
	href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
<script type="text/javascript"
	src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
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
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/demo_table.css" />
<link rel="stylesheet" href="/resources/css/ryjbxx.css" />
<link rel="stylesheet" href="/resources/css/yjda.css" />
</head>
<style>
	#selectContent{
		width:650px;
		margin-left:70px;
	}
	input{
		margin:20px 30px;
	}
</style>
<script type="text/javascript">
	function checkTime(str) {
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	
	$(function() {
		$zdybq.changeDateFromLabelToPicker();
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth();
		var day = date.getDate();
		var jzsj = ""+year+"-"+(month+1)+"-"+day;
		var kssj = ""+(year-1)+"-"+(month+1)+"-"+day;
		$("#kssj").attr("value",kssj);
		$("#jzsj").attr("value",jzsj);
		$("#scgrbb_btn").live("click", function() {
			var kssj = $("#kssj").val();
			var jzsj = $("#jzsj").val();
			if(kssj!=""&&jzsj!=""&&checkTime($("#kssj").val())&&checkTime($("#jzsj").val())){
				$("#loadingSpinner").show();
				$("#tablenr").hide();
				$.ajax({
					url : "scgrbb.aj",
					type : 'post',
					data : {'kssj':kssj,'jzsj':jzsj,'showKey':$("#menu_list").data("showkey")},
					dataType : 'json',
					success : function(json) {
						for ( var i in json) {
							$("#" + i + "").text(json[i]);
						}
						var tdContent = $("#tablenr span");
						for ( var i = 0; i < tdContent.length; i++) {
							if (tdContent.eq(i).text() == "") {
								tdContent.eq(i).text("--");
							}
						}
						$("#loadingSpinner").hide();
						$("#tablenr").show();
					}
				});
			}else{
				alert("请选择时间！");			
			}
		});
	});
</script>
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
							<li class="list"><a>常用信息</a></li>
							<li class="sub_list" data-type="ryjbxx"><a>基本信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="zzmm"><a>政治面貌<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="zjxx"><a>职级信息<span class="clicked_a">→</span></a></li>
							<li class="sub_list" data-type="xzzw"><a>行政职务<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="flzw"><a>法律职务<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="xlxx"><a>学历信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="xwxx"><a>学位信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="jlxx"><a>简历信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="jtxx"><a>家庭信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="khxx"><a>考核信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="jlixx"><a>奖励信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="sfks"><a>司法考试<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="jliuxx"><a>交流信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="pxxx"><a>培训信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="rcxx"><a>人才信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="gryjda"><a>个人业绩档案<span
									class="clicked_a">→</span> </a></li>

							<li class="list"><a>其他信息</a></li>
							<li class="sub_list" data-type="djxx"><a>等级信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="gwyjb"><a>公务员级别<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="zyjszw"><a>专业技术职务<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="jrzw"><a>兼任职务<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="ldbz"><a>领导班子<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="hbgb"><a>后备干部<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="gzxx"><a>工资信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="ccxx"><a>惩处信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="swxx"><a>伤亡信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="zdxx"><a>在读信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="cgxx"><a>出国信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="wyxx"><a>外语信息<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="txl"><a>通讯录<span
									class="clicked_a">→</span> </a></li>
							<li class="sub_list" data-type="bzxx"><a>备注信息<span
									class="clicked_a">→</span> </a></li>
									
							<li class="list"><a>人员数据变动信息</a></li>
						<li class="sub_list" data-type="xjxx"><a>休假信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="htxx"><a>合同信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zjbbxx"><a>职级变动信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zgqk"><a>在岗情况<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="xcflxx"><a>薪酬福利信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="sbjl"><a>社保记录<span class="clicked_a">→</span></a></li>
						</ul>
					</div>
					<div id="menu_open"></div>
				</div>
				<div class="right_content">
					<div id="current_position">
						<span id="position_text">当前位置：&nbsp;人员信息&nbsp;&gt;个人业绩档案</span>
					</div>
					<div id="content_wapper">
						<div id="tree_ry">
							<div>
								<span>人员信息</span>
							</div>
						</div>
						<div id="list_ry">
							<div id="detail">
								<div class="main_wapper" style="background-color:white;">
									<div class="wapper_title">
										<span>当前人员：${cxm}</span><span style="left:180px;">单位：${fymc}</span><span
											style="right:125px;">状态：在职</span>
									</div>
									<div id="selectContent">
										<span>开始时间：</span>
										<input id="kssj" type="text" class="myDate_label" />
										<span>截止时间：</span>
										<input id="jzsj" type="text" class="myDate_label" />
										<button type="button" class="btn btn-primary" id="scgrbb_btn">
											<span class="glyphicon glyphicon-plus"></span> 生成报表
										</button>
									</div>
									<!-- 个人业绩档案  -->
									<img src="/resources/images/loading.gif" id="loadingSpinner"
										style="display:none;"/>
									<div id="tablenr">
										<div id="tabletitle">
											<span>个人业绩查看</span>
										</div>
										<div id="tablemenu">
											<table id="tableone">
												<tr>
													<td rowspan="5"><span>审判数量</span>
													</td>
													<td id="odd"><span>结案总数</span>
													</td>
													<td id="even"><span id="jazs"></span>
													</td>
													<td id="odd"><span>一审案件数(已结)</span>
													</td>
													<td id="even"><span id="ysajs"></span>
													</td>
													<td id="odd"><span>二审案件数(已结)</span>
													</td>
													<td id="even"><span id="esajs"></span>
													</td>
													<td id="odd"><span>再审案件数(已结)</span>
													</td>
													<td id="even"><span id="zsajs"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>行政审查执行案件数(已结)</span>
													</td>
													<td id="even"><span id="xzsczxajs"></span>
													</td>
													<td id="odd"><span>减刑案件数(已结)</span>
													</td>
													<td id="even"><span id="jxajs"></span>
													</td>
													<td id="odd"><span>刑事附带民事案件数(已结)</span>
													</td>
													<td id="even"><span id="xsfdmsajs"></span>
													</td>
													<td id="odd"><span>参加合议庭案件数</span>
													</td>
													<td id="even"><span id="cjhytajs"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>一审案件陪审数</span>
													</td>
													<td id="even"><span id="ysajpss"></span>
													</td>
													<td id="odd"><span>一审案件陪审率</span>
													</td>
													<td id="even"><span id="ysajpsl"></span>
													</td>
													<td id="odd"><span>一审简易程序结案数</span>
													</td>
													<td id="even"><span id="ysjycxjas"></span>
													</td>
													<td id="odd"><span>一审简易程序适用率</span>
													</td>
													<td id="even"><span id="ysjycxsyl"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>执结案件数</span>
													</td>
													<td id="even"><span id="zjajs"></span>
													</td>
													<td id="odd"><span>执行案件强制执行数</span>
													</td>
													<td id="even"><span id="zxajqzzxs"></span>
													</td>
													<td id="odd"><span>执行案件自动履行数</span>
													</td>
													<td id="even"><span id="zxajzdlxs"></span>
													</td>
													<td id="odd"><span>已执结案件申请执行标的额</span>
													</td>
													<td id="even"><span id="yzjajsqzxbde"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>执行到位标的额</span>
													</td>
													<td id="even"><span id="zxdwbde"></span>
													</td>
													<td id="odd"><span>旧存案件数</span>
													</td>
													<td id="even"><span id="jcajs"></span>
													</td>
													<td id="odd"><span>新收案件总数</span>
													</td>
													<td id="even"><span id="xsajzs"></span>
													</td>
													<td id="odd"><span>审限内未结案</span>
													</td>
													<td id="even"><span id="sxnwja"></span>
													</td>
												</tr>
											</table>
											<br />
											<table id="tabletwo">
												<tr>
													<td rowspan="2"><span>审判质量</span>
													</td>
													<td id="odd"><span>上诉案件数</span>
													</td>
													<td id="even"><span id="ssajs"></span>
													</td>
													<td id="odd"><span>上诉率</span>
													</td>
													<td id="even"><span id="ssl"></span>
													</td>
													<td id="odd"><span>被改判发回数</span>
													</td>
													<td id="even"><span id="bgpfhs"></span>
													</td>
													<td id="odd"><span>被改判发回率</span>
													</td>
													<td id="even"><span id="bgpfhl"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>申诉数</span>
													</td>
													<td id="even"><span id="sss"></span>
													</td>
													<td id="odd"><span>申诉率</span>
													</td>
													<td id="even"><span id="shensl"></span>
													</td>
													<td id="odd"><span>二审开庭审理结案数</span>
													</td>
													<td id="even"><span id="esktsljas"></span>
													</td>
													<td id="odd"><span>二审开庭审理率</span>
													</td>
													<td id="even"><span id="esktsll"></span>
													</td>
												</tr>
											</table>
											<br />
											<table id="tablethree">
												<tr>
													<td rowspan="3"><span>审判效率</span>
													</td>
													<td id="odd"><span>法定审限内结案数</span>
													</td>
													<td id="even"><span id="fdsxnjas"></span>
													</td>
													<td id="odd"><span>法定审限内结案率</span>
													</td>
													<td id="even"><span id="fdsxnjal"></span>
													</td>
													<td id="odd"><span>报延未结数</span>
													</td>
													<td id="even"><span id="bywjas"></span>
													</td>
													<td id="odd"><span>中止未结数</span>
													</td>
													<td id="even"><span id="zzwjs"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>中断未结数</span>
													</td>
													<td id="even"><span id="zdwjs"></span>
													</td>
													<td id="odd"><span>暂停计算未结数</span>
													</td>
													<td id="even"><span id="ztjswjs"></span>
													</td>
													<td id="odd"><span>超审限未结数</span>
													</td>
													<td id="even"><span id="csxwjs"></span>
													</td>
													<td id="odd"><span>案件平均审理天数</span>
													</td>
													<td id="even"><span id="ajpjslts"></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>结收案件比</span>
													</td>
													<td id="even"><span id="jsajb"></span>
													</td>
													<td id="odd"><span>实际执行率</span>
													</td>
													<td id="even"><span id="sjzxl"></span>
													</td>
													<td id="odd"><span>执行到位率</span>
													</td>
													<td id="even"><span id="zxdwl"></span>
													</td>
													<td id="odd"><span></span>
													</td>
													<td id="even"><span></span>
													</td>
												</tr>
											</table>
											<br />
											<table id="tablefour">
												<tr>
													<td rowspan="2"><span>审判效果</span>
													</td>
													<td id="odd"><span>调解数</span>
													</td>
													<td id="even"><span id="tjs"></span>
													</td>
													<td id="odd"><span>调解率</span>
													</td>
													<td id="even"><span id="tjl"></span>
													</td>
													<td id="odd"><span>撤诉数</span>
													</td>
													<td id="even"><span id="css"></span>
													</td>
													<td id="odd"><span id="csl">撤诉率</span>
													</td>
													<td id="even"><span></span>
													</td>
												</tr>
												<tr>
													<td id="odd"><span>执行和解案件数</span>
													</td>
													<td id="even"><span id="zxhjajs"></span>
													</td>
													<td id="odd"><span>信访投诉数</span>
													</td>
													<td id="even"><span id="xftss"></span>
													</td>
													<td id="odd"><span>信访投诉率</span>
													</td>
													<td id="even"><span id="xftsl"></span>
													</td>
													<td id="odd"><span></span>
													</td>
													<td id="even"><span></span>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="content_footer"></div>
				</div>
			</div>
		</div>
		<div class="footer">
			<span>版权所有&nbsp;淮安市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持
				南京铉盈网络科技有限公司</span>
		</div>
	</div>
	<div id="gryjda_dlg"></div>
	<div class="J_dlg"></div>
</body>
</html>
