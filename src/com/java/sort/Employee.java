package com.java.sort;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	private String firstName;
	private String lastName;
	private int empId;
	
	public Employee(String firstName, String lastName, int empId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public int compareTo(Employee o) {
		int compareId = o.getEmpId();
		return this.empId - compareId;
	}	
	
	public static Comparator<Employee> EmployeeNameComparator = new Comparator<Employee>(){
		public int compare(Employee e1, Employee e2){
			String empLName1 = e1.getLastName().toLowerCase();
			String empLName2 = e2.getLastName().toLowerCase();
			return empLName1.compareTo(empLName2);
		}
	};
}