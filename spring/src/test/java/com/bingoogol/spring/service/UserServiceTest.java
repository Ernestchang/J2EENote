package com.bingoogol.spring.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bingoogol.spring.dto.Pager;
import com.bingoogol.spring.dto.UserLoginDto;
import com.bingoogol.spring.util.SecurityUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {

	@Resource
	private UserService userService;

	// @Test
	public void testIsUsernameAvailable() {
		Assert.assertEquals(true, userService.isUsernameAvailable("wanghao1"));
		Assert.assertEquals(false, userService.isUsernameAvailable("wanghao"));
	}

	// @Test
	public void testIsEmailAvailable() {
		Assert.assertEquals(true, userService.isEmailAvailable("bingoogol1@sina.com"));
		Assert.assertEquals(false, userService.isEmailAvailable("bingoogol@sina.com"));
	}

	// @Test
	public void testFenye() {
		Pager pager = new Pager();
		pager.setPage(1);
		pager.setRows(3);
		System.out.println(userService.fenye(pager));
	}

	// @Test
	public void testMd5() throws NoSuchAlgorithmException {
		System.out.println(SecurityUtil.md5("admin123", "123456"));
		System.out.println(SecurityUtil.md5("moderator", "123456"));
		System.out.println(SecurityUtil.md5("user123", "123456"));
	}

	// @Test
	public void testLogin() throws NoSuchAlgorithmException {
		UserLoginDto userLoginDto = new UserLoginDto();
		userLoginDto.setUsername("admin123");
		userLoginDto.setPassword("123456");

		System.out.println(userService.login(userLoginDto));
	}
}
