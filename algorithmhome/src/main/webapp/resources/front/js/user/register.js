$(function() {
	var ctx = $("#ctx").val();

	$("#vcodeimg").click(function() {
		$(this).attr("src", ctx + "/verifycode/vcode?timestamp=" + new Date().getTime());
	});

	var vRegisterForm = $("#registerForm").validate({
		rules : {
			username : {
				required : true,
				minlength : 6,
				remote : {
					url : ctx + "/user/vusername",
					type : "post"
				}
			},
			password : {
				required : true,
				minlength : 6
			},
			vpassword : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			},
			email : {
				required : true,
				email : true,
				remote : {
					url : ctx + "/user/vemail",
					type : "post"
				}
			},
			cid : {
				required : true
			},
			vcode : {
				required : true,
				rangelength : [ 4, 4 ]
			}
		},
		messages : {
			username : {
				required : "用户名不能为空",
				minlength : "用户名至少为6位",
				remote : "该用户名已被注册"
			},
			password : {
				required : "密码不能为空",
				minlength : "密码至少为6位"
			},
			vpassword : {
				required : "确认密码不能为空",
				minlength : "密码至少为6位",
				equalTo : "两次密码不一致"
			},
			email : {
				required : "邮箱不能为空",
				email : "邮箱格式不正确",
				remote : "该邮箱已被注册"
			},
			cid : {
				required : "请选择您关注的领域"
			},
			vcode : {
				required : "验证码不能为空",
				rangelength : "验证码必须为4位"
			}
		}
	});
	$("#registerForm").submit(function() {
		if (vRegisterForm.errorList.length == 0) {
			$.post(window.location.href, $("#registerForm").serialize(), function(ajaxObj) {
				if (ajaxObj.success) {
					window.location.href = ctx + "/user/activeui?status=0&id=" + ajaxObj.obj;
				} else {
					$("#error").html(ajaxObj.msg);
					$("#error_div").css("display", "block");
				}
			}, "json");
		}
		return false;
	});
	
	var $channel2 = $("#channel2");
	var $cid = $("#cid");
	$("#channel1").on("change",function(){
		$("#channel2 option[value!='']").remove();
		$("#cid option[value!='']").remove();
		var channel1id = $(this).val();
		if (channel1id != "") {
			$.get(ctx + "/channel/select/" + channel1id,function(ajaxObj) {
				var channel2s = ajaxObj.obj;
				for ( var i = 0; i < channel2s.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", channel2s[i].id);
					$option.text(channel2s[i].name);
					$channel2.append($option);
				}
			}, "json");
		}
	});
	$("#channel2").on("change",function(){
		$("#cid option[value!='']").remove();
		var channel2id = $(this).val();
		if (channel2id != "") {
			$.get(ctx + "/channel/select/" + channel2id,function(ajaxObj) {
				var channel3s = ajaxObj.obj;
				for ( var i = 0; i < channel3s.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", channel3s[i].id);
					$option.text(channel3s[i].name);
					$cid.append($option);
				}
			}, "json");
		}
	});
});