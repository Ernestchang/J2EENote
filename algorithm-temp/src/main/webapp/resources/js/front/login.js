$(function() {
	$("#login").submit(function() {
		$.post("/auth/front/login", $(this).serialize(), function(json) {
			if (json.success) {
				window.location.href = "/home/front";
			} else {
				alert(json.msg);
			}
		}, "json");
		return false;
	});
});