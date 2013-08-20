package com.java.inheritance;

import java.util.Scanner;

public class InheritanceTester {
	public static void main(String[] args){
		Progression prog;
		int choice;
		System.out.println("Enter the choice for version: {ArithProgression : 1} {GeomProgression : 2}");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		
		scan.close();
		System.out.println("Choice : " + choice);
		
		switch(choice){
		case 1: 
			System.out.println("Executing Arithmetic Progression");
			prog = new ArithProgression(5);
			prog.printProgression(10);
		  break;
		case 2:
			System.out.println("Executing Geometric Progression");
			prog = new GeomProgression(3);
			prog.printProgression(10);
		  break;
		}
		
		
	}
}
