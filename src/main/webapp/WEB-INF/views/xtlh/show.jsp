<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.flot.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   
    <style type="text/css">
     #recoverTime
     {
       text-align: center;
             padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
		font-size: 110%;
     }
     #setTime{
     	padding: 10px 5px;
     	font-size: 14px;
     	text-align:center;
     }
     #normalDB{
     	padding: 10px 5px;
     }
     #realtime{
     	height: 300px;
     }
      .ui-dialog .ui-dialog-titlebar
      {
         padding: 0.2em 0.5em;
      }
      .nav li{
      	font-size: 18px;
      }
   </style>
   <script type="text/javascript">
     $(function(){
    	 var currentSource;
    	 if($("#recoverTime").data("datasource") == "fyrs")
    		 {
    		   currentSource = true;
    		 }
    	 else
    		 {
    		   currentSource = false;
    		 }
    	 changeDataSourceCommon();
    	 // 表示当前是正常库
    	 var begin ="";
    	 var end = "";
    	 $("#timeEnd").click(function(){
    		   if( begin == "")
    			   {
    			     $("#timeEnd").val("没有数据可以恢复！");   			     		    
    			     return false;
    			   }
    	 });
    	 // 切换数据源
    	 $("#changeDateSource_btn").live("click",function(){
    		 currentSource = !currentSource;
    		 changeDataSourceCommon();
    	 });
    	 function changeDataSourceCommon()
    	 {
    		 if(currentSource)
    			{
    			 $("#changeDateSource_btn").html("<span class='glyphicon glyphicon-briefcase'></span> 启用备份数据库");
    			 	$('#dbTab a[href="#normalDB"]').tab('show');
     			   $("#showTextDataSource").text("当前数据库为正常库");
    			}
    		else
    			{
    			$("#changeDateSource_btn").html("<span class='glyphicon glyphicon-ok'></span> 启用正常库");	
    			$('#dbTab a[href="#backupDB"]').tab('show');
    			  $("#showTextDataSource").text("当前数据库为备份历史库");
    			}
    		 $.ajax({
    			 url:"/main/rslh/beginAndEndTime.aj",
    			 type:"POST",
    			 data:{currentDataSource:currentSource},
    			 dataType:"json",
    			 success:function(json){
    				 begin = json.begin;
    				 end = json.end; 
    				 if(!currentSource)
    					 {
    					 if(begin == "")
            			 {
        				   $("#timeEnd").val("没有数据可以恢复！");
            			   return;
            			 }
        				 else
        					 {
        					   $("#timeEnd").datepicker();
        					   $("#timeEnd").val("点击选择恢复到的时间点！");  					   
        					   $("#timeEnd").datepicker("option","minDate",new Date(begin)).datepicker("option","maxDate",new Date(end)); 	
        					 }
    					 }
    			 }
    		 });
    	 }
    	 
    	 $("#recover_btn").click(function(){
    		 var time = $("#timeEnd").val();
    		 if(time.trim() == "")
    			 {
    			   alert("请选择恢复到的时间点！");
    			   return;
    			 }
    		 if(time.trim() == "没有数据可以恢复！")
    			 {
    			   alert("没有数据可以恢复！");
  			      return; 
    			 }
    		 
    		 $("#wait_dlg").html("").html('<div class="wait_hand_dlg" style="text-align: center;margin-top: 20px;"><img src="/resources/images/loading.gif"/></div>').dialog('open');
    		 $.ajax({
    			 url:"/main/rslh/recover.aj",
    			 type:"POST",
    			 data:{timeEnd:$("#timeEnd").val()},
    			 dataType:"json",
    			 success:function(json){
    				 begin = json.begin;
    				 end = json.end; 
    				 if(begin == undefined)
    					 {
    					   alert("数据恢复失败！");
    					   return;
    					 }
    				 if(begin == "")
        			 {
    				   $("#timeEnd").val("没有数据可以恢复！");
    				   $("#wait_dlg").dialog('close');        			 
        			 }
    				 else
    					 {
    					   $("#timeEnd").die();
    					   $("#timeEnd").datepicker();
    					   $("#timeEnd").val("点击选择恢复到的时间点！");  					   
    					   $("#timeEnd").datepicker("option","minDate",new Date(begin)).datepicker("option","maxDate",new Date(end)); 	
    					   $("#wait_dlg").dialog('close');
    					 }
    			 }
    			 
    		 });
    	 });
    	 //
    	 $('#wait_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 150,
				width : 300,
				title : '系统正在恢复......'
			});
    	 
    	 // 动态数据模拟图
    	 var rdata = [],
         totalPoints = 300;
       function getRandomData() {
           if(rdata.length > 0) rdata = rdata.slice(1);
           while(rdata.length < totalPoints) {
             var prev = rdata.length > 0 ? rdata[rdata.length - 1] : 50;
             var y = prev + Math.random() * 10 - 5;
             if(y < 0) y = 0;
             if(y > 100) y = 100;
             rdata.push(y);
           }
           var res = [];
           for(var i = 0; i < rdata.length; ++i) res.push([i, rdata[i]])
           return res;
         }
       var updateInterval = 1000;
       
       var options = {
         colors: ["#666"],
         series: {
           lines: {
             fill: true,
             fillColor: {
               colors: [{
                 opacity: 0.1
               }, {
                 opacity: 0.5
               }]
             }
           },
           shadowSize: 0
         }, 
         yaxis: {
           min: 0,
           max: 100
         },
         grid: {
           borderColor: '#666',
           borderWidth: 2
         }
       };
       var plot = $.plot($("#realtime"), [getRandomData()], options);

       function update() {
         plot.setData([getRandomData()]);
         plot.draw();
         setTimeout(update, updateInterval);
       }
       update();
   }); // jquery
   </script>
