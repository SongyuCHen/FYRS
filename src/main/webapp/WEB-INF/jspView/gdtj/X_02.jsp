<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  	<title>法院人事 - ${bt}</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <script type="text/javascript" src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
	
	<style type="text/css">
	/*table
	{
		margin-top:20px;
		margin-bottom:5px;
		border:2px solid;
	}*/
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
		<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;徐州中院机关实有在编在岗人员${fypz.syzg }人，法官${fypz.fg }人（其中审委会委员${fypz.fg_swhwy }人，审判员${fypz.fg_spy }人，
				助审员${fypz.fg_zsy }人），书记员${fypz.sjy }人（其中聘任制转委任${fypz.sjy_przzwr }人，聘用书记员${fypz.sjy_pysjy }人，
				政法专项编制书记员${fypz.sjy_zfzxbz }人），执行员${fypz.zxy }人，法官助理${fypz.fgzl }人（事业编），司法警察${fypz.sfjc }人，
				司法鉴定技术人员${fypz.sfjdjsry }人，司法行政人员共${fypz.sfxzry }人。编外书记员${fypz.bwsjy }人。
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${fypz.fg }名法官中，其中院领导${fypz.fg_yld }人，审判业务部门即一线法官${fypz.fg_spywbm }人，综合审判业务部门（研究室、审管办）${fypz.fg_zhspywbm }人，综合部门${fypz.fg_zhbm }人。
		</div>
		<table align="center" style="border-collapse:collapse;margin-top:20px;margin-bottom:50px;">
			<tr>
				<td>部门</td>
				<td>人数</td>
				<td>庭长+副庭长</td>
				<td>审判员、助审</td>
				<td>书记员</td>
				<td>新进人员</td>
				<td>法官助理</td>
				<td>聘用人员</td>
			</tr>
			<c:forEach items="${bmpz}" var="item" varStatus="status">
				<tr>
					<td>${item.bm }</td>
					<td>${item.rs }</td>
					<td>${item.tz+item.ftz }</td>
					<td>${item.spy+item.zs }</td>
					<td>${item.sjy }</td>
					<td>${item.xjry }</td>
					<td>${item.fgzl }</td>
					<td>${item.pyry }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>