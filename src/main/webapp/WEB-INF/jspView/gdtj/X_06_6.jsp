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
		<div class="fbt">表一：法官职级分布统计总表</div>
		<table align="center">
			<tr>
				<td>单位</td>
				<td>法官总数</td>
				<td>正厅</td>
				<td>副厅</td>
				<td>正处</td>
				<td>副处</td>
				<td>正科</td>
				<td>副科</td>
				<td>科员</td>
				<td>科员以下</td>
			</tr>
			<c:forEach items="${fgs}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.zs }</td>
					<td>${item.zt }</td>
					<td>${item.ft }</td>
					<td>${item.zc }</td>
					<td>${item.fc }</td>
					<td>${item.zk }</td>
					<td>${item.fk }</td>
					<td>${item.ky }</td>
					<td>${item.kyyx }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="fbt">表二：非领导职务法官职级分布表</div>
		<table align="center">
			<tr>
				<td>单位</td>
				<td>非领导职务法官总数</td>
				<td>正处</td>
				<td>副处</td>
				<td>正科</td>
				<td>副科</td>
				<td>科员</td>
				<td>科员以下</td>
			</tr>
			<c:forEach items="${fldfgs}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.zs }</td>
					<td>${item.zc }</td>
					<td>${item.fc }</td>
					<td>${item.zk }</td>
					<td>${item.fk }</td>
					<td>${item.ky }</td>
					<td>${item.kyyx }</td>
				</tr>
			</c:forEach>
			<tr>
				<td>备注</td>
				<td colspan=7 style="text-align:left;">
					1、非领导职务法官，是指目前没有担任领导职务以及以前也没有担任过领导职务的一般法官，一般法官包含审判员和助理审判员。<br>
					2、领导职务是指法院院领导、正副庭长、正副处长、正副主任等院领导和中层领导职务，以及其他参照中层领导干部管理的专职副书记、廉政监察员等职务。
				</td>
			</tr>
		</table>
		<br>
		<div class="fbt">表三：现任人民法庭庭长职级分布表</div>
		<table align="center">
			<tr>
				<td>单位</td>
				<td>法庭总数</td>
				<td>现任法庭庭长总数</td>
				<td>副处</td>
				<td>正科</td>
				<td>副科</td>
				<td>科员</td>
			</tr>
			<c:forEach items="${tzs}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.ftzs }</td>
					<td>${item.tzzs }</td>
					<td>${item.fc }</td>
					<td>${item.zk }</td>
					<td>${item.fk }</td>
					<td>${item.ky }</td>
				</tr>
			</c:forEach>
			<tr>
				<td>备注</td>
				<td colspan=6 style="text-align:left;">
					人民法庭庭长仅限于正职庭长，主持工作的副庭长不计入统计。
				</td>
			</tr>
		</table>
	</div>
  </body>
</html>