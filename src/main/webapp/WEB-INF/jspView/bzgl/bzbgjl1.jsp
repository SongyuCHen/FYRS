<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
  	<title>人员增减事项及人员结构变更记录(一)</title>
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
  	<div class="bt">人员增减事项及人员结构变更记录(一)</div><br><br>
  	<table align="center">
  		<tr>
  			<td>办理时间</td>
  			<td>人员增减记录<br>姓名、岗位变化、职务、来源\去向</td>
  			<td>增减事项标识(增人填“+”号，减人填“-”号)</td>
  			<td>经办人签章</td>
  			<td>审核人签章</td>
  		</tr>
  		<tr>
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