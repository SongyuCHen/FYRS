<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>    
    <title>法院人事 - ${bt.tjbmc}</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	td
	{
		border:1px solid;
		text-align:center;
	}
	.lefttd
	{
		width:120px;
		height:33px;
	}
	.headtd
	{
		width:40px;
		height:110px;
	}
	.bt
	{
		font-size: 30px;
		font-family:"黑体";
		font-weight:bold;
		text-align: center;
		margin-top: 30px;
		margin-bottom: 30px;
	}
	.xgxx
	{
		font-size: 10px;
		margin-top: 5px;
		text-align: center;
	}
	.button
	{
		width:110px;
		height:25px;
		font-weight:bold;
		color:#fff;
		text-shadow:1px 1px 1px #333;
		border-radius:8px;
		margin:0 15px 20px 0;
		position:relative;
		overflow:hidden;
		background-color: #42a4e0;
	}
	.button:hover
	{
		background-color: #70bfef;
	}
	@media print{
		.noprint{display : none }
	}
	</style>
	<script type="text/javascript">
	$(function(){		
		var today=new Date();
		var html=today.getFullYear();
		$("#jzrq").append(today.getFullYear()+"-"+(today.getMonth()+1)+"-"+today.getDate());
	});
	
	function exportToWord(controlId) {
        var control = document.getElementById(controlId);
        try{
           var oWD = new ActiveXObject("Word.Application");
           var oDC = oWD.Documents.Add("", 0, 1);
           var oRange = oDC.Range(0, 1);
           var sel = document.body.createTextRange();
           try{
              sel.moveToElementText(control);
           } catch (notE){
              alert("导出数据失败，没有数据可以导出。");
              window.close();
              return;
           }
           sel.select();
           sel.execCommand("Copy");
           oRange.Paste();
           oWD.Application.Visible = true;   
		   //window.close();
        } catch (e){
           alert("导出数据失败，需要在客户机器安装Microsoft Office Word(不限版本)，将当前站点加入信任站点，允许在IE中运行ActiveX控件。");
           try{ 
        	   oWD.Quit(); 
           } catch (ex) {
        	   alert("");
           }
       }
   }
	
	function exportToExcel(controlId){
		var control = document.getElementById(controlId);
		try {
		var oXL = new ActiveXObject("Excel.Application"); 
		  var oWB = oXL.Workbooks.Add(); 
		  var oSheet = oWB.ActiveSheet;  
		  var sel=document.body.createTextRange();
		  sel.moveToElementText(control);
		  sel.select();
		  sel.execCommand("Copy");
		  oSheet.Paste();
		  oXL.Visible = true;
		}
		  catch (e) {
	           alert("导出数据失败，需要在客户机器安装Microsoft Office Excel(不限版本)，将当前站点加入信任站点，允许在IE中运行ActiveX控件。");
	           try { oWD.Quit(); } catch (ex) { }
	           //window.close();
	       }
	}
	</script>
  </head>
  
  <body>
    <div class="noprint">
    	<input type="button" class="button" onclick="exportToWord('printdiv');" value="导出Word"/>
		<input type="button" class="button" onclick="exportToExcel('printdiv');" value="导出Excel"/>
		<input type="button" class="button" onclick="window.print();" value="打印"/>
	</div>
	<div id="printdiv">
  	<div class="bt">${bt.tjbmc}</div>
  	<div class="xgxx">报表编号：${bt.tjbbh}</div>
  	<div id="jzrq" class="xgxx">截止日期：</div>
  	<div class="xgxx">制表机关：徐州市中级人民法院(本院信息)</div>
  	<div class="xgxx">备案机关：国家统计局</div>
  	<div class="xgxx">备案文号：国统办函[2001]130号</div>
  	<table align="center" style="border-collapse:collapse;margin-top:20px;margin-bottom:50px;">
  		<c:forEach items="${result}" var="row" varStatus="rowstatus">
  			<tr>
    		<c:forEach items="${row}" var="item" varStatus="columnstatus">
    			<c:choose>
    				<c:when test="${columnstatus.index==0&&rowstatus.index!=0 }"><td class="lefttd">${item}</td>
    				</c:when>
    				<c:when test="${columnstatus.index!=0&&rowstatus.index==0 }"><td class="headtd">${item}</td>
    				</c:when>
    				<c:when test="${columnstatus.index==0&&rowstatus.index!=0 }"><td class="leftheadtd">${item}</td>
    				</c:when>
    				<c:otherwise><td class="commontd">${item}</td></c:otherwise>
    			</c:choose>
    		</c:forEach>
    		</tr>
    	</c:forEach>
  	</table>
  	</div>
  </body>
</html>
