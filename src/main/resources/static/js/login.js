/**
 * 
 */
function loginCommit(){
	var username=$.trim($("#username").val());
	var password=$.trim($("#password").val());
	
	if(username==""&&password==""){
		$(".mms-error").show();
		$(".commitResult").hide();
		$(".usernameNull").hide();
		$(".passwordNull").hide();
		$(".unamePwdNull").show();
	}else if(username==""){
		$(".mms-error").show();
		$(".commitResult").hide();
		$(".passwordNull").hide();
		$(".unamePwdNull").hide();
		$(".usernameNull").show();
	}else if(password==""){
		$(".mms-error").show();
		$(".commitResult").hide();
		$(".usernameNull").hide();
		$(".unamePwdNull").hide();
		$(".passwordNull").show();
	}else{
		$(".mms-error").hide();
		$(".usernameNull").hide();
		$(".unamePwdNull").hide();
		$(".passwordNull").hide();
		var json={username:username,password:password};
		$.ajax({
			url:"../user/handleLogin",
			data:json,
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.respCode==1){
					alert("登陆成功");
					location.href="../user/index";
				}else{
					$(".mms-error").show();
					$(".commitResult").show();
//				$(".commitResult").attr("hidden","true");
				}
			}
		})
	}
}