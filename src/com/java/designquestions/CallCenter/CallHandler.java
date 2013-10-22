package com.java.designquestions.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class CallHandler {
	private static CallHandler _instance = null;
	private final int LVLS = 3;
	private final int RESPONDENTS = 5;
	private final int MANAGERS = 3;
	private final int DIRECTORS = 2;

	List<List<Employee>> empLvls;
	List<List<Call>> callQueues;

	private CallHandler(){
		callQueues = new ArrayList<List<Call>>(LVLS);
		empLvls = new ArrayList<List<Employee>>(LVLS);
		
		ArrayList<Employee> respondents = new ArrayList<Employee>(RESPONDENTS);
		for(int i = 0; i <= RESPONDENTS; i++){
			respondents.add(new Respondent());
		}
		empLvls.add(respondents);
		
		ArrayList<Employee> managers = new ArrayList<Employee>(MANAGERS);
		for(int j = 0; j <= MANAGERS; j++){
			managers.add(new Manager());
		}
		empLvls.add(managers);
		
		ArrayList<Employee> directors = new ArrayList<Employee>(DIRECTORS);
		for(int k = 0; k <= DIRECTORS; k++){
			directors.add(new Director());
		}
		empLvls.add(directors);
	}
	
	public static CallHandler getInstance(){
		if(_instance == null){
			_instance = new CallHandler();
		}
		return _instance;
	}
	
	public Employee getFirstCallHandler(Call call){
		for(int i = call.getLvl_assigned().getVal(); i <= LVLS; i++){
			List<Employee> empLvl = empLvls.get(i);
			for(Employee emp: empLvl){
				if(emp.isAvailable()){
					return emp;
				}
			}
		}
		return null;
	}
	
	public boolean assignCall(Employee emp){
		for(int i = emp.isLevel().getVal(); i >= 0; i--){
			List<Call> q = callQueues.get(i);
			if(q.size() != 0){
				Call call = q.remove(0);
				if(call != null){
					emp.receiveCall(call);
					return true;
				}
			}
			
		}
		return false;
	}
	
	public void dispatchCall(Call call){
		Employee emp = getFirstCallHandler(call);
		if(emp != null){
			emp.receiveCall(call);
			call.setCallHandler(emp);
		}else{
			call.reply("Wait for an employee to free up");
			callQueues.get(call.getLvl_assigned().getVal()).add(call);
		}
	}


}
