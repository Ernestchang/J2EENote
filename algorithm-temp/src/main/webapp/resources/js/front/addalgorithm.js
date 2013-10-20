$(function() {
	$("#addalgorithm").submit(function() {
		if($("#score").val()) {
			if($("#cid").val()) {
				return true;
			} else {
				alert("请选择研究方向");
			}
		} else {
			alert("请选择标价");
		}
		return false;
	});
	
	$("#pcid1").on("change", function() {
		$("#pcid2 option[value!='']").remove();
		$("#cid option[value!='']").remove();
		var pcid1 = $(this).val();
		if(pcid1) {
			$.post("/channel/getJsonByPid/" + pcid1, function(data) {
				for ( var i = 0; i < data.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", data[i].id);
					$option.text(data[i].name);
					$("#pcid2").append($option);
				}
			}, "json");
		}
	});
	$("#pcid2").on("change", function() {
		$("#cid option[value!='']").remove();
		var pcid2 = $(this).val();
		if(pcid2) {
			$.post("/channel/getJsonByPid/" + pcid2, function(data) {
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