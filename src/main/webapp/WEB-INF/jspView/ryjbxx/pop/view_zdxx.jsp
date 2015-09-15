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
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly", "readonly");
		};
		
		$("#checkNum").change(function(){
					//检查必填项是否已经填写完整：true.填写完整 false.不完整
					if(!checkInteger($("#checkNum").val())){
						$(".J_dlg").html('<p>学制必须为正整数</p>').dialog({
							'buttons':{
								'确定':function(){
									$(".J_dlg").dialog("close");
								}
							}
						}).dialog("open");
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
<table id="zdxx_table" data-keyid="${zdxx.NId}" data-fydm="${zdxx.NFy}" data-rybh="${zdxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>在读学历：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmXl}" var="listDmXl">
						<option value="${listDmXl.NDm}" ${listDmXl.CMc==zdxx.NZdxl?'selected="selected"':"" }>${listDmXl.CMc }</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${zdxx.NZdxl }" />
			</div></td>
		<td class="odd_td"><span style="color:red">*</span>入学日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label keyValue" value="${zdxx.DRxrq }" /></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>在读院校：</td>
		<td class="even_td"><input type="text" class="myLabel keyValue"  value="${zdxx.CZdyx}"/></td>
		<td class="odd_td">在读专业：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZdzy}" var="listDmZdzy">
						<option value="${listDmZdzy.NDm}" ${listDmZdzy.CMc==zdxx.NSxzy?'selected="selected"':"" }>${listDmZdzy.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${zdxx.NSxzy }" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">专业：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${zdxx.CZdzy}"/></td>
	</tr>
	<tr style="height:20px">
		<td class="odd_td">教育形式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmJyxs}" var="listDmJyxs">
						<option value="${listDmJyxs.NDm}" ${listDmJyxs.CMc==zdxx.NJyxs?'selected="selected"':""}>${listDmJyxs.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${zdxx.NJyxs }" />
			</div></td>
		<td class="odd_td">学习形式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmXxxs}" var="listDmXxxs">
						<option value="${listDmXxxs.NDm}" ${listDmXxxs.CMc==zdxx.NXxxs?'selected="selected"':""}>${listDmXxxs.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${zdxx.NXxxs}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">学制：</td>
		<td class="even_td"><input type="text" id="checkNum" class="myLabel"  value="${zdxx.NXz }"/></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${zdxx.NDqxx=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${zdxx.NDqxx=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${zdxx.NDqxx }" />
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