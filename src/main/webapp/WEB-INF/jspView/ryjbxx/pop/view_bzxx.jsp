<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
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
			$(".my_input_s,.myLabel").attr("readonly", "readonly");
		};
	});
</script>
<table id="bzxx_table" data-keyid="${bzxx.NId}" data-fydm="${bzxx.NFy}" data-rybh="${bzxx.NRybh}">
	<tr>
		<td>备注：</td>
		<td colspan="3"><textarea class="myArea_read keyValue">${bzxx.CBz}</textarea></td>
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