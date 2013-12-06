var $ctx = $("#ctx").val();
function changeStatus(id,status) {
	$.post($ctx + "/moderatorinfo/admin/changeStatus/" + id + "/" + status,function(ajaxObj) {
		if (ajaxObj.success) {
			window.location.reload();
		} else {
			alert("操作失败");
		}
	}, "json");
}
