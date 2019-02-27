//用户名获取焦点
function username_onfocus(x) {
	x.nextElementSibling.innerHTML = "用户名长度在5~16位之间(英文字母组合)";
	$("#username_hint").css("background-color", "#999");
}

// 用户名失去焦点事件
function username_onblur(x) {
	var username = $("#username").val();
	var pattern = /[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/;

	if (x.validity.valueMissing) {
		x.nextElementSibling.innerHTML = "用户名不能为空";
		// x.setCustomValidity("用户名不能为空");
		$("#username_hint").css("background-color", "red");
	} else if (x.validity.tooShort) {
		x.nextElementSibling.innerHTML = "用户名不能少于5位";
		// x.setCustomValidity("用户名不能少于5位");
		$("#username_hint").css("background-color", "red");
	} else if (!pattern.test(username)) {
		x.nextElementSibling.innerHTML = "用户名必须是英文数字组合";
		// x.setCustomValidity("请输入5~9位英文数字组合");
		$("#username_hint").css("background-color", "red");
	} else {
		// x.nextElementSibling.innerHTML = "用户名格式正确";
		// 没有错误时需要设置为空，否则表单无法提交
		// x.setCustomValidity("");

		// 发起异步请求，判断用户名是否存在
		$.ajax({
			url : "../user/checkUserName",
			data : {
				username : username
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				$("#username_hint").html(data.respMsg);
				var res = data.respCode == 1 ? "msg-success" : "msg-error";
				if (1 == data.respCode) {
					$("#username_hint").css("background-color", "green");
					$("#username_hint").attr("class", res);
				} else {
					$("#username_hint").css("background-color", "red");
				}
			}
		})
	}
}

// 密码获取焦点
function password_onfocus(x) {
	x.nextElementSibling.innerHTML = "密码长度在6~12位之间";
	$("#password_hint").css("background-color", "#999");
}

// 密码失去焦点事件
function password_onblur(x) {
	var password = $("#password").val();
	var pattern = /[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/;

	if (x.validity.valueMissing) {
		x.nextElementSibling.innerHTML = "密码不能为空";
		$("#password_hint").css("background-color", "red");
	} else if (x.validity.tooShort) {
		x.nextElementSibling.innerHTML = "密码不能少于6位";
		$("#password_hint").css("background-color", "red");
	} else if (!pattern.test(password)) {
		x.nextElementSibling.innerHTML = "密码必须是英文数字组合";
		$("#password_hint").css("background-color", "red");
	} else {
		x.nextElementSibling.innerHTML = "密码格式正确";
		$("#password_hint").css("background-color", "green");
	}
}

// 确认密码获取焦点
function confirmPassword_onfocus(x) {
	x.nextElementSibling.innerHTML = "密码长度在6~12位之间";
	$("#passwordConfirm_hint").css("background-color", "#999");
}

// 确认密码失去焦点事件
function confirmPassword_onblur(x) {
	var passwordConifrm = $("#passwordConfirm").val();
	var pattern = /[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/;

	if (x.validity.valueMissing) {
		x.nextElementSibling.innerHTML = "密码不能为空";
		$("#passwordConfirm_hint").css("background-color", "red");
	} else if (x.validity.tooShort) {
		x.nextElementSibling.innerHTML = "密码不能少于6位";
		$("#passwordConfirm_hint").css("background-color", "red");
	} else if (!pattern.test(passwordConifrm)) {
		x.nextElementSibling.innerHTML = "密码必须是英文数字组合";
		$("#passwordConfirm_hint").css("background-color", "red");
	} else {
		x.nextElementSibling.innerHTML = "密码格式正确";
		$("#passwordConfirm_hint").css("background-color", "green");
	}
}

// 手机号获取焦点
function phone_onfocus(x) {
	x.nextElementSibling.innerHTML = "请输入合法的手机号";
	$("#phone_hint").css("background-color", "#999");
}

// 手机号失去焦点
function phone_onblur(x) {
	var phone = $("#phone").val();
	var pattern = /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
	if (x.validity.valueMissing) {
		x.nextElementSibling.innerHTML = "手机号不能为空";
		$("#phone_hint").css("background-color", "red");
	} else if (x.validity.tooShort) {
		x.nextElementSibling.innerHTML = "手机号必须为11位";
		$("#phone_hint").css("background-color", "red");
	} else if (!pattern.test(phone)) {
		x.nextElementSibling.innerHTML = "请输入合法的手机号";
		$("#phone_hint").css("background-color", "red");
	} else {
		$.ajax({
			url : "../user/checkPhone",
			data : {
				phone : phone
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				$("#phone_hint").html(data.respMsg);
				var res = data.respCode == 1 ? "msg-success" : "msg-error";
				if (1 == data.respCode) {
					$("#phone_hint").css("background-color", "green");
					$("#phone_hint").attr("class", res);
				} else {
					$("#phone_hint").css("background-color", "red");
				}
			}
		})
	}
}

// 邮箱地址获取焦点
function email_onfocus(x) {
	x.nextElementSibling.innerHTML = "请输入合法的邮箱地址";
	$("#email_hint").css("background-color", "#999");
}
// 邮箱地址失去焦点
function email_onblur(x) {
	var email = $("#email").val();
	var pattern = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (x.validity.valueMissing) {
		x.nextElementSibling.innerHTML = "邮箱地址不能为空";
		$("#email_hint").css("background-color", "red");
	} else if (x.validity.typeMismatch) {
		x.nextElementSibling.innerHTML = "邮箱地址格式不正确";
		$("#email_hint").css("background-color", "red");
	} else if (!pattern.test(email)) {
		x.nextElementSibling.innerHTML = "请输入合法的手机号";
		$("#email_hint").css("background-color", "red");
	} else {
		$.ajax({
			url : "../user/checkEmail",
			data : {
				email : email
			},
			type : "POST",
			dataType : "json",
			success : function(data) {
				$("#email_hint").html(data.respMsg);
				var res = data.respCode == 1 ? "msg-success" : "msg-error";
				if (1 == data.respCode) {
					$("#email_hint").css("background-color", "green");
					$("#email_hint").attr("class", res);
				} else {
					$("#email_hint").css("background-color", "red");
				}
			}
		})
	}
}

// 注册提交按钮
function registerCommit() {
	var username = $.trim($("#username").val());
	var password = $.trim($("#password").val());
	var passwordConfirm = $.trim($("#passwordConfirm").val());
	var phone = $.trim($("#phone").val());
	var email = $.trim($("#email").val());
	var json = {
		username : username,
		password : password,
		phone : phone,
		email : email
	};

	if (password == passwordConfirm) {
		var count = 0;
		$(".register_group").each(function() {
			if ($(this).find("span").hasClass("msg-success")) {
				count++;
			}
		});
		if (count == 3) {
			$.ajax({
				url : "../user/handleRegister",
				data : json,
				dataType : "json",
				type : "POST",
				success : function(data) {
					debugger;
					if (data.respCode == 1) {
						location.href="../user/login";
						alert("注册成功");
					} else {
						alert("登陆失败");
					}

				}
			});
		}
	} else {
		alert("密码和确认密码不同,请重新输入！");
	}

}