package com.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
// 这里可以写
public class TestController {

	// @RequestMapping("/start")
	// public String start(HttpServletRequest request) {
	// // http://localhost:8087/AnnotationMVC/test/start.do?name=wanghao
	// String name = request.getParameter("name");
	// System.out.println(name);
	// return "start";
	// }

	// // public String start(@PathVariable String name) { //只能以debug模式编译
	// @RequestMapping("/start/{name}")
	// // restful风格
	// public String start(@PathVariable("name") String name) { //
	// debug模式和release模式编译均可
	// // http://localhost:8087/AnnotationMVC/test/start/wanghao.do
	// System.out.println(name);
	// return "start";
	// }

	// // 指定@PathVariable("age") int nianling可以随便写
	// @RequestMapping("/start/{name}/{age}")
	// public String start(@PathVariable("name") String name,
	// @PathVariable("age") int nianling) {
	// // http://localhost:8087/AnnotationMVC/test/start/wanghao/21.do
	// System.out.println(name + "|" + nianling);
	// return "start";
	// }

	// @RequestMapping(value = "/start", method = RequestMethod.GET)
	// public String getStart() {
	// // http://localhost:8087/AnnotationMVC/test/start.do放在浏览器地址栏或a标签中
	// return "start_get";
	// }

	// @RequestMapping(value = "/start", method = RequestMethod.POST)
	// public String postStart() {
	// // http://localhost:8087/AnnotationMVC/test/start.do放在表单中
	// return "start_post";
	// }

	// @RequestMapping(value = "/{test}", method = RequestMethod.GET)
	// public void testPathVariable(@PathVariable("test") Date test) {
	//
	// }
	// @InitBinder
	// public void initBinder(WebRequestDataBinder binder) {
	// CustomDateEditor customDateEditor = new CustomDateEditor(new
	// SimpleDateFormat("yyyy-MM-dd"), true);
	// binder.registerCustomEditor(Date.class, customDateEditor);
	// }

	// //session前提条件，当请求session可用
	// public void testAllArguments(HttpServletRequest request,
	// HttpServletResponse response,
	// HttpSession session,
	// @PathVariable AnyType xxx1, //类型转换根据属性编辑器
	// @RequestParam AnyType xxx2, //类型转换根据属性编辑器
	// @CookieValue AnyType cookieName,
	// @RequestHeader("") AnyType xxx3
	// ) {
	// }

	// @RequestMapping("/xx")
	// public void testAllArguments(PrintWriter out) {
	// out.print("");
	// }

	// @RequestMapping("/xx")
	// public String testAllArguments(Map model) {
	// model.put(key, value); //如果传入了model，虽然没有显示返回model，但会默认返回model
	// return "";
	// }

	// //错误绑定参数
	// @RequestMapping("/xx")
	// public String testCommond(User user, BindingResult result) {
	// return "";
	// }

	// @RequestMapping("/xx")
	// public String testCommond(User user) {
	// return "";
	// }

	// @RequestMapping("/xx")
	// public void testVoid() {
	// // http://localhost:8087/AnnotationMVC/test/xx.do --隐含视图名--> test/xx
	// --加上前后缀--> /WEB-INF/page/test/xx.jsp
	// }

	// public User queryUser() {
	// //model("user",user),key是类名第一个字母小写
	// return null;
	// }

	// public List<User> queryUsers() {
	// // model("userList",users),key是类名第一个字母小写加上对应的List，或Set
	// return null;
	// }
}