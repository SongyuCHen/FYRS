<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  	<title>法院人事 - ${title}</title>
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
		/*width:50px;
		height:40px;*/
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
		<div class="xbt">院领导（${ylds.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${ylds}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="xbt">调研员（${dyys.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${dyys}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="xbt">1、办公室（${bgss.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${bgss}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="xbt">2、组织人事处（${zzrscs.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${zzrscs}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="xbt">3、综合处（${zhcs.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${zhcs}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="xbt">4、教培处（${jpcs.size() }人）</div>
		<table align="center">
			<tr>
				<td>姓名</td>
				<td>出生日期</td>
				<td>行政职务</td>
				<td>法律职务</td>
				<td>行政职务时间</td>
				<td>法律职务时间</td>
				<td>职级</td>
				<td>职级时间</td>
				<td>等级</td>
				<td>工作时间</td>
				<td>进院时间</td>
				<td>籍贯</td>
				<td>学历</td>
				<td>学位</td>
				<td>政治面貌</td>
				<td>加入时间</td>
			</tr>
			<c:forEach items="${jpcs}" var="item" varStatus="status">
				<tr>
					<td>${item.name }</td>
					<td>${item.csrq }</td>
					<td>${item.xzzw }</td>
					<td>${item.flzw }</td>
					<td>${item.xzzwsj }</td>
					<td>${item.flzwsj }</td>
					<td>${item.zj }</td>
					<td>${item.zjsj }</td>
					<td>${item.dj }</td>
					<td>${item.gzsj }</td>
					<td>${item.jysj }</td>
					<td>${item.jg }</td>
					<td>${item.xl }</td>
					<td>${item.xw }</td>
					<td>${item.zzmm }</td>
					<td>${item.jrsj }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>