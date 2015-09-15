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
		};
	});
</script>
<table id="zjxx_table"  data-keyid="${zjxx.NId}" data-fydm="${zjxx.NFy}"
	data-rybh="${zjxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>任免类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s keyValue">
					<c:forEach items="${listDmRmlb}" var="listDmRmlb">
						<option value="${listDmRmlb.NDm}" ${listDmRmlb.CMc==zjxx.NRmlb?
							'selected="selected"':""}>${listDmRmlb.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${zjxx.NRmlb}" />
			</div></td>
		<td class="odd_td"><span style="color:red">*</span>职级：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s keyValue">
					<c:forEach items="${listDmZj}" var="listDmZj">
						<option value="${listDmZj.NDm}" ${listDmZj.CMc==zjxx.NZj?
							'selected="selected"':""}>${listDmZj.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${zjxx.NZj}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td" style="font-weight:bold;">任免日期：</td>
		<td class="even_td"><input type="text" class="myDate_label" id="checkDate1" value="${zjxx.DRmrq}" /></td>
		<td class="odd_td">职级性质：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s keyValue">
					<c:forEach items="${listDmZjxz}" var="listDmZjxz">
						<option value="${listDmZjxz.NDm}" ${listDmZjxz.CMc==zjxx.NZjxz?
							'selected="selected"':""}>${listDmZjxz.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${zjxx.NZjxz}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">单位：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${zjxx.CDw}"/></td>
		<td class="odd_td">部门：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${zjxx.CBm}"/></td>
		
	</tr>
	<tr>
		<td class="odd_td">任免原因：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s keyValue">
					<c:forEach items="${listDmRmyy}" var="listDmRmyy">
						<option value="${listDmRmyy.NDm}" ${listDmRmyy.CMc==zjxx.NRmyy?
							'selected="selected"':""}>${listDmRmyy.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${zjxx.NRmyy}" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">批准日期：</td>
		<td class="even_td"><input type="text" class="myDate_label" value="${zjxx.DPzrq}" /></td>
		<td class="odd_td">批准单位：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${zjxx.CPzdw}"/></td>
	</tr>
	<tr>
		<td class="odd_td">批准文号：</td>
		<td class="even_td"><input type="text" class="myLabel"  value="${zjxx.CPzwh}"/></td>
		<td class="odd_td">当前信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s keyValue">
					<c:forEach items="${listDmSf}" var="listDmSf">
						<option value="${listDmSf.NDm}" ${listDmSf.CMc==zjxx.NDqxx?
							'selected="selected"':""}>${listDmSf.CMc}</option>
					</c:forEach>
				</select><input type="text" class="my_input_s" value="${zjxx.NDqxx}" />
			</div></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center"><input id="i_save" type="button" value="保存" class="btn" data-type="${btnType}" /></td>
		<td colspan="4" style="text-align:center"><input id="i_close" type="button" value="关闭" class="btn" /></td>
	</tr>
</table>