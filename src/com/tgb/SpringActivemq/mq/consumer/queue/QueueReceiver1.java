
package com.tgb.SpringActivemq.mq.consumer.queue;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.tgb.onlineChat.utils.ChatRecordUtil;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiver1 implements MessageListener {
	
	@Override
	public void onMessage(Message message) {
		try {
			//System.out.println("QueueReceiver1接收到消息:"+((TextMessage)message).getText());
			String msg=((TextMessage)message).getText();
			String chatTime=new SimpleDateFormat("HH:mm:ss").format(new Date());
			msg="<"+chatTime+" "+msg+">";
			ChatRecordUtil.saveChatHistory(msg, "laidong");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
