<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	//检查时间格式
	function checkTime(str){
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	$(function(){
		$type="${btnType}";
		if($type!=1){
			$zdybq.changeDateFromLabelToPicker();
			$zdybq.changeFromLabelToInput();
			$zdybq.changeToSelect();
			$zdybq.changeAreaToEdit();
			$zdybq.updateKeyValue($type);
			
			$("#i_save").parent().show();
			$("#i_close").parent().prop("colspan","2");
		}else {
			$(".my_input_s").css({
				"border" : "0px"
			});
			$(".my_input_s").show();
			$(".my_select_s").hide();
			$("#i_save").parent().hide();
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		};
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
<table id="hbgb_table" data-keyid="${hbgb.NId}" data-fydm="${hbgb.NFy}" data-rybh="${hbgb.NRybh}">
	<tr style="height:30px">
		<td class="odd_td">后备职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZw}" var="listDmZw">
						<option value="${listDmZw.NDm}" ${listDmZw.CMc==hbgb.NHbzw?'selected="selected"':"" }>${listDmZw.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${hbgb.NHbzw}" />
			</div>
		</td>
		<td class="odd_td">锻炼职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZw}" var="listDmZw">
						<option value="${listDmZw.NDm}" ${listDmZw.CMc==hbgb.NDlzw?'selected="selected"':"" }>${listDmZw.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${hbgb.NDlzw}" />
			</div>
		</td>
	</tr>
	<tr>
		<td class="odd_td">开始时间：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label"
			value="${hbgb.DKssj}" />
		</td>
		<td class="odd_td">结束时间：</td>
		<td class="even_td"><input type="text" id="checkDate2" class="myDate_label"
			value="${hbgb.DJssj}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">锻炼单位：</td>
		<td class="even_td" colspan="3"><input type="text"
			class="myLabel" value="${hbgb.CDldw}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">结论：</td>
		<td class="even_td" colspan="3"><input type="text"
			class="myLabel" value="${hbgb.CJl}" />
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