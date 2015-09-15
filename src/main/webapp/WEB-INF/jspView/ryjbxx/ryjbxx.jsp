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
	<script type="text/javascript" src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	<script type="text/javascript" src="/resources/js/global.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.uniform.min.js"><jsp:text/></script>
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/uniform/themes/default/css/uniform.default.min.css" />
    <link rel="stylesheet" href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
	<!-- bootstrap -->
	<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"><jsp:text/></script>
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/bootstrap/css/bootstrap-theme.min.css" />
	<!-- 兼容IE8 -->
	<!--[if lt IE 9]>
	      <script src="/resources/js/html5shiv.min.js"></script>
	      <script src="/resources/js/respond.min.js"></script>
	    <![endif]-->
	<link rel="stylesheet" href="/resources/css/common.css" />
	<link rel="stylesheet" href="/resources/css/ryjbxx.css" />
	<link rel="stylesheet" href="resources/css/dlg.css" />
	<link rel="stylesheet" href="resources/css/main.css" />
<script type="text/javascript">
	$(function() {
		$("#edit_btn").live(
				"click",
				function() {
					window.location.href = "/editryjbxx.do?showKey="
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
		
	});
</script>
<style type="text/css">
	#top_right{
		float:right;
		position:relative;
	}
	
	#top_right ul{
		position: absolute;
		right: 0px;
		width: 200px;
		top: 7px;
	}
	
	#top_right ul li{
		display: inline;
		width: 100px;
		margin: 0px 7px;
	}
	
	#top_right ul li img {
		margin-top: -3px;
	}
	
	#top_right ul li a {
		color: white;
		margin-left: 5px;
		text-decoration: none;
	}
</style>
</head>

