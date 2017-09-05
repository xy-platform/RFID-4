package com.r.domain;

import java.util.Date;

public class ChannelData {

	private String tid;
	private String sender;
	private String data;
	private Date datetime;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public ChannelData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChannelData(String tid, String sender, String data, Date datetime) {
		super();
		this.tid = tid;
		this.sender = sender;
		this.data = data;
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ChannelData [tid=" + tid + ", sender=" + sender + ", data=" + data + ", datetime=" + datetime + "]";
	}
}
