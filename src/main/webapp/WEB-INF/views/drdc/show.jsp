<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    
    <style type="text/css">
      .tab-pane{
    	padding: 15px;
      }
      .nav li{
      	font-size: 16px;
      }
      #editWdForm{
        text-align: center;
        padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
		font-size: 110%;
      }
   </style>
   <script type="text/javascript">
      $(function(){
      	$('#load_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 200,
			width : 180,
			title : '导入中,请认真等待',
			close : function() {

			}
		});
      	$('#dbTab a[href="#importFile"]').tab('show');
      	$("#drButton").click(function(){
      		var val = $("#fileId").val();
      		if(val == ""){
      			alert("请选择要上传的文件");
      		}else{
      			var subname = val.substring(val.length-2).toLowerCase();
      			if((val.slice(-3,-2) == '.')&&(subname == "db" )){
      				$("#load_dlg").dialog('open');
      				$.ajax({
      					url:"/main/xtgl/importFile.do",
      					type:"post",
      					data:{fileName:val},
      					dataType:'json',
      					success:function(){
      						$("#load_dlg").dialog('close');
      					}
      				});
      			}else{
      				alert("请选择db文件");
      			}
      		}
      	});
      	
      	//导出功能
      	$("#bfh_btn_export").click(function(){
      		$("#load_dlg").dialog('open');
      			$.ajax({
      				url:"/main/xtgl/ExportFile.do",
      				type:"post",
      				dataType:'json',
      				success:function(){
      					$("#load_dlg").dialog('close');
      				}
      		});
      	});
      });
   </script>
</head>
<body>
	<ul id="dbTab" class="nav nav-tabs" role="tablist">
		<li>
			<a href="#exportFile" role="tab" data-toggle="tab">
				<span class="glyphicon glyphicon-briefcase"></span> 导出功能
			</a>
		</li> 
		<li>
			<a href="#importFile" role="tab" data-toggle="tab">
				<span class="glyphicon glyphicon-cloud-upload"></span> 导入功能
			</a>
		</li>
	</ul>
<div class="tab-content">
	<div class="tab-pane" id="exportFile">
      <div class="form-horizontal">
      	<div class="form-group">
      		<div class="alert alert-info" role="alert">
      			<p>将系统数据库导出！</p>
      		</div>
      	</div>
     	<div class="form-group">
      		<button class="btn btn-primary center-block" id="bfh_btn_export">
      			<span class="glyphicon glyphicon-ok"></span> 导出
      		</button>
     	</div>
      </div>
  	</div>
	<div class="tab-pane" id="importFile">
		<div id="editWdForm" class="form-horizontal"> <!--enctype="multipart/form-data"  -->
		    <div class="form-group">
		    	<div class="col-sm-offset-2 col-md-offset-2 col-sm-6 col-md-6" style="display:inline-block;">
			    	<label class="col-sm-3 col-md-3 control-label" style="display:inline-block;">文件路径</label>
			    	<div class="col-sm-6 col-md-6" style="display:inline-block;">
			    		<input type="file" value="选择文件" name="fileName" id="fileId">
			    	</div>
			    </div>
		    	<div class="col-sm-3 col-md-3" style="display:inline-block;">
			      	<button class="btn btn-primary" type="submit" style="display:inline-block;" id="drButton">
						<span class="glyphicon glyphicon-cloud-upload"></span> 导入
					</button>
				</div>
		    </div>		
		</div>
	</div>
</div>
<div id="load_dlg"><img src="/resources/images/loading.gif" style="width:120px;height:120px;margin-left:10px;"/></div>
</body>
</html>
