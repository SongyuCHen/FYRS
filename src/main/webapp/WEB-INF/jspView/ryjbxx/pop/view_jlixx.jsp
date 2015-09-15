<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="../../resources/js/zdybq.js"></script>
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
	});
</script>
<table id="jlixx_table" data-keyid="${jlixx.NId}" data-fydm="${jlixx.NFy}" data-rybh="${jlixx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>奖励类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgup" name="NJllb">
					<c:forEach items="${listDmJllb}" var="listDmJllb">
						<option value="${listDmJllb.NDm}" ${listDmJllb.CMc==jlixx.NJllb?'selected="selected"':""}>${listDmJllb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${jlixx.NJllb}"/></div></td>
		<td class="odd_td">奖励类别说明：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CJllbsm"  value="${jlixx.CJllbsm}"/></td>
	</tr>
	
	<tr>
		<td class="odd_td"><span style="color:red">*</span>奖励原因：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgup" name="NJlyy">
					<c:forEach items="${listDmJlyy}" var="listDmJlyy">
						<option value="${listDmJlyy.NDm}" ${listDmJlyy.CMc==jlixx.NJlyy?'selected="selected"':""}>${listDmJlyy.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${jlixx.NJlyy}"/></div></td>
		<td class="odd_td">奖励原因说明：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CJlyyxx"  value="${jlixx.CJlyyxx}"/></td>
	</tr>
		
	<tr>
		<td class="odd_td">个人情况：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NGrqk">
					<c:forEach items="${listDmGrqk}" var="listDmGrqk">
						<option value="${listDmGrqk.NDm}" ${listDmGrqk.CMc==jlixx.NGrqk?'selected="selected"':"" }>${listDmGrqk.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${jlixx.NGrqk}"/></div></td>
		<td class="odd_td">奖励级别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NJljb">
					<c:forEach items="${listDmJljb}" var="listDmJljb">
						<option value="${listDmJljb.NDm}" ${listDmJljb.CMc==jlixx.NJljb?'selected="selected"':"" }>${listDmJljb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${jlixx.NJljb}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">奖励时间：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label plxgUp" name="DJlsj" value="${jlixx.DJlsj}" /></td>
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzwh"  value="${jlixx.CPzwh}"/></td>
	</tr>
	<tr>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzdw"  value="${jlixx.CPzdw}"/></td>
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