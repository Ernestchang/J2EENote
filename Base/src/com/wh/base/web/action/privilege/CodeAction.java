package com.wh.base.web.action.privilege;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class CodeAction extends ActionSupport {
	private static final long serialVersionUID = 5117690030819386116L;
	private int width = 80;
	private int height = 30;
	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 禁止浏览器缓存图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 通知客户机以图片方式打开发过去的数据
		response.setHeader("Content-Type", "image/jpeg");
		// 在内存中创建一幅图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		drawCode(image.getGraphics());
		ImageIO.write(image, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	private void drawCode(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Color[] colors = new Color[]{Color.red,Color.green,Color.blue,Color.orange};
		Font font = null;
		String code = makeCode();
		ActionContext.getContext().getSession().put("checkcode", code);
		int len = code.length();
		for(int i = 0; i < len; i++) {
			Double size = Math.random()*10 + 20;
			Double y = height - Math.random()*10;
			Double c = Math.random()*4;
			Double x1 = Math.random()*width;
			Double y1 = Math.random()*height;
			Double x2 = Math.random()*width;
			Double y2 = Math.random()*height;
			g.setColor(colors[c.intValue()]);
			font = new Font("宋体", Font.ITALIC, size.intValue());
			g.setFont(font);
			g.drawString(code.charAt(i) + "", i*20, y.intValue());
			g.drawLine(x1.intValue(), y1.intValue(),x2.intValue(),y2.intValue());
		}
	}

	private String makeCode() {
		String codes = "abcdefghijklmnopqrstuvwxyz0123456789";
		int len = codes.length();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			Double d = Math.random()*len;
			builder.append(codes.charAt(d.intValue()));
		}
		return builder.toString();
	}
}
