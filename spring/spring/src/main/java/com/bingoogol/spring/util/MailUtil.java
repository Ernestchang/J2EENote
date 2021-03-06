package com.bingoogol.spring.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
	private static String targetSMTP = "smtp.126.com";
	public static String username = "algorithmhome@126.com";
	private static String password = "jsjyxxgcxy";

	public static Session createSession() {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", targetSMTP);
		properties.put("mail.smtp.auth", "true");// 链接认证
		properties.put("mail.debug", "true");// 在控制台显示链接日志信息
		properties.put("mail.stmp.timeout", 3000);// 在控制台显示链接日志信息
		return Session.getInstance(properties);
	}

	public static void sendMail(Session session, Message message) throws MessagingException {
		Transport transport = session.getTransport();
		transport.connect(username, password);
		transport.sendMessage(message, message.getAllRecipients());
	}

	public static void sendActiveLink(String to, String username, String id, String activecode) throws MessagingException {
		// 1.创建与邮件服务器的链接会话
		Session session = MailUtil.createSession();
		// 2.通过session创建message邮件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(MailUtil.username));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("算法之家账户激活通知");
		StringBuilder sb = new StringBuilder();
		sb.append("<style type='text/css'>");
		sb.append(".panel {width:800px;background-color: #ffffff;border: 1px solid transparent;border-radius: 4px;-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);border-color: #428bca;}");
		sb.append(".panel-body {padding: 15px;}");
		sb.append(".panel-body:before, .panel-body:after {display: table;content: '            ';}");
		sb.append(".panel-body:after, .panel-body:after {clear: both;}");
		sb.append(".panel-heading {padding: 10px 15px;border-bottom: 1px solid transparent;border-top-right-radius: 3px;border-top-left-radius: 3px;color: #ffffff;background-color: #428bca;border-color: #428bca;}");
		sb.append(".panel-title {margin-top: 0;margin-bottom: 0;font-size: 16px;text-align: center;}");
		sb.append(".btn {text-decoration: none;color: #ffffff;background-color: #428bca;border-color: #357ebd;display: inline-block;padding: 6px 12px;margin-bottom: 0;font-size: 14px;font-weight: normal;line-height: 1.428571429;text-align: center;white-space: nowrap;vertical-align: middle;cursor: pointer;border: 1px solid transparent;border-radius: 4px;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;-o-user-select: none;user-select: none;}");
		sb.append(".btn:focus {outline: thin dotted #333;outline: 5px auto -webkit-focus-ring-color;outline-offset: -2px;color: #ffffff;background-color: #3276b1;border-color: #285e8e;}");
		sb.append(".btn:hover, .btn:focus {text-decoration: none;color: #ffffff;background-color: #3276b1;border-color: #285e8e;}");
		sb.append(".btn:active, .btn.active {background-image: none;outline: 0;-webkit-box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);background-image: none;}");
		sb.append("</style>");
		sb.append("<div class='panel'>");
		sb.append("<div class='panel-heading'><h3 class='panel-title'>算法之家账户激活通知</h3></div>");
		sb.append("<div class='panel-body'>欢迎您注册算法之家，请点击右侧链接激活您的账号 " + username + "   <a href='http://localhost:7777/front/user/active/" + activecode + "/" + id + "' class='btn'>激活帐号</a></div>");
		sb.append("</div>");
		MimeBodyPart content = new MimeBodyPart();
		content.setContent(sb.toString(), "text/html;charset=utf-8");
		MimeMultipart mimeMultipart = new MimeMultipart();
		mimeMultipart.addBodyPart(content);
		message.setContent(mimeMultipart);
		// 3.使用Transport发送邮件
		MailUtil.sendMail(session, message);

	}

	public static void sendActiveCode(String to, String activecode) throws MessagingException {
		// 1.创建与邮件服务器的链接会话
		Session session = MailUtil.createSession();
		// 2.通过session创建message邮件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("算法之家账户激活");
		message.setText("您的激活码是：" + activecode);
		// 3.使用Transport发送邮件
		MailUtil.sendMail(session, message);

	}
}
