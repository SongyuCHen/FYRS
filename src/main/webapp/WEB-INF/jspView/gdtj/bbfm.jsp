<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>    
    <title>报表封面</title>
    <style type="text/css">
    .fmm
    {
    	font-size: 50px;
    	margin-top: 100px;
    	text-align: center;
    }
    .txnr
    {
    	font-size: 25px;
    	margin-bottom: 25px;
    	text-align: center;
    }
    .fmgz
    {
    	font-size: 30px;
    	font-family: "黑体";
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
		<input type="button" class="button" onclick="window.print();" value="打印"/>
	</div>
	<div id='printdiv'>
  	<div class="fmm">法院系统人事信息报表</div>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<div class='txnr'>数据填报日期:</div>
  	<div class='txnr'>数据截止日期:</div>
  	<div class='txnr'>&nbsp;&nbsp;数据填报人:</div>
  	<div class='txnr'>&nbsp;&nbsp;数据审核人:</div>
  	<div class='txnr'>&nbsp;&nbsp;单位负责人:</div>
  	<div class='txnr'>&nbsp;&nbsp;&nbsp;&nbsp;联系电话:</div>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<div class='fmgz'>某市中级人民法院政治部（处、科）（盖章）</div>
  	</div>
  </body>
</html>
