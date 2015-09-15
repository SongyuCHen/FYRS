<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	//函数检查必须为数字，可以为浮点数
	function checkDouble(str) {
		if(str!=""){
			var reg = new RegExp("^([+-]?)\\d*\\.?\\d+$");
			return reg.test(str);
		}else{
			return true;
		}
		
	}
	//检查时间格式
	function checkTime(str) {
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
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
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly", "readonly");
		}
		;

		$("#checkDoubleNum1").change(function() {
			if ($("#checkDoubleNum1").val() != "") {
				if (!checkDouble($("#checkDoubleNum1").val())) {
					$(".J_dlg").html('<p>级别工资额必须为数字</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}

		});
		$("#checkDoubleNum2").change(function() {
			if ($("#checkDoubleNum2").val() != "") {
				if (!checkDouble($("#checkDoubleNum2").val())) {
					$(".J_dlg").html('<p>级别工资额必须为数字</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}

		});
		$("#checkDoubleNum3").change(function() {
			if ($("#checkDoubleNum3").val() != "") {
				if (!checkDouble($("#checkDoubleNum3").val())) {
					$(".J_dlg").html('<p>级别工资额必须为数字</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}

		});
		$("#checkDoubleNum4").change(function() {
			if ($("#checkDoubleNum4").val() != "") {
				if (!checkDouble($("#checkDoubleNum4").val())) {
					$(".J_dlg").html('<p>级别工资额必须为数字</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}

		});
		$("#checkDoubleNum5").change(function() {
			if ($("#checkDoubleNum5").val() != "") {
				if (!checkDouble($("#checkDoubleNum5").val())) {
					$(".J_dlg").html('<p>级别工资额必须为数字</p>').dialog({
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
	});
</script>
<table id="gzxx_table" data-keyid="${gzxx.NId}" data-fydm="${gzxx.NFy}"
	data-rybh="${gzxx.NRybh}">
	<tr>
		<td class="odd_td" style="width:110px"><span style="color:red">*</span>职务工资档次：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue"
			value="${gzxx.CZwgzdc}" />
		</td>
		<td class="odd_td" style="width:100px"><span style="color:red"></span>档次时间：</td>
		<td class="even_td"><input type="text" id="checkDate1"
			class="myDate_label" value="${gzxx.DZwgzdcsj}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">现级别：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${gzxx.CXjb}" />
		</td>
		<td class="odd_td">现级别时间：</td>
		<td class="even_td"><input type="text" id="checkDate2"
			class="myDate_label" value="${gzxx.DXjbsj}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">级别工资额：</td>
		<td class="even_td"><input type="text" id="checkDoubleNum1"
			class="myLabel" value="${gzxx.MJbgze}" />
		</td>
		<td class="odd_td">职务工资额：</td>
		<td class="even_td"><input type="text" id="checkDoubleNum2"
			class="myLabel" value="${gzxx.MZwgze}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">职务岗位补贴：</td>
		<td class="even_td"><input type="text" id="checkDoubleNum3"
			class="myLabel" value="${gzxx.MZwgwbt}" />
		</td>
		<td class="odd_td">津贴：</td>
		<td class="even_td"><input type="text" id="checkDoubleNum4"
			class="myLabel" value="${gzxx.MJt}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">教、护龄津贴：</td>
		<td class="even_td"><input type="text" id="checkDoubleNum5"
			class="myLabel" value="${gzxx.MJhljt}" />
		</td>
	</tr>
</table>
<div class="bottom-btn-bar">
	<div class="btn-group">
		<button id="i_save" class="btn btn-primary" data-type="${btnType}">
			<span class="glyphicon glyphicon-save"></span> 保存
		</button>
		<button id="i_close" class="btn btn-default">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>