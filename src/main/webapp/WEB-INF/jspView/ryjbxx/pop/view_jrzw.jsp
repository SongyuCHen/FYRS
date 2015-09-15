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
<table id="jrzw_table" data-keyid="${jrzw.NId}" data-fydm="${jrzw.NFy}" data-rybh="${jrzw.NRybh}">
	<tr style="height:25px">
		<td class="odd_td"><span style="color:red">*</span>任免类型：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmRmlb}" var="listDmRmlb">				
						<option value="${listDmRmlb.NDm}" ${listDmRmlb.CMc==jrzw.NRmlb?'selected="selected"':"" }>${listDmRmlb.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jrzw.NRmlb}" />
			</div></td>
		<td class="odd_td"><span style="color:red">*</span>兼任职务：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue" value="${jrzw.CJrzw}" /></td>
	</tr>
	<tr style="height:30px">
		<td class="odd_td">任免日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label" value="${jrzw.DRmrq}" /></td>
		<td class="odd_td">任免原因：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmRmyy}" var="listDmRmyy">
						<option value="${listDmRmyy.NDm}" ${listDmRmyy.CMc==jrzw.NRmyy?'selected="selected"':"" }>${listDmRmyy.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jrzw.NRmyy}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">单位：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${jrzw.CDw}" /></td>
		<td class="odd_td">部门：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${jrzw.CBm}" /></td>
	</tr>
	<tr>
		<td class="odd_td">批准日期：</td>
		<td class="even_td"><input type="text" id="checkDate2" class="myDate_label"
			value="${jrzw.DPzrq}" /></td>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${jrzw.CPzdw}" /></td>
	</tr>
	<tr>
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${jrzw.CPzwh}" /></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${jrzw.NDqxx=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${jrzw.NDqxx=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${jrzw.NDqxx}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">同步简历信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${jrzw.NTbjl=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${jrzw.NTbjl=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${jrzw.NTbjl}"/>
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