<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="../../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
     <script type="text/javascript" src="/resources/js/ajjtxx.js"></script>
     <link rel="stylesheet" href="/resources/css/demo_table.css" />
     
<div id="ajjtxx_list" class="ajlbtable">
	<table class="dataTable" style="table-layout: automatic;">
		<thead>
			<th style="width: 27px;">序号</th>
			<th style="width: 185px;">案号</th>
			<th style="width: 760px;">案件名称</th>
			<th style="width: 45px;">承办人</th>
			<th style="width:145px;">立案日期</th>
			<th style="width:145px;">结案日期</th>
			<th style="width:50px;">审限</th>
			<th style="vertical-align: top;">附加</th>
			<th style="vertical-align: top;">总计</th>
		</thead>
		<tbody>
			<c:forEach items="${ajjtxxList}" var="ajjtxxList" varStatus="i">
				<tr>
					<td class="center" style="width: 36px;">${i.index+1}</td>
					<td class="center" style="width: 180px;">${ajjtxxList.AH}</td>
					<td class="center" style="width: 760px;">${ajjtxxList.AJMC}</td>
					<td class="center" style="width: 45px;">${ajjtxxList.XM}</td>
					<td class="center" style="width:145px;">${ajjtxxList.LARQ}</td>
					<td class="center" style="width:145px;">${ajjtxxList.JARQ}</td>
					<td class="center" style="width:50px;">${ajjtxxList.shixian}</td>
					<td class="center"></td>
					<td class="center"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
