<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	function checkInteger(str) {
		var reg = /^[0-9]*[1-9][0-9]*$/;
		return reg.test(str);
	}
	$(function() {
		$type = "${btnType}";
		if ($type != 1) {
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
			$(".my_input_s,.myLabel").attr("readonly","readonly");
		}
		;

	});
</script>
<table id="khxx_table" data-keyid="${khxx.NId}" data-fydm="${khxx.NFy}"
	data-rybh="${khxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>年度：</td>
		<td class="even_td"><input type="text" id="checkNum"
			class="myLabel keyValue plxgUp" name="NNd" value="${khxx.NNd}" />
		</td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red"></span>考核结果：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NKhjg">
					<c:forEach items="${listDmKhjg}" var="listDmKhjg">
						<option value="${listDmKhjg.NDm}" ${listDmKhjg.CMc==khxx.NKhjg?
							'selected="selected"':""}>${listDmKhjg.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${khxx.NKhjg}" />
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