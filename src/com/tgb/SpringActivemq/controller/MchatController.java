package com.tgb.SpringActivemq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.SpringActivemq.mq.producer.queue.QueueSender;
import com.tgb.onlineChat.domain.JsonObject;
import com.tgb.onlineChat.utils.ChatRecordUtil;

@Controller
@RequestMapping("/mchat")
public class MchatController {
	@Autowired
	private QueueSender queueSender;
	
	//进入页面
	@RequestMapping("index")
	public String mchat(){
		return "mchat";
	}
	
	//获取数据
	@RequestMapping(value="loadChat")
	@ResponseBody
	public JsonObject loadChat(){
		Date date=new Date();
		String user="laidong";
		String records=ChatRecordUtil.readChatHistory(date, user);
		return new JsonObject("success",records);
	}
	
	@RequestMapping("sendMsg")
	public void sendMsg(String msg){
		//发送并保存消息
		//发送消息
		queueSender.send("laidong.queue",msg);
		ChatRecordUtil.saveChatHistory(msg, "laidong");
	}
	
	
}
