<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
      #gdtj_list
      {
        margin-top: 10px;
      }
      .center
      {
      	text-align: center;
      }
      .tj_btn
      {
      	margin:0 0 0 15px;
      }
      .selectArea{
		display: inline-block;
		width: 160px;
	  }
   </style>
   <script type="text/javascript">
     $(function(){
    	 var html_not_special="";
    	 var html_xu_special="<tr class='xu_special'>"+
								"<td>X_01_1</td>"+
								"<td><a href='X_01_1.do' target='_blank'>中院干警获得表彰奖励情况</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_01_2</td>"+
								"<td><a href='X_01_2.do' target='_blank'>徐州市中级人民法院表彰奖励数据（集体）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_02</td>"+
								"<td><a href='X_02.do' target='_blank'>徐州中院业务部门人员配置基本情况</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_1</td>"+
								"<td><a href='X_03_1.do' target='_blank'>中院花名册（人员总表）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_2</td>"+
								"<td><a href='X_03_2.do' target='_blank'>中院花名册（中院机关人员名单）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_3</td>"+
								"<td><a href='X_03_3.do' target='_blank'>中院花名册（中层干部人员名单）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_4</td>"+
								"<td><a href='X_03_4.do' target='_blank'>中院花名册（人员职级情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_5</td>"+
								"<td><a href='X_03_5.do' target='_blank'>中院花名册（新招录人员情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_6</td>"+
								"<td><a href='X_03_6.do' target='_blank'>中院花名册（法律职务情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_7</td>"+
								"<td><a href='X_03_7.do' target='_blank'>中院花名册（军转干部情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_8</td>"+
								"<td><a href='X_03_8.do' target='_blank'>中院花名册（女干警情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_03_9</td>"+
								"<td><a href='X_03_9.do' target='_blank'>中院花名册（非党员公务员情况）</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_04</td>"+
								"<td><a href='X_04.do' target='_blank'>各部门法官数</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_05</td>"+
								"<td><a href='X_05.do' target='_blank'>聘用人员花名册</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_1</td>"+
								"<td><a href='X_06_1.do' target='_blank'>徐州市法院人员核定编制及实有人数统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_2</td>"+
								"<td><a href='X_06_2.do' target='_blank'>徐州市法院人员统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_3</td>"+
								"<td><a href='X_06_3.do' target='_blank'>徐州市法院法官分布统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_4</td>"+
								"<td><a href='X_06_4.do' target='_blank'>徐州市法院书记员分布统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_5</td>"+
								"<td><a href='X_06_5.do' target='_blank'>徐州市法院在岗法官助理统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_6</td>"+
								"<td><a href='X_06_6.do' target='_blank'>徐州市法官职级分布统计表(含表一、表二、表三)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_7</td>"+
								"<td><a href='X_06_7.do' target='_blank'>徐州市法官结构分布统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_06_8</td>"+
								"<td><a href='X_06_8.do' target='_blank'>徐州市法院领导班子人员情况统计表(表一、表二)</a></td>"+
							 "</tr>"+
							 "<tr class='xu_special'>"+
								"<td>X_07</td>"+
								"<td><a href='X_07.do' target='_blank'>徐州中院 2014干部编制、职级变动台账</a></td>"+
							 "</tr>";
		 var html_head="<table id='dataTable' class='dataTable' cellspacing='0' width='100%'>"+
							"<thead>"+
								"<tr>"+
								"<th width='200px'>统计表编号</th>"+
								"<th>统计表名称</th>"+
								"</tr>"+
							"</thead>"+
						"<tbody>";
		 var html_tail="</tbody></table>";
		 
    	 $.ajax({
    		 url : "/main/cxtj/gdtjlist.aj",
    		 type : 'post',
    		 success : function(data){
    			 var html="";
    			 for(var i=0;i<data.length;i++){
    				 html+= "<tr class='not_special'>"+
    				 		"<td class='center'>"+data[i].tjbbh+"</td>"+
    				 		"<td class='center'><a href='javascript:titleClicked("+data[i].bbh+",&quot;"+data[i].tjbmc+"&quot;);'>"+data[i].tjbmc+"</a></td>"+
    				 		"</tr>";
    			 }
    			 html_not_special=html;
    			 $("#gdtj_list").html(html_head+html_not_special+html_xu_special+html_tail);
    			 initTable("gdtj_list");
    		 }
    	 });
    	 
    	 $("#hang_all").live("click",function(){
    		 $("[name=hangbox]:checkbox").attr("checked",true);
    	 });
    	 $("#hang_none").live("click",function(){
    		 $("[name=hangbox]:checkbox").attr("checked",false);
    	 });
    	 $("#hang_reverse").live("click",function(){
    		 $("[name=hangbox]:checkbox").each(function(){
    			 $(this).attr("checked",!$(this).attr("checked"));
    		 });
    	 });
    	 $("#lie_all").live("click",function(){
    		 $("[name=liebox]:checkbox").attr("checked",true);
    	 });
    	 $("#lie_none").live("click",function(){
    		 $("[name=liebox]:checkbox").attr("checked",false);
    	 });
    	 $("#lie_reverse").live("click",function(){
    		 $("[name=liebox]:checkbox").each(function(){
    			 $(this).attr("checked",!$(this).attr("checked"));
    		 });
    	 });
    	 $("#bgxs").live("change",function(){
    		 var option = $("#bgxs option:selected").attr("value");
    		 if(option==0){
    			 $("#gdtj_list").html(html_head+html_not_special+html_tail);
    			 initTable("gdtj_list");
    		 }else if(option==1){
    			 $("#gdtj_list").html(html_head+html_xu_special+html_tail);
    			 initTable("gdtj_list");
    		 }else{
    			 $("#gdtj_list").html(html_head+html_not_special+html_xu_special+html_tail);
    			 initTable("gdtj_list");
    		 }
    	 });
     }); // jquery
     var initTable = function(dataTableId){
   	  $roles_oTable=$("#"+dataTableId+" .dataTable").dataTable({
 			'bFilter' : false,
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
           'iDisplayLength' : 10,
           'bRetrieve':true,
           'bDestory':true
 		});
     };
     
     function titleClicked(bh,mc){
    	 if(bh==1){
    		 window.open("bbfm.do");
    	 }else{
    		 $.ajax({
    			 url:"/main/cxtj/gdtjtjlist.aj",
    			 type:'post',
    			 data:"bbh="+bh,
    			 success:function(data){
    				 var html="<div><span style='margin:20px 0 0 0; color:blue;'>单位审级：</span>本院信息</div>"+
    					 		"<div id='hang' style='margin:20px 0 0 0; color:blue;'>行可选："+
    				 			"<input id='hang_all' class='tj_btn' type='button' value='全选'>"+
    				 			"<input id='hang_none' class='tj_btn' type='button' value='清空'>"+
    				 			"<input id='hang_reverse' class='tj_btn' type='button' value='反选'></div>";
    				 for(var i=0;i<data[0].length;i++){
    					 html+="<input type='checkbox' checked='checked' name='hangbox' value='"+data[0][i].tjbh+"' style='margin:10px 0 0 20px'>"+data[0][i].tjm;
    				 }
    				 html+="<div id='lie' style='margin: 20px 0 0 0; color:blue;'>列可选："+
    					 	"<input id='lie_all' class='tj_btn' type='button' value='全选'>"+
				 			"<input id='lie_none' class='tj_btn' type='button' value='清空'>"+
				 			"<input id='lie_reverse' class='tj_btn' type='button' value='反选'></div>";
    				 for(var i=0;i<data[1].length;i++){
    					 html+="<input type='checkbox' checked='checked' name='liebox' value='"+data[1][i].tjbh+"' style='margin:10px 0 0 20px'>"+data[1][i].tjm;
    				 }
    				 $("#select_tj").empty();
    				 $("#select_tj").append(html);
    				 $("#select_tj").dialog({
    	    			 modal:true,
    	    			 title:"选择条件 - "+mc,
    	    			 height:400,
    	    			 width:800,
    	    			 buttons:{
    	    				 "开始统计":function(){
    	    					 var hangchecked="";
    	    					 var liechecked="";
    	    					 $("[name=hangbox]:checked").each(function(){
    	    						 if(hangchecked=="")hangchecked=$(this).val();
    	    						 else hangchecked+=","+$(this).val();
    	    					 });
    	    					 $("[name=liebox]:checked").each(function(){
    	    						 if(liechecked=="")liechecked=$(this).val();
    	    						 else liechecked+=","+$(this).val();
    	    					 });
    	    					 if(hangchecked==""||liechecked=="")alert("请至少选一项");
    	    					 //$(this).dialog('close');
    	    					 else{
    	    						 $(this).dialog('close');
    	    						 window.open("dealTj.do?bbh="+bh+"&hang="+hangchecked+"&lie="+liechecked);
    	    					 }
    	    				 },
    	    				 "关 闭":function(){
    	    					 $(this).dialog('close');
    	    				 }
    	    			 }
    	    		 });
    			 }
    		 });
    	 }
     }
   </script>
</head>
<body>
	<div class="selectArea">
		<select id="bgxs" class="input-sm form-control" style="display:inline-block;">
			<option value="10">全部</option>
			<option value="0">仅显示常规统计</option>
			<option value="1">仅显示徐州专有统计</option>
		</select>
	</div>
	<div id="gdtj_list">
		<!-- <table id="dataTable" data-maxindex="" class="dataTable" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="200px">统计表编号</th>
					<th>统计表名称</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table> -->
	</div>
	<div id="select_tj" style="display:none;">
	</div>
</body>
</html>
