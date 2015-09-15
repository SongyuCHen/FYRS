<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
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
			$(".my_input_s,.myLabel").attr("readonly","readonly");
		};
	});
</script>
<table id="ldbz_table" data-keyid="${ldbz.NId}" data-fydm="${ldbz.NFy}" data-rybh="${ldbz.NRybh}">
	<tr>
		<td class="odd_td">前工作单位：</td>
		<td class="even_td"><input type="text" class="myLabel" value="${ldbz.CQgzdw}" /></td>
		<td class="odd_td">前工作部门：</td>
		<td class="even_td"><input type="text" class="myLabel"
			value="${ldbz.CQgzbm}" /></td>
	</tr>
	<tr>
		<td class="odd_td">职务：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmZw}" var="listDmZw">
						<option value="${listDmZw.NDm}" ${listDmZw.CMc==ldbz.NZw?'selected="selected"':"" }>${listDmZw.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${ldbz.NZw}" />
			</div></td>
		<td class="odd_td">是否参加考察：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${ldbz.NCjkc=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${ldbz.NCjkc=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${ldbz.NCjkc}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td" colspan="2">拟任前是否征求上级法院党组意见：</td>
		<td class="even_td" colspan="2"><div class="mySelect">
				<select class="my_select_s">
					<option value="1" ${ldbz.NZqdzyj=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${ldbz.NZqdzyj=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${ldbz.NZqdzyj }" />
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