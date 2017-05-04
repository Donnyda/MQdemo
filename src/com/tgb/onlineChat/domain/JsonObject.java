package com.tgb.onlineChat.domain;

import java.io.Serializable;

public class JsonObject implements Serializable{
	
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	private String info;
	private String data;
	
	public JsonObject() {
    }
	
	public JsonObject(String info, String data) {
	    this.info = info;
	    this.data = data;
    }
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
