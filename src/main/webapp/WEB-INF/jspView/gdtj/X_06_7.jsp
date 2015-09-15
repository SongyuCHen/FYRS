<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  	<title>法院人事 - ${bt}</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	
	<style type="text/css">
	table
	{
		border-collapse:collapse;
		margin-top:20px;
		margin-bottom:10px;
		/*border:2px solid;*/
	}
	td
	{
		border:1px solid;
		text-align:center;
		width:80px;
		height:35px;
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
	.fbt
	{
		font-size: 25px;
		font-family:"黑体";
		font-weight:bold;
		text-align: center;
		margin-top: 30px;
		margin-bottom: 30px;
	}
	.xbt
	{
		font-weight:bold;
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
		margin:10px 15px 10px 10px;
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
	function exportToWord(controlId) {
        var control = document.getElementById(controlId);
        try {
            var oWD = new ActiveXObject("Word.Application");
           var oDC = oWD.Documents.Add("", 0, 1);
           var oRange = oDC.Range(0, 1);
          var sel = document.body.createTextRange();
          try {
              sel.moveToElementText(control);
         } catch (notE) {
              alert("导出数据失败，没有数据可以导出。");
             window.close();
               return;
         }
         sel.select();
           sel.execCommand("Copy");
          oRange.Paste();
          oWD.Application.Visible = true;   
		   //window.close();
       }
       catch (e) {
           alert("导出数据失败，需要在客户机器安装Microsoft Office Word(不限版本)，将当前站点加入信任站点，允许在IE中运行ActiveX控件。");
           try { oWD.Quit(); } catch (ex) { }
           //window.close();
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
		<div class="bt">${bt}</div>
		<div class="fbt">表一：法官年龄、学历分布统计表</div>
		<table align="center">
			<tr>
				<td rowspan=2>单位</td>
				<td rowspan=2>法官总数</td>
				<td colspan=4>年龄分布</td>
				<td colspan=5>学历分布</td>
			</tr>
			<tr>
				<td>35岁及以下</td>
				<td>36-45岁</td>
				<td>46-55岁</td>
				<td>56岁及以上</td>
				<td>博士研究生</td>
				<td>硕士研究生</td>
				<td>大学本科</td>
				<td>大专</td>
				<td>高中及以下(含中专)</td>
			</tr>
			<c:forEach items="${fgnlxls}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.zs }</td>
					<td>${item.nl_35 }</td>
					<td>${item.nl_36_45 }</td>
					<td>${item.nl_46_55 }</td>
					<td>${item.nl_56 }</td>
					<td>${item.xl_bs }</td>
					<td>${item.xl_ss }</td>
					<td>${item.xl_bk }</td>
					<td>${item.xl_dz }</td>
					<td>${item.xl_gzyx }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>