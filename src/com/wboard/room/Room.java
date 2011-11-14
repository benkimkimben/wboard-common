package com.wboard.room;

import java.util.ArrayList;

import com.wboard.user.User;


public class Room {
	protected int id;
	protected String title;
	protected int leaderid;
	protected int type;
	protected ArrayList<User> uList;
	
	public static final int FREE = 0;
	public static final int CONFERENCE = 1;
	
	public Room(){
		this.id = -1;
		this.title = "";
		this.leaderid = -1;
		this.type = 0;
		uList = new ArrayList<User>();
	}
	public Room(String title, int leaderid, int type) {
		this();
		this.title = title;
		this.leaderid = leaderid;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLeaderId() {
		return leaderid;
	}
	
	public void setLeaderId(int leaderid) {
		this.leaderid = leaderid;
	}

	public int getType() {
		return type;
	}

	public void setType(int roomtype) {
		this.type = roomtype;
	}
}