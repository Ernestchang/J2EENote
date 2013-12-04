$(function() {
	var ctx = $("#ctx").val();

	$("#vcodeimg").click(function() {
		$(this).attr("src", ctx + "/verifycode/vcode?timestamp=" + new Date().getTime());
	});

	$('#file_upload').uploadify({
		'auto' : false,
		'fileObjName' : 'file',
		'buttonText' : '选择文件',
		'queueID' : 'some_file_queue',
		'fileSizeLimit' : '10MB',
		'swf' : ctx + '/resources/common/uploadify.swf',
		'uploader' : 'http://up.qiniu.com/',
		'onSelect' : function(file) {
			$.get(ctx + "/front/algorithm/getUpToken", function(uptoken) {
				$('#file_upload').uploadify('settings', 'formData', {
					'token' : uptoken
				});
				$('#file_upload').uploadify('upload', '*');
			}, "text");
		},
		'onUploadSuccess' : function(file, data, response) {
			var ajaxObj = $.parseJSON(data);
			$("#attach").val(ajaxObj.name);
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			alert(errorString);
		},
		'removeTimeout' : 1,
		'fileTypeExts' : '*.*'
	});

	var vAddForm = $("#addForm").validate({
		rules : {
			name : {
				required : true,
				minlength : 2
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
			name : {
				required : "算法名不能为空",
				minlength : "算法名至少为2位"
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
	$("#addForm").submit(function() {
		if (vAddForm.errorList.length == 0) {
			$.post(window.location.href, $("#addForm").serialize(), function(ajaxObj) {
				if (ajaxObj.success) {
					alert("发布成功");
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
	$("#channel1").on("change", function() {
		$("#channel2 option[value!='']").remove();
		$("#cid option[value!='']").remove();
		var channel1id = $(this).val();
		if (channel1id != "") {
			$.get(ctx + "/front/selectChannel/" + channel1id, function(ajaxObj) {
				var channel2s = ajaxObj.obj;
				for (var i = 0; i < channel2s.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", channel2s[i].id);
					$option.text(channel2s[i].name);
					$channel2.append($option);
				}
			}, "json");
		}
	});
	$("#channel2").on("change", function() {
		$("#cid option[value!='']").remove();
		var channel2id = $(this).val();
		if (channel2id != "") {
			$.get(ctx + "/front/selectChannel/" + channel2id, function(ajaxObj) {
				var channel3s = ajaxObj.obj;
				for (var i = 0; i < channel3s.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", channel3s[i].id);
					$option.text(channel3s[i].name);
					$cid.append($option);
				}
			}, "json");
		}
	});
});