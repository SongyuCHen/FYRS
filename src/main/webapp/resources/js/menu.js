//黑科技，让页面自适应浏览器最大窗口大小
$(".page").css("width",(screen.width-20)+"px");
$(function() {
	var headMenuName = $(".head-parent-menu span").text();
	var pic_url = "";
	$(".head-title-content ul li").each(function() {
		if ($(this).text() == headMenuName) {
			pic_url = $(this).find("img").attr("src");
		}
	});
	$(".head-parent-menu img").attr("src", pic_url);
});