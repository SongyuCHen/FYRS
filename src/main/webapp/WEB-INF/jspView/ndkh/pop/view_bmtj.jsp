<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="../../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style type="text/css">
#titleContent {
	padding: 15px 0;
	background-color: #EEF7FD;
	border-bottom: 2px solid #96C8EB;
	color: #166092;
	font-size: 120%;
}

#bmtjbg {
	width: 560px;
	height: 300px;
	overflow: true;
}

#head {
	font-size: 20px;
	text-align: center;
}

tr {
	border: 2px solid #96C8EB;
	width: 560px;
	height: 30px;
}

td {
	border: 2px solid #96C8EB;
	width: 120px;
	height: 30px;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		var date = new Date();
		var year = date.getFullYear();
		var selectObj = document.getElementById("select-xznf");
		for ( var i = 1990; i < year + 10; i++) {
			selectObj.options.add(new Option(i, i));
		}
		selectObj.value = year;
		$("#tj").live("click",function() {
							$.ajax({
										url : "tjsc.aj",
										type : "post",
										data : {
											'year' : $("#select-xznf").val()
										},
										dataType : "json",
										success : function(json) {
											$("tr[id^='line']").remove();
											$("#bm").text(json[0][0]);
											var yx = 0, cz = 0, bcz = 0;
											for ( var i = 0; i < json.length; i++) {
												var jsonObj = json[i];
												$("#tcsj")
														.after(
																"<tr id=line" + i
															+ "></tr>");
												for ( var j = 1; j < jsonObj.length; j++) {
													if (j == 4) {
														$("#line" + i)
																.append(
																		"<td colspan="+2+">"
																				+ jsonObj[j]
																				+ "</td>");
													} else {
														$("#line" + i)
																.append(
																		"<td>"
																				+ jsonObj[j]
																				+ "</td>");
														if (jsonObj[j] == "称职") {
															cz++;
														}
														if (jsonObj[j] == "优秀") {
															yx++;
														}
														if (jsonObj[j] == "不称职") {
															bcz++;
														}
													}
												}
											}
											$("#yxrs").text(yx + "人");
											$("#czrs").text(cz + "人");
											$("#bczrs").text(bcz + "人");

										}
									});
						});
	});
</script>
<div id="titleContent" class="form-horizontal">
	<div class="row">
		<div class="col-sm-5 col-md-5" style="display:inline-block;">
			<label class="col-sm-4 col-md-4 control-label" for="xzfy_ipt" style="display:inline-block;">年度：</label>
			<div class="col-sm-8 col-md-8" style="display:inline-block;">
				<select id="select-xznf" class="form-control">
					<option value="-1">请选择...</option>
				</select>
			</div>
		</div>
		<div class="col-sm-2 col-md-2" style="display:inline-block;">
			<button type="button" class="btn btn-primary" id="tj">
				<span class="glyphicon glyphicon-search"></span> 统计
			</button>
		</div>
	</div>
</div>
<div id="bmtjbg" style="width:100%;">
	<div id="head">
		<span>中层以下干部年度考核统计表</span>
	</div>
	<table>
		<tr>
			<td>部门</td>
			<td colspan="4" id="bm"></td>
		</tr>
		<tr id="tcsj">
			<td>姓名</td>
			<td>职务</td>
			<td>考核等次</td>
			<td colspan="2">备注</td>
		</tr>
		<tr>
			<td rowspan="6">合计</td>
			<td>优秀</td>
			<td id="yxrs">人</td>
			<td rowspan="6">部门领导审核意见</td>
			<td rowspan="6" colspan="2"></td>
		</tr>
		<tr>
			<td>称职</td>
			<td id="czrs">人</td>
		</tr>
		<tr>
			<td>基本称职</td>
			<td>人</td>
		</tr>
		<tr>
			<td>不称职</td>
			<td id="bczrs">人</td>
		</tr>
		<tr>
			<td>未参加考核</td>
			<td>人</td>
		</tr>
		<tr>
			<td>试用期不定等次</td>
			<td>人</td>
		</tr>
	</table>
</div>
