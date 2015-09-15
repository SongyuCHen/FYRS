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
	});
</script>
<table id="djxx_table" data-keyid="${djxx.NId}" data-fydm="${djxx.NFy}" data-rybh="${djxx.NRybh}">
	<tr style="height:30px">
		<td class="odd_td" style="font-weight:bold;"><span style="color:red">*</span>等级类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDjlb">
					<c:forEach items="${listDmDjlb}" var="listDmDjlb">
						<option value="${listDmDjlb.NDm}" ${listDmDjlb.CMc==djxx.NDjlb?'selected="selected"':"" }>${listDmDjlb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${djxx.NDjlb}"/></div></td>
		<td class="odd_td" style="font-weight:bold;"><span style="color:red">*</span>等级名称：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDjmc">
					<c:forEach items="${listDmDj}" var="listDmDj">
						<option value="${listDmDj.NDm}" ${listDmDj.CMc==djxx.NDjmc?'selected="selected"':"" }>${listDmDj.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${djxx.NDjmc}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td" style="font-weight:bold;">起算日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label plxgUp" name="DQsrq" value="${djxx.DQsrq}" /></td>
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzwh"  value="${djxx.CPzwh}"/></td>
	</tr>
	<tr style="height:30px">
		<td class="odd_td">变动类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NBdlb">
					<c:forEach items="${listDmDjbdlb}" var="listDmDjbdlb">
						<option value="${listDmDjbdlb.NDm}" ${listDmDjbdlb.CMc==djxx.NBdlb?'selected="selected"':""}>${listDmDjbdlb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${djxx.NBdlb}"/></div></td>
		<td class="odd_td">变动原因：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NBdyy">
					<c:forEach items="${listDmDjbdyy}" var="listDmDjbdyy">
						<option value="${listDmDjbdyy.NDm}" ${listDmDjbdyy.CMc==djxx.NBdyy?'selected="selected"':"" }>${listDmDjbdyy.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${djxx.NBdyy}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPzdw"  value="${djxx.CPzdw}"/></td>
		<td class="odd_td">证书编号：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CZsbh"  value="${djxx.CZsbh}"/></td>
	</tr>
	<tr>
		<td class="odd_td">变动依据：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CBdyj"  value="${djxx.CBdyj}"/></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDqxx">
					<option value="1" ${djxx.NDqxx=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${djxx.NDqxx=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${djxx.NDqxx}" />
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