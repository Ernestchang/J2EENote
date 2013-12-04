package com.bingoogol.spring.util;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Properties;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.URLUtils;

public class QiniuUtil {
	private static Mac mac = null;
	private static String bucketName = null;
	private static String domain = null;
	private static int expires = 10;
	static {
		InputStream is = null;
		try {
			Properties pp = new Properties();
			is = QiniuUtil.class.getClassLoader().getResourceAsStream("qiniu.properties");
			pp.load(is);
			Config.ACCESS_KEY = pp.getProperty("ACCESS_KEY");
			Config.SECRET_KEY = pp.getProperty("SECRET_KEY");
			bucketName = pp.getProperty("bucketName");
			domain = pp.getProperty("domain");
			expires = Integer.parseInt(pp.getProperty("expires"));
			mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取上传令牌
	 * @return
	 */
	public static String getUpToken() {
		try {
			PutPolicy putPolicy = new PutPolicy(bucketName);
			putPolicy.returnBody = "{\"hash\":$(etag),\"name\":$(fname)}";
			putPolicy.expires = expires;
			return putPolicy.token(mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 根据hash值，获取要在线预览文档的七牛路径
	 * @param hash
	 * @return
	 */
	public static String getDocUrl(String hash) {
		try {
			String baseUrl = URLUtils.makeBaseUrl(domain, hash);
			GetPolicy getPolicy = new GetPolicy();
			getPolicy.expires = expires;
			String fileUrl = getPolicy.makeRequest(baseUrl, mac);
			// Google 文档查看器要求url是经过iso-8859-1编码的
			fileUrl = URLEncoder.encode(fileUrl, "iso-8859-1");
			return fileUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getDownloadUrl(String hash) {
		try {
			String baseUrl = URLUtils.makeBaseUrl(domain, hash);
			GetPolicy getPolicy = new GetPolicy();
			getPolicy.expires = expires;
			String fileUrl = getPolicy.makeRequest(baseUrl, mac);
			// Google 文档查看器要求url是经过iso-8859-1编码的
			fileUrl = URLEncoder.encode(fileUrl, "iso-8859-1");
			return fileUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
