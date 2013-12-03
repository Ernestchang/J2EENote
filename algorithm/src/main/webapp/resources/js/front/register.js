$(function() {
	$("#register").submit(function() {
		var isAvaliable = $("#isAvaliable").val();
		if(isAvaliable == "true") {
			if($("input[name='password']").val() == $("input[name='confirmPwd']").val()) {
				if($("#cid").val()) {
					$.post("/user/front/register", $(this).serialize(), function(json) {
						if(json.success) {
							window.location.href = "/home/front";
						} else {
							alert(json.msg);
						}
					}, "json");
				} else {
					alert("请选择研究方向");
				}
			} else {
				alert("两次密码不一致");
			}
		} else {
			alert("该账户名已被注册，请重新填写");
		}
		return false;
	});
	
	$("#username").focusout(function() {
		$.post("/user/front/available", {username:$("#username").val()}, function(json) {
			$("#isAvaliable").val(json.success);
		}, "json");
	});
	
	$("#pcid").on("change", function() {
		$("#cid option[value!='']").remove();
		var pcid = $(this).val();
		if(pcid) {
			$.post("/channel/getJsonByPid/" + pcid, function(data) {
				for ( var i = 0; i < data.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", data[i].id);
					$option.text(data[i].name);
					$("#cid").append($option);
				}
			}, "json");
		}
	});
});