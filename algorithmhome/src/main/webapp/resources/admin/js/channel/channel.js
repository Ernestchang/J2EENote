$(function() {
	var ctx = $("#ctx").val();
	$("#name").val("");
	$('#addChannelModel').on("shown.bs.modal",function(e){
		$("#name").focus();
	});
	var vAddChannelForm = $("#addChannelForm").validate({
		rules : {
			name : {
				required : true,
				minlength : 2,
				remote : {
					url : ctx + "/channel/admin/vname",
					type : "post"
				}
			}
		},
		messages : {
			name : {
				required : "学科名不能为空",
				minlength : "学科名至少为2位",
				remote : "该学科名已被存在"
			}
		}
	});
	$("#addChannelForm").submit(function() {
		if (vAddChannelForm.errorList.length == 0) {
			$.post(ctx + "/channel/admin/add", $("#addChannelForm").serialize(), function(ajaxObj) {
				if (ajaxObj.success) {
					window.location.reload();
					$('#addChannelModel').modal('hide');
				} else {
					$("#error").html(ajaxObj.msg);
					$("#error_div").css("display", "block");
				}
			}, "json");
		}
		return false;
	});
});