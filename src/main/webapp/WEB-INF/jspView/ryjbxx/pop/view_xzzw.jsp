<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
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
			if(str!=""){
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
<table id="xzzw_table" data-keyid="${xzzw.NId}" data-fydm="${xzzw.NFy}" data-rybh="${xzzw.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>任免类型：</td>
		<td class="even_td"><div class="mySelect" >
				<select class="my_select_s plxgUp keyValue" name="NRmlb" style="width: 100%; height: 90%;">
					<option value="任" ${xzzw.NRmlb=="任"?'selected="selected"':"" }>任</option>
					<option value="免" ${xzzw.NRmlb=="免"?'selected="selected"':"" }>免</option>
				</select><input type="text" class="my_input_s"  value="${xzzw.NRmlb}"/></div></td>
		<td class="odd_td"><span style="color:red">*</span>行政职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp keyValue" name="NXzzw" style="width: 100%; height: 90%;">
					<c:forEach items="${listDmXzzw}" var="listDmXzzw">
						<option value="${listDmXzzw.CMc}" ${listDmXzzw.CMc==xzzw.NXzzw?'selected="selected"':""}>${listDmXzzw.CMc}</option>
					</c:forEach>
				</select>
		<input type="text" class="my_input_s" value="${xzzw.NXzzw}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">任免日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label plxgUp" name="DRmrq" value="${xzzw.DRmrq}" /></td>
		<td class="odd_td">单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CDw"  value="${xzzw.CDw}"/></td>
	</tr>
	<tr>
		<td class="odd_td">部门：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CBm"  value="${xzzw.CBm}"/></td>
		<td class="odd_td">任免原因：</td>
		<td class="even_td">
			<div class="mySelect">
				<select class="my_select_s plxgUp" name="NRmyy">
					<option value="新录用试用期满合格" ${xzzw.NRmyy=="新录用试用期满合格"?'selected="selected"':"" }>新录用试用期满合格</option>
					<option value="其他单位调入"  ${xzzw.NRmyy=="其他单位调入"?'selected="selected"':"" }>其他单位调入</option>
					<option value="转换职位任职" ${xzzw.NRmyy=="转换职位任职"?'selected="selected"':"" }>转换职位任职</option>
					<option value="晋升或降低职务" ${xzzw.NRmyy=="晋升或降低职务"?'selected="selected"':"" }>晋升或降低职务</option>
					<option value="因其他原因职务发生变化" ${xzzw.NRmyy=="因其他原因职务发生变化"?'selected="selected"':"" }>因其他原因职务发生变化</option>
				</select><input type="text" class="my_input_s"  value="${xzzw.NRmyy}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">批准日期：</td>
		<td class="even_td"><input type="text" id="checkDate2" class="myDate_label plxgUp" name="DPzrq" value="${xzzw.DPzrq}" /></td>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzdw"  value="${xzzw.CPzdw}"/></td>
	</tr>
	<tr>
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel" plxgUp" name="CPzwh"  value="${xzzw.CPzwh}"/></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDqxx">
					<option value="是" ${xzzw.NDqxx=="是"?'selected="selected"':"" }>是</option>
					<option value="否" ${xzzw.NDqxx=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${xzzw.NDqxx}" />
			</div></td>
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