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
		<div class="fbt">表一：法官部门分布统计表</div>
		<table align="center">
			<tr>
				<td rowspan=2>单位</td>
				<td rowspan=2>法官总数</td>
				<td rowspan=2>院领导</td>
				<td colspan=6>审执业务部门</td>
				<td rowspan=2>综合审判业务部门</td>
				<td rowspan=2>综合部门</td>
				<td rowspan=2>其他</td>
			</tr>
			<tr>
				<td>刑事</td>
				<td>民事</td>
				<td>行政</td>
				<td>审监</td>
				<td>立案部门</td>
				<td>执行部门</td>
			</tr>
			<c:forEach items="${fgbmfbs}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.zs }</td>
					<td>${item.yld }</td>
					<td>${item.xs }</td>
					<td>${item.ms }</td>
					<td>${item.xz }</td>
					<td>${item.sj }</td>
					<td>${item.la }</td>
					<td>${item.zx }</td>
					<td>${item.zhsp }</td>
					<td>${item.zh }</td>
					<td>${item.qt }</td>
				</tr>
			</c:forEach>
			<tr>
				<td>备注</td>
				<td colspan=11 style="text-align:left;">院领导含正、副院长，专职审委会委员，以及具有法官职务的政治部(处)主任和纪检组长、进班子的院长助理、执行局长、庭长等；
				综合审判业务部门含研究室、审管办、司改办，综合部门含办公室、政治部(处)、机关党委、纪检组监察室、行政装备管理处(科)、技术处、宣传处、法警队、司法鉴定处。</td>
			</tr>
		</table>
		<br>
		<div class="fbt">表二：法官法律职务分布表</div>
		<table align="center">
			<tr>
				<td>单位</td>
				<td>法官总数</td>
				<td>院领导</td>
				<td>庭长</td>
				<td>副庭长</td>
				<td>审判员</td>
				<td>助审员</td>
			</tr>
			<c:forEach items="${fgflzwfbs}" var="item" varStatus="status">
				<tr>
					<td>${item.dw }</td>
					<td>${item.zs }</td>
					<td>${item.yld }</td>
					<td>${item.tz }</td>
					<td>${item.ftz }</td>
					<td>${item.spy }</td>
					<td>${item.zsy }</td>
				</tr>
			</c:forEach>
			<tr>
				<td>备注</td>
				<td colspan=6 style="text-align:left;">院领导含正、副院长，专职审委会委员，以及具有法官职务的政治部(处)主任和纪检组长、
				进班子的院长助理、执行局长、庭长等。执行局长不是院领导的，在“庭长”中填报；执行局副局长及其他内设机构负责人，根据各地编办确定的岗位职级，
				选择在“庭长”或“副庭长”中填报。</td>
			</tr>
		</table>
	</div>
  </body>
</html>