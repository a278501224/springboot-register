/**
 * 登陆界面显示或者隐藏密码
 */
$(function() {
	$("#passwordVisible").click(function() {
		var type = $("#password").attr("type");
		if (type == "password") {
			$("#password").attr("type", "text");
			$("#passwordVisible").attr("src", "../img/passwordVisible.png");
		} else {
			$("#password").attr("type", "password");
			$("#passwordVisible").attr("src", "../img/passwordUnvisible.png");
		}
	})
});