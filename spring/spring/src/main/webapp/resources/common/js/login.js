$(function() {
	var ctx = $("#ctx").val();

	$("#vcodeimg").click(function() {
		$(this).attr("src", ctx + "/verifycode/vcode?timestamp=" + new Date().getTime());
	});
	
	var vLoginForm = $("#loginForm").validate({
		rules : {
			username : {
				required : true,
				minlength : 6
			},
			password : {
				required : true,
				minlength : 6
			},
			vcode : {
				required : true,
				rangelength : [ 4, 4 ]
			}
		},
		messages : {
			username : {
				required : "用户名不能为空",
				minlength : "用户名至少为6位"
			},
			password : {
				required : "密码不能为空",
				minlength : "密码至少为6位"
			},
			vcode : {
				required : "验证码不能为空",
				rangelength : "验证码必须为4位"
			}
		}
	});
	$("#loginForm").submit(function() {
		if (vLoginForm.errorList.length == 0) {
			$.post(window.location.href, $("#loginForm").serialize(), function(ajaxObj) {
				if(ajaxObj.success) {
					if(ajaxObj.obj == 1) {
						window.location.href = ctx + "/admin/index";
					} else if(ajaxObj.obj == 2) {
						window.location.href = ctx + "/moderator/index";
					} else {
						window.location.href = ctx + "/front/index";
					}
				} else {
					if(ajaxObj.obj == 3) {
						window.location.href = ctx + "/front/user/activeui?status=3&id=" + ajaxObj.msg;
					} else {
						$("#error").html(ajaxObj.msg);
						$("#error_div").css("display", "block");
					}
				}
			}, "json");
		}
		return false;
	});
});