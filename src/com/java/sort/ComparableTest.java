package com.java.sort;

import java.util.Arrays;

public class ComparableTest {
	public static void main(String[] args) {
		Employee[] emp = new Employee[4];
		
		Employee emp3 = new Employee("Roger","Federer",3);
		Employee emp4 = new Employee("Michael P","Phelps",4);
		Employee emp1 = new Employee("Michael J","Jordan",1);
		Employee emp2 = new Employee("Michael S","Schumacher",2);
		
		emp[0] = emp3;
		emp[1] = emp4;
		emp[2] = emp1;
		emp[3] = emp2;
		
		Arrays.sort(emp);
		int count = 0;
		for(Employee e: emp){
			System.out.println("Employees " + ++count + ":" + e.getFirstName() +"," + e.getEmpId());
		}
	}

}
