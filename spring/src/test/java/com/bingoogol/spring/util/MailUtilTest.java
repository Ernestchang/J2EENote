package com.bingoogol.spring.util;

import javax.mail.MessagingException;

public class MailUtilTest {

	//@Test
	public void testSendActiveLink() throws MessagingException {
		MailUtil.sendActiveLink("bingoogol@sina.com", "bingoogol", "bingoogolid", "bingoogolactivecode");
	}

}
