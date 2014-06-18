package cn.wh.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Topic"),
	@ActivationConfigProperty(propertyName="destination",propertyValue="topic/whTopic")
})
public class ReceiveBean2 implements MessageListener {

	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println(this.getClass().getName() + ":" + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
