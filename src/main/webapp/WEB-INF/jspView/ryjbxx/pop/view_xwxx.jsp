<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	//检查时间格式
	function checkTime(str) {
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	//检查为正整数
	function checkInteger(str) {
		var reg = /^[0-9]*[1-9][0-9]*$/;
		return reg.test(str);
	}

	$(function() {
		$type = "${btnType}";
		if ($type != 1) {//0.添加 1.查看 2.修改
			$zdybq.changeDateFromLabelToPicker();
			$zdybq.changeFromLabelToInput();
			$zdybq.changeToSelect();
			$zdybq.changeAreaToEdit();
			$zdybq.updateKeyValue($type);

			$("#i_save").parent().show();
			$("#i_close").parent().prop("colspan", "2");
		} else {
			$(".my_input_s").css({
				"border" : "0px"
			});
			$(".my_input_s").show();
			$(".my_select_s").hide();
			$("#i_save").parent().hide();
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		}
		;

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
		$("#checkDate3").change(function() {
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
<table id="xwxx_table" data-keyid="${xwxx.NId}" data-fydm="${xwxx.NFy}"
	data-rybh="${xwxx.NRybh}">
	<tr style="height: 30px">
		<td class="odd_td"><span style="color:red">*</span>学位：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmXw}" var="listDmXw">
						<option value="${listDmXw.NDm}" ${listDmXw.CMc==xwxx.NXw?
							'selected="selected"':""}>${listDmXw.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${xwxx.NXw}" />
			</div>
		</td>
		<td class="odd_td"><span style="color:red">*</span>授予日期：</td>
		<td class="even_td"><input type="text" id="checkDate1"
			class="myDate_label keyValue" value="${xwxx.DSyrq}" />
		</td>
	</tr>
	<tr style="height: 30px">
		<td class="odd_td">所学专业：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmSxzy}" var="listDmSxzy">
						<option value="${listDmSxzy.NDm}" ${listDmSxzy.CMc==xwxx.NSxzy?
							'selected="selected"':""}>${listDmSxzy.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${xwxx.NSxzy}" />
			</div>
		</td>
		<td class="odd_td">专业：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${xwxx.CSxzy}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">学校名称：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${xwxx.CXxmc}" />
		</td>
		<td class="odd_td">学校类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmXxlb}" var="listDmXxlb">
						<option value="${listDmXxlb.NDm}" ${listDmXxlb.CMc==xwxx.NXxlb?
							'selected="selected"':""}>${listDmXxlb.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${xwxx.NXxlb}" />
			</div>
		</td>
	</tr>
	<tr style="height:30px">
		<td class="odd_td">教育形式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmJyxs}" var="listDmJyxs">
						<option value="${listDmJyxs.NDm}" ${listDmJyxs.CMc==xwxx.NJyxs?
							'selected="selected"':""}>${listDmJyxs.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${xwxx.NJyxs}" />
			</div>
		</td>
		<td class="odd_td">学习形式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmXxxs}" var="listDmXxxs">
						<option value="${listDmXxxs.NDm}" ${listDmXxxs.CMc==xwxx.NXxxs?
							'selected="selected"':""}>${listDmXxxs.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${xwxx.NXxxs}" />
			</div>
		</td>
	</tr>
	<tr>
		<td class="odd_td">入学日期：</td>
		<td class="even_td"><input type="text" id="checkDate2"
			class="myDate_label" value="${xwxx.DRxrq}" />
		</td>
		<td class="odd_td">毕业日期：</td>
		<td class="even_td"><input type="text" id="checkDate3"
			class="myDate_label" value="${xwxx.DByrq}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td">学制：</td>
		<td class="even_td"><input type="text" id="checkNum"
			class="myLabel" value="${xwxx.NXz}" />
		</td>
		<td class="odd_td">授予国家：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmSygj}" var="listDmSygj">
						<option value="${listDmSygj.NDm}" ${listDmSygj.CMc==xwxx.NSygj?
							'selected="selected"':""}>${listDmSygj.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${xwxx.NSygj}" />
			</div>
		</td>
	</tr>
	<tr>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${xwxx.NDqxx== "是"?'selected="selected"':"" }>是</option>
					<option value="2" ${xwxx.NDqxx== "否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${xwxx.NDqxx}" />
			</div>
		</td>
		<td class="odd_td">同步简历信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${xwxx.NTbjl== "是"?'selected="selected"':"" }>是</option>
					<option value="2" ${xwxx.NTbjl== "否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${xwxx.NTbjl}" />
			</div>
		</td>
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