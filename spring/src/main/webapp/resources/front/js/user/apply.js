$(function() {
	var $ctx = $("#ctx").val();
	var $approveUpload = $('#approveUpload');
	var $cid = $("#cid");

	$("#vcodeimg").click(function() {
		$(this).attr("src", $ctx + "/verifycode/vcode?timestamp=" + new Date().getTime());
	});
	
	$approveUpload.uploadify({
		'auto' : false,
		'fileObjName' : 'file',
		'buttonText' : '选择',
		'queueID' : 'approveQueue',
		'fileSizeLimit' : '10MB',
		'swf' : $ctx + '/resources/common/uploadify.swf',
		'uploader' : 'http://up.qiniu.com/',
		'onSelect' : function(file) {
			$.get($ctx + "/qiniu/auth/getPrivateUpToken", function(uptoken) {
				$approveUpload.uploadify('settings', 'formData', {
					'token' : uptoken
				});
				$approveUpload.uploadify('upload', '*');
			}, "text");
		},
		'onUploadSuccess' : function(file, data, response) {
			var ajaxObj = $.parseJSON(data);
			$("#approveName").val(ajaxObj.name);
			$("#approveHash").val(ajaxObj.hash);
			$("#approveName").keyup();
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			alert(errorString);
		},
		'onCancel' : function(file) {
			$("#approveName").val("");
			$("#approveHash").val("");
			return false;
        },
		'removeTimeout' : 1,
		'successTimeout' : 1,
		'fileTypeExts' : '*.zip;*.rar'
	});

	var vApplyForm = $("#applyForm").validate({
		rules : {
			realname : {
				required : true,
				minlength : 2
			},
			title : {
				required : true,
				minlength : 2
			},
			degree : {
				required : true,
				minlength : 2
			},
			summary : {
				required : true,
				minlength : 15,
				maxlength : 150
			},
			cid : {
				required : true
			},
			approveName : {
				required : true
			},
			vcode : {
				required : true,
				rangelength : [ 4, 4 ]
			}
		},
		messages : {
			realname : {
				required : "真实名字不能为空",
				minlength : "真实名字至少为2位"
			},
			title : {
				required : "职称不能为空",
				minlength : "职称至少为2位"
			},
			degree : {
				required : "学位不能为空",
				minlength : "学位至少为2位"
			},
			summary : {
				required : "个人简介不能为空",
				minlength : "个人简介至少有15字",
				maxlength : "个人简介不能超过150字"
			},
			cid : {
				required : "请选择您要申请的板块"
			},
			approveName : {
				required : "请添加认证材料"
			},
			vcode : {
				required : "验证码不能为空",
				rangelength : "验证码必须为4位"
			}
		}
	});

	$("#applyForm").submit(function() {
		if (vApplyForm.errorList.length == 0) {
			$.post(window.location.href, $("#applyForm").serialize(), function(ajaxObj) {
				if (ajaxObj.success) {
					window.location.href = $ctx + "/front/index";
				} else {
					alert("申请失败");
					console.log("申请失败");
					$("#error").html(ajaxObj.msg);
					$("#error_div").css("display", "block");
				}
			}, "json");
		}
		return false;
	});

	$("#channel1").on("change", function() {
		$("#cid option[value!='']").remove();
		var channel1id = $(this).val();
		if (channel1id != "") {
			$.get($ctx + "/channel/select/" + channel1id, function(ajaxObj) {
				var cids = ajaxObj.obj;
				for (var i = 0; i < cids.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", cids[i].id);
					$option.text(cids[i].name);
					$cid.append($option);
				}
			}, "json");
		}
	});
});