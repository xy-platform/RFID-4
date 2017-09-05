package com.r.domain;

public class Reader {

	private String tid;
	private String name;
	private String type;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reader(String tid, String name, String type) {
		super();
		this.tid = tid;
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Reader [tid=" + tid + ", name=" + name + ", type=" + type + "]";
	}
}
