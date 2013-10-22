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
			currCall = null;
		}
		assignNewCall();
	}
	
	public void reassignCall(){
		if(currCall != null){
			currCall.addLevel();
			CallHandler.getInstance().dispatchCall(this.currCall);
			currCall = null;
		}
	}
	
	public boolean isAvailable(){
		return currCall == null;
	}
	
	public boolean assignNewCall(){
		if(!isAvailable()){
			return false;
		}
		return CallHandler.getInstance().assignCall(this);
	}
	
	public void receiveCall(Call call){
		this.currCall = call;
	}
	
	public Level isLevel(){ 
		return level;
	}

}
