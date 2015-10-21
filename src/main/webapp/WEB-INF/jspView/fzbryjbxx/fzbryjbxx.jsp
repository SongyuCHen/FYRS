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

<title>非在编人员基本信息</title>

<script type="text/javascript"
	src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<!--<script type="text/javascript" src="/resources/js/ryjbxx.js"></script> -->
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
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/ryjbxx.css" />
<script type="text/javascript">
	$(function() {
		$("#edit_btn").live(
				"click",
				function() {
					window.location.href = "/editryjbxxfzb.do?showKey="
							+ $("#menu_list").data("showkey");
				});
		$("#print_btn").live("click", function() {
			var printData = document.getElementById("list_ry").innerHTML;
			var oldstr = document.body.innerHTML;
			window.document.body.innerHTML = printData;
			window.print();
			document.body.innerHTML = oldstr;
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
	});
</script>
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
						<li class="list"><a>常用信息</a>
						</li>
						<li class="sub_list" data-type="ryjbxxfzb"><a>基本信息<span
									class="clicked_a">→</span>
							</a>
						</li>
						<li class="sub_list" data-type="jlxxfzb"><a>简历信息<span
									class="clicked_a">→</span>
							</a>
						</li>
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
										<img alt="个人图片" src="/resources/images/moren.png"
											id="perPhoto" width="97px" height="122px">
									</div>
									<div id="table_one_content">
										<table class="inner_table" style="line-height:20px;">
											<tr>
												<td class="table_title">编号：</td>
												<td class="table_content">${ryxx1.NRybh}</td>
												<td class="table_title"><span style="color:red">*</span>身份证号：</td>
												<td class="table_content">${ryxx1.CSfzh}</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>部门：</td>
												<td class="table_content">${ryxx1.NBm}</td>
												<td class="table_title"></td>
												<td class="table_content"></td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>姓名：</td>
												<td class="table_content">${ryxx1.CXm}</td>
												<td class="table_title">曾用名：</td>
												<td class="table_content">${ryxx1.CCym}</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>性别：</td>
												<td class="table_content">${ryxx1.NXb}</td>
												<td class="table_title"><span style="color:red">*</span>民族：</td>
												<td class="table_content">${ryxx1.NMz}</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>婚姻状况：</td>
												<td class="table_content">${ryxx1.NHyzk}</td>
												<td class="table_title"><span style="color:red">*</span>健康状况：</td>
												<td class="table_content">${ryxx1.NJkzk}</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>出生日期：</td>
												<td class="table_content">${ryxx1.DCsrq}</td>
												<td class="table_title">年龄：</td>
												<td class="table_content">${nl}</td>
											</tr>
											<tr>
												<td class="table_title"><span style="color:red">*</span>籍贯：</td>
												<td class="table_content">${ryxx1.CJg}</td>
												<td class="table_title">出生地：</td>
												<td class="table_content">${ryxx1.CCsd}</td>
											</tr>
										</table>
									</div>
								</div>
								<div id="table_two" class="infoTable">
									<table class="inner_table" style="width: 700px;">
										<tr>
											<td class="table_title">政治面貌：</td>
											<td class="table_content">${ryxx1.NZzmm}</td>
											<td class="table_title">加入日期：</td>
											<td class="table_content">${ryxx1.DZzmm}</td>
											<td class="table_title">工种：</td>
											<td class="table_content">${ryxx1.NGz}</td>
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
											<td class="table_title">证书：</td>
											<td class="table_content">${ryxx1.CZyzs}</td>
											<td class="table_title">获得证书日期：</td>
											<td class="table_content">${ryxx1.DHdzsrq}</td>
										</tr>
									</table>
							</div>
							<div id="table_four" class="infoTable">
								<table class="inner_table">
										<tr>
											<td class="table_title"><span style="color:red">*</span>工作日期：</td>
											<td class="table_content">${ryxx1.DGzrq}</td>
											<td class="table_title"><span style="color:red">*</span>进院日期：</td>
											<td class="table_content">${ryxx1.DJyrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
							</div>
							<div id="table_five" class="infoTable">
								<table>
										<tr>
											<td class="table_title"><span style="color:red">*</span>进途径：</td>
											<td class="table_content">${ryxx1.CJtj}</td>
											<td class="table_title"><span style="color:red">*</span>进来源：</td>
											<td class="table_content">${ryxx1.CJly}</td>
											<td class="table_title">审核日期：</td>
											<td class="table_content">${ryxx1.DShrq}</td>
										</tr>
										<tr>
											<td class="table_title">出原因：</td>
											<td class="table_content">${ryxx1.NCyy}</td>
											<td class="table_title">出日期：</td>
											<td class="table_content">${ryxx1.DCrq}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
							</div>
							<div id="btn_contain"> <style> @media Print{.Noprn{DISPLAY:none}} </style>
								<button id="edit_btn" type="button" class="btn btn_primary Noprn">
									<span class="glyphicon glyphicon-plus"></span> 编辑
								</button>
								<button id="print_btn" type="button" class="btn btn-primary Noprn">
									<span class="glyphicon glyphicon-print"></span> 打印
								</button>
							</div>
						</div>
					</div>
				</div>
				<div id="content_footer"></div>
			</div>
	</div>
		<div class="footer">
			<span>版权所有&nbsp;某市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持 南京铉盈网络科技有限公司</span>
		</div>
	</div>
</div>

</body>
</html>
