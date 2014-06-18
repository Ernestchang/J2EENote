package com.bingoogol.generic.util;


public class TextUtil {

	private TextUtil() {
	}

	public static boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}
}
