<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<title>法院人员编制变化情况登记表</title>
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
		width:35px;
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
	</script>
  </head>
  <body>
  	<div>
  		<input type="button" class="button" onclick="exportToWord('printdiv');" value="导出Word"/>
  	</div>
  	<div  id="printdiv">
  	<div class="bt">核定编制及人员结构登记表</div><br><br>
  	<table align="center">
  		<tr>
  			<td colspan=3>核定时间</td>
  			<td rowspan=4 style="width:100px;">核定文号</td>
  			<td colspan=5>核定人员编制数</td>
  			<td colspan=15>核定人员结构情况</td>
  			<td rowspan=4 style="width:60px;">经办人签章</td>
  			<td rowspan=4 style="width:60px;">审核人签章</td>
  		</tr>
  		<tr>
  			<td rowspan=3 style="width:50px;">年</td>
  			<td rowspan=3 style="width:30px;">月</td>
  			<td rowspan=3 style="width:30px;">日</td>
  			<td rowspan=3>合计</td>
  			<td colspan=4>其中</td>
  			<td colspan=4>部门领导职数</td>
  			<td colspan=6>内设机构领导职数</td>
  			<td colspan=4>非领导职数</td>
  			<td rowspan=3>科员及办事员</td>
  		</tr>
  		<tr>
  			<td rowspan=2>行政编制</td>
  			<td rowspan=2>省定编制</td>
  			<td colspan=2>附属编制</td>
  			<td rowspan=2>正职</td>
  			<td rowspan=2>副职</td>
  			<td colspan=2>其他</td>
  			<td colspan=2>内设机构正职</td>
  			<td colspan=2>内设机构副职</td>
  			<td colspan=2>其他</td>
  			<td rowspan=2>调研员</td>
  			<td rowspan=2>副调研员</td>
  			<td rowspan=2>主任科员</td>
  			<td rowspan=2>副主任科员</td>
  		</tr>
  		<tr>
  			<td>后勤服务人员编制</td>
  			<td>老干部服务人员编制</td>
  			<td>核定数</td>
  			<td style="width:90px;">明细内容</td>
  			<td>副处级</td>
  			<td>正科级</td>
  			<td>正科级</td>
  			<td>副科级</td>
  			<td>核定数</td>
  			<td style="width:90px;">明细内容</td>
  		</tr>
  		<c:forEach items="${bzjg}" var="item" varStatus="status">
  		<tr>
  			<td>${item.NYear }</td>
  			<td style="width:30px;">${item.NMonth }</td>
  			<td style="width:30px;">${item.NDate }</td>
  			<c:choose>
				<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CHdwh}</a></td></c:when>
				<c:otherwise><td>${item.CHdwh}</td></c:otherwise>
			</c:choose>
  			<td>${item.NHj }</td>
  			<td>${item.NXzbz }</td>
  			<td>${item.NSdbz }</td>
  			<td></td>
  			<td></td>
  			<td>${item.NZyZfzxbzBmldZz }</td>
  			<td>${item.NZyZfzxbzBmldFz }</td>
  			<td>${item.NZyZfzxbzBmldQt }</td>
  			<td>${item.CZyZfzxbzBmldQtMx }</td>
  			<td>${item.NZyZfzxbzNsjgldZzFc }</td>
  			<td>${item.NZyZfzxbzNsjgldZzZk }</td>
  			<td>${item.NZyZfzxbzNsjgldFzZk }</td>
  			<td>${item.NZyZfzxbzNsjgldFzFk }</td>
  			<td>${item.NZyZfzxbzNsjgldQt }</td>
  			<td>${item.CZyZfzxbzNsjgldQtMx }</td>
  			<td>${item.NZyZfzxbzDyy }</td>
  			<td>${item.NZyZfzxbzFdyy }</td>
  			<td>${item.NZyZfzxbzZrky }</td>
  			<td>${item.NZyZfzxbzFzrky }</td>
  			<td>${item.NZyZfzxbzKybsy }</td>
  			<td></td>
  			<td></td>
  		</tr>
  		</c:forEach>
  		<tr>
  			<td></td>
  			<td style="width:30px;"></td>
  			<td style="width:30px;"></td>
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