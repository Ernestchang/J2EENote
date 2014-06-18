package cn.wh.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class TopicSender {
	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
			TopicConnection conn = factory.createTopicConnection();
			TopicSession session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
			Destination destination = (Destination) ctx.lookup("topic/whTopic");
			MessageProducer producer = session.createProducer(destination);
			producer.send(session.createTextMessage("你好，我是topic消息"));
			session.close();
			conn.close();
			System.out.println("topic消息发送完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
