package com.tgb.onlineChat.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatRecordUtil {
	
	private static String saveBasePath="e:/Mchat/";
	
	private ChatRecordUtil(){}
	
	public static void saveChatHistory(String msg,String user){
		Date date=new Date();
		String chatDate=new SimpleDateFormat("yyyy_MM_dd").format(date);
		String fileDirPath=saveBasePath+user+"/";
		String filePath=fileDirPath+chatDate+".txt";
		//判断是否存在文件夹
		File fileDir=new File(fileDirPath);
		File file=new File(filePath);
		if(!fileDir.exists()){
			if(fileDir.mkdirs()){
				try {
					file.createNewFile();
                } catch (IOException e) {
	                e.printStackTrace();
	                System.out.println("创建文件失败");
                }
			};
		}
		
		//将消息写入文件
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true)));
			out.write(msg);
			out.flush();
			out.close();
        } catch (Exception e) {
	        e.printStackTrace();
        }
	}
	
	public static String readChatHistory(Date date,String user){
		String chatDate=new SimpleDateFormat("yyyy_MM_dd").format(date);
		String fileDirPath=saveBasePath+user+"/";
		String filePath=fileDirPath+chatDate+".txt";
		//判断是否存在文件夹
		File file=new File(filePath);
		if(!file.exists()){
			return null;
		}
		StringBuffer sb=new StringBuffer();
		try {
	        BufferedReader br=new BufferedReader(new FileReader(file));
	        String msg="";
	        while((msg=br.readLine())!=null){
	        	sb.append(msg);
	        	System.out.println(msg);
	        }
	        return sb.toString();
        } catch (Exception e) {
	        e.printStackTrace();
        }
		
		return null;
		
	}
}
