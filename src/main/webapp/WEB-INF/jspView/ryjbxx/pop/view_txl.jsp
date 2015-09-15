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
<table id="txl_table" data-keyid="${txl.NId}" data-fydm="${txl.NFy}" data-rybh="${txl.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>区号：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue"  value="${txl.CQh}"/></td>
		<td class="odd_td"><span style="color:red">*</span>办公电话：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue"  value="${txl.CBgdh}"/></td>
	</tr>
	<tr>
		<td class="odd_td">家庭电话：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${txl.CJtdh}"/></td>
		<td class="odd_td">移动电话：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${txl.CYddh}"/></td>
	</tr>
	<tr>
		<td class="odd_td">邮政编码：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${txl.CYzbm}"/></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>通讯地址：</td>
		<td class="even_td" colspan="3"><input type="text" class="myLabel keyValue" style="width:100%"  value="${txl.CTxdz}"/></td>

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