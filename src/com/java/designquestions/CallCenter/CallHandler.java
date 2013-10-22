package com.java.designquestions.CallCenter;

import java.util.List;
import java.util.Queue;

public class CallHandler {
	private static CallHandler _instance = null;
	private final int lvls = 3;

	List<List<Employee>> employeeLvls;
	Queue<Call> callQueues;

	public static CallHandler getInstance(){
		if(_instance == null){
			_instance = new CallHandler();
		}
		return _instance;
	}
	
	public void assignCall(Employee emp){
		
	}
	
	public void dispatchCall(Call call){
		
	}


}
