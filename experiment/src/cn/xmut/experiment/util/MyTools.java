package cn.xmut.experiment.util;

import java.security.MessageDigest;

public class MyTools {
	
	public static String getMD5(String s) {
		String result = null;
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f' };
		try {
			byte[] source = s.getBytes();
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(source);
			byte md[] = messageDigest.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			result = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
