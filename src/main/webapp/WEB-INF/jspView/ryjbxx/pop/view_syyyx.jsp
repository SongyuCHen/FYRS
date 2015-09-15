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
		};
	});
</script>
<table id="syyyx_table" data-bh="${syyyx.NId}">
	<tr>
		<td class="odd_td">文件：</td>
		<td class="even_td" colspan="1">
			<!--<input type="text" id="file_path" class="myLabel" value="${syyyx.CPath}" /> 
			<input type="button" id="fileselect_btn" value="浏览..." />  -->
			<input type="file" id="file" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">描述：</td>
		<td class="even_td" colspan="3">
			<textarea class="myArea_read"
				style="width:100%">${syyyx.CMs}</textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center"><input id="i_save"
			type="button" value="保存" class="btn" data-type="${btnType }" /></td>
		<td colspan="4" style="text-align:center"><input id="i_close"
			type="button" value="关闭" class="btn" /></td>
	</tr>
</table>