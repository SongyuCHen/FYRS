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