<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
     <link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
    #jdcx_head{
    	padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
	}
     #jdcx_head div
      {
        margin-top: 10px;
        margin-bottom:10px;
      }
   
      
      #jdcx_head span select
      {
        width:150px;
      }
      
      #jdcx_head span.off1word{
      	padding-left:28px;
      }
      #jdcx_head span.off2word{
      	padding-left:40px;
      }
      #jdcx_find
      {
      }
       #line_branch
      {
        padding: 5px;
      }
      #jdcx_middle #jdcx_btn_count
      {
         margin-left: 30px;
      }
      #jdcx_middle{
      	text-align: right;
      }
      #jdcx_list
      {
        margin-top: 10px;
      }
      #dataTable_filter
      {
        display:none;
      }
        .ui-button-text-only .ui-button-text
      {
         padding: 0em 0em;
      }
      .ui-dialog .ui-dialog-titlebar
      {
         padding: 0.2em 0.5em;
      }
   </style>
   <script type="text/javascript">
     $(function(){
    	 initTable("jdcx_list");
    	 // find
    	 $("#jdcx_btn_find").live("click",function(){
    		 var i = 0;
    		 var jsonStr = '{';
    		 $("#jdcx_head select option:selected").each(function(){
    			 if($(this).val() == -1)
    				 {
    				   i++; 
    				 }
    			 
    			 jsonStr += '"'+$(this).parent().attr("name")+'"'+':'+'"'+$(this).val()+'"'+',';
    		 });
    		 if(i == 8)
    			 {
    			   alert("请至少选择一个查询条件！");
    		       return;
    			 }
    	     showLoading();
    		 // 把搜索框清空
    		 $("#searchFun input").val("");
    		 jsonStr = jsonStr.substring(0,jsonStr.length -1);
    		 jsonStr += '}';
    		 var json = JSON.parse(jsonStr);
    		 $.ajax({
    			 url:"/main/cxtj/jdcxFind.aj",
    			 type:"POST",
    			 dataType:"json",
    			 data:json,
    			 success:function(json){
    				var html = '<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="70px">序号</th><th width="80px">姓名</th><th width="40px">性别</th><th>工作单位</th><th width="200px">部门</th><th width="100px">行政职务</th><th width="80px">操作</th></tr></thead><tbody>';
    				 for(var i = 0; i < json.length; i++)
					  {
					    var jdcx = json[i];
					    html += "<tr>";
					    html += '<td class="center">'+(i+1)+'</td>';
					    html += '<td class="center">'+jdcx.CXm+'</td>';
					    html += '<td class="center">'+jdcx.xb+'</td>';
					    html += '<td class="center">'+jdcx.dwmc+'</td>';
					    html += '<td class="center">'+jdcx.bmMc+'</td>';
					    html += '<td class="center">'+jdcx.xzzwMc+'</td>'; 
					    if(jdcx.isOnlyLook)
					    	{
					    	  html += '<td class="center"  data-showKey="'+jdcx.showKey+'" data-isOnlyLook="'+jdcx.isOnlyLookEncode+'" data-fyDm="'+jdcx.NFy+'" data-rybh="'+jdcx.NRybh+'"><a class="i_ck" data-btnType="2" href="javascript:void(0)">查看</a></td>';
					    	}
					    else
					    	{
					    	 html += '<td class="center"  data-showKey="'+jdcx.showKey+'"  data-isOnlyLook="'+jdcx.isOnlyLookEncode+'" data-fyDm="'+jdcx.NFy+'" data-rybh="'+jdcx.NRybh+'"><a class="i_ck" data-btnType="2" href="javascript:void(0)">查看</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a></td>';
					    	}
					   
					    html += "</tr>";											    
					  }
				  html += '</tbody></table>';
				  $("#jdcx_list  #dataTable_wrapper").remove();
				  $("#jdcx_list").append(html);
				  initTable("jdcx_list");
				  hiddenLoading();
    			 }
    		 });
    	 }); // find
    	// reset
    	 $("#jdcx_btn_reset").live("click",function(){
    		 $("#jdcx_head select").each(function(){
    			 $(this).children(":first").attr("selected","selected");
    		 });
    	 }); // reset
    		/*active选中的dataTable中的行*/
 		function activeSelectTr($node){
 			// 它只是简单地添加一个  class 作为标识，表示选中一行，也就是在 <tr> 添加  class 属性
 			$node.parent().parent().addClass("active");
 		}
 		/*清除dataTable中选中行的active类*/
 		function removeSelectTrActive(id){
 			// 当窗口关闭时，把添加的  class 属性进行删除
 			$("#"+id+"_list #dataTable tbody .active").removeClass("active");
 		}
 		/*删除选中的dataTable中的行*/
 		function removeSelectTr($oTableLocal){
 			$oTableLocal.fnDeleteRow($oTableLocal.$("tr.active")[0]);
 		}
    	// 查看
    	$(".i_ck").live('click',function(){
    	    var showKey = $(this).parent().data("showkey");
    	    var isOnlyLook = $(this).parent().data("isonlylook");
    	    window.open("/ryjbxx.do?showKey="+showKey+"&isOnlyLook="+isOnlyLook);
    	});
    	// 删除
    	$(".i_delete").live('click',function(){
    		var fydm = $(this).parent().data("fydm");
      	    var rybh = $(this).parent().data("rybh");
    		activeSelectTr($(this));
    		  var temp = $(this);
    		  $(".ex_dlg").html('<p>确定要删除？删除后不能恢复</p>').dialog({
					'close':function(){
					},
					'buttons':{
						"确定":function(){
							 $.ajax({
				    			  url:"/main/cxtj/jdcxDelete.aj",
									type:"post",
									dataType:"html",
									data:{
										fydm:fydm,rybh:rybh
									},
									success:function(html){								   
										if(html.match(/^success$/))
											{
											removeSelectTr($roles_oTable);
											$(".ex_dlg").dialog("close");
											}
										else if(html.match(/^fail$/))
											{
											  alert("执行不成功，请重新执行");
											  $(".ex_dlg").dialog("close");
											}
										else if(html.match(/^deleteSelf$/))
										{
										      alert("不能删除自己!");
											  $(".ex_dlg").dialog("close");
										}
										else
										{
										    alert("系统错误，请联系管理员!");
											$(".ex_dlg").dialog("close");
										}
									}
				    		  }); // ajax
						},
						"取消":function(){
							$(this).dialog("close");
						}
					}
				}).dialog("open");
    		
    	});
    	// 搜索
    	$("#searchFun input").keyup(function(){
    	     $roles_oTable.fnFilter($(this).val());
    	});
    	
        //  导出事件
        $("#jdcx_btn_export").live('click',function(){
        	var dataIn = "(";
        	var dataStr = "";
        	var space = [""," ","  ","   ","    "];
        	
        	 $roles_oTable.$('tr', {"filter": "applied"}).each(function(){
        		dataStr +="'";
        		var fydm =  $(this).children("td[data-fydm]").data('fydm');
        		var fydmStr = "";
        		fydmStr += fydm;
         		dataStr += fydm;
         		dataStr += space[5 - fydmStr.length]; 
         		dataStr += $(this).children("td[data-fydm]").data("rybh");
         		dataStr +="',";
      	   });
        	dataStr = dataStr.substring(0,dataStr.length-1);
        	dataIn += dataStr;
        	dataIn += ")";
        	if(dataIn == "()")
        		{
        		   alert("请选择人员再导出！");
            	   return;
        		}
        	
        	window.location.href="/main/cxtj/jdcxExport.aj?inString="+dataIn;
        	
        });
        // 打印
        $("#jdcx_btn_print").live('click',function(){
        	if($("#dataTable tbody td[data-fydm]").length == 0)
        		{
        		  alert("请选择人员再打印！");
            	  return;
        		}
        	
        	var html = '<table  border="1" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="80px">姓名</th><th width="40px">性别</th><th>工作单位</th><th width="200px">部门</th><th width="100px">行政职务</th></tr></thead><tbody>';
        	$roles_oTable.$('tr', {"filter": "applied"}).each(function(){
        		var data = $roles_oTable.fnGetData( this );
        		var result = data + "";
        		var dataS = result.split(",");
        		html += '<tr style="text-align: center;">';
 			    html += '<td width="80px">'+dataS[1]+'</td>';
 			    html += '<td width="40px">'+dataS[2]+'</td>';
 			    html += '<td>'+dataS[3]+'</td>';
 			    html += '<td width="200px">'+dataS[4]+'</td>';
 			    html += '<td width="100px">'+dataS[5]+'</td>';
 			    html += "</tr>";	
        	});
		  html += '</tbody></table>';
		  myPrint(html,"titlechaged");
        });
     }); // jquery
     var initTable = function(dataTableId){
   	  $roles_oTable=$("#"+dataTableId+" #dataTable").dataTable({
   		   "sPaginationType" : "full_numbers", 
   		   "sScrollX" : "100%", // 横向滚动条
		   "sScrollY" : "200px",
   		   'bFilter' : true,
           'bSort' : false,
           'bLengthChange' : false,
 			'oLanguage' : {
 				"sProcessing" : "处理中...",
 				"sLengthMenu" : "显示 _MENU_ 项结果",
 				"sZeroRecords" : "没有匹配结果",
 				"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
 				"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
 				"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
 				"sInfoPostFix" : "",
 				"sSearch" : "搜索:",
 				"sUrl" : "",
 				"oPaginate" : {
 					"sFirst" : "首页",
 					"sPrevious" : "上页",
 					"sNext" : "下页",
 					"sLast" : "末页"
 				}
 			},
 			'bSortClasses' : false,
           'iDisplayLength' : 6,
           'bRetrieve':true,
           'bDestory':true
 		});
     };
     function myPrint(input,title){

    		var headobj = document.getElementsByTagName("head").item(0);
    		var headHtml = headobj.outerHTML;
    		var reg = new RegExp("<title>.*</title>","g");
    		headHtml = headHtml.replace(reg,"<title>"+title+"</title>");
    		printFrame = document.getElementById("lldxi_printRegionFrame_2012_0112");
    		if(printFrame!=null)
    		{document.body.removeChild(printFrame);}

    		printFrame = document.createElement("iframe");
    		printFrame.setAttribute("src", "about:blank");
    		printFrame.setAttribute("id", "lldxi_printRegionFrame_2012_0112");
    		printFrame.setAttribute("marginheight", 0);
    		printFrame.setAttribute("marginwidth", 0);
    		printFrame.style.display = "none";
    		document.body.appendChild(printFrame);
    		
    		if(navigator.userAgent.indexOf("MSIE")>0){
    			var htmlobj = printFrame.contentWindow.document.createElement("html");
    			var bodyobj = printFrame.contentWindow.document.createElement("body");
    			bodyobj.innerHTML = input;
    			htmlobj.appendChild(headobj.cloneNode(true));
    			htmlobj.appendChild(bodyobj);
    			printFrame.contentWindow.document.appendChild(htmlobj);
    			printFrame.contentWindow.document.execCommand("Print",true);
//    			b.document.getElementById("print").execWB(7,1);
    		}

    		if(navigator.userAgent.indexOf("Chrome")>0){
    			htmlstr = "<html>" + headHtml + "<body>" + input+"<\/body>"+"<\/html>";
    			printFrame.contentWindow.document.write(htmlstr);
//    			printFrame.contentWindow.document.title = title;
    			printFrame.contentWindow.print();
    		}
    	};
   </script>
</head>
<body>
    <div id="jdcx_head">
    	<div class="row">
    		<span class="col-md-4">法律职务&nbsp;&nbsp;
    			<select name="flzw">
     				<option value="-1"></option>
      					<c:forEach items="${flzws}" var="flzw">
         					<option value="${flzw.NDm}">${flzw.CMc}</option>
      					</c:forEach>
      			</select>
      		</span>
      		<span class="col-md-4 off2word">部门&nbsp;&nbsp;
    			<select name="bm">
     				<option value="-1"></option>
        				<c:forEach items="${bms}" var="bm">
         					<option value="${bm.NDm}">${bm.CMc}</option>
      					</c:forEach>
    			</select>
    		</span>    			
    		<span class="col-md-4">职务类别&nbsp;&nbsp;
    			<select name="zwlb">
     				<option value="-1"></option>
       					<c:forEach items="${zwlbs}" var="zwlb">
         					<option value="${zwlb.NDm}">${zwlb.CMc}</option>
      					</c:forEach>
    			</select>
    		</span>
    	</div>
    	<div class="row">
    		<span class="col-md-4 off2word">专业&nbsp;&nbsp;
    			<select name="zy">
     				<option value="-1"></option>
        			<c:forEach items="${zys}" var="zy">
         				<option value="${zy.NDm}">${zy.CMc}</option>
      				</c:forEach>
    			</select>
    		</span>
    		<span class="col-md-4 off2word">职级&nbsp;&nbsp;
    			<select name="zj">
     				<option value="-1"></option>
       				<c:forEach items="${zjs}" var="zj">
         				<option value="${zj.NDm}">${zj.CMc}</option>
      				</c:forEach>
    			</select>
    		</span>
    		<span class="col-md-4 off2word">等级&nbsp;&nbsp;
    			<select name="dj">
     				<option value="-1"></option>
       				<c:forEach items="${djs}" var="dj">
         				<option value="${dj.NDm}">${dj.CMc}</option>
      				</c:forEach>
    			</select>
    		</span>
    	</div>
    	<div class="row">
    		<span class="col-md-4 off2word">学历&nbsp;&nbsp;
    			<select name="xl">
     				<option value="-1"></option>
        			<c:forEach items="${xls}" var="xl">
         				<option value="${xl.NDm}">${xl.CMc}</option>
      				</c:forEach>
    			</select>
    		</span>
    		<span class="col-md-4 off1word">人员库&nbsp;&nbsp;
    			<select name="ryk">
       				<c:forEach items="${ryks}" var="ryk">
         				<option value="${ryk.NDm}">${ryk.CMc}</option>
      				</c:forEach>
    			</select>
    		</span>
    	</div>
    	<div class="row">
    		<span class="col-md-10"></span>
    		<span class="col-md-2 btn-group"  id="jdcx_find">
    			<button type="button" class="btn btn-primary" id="jdcx_btn_find">
       				<span class="glyphicon glyphicon-search"></span> 查询
       			</button>
       			<button type="button" class="btn btn-success" id="jdcx_btn_reset">
       				<span class="glyphicon glyphicon-refresh"></span> 重置
       			</button>
    		</span>
    	</div>
    </div> 
    
	<div id="jdcx_middle">
	   <span id="searchFun">搜索:<input type="text" name="" ></span>
	   <div class="btn-group">
		   <button type="button" class="btn btn-primary" id="jdcx_btn_print">
		   		<span class="glyphicon glyphicon-print"></span> 打印
		   </button>
		   <button type="button" class="btn btn-primary" id="jdcx_btn_export">
		   		<span class="glyphicon glyphicon-download-alt"></span> 导出
		   </button>
		</div>
	</div>
	<div id="jdcx_list">
	    <div id="loading" class="element-display-none"><img src='/resources/images/loading.gif'/></div>
		<table id="dataTable" data-maxindex="${roles.size()}" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th width="70px">序号</th>
					<th width="80px">姓名</th>
					<th width="40px">性别</th>
					<th>工作单位</th>
					<th width="120px">部门</th>
					<th width="80px">行政职务</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
	
	<div class="ex_dlg"></div>
</body>
</html>
