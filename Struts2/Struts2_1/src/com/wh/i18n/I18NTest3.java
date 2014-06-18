package com.wh.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class I18NTest3 {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("com\\wh\\i18n\\bingo",locale);
		String value = bundle.getString("hello");
		String result = MessageFormat.format(value, new Object[]{"hahahahah"});
		System.out.println(result);
	}
}
