package com.wh.utils;

import java.util.UUID;

import org.junit.Test;

import com.wh.base.utils.MD5;

public class MD5Test {

	@Test
	public void testMD5Encode() {
		System.out.println(MD5.MD5Encode("wanghao").length());
	}
	@Test
	public void testUUID() {
		System.out.println(UUID.randomUUID());
		System.out.println("54bc4761-c59f-4fbf-a652-8d41a603a26b".length());
	}

}
