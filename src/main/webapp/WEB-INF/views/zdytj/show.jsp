<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
     <script type="text/javascript" src="/resources/js/knockout-1.3.0.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
	<style>
	/***通用样式***/
	#wrapper{
		width: 100%;
	}
	#zdytjTable{
		text-align: center;
		border-spacing: 1px;
	}
	.firstTd{
		font-weight: bold;
		text-align: center;
		width: 150px;
	}
	/***显示样式***/
	@media screen{
		#topConditions{
			margin: 10px;
			padding: 0 5px;
			border-bottom: 1px dashed #96C8EB;
		}
		#topSelect{
			text-align: center;
		}
		#leftSelect{
			text-align: center;
		}
		#leftConditions{
			margin: 10px;
			padding: 0 5px;
		}
		#topOptions{
			max-height: 160px;
			max-width: 800px;
			overflow: auto;
		}
		#leftOptions{
			max-height: 160px;
			max-width: 800px;
			overflow: auto;
		}
		.optionSpan{
			width: 180px;
			display: inline-block;
		}
		#zdytjDiv{
			overflow-x: auto;
		}
		
		#zdytjForm{
			padding: 5px;
			margin-bottom: 15px;
			color: #166092;
			background-color: #EEF7FD;
			border-bottom: 2px solid #96C8EB;
		}
		.firstTd{
			background-color: #3A7A90;
			color: #FFF;
		}
		#buttonGroup{
			text-align: center;
		}
	}
	/***打印样式***/
	@media print{
		.noprint{display : none }
		#zdytjTable{
			font-weight: bold;
			border-collapse: collapse;
            border: none;
		}
		#zdytjTable td
        {
            border: solid #000 1px;
            padding: 0;
            margin: 0;
        }
		#zdytjTable thead th{
			text-align: center;
			color: black;
			font-weight: bold;
		}
	}
   </style>
   <script type="text/javascript">
     $(function(){
    	 function Condition(name, nameInDb, options){
    		 this.name = name;
    		 this.nameInDb = nameInDb;
    		 this.options = options;
    	 }
    	 
    	 function ConditionViewModel(conditions){
    		 this.conditions = conditions || new Array();
    		 this.chosenCondition = ko.observable();
    	 }
    	 $("#zdytjForm").hide();
    	 $("#loadingSpinner").show();
    	 $.ajax({
    		 url:"getInitConditions.do",
    		 type:"post",
    		 success:function(data){
    			 var retArray = new Array();
    			 for(var d in data){
    				 retArray.push(data[d]);
    			 }
    			 ko.applyBindings(new ConditionViewModel(retArray), document.getElementById('topConditions'));
    			 ko.applyBindings(new ConditionViewModel(retArray), document.getElementById('leftConditions'));
    			 rebindUniform();
    			 $(".zdytj-datepicker").live("focus", function(){
    				 $(this).datepicker();
    			 });
    			 $("#zdytjForm").show();
    			 $("#loadingSpinner").hide();//隐藏加载图片
    		 }
    	 });
    	 
    	 $("#zdytjForm").submit(function(){
    		 $("#loadingSpinner").show();
    		 $.ajax({
        		 url:"kstj.aj",
        		 type:"post",
        		 data:$(this).serialize(),
        		 success:function(data){
        			 $("#zdytjTable thead tr").empty();
        			 $("#zdytjTable tbody").empty();
        			 var tableHead = data.tableHead;
        			 for(var i in tableHead){
        				 $("#zdytjTable thead tr").append("<th>"+tableHead[i]+"</th>");
        			 }
        			 var items = data.items;
        			 for(var i in items){
        				 var d = items[i].data;
        				 var tdStr = "";
        				 for(var j in d){
        					if(j==0)
        						tdStr+="<td class='firstTd'>" + d[j] + "</td>";
        					else 
        						tdStr+="<td>" + d[j] + "</td>";
        				 }
        				 var oddOrEven = i % 2 == 0 ? "even" : "odd";
        				 $("#zdytjTable tbody").append("<tr class="+oddOrEven+">"+tdStr+"</tr>");
        			 }
        			 
        			 $("#loadingSpinner").hide();//隐藏加载图片
        			 $("#printBtn").show();//显示打印按钮
        		 }
    		 });
    		 return false;
    	 });
    	 
    	 /*选择按钮*/
   	    $("#checkAllTopBtn").live("click",function () {
   	        $("#topOptions :checkbox").each(function(){
   	        	this.checked = true;
   	        	updateUniform();
   	        });
   	    });
   	    $("#checkNoneTopBtn").live("click",function () {
   	        $("#topOptions :checkbox").each(function(){
   	        	this.checked = false;
   	        	updateUniform();
   	        });
   	    });
   	    $("#checkReverseTopBtn").live("click",function () {
   	        $("#topOptions :checkbox").each(function () {
   	        	this.checked = !this.checked;
   	        	updateUniform();
   	        });
   	    });
   	 	$("#checkAllLeftBtn").live("click",function () {
	        $("#leftOptions :checkbox").each(function(){
	        	this.checked = true;
	        	updateUniform();
	        });
	    });
	    $("#checkNoneLeftBtn").live("click",function () {
	        $("#leftOptions :checkbox").each(function(){
	        	this.checked = false;
	        	updateUniform();
	        });
	    });
	    $("#checkReverseLeftBtn").live("click",function () {
	        $("#leftOptions :checkbox").each(function () {
	        	this.checked = !this.checked;
	        	updateUniform();
	        });
	    });
	    
	    $(".delDateSpanBtn").live("click",function(){
	    	$(this).parent().parent().remove();
	    });
	    $(".addDateSpanBtn").live("click",function(){
	    	var nameInDb = $(this).attr("name");
	    	var spanContent = "<div class='row form-group'>"+
	    	"<div class='col-sm-8 col-md-9'>" +
	    		"<div class='input-group'>" +
					"<input type='text' class='input-sm form-control zdytj-datepicker datepicker' name='"+nameInDb+"' />" +
					"<span class='input-group-addon'>至</span>" +
					"<input type='text' class='input-sm form-control zdytj-datepicker datepicker' name='"+nameInDb+"' />" +
				"</div>" +
			"</div>" +
			"<div class='col-sm-4 col-md-3'>" +
				"<input type='button' class='btn btn-sm btn-danger delDateSpanBtn' value='删除时间段' />" +
			"</div></div>";
			$(this).parent().parent().parent().append(spanContent);
	    });
	    
	    /*打印表格*/
	    $("#printBtn").live("click",function(){
	    	window.print();
	    });
	    
	    /*重新绑定uniform样式 */
	    $(".uniform-select").live("change",function(){
	    	rebindUniform();
	    });
	    
     });
   </script>
