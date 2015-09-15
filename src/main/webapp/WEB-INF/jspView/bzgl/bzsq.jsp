<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
	<script type="text/javascript">
	function add_ry(){
		var xm = $("#add_xm").val();
		if(xm==""){
			alert("姓名不能为空！");
			return;
		}
		var xb = $("#add_xb option:selected").attr("value");
		var csny = $("#add_csny").val();
		var xl = $("#add_xl").val();
		var xzw = $("#add_xzw").val();
		var dzw = $("#add_dzw").val();
		$("#blank_tr").before("<tr>"+
						  	  	"<td>"+xm+"</td>"+
						  	  	"<td>"+xb+"</td>"+
						  	  	"<td>"+csny+"</td>"+
						  	  	"<td>"+xl+"</td>"+
						  	  	"<td colspan=4>"+xzw+"</td>"+
						  	  	"<td colspan=4>"+dzw+"</td>"+
						  	  "</tr>");
		$("#add_bzxx").dialog("close");
		$("#add_xm").val("");
		$("#add_xb").val("男");
		$("#add_csny").val("");
		$("#add_xl").val("");
		$("#add_xzw").val("");
		$("#add_dzw").val("");
		var rowspan=parseInt($("#nsybzryxx").attr("rowspan"))+1;
		$("#nsybzryxx").attr("rowspan", rowspan);
		rowspan=parseInt($("#sqqk").attr("rowspan"))+1;
		$("#sqqk").attr("rowspan", rowspan);
	}
	
	function addBzxx(){
		$("#add_bzxx").dialog({
			modal:true,
			title:"新增人员信息",
			height:430,
			width:450
		});
	}
	
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
  		<input type="button" class="button" onclick="addBzxx();" value="新增人员信息"/>
  	</div>
  	<div  id="printdiv">
  	<div class="bt">公务员法管理单位编制使用申请表</div><br><br>
  	<table align="center">
  	  <tr>
  	    <td colspan=2 style="height:60px;">申请使用编制单位</td>
  	    <td colspan=6 style="height:60px;">${fy}</td>
  	    <td colspan=2 style="height:60px;">主管部门</td>
  	    <td colspan=4 style="height:60px;"></td>
  	  </tr>
  	  <tr>
  	  	<td id="sqqk" rowspan=9 style="width:30px;">申请情况</td>
  	  	<td rowspan=2>项目</td>
  	  	<td rowspan=2 style="width:80px;">行政编制</td>
  	  	<td rowspan=2>参照编制</td>
  	  	<td colspan=3>单位领导职数</td>
  	  	<td colspan=4>内设机构领导职数</td>
  	  	<td colspan=2>非领导职数</td>
  	  	<td rowspan=2 style="width:70px;">其他项说明</td>
  	  </tr>
  	  <tr>
  	  	<td style="width:80px;">正职</td>
  	  	<td style="width:80px;">副职</td>
  	  	<td>其他</td>
  	  	<td>副处</td>
  	  	<td>正科</td>
  	  	<td>副科</td>
  	  	<td>其他</td>
  	  	<td>主任科员</td>
  	  	<td>副主任科员</td>
  	  </tr>
  	  <tr>
  	  	<td>核定编制</td>
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
  	  <tr>
  	  	<td>实有人员</td>
  	  	<td></td>
  	  	<td></td>
  	  	<td>${syry[0]}</td>
  	  	<td>${syry[1]}</td>
  	  	<td>${syry[2]}</td>
  	  	<td>${syry[3]}</td>
  	  	<td>${syry[4]}</td>
  	  	<td>${syry[5]}</td>
  	  	<td>${syry[6]}</td>
  	  	<td>${syry[7]}</td>
  	  	<td>${syry[8]}</td>
  	  	<td></td>
  	  </tr>
  	  <tr>
  	  	<td>申请使用</td>
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
  	  <tr>
  	  	<td style="height:100px;">申请理由</td>
  	  	<td style="height:100px;" colspan=12></td>
  	  </tr>
  	  <tr>
  	  	<td>编制使用类型</td>
  	  	<td colspan=12 style="text-align:left;padding-left:15px;">
  	  	  公开招聘(选调)<input type="checkbox" name="sylx" value="" style=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	  	  调动<input type="checkbox" name="sylx" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	  	  政策性安置<input type="checkbox" name="sylx" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	  	  其他<input type="checkbox" name="sylx" value=""/>
  	  	</td>
  	  </tr>
  	  <tr>
  	  	<td id="nsybzryxx" rowspan=2>拟使用编制人员信息</td>
  	  	<td>姓名</td>
  	  	<td>性别</td>
  	  	<td>出生年月</td>
  	  	<td>学历</td>
  	  	<td colspan=4>先工作单位及职务</td>
  	  	<td colspan=4>调入单位及职务</td>
  	  </tr>
  	  <tr id="blank_tr">
  	  	<td></td>
  	  	<td></td>
  	  	<td></td>
  	  	<td></td>
  	  	<td colspan=4></td>
  	  	<td colspan=4></td>
  	  </tr>
  	  <tr>
  	  	<td colspan=2 style="height:200px;">申请单位意见</td>
  	  	<td colspan=4 style="height:200px;">
  	  	  <br><br><br>
  	  	  <div style="font-size:25px;">同&nbsp;&nbsp;&nbsp;&nbsp;意
  	  	  </div>
  	  	  <br><br>
  	  	  <div style="text-align:right;">
  	  	  	年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;
  	  	  	<br>(盖章)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	  	  </div>
  	  	</td>
  	  	<td colspan=3 style="height:200px;">主管部门意见</td>
  	  	<td colspan=5 style="height:200px;text-align:right;">
  	  	<br><br><br><br><br><br>
  	  	年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;
  	  	<br>(盖章)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	  	</td>
  	  </tr>
  	</table>
  	<div align="center">
  	<div style="width:700px;">
  	&nbsp;&nbsp;&nbsp;&nbsp;说明：1、“其他项说明”填写内容为：纪委书记、纪检组长、工会主席、机关党委专职副书记或监察室
  	主任；2、因军转安置或毕业分配使用编制，现工作单位填写部队或学校名称；3、人员名单填写不够可另附表格。
  	</div>
  	<br>
  	<br>
  	<br>
  	</div>
  	</div>
  	<div id="add_bzxx" style="display:none;font-size:12px;">
  		<div class="form-group">
			<label class="controllabel">姓名：</label>
			<div style="display:inline-block;width:150px;">
				<input id="add_xm" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel">性别：</label>
			<div class="selectArea">
				<select id="add_xb" class="input-sm form-control" style="display:inline-block;">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel">出生年月：</label>
			<div style="display:inline-block;width:150px;">
				<input id="add_csny" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel">学历：</label>
			<div style="display:inline-block;width:200px;">
				<input id="add_xl" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel">现工作单位及职务：</label>
			<div style="display:inline-block;width:300px;">
				<input id="add_xzw" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel">调入单位及职务：</label>
			<div style="display:inline-block;width:300px;">
				<input id="add_dzw" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div style="text-align:center;">
			<input type="button" class="button" onclick="add_ry();" value="保存"/>
			<input type="button" class="button" onclick="$('#add_bzxx').dialog('close');" value="关闭"/>
		</div>
  	</div>
  </body>
 </html>
	
	