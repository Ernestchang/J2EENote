package cn.wh.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

public class QueueSender {
	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
			QueueConnection conn = factory.createQueueConnection();
			QueueSession session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Destination destination = (Destination) ctx.lookup("queue/whQueue");
			MessageProducer producer = session.createProducer(destination);
			producer.send(session.createTextMessage("你好，世界"));
			session.close();
			conn.close();
			System.out.println("queue消息发送完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