</head>
<body>
	<div id="wrapper">
		<form id="zdytjForm" class="noprint form-horizontal" action="kstj.do" method="post">
			<fieldset>
				<h3>统计选项</h3>
			<div>
				<div id="topConditions">
					<div id="topSelect" class="row form-group">
						<label class="control-label" style="display:inline-block;width:100px;height:24px;text-align:center;">上标题选项：</label>
						<div style="display:inline-block;width:250px;height:30px;">
							<select class="input-sm form-control uniform-select" data-bind="options: conditions,
											optionsCaption: '选择一个查询条件',
										   optionsText: 'name',
										   value: chosenCondition" style="display:inline-block;"></select>
						</div>
					</div>
					<div id="topOptions" class="zdytjOptions" data-bind="with: chosenCondition">
						<!-- ko if: isDatetime -->
						<div class="row form-group">
							<div class="col-sm-4 col-md-4">
								<input type="button" data-bind="attr: {name: 'top-'+$data.nameInDb}" class="btn btn-sm btn-primary addDateSpanBtn" value="添加时间段" />
							</div>
						</div>
						<div class="row form-group">
							<div class="col-sm-8 col-md-9">
								<div class="input-group">
									<input type="text" class="input-sm form-control zdytj-datepicker datepicker" data-bind="attr: {name: 'top-'+$data.nameInDb}" />
									<span class="input-group-addon">至</span>
									<input type="text" class="input-sm form-control zdytj-datepicker datepicker" data-bind="attr: {name: 'top-'+$data.nameInDb}" />
								</div>
							</div>
							<div class="col-sm-4 col-md-3">	
								<input type="button" class="btn btn-sm btn-danger delDateSpanBtn" value="删除时间段" />
							</div>
						</div>
						<!-- /ko -->
						<!-- ko if: !isDatetime && hasMaincode -->
							<div class="btn-group">
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkAllTopBtn" value="全选" />
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkNoneTopBtn" value="全不选" />
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkReverseTopBtn" value="反选" />
							</div>
							<div data-bind="foreach: options">
								<span class="optionSpan">
									<input type="checkbox" data-bind="attr: {id: 'top-'+$parent.nameInDb+'-'+$data.optionId, name: 'top-'+$parent.nameInDb, value: $data.optionId, checked: 'checked'}" />
									<label data-bind="attr: {for: 'top-'+$parent.nameInDb+'-'+$data.optionId}, text: $data.name"></label>
								</span>
							</div>
						<!-- /ko -->
						<!-- ko if: !isDatetime && !hasMaincode -->
							<div class="row form-group">
								<label class="col-sm-4 col-md-4 control-label">输入值：</label>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="input-sm form-control" data-bind="attr: {name: 'top-'+$data.nameInDb}"/>
								</div>
							</div>
						<!-- /ko -->
					</div>
				</div>
				<div id="leftConditions">
					<div id="leftSelect" class="row form-group">
						<label class="control-label" style="display:inline-block;width:100px;height:24px;text-align:center;">左标题选项：</label>
						<div style="display:inline-block;width:250px;height:30px;">
							<select class="input-sm form-control uniform-select" data-bind="options: conditions,
											optionsCaption: '选择一个查询条件',
										   optionsText: 'name',
										   value: chosenCondition" style="display:inline-block;"></select>
						</div>
					</div>
					<div id="leftOptions" class="zdytjOptions" data-bind="with: chosenCondition">
						<!-- ko if: isDatetime -->
						<div class="row form-group">
							<div class="col-sm-4 col-md-4">
								<input type="button" data-bind="attr: {name: 'left-'+$data.nameInDb}" class="btn btn-sm btn-primary addDateSpanBtn" value="添加时间段" />
							</div>
						</div>
						<div class="row form-group">
							<div class="col-sm-8 col-md-9">
								<div class="input-group">
									<input type="text" class="input-sm form-control zdytj-datepicker datepicker" data-bind="attr: {name: 'left-'+$data.nameInDb}" />
									<span class="input-group-addon">至</span>
									<input type="text" class="input-sm form-control zdytj-datepicker datepicker" data-bind="attr: {name: 'left-'+$data.nameInDb}" />
								</div>
							</div>
							<div class="col-sm-4 col-md-3">	
								<input type="button" class="btn btn-sm btn-danger delDateSpanBtn" value="删除时间段" />
							</div>
						</div>
						<!-- /ko -->
						<!-- ko if: !isDatetime && hasMaincode -->
							<div class="btn-group">
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkAllLeftBtn" value="全选" />							
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkNoneLeftBtn" value="全不选" />
								<input type="button" class="btn btn-sm btn-default" href="javascript:void(0);" id="checkReverseLeftBtn" value="反选" />
							</div>
							<div data-bind="foreach: options">
								<span class="optionSpan">
									<input type="checkbox" data-bind="attr: {id: 'left-'+$parent.nameInDb+'-'+$data.optionId, name: 'left-'+$parent.nameInDb, value: $data.optionId, checked: 'checked'}" />
									<label data-bind="attr: {for: 'left-'+$parent.nameInDb+'-'+$data.optionId}, text: $data.name"></label>
								</span>
							</div>
						<!-- /ko -->
						<!-- ko if: !isDatetime && !hasMaincode -->
							<div class="row form-group">
								<label class="col-sm-4 col-md-4 control-label">输入值：</label>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="input-sm form-control" data-bind="attr: {name: 'left-'+$data.nameInDb}"/>
								</div>
							</div>
						<!-- /ko -->
					</div>
				</div>
			</div>
			<div id="buttonGroup">
				<button type="submit" class="btn btn-sm btn-primary" id="kstjBtn">
					<span class="glyphicon glyphicon-list-alt"></span> 开始统计
				</button>
				<button type="button" class="noprint btn btn-sm btn-success" id="printBtn" style="display:none;">
					<span class="glyphicon glyphicon-print"></span> 打印表格
				</button>
			</div>
			</fieldset>
		</form>
	
		<img src="/resources/images/loading.gif" id="loadingSpinner" style="display:none;" />
		<div id="zdytjDiv">
			<table id="zdytjTable" class="dataTable" cellspacing="0" style="width:100%;">
				<thead>
					<tr class="tableHead">
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
