//黑科技，让页面自适应浏览器最大窗口大小
function makeLRalign(){
	var h = screen.height-350;
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
$(function() {
	var w = screen.width;
	if(w<1366){
		w = 1366;
	}
	$(".page").css("width",(w-20)+"px");
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

