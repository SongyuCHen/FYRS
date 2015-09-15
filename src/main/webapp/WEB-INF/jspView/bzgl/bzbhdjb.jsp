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
		margin-top:10px;
		margin-bottom:10px;
		border:2px solid;
	}
	.fu_td
	{
		width:432px;
	}
	td
	{
		border:1px solid;
		text-align:center;
		height:30px;
	}
	.bt
	{
		font-size: 30px;
		font-family:"黑体";
		font-weight:bold;
		text-align: center;
		margin-top: 30px;
		margin-bottom: 10px;
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
		width: 150px;
	}
	/*a:hover, a:focus{
		text-decoration: none;
	}*/
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
  	<div class="bt">${fy}人员编制变化情况登记表</div>
  	<div align="center">
  	<div align="center">
  		本院分管领导签字：
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		<br>（政治部盖章）
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		${fy}
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		同级编制主管部门确认：
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	</div>
  	</div>
  	<table align="center">
  	  <tr>
  	    <td rowspan=2 style="width:30px">级别</td>
  	    <td rowspan=2 colspan=2>编制性质</td>
		<td colspan=3 style="height:45px;width:150px;">日期</td>
		<td rowspan=2 style="width:170px;">变化原因</td>
		<td rowspan=2 style="width:150px;">批准文号</td>
		<td rowspan=2>增编数</td>
		<td rowspan=2>减编数</td>
		<td rowspan=2>控编数</td>
		<td rowspan=2 style="width:150px;">备注</td>
  	  </tr>
	  <tr>
	    <td style="height:45px;width:50px">年</td>
		<td style="height:45px;">月</td>
		<td style="height:45px;">日</td>
	  </tr>
	  <tr>
		<td rowspan=${zy_zfzx.size()+zy_sy.size()+2} style="width:30px">中央编制</td>
		<td rowspan=${zy_zfzx.size()+1} colspan=2>政法专项编制</td>
	<c:forEach items="${zy_zfzx}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${zy_sy.size()+1} colspan=2>事业</td>
	<c:forEach items="${zy_sy}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${sheng_zfzx.size()+sheng_syqe.size()+sheng_syce.size()+sheng_syzczz.size()+sheng_fs.size()+5} style="width:30px">省定编制</td>
		<td rowspan=${sheng_zfzx.size()+1} colspan=2>政法专项编制</td>
	<c:forEach items="${sheng_zfzx}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${sheng_syqe.size()+sheng_syce.size()+sheng_syzczz.size()+3} style="width:40px">事业</td>
		<td rowspan=${sheng_syqe.size()+1} style="width:40px">全额</td>
	<c:forEach items="${sheng_syqe}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${sheng_syce.size()+1} style="width:40px">差额</td>
	<c:forEach items="${sheng_syce}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${sheng_syzczz.size()+1} style="width:40px">自筹自支</td>
	<c:forEach items="${sheng_syzczz}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${sheng_fs.size()+1} colspan=2>附属</td>
	<c:forEach items="${sheng_fs}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${shi_zfzx.size()+shi_syqe.size()+shi_syce.size()+shi_syzczz.size()+shi_fs.size()+5} style="width:30px">市定编制</td>
		<td rowspan=${shi_zfzx.size()+1} colspan=2>政法专项编制</td>
	<c:forEach items="${shi_zfzx}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${shi_syqe.size()+shi_syce.size()+shi_syzczz.size()+3} style="width:40px">事业</td>
		<td rowspan=${shi_syqe.size()+1} style="width:40px">全额</td>
	<c:forEach items="${shi_syqe}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${shi_syce.size()+1} style="width:40px">差额</td>
	<c:forEach items="${shi_syce}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${shi_syzczz.size()+1} style="width:40px">自筹自支</td>
	<c:forEach items="${shi_syzczz}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td rowspan=${shi_fs.size()+1} colspan=2>附属</td>
	<c:forEach items="${shi_fs}" var="item" varStatus="status">
		<td>${item.NYear}</td>
		<td>${item.NMonth}</td>
		<td>${item.NDate}</td>
		<td>${item.CBhyy}</td>
		<c:choose>
			<c:when test="${item.hasWj }"><td><a href="/main/cxtj/downloadWj.aj?id=${item.NId }">${item.CPzwh}</a></td></c:when>
			<c:otherwise><td>${item.CPzwh}</td></c:otherwise>
		</c:choose>
		<td>${item.NZbs}</td>
		<td>${item.NJbs}</td>
		<td>${item.NKbs}</td>
		<td>${item.CBz}</td>
	  </tr>
	  <tr>
	</c:forEach>
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
	  <tr>
		<td colspan=3>合计</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>${sum}</td>
		<td></td>
	  </tr>
	  <tr>
	  	<td colspan=3>备注</td>
	  	<td colspan=9 style="text-align:left;">
	  	<br>
	  	  1、本次法院人员编制情况的登记时间自恢复建院有编制部门文件确定法院人员编制时起，直至目前。<br>
	  	  2、本表“控编数”指人民法院经本级机构编制部门核定的人员编制数。
	  	<br>
	  	<br>
	  	</td>
	  </tr>
  	</table>
  	<br>
  	<br>
  	<div  align="center">
  		附：相关数据填报
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	</div>
  	<table id="fu_table"  align="center">
  		<tr>
  			<td colspan=3 class="fu_td">本级行政区划户籍人口（万）</td>
			<td colspan=3 class="fu_td"></td>
  		</tr>
  		<tr>
  			<td colspan=3 class="fu_td">本级行政区划户籍人口以外的常住人口（万）</td>
			<td colspan=3 class="fu_td"></td>
  		</tr>
  		<tr>
  			<td colspan=3 class="fu_td">本级行政区划地域面积（平方公里）</td>
			<td colspan=3 class="fu_td"></td>
  		</tr>
  		<tr>
			<td colspan=6 style="text-align:left;padding-left:20px;">注："户籍人口以外的常住人口"指经常居住地在本级行政区划内的非户籍人口。</td>
  		</tr>
  	</table>
  	<div align="center" style="margin-bottom:50px;">
  		<br>
  		填表人：
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		填表时间：
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		联系电话：
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	</div>
  	</div>
  </body>
 </html>
	
	