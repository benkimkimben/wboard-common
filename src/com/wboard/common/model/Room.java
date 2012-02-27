package com.wboard.common.model;

import java.util.ArrayList;



public class Room {
	protected int id;
	protected String title;
	protected ArrayList<WUser> uList;
	
	public static final int FREE = 0;
	public static final int CONFERENCE = 1;
	
	public Room(){
		this.id = -1;
		this.title = "";
		uList = new ArrayList<WUser>();
	}
	public Room(String title) {
		this();
		this.title = title;
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
	
	public boolean addUser(WUser u){
		if(uList.add(u))
			return true;
		else 
			return false;
	}
	
	/**
	 * Linear search and remove
	 * @param uid
	 * @return
	 */
	public boolean removeUser(int uid){
		for(WUser u: uList){
			if(u.getId() == uid){
				uList.remove(u);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Linear search
	 * @param uid
	 * @return
	 */
	public boolean hasUser(int uid){
		for(WUser u: uList){
			if(u.getId() == uid){
				return true;
			}
		}
		return false;
	}
}