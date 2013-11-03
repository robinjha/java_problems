package com.java.threads;

public class ThreadObj {
	public synchronized void test(String name){
		try{
			System.out.println("Thread "+ name + ".test(): starting.");
			Thread.sleep(3000);
			System.out.println("Thread "+ name + ".test(): terminating.");
		}catch(InterruptedException ex){
			System.out.println("Thread" + name + ": interrupted.");
		}
	}
	
	public static synchronized void test1(String name){
		try{
			System.out.println("Thread "+ name + ".test1(): starting.");
			Thread.sleep(3000);
			System.out.println("Thread "+ name + ".test1(): terminating.");
		}catch(InterruptedException ex){
			System.out.println("Thread" + name + ": interrupted.");
		}
	}
	
	public static synchronized void test2(String name){
		try{
			System.out.println("Thread "+ name + ".test2(): starting.");
			Thread.sleep(3000);
			System.out.println("Thread "+ name + ".test2(): terminating.");
		}catch(InterruptedException ex){
			System.out.println("Thread" + name + ": interrupted.");
		}
	}

}
