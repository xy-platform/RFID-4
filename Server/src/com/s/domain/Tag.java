package com.s.domain;

public class Tag {

	private String tid;
	private String id;
	private String s;
	private String hash;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public Tag(String tid, String id, String s, String hash) {
		super();
		this.tid = tid;
		this.id = id;
		this.s = s;
		this.hash = hash;
	}
	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", id=" + id + ", s=" + s + ", hash=" + hash + "]";
	}
}
