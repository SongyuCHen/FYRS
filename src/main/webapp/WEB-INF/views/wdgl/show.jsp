<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   	<link rel="stylesheet" type="text/css" href="/resources/css/wdgl.css" />
   	<script type="text/javascript">
   	$(function(){
   		// datepicker
   		$("#fwsj-start").datepicker({changeMonth:true,changeYear:true});
   		$("#fwsj-end").datepicker({changeMonth:true,changeYear:true});
   		
   		// dataTable
   		$("#dataTable").dataTable({
   			'sPaginationType' : 'full_numbers',
   			//"sScrollY" : "272px",
   			'bFilter': true,
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
  				"sSearch" : "",
  				"sUrl" : "",
  				"oPaginate" : {
  					"sFirst" : "首页",
  					"sPrevious" : "上页",
  					"sNext" : "下页",
  					"sLast" : "末页"
  				}
  			}
   		});
   		
   		var $addWdDialog = $("#addWdDialog");
   		$addWdDialog.dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			width: 660,
			height: 500
		});
   		
   		// 添加文档
   		$("#addWdBtn").click(function(){
   			// 清空上一次填写的数据
   			$("#addWdDialog input[type='text']").val("");
   			$("#addWdDialog input[type='file']").val("");
   			$("#addWdDialog textarea").val("");
   			$addWdDialog.dialog("open");
   		});
   		
   		var $editWdDialog = $("#editWdDialog");
   		$editWdDialog.dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			width: 660,
			height: 550
		});
   		
   		// 编辑文档
   		$(".editWdLink").live("click",function(){
   			$("#editWdDialog input[name='wdbh']").val($(this).data("wdbh"));
   			$("#editWdDialog input[name='fwh']").val($(this).data("fwh"));
   			$("#editWdDialog input[name='bt']").val($(this).data("bt"));
   			$("#editWdDialog input[name='fwsj']").val($(this).data("fwsj"));
   			$("#editWdDialog input[name='wdms']").val($(this).data("wdms"));
   			$("#editWdDialog textarea[name='wdnr']").val($(this).data("wdnr"));
   			$("#editWdDialog p[name='yscfj']").text($(this).data("wdywjm").length > 0 ? $(this).data("wdywjm") : "无");
   			$editWdDialog.dialog("open");
   		});
   		
   		adjustLR("wdList");
   	});
   	</script>
