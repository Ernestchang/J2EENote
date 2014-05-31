package com.bingoogol.algorithmhome.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ChannelServiceTest {
	@Resource
	private ChannelService channelService;

	// @Test
	public void testIsNameAvailable() {
		Assert.assertEquals(false, channelService.isNameAvailable("tianwenxue"));
	}
}