<body>
	<div class="wapper">
		<div class="header">
			<div id="top_left"></div>
			<div id="top_right" <c:if test="${isHidden==false}"> style="visibility:hidden;"</c:if>>
            	<ul>
                <li><img src="/resources/images/head-login.png"/><a href="javascript:void(0);"  onclick="changePassword();">修改密码</a></li>
                <li><img src="/resources/images/head-logout.png"/><a href="/logout.do">退出系统</a></li>
                </ul>
            </div>
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
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="zzmm"><a>政治面貌<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="zjxx"><a>职级信息<span class="clicked_a">→</span></a></li>
							<li class="sub_list" data-type="xzzw"><a>行政职务<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="flzw"><a>法律职务<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="xlxx"><a>学历信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="xwxx"><a>学位信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="jlxx"><a>简历信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="jtxx"><a>家庭信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="khxx"><a>考核信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="jlixx"><a>奖励信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="sfks"><a>司法考试<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="jliuxx"><a>交流信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="pxxx"><a>培训信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="rcxx"><a>人才信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="gryjda"><a>个人业绩档案<span
									class="clicked_a">→</span>
							</a>
							</li>

							<li class="list"><a>其他信息</a>
							</li>
							<li class="sub_list" data-type="djxx"><a>等级信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="gwyjb"><a>公务员级别<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="zyjszw"><a>专业技术职务<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="jrzw"><a>兼任职务<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="ldbz"><a>领导班子<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="hbgb"><a>后备干部<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="gzxx"><a>工资信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="ccxx"><a>惩处信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="swxx"><a>伤亡信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="zdxx"><a>在读信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="cgxx"><a>出国信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="wyxx"><a>外语信息<span
									class="clicked_a">→</span>
							</a>
							</li>
							<li class="sub_list" data-type="txl"><a>通讯录<span
									class="clicked_a">→</span>
							</a>
							</li>
							<!-- <li class="sub_list" data-type="syyyx"><a>声音与影像<span class="clicked_a">→</span></a></li>  -->
							<li class="sub_list" data-type="bzxx"><a>备注信息<span
									class="clicked_a">→</span>
							</a>
							</li>

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
												<td class="table_title">部门性质：</td>
												<td class="table_content">${ryxx1.bmxz}</td>
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
												<td class="table_content">${ryxx1.NNl}</td>
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
											<td class="table_title">职务类别：</td>
											<td class="table_content">${ryxx1.NZwlb}</td>
											<td class="table_title">职务类别日期：</td>
											<td class="table_content">${ryxx1.DZwlbsj}</td>
											<td class="table_title">法官资格日期：</td>
											<td class="table_content">${ryxx1.DFgzgrq}</td>
										</tr>
										<tr>
											<td class="table_title">政治面貌：</td>
											<td class="table_content">${ryxx1.NZzmm}</td>
											<td class="table_title">加入日期：</td>
											<td class="table_content">${ryxx1.DZzmm}</td>
											<td class="table_title">党组职务日期：</td>
											<td class="table_content">${ryxx1.DDzzwrq}</td>
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
											<td class="table_content">${ryxx1.NDzzw}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
										<tr>
											<td class="table_title">行政职务：</td>
											<td class="table_content">${ryxx1.NXzzw}</td>
											<td class="table_title">任职日期：</td>
											<td class="table_content">${ryxx1.DXzzwRzrq}</td>
											<td class="table_title"><span style="color:red">*</span>编制：</td>
											<td class="table_content">${ryxx1.NBz}</td>
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
											<td class="table_content">${ryxx1.NZyzs}</td>
											<td class="table_title">获得证书日期：</td>
											<td class="table_content">${ryxx1.DHdzsrq}</td>
										</tr>
										<tr>
											<td class="table_title">取得法官资格证书时间：</td>
											<td class="table_content">${ryxx1.DQdfgzgzs}</td>
											<td class="table_title">取得法官资格证书类型：</td>
											<td class="table_content">${ryxx1.NQdfgzgzs}</td>
											<td class="table_title"></td>
											<td class="table_content"></td>
										</tr>
									</table>
							</div>
							<div id="table_four" class="infoTable">
								<table class="inner_table">
										<tr>
											<td class="table_title"><span style="color:red">*</span>工作日期：</td>
											<td class="table_content">${ryxx1.DGzrq}</td>
											<td class="table_title">政法工作日期：</td>
											<td class="table_content">${ryxx1.DZfgzrq}</td>
											<td class="table_title"><span style="color:red">*</span>进院日期：</td>
											<td class="table_content">${ryxx1.DJyrq}</td>
										</tr>
										<tr>
											<td class="table_title"><span style="color:red">*</span>补充工龄：</td>
											<td class="table_content">${ryxx1.NBcgl}年</td>
											<td class="table_title"><span style="color:red">*</span>扣减工龄：</td>
											<td class="table_content">${ryxx1.NKjgl}年</td>
											<td class="table_title">连续工龄：</td>
											<td class="table_content">${ryxx1.lxgl}年</td>
										</tr>
										<tr>
											<td class="table_title">进本院前法院年限：</td>
											<td class="table_content">${ryxx1.NJyqfynx}年</td>
											<td class="table_title">法院工作合计年限：</td>
											<td class="table_content">${ryxx1.fygzhjnx}年</td>
											<td class="table_title">应加学制：</td>
											<td class="table_content">${ryxx1.NYjxz}年</td>
										</tr>
									</table>
							</div>
							<div id="table_five" class="infoTable">
								<table>
										<tr>
											<td class="table_title"><span style="color:red">*</span>进途径：</td>
											<td class="table_content">${ryxx1.NJtj}</td>
											<td class="table_title"><span style="color:red">*</span>进来源：</td>
											<td class="table_content">${ryxx1.NJly}</td>
											<td class="table_title">审核日期：</td>
											<td class="table_content">${ryxx1.DShrq}</td>
										</tr>
										<tr>
											<td class="table_title">原职务：</td>
											<td class="table_content">${ryxx1.NYzw}</td>
											<td class="table_title">原职级：</td>
											<td class="table_content">${ryxx1.NYzj}</td>
											<td class="table_title">原单位：</td>
											<td class="table_content">${ryxx1.CYdw}</td>
										</tr>
										<tr>
											<td class="table_title">出原因：</td>
											<td class="table_content">${ryxx1.NCyy}</td>
											<td class="table_title">出日期：</td>
											<td class="table_content">${ryxx1.DCrq}</td>
											<td class="table_title">去向：</td>
											<td class="table_content">${ryxx1.NQx}</td>
										</tr>
									</table>
							</div>
							<div id="btn_contain"> <style> @media Print{.Noprn{DISPLAY:none}} </style>
								<button id="edit_btn" type="button" class="btn btn_primary Noprn" <c:if test="${isHidden}">style="visibility:hidden;"</c:if>>
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
			<span>版权所有&nbsp;淮安市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持 南京铉盈网络科技有限公司</span>
		</div>
	</div>
</div>
<div id="changePassword_dlg"></div>
</body>
</html>
