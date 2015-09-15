<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
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
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		}
		;
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
	});
</script>
<table id="sfks_table" data-keyid="${sfks.NId}" data-fydm="${sfks.NFy}"
	data-rybh="${sfks.NRybh}">
	<tr style="height:30px">
		<td class="odd_td" style="width:200px"><span style="color:red">*</span>法律职业资格证书类型：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZslx}" var="listDmZslx">
						<option value="${listDmZslx.NDm}" ${listDmZslx.CMc==sfks.NZslx?
							'selected="selected"':"" }>${listDmZslx.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${sfks.NZslx}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">颁证日期：</td>
		<td class="even_td"><input type="text" id="checkDate1"
			class="myDate_label" value="${sfks.DBzrq}" /></td>
	</tr>
	<tr>
		<td class="odd_td">证书编号：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${sfks.CZsbh}" /></td>
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