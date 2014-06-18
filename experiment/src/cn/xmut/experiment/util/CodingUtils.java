package cn.xmut.experiment.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CodingUtils {
	public static String iso2utf(String str) {
		String result = null;
		try {
			result = new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String utf2iso(String str) {
		String result = null;
		try {
			result = new String(str.getBytes("utf-8"),"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String urlEncoder2utf(String str) {
		String result = null;
		try {
			result = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
