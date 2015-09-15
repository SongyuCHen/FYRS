<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
   <script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
   <script src="/resources/jstree/jquery.jstree.js"></script>
   <script src="/resources/js/jquery.orgchart.js"></script>

   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" href="/resources/css/jquery.orgchart.css"/>
   <style type="text/css">
      #bmjggl_xzfy{
        padding: 15px 0;
        background-color: #EEF7FD;
		margin-bottom: 5px;
		color: #166092;
		font-size: 120%;
		text-align:center;
		border-bottom: 2px solid #96C8EB;
      }
      #main div.node {
		  border-radius: 0px;
		  box-shadow: none;
		  width:2em;
		  height:auto;
		  padding:6px 4px;
		}
	  #main div.level0 {
		  width: auto;
		  font-style: normal;
  		  font-size: 14px;
          padding: 4px 6px;
	  }
	  
	  #main td.line{
	  	height:10px;
	  }
      .operationDiv button{
      	float:right;
      }
      
     div.orgChart{
     	overflow-y:auto;
      }
   </style>
   <script type="text/javascript">
     $(function(){
         initTable("bmjggl_list");
    	  // 点击触发事件 
    	  $('.xzfy_ipt').click(function() {
  			$.ajax({
  				url : "/xzfyShow.aj",
  				type : 'post',
  				dataType : 'html',
  				data : {},
  				success : function(html) {
  				    $('.xzfy_dlg').html(html).dialog('open');
  				}
  			});
  		}); // 获得法院
  		
  		$('.bmjggl_dlg').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 400,
			width : 400,
			title : '添加机构',
			close:function(){
				// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
			    removeSelectTrActive("bmjggl");
			}
		}); // dialog
		
		$('.bmryfb').dialog({
			autoOpen : false,
			bgiframe : true,
			modal : true,
			resizable : false,
			height : 500,
			width : 650,
			title : '查看——人员分布',
			close : function() {
				
			}
		});
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
		
     }); // jquery
     var initTable = function(dataTableId){
   	  $bmjggl_oTable=$("#"+dataTableId+" #dataTable").dataTable({
   		   "sPaginationType" : "full_numbers", 
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
     var selectFyAfter = function(){
  	   var fydm = $(".xzfy_fybh").val();
  	   initDataTable(fydm);
     };
     
	 function onNodeClicked($node) {
            var bmdm = $node.clone().data("ncode");
            var fydm = $("#organisation").children().eq(0).data("ncode");
            var fy = $node.parentsUntil("#organisation").eq(1).data("ncode");
            if(fy!==undefined){
            	$.ajax({
            		url:"/main/dwxx/bmryfb.aj",
            		type:"POST",
            		data:{fydm:fydm,bmdm:bmdm},
            		dataType:"html",
            		success:function(html){
						$(".bmryfb").html(html).dialog("open");            		
            		}
            	});
            }
            
      }
      
      var initDataTable = function(fydm){
		 $.ajax({
	    	  url:"/main/dwxx/bmjgglDetail.aj",
	    	  type:"POST",
	    	  data:{fydm:fydm},
	    	  dataType:"json",
	    	  success:function(json){
	    	  	  $("#organisation").empty();
	    	  	  $node = $("#organisation");
	    	  	  $li = $("<li data-ncode="+json[0].NCode+">"+json[0].CName+"</li>");
	    	  	  $node.append($li);
	    	  	  $ul = $("<ul></ul");
	    	  	  $li.append($ul);
	    		  for(var i=1;i<json.length;i++){
	    		  	var jg = json[i];
	    		  	$ul.append("<li data-ncode="+jg.NCode+">"+jg.CName+"</li>");
	    		  }
	    		  $("#organisation").orgChart({container: $("#main"), nodeClicked: onNodeClicked});
	    	  }
	      }); 
	 };
   </script>
</head>
<body>
 <div id="bmjggl_xzfy" class="form-horizontal">
 		<div class="form-group">
 			<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院：</label>
 			<div style="display:inline-block;width:250px;height:30px;">
	 			<input type="text" class="xzfy_ipt form-control" value="请选择一个法院" style="display:inline-block;"/>
				<input class="xzfy_fybh" name="fybh" value="320000 A00" type="hidden" />
			</div>
		</div>
 </div>
 <div class="operationDiv clearfix">
 	<button type="button" class="btn btn-primary" id="bmjggl_add" data-btnType="0">
		<span class="glyphicon glyphicon-plus"></span> 添加
	</button>
 </div>
	<div id="bmjggl_list" style="overflow:true;">
		<ul id="organisation" style="display:none;"></ul>
        <div id="main"></div>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="0" isFyAndBm="0"></div>
	<div class="bmjggl_dlg"></div>
	<div class="ex_dlg"></div>
	<div class="bmryfb"></div>
</body>
</html>
