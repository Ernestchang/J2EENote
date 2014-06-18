var ctx = $("#ctx").val();
function topage(page) {
	window.location.href = ctx + "/user/users?page=" + page;
}