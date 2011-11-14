package com.wboard.user;


public class User {
	protected int id;
	protected String username;
	protected Role role;
	
	// permission b000: right most digit is the write permission. Others left for future use.
	protected int permission;
	
	// user role
	public static enum Role {MANAGER, CLERK, MEMBER};
	
	public User(){
		this.username = "";
		this.role = Role.MEMBER;
		this.permission = 0;
	}
	public User(String username) {
		super();
		this.username = username;
		this.role = Role.MEMBER;
		this.permission = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	// Permission calculation //
	
	public boolean getWritePermission(){
		return ((permission & 1) == 1) ? true : false;
	}
	public void setWritePermission(boolean write){
		if(write)
			permission = (permission | 1);
		else
			permission = permission & Integer.MAX_VALUE - 1;
	}
}
