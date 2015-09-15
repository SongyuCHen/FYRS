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
<table id="flzw_table" style="border-collapse:collapse;" data-keyid="${flzw.NId}" data-fydm="${flzw.NFy}" data-rybh="${flzw.NRybh}">
	<tr style="height:35px">
		<td class="odd_td" style="font-weight:bold;"><span style="color:red" >*</span>任免类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NRmlb">
					<option value="任" ${flzw.NRmlb=="任"?'selected="selected"':"" }>任</option>
					<option value="免" ${flzw.NRmlb=="免"?'selected="selected"':"" }>免</option>
				</select>
		<input type="text" class="my_input_s"  value="${flzw.NRmlb}"/></div></td>
		<td class="odd_td" style="font-weight:bold;"><span style="color:red">*</span>法律职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NFlzw">
					<option value="院长" ${flzw.NFlzw=="院长"?'selected="selected"':"" }>院长</option>
					<option value="副院长" ${flzw.NFlzw=="副院长"?'selected="selected"':"" }>副院长</option>
					<option value="审判委员会委员" ${flzw.NFlzw=="审判委员会委员"?'selected="selected"':"" }>审判委员会委员</option>
					<option value="庭长" ${flzw.NFlzw=="庭长"?'selected="selected"':"" }>庭长</option>
					<option value="副庭长" ${flzw.NFlzw=="副庭长"?'selected="selected"':"" }>副庭长</option>
					<option value="助理审判员" ${flzw.NFlzw=="助理审判员"?'selected="selected"':"" }>助理审判员</option>
					<option value="执行员" ${flzw.NFlzw=="执行员"?'selected="selected"':"" }>执行员</option>
					<option value="法官助理" ${flzw.NFlzw=="法官助理"?'selected="selected"':"" }>法官助理</option>
					<option value="书记员" ${flzw.NFlzw=="书记员"?'selected="selected"':"" }>书记员</option>
					<option value="法警" ${flzw.NFlzw=="法警"?'selected="selected"':"" }>法警</option>
					<option value="法医" ${flzw.NFlzw=="法医"?'selected="selected"':"" }>法医</option>
					<option value="代院长" ${flzw.NFlzw=="代院长"?'selected="selected"':"" }>代院长</option>
					<option value="其他审判辅助人员" ${flzw.NFlzw=="其他审判辅助人员"?'selected="selected"':"" }>其他审判辅助人员</option>
				</select>
		<input type="text" class="my_input_s"  value="${flzw.NFlzw}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td" style="font-weight:bold;">任免日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label plxgUp" name="DRmrq" value="${flzw.DRmrq}" /></td>
		<td class="odd_td">单位：</td>
		<td class="even_td"><input type="text" class="myLabel  plxgUp" name="CDw"  value="${flzw.CDw}"/></td>
	</tr>
	<tr style="height:35px">
		<td class="odd_td">部门：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CBm"  value="${flzw.CBm}"/></td>
		<td class="odd_td">任免原因：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NRmyy">
					<option value="新录用试用期满合格" ${flzw.NRmyy=="新录用试用期满合格"?'selected="selected"':"" }>新录用试用期满合格</option>
					<option value="其他单位调入" ${flzw.NRmyy=="其他单位调入"?'selected="selected"':"" }>其他单位调入</option>
					<option value="转换职位任职" ${flzw.NRmyy=="转换职位任职"?'selected="selected"':"" } >转换职位任职</option>
					<option value="晋升或降低职务" ${flzw.NRmyy=="晋升或降低职务"?'selected="selected"':"" }>晋升或降低职务</option>
					<option value="因其他原因职务发生变化" ${flzw.NRmyy=="因其他原因职务发生变化"?'selected="selected"':"" }>因其他原因职务发生变化</option>
				</select>
		<input type="text" class="my_input_s"  value="${flzw.NRmyy}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">批准日期：</td>
		<td class="even_td"><input type="text" id="checkDate2" class="myDate_label plxgUp" name="DPzrq" value="${flzw.DPzrq}" /></td>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzdw"  value="${flzw.CPzdw}"/></td>
	</tr>
	<tr><!-- style="border-bottom:dashed 1px dimGray"-->
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzwh"  value="${flzw.CPzwh}"/></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDqxx">
					<option value="是" ${flzw.NDqxx=="是"?'selected="selected"':"" }>是</option>
					<option value="否" ${flzw.NDqxx=="否"?'selected="selected"':"" }>否</option>
				</select>
		<input type="text" class="my_input_s"  value="${flzw.NDqxx}"/></div></td>
	</tr>
	<!--<tr>
		<td class="odd_td">首次任命法官：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${flzw.NCrfg}"/></td>
		<td class="odd_td">首任法官法律工作年限：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${flzw.NCrfgnx}"/></td>
	</tr>
	<tr>
		<td class="odd_td" style="font-weight:bold;">从事法律工作情况：</td>
		<td class="even_td" colspan="3"><input type="text" class="myLabel"  value="${flzw.NFlgzqk}"/></td>
	</tr>
	<tr>
		<td class="odd_td">具有法律专业知识：</td>
		<td class="even_td" colspan="3"><input type="text" class="myLabel"  value="${flzw.NFlzyzs}"/></td>
	</tr>
	<tr>
		<td class="odd_td" style="font-weight:bold;">具有法律专业知识情况：</td>
		<td class="even_td" colspan="3"><input type="text" class="myLabel" style="width:100%" value="${flzw.NFlzyzsqk}"/></td>
	</tr>  -->
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