package com.java.designquestions.CallCenter;

public class Caller {
	private String name;
    private int userId;
    public Caller(int id, String nm) {
            setName(nm);
            setUserId(id);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
