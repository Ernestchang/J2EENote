$(function() {
	$("#addchannel").submit(function() {
		if($("#pid2").val()) {
			$.post("/channel/front/add", $(this).serialize(), function(json) {
				if(json.success) {
					window.location.href = "/home/front";
				} else {
					alert(json.msg);
				}
			}, "json");
		} else {
			alert("请选择研究方向");
		}
		return false;
	});
	
	$("#pid1").on("change", function() {
		$("#pid2 option[value!='']").remove();
		var pcid1 = $(this).val();
		if(pcid1) {
			$.post("/channel/getJsonByPid/" + pcid1, function(data) {
				for ( var i = 0; i < data.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", data[i].id);
					$option.text(data[i].name);
					$("#pid2").append($option);
				}
			}, "json");
		}
	});
});