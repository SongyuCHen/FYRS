
/*==================
 * 全局函数
 * ==================
*/
	/**
	 * 修改密码
	 */
	var changePassword = function(){
		$.ajax({
			url:"/changePasswordShow.aj",
			type:"GET",
			data:{},
			dataType:"html",
			success:function(html){
				$("#changePassword_dlg").html(html).dialog("open");
			}
		});
		return false;
	};
  var linkToPerson = function()
  {
	    var showKey = $("#personCode").data("headshowkey");
	    var isOnlyLook = $("#personCode").data("headisonlylook");
	    window.open("/ryjbxx.do?showKey="+showKey+"&isOnlyLook="+isOnlyLook);
  };
	/**
	 * 更新uniform样式
	 */
	var updateUniform = function(){
		if($.uniform){
			$.uniform.update();
		}
	};
	/**
	 * 重新绑定
	 */
	var rebindUniform = function(){
		$('input:checkbox, input:radio').uniform();
		$("input:file").uniform({
			fileDefaultHtml : '请选择文件',
			fileButtonHtml : '浏览'
		});
	};

$(document).ready(function(){
	// 修改密码
	$('#changePassword_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 400,
		width : 400,
		title : '修改密码'
	});
	
	rebindUniform();
});

var showLoading = function()
{
	 $("#loading").removeClass("element-display-none");
     $("#loading").addClass("element-vis");
};
var hiddenLoading = function()
{
	 $("#loading").removeClass("element-vis");
     $("#loading").addClass("element-display-none");
};
