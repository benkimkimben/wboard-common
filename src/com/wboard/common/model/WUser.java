package com.wboard.common.model;

import java.io.IOException;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.security.User;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;


public class WUser extends User{
	protected int id;
	protected String username;
	protected Role role;
	
	// permission b000: right most digit is the write permission. Others left for future use.
	protected int permission;
	
	// user role
	public static enum Role {MANAGER, CLERK, MEMBER};
	
	public WUser(){
		this.username = "";
		this.role = Role.MEMBER;
		this.permission = 0;
	}
	public WUser(String username) {
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
	@Override
	public String getShortName() {
		return username;
	}
	@Override
	public void obtainAuthTokenForJob(JobConf arg0) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void obtainAuthTokenForJob(Configuration arg0, Job arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <T> T runAs(PrivilegedAction<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T runAs(PrivilegedExceptionAction<T> arg0) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}
