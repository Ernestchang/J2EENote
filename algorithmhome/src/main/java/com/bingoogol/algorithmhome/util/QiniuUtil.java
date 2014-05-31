package com.bingoogol.algorithmhome.util;

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
	private static String privateBucketName = null;
	private static String privateDomain = null;
	private static String publicBucketName = null;
	private static String publicDomain = null;
	private static int expires = 10;
	static {
		InputStream is = null;
		try {
			Properties pp = new Properties();
			is = QiniuUtil.class.getClassLoader().getResourceAsStream("qiniu.properties");
			pp.load(is);
			Config.ACCESS_KEY = pp.getProperty("ACCESS_KEY");
			Config.SECRET_KEY = pp.getProperty("SECRET_KEY");

			privateBucketName = pp.getProperty("privateBucketName");
			privateDomain = pp.getProperty("privateDomain");

			publicBucketName = pp.getProperty("publicBucketName");
			publicDomain = pp.getProperty("publicDomain");

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
	 * 获取私有空间上传令牌
	 * 
	 * @return
	 */
	public static String getPrivateUpToken() {
		try {
			PutPolicy putPolicy = new PutPolicy(privateBucketName);
			putPolicy.returnBody = "{\"hash\":$(etag),\"name\":$(fname)}";
			putPolicy.expires = expires;
			return putPolicy.token(mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取公开空间上传令牌
	 * 
	 * @return
	 */
	public static String getPublicUpToken() {
		try {
			PutPolicy putPolicy = new PutPolicy(publicBucketName);
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
	 * 
	 * @param hash
	 * @return
	 */
	public static String getDocUrl(String hash) {
		try {
			GetPolicy getPolicy = new GetPolicy();
			String baseUrl = URLUtils.makeBaseUrl(publicDomain, hash);
			String fileUrl = getPolicy.makeRequest(baseUrl, mac);
			// Google 文档查看器要求url是经过iso-8859-1编码的
			return URLEncoder.encode(fileUrl, "iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取私有文件下载地址
	 * 
	 * @param hash
	 * @return
	 */
	public static String getPrivateDownloadUrl(String hash) {
		try {
			GetPolicy getPolicy = new GetPolicy();
			String baseUrl = URLUtils.makeBaseUrl(privateDomain, hash);
			getPolicy.expires = expires;
			return getPolicy.makeRequest(baseUrl, mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取公有文件下载地址
	 * 
	 * @param hash
	 * @return
	 */
	public static String getPublicDownloadUrl(String hash) {
		try {
			GetPolicy getPolicy = new GetPolicy();
			String baseUrl = URLUtils.makeBaseUrl(publicDomain, hash);
			getPolicy.expires = expires;
			return getPolicy.makeRequest(baseUrl, mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
