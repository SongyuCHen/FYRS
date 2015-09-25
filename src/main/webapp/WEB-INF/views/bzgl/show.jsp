<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/jquery/ajaxfileupload.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/demo_table.css" />

<style type="text/css">
	.controllabel{
		display: inline-block;
		width: 90px;
		height: 24px;
		text-align:center;
		color: #166092;
		font-weight: 700;
	}
	.controllabel2{
		display: inline-block;
		width: 132px;
		height: 24px;
		text-align:right;
		color: #166092;
		font-weight: 700;
	}
	.controllabel3{
		display: inline-block;
		width: 90px;
		height: 24px;
		text-align:center;
		font-weight: 700;
	}
	.selectArea{
		display: inline-block;
		width: 150px;
	}
	#new_table td
	{
		border:1px solid;
		text-align:center;
		width:40px;
		height:40px;
	}
	.zy-input{
		height:40px;
		display:inline-block;
		padding:0;
		text-align:center;
		border-radius:1px;
	}
	.notshow{
		display:none;
	}
</style>

<script type="text/javascript">
$(function(){
	initTable("bzgl_list");
	$("#new_hdrq").datepicker();
	
	$("#importBg").live("click",function(){
		$("#newBg").dialog({
			modal:true,
			title:"导入核定编制变更",
			height:500,
			width:800
		});
	});
	
	$("#zy_zfzxbz_select").live("change",function(){
		var bg = $("#zy_zfzxbz_select option:selected").attr("value");
		if(bg==-1){
			$(".zy_zfzxbz_content").hide();
		}else{
			$(".zy_zfzxbz_content").show();
		}
	});
	
	$("#zy_sy_select").live("change",function(){
		var bg = $("#zy_sy_select option:selected").attr("value");
		if(bg==-1){
			$(".zy_sy_content").hide();
		}else{
			$(".zy_sy_content").show();
		}
	});
	
	$("#sheng_zfzxbz_select").live("change",function(){
		var bg = $("#sheng_zfzxbz_select option:selected").attr("value");
		if(bg==-1){
			$(".sheng_zfzxbz_content").hide();
		}else{
			$(".sheng_zfzxbz_content").show();
		}
	});
	
	$("#sheng_qe_select").live("change",function(){
		var bg = $("#sheng_qe_select option:selected").attr("value");
		if(bg==-1){
			$(".sheng_qe_content").hide();
		}else{
			$(".sheng_qe_content").show();
		}
	});
	
	$("#sheng_ce_select").live("change",function(){
		var bg = $("#sheng_ce_select option:selected").attr("value");
		if(bg==-1){
			$(".sheng_ce_content").hide();
		}else{
			$(".sheng_ce_content").show();
		}
	});
	
	$("#sheng_zczz_select").live("change",function(){
		var bg = $("#sheng_zczz_select option:selected").attr("value");
		if(bg==-1){
			$(".sheng_zczz_content").hide();
		}else{
			$(".sheng_zczz_content").show();
		}
	});
	
	$("#sheng_fs_select").live("change",function(){
		var bg = $("#sheng_fs_select option:selected").attr("value");
		if(bg==-1){
			$(".sheng_fs_content").hide();
		}else{
			$(".sheng_fs_content").show();
		}
	});
	
	$("#shi_zfzxbz_select").live("change",function(){
		var bg = $("#shi_zfzxbz_select option:selected").attr("value");
		if(bg==-1){
			$(".shi_zfzxbz_content").hide();
		}else{
			$(".shi_zfzxbz_content").show();
		}
	});
	
	$("#shi_qe_select").live("change",function(){
		var bg = $("#shi_qe_select option:selected").attr("value");
		if(bg==-1){
			$(".shi_qe_content").hide();
		}else{
			$(".shi_qe_content").show();
		}
	});
	
	$("#shi_ce_select").live("change",function(){
		var bg = $("#shi_ce_select option:selected").attr("value");
		if(bg==-1){
			$(".shi_ce_content").hide();
		}else{
			$(".shi_ce_content").show();
		}
	});
	
	$("#shi_zczz_select").live("change",function(){
		var bg = $("#shi_zczz_select option:selected").attr("value");
		if(bg==-1){
			$(".shi_zczz_content").hide();
		}else{
			$(".shi_zczz_content").show();
		}
	});
	
	$("#shi_fs_select").live("change",function(){
		var bg = $("#shi_fs_select option:selected").attr("value");
		if(bg==-1){
			$(".shi_fs_content").hide();
		}else{
			$(".shi_fs_content").show();
		}
	});
	
	$("#dialog_close").live("click",function(){
		$("#newBg").dialog("close");
		clear();
	});
	
	$("#dialog_save").live("click",function(){
		//中央政法编制
		var zy_zfzxbz_bmld_zz = "";
		var zy_zfzxbz_bmld_fz = "";
		var zy_zfzxbz_bmld_qt = "";
		var zy_zfzxbz_bmld_qt_mx = "";
		var zy_zfzxbz_nsjgld_zz_fc = "";
		var zy_zfzxbz_nsjgld_zz_zk = "";
		var zy_zfzxbz_nsjgld_fz_zk = "";
		var zy_zfzxbz_nsjgld_fz_fk = "";
		var zy_zfzxbz_nsjgld_qt = "";
		var zy_zfzxbz_nsjgld_qt_mx = "";
		var zy_zfzxbz_dyy = "";
		var zy_zfzxbz_fdyy = "";
		var zy_zfzxbz_zrky = "";
		var zy_zfzxbz_fzrky = "";
		var zy_zfzxbz_kybsy = "";
		var zy_zfzxbz_bhyy = "";
		var zy_zfzxbz_bz = "";
		//中央事业编制
		var zy_sy_kbs = "";
		var zy_sy_bhyy = "";
		var zy_sy_bz = "";
		//省定政法专项编制
		var sheng_zfzxbz_kbs = "";
		var sheng_zfzxbz_bhyy = "";
		var sheng_zfzxbz_bz = "";
		//省定事业全额编制
		var sheng_qe_kbs = "";
		var sheng_qe_bhyy = "";
		var sheng_qe_bz = "";
		//省定事业差额编制
		var sheng_ce_kbs = "";
		var sheng_ce_bhyy = "";
		var sheng_ce_bz = "";
		//省定事业自筹自支编制
		var sheng_zczz_kbs = "";
		var sheng_zczz_bhyy = "";
		var sheng_zczz_bz = "";
		//省定附属编制
		var sheng_fs_kbs = "";
		var sheng_fs_bhyy = "";
		var sheng_fs_bz = "";
		//市定政法专项编制
		var shi_zfzxbz_kbs = "";
		var shi_zfzxbz_bhyy = "";
		var shi_zfzxbz_bz = "";
		//市定事业全额编制
		var shi_qe_kbs = "";
		var shi_qe_bhyy = "";
		var shi_qe_bz = "";
		//市定事业差额编制
		var shi_ce_kbs = "";
		var shi_ce_bhyy = "";
		var shi_ce_bz = "";
		//市定事业自筹自支编制
		var shi_zczz_kbs = "";
		var shi_zczz_bhyy = "";
		var shi_zczz_bz = "";
		//市定附属编制
		var shi_fs_kbs = "";
		var shi_fs_bhyy = "";
		var shi_fs_bz = "";
		
		var pzwh=$("#new_pzwh").val();
		if(pzwh==""){
			alert("批准文号不能为空！");
			return;
		}
		var hdrq=$("#new_hdrq").val();
		if(hdrq==""){
			alert("核定日期不能为空！");
			return;
		}
		
		var zy_zfzxbz_change=$("#zy_zfzxbz_select option:selected").attr("value");
		var zy_sy_change=$("#zy_sy_select option:selected").attr("value");
		var sheng_zfzxbz_change=$("#sheng_zfzxbz_select option:selected").attr("value");
		var sheng_qe_change=$("#sheng_qe_select option:selected").attr("value");
		var sheng_ce_change=$("#sheng_ce_select option:selected").attr("value");
		var sheng_zczz_change=$("#sheng_zczz_select option:selected").attr("value");
		var sheng_fs_change=$("#sheng_fs_select option:selected").attr("value");
		var shi_zfzxbz_change=$("#shi_zfzxbz_select option:selected").attr("value");
		var shi_qe_change=$("#shi_qe_select option:selected").attr("value");
		var shi_ce_change=$("#shi_ce_select option:selected").attr("value");
		var shi_zczz_change=$("#shi_zczz_select option:selected").attr("value");
		var shi_fs_change=$("#shi_fs_select option:selected").attr("value");
		if(zy_zfzxbz_change==-1&&zy_sy_change==-1&&sheng_zfzxbz_change==-1&&sheng_qe_change==-1&&sheng_ce_change==-1
				&&sheng_zczz_change==-1&&sheng_fs_change==-1&&shi_zfzxbz_change==-1&&shi_qe_change==-1&&shi_ce_change==-1
				&&shi_zczz_change==-1&&shi_fs_change==-1){
			alert("核定编制未发生变化，请至少改变一个编制信息！");
			return;
		}
		
		if(zy_zfzxbz_change==1){//中央政法编制
			zy_zfzxbz_bmld_zz=$("#zy_zfzxbz_bmld_zz").val();
			if(zy_zfzxbz_bmld_zz==""||isNaN(zy_zfzxbz_bmld_zz)||zy_zfzxbz_bmld_zz<0){
				alert("请正确输入 中央政法专项编制-部门领导职数-正职");
				return;
			}
			zy_zfzxbz_bmld_fz=$("#zy_zfzxbz_bmld_fz").val();
			if(zy_zfzxbz_bmld_fz==""||isNaN(zy_zfzxbz_bmld_fz)||zy_zfzxbz_bmld_fz<0){
				alert("请正确输入 中央政法专项编制-部门领导职数-副职");
				return;
			}
			zy_zfzxbz_bmld_qt=$("#zy_zfzxbz_bmld_qt").val();
			if(zy_zfzxbz_bmld_qt==""||isNaN(zy_zfzxbz_bmld_qt)||zy_zfzxbz_bmld_qt<0){
				alert("请正确输入 中央政法专项编制-部门领导职数-其他-核定数");
				return;
			}
			zy_zfzxbz_bmld_qt_mx=$("#zy_zfzxbz_bmld_qt_mx").val();
			
			zy_zfzxbz_nsjgld_zz_fc=$("#zy_zfzxbz_nsjgld_zz_fc").val();
			if(zy_zfzxbz_nsjgld_zz_fc==""||isNaN(zy_zfzxbz_nsjgld_zz_fc)||zy_zfzxbz_nsjgld_zz_fc<0){
				alert("请正确输入 中央政法专项编制-内设机构领导职数-内设机构正职-副处级");
				return;
			}
			zy_zfzxbz_nsjgld_zz_zk=$("#zy_zfzxbz_nsjgld_zz_zk").val();
			if(zy_zfzxbz_nsjgld_zz_zk==""||isNaN(zy_zfzxbz_nsjgld_zz_zk)||zy_zfzxbz_nsjgld_zz_zk<0){
				alert("请正确输入 中央政法专项编制-内设机构领导职数-内设机构正职-正科级");
				return;
			}
			zy_zfzxbz_nsjgld_fz_zk=$("#zy_zfzxbz_nsjgld_fz_zk").val();
			if(zy_zfzxbz_nsjgld_fz_zk==""||isNaN(zy_zfzxbz_nsjgld_fz_zk)||zy_zfzxbz_nsjgld_fz_zk<0){
				alert("请正确输入 中央政法专项编制-内设机构领导职数-内设机构副职-正科级");
				return;
			}
			zy_zfzxbz_nsjgld_fz_fk=$("#zy_zfzxbz_nsjgld_fz_fk").val();
			if(zy_zfzxbz_nsjgld_fz_fk==""||isNaN(zy_zfzxbz_nsjgld_fz_fk)||zy_zfzxbz_nsjgld_fz_fk<0){
				alert("请正确输入 中央政法专项编制-内设机构领导职数-内设机构副职-副科级");
				return;
			}
			zy_zfzxbz_nsjgld_qt=$("#zy_zfzxbz_nsjgld_qt").val();
			if(zy_zfzxbz_nsjgld_qt==""||isNaN(zy_zfzxbz_nsjgld_qt)||zy_zfzxbz_nsjgld_qt<0){
				alert("请正确输入 中央政法专项编制-内设机构领导职数-其他-核定数");
				return;
			}
			zy_zfzxbz_nsjgld_qt_mx=$("#zy_zfzxbz_nsjgld_qt_mx").val();
			
			zy_zfzxbz_dyy=$("#zy_zfzxbz_dyy").val();
			if(zy_zfzxbz_dyy==""||isNaN(zy_zfzxbz_dyy)||zy_zfzxbz_dyy<0){
				alert("请正确输入 中央政法专项编制-非领导职数-调研员");
				return;
			}
			zy_zfzxbz_fdyy=$("#zy_zfzxbz_fdyy").val();
			if(zy_zfzxbz_fdyy==""||isNaN(zy_zfzxbz_fdyy)||zy_zfzxbz_fdyy<0){
				alert("请正确输入 中央政法专项编制-非领导职数-副调研员");
				return;
			}
			zy_zfzxbz_zrky=$("#zy_zfzxbz_zrky").val();
			if(zy_zfzxbz_zrky==""||isNaN(zy_zfzxbz_zrky)||zy_zfzxbz_zrky<0){
				alert("请正确输入 中央政法专项编制-非领导职数-主任科员");
				return;
			}
			zy_zfzxbz_fzrky=$("#zy_zfzxbz_fzrky").val();
			if(zy_zfzxbz_fzrky==""||isNaN(zy_zfzxbz_fzrky)||zy_zfzxbz_fzrky<0){
				alert("请正确输入 中央政法专项编制-非领导职数-副主任科员");
				return;
			}
			zy_zfzxbz_kybsy=$("#zy_zfzxbz_kybsy").val();
			if(zy_zfzxbz_kybsy==""||isNaN(zy_zfzxbz_kybsy)||zy_zfzxbz_kybsy<0){
				alert("请正确输入 中央政法专项编制-科员及办事员");
				return;
			}
			zy_zfzxbz_bhyy=$("#zy_zfzxbz_bhyy").val();
			
			zy_zfzxbz_bz=$("#zy_zfzxbz_bz").val();
			
		}
		
		if(zy_sy_change==1){//中央事业编制
			zy_sy_kbs=$("#zy_sy_kbs").val();
			if(zy_sy_kbs==""||isNaN(zy_sy_kbs)||zy_sy_kbs<0){
				alert("请正确输入 中央事业编制-核定数");
				return;
			}
			zy_sy_bhyy=$("#zy_sy_bhyy").val();
			zy_sy_bz=$("#zy_sy_bz").val();
		}
		
		if(sheng_zfzxbz_change==1){//省定政法专项编制
			sheng_zfzxbz_kbs=$("#sheng_zfzxbz_kbs").val();
			if(sheng_zfzxbz_kbs==""||isNaN(sheng_zfzxbz_kbs)||sheng_zfzxbz_kbs<0){
				alert("请正确输入 省定政法专项编制-核定数");
				return;
			}
			sheng_zfzxbz_bhyy=$("#sheng_zfzxbz_bhyy").val();
			sheng_zfzxbz_bz=$("#sheng_zfzxbz_bz").val();
		}
		
		if(sheng_qe_change==1){//省定事业全额编制
			sheng_qe_kbs=$("#sheng_qe_kbs").val();
			if(sheng_qe_kbs==""||isNaN(sheng_qe_kbs)||sheng_qe_kbs<0){
				alert("请正确输入 省定事业全额编制-核定数");
				return;
			}
			sheng_qe_bhyy=$("#sheng_qe_bhyy").val();
			sheng_qe_bz=$("#sheng_qe_bz").val();
		}
		
		if(sheng_ce_change==1){//省定事业差额编制
			sheng_ce_kbs=$("#sheng_ce_kbs").val();
			if(sheng_ce_kbs==""||isNaN(sheng_ce_kbs)||sheng_ce_kbs<0){
				alert("请正确输入 省定事业差额编制-核定数");
				return;
			}
			sheng_ce_bhyy=$("#sheng_ce_bhyy").val();
			sheng_ce_bz=$("#sheng_ce_bz").val();
		}
		
		if(sheng_zczz_change==1){//省定事业自筹自支编制
			sheng_zczz_kbs=$("#sheng_zczz_kbs").val();
			if(sheng_zczz_kbs==""||isNaN(sheng_zczz_kbs)||sheng_zczz_kbs<0){
				alert("请正确输入 省定事业自筹自支编制-核定数");
				return;
			}
			sheng_zczz_bhyy=$("#sheng_zczz_bhyy").val();
			sheng_zczz_bz=$("#sheng_zczz_bz").val();
		}
		
		if(sheng_fs_change==1){//省定附属编制
			sheng_fs_kbs=$("#sheng_fs_kbs").val();
			if(sheng_fs_kbs==""||isNaN(sheng_fs_kbs)||sheng_fs_kbs<0){
				alert("请正确输入 省定附属编制-核定数");
				return;
			}
			sheng_fs_bhyy=$("#sheng_fs_bhyy").val();
			sheng_fs_bz=$("#sheng_fs_bz").val();
		}
		
		if(shi_zfzxbz_change==1){//市定政法专项编制
			shi_zfzxbz_kbs=$("#shi_zfzxbz_kbs").val();
			if(shi_zfzxbz_kbs==""||isNaN(shi_zfzxbz_kbs)||shi_zfzxbz_kbs<0){
				alert("请正确输入 市定政法专项编制-核定数");
				return;
			}
			shi_zfzxbz_bhyy=$("#shi_zfzxbz_bhyy").val();
			shi_zfzxbz_bz=$("#shi_zfzxbz_bz").val();
		}
		
		if(shi_qe_change==1){//市定事业全额编制
			shi_qe_kbs=$("#shi_qe_kbs").val();
			if(shi_qe_kbs==""||isNaN(shi_qe_kbs)||shi_qe_kbs<0){
				alert("请正确输入 市定事业全额编制-核定数");
				return;
			}
			shi_qe_bhyy=$("#shi_qe_bhyy").val();
			shi_qe_bz=$("#shi_qe_bz").val();
		}
		
		if(shi_ce_change==1){//市定事业差额编制
			shi_ce_kbs=$("#shi_ce_kbs").val();
			if(shi_ce_kbs==""||isNaN(shi_ce_kbs)||shi_ce_kbs<0){
				alert("请正确输入 市定事业差额编制-核定数");
				return;
			}
			shi_ce_bhyy=$("#shi_ce_bhyy").val();
			shi_ce_bz=$("#shi_ce_bz").val();
		}
		
		if(shi_zczz_change==1){//市定事业自筹自支编制
			shi_zczz_kbs=$("#shi_zczz_kbs").val();
			if(shi_zczz_kbs==""||isNaN(shi_zczz_kbs)||shi_zczz_kbs<0){
				alert("请正确输入 市定事业自筹自支编制-核定数");
				return;
			}
			shi_zczz_bhyy=$("#shi_zczz_bhyy").val();
			shi_zczz_bz=$("#shi_zczz_bz").val();
		}
		
		if(shi_fs_change==1){//市定附属编制
			shi_fs_kbs=$("#shi_fs_kbs").val();
			if(shi_fs_kbs==""||isNaN(shi_fs_kbs)||shi_fs_kbs<0){
				alert("请正确输入 市定附属编制-核定数");
				return;
			}
			shi_fs_bhyy=$("#shi_fs_bhyy").val();
			shi_fs_bz=$("#shi_fs_bz").val();
		}
		
		var bg={
				pzwh : pzwh,
				hdrq : hdrq,
				zy_zfzxbz_bmld_zz : zy_zfzxbz_bmld_zz,
				zy_zfzxbz_bmld_fz : zy_zfzxbz_bmld_fz,
				zy_zfzxbz_bmld_qt : zy_zfzxbz_bmld_qt,
				zy_zfzxbz_bmld_qt_mx : zy_zfzxbz_bmld_qt_mx,
				zy_zfzxbz_nsjgld_zz_fc : zy_zfzxbz_nsjgld_zz_fc,
				zy_zfzxbz_nsjgld_zz_zk : zy_zfzxbz_nsjgld_zz_zk,
				zy_zfzxbz_nsjgld_fz_zk : zy_zfzxbz_nsjgld_fz_zk,
				zy_zfzxbz_nsjgld_fz_fk : zy_zfzxbz_nsjgld_fz_fk,
				zy_zfzxbz_nsjgld_qt : zy_zfzxbz_nsjgld_qt,
				zy_zfzxbz_nsjgld_qt_mx : zy_zfzxbz_nsjgld_qt_mx,
				zy_zfzxbz_dyy : zy_zfzxbz_dyy,
				zy_zfzxbz_fdyy : zy_zfzxbz_fdyy,
				zy_zfzxbz_zrky : zy_zfzxbz_zrky,
				zy_zfzxbz_fzrky : zy_zfzxbz_fzrky,
				zy_zfzxbz_kybsy : zy_zfzxbz_kybsy,
				zy_zfzxbz_bhyy : zy_zfzxbz_bhyy,
				zy_zfzxbz_bz : zy_zfzxbz_bz,
				
				zy_sy_kbs : zy_sy_kbs,
				zy_sy_bhyy : zy_sy_bhyy,
				zy_sy_bz : zy_sy_bz,
				
				sheng_zfzxbz_kbs : sheng_zfzxbz_kbs,
				sheng_zfzxbz_bhyy : sheng_zfzxbz_bhyy,
				sheng_zfzxbz_bz : sheng_zfzxbz_bz,
				
				sheng_qe_kbs : sheng_qe_kbs,
				sheng_qe_bhyy : sheng_qe_bhyy,
				sheng_qe_bz : sheng_qe_bz,
				
				sheng_ce_kbs : sheng_ce_kbs,
				sheng_ce_bhyy : sheng_ce_bhyy,
				sheng_ce_bz : sheng_ce_bz,
				
				sheng_zczz_kbs : sheng_zczz_kbs,
				sheng_zczz_bhyy : sheng_zczz_bhyy,
				sheng_zczz_bz : sheng_zczz_bz,
				
				sheng_fs_kbs : sheng_fs_kbs,
				sheng_fs_bhyy : sheng_fs_bhyy,
				sheng_fs_bz : sheng_fs_bz,
				
				shi_zfzxbz_kbs : shi_zfzxbz_kbs,
				shi_zfzxbz_bhyy : shi_zfzxbz_bhyy,
				shi_zfzxbz_bz : shi_zfzxbz_bz,
				
				shi_qe_kbs : shi_qe_kbs,
				shi_qe_bhyy : shi_qe_bhyy,
				shi_qe_bz : shi_qe_bz,
				
				shi_ce_kbs : shi_ce_kbs,
				shi_ce_bhyy : shi_ce_bhyy,
				shi_ce_bz : shi_ce_bz,
				
				shi_zczz_kbs : shi_zczz_kbs,
				shi_zczz_bhyy : shi_zczz_bhyy,
				shi_zczz_bz : shi_zczz_bz,
				
				shi_fs_kbs : shi_fs_kbs,
				shi_fs_bhyy : shi_fs_bhyy,
				shi_fs_bz : shi_fs_bz
		};
		
		$.ajaxFileUpload({
			url : "/main/cxtj/saveHdbzBg.aj",
			fileElementId : "upload_file",
			dataType : "json",
			type : 'post',
			data : bg,
			success : function(data){
				if(data){
					alert("保存成功！");
					$("#newBg").dialog("close");
					clear();
				}else{
					alert("出错，请重试！");
				}
			}
		});
	});
	
	function clear(){
		$("#newBg input").val("");
		$("#newBg select").val("-1");
		$("#newBg .notshow").hide();
	}
});
	  
var initTable = function(dataTableId){
   	  $roles_oTable=$("#"+dataTableId+" .dataTable").dataTable({
   		'iDisplayLength' : 10,
   		"sPaginationType" : "full_numbers",
 		'bFilter' : false,
        'bSort' : false,
        'bLengthChange' : false,
 		'oLanguage' : {
 			"sProcessing" : "处理中...",
 			"sLengthMenu" : "显示 _MENU_ 项结果",
 			"sZeroRecords" : "没有匹配结果",
 			"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
 			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
 			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
 			"sInfoPostFix" : "",
 			"sSearch" : "搜索:",
 			"sUrl" : "",
 			"oPaginate" : {
 				"sFirst" : "首页",
 				"sPrevious" : "上页",
 				"sNext" : "下页",
 				"sLast" : "末页"
 			}
 		},
		'bSortClasses' : false,
		'bRetrieve':true,
		'bDestory':true
	});
};
</script>
</head>
<body>
	<div style="float:right;">
		<button type="button" id="importBg" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>导入核定编制变更
		</button>
	</div>
	<div id="bzgl_list">
		<table id="dataTable" data-maxindex="" class="dataTable cell-border" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th width="200px">统计表编号</th>
					<th>统计表名称</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td><a href="bzbh.do" target="_blank">人员编制变化情况登记表</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td><a href="bzsq.do" target="_blank">编制使用情况申请表</a></td>
				</tr>
				<tr>
					<td>3</td>
					<td><a href="bzjg.do" target="_blank">核定编制及人员结构登记表</a></td>
				</tr>
				<tr>
					<td>4</td>
					<td><a href="bzbgjl1.do" target="_blank">人员增减事项及人员结构变更记录(一)</a></td>
				</tr>
				<tr>
					<td>5</td>
					<td><a href="bzbgjl2.do" target="_blank">人员增减事项及人员结构变更记录(二)</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="newBg" style="display:none;font-size:12px;">
		<div class="form-group" style="margin-top:10px;">
			<label class="controllabel">批准文号：</label>
			<div style="display:inline-block;width:200px;">
				<input id="new_pzwh" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<input type="file" id="upload_file" name="file">
			<label class="controllabel">核定日期：</label>
			<div style="display:inline-block;">
				<input id="new_hdrq" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">中央政法专项编制：</label>
			<div class="selectArea">
				<select id="zy_zfzxbz_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group zy_zfzxbz_content notshow">
			<table id="new_table" align="center" style="border:2px solid;">
		  		<tr>
		  			<td colspan=4>部门领导职数</td>
		  			<td colspan=6>内设机构领导职数</td>
		  			<td colspan=4>非领导职数</td>
		  			<td rowspan=3>科员及办事员</td>
		  		</tr>
		  		<tr>
		  			<td rowspan=2>正职</td>
		  			<td rowspan=2>副职</td>
		  			<td colspan=2>其他</td>
		  			<td colspan=2>内设机构正职</td>
		  			<td colspan=2>内设机构副职</td>
		  			<td colspan=2>其他</td>
		  			<td rowspan=2>调研员</td>
		  			<td rowspan=2>副调研员</td>
		  			<td rowspan=2>主任科员</td>
		  			<td rowspan=2>副主任科员</td>
		  		</tr>
		  		<tr>
		  			<td>核定数</td>
		  			<td style="width:110px;">明细内容</td>
		  			<td>副处级</td>
		  			<td>正科级</td>
		  			<td>正科级</td>
		  			<td>副科级</td>
		  			<td>核定数</td>
		  			<td style="width:110px;">明细内容</td>
		  		</tr>
		  		<tr>
		  			<td><input id="zy_zfzxbz_bmld_zz" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_bmld_fz" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_bmld_qt" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_bmld_qt_mx" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_zz_fc" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_zz_zk" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_fz_zk" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_fz_fk" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_qt" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_nsjgld_qt_mx" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_dyy" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_fdyy" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_zrky" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_fzrky" type="text" class="input-sm form-control zy-input"/></td>
		  			<td><input id="zy_zfzxbz_kybsy" type="text" class="input-sm form-control zy-input"/></td>
		  		</tr>
	  		</table>
  		</div>
  		<div class="form-group zy_zfzxbz_content notshow">
  			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:200px;">
				<input id="zy_zfzxbz_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:200px;">
				<input id="zy_zfzxbz_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
  		</div>
		<div class="form-group">
			<label class="controllabel2">中央事业编制：</label>
			<div class="selectArea">
				<select id="zy_sy_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group zy_sy_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="zy_sy_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="zy_sy_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="zy_sy_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">省定政法专项编制：</label>
			<div class="selectArea">
				<select id="sheng_zfzxbz_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group sheng_zfzxbz_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="sheng_zfzxbz_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_zfzxbz_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_zfzxbz_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">省定事业全额编制：</label>
			<div class="selectArea">
				<select id="sheng_qe_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group sheng_qe_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="sheng_qe_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_qe_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_qe_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">省定事业差额编制：</label>
			<div class="selectArea">
				<select id="sheng_ce_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group sheng_ce_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="sheng_ce_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_ce_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_ce_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">省定事业自筹自支编制：</label>
			<div class="selectArea">
				<select id="sheng_zczz_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group sheng_zczz_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="sheng_zczz_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_zczz_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_zczz_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">省定附属编制：</label>
			<div class="selectArea">
				<select id="sheng_fs_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group sheng_fs_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="sheng_fs_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_fs_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="sheng_fs_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">市定政法专项编制：</label>
			<div class="selectArea">
				<select id="shi_zfzxbz_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group shi_zfzxbz_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="shi_zfzxbz_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_zfzxbz_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_zfzxbz_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">市定事业全额编制：</label>
			<div class="selectArea">
				<select id="shi_qe_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group shi_qe_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="shi_qe_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_qe_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_qe_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">市定事业差额编制：</label>
			<div class="selectArea">
				<select id="shi_ce_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group shi_ce_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="shi_ce_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_ce_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_ce_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">市定事业自筹自支编制：</label>
			<div class="selectArea">
				<select id="shi_zczz_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group shi_zczz_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="shi_zczz_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_zczz_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_zczz_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group">
			<label class="controllabel2">市定附属编制：</label>
			<div class="selectArea">
				<select id="shi_fs_select" class="input-sm form-control" style="display:inline-block;">
					<option value="-1">不作变更</option>
					<option value="1">变更</option>
				</select>
			</div>
		</div>
		<div class="form-group shi_fs_content notshow">
			<label class="controllabel3">核定数：</label>
  			<div style="display:inline-block;width:40px;">
				<input id="shi_fs_kbs" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">变化原因：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_fs_bhyy" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
			<label class="controllabel3">备注：</label>
  			<div style="display:inline-block;width:180px;">
				<input id="shi_fs_bz" type="text" class="input-sm form-control" style="display:inline-block;"/>
			</div>
		</div>
		<div class="form-group" style="text-align:center;">
			<button type="button" id="dialog_save" class="btn btn-primary" style="width:70px;margin-right:20px;">保&nbsp;存</button>
			<button type="button" id="dialog_close" class="btn btn-primary" style="width:70px;">关&nbsp;闭</button>
		</div>
	</div>
</body>
</html>
