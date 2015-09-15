/*閼奉亜鐣炬稊澶嬬垼缁涳拷*/
$(function(){
	$zdybq={};
	$zdybq.initialize=function(){
		$(".myLabel").prop("disabled",true);
		$(".my_input_s,.my_select_s").css({"width":"100%","height":"100%"});
		$(".my_input_s").prop({"disabled":true,});
		$(".myDate_label").prop({"disabled":true,});
		$(".myArea_read").prop({"disabled":true,});
		$(".myText").children(".my_input_s").css("z-index","1");
		
		$("#i_save").parent().hide();
	};
	/*$(".my_select_s").live("change",function(){
		console.log($(this).find("option:selected").text());
	});*/
	$zdybq.getselectValue=function(){
		if($(".my_input_s").css("z-index")==-1){
			//瑜版挸澧犻弰鍓с仛閻ㄥ嫪缍卻elect
			return $(".my_select_s").find("option:selected").text();
		}else
			return $(".my_input_s").val();
	};
	$zdybq.setSelectValue=function(value){
		//瑜版挸澧犻弰鍓с仛閻ㄥ嫪缍卻elect
		$tip=0;
		$(".my_select_s").children("option").each(function(){
			if($(this).text()==value){
				$(this).prop("selected",true);
				$tip=1;
			};
		});
		if($tip==0){
			$(".my_select_s").append("<option selected>"+value+"</option>");
		}
	
		$(".my_input_s").val(value);
	};
	$zdybq.changeDateFromLabelToPicker=function(){
		return $(".myDate_label").prop("disabled",false).removeClass("myDate_label").addClass("myDate").datepicker({changeMonth:true,changeYear:true});
	};
	$zdybq.changeFromLabelToInput=function(){
		//閹跺yLabel閸欐ɑ鍨歮yInput
		$(".myLabel").prop("disabled",false).removeClass("myLabel").addClass("myInput");
	};
	$zdybq.changeToSelect=function(){
		//閹跺ySelect娑擃厾娈憁y_input_s閻ㄥ墥-index閸欐ɑ鍨�1
		$(".my_input_s").css("z-index","-1");
	};
	$zdybq.changeAreaToEdit=function(){
		$(".myArea_read").prop("disabled",false).removeClass("myArea_read").addClass("myArea_edit");
	};
	$zdybq.updateKeyValue=function(type){
		if(type==2){
			$(".keyValue").each(function(){
				//if($(this).has('myInput'))
				//	$(this).removeClass("myInput").addClass("myLabel").prop("disabled",true);
				//if($(this).has('myDate'))
				//	$(this).removeClass("myDate").addClass("myDate_label").prop("disabled",true);
				if($(this).has('my_input_s'))
					$(this).css("z-index","1");
				//if($(this).has('myArea_edit'))
				//	$(this).removeClass("myArea_edit").addClass("myArea_read").prop("disabled",true);
			});
		}
	};
	$zdybq.refresh=function(){
		$(".myInput").removeClass("myInput").addClass("myLabel").prop("disabled",true);
		$(".myDate").removeClass("myDate").addClass("myDate_label").prop("disabled",true);
		$(".my_input_s").css("z-index","1");
		$(".myArea_edit").removeClass("myArea_edit").addClass("myArea_read").prop("disabled",true);
		
		$("#i_close").parent().prop("colspan","4");
		$("#i_save").parent().hide();
	};
	
	//閸掓繂顬婇崠锟�	$zdybq.initialize();
});