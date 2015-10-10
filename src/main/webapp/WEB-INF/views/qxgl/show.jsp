<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
   <style type="text/css">
      .qxgl-head
      {
        padding: 15px;
	margin-bottom: 50px;
	color: black;
	background-color:#EDEDED;
		font-size: 120%;
      }
      #qxgl_list
      {
      }
      #qxgl_list
      {
        margin-top: 5px;
      }
   </style>
   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
   <script src="/resources/jstree/jquery.jstree.js"></script>
   <script type="text/javascript"
		src="/resources/js/jquery/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />
   <script type="text/javascript">
      $(function(){
    	//uniform美化多选框
    	  $('input:checkbox, input:radio, .uniform-file').uniform();
    	
    	// 加载时初始化一次表格
    	initTable();
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
  		});
        // 当修改权限时，给它添加一个标识的 class
    	  /*active选中的dataTable中的行*/
			function activeSelectTr($node){
				// 它只是简单地添加一个  class 作为标识，表示选中一行，也就是在 <tr> 添加  class 属性
				$node.parent().parent().addClass("active");
			}
        // 关闭时，添加的 active 属性去掉
			/*清除dataTable中选中行的active类*/
			function removeSelectTrActive(id){
				// 当窗口关闭时，把添加的  class 属性进行删除
				$("#"+id+"_list #dataTable tbody .active").removeClass("active");
			}
    	  // 修改权限
          $("#qxgl_list .dlg_modify").live('click',function(){
        	  activeSelectTr($(this));
        	  $.ajax({
        			url:"/main/xtgl/ownroles.aj",
					type:"post",
					dataType:"html",
					data:{
						fydm:$(this).parent().data("fydm"),rybh:$(this).parent().data("rybh")
					},
					success:function(html){
						$("#ownRoles_dlg").html(html).dialog('open');
						$.uniform.update();
					}
        	  });
          });
    	  // 清空密码
    	  $("#qxgl_list .i_delete").live('click',function(){
    		  var temp = $(this);
    		  $(".ex_dlg").html('<p>是否确定要清空密码？</p>').dialog({
					'close':function(){
					},
					'buttons':{
						"确定":function(){
							 $.ajax({
				    			  url:"/main/xtgl/emptyPassword.aj",
									type:"post",
									dataType:"html",
									data:{
										realName:temp.parent().data("realname"),fydm:temp.parent().data("fydm"),rybh:temp.parent().data("rybh")
									},
									success:function(html){
										if(html == 1)
											{
											  alert("成功清除密码！");
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
    	  //拥有角色 dialog
          $('#ownRoles_dlg').dialog({
				autoOpen : false,
				bgiframe : true,
				modal : true,
				resizable : false,
				height : 400,
				width : 540,
				title : '拥有--角色',
				close:function(){
					// 这是关闭时触发的函数,也就是把添加选中一行的 class 删除
				    removeSelectTrActive("qxgl");
				}
			});
       
      }); //  jquery
      var initTable = function(dataTableId){
    	  $roles_oTable=$("#qxgl_list #dataTable").dataTable({
    		"sPaginationType" : "full_numbers",
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
  				"sSearch" : "",
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
    	  adjustLR("qxgl_list");
      }
     
      // 当部门被选择时
      var selectBmAfter = function(){
    	  var selectValue = $("#select-xzbm option:selected").attr("value");
    	  if(-1 == selectValue)
    		  {
    		     alert("请选择一个部门");
    		     return;
    		  }
    	  $.ajax({
			      url : "/main/xtgl/getUsername.aj",
				  type : 'post',
				  dataType : 'json',
				  data : {'fyDm':$(".xzfy_fybh").val(),'bmDm':$("#select-xzbm option:selected").attr("value")},
				  success:function(json)
				  {
					  var html = '<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%"><thead><tr class="tableHead"><th width="40px">序号</th><th width="60px">姓名</th><th width="90px">登录用户名</th><th>权限</th><th width="120px">操作</th></tr></thead><tbody>';
					  for(var i = 0; i < json.length; i++)
						  {
						    var ryjbxx = json[i];
						    html += "<tr>";
						    html += '<td class="center">'+(i+1)+'</td>';
						    html += '<td class="center">'+ryjbxx.CXm+'</td>';
						    html += '<td class="center">'+ryjbxx.CBs+'</td>';
						    html += '<td class="center">'+ryjbxx.roleNames+'</td>';
						    html += '<td class="center" data-realName="'+ryjbxx.CXm+'"  data-fyDm="'+ryjbxx.NFy+'" data-rybh="'+ryjbxx.NRybh+'"><a class="dlg_modify" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">清空密码</a></td>';
						  }
					  html += '</tbody></table>';
					  // $("#qxgl_list #dataTable").remove();
					  $("#qxgl_list  #dataTable_wrapper").remove();
					  $("#qxgl_list").append(html);
					  initTable();
				  }
				});
      }
   </script>
</head>
<body>
	<div class="qxgl-head form-horizontal">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 col-md-3 control-label" for="xzfy_ipt" style="display:inline-block;width:90px;height:24px;text-align:center;">法院：</label>
				<div class="col-sm-8 col-md-8" style="display:inline-block;width:250px;height:30px;">
					<input type="text" class="xzfy_ipt form-control"
									value="请选择一个法院"  style="display:inline-block;"/>
					<input class="xzfy_fybh" name="fybh"
									value="320000 A00" type="hidden" />
				</div>
				
				<label class="col-sm-3 col-md-3 control-label" for="select-xzbm" style="display:inline-block;width:90px;height:24px;text-align:center;">部门：</label>
				<div class="col-sm-8 col-md-8" style="display:inline-block;width:250px;height:30px;">
					<select id="select-xzbm" class="form-control" style="display:inline-block;">
						<option value="1">请先选择法院</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	<div id="qxgl_list" class="main_list">
		<table id="dataTable" data-maxindex="${roles.size()}" class="cell-border" cellspacing="0" width="100%">
			<thead>
				<tr class="tableHead">
					<th width="40px">序号</th>
					<th width="60px">姓名</th>
					<th width="90px">登录用户名</th>
					<th >权限</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="1" isFyAndBm="0"></div>
	<div id="ownRoles_dlg"></div><div class="ex_dlg"></div>
</body>
</html>