</head>
<body>
	<div id="queryForm">
		<form action="queryWd.do" class="form-horizontal" method="post">
			<fieldset>
				<h4>文档查询</h4>
				<div class="row">
					<div class="form-group">
						<label for="fwh" class="control-label col-sm-2 col-md-2" style="display:inline-block;width:90px;height:24px;text-align:center;">发文号：</label>
						<div class="col-sm-4 col-md-4" style="display:inline-block;width:250px;height:30px;">
							<input class="input-sm form-control" type="text" name="fwh" value="${queryFwh}"/>
						</div>
						<label for="bt" class="control-label col-sm-2 col-md-2" style="display:inline-block;width:90px;height:24px;text-align:center;">标题：</label>
						<div class="col-sm-4 col-md-4" style="display:inline-block;width:250px;height:30px;">
							<input class="input-sm form-control" type="text" name="bt" value="${queryBt}"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="fwsj" class="col-sm-2 col-md-2 control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">发文时间：</label>
						<div class="col-sm-6 col-md-6" style="display:inline-block;width:500px;height:30px;">
							<div class="input-group">
								<input type="text" class="input-sm form-control" id="fwsj-start" name="fwsj-start" value="${queryFwsjStart}" style="display:inline-block;"/>
								<span class="input-group-addon">至</span>
								<input type="text" class="input-sm form-control" id="fwsj-end" name="fwsj-end" value="${queryFwsjEnd}" style="display:inline-block;"/>
							</div>
						</div>
						<div class="col-sm-2 col-md-2" style="float:right;">
							<button class="btn btn-primary btn-sm" type="submit">
								<span class="glyphicon glyphicon-search"></span> 查询
							</button>
						</div>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	
	<div id="wdList">
	<div>
		<button id="addWdBtn" class="btn btn-primary btn-sm">
			<span class="glyphicon glyphicon-plus"></span> 添加文档</button>
	</div>
	<table id="dataTable" data-maxindex="${wdList.size()}" class="dataTable" cellspacing="0" width="100%">
		<thead>
				<th width="100px">发文号</th>
				<th>标题</th>
				<th>描述</th>
				<th width="95px">发文时间</th>
				<th width="150px">操作</th>
		</thead>
		<tbody>
			<c:forEach items="${wdList}" var="wd">
				<tr>
					<td>${wd.fwh}</td>
					<td>${wd.bt}</td>
					<td>${wd.wdms}</td>
					<td>${wd.fwsj}</td>
					<td>
						<c:if test="${wd.userid == currentUserId}">
							<span><a class="deleteWdLink" href="deleteWd.do?wdbh=${wd.wdbh}">删除</a></span> | 
							<span><a class="editWdLink" href="javascript:void(0)" data-wdbh="${wd.wdbh}"
									data-fwh="${wd.fwh}" data-bt="${wd.bt}" data-wdms="${wd.wdms}"
									data-fwsj="${wd.fwsj}" data-wdnr="${wd.wdnr}" data-wdywjm="${wd.wdywjm}">编辑</a></span> | 
						</c:if>
						<c:if test="${!empty wd.wdywjm}">
							<span><a class="downloadWdLink" href="downloadWd.do?wdbh=${wd.wdbh}">下载</a></span>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div id="addWdDialog" class="wdDialog" title="添加文档">
		<form id="addWdForm" class="form-horizontal" action="addWd.do" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="fwh" class="col-md-3 control-label"><span class="required">*</span>发文号：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" required name="fwh" />
				</div>
			</div>
			<div class="form-group">
				<label for="bt" class="col-md-3 control-label"><span class="required">*</span>标题：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" required name="bt" />
				</div>
			</div>
			<div class="form-group">
				<label for="wdms" class="col-md-3 control-label">文档描述：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" name="wdms" />
				</div>
			</div>
			<div class="form-group">
				<label for="wdnr" class="col-md-3 control-label"><span class="required">*</span>文档内容：</label>
				<div class="col-md-8">
					<textarea class="form-control" name="wdnr" cols="50" rows="8" required></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="myfiles" class="col-md-3 control-label">上传附件：</label>
				<div class="col-md-8">
					<input type="file" name="myfiles" />
				</div>
			</div>
			<div class="form-group">
				<div class="float-right">
					<button class="btn btn-primary" type="submit">
						<span class="glyphicon glyphicon-ok"></span> 确定
					</button>
				</div>
			</div>
		</form>
	</div>
	
	<div id="editWdDialog" class="wdDialog" title="编辑文档">
		<form id="editWdForm" class="form-horizontal" action="editWd.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="wdbh" />
			<div class="form-group">
				<label class="col-md-3 control-label" for="fwh"><span class="required">*</span>发文号：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" required name="fwh" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="fwsj"><span class="required">*</span>发文日期：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" required disabled name="fwsj" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="bt"><span class="required">*</span>标题：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" required name="bt" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="wdms">文档描述：</label>
				<div class="col-md-8">
					<input class="form-control" type="text" name="wdms" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="wdnr"><span class="required">*</span>文档内容：</label>
				<div class="col-md-8">
					<textarea class="form-control" name="wdnr" cols="50" rows="8" required></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="yscfj">已上传附件：</label>
				<div class="col-md-8">
					<p name="yscfj" class="form-control-static"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="myfiles">上传附件：</label>
				<div class="col-md-8">
					<input type="file" name="myfiles" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-8">
					<button class="btn btn-primary" type="submit">
						<span class="glyphicon glyphicon-ok"></span> 确定
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>