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
<table id="jliuxx_table" data-keyid="${jliuxx.NId}"
	data-fydm="${jliuxx.NFy}" data-rybh="${jliuxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>交流类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NJllb">
					<c:forEach items="${listDmJllb}" var="listDmJllb">
						<option value="${listDmJllb.NDm}" ${listDmJllb.CMc==jliuxx.NJllb?
							'selected="selected"':"" }>${listDmJllb.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jliuxx.NJllb}" />
			</div>
		</td>
		<td class="odd_td"><span style="color:red">*</span>交流方式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NJlfs">
					<c:forEach items="${listDmJlfs}" var="listDmJlfs">
						<option value="${listDmJlfs.NDm}" ${listDmJlfs.CMc==jliuxx.NJlfs?
							'selected="selected"':"" }>${listDmJlfs.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jliuxx.NJlfs}" />
			</div>
		</td>
	</tr>
	<tr>
		<td class="odd_td">交流职务性质：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NJlzwzx">
					<c:forEach items="${listDmJlzwxz}" var="listDmJlzwxz">
						<option value="${listDmJlzwxz.NDm}"
							${listDmJlzwxz.CMc==jliuxx.NJlzwxz? 'selected="selected"':""}>${listDmJlzwxz.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jliuxx.NJlzwxz }" />
			</div></td>
		<td class="odd_td">交流职务名称：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp"
			name="CJlzwmc" value="${jliuxx.CJlzwmc }" /></td>
	</tr>
	<tr>
		<td class="odd_td">开始日期：</td>
		<td class="even_td"><input type="text" id="checkDate1"
			class="myDate_label plxgUp" name="DKsrq" value="${jliuxx.DKsrq}" />
		</td>
		<td class="odd_td">结束日期：</td>
		<td class="even_td"><input type="text" id="checkDate2"
			class="myDate_label plxgUp" name="DJsrq" value="${jliuxx.DJsrq}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">交流工作单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp"
			name="CJlgzdw" value="${jliuxx.CJlgzdw }" /></td>
		<td class="odd_td">交流工作部门：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp"
			name="CJlgzbm" value="${jliuxx.CJlgzbm }" /></td>
	</tr>
	<tr>
		<td class="odd_td">同步简历信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NTbjl">
					<option value="1" ${jliuxx.NTbjl== "是"?'selected="selected"':"" }>是</option>
					<option value="2" ${jliuxx.NTbjl== "否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${jliuxx.NTbjl }" />
			</div></td>
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