package com.wh.i18n;

import java.util.Locale;
import java.util.ResourceBundle;


public class I18NTest2 {

	public static void main(String[] args) {
//		ResourceBundle bundle = ResourceBundle.getBundle("com\\wh\\i18n\\bingo");
		//如果找不到对应的资源文件会使用默认的语言包
		ResourceBundle bundle = ResourceBundle.getBundle("com\\wh\\i18n\\bingo",Locale.FRANCE);
		String value = bundle.getString("hello");
		System.out.println(Locale.getDefault());
		System.out.println(value);
	}
}
