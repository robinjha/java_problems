package com.java.designpatterns;

public class Singleton {
	private static Singleton instance = new Singleton(); //variable is static to keep it the only instance
	
	private Singleton(){ //constructor is private so that any other class cannot create an 
		//instance of it as they will have no access to it.
	}
	
	/**
	 * 
	 * @return instance - only method that can be accessed to get the instance
	 * we use synchronized to protect against more than one thread access to this method
	 * at the same time. 
	 */
	public static synchronized Singleton getInstance(){
		return instance;
	}
	
	public void doSomething(){
		for(int i = 0; i < 10; i++){
			System.out.println("i =" + i);
		}
	}
	
	/**
	 * Override the clone() method and throw an exception so that 
	 * another instance cannot be created by cloning the singleton object.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Clone is not allowed");
	}
	
	public static void main(String[] args){
		Singleton service = new Singleton();
		service.doSomething();
	}

}
