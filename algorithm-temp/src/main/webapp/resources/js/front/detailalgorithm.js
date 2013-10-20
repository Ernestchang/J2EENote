$(function() {
	$("#downloadThesisBtn").click(function() {
		check("/algorithm/front/downloadThesis/" + $("#aid").val());
		return false;
	});
	$("#downloadAlgorithmBtn").click(function() {
		check("/algorithm/front/downloadAlgorithm/" + $("#aid").val());
		return false;
	});
	
	function check(url) {
		$.post("/algorithm/front/isPermission/" + $("#aid").val(), function(json1) {
			if (json1.success) {
				if(json1.obj == 1) {
					window.open(url);
				} else {
					if (confirm("下载该资源需要扣除" + $("#ascore").val()+ "个积分，确定要下载吗？")) {
						$.post("/algorithm/front/addUserAlgorithm/" + $("#aid").val(), function(json2) {
							if(json2.success) {
								window.open(url);
							} else {
								alert(json2.msg);
							}
						}, "json");
					}
				}
			} else {
				alert(json1.msg);
			}
		}, "json");
	}
});