<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	//检查时间格式
	function checkTime(str){
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	//检查为正整数
	function checkInteger(str){
		var reg = /^[0-9]*[1-9][0-9]*$/;
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
		
		$("#checkNum").change(function() {
			//检查必填项是否已经填写完整：true.填写完整 false.不完整
			if ($("#checkNum").val() != "") {
				if (!checkInteger($("#checkNum").val())) {
					$(".J_dlg").html('<p>学制必须为正整数</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}
		});

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
<table id="jtxx_table" data-keyid="${jtxx.NId}" data-fydm="${jtxx.NFy}" data-rybh="${jtxx.NRybh}">
	<tr>
		<td class="odd_td" ><span style="color:red">*</span>姓名：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue"  value="${jtxx.CXm}"/></td>
		<td class="odd_td" ><span style="color:red">*</span>与本人关系：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmJtgx}" var="listDmJtgx">
						<option value="${listDmJtgx.NDm}" ${listDmJtgx.CMc==jtxx.NYbrgx?'selected="selected"':"" }>${listDmJtgx.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jtxx.NYbrgx}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">出生日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label" value="${jtxx.DCsrq}" /></td>
		<td class="odd_td">政治面貌：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZzmm}" var="listDmZzmm">
						<option value="${listDmZzmm.NDm}" ${listDmZzmm.CMc==jtxx.NZzmm?'selected="selected"':""}>${listDmZzmm.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${jtxx.NZzmm}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">家庭电话：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${jtxx.CJtdh}"/></td>
		<td class="odd_td">邮政编码：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${jtxx.CYzbm}"/></td>
	</tr>
	<tr>
		<td class="odd_td">住房面积：</td>
		<td class="even_td"><input type="text" id="checkNum" class="myLabel"  value="${jtxx.NZfmj}"/></td>
		<td class="odd_td">家庭住址：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${jtxx.CJtzz}"/></td>
	</tr>
	<tr>
		<td class="odd_td">单位及职位：</td>
		<td class="even_td" colspan="3"><input type="text" class="myLabel" style="width:96%;margin-left:2px;"  value="${jtxx.CDwjzw}"/></td>
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