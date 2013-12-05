$(function() {
	var $ctx = $("#ctx").val();
	
	$("#buyBtn").on("click",function(){
		$.post($ctx + "/front/algorithm/buy/" + $("#id").val(), function(ajaxObj) {
			if (ajaxObj.success) {
				alert("成功");
			} else {
				$("#error").html(ajaxObj.msg);
				$("#error_div").css("display", "block");
			}
		}, "json");
	});
});