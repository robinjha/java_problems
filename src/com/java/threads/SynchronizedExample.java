package com.java.threads;

import java.util.concurrent.locks.Lock;

public class SynchronizedExample extends Thread {
	
	private String name;
	private ThreadObj tObj;
	Lock myLock;
	
	
	
	SynchronizedExample(ThreadObj tObj, String name){
		this.name = name;
		this.tObj = tObj;
	}
	
	public void run(){
		if(name.equals("thread3"))ThreadObj.test1(name);
		else if(name.equals("thread4"))ThreadObj.test2(name);
	}
	
//	public void run(){
//		tObj.test(name);
//	}
	
	public static void main(String[] args){
//		when using the reference to different object
//		ThreadObj obj1 = new ThreadObj();
//		ThreadObj obj2 = new ThreadObj();
//		SynchronizedExample thread1 = new SynchronizedExample(obj1, "thread1");
//		SynchronizedExample thread2 = new SynchronizedExample(obj2, "thread2");
//		thread1.start();
//		thread2.start();
		
		//when using the reference to the same object.
		ThreadObj obj3 = new ThreadObj();
		SynchronizedExample thread3 = new SynchronizedExample(obj3, "thread3");
		SynchronizedExample thread4 = new SynchronizedExample(obj3, "thread4");
		thread3.start();
		thread4.start();
	}

}
