package com.java.designquestions.CallCenter;

public abstract class Employee {
	
	private Call currCall = null;
	protected Level level;
	
	public Call getCurrCall() {
		return currCall;
	}

	public void setCurrCall(Call currCall) {
		this.currCall = currCall;
	}
	
	public void completeCall(Call call){	
		if(currCall != null){
			call.disconnect();
		}
	}
	
	public void reassignCall(){}
	
	public boolean isAvailable(){
		boolean free = false;
		if(currCall == null){
			free = true;
		}else{
			free = false;
		}
		return free;
		
	}
	
	public void assignNewCall(){}
	
	public void receiveCall(Call call){
		this.currCall = call;
	}
	
	public Level isLevel(){ 
		return level;
	}

}
