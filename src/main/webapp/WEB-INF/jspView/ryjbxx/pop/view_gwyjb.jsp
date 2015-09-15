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
	});
</script>
<table id="gwyjb_table" data-keyid="${gwyjb.NId}" data-fydm="${gwyjb.NFy}" data-rybh="${gwyjb.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>公务员级别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NGwyjb">
					<c:forEach items="${listDmGwyjb}" var="listDmGwyjb">
						<option value="${listDmGwyjb.NDm}" ${listDmGwyjb.CMc==gwyjb.NGwyjb?'selected="selected"':"" }>${listDmGwyjb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${gwyjb.NGwyjb}"/></div></td>
		<td class="odd_td">起算日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label plxgUp" name="DQsrq" value="${gwyjb.DQsrq}" /></td>
	</tr>
	<tr>
		<td class="odd_td">单位：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CDw"  value="${gwyjb.CDw}"/></td>
		<td class="odd_td">工资档次：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NGzdc">
					<c:forEach items="${listDmGzdc}" var="listDmGzdc">
						<option value="${listDmGzdc.NDm}" ${listDmGzdc.CMc==gwyjb.NGzdc?'selected="selected"':"" }>${listDmGzdc.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s"  value="${gwyjb.NGzdc}"/></div></td>
	</tr>
	<tr>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NDqxx">
					<option value="1" ${gwyjb.NDqxx=="是"?'selected="selected"':""}>是</option>
					<option value="2" ${gwyjb.NDqxx=="否"?'selected="selected"':""}>否</option>
				</select> <input type="text" class="my_input_s" value="${gwyjb.NDqxx}" />
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