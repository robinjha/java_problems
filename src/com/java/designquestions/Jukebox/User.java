package com.java.designquestions.Jukebox;

public class User {

	private String userName;
	private int uid;
	
	public User(String name, int uid){
		this.userName = name;
		this.uid = uid;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User getUser(){
		return this;
	}
	
	public void deleteUser(){
		
	}
	
	public void addCredit(){
		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void addUser(String user, int uid){
		
	}
	
	
}
