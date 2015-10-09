//黑科技，让页面自适应浏览器最大窗口大小
function makeLRalign(){
	var h = screen.height-250;
	var lh = $(".contentLeftWrap").height();
	var rh = $(".contentRightWrap").height();
	//alert(lh+","+rh);
	if(lh>h){
		h = lh;
	}
	if(rh>h){
		h = rh;
	}
	$(".contentLeftWrap").css("height",h+"px");
	$(".contentRightWrap").css("height",h+"px");
	
}

function adjustLR(id){
	var nh = $("#"+id).height()+$("#"+id).position().top;
	var minH = screen.height-250;
	//alert(nh+","+(screen.height-350)+","+$("#zzk_list").height()+","+$("#zzk_list").position().top);
	if(nh<minH){
		nh = minH;
	}
	$(".contentLeftWrap").height(nh+"px");
	$(".contentRightWrap").height(nh+"px");
	
}
$(function() {
	var w = screen.width;
	if(w<1366){
		w = 1366;
	}
	w = w -25;
	$(".page").css("width",w+"px");
	$(".contentLeftWrap").css("width",w*0.2+"px");
	if($.browser.version == "8.0"){
		$(".contentRightWrap").css("width",(w*0.78)+"px");
	}else{
		$(".contentRightWrap").css("width",(w*0.8)+"px");
	}

	
	makeLRalign();
	var headMenuName = $(".head-parent-menu span").text();
	var pic_url = "";
	$(".head-title-content ul li").each(function() {
		if ($(this).text() == headMenuName) {
			pic_url = $(this).find("img").attr("src");
		}
	});
	$(".head-parent-menu img").attr("src", pic_url);
});

