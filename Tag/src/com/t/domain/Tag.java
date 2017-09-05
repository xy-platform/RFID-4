package com.t.domain;

public class Tag {

	private String tid;
	private String name;
	private String type;
	private String id;
	private String s;
	private String hash;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(String tid, String name, String type, String id, String s, String hash) {
		super();
		this.tid = tid;
		this.name = name;
		this.type = type;
		this.id = id;
		this.s = s;
		this.hash = hash;
	}
	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", name=" + name + ", type=" + type + ", id=" + id + ", s=" + s + ", hash=" + hash
				+ "]";
	}
}
