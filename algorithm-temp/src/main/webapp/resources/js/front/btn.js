$(function() {
	$("#homeBtnNav").on("click", function() {
		window.location.href="/home/front";
		return false;
	});
	$("#loginBtnNav").on("click", function() {
		window.location.href="/auth/front/login";
		return false;
	});
	$("#registerBtnNav").on("click", function() {
		window.location.href="/user/front/register";
		return false;
	});
	$("#addQuestionBtnNav").on("click", function() {
		window.location.href="/question/front/add";
		return false;
	});
	$("#addAlgorithmBtnNav").on("click", function() {
		window.location.href="/algorithm/front/add";
		return false;
	});
	$("#logoutBtnNav").on("click", function() {
		window.location.href="/auth/front/logout";
		return false;
	});
});