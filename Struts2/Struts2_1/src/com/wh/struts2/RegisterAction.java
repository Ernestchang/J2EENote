package com.wh.struts2;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = -9071587506351446464L;
	private String username;
	private String password;
	private String repassword;
	private int age;
	private Date birthday;
	private Date graduation;

//	@Override
//	public void validate() {
		/*
		 * this.addActionError(anErrorMessage);
		 * 
		 * HTTP Status 404 - No result defined for action
		 * com.wh.struts2.RegisterAction and result input
		 * 如果输入校验失败或类型转换出错就会跳转到名字叫input的result页面 一般是返回到输入页面
		 */
		
		/*
		 * 1.首先进行类型转换（如果类型转换出错struts会将错误信息放到FieldError级别中
		 * 2.然后进行输入校验（执行validate方法）
		 * 3.如果上述过程中出现了任何错误（不管是哪一个错误），都不会再去执行execute方法，会转向struts.xml中
		 * 该action的名为input的result所对应的页面
		 * private Map<String, List<String>> internalGetFieldErrors() {
		 *      if (fieldErrors == null) {
		 *          fieldErrors = new LinkedHashMap<String, List<String>>();
		 *      }		
		 *      return fieldErrors;
		 *  }
		 */
		// 验证的时候只找不合法的
//		if (null == username || username.length() < 4 || username.length() > 6) {
//			this.addActionError("username invalid");
//			this.addFieldError("username", "\u7528\u6237\u540d\u4e0d\u5408\u6cd5");
//		}
//		if (null == password || password.length() < 4 || password.length() > 6) {
//			this.addActionError("password invalid");
//		} else if (null == repassword || repassword.length() < 4
//				|| repassword.length() > 6) {
//			this.addActionError("repassword invalid");
//		} else if (!password.equals(repassword)) {
//			this.addActionError("the passwords not the same");
//		}
//		if (age < 10 || age > 50) {
//			this.addActionError("age invalid");
//		}
//		if (null == birthday) {
//			this.addActionError("birthday invalid");
//		}
//		if (null == graduation) {
//			this.addActionError("graduation invalid");
//		}
//		if (null != birthday && null != graduation) {
//			Calendar c1 = Calendar.getInstance();
//			c1.setTime(birthday);
//			Calendar c2 = Calendar.getInstance();
//			c2.setTime(graduation);
//			if (!c1.before(c2)) {
//				this.addActionError("birthday should be before graduation");
//			}
//		}
//
		/*
		 * Field Error级别的错误信息底层使用LinkedHashMap实现的，给Map的key是Stirng
		 * 类型，value是List<String>类型，这就表示一个Field Name可以对应对条错误信息，这
		 * 些错误信息的哦独放置在List<String>集合当中
		 */
//		this.getFieldErrors().clear();
		/*
		 * 当调用getActionErrors()方法返回Action级别的错误信息列表时，返回的实际上是
		 * 集合的一个副本而不是集合本身，因此对集合副本调用clear()方法清除的依旧是副本中的元
		 * 素而非元集合中的元素，此时元集合中的内容没有受到任何的影响。换句话说Action级别的错
		 * 误信息列表对开发者来说是只读的。
		 * public synchronized Collection<String> getActionErrors() {
         *     return new ArrayList<String>(internalGetActionErrors());
    	 * }
		 */
//		this.getActionErrors().clear();
		
//		this.clearErrors();
//		System.out.println("claer");
//		this.addActionMessage("dfs");
		
		/*
		 * 自定义Field级别的错误提示消息
		 * 1.新建一个Actio名命名的properties文件，如RegisterAction.properties。
		 * 2.然后在该属性文件中指定每一个出错字段的错误消息
		 * invalid.fieldvalue.birthday=birthday invalid!
		 */
		
		/*
		 * Struts2的校验框架（有效的xml文件）具体来说分为字段优先校验器与校验器优先校验器
		 * 看这包com.opensymphony.xwork2.validator.validators下的default.xml文件
		 * 对于国际化资源文件，其命名规则是：package_语言名_国家名，比如package_zh_CN,package_en_US
		 */
//	}
	/*
	 *Struts2框架校验执行的先后顺序
	 *1.首先执行校验框架RegisterAction-validation.xml
	 *2.执行自定义方法的校验方法（validateMyExecute）
	 *3.执行指定的execute方法
	 */
}
