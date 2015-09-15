<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="../../resources/js/zdybq.js"></script>
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
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		};
	});
</script>
<table id="htxx_table" data-keyid="${htxx.NId}" data-fydm="${htxx.NFy}" data-rybh="${htxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>合同编号：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CHtbh"  value="${htxx.CHtbh}"/></td>
		<td class="odd_td">签订时间：</td>
		<td class="even_td"><input type="text" class="myDate_label plxgUp" id="checkDate1" name="DQdrq"  value="${htxx.DQdrq}"/></td>
	</tr>
	
	<tr>
		<td class="odd_td"><span style="color:red">*</span>合同期限：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CHtqx"  value="${htxx.CHtqx}"/></td>
		<td class="odd_td">聘任职位：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmzwlx}" var="listDmzwlx">
						<option value="${listDmzwlx.NDm}" ${listDmzwlx.CMc==htxx.CPrzw?
							'selected="selected"':""}>${listDmzwlx.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${htxx.CPrzw}" />
			</div></td>
		
	<!--  	<input type="text" class="myLabel plxgUp" name="CPrzw"  value="${htxx.CPrzw}"/></td> -->
	</tr>
		
	<tr>
		<td class="odd_td">备注：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CBz"  value="${htxx.CBz}"/></td>
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