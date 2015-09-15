<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/ajjtxx.js"></script>
<script type="text/javascript" src="/resources/js/spyj.js"></script>

<link rel="stylesheet" type="text/css" href="/resources/css/customtable.css">
<link rel="stylesheet" type="text/css" href="/resources/css/yjda.css">
</head>
<body>
	<div class="titlecontent form-horizontal">
		<div id="sjxz" class="form-horizontal">
			<label class="control-label">时间选择</label>
			<div class="selectcontent">
				<select id="select-sj" class="input-sm form-control">
					<option value="-1">请选择时间</option>
					<option value="1">年度</option>
					<option value="2">季度</option>
					<option value="3">月份</option>
					<option value="4">期间</option>
					<option value="5">全部</option>
				</select> <br />
				<div class="bianhua col-md-9 col-md-9">
					<div class="input-group" id="sjfw">
						<input type="text"
							class="input-sm form-control zdytj-datepicker datepicker"
							id="fromDate" /> <span class="input-group-addon">至</span> <input
							type="text"
							class="input-sm form-control zdytj-datepicker datepicker"
							id="toDate" />
					</div>
					<div class="input-group" id="niandu">
						<select id="select-year" class="input-sm form-control">
						</select> <span class="input-group-addon">年</span> <select
							id="select-xuanze" class="input-sm form-control">
						</select>
					</div>
				</div>
			</div>
		</div>
		<div id="selectmenu">
			<label class="control-label">选项选择</label>
			<div class="selectcontent">
				<select id="select-xx" class="input-sm form-control">
					<option value="-1">请选择...</option>
					<option value="1">部门</option>
					<option value="2">职务</option>
					<option value="3">职级</option>
				</select> <br> <select id="select-ry" class="input-sm form-control">
				</select>

				<div id="scbb">
					<button type="button" class="btn btn-primary" id="bg_ge">
						<span class="glyphicon glyphicon-print"></span> 生成报表
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="maincontent">
		<div id="content">
			<div id="tablecontent">
				<img src="/resources/images/loading.gif" id="loadingSpinner"
					style="display:none;" />
				<!-- 个人业绩档案  -->
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

				<!-- 全院  -->
				<div id="tablenrone">
					<div id="tabletitleone">
						<span>法官业绩考评</span>
					</div>
					<div id="tablemenuone">
						<table id="fgyjkp">
							<tr>
								<td rowspan="3" style="width:120px;"><span>部门</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="15"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案件</span>
								</td>
							</tr>
							<tr>
								<td colspan="10"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="2"><span>当庭裁判</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
							</tr>
							<tr id="temp">
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>审诉复查</span>
								</td>
								<td><span>减刑假释</span>
								</td>
								<td><span>复核案件</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>当庭裁判案件数</span>
								</td>
								<td><span>当庭裁判率(%)</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
							</tr>
						</table>
					</div>
				</div>

				<!-- 刑事 -->
				<div id="tablenrtwo">
					<div id="tabletitletwo">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenutwo">
						<table id="fgyjkpxst">
							<tr>
								<td rowspan="3" style="width:150px;"><span>审判职务</span>
								</td>
								<td rowspan="3" style="width:80px;"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="31"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="10"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>刑事案件调解撤诉情况</span>
								</td>
								<td colspan="2"><span>一审陪审情况</span>
								</td>
								<td colspan="2"><span>一审简易程序</span>
								</td>
								<td colspan="2"><span>二审开庭情况</span>
								</td>
								<td colspan="2"><span>上诉情况</span>
								</td>
								<td colspan="2"><span>被改判发回情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr>
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>减刑假释</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉数</span>
								</td>
								<td><span>调解撤诉率(%)</span>
								</td>
								<td><span>陪审数</span>
								</td>
								<td><span>陪审率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>开庭数</span>
								</td>
								<td><span>开庭率(%)</span>
								</td>
								<td><span>上诉数</span>
								</td>
								<td><span>上诉率(%)</span>
								</td>
								<td><span>被改判，发回数</span>
								</td>
								<td><span>被改发率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 民事 -->
				<div id="tablenrthree">
					<div id="tabletitlethree">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenuthree">
						<table id="fgyjkpmst">
							<tr>
								<td rowspan="3" style="width:150px;"><span>审判职务</span>
								</td>
								<td rowspan="3" style="width:80px;"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="33"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="8"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>民事案件调解撤诉情况</span>
								</td>
								<td rowspan="2"><span>民事特别程序撤回申请数</span>
								</td>
								<td colspan="2"><span>一审陪审情况</span>
								</td>
								<td colspan="2"><span>一审简易程序</span>
								</td>
								<td colspan="2"><span>二审开庭情况</span>
								</td>
								<td colspan="2"><span>上诉情况</span>
								</td>
								<td colspan="2"><span>被改判发回情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td colspan="3"><span>民商事调解结案实际履行率</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr >
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉数</span>
								</td>
								<td><span>调解撤诉率(%)</span>
								</td>
								<td><span>陪审数</span>
								</td>
								<td><span>陪审率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>开庭数</span>
								</td>
								<td><span>开庭率(%)</span>
								</td>
								<td><span>上诉数</span>
								</td>
								<td><span>上诉率(%)</span>
								</td>
								<td><span>被改判，发回数</span>
								</td>
								<td><span>被改发率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率</span>
								</td>
								<td><span>民商事案件调解结案数</span>
								</td>
								<td><span>调解结案中实际履行结案数</span>
								</td>
								<td><span>实际履行率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 行政审判  -->
				<div id="tablenrfour">
					<div id="tabletitlefour">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenufour">
						<table id="xzspt">
							<tr>
								<td rowspan="3" style="width:150px;"><span>审判职务</span>
								</td>
								<td rowspan="3" style="width:80px;"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="30"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="9"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>行政案件调解撤诉情况</span>
								</td>
								<td colspan="2"><span>一审陪审情况</span>
								</td>
								<td colspan="2"><span>一审简易程序</span>
								</td>
								<td colspan="2"><span>二审开庭情况</span>
								</td>
								<td colspan="2"><span>上诉情况</span>
								</td>
								<td colspan="2"><span>被改判发回情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr>
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>行政审查执行案件</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉数</span>
								</td>
								<td><span>调解撤诉率(%)</span>
								</td>
								<td><span>陪审数</span>
								</td>
								<td><span>陪审率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>开庭数</span>
								</td>
								<td><span>开庭率(%)</span>
								</td>
								<td><span>上诉数</span>
								</td>
								<td><span>上诉率(%)</span>
								</td>
								<td><span>被改判，发回数</span>
								</td>
								<td><span>被改发率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 执行局 -->
				<div id="tablenrfive">
					<div id="tabletitlefive">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenufive">
						<table id="zxj">
							<tr>
								<td rowspan="3"><span>审判职务</span>
								</td>
								<td rowspan="3"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>执行案件受理</span>
								</td>
								<td colspan="21"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="3"><span>执结</span>
								</td>
								<td colspan="5"><span>执行率</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>执行标的额到位情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>执行案件投诉情况</span>
								</td>
								<td colspan="3"><span>执行案件中止终结率</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr>
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>执结率(%)</span>
								</td>
								<td><span>强制执行数</span>
								</td>
								<td><span>自动履行数</span>
								</td>
								<td><span>和解数</span>
								</td>
								<td><span>实际执行率(%)</span>
								</td>
								<td><span>执行案件自动履行和解率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>到位标的额(万元)</span>
								</td>
								<td><span>申请标的额(万元)</span>
								</td>
								<td><span>到位率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率(%)</span>
								</td>
								<td><span>执行案件中止结案数</span>
								</td>
								<td><span>执行案件终结结案数</span>
								</td>
								<td><span>执行案件中止终结率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 立案庭 -->
				<div id="tablenrsix">
					<div id="tabletitlesix">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenusix">
						<table id="laj">
							<tr>
								<td rowspan="3"><span>审判职务</span>
								</td>
								<td rowspan="3"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="17"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="8"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>民事案件调解撤诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr>
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉率</span>
								</td>
								<td><span>调解撤诉率</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率(%)</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 审判监督庭 -->
				<div id="tablenrseven">
					<div id="tabletitleseven">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenuseven">
						<table id="spjdt">
							<tr>
								<td rowspan="3"><span>审判职务</span>
								</td>
								<td rowspan="3"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="28"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="9"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>民事案件调解撤诉情况</span>
								</td>
								<td colspan="2"><span>一审陪审情况</span>
								</td>
								<td colspan="2"><span>一审简易程序</span>
								</td>
								<td colspan="2"><span>上诉情况</span>
								</td>
								<td colspan="2"><span>被改判发回情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr >
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>减刑假释</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉数</span>
								</td>
								<td><span>调解撤诉率(%)</span>
								</td>
								<td><span>陪审数</span>
								</td>
								<td><span>陪审率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>上诉数</span>
								</td>
								<td><span>上诉率(%)</span>
								</td>
								<td><span>被改判，发回数</span>
								</td>
								<td><span>被改发率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 赔偿办 -->
				<div id="tablenreight">
					<div id="tabletitleeight">
						<span>法官业绩考评</span>
					</div>
					<span>人均结案数：</span>
					<div id="tablemenueight">
						<table id="pcb">
							<tr>
								<td rowspan="3"><span>审判职务</span>
								</td>
								<td rowspan="3"><span>姓名</span>
								</td>
								<td rowspan="2" colspan="3"><span>受理</span>
								</td>
								<td colspan="33"><span>审结</span>
								</td>
								<td colspan="7"><span>未结案数</span>
								</td>
								<td colspan="7"><span>录入项</span>
								</td>
							</tr>
							<tr>
								<td colspan="8"><span>结案</span>
								</td>
								<td colspan="2"><span>法定正常审限</span>
								</td>
								<td rowspan="2"><span>案件平均审理天数</span>
								</td>
								<td colspan="3"><span>民事案件调解撤诉情况</span>
								</td>
								<td rowspan="2"><span>民事特别程序撤回申请数</span>
								</td>
								<td colspan="2"><span>一审陪审情况</span>
								</td>
								<td colspan="2"><span>一审简易程序</span>
								</td>
								<td colspan="2"><span>二审开庭情况</span>
								</td>
								<td colspan="2"><span>上诉情况</span>
								</td>
								<td colspan="2"><span>被改判发回情况</span>
								</td>
								<td colspan="2"><span>申诉情况</span>
								</td>
								<td colspan="2"><span>信访投诉</span>
								</td>
								<td rowspan="2"><span>参加合议庭案件数</span>
								</td>
								<td colspan="3"><span>民商事调解结案实际履行率</span>
								</td>
								<td rowspan="2"><span>总数</span>
								</td>
								<td colspan="5"><span>其中四项未结数</span>
								</td>
								<td rowspan="2"><span>18个月以上未结案件数</span>
								</td>
								<td colspan="2"><span>承办专案数</span>
								</td>
								<td rowspan="2"><span>审批案件数</span>
								</td>
								<td rowspan="2"><span>审批裁判文书数</span>
								</td>
								<td colspan="3"><span>裁判文书差错率</span>
								</td>
							</tr>
							<tr>
								<td><span>旧存</span>
								</td>
								<td><span>新收</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>再审</span>
								</td>
								<td><span>申诉复查</span>
								</td>
								<td><span>其他</span>
								</td>
								<td><span>结案总数</span>
								</td>
								<td><span>结收案比(%)</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>调解数</span>
								</td>
								<td><span>撤诉数</span>
								</td>
								<td><span>调解撤诉率(%)</span>
								</td>
								<td><span>陪审数</span>
								</td>
								<td><span>陪审率(%)</span>
								</td>
								<td><span>结案数</span>
								</td>
								<td><span>结案率(%)</span>
								</td>
								<td><span>开庭数</span>
								</td>
								<td><span>开庭率(%)</span>
								</td>
								<td><span>上诉数</span>
								</td>
								<td><span>上诉率(%)</span>
								</td>
								<td><span>被改判，发回数</span>
								</td>
								<td><span>被改发率(%)</span>
								</td>
								<td><span>申诉数</span><br>
								</td>
								<td><span>申诉率(%)</span>
								</td>
								<td><span>投诉数</span>
								</td>
								<td><span>投诉率</span>
								</td>
								<td><span>民商事案件调解结案数</span>
								</td>
								<td><span>调解结案中实际履行结案数</span>
								</td>
								<td><span>实际履行率</span>
								</td>
								<td><span>延长</span>
								</td>
								<td><span>中止</span>
								</td>
								<td><span>中断</span>
								</td>
								<td><span>暂停</span>
								</td>
								<td><span>小计</span>
								</td>
								<td><span>收案</span>
								</td>
								<td><span>结案</span>
								</td>
								<td><span>评查裁判文书数</span>
								</td>
								<td><span>出现差错裁判文书数</span>
								</td>
								<td><span>差错率(%)</span>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				<!-- 职务职级 -->
				<div id="tablenrnine">
					<div id="tabletitlenine">
						<span>法官业绩考评</span>
					</div>
					<div id="tablemenunine">
						<table id="zwzj">
							<tr>
								<td rowspan="2"><span>序号</span>
								</td>
								<td rowspan="2" style="width:50px;"><span>姓名</span>
								</td>
								<td colspan="17"><span>新收案件</span>
								</td>
								<td colspan="17"><span>已结案件</span>
								</td>
							</tr>
							<tr>
								<td><span>诉前保全</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>刑事申诉</span>
								</td>
								<td><span>刑事再审</span>
								</td>
								<td><span>行政申诉</span>
								</td>
								<td><span>行政再审</span>
								</td>
								<td><span>民事申诉</span>
								</td>
								<td><span>民事抗诉</span>
								</td>
								<td><span>申请再审</span>
								</td>
								<td><span>民事再审</span>
								</td>
								<td><span>请示协调</span>
								</td>
								<td><span>死刑复核</span>
								</td>
								<td><span>减刑假释</span>
								</td>
								<td><span>破产</span>
								</td>
								<td><span>执行</span>
								</td>
								<td><span>赔偿</span>
								</td>
								<td><span>诉前保全</span>
								</td>
								<td><span>一审</span>
								</td>
								<td><span>二审</span>
								</td>
								<td><span>刑事申诉</span>
								</td>
								<td><span>刑事再审</span>
								</td>
								<td><span>行政申诉</span>
								</td>
								<td><span>行政再审</span>
								</td>
								<td><span>民事申诉</span>
								</td>
								<td><span>民事抗诉</span>
								</td>
								<td><span>申请再审</span>
								</td>
								<td><span>民事再审</span>
								</td>
								<td><span>请示协调</span>
								</td>
								<td><span>死刑复核</span>
								</td>
								<td><span>减刑假释</span>
								</td>
								<td><span>破产</span>
								</td>
								<td><span>执行</span>
								</td>
								<td><span>赔偿</span>
								</td>
							</tr>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div id="ajjtxx_dlg"></div>
</body>
</html>
