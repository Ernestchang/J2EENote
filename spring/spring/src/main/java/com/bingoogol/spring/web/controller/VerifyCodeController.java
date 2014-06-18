package com.bingoogol.spring.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/verifycode")
public class VerifyCodeController {

	@RequestMapping(value = "vcode", method = RequestMethod.GET)
	public void vcode(HttpServletResponse res, HttpSession session) throws IOException {
		String vcode = getVerifyCode();
		session.setAttribute("vcode", vcode);
		// 禁止图像缓存。
		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);
		res.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = res.getOutputStream();
		ImageIO.write(createImage(vcode), "jpeg", sos);
		sos.close();
	}
	
	private String getVerifyCode() {
		String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int len = codes.length();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			Double d = Math.random() * len;
			builder.append(codes.charAt(d.intValue()));
		}
		return builder.toString();
	}
	
	private BufferedImage createImage(String vcode) {
		// 验证码长度
		int codeLength = vcode.length();
		// 字体大小
		int fSize = 16;
		int fWidth = fSize + 1;
		// 图片宽度
		int width = codeLength * fWidth + 6;
		// 图片高度
		int height = fSize * 2 + 1;
		// 图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		// 设置背景色
		g.setColor(Color.WHITE);
		// 填充背景
		g.fillRect(0, 0, width, height);
		// 设置边框颜色
		g.setColor(Color.LIGHT_GRAY);
		// 边框字体样式
		g.setFont(new Font("Arial", Font.BOLD, height - 2));
		// 绘制边框
		g.drawRect(0, 0, width - 1, height - 1);
		// 绘制噪点
		Random rand = new Random();
		// 设置噪点颜色
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < codeLength * 6; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			// 绘制1*1大小的矩形
			g.drawRect(x, y, 1, 1);
		}
		// 绘制验证码
		int codeY = height - 10;
		// 设置字体颜色和样式
		Color[] colors = new Color[] { Color.red, Color.green, Color.blue, Color.orange };
		g.setFont(new Font("Georgia", Font.BOLD, fSize));
		for (int i = 0; i < codeLength; i++) {
			g.setColor(colors[rand.nextInt(4)]);
			g.drawString(String.valueOf(vcode.charAt(i)), i * 16 + 5, codeY);
		}
		// 关闭资源
		g.dispose();
		return image;
	}
	
}
