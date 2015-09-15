<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
  	<title>人员增减事项及人员结构变更记录(二)</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/jquery-ui/custom-theme/jquery-ui-1.9.2.custom.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css" />
	
	<style type="text/css">
	table
	{
		margin-top:20px;
		margin-bottom:5px;
		border:2px solid;
	}
	td
	{
		border:1px solid;
		text-align:center;
		width:50px;
		height:40px;
	}
	.bt
	{
		font-size: 30px;
		font-family:"黑体";
		font-weight:bold;
		text-align: center;
		margin-top: 30px;
	}
	.button
	{
		width:110px;
		height:25px;
		font-weight:bold;
		color:#fff;
		text-shadow:1px 1px 1px #333;
		border-radius:8px;
		margin:10px 15px 10px 10px;
		position:relative;
		overflow:hidden;
		background-color: #42a4e0;
	}
	.button:hover
	{
		background-color: #70bfef;
	}
	.controllabel{
		display: inline-block;
		width: 90px;
		height: 24px;
		text-align:center;
		color: #166092;
		font-weight: 700;
	}
	.selectArea{
		display: inline-block;
		width: 80px;
	}
	</style>
  </head>
  <body>
  	<div>
  		<input type="button" class="button" onclick="exportToWord('printdiv');" value="导出Word"/>
  	</div>
  	<div  id="printdiv">
  	<div class="bt">人员增减事项及人员结构变更记录(二)</div><br><br>
  	<table align="center">
  		<tr>
  			<td rowspan=4>时间</td>
  			<td colspan=3>实有在编人员</td>
  			<td colspan=16>在编人员结构明细</td>
  			<td colspan=4>非在编实有数</td>
  			<td rowspan=4>其他项说明</td>
  			<td rowspan=4>经办人签章</td>
  			<td rowspan=4>审核人签章</td>
  		</tr>
  		<tr>
  			<td rowspan=3>合计</td>
  			<td rowspan=3>行政编制人员</td>
  			<td rowspan=3>行政附属人员</td>
  			<td rowspan=3>编制单列人员</td>
  			<td colspan=3>部门领导职数实有数</td>
  			<td colspan=5>内设机构领导职数实有数</td>
  			<td colspan=4 rowspan=2>非领导职数实有数</td>
  			<td colspan=2 rowspan=2>到龄转任非领导职数实有数</td>
  			<td rowspan=3>科员及办事员</td>
  			<td rowspan=3>合计</td>
  			<td rowspan=3>离休人员</td>
  			<td rowspan=3>退休人员</td>
  			<td rowspan=3>其他</td>
  		</tr>
  		<tr>
  			<td rowspan=2>正职</td>
  			<td rowspan=2>副职</td>
  			<td rowspan=2>其他</td>
  			<td rowspan=2>正职</td>
  			<td colspan=2>副职</td>
  			<td colspan=2>其他</td>
  		</tr>
  		<tr>
  			<td>副处级</td>
  			<td>正科级</td>
  			<td>正科级</td>
  			<td>副科级</td>
  			<td>调研员</td>
  			<td>副调研员</td>
  			<td>主任科员</td>
  			<td>副主任科员</td>
  			<td>正科级</td>
  			<td>副科级</td>
  		</tr>
  		<tr>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  			<td></td>
  		</tr>
  	</table>
  	</div>
  </body>
</html>