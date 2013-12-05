$(function() {
	var $ctx = $("#ctx").val();
	var $codeUpload = $('#codeUpload');
	var $iodataUpload = $('#iodataUpload');
	var $thesisUpload = $('#thesisUpload');
	var $channel2 = $("#channel2");
	var $cid = $("#cid");

	$("#vcodeimg").click(function() {
		$(this).attr("src", $ctx + "/verifycode/vcode?timestamp=" + new Date().getTime());
	});

	$('#pricerange').on("change", function() {
		$("#price").val($(this).val());
	});

	$codeUpload.uploadify({
		'auto' : false,
		'fileObjName' : 'file',
		'buttonText' : '选择',
		'queueID' : 'codeQueue',
		'fileSizeLimit' : '10MB',
		'swf' : $ctx + '/resources/common/uploadify.swf',
		'uploader' : 'http://up.qiniu.com/',
		'onSelect' : function(file) {
			$.get($ctx + "/qiniu/auth/getPrivateUpToken", function(uptoken) {
				$codeUpload.uploadify('settings', 'formData', {
					'token' : uptoken
				});
				$codeUpload.uploadify('upload', '*');
			}, "text");
		},
		'onUploadSuccess' : function(file, data, response) {
			var ajaxObj = $.parseJSON(data);
			$("#codeName").val(ajaxObj.name);
			$("#codeHash").val(ajaxObj.hash);
			$("#codeName").keyup();
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			alert(errorString);
		},
		'removeTimeout' : 1,
		'fileTypeExts' : '*.*'
	});
	$iodataUpload.uploadify({
		'auto' : false,
		'fileObjName' : 'file',
		'buttonText' : '选择',
		'queueID' : 'iodataQueue',
		'fileSizeLimit' : '10MB',
		'swf' : $ctx + '/resources/common/uploadify.swf',
		'uploader' : 'http://up.qiniu.com/',
		'onSelect' : function(file) {
			$.get($ctx + "/qiniu/auth/getPrivateUpToken", function(uptoken) {
				$iodataUpload.uploadify('settings', 'formData', {
					'token' : uptoken
				});
				$iodataUpload.uploadify('upload', '*');
			}, "text");
		},
		'onUploadSuccess' : function(file, data, response) {
			var ajaxObj = $.parseJSON(data);
			$("#iodataName").val(ajaxObj.name);
			$("#iodataHash").val(ajaxObj.hash);
			$("#iodataName").keyup();
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			alert(errorString);
		},
		'removeTimeout' : 1,
		'fileTypeExts' : '*.*'
	});
	$thesisUpload.uploadify({
		'auto' : false,
		'fileObjName' : 'file',
		'buttonText' : '选择',
		'queueID' : 'thesisQueue',
		'fileSizeLimit' : '10MB',
		'swf' : $ctx + '/resources/common/uploadify.swf',
		'uploader' : 'http://up.qiniu.com/',
		'onSelect' : function(file) {
			$.get($ctx + "/qiniu/auth/getPublicUpToken", function(uptoken) {
				$thesisUpload.uploadify('settings', 'formData', {
					'token' : uptoken
				});
				$thesisUpload.uploadify('upload', '*');
			}, "text");
		},
		'onUploadSuccess' : function(file, data, response) {
			var ajaxObj = $.parseJSON(data);
			$("#thesisName").val(ajaxObj.name);
			$("#thesisHash").val(ajaxObj.hash);
			$("#thesisName").keyup();
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
			summary : {
				required : true,
				minlength : 15,
				maxlength : 150
			},
			price : {
				required : true,
				min : 0,
				max : 100
			},
			cid : {
				required : true
			},
			codeName : {
				required : true
			},
			iodataName : {
				required : true
			},
			thesisName : {
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
			summary : {
				required : "算法简介不能为空",
				minlength : "算法简介至少有15字",
				maxlength : "算法简介不能超过150字"
			},
			price : {
				required : "算法价格不能为空",
				min : "算法价格必须在0到100之间",
				max : "算法价格必须在0到100之间"
			},
			cid : {
				required : "请选择您关注的领域"
			},
			codeName : {
				required : "请添加源码"
			},
			iodataName : {
				required : "请添加输入输出数据"
			},
			thesisName : {
				required : "请添加论文"
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

	$("#channel1").on("change", function() {
		$("#channel2 option[value!='']").remove();
		$("#cid option[value!='']").remove();
		var channel1id = $(this).val();
		if (channel1id != "") {
			$.get($ctx + "/channel/select/" + channel1id, function(ajaxObj) {
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
			$.get($ctx + "/channel/select/" + channel2id, function(ajaxObj) {
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