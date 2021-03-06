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
	<title>简历信息</title>
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
						<li class="sub_list" data-type="ryjbxxfzb"><a>基本信息<span class="clicked_a">→</span></a></li>
						<li class="sub_list" data-type="jlxxfzb"><a>简历信息<span class="clicked_a">→</span></a></li>
					</ul>
				</div>
				<div id="menu_open"></div>
			</div>
			<div class="right_content">
				<div id="current_position"><span id="position_text">当前位置：&nbsp;人员信息&nbsp;&gt;简历信息</span>
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
									<button type="button" class="btn btn-primary" id="jlxxfzb_add_btn" data-btn_type="0" <c:if test="${isHidden}">style="visibility:hidden;"</c:if>>
										<span class="glyphicon glyphicon-plus"></span> 添加
									</button>
								</div>
								<div id="jlxxfzb_list" class="main_list">
									<table class="dataTable" data-maxindex="${jlxxList.size()}">
										<thead>
											<th width="42px" style="text-align:left">序号</th>
											<th width="76px">起始日期</th>
											<th width="76px">截止日期</th>
											<th width="80px">单位</th>
											<th width="85px">部门</th>
											<th width="60px">职务</th>
											<th width="60px">职级</th>
											<th>操作</th>
										</thead>
										<tbody>
											<c:forEach items="${jlxxList}" var="jlxxList" varStatus="i">
													<tr>
														<td class="center">${i.index+1}</td>
														<td class="center">${jlxxList.DQsrq}</td>
														<td class="center">${jlxxList.DJzrq}</td>
														<td class="center">${jlxxList.CSzdw}</td>
														<td class="center">${jlxxList.CSzbm}</td>
														<td class="center">${jlxxList.CZw}</td>
														<td class="center">${jlxxList.CZj}</td>
														<td class="center" data-keyid="${jlxxList.NId}" data-fydm="${jlxxList.NFy}" data-rybh="${jlxxList.NRybh}"> 
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
<div id="jlxxfzb_dlg"></div><div class="J_dlg"></div>
</body>
</html>
