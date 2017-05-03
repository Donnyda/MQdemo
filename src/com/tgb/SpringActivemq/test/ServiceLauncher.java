package com.tgb.SpringActivemq.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ServiceLauncher {
	 public static void main(String[] args) throws IOException {
	        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ActiveMQ.xml", "classpath:applicationContext.xml", "classpath:spring-mvc.xml");
	        ctx.start();
	        System.in.read();
	        ctx.close();
	    }
}
