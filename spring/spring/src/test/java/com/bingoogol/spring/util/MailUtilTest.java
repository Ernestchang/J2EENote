package com.bingoogol.spring.util;

import javax.mail.MessagingException;

import org.junit.Test;

import com.bingoogol.spring.util.MailUtil;

public class MailUtilTest {

	@Test
	public void testSendActiveLink() throws MessagingException {
		MailUtil.sendActiveLink("bingoogol@sina.com", "bingoogol", "bingoogolid", "bingoogolactivecode");
	}

}