</head>
<body> 
   <div id="recoverTime" class="form-horizontal" data-begin="${begin}" data-end="${end}" data-dataSource="${dataSource}">
   		<div class="row">
	   		<p class="col-sm-4 col-md-4 form-control-static" id="showTextDataSource"></p>
	   		<div class="col-sm-4 col-md-4">
		    	<button type="button" class="btn btn-primary" id="changeDateSource_btn">
					<span class="glyphicon glyphicon-ok"></span> 启用备份数据库
				</button>
			</div>
		</div>
   </div>
  
<ul id="dbTab" class="nav nav-tabs" role="tablist">
	<li>
		<a href="#normalDB" role="tab" data-toggle="tab">
			<span class="glyphicon glyphicon-ok"></span> 正常库
		</a>
	</li>
	<li>
		<a href="#backupDB" role="tab" data-toggle="tab">
			<span class="glyphicon glyphicon-briefcase"></span> 备份库
		</a>
	</li>
</ul>
<div class="tab-content">
  <div class="tab-pane" id="normalDB">
      <div id="realtime"></div>
  </div>
  <div class="tab-pane" id="backupDB">
  	<div id="setTime" class="form-horizontal">
  		<div class="row">
  			<div class="form-group">
		       	<label for="timeEnd" class="col-sm-4 col-md-4 control-label" style="display:inline-block;">系统恢复到时间：</label>
		       	<div class="col-sm-6 col-md-6" style="display:inline-block;">
		       		<input type="text" class="form-control" id="timeEnd" value="">
		       	</div>
		    </div>
       	</div>
       	<div class="row">
       		<div class="col-sm-offset-4 col-md-offset-4 col-sm-6 col-md-6">
		      	<button type="button" class="btn btn-primary" id="recover_btn">
					<span class="glyphicon glyphicon-ok"></span> 确定
				</button>
			</div>
		</div>
	</div>
  </div>
</div>
   <div id="wait_dlg"></div>
</body>
</html>
