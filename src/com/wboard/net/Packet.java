package com.wboard.net;

import java.io.Serializable;
/**
 * Wrapper class of objects that will be sent through pipeline
 * @author SKCCADMIN
 *
 */
public class Packet implements Serializable{

	private static final long serialVersionUID = 3333L;
	
	private String header;
	private Object content;
	public Packet(String header, Object content) {
		super();
		this.header = header;
		this.content = content;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
}
