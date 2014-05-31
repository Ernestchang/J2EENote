package com.bingoogol.algorithmhome.util;




public class QiniuUtilTest {

	//@Test
	public void testGetPublicUpToken() {
		System.out.println(QiniuUtil.getPublicUpToken());
	}
	
	//@Test
	public void testGetPrivateUpToken() {
		System.out.println(QiniuUtil.getPublicUpToken());
	}
	
	//@Test
	public void testGetDocUrl() {
		System.out.println(QiniuUtil.getDocUrl("FmvmReNl6_LreeFnDgBV8ZgE4TpZ"));
	}
	
	//@Test
	public void testGetPrivateDownloadUrl() {
		System.out.println(QiniuUtil.getPrivateDownloadUrl("FmvmReNl6_LreeFnDgBV8ZgE4TpZ"));
	}
	
	//@Test
	public void testGetPublicDownloadUrl() {
		System.out.println(QiniuUtil.getPublicDownloadUrl("FmvmReNl6_LreeFnDgBV8ZgE4TpZ"));
	}

}
