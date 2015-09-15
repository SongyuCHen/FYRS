<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/resources/js/zdybq.js"></script>
<script type="text/javascript">
	//检查时间格式
	function checkTime(str) {
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	//检查为正整数
	function checkInteger(str) {
		var reg = /^[0-9]*[1-9][0-9]*$/;
		return reg.test(str);
	}
	$(function() {
		$type = "${btnType}";
		if ($type != 1) {
			$zdybq.changeDateFromLabelToPicker();
			$zdybq.changeFromLabelToInput();
			$zdybq.changeToSelect();
			$zdybq.changeAreaToEdit();
			$zdybq.updateKeyValue($type);

			$("#i_save").parent().show();
			$("#i_close").parent().prop("colspan", "2");
		} else {
			$(".my_input_s").css({
				"border" : "0px"
			});
			$(".my_input_s").show();
			$(".my_select_s").hide();
			$("#i_save").parent().hide();
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		}
		;

		$("#checkNum").change(function() {
			//检查必填项是否已经填写完整：true.填写完整 false.不完整
			if ($("#checkNum").val() != "") {
				if (!checkInteger($("#checkNum").val())) {
					$(".J_dlg").html('<p>学制必须为正整数</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}
		});

		$("#checkDate1").change(function() {
			var str = $(this).val();
			if (str != "") {
				if (!checkTime(str)) {
					$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}
			}
		});
		$("#checkDate2").change(function() {
			var str = $(this).val();
			if (str != "") {
				if (!checkTime(str)) {
					$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}
			}
		});
		$("#bmxz").change(function() {
	
			var bm = $("#bmxz option:selected").attr("value");
			var fy = $("#htgl_table").data("fydm");
			$.ajax({
  				url : "/main/ryxx/zzkTable.aj",
  				type : 'post',
  				dataType : 'json',
  				data : {bmdm:bm,fydm:fy,lsklx:1},
  				success : function(json) {
  				var allOption  ;
	  			for(var i = 0; i < json.length; i++)
			  	{
			   		var ry = json[i];
			   		allOption += '<option value="'+ry.rybh+'">' + ry.xm+'</option>';
			  	}
	  			$("#xmxz").append(allOption);
  				}
  			});
		});
	});

</script>
<table id="htgl_table" data-keyid="${htgl.NId}" data-fydm="${htgl.NFy}"
	data-rybh="${htgl.NRybh}">
	<tr style="height:35px">
		<td class="odd_td" style="font-weight:bold;"><span
			style="color:red">*</span>部门：</td>
		<td class="even_td"><div class="mySelect" id="bmxz">
				<select class="my_select_s">
					<c:forEach items="${listDmBm}" var="listDmBm">
						<option value="${listDmBm.NCode}" >${listDmBm.CName}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="" />
			</div></td>
		<td class="odd_td" style="font-weight:bold;">姓名：</td>
		<td class="even_td">
			<select id="xmxz" class="myLabel">
			</select>
		</td>
		<%-- <td class="even_td"><input type="text" class="myLabel" value="${htgl.CXm}" /></td> --%>
	</tr>
	<tr style="height:35px">
		<td class="odd_td" >合同类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmHt}" var="listDmHt">
						<option value="${listDmHt.NDm}" >${listDmHt.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${htgl.NHtlb}" />
			</div></td>
		<td class="odd_td">合同编号：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${htgl.CHtbh}" /></td>
	</tr>
	<tr>
		<td class="odd_td">签订日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label" value="${htgl.DQdrq}" /></td>
		<td class="odd_td">合同年限：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${htgl.CHtqx}" /></td>
	</tr>
	<tr style="height:35px">
		<td class="odd_td">聘任职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmPrzw}" var="listDmPrzw">
						<option value="${listDmPrzw.NDm}" >${listDmPrzw.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${htgl.NPrzw}" />
			</div></td>
	<%-- 	<td class="even_td"><input type="text" class="myLabel" value="${htgl.NPrzw}" /></td> --%>
		<td class="odd_td">备注：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${htgl.CBz}" /></td>
	</tr>
</table>
<div class="bottom-btn-bar">
	<div class="btn-group">
		<button id="i_save" class="btn btn-primary" data-type="${btnType}">
			<span class="glyphicon glyphicon-save"></span> 保存
		</button>
		<button id="i_close" class="btn btn-default" data-type="${btnType}">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>