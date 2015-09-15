<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>

<html>
<head>
	<meta charset="utf-8" />
	<title>外语信息</title>
	<link rel="stylesheet" href="resources/css/flick/jquery-ui-1.8.21.custom.css" />
	<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
	<script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	<script type="text/javascript" src="/resources/js/ryjbxx.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery.treeview.js"></script>
	<!-- bootstrap -->
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"><jsp:text/></script>
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
					<div id="menu_title" data-current="${index==null?'':index }"><div id="cdlb"></div></div>
					<ul id="menu_list" data-showKey="${showKey}">
						<li class="list"><a>常用信息</a></li>
						<li class="sub_list" data-type="ryjbxx"><a>基本信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zzmm"><a>政治面貌<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zjxx"><a>职级信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="xzzw"><a>行政职务<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="flzw"><a>法律职务<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="xlxx"><a>学历信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="xwxx"><a>学位信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jlxx"><a>简历信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jtxx"><a>家庭信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="khxx"><a>考核信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jlixx"><a>奖励信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="sfks"><a>司法考试<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jliuxx"><a>交流信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="pxxx"><a>培训信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="rcxx"><a>人才信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="gryjda"><a>个人业绩档案<span class="clicked_a">→</span></a></li>
						
						<li class="list"><a>其他信息</a></li>
						<li class="sub_list" data-type="djxx"><a>等级信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="gwyjb"><a>公务员级别<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zyjszw"><a>专业技术职务<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jrzw"><a>兼任职务<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="ldbz"><a>领导班子<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="hbgb"><a>后备干部<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="gzxx"><a>工资信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="ccxx"><a>惩处信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="swxx"><a>伤亡信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="zdxx"><a>在读信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="cgxx"><a>出国信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="wyxx"><a>外语信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="txl"><a>通讯录<span class="clicked_a">→</span></a></li>
						<!-- <li class="sub_list" data-type="syyyx"><a>声音与影像<span class="clicked_a">→</span></a></li>  -->
						<li class="sub_list" data-type="bzxx"><a>备注信息<span class="clicked_a">→</span></a></li>
						
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
				<div id="current_position"><span id="position_text">当前位置：&nbsp;人员信息&nbsp;&gt;外语信息</span>
				</div>
				<div id="content_wapper">
					<div id="tree_ry">
						<div><span>人员信息</span></div>
					</div>
					<div id="list_ry">
						<div id="detail">
							<div class="main_wapper">
								<div class="wapper_title">
									<span>当前人员：${cxm}</span><span style="left:180px;">单位：${fymc}</span><span style="right:125px;">状态：在职</span>
									<button type="button" class="btn btn-primary" id="wyxx_add_btn" data-btn_type="0" <c:if test="${isHidden}">style="visibility:hidden;"</c:if>>
										<span class="glyphicon glyphicon-plus"></span> 添加
									</button>
								</div>
									<div id="wyxx_list" class="main_list">
									<table class="dataTable" data-maxindex="${wyxxList.size()}">
										<thead>
											<th width="42px" style="text-align:left">序号</th>
											<th>外语语种</th>
											<th>熟练程度</th>
											<th width="80px">水平级别</th>
											<th>操作</th>
										</thead>
										<tbody>
											<c:forEach items="${wyxxList}" var="wyxxList" varStatus="i">
													<tr>
														<td class="center">${i.index+1}</td>
														<td class="center">${wyxxList.NWyyz}</td>
														<td class="center">${wyxxList.NSlcd}</td>
														<td class="center">${wyxxList.NSpjb}</td>
														<td class="center" data-keyid="${wyxxList.NId}" data-fydm="${wyxxList.NFy}" data-rybh="${wyxxList.NRybh}"> 
															<a class="dlg_view" data-btn_type="1">查看</a><span <c:if test="${isHidden}">style="display: none;"</c:if> >|</span>
															<a class="dlg_modify" data-btn_type="2" <c:if test="${isHidden}">style="display: none;"</c:if>>修改</a><span <c:if test="${isHidden}">style="display: none;"</c:if>>|</span>
															<a class="i_delete" <c:if test="${isHidden}">style="display: none;"</c:if>>删除</a>
														</td>
													</tr>
											</c:forEach>
										</tbody>
									</table>
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
		<span>版权所有&nbsp;淮安市中级人民法院&nbsp;&nbsp;|&nbsp;&nbsp;技术支持 南京铉盈网络科技有限公司</span>
	</div>
</div>
<div id="wyxx_dlg"></div><div class="J_dlg"></div>
</body>
</html>
