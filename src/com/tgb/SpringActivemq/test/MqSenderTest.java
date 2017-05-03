package com.tgb.SpringActivemq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tgb.SpringActivemq.mq.producer.queue.QueueSender;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ActiveMQ.xml","classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class MqSenderTest {
	
	@Autowired
	QueueSender sender;
	
	@Test
	public void testSend() {
		sender.send("test.queue", "你个傻逼");
	}

}
