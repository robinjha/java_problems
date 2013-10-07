package com.java.designpatterns;

public class SingletonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton service = Singleton.getInstance();
		service.doSomething();
	}

}
