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
			$(".my_input_s,.myLabel").attr("readonly","readonly");
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
	});
</script>
<table id="rcxx_table" data-keyid="${rcxx.NId}" data-fydm="${rcxx.NFy}" data-rybh="${rcxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>部门：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NBm">
					<c:forEach items="${listDmBm}" var="listDmBm">
						<option value="${listDmBm.NDm}" ${listDmBm.CMc==rcxx.NBm?'selected="selecteds"':""}>${listDmBm.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${rcxx.NBm}" />
			</div></td>
		<td class="odd_td"><span style="color:red">*</span>人才类型：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NRclx">
					<c:forEach items="${listDmRclx}" var="listDmRclx">
						<option value="${listDmRclx.NDm}" ${listDmRclx.CMc==rcxx.NRclx?'selected="selected"':"" }>${listDmRclx.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${rcxx.NRclx}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>批准时间：</td>
		<td class="even_td"><input name="DPzsj" type="text" id="checkDate1 pzsj" class="myDate_label keyValue plxgUp" value="${rcxx.DPzsj}" /></td>
		<td class="odd_td"><span style="color:red">*</span>批准文号：</td>
		<td class="even_td"><input name="CPzwh" type="text" id="pzwh" class="myLabel keyValue plxgUp" value="${rcxx.CPzwh}" /></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>批准单位：</td>
		<td class="even_td"><input name="CPzdw" type="text" id="pzdw" class="myLabel keyValue plxgUp" value="${rcxx.CPzdw}" /></td>
		<td class="odd_td"><span style="color:red">*</span>批准部门：</td>
		<td class="even_td"><input name="CPzbm" type="text" id="pzbm" class="myLabel keyValue plxgUp" value="${rcxx.CPzbm}" /></td>
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