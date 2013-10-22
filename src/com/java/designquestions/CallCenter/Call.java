package com.java.designquestions.CallCenter;

public class Call {
	private Employee callHandler;
	private Level lvl_assigned;
	private Caller caller;
	
	public Employee getCallHandler() {
		return callHandler;
	}
	public void setCallHandler(Employee callHandler) {
		this.callHandler = callHandler;
	}
	public Level getLvl_assigned() {
		return lvl_assigned;
	}
	public void setLvl_assigned(Level lvl_assigned) {
		this.lvl_assigned = lvl_assigned;
	}
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
		this.caller = caller;
	}
	
	public void reply(String message) {
        System.out.println(message);
	}

	public void disconnect(){
		reply("Thank you for the call. Bye!!");
	}
	
		
}
