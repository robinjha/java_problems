package com.java.threads;

import java.util.ArrayList;
import java.util.List;

public class RunnableExample implements Runnable{
	private long count = 0;

	RunnableExample(long count){
		this.count = count;
	}
	@Override
	public void run() {
		System.out.println("Starting runnable thread.....");
		long sum = 0;
		for(int i = 0; i < count; i++){
			sum+=i;
		}
		System.out.println(sum);
		System.out.println("Terminating runnable thread.....");
	}
	
	public static void main(String[] args){
		
		List<Thread> thread = new ArrayList<Thread>();
		for(int j = 0; j < 10; j++){
			RunnableExample runEx = new RunnableExample(100000L + j);
			Thread t = new Thread(runEx);
			t.setName(String.valueOf(j));
			t.start();
			thread.add(t);
		}
		int running = 0;
		do{
			running = 0;
			for(Thread t: thread){
				if(t.isAlive()){
					running++;
				}
			}
			System.out.println("Running threads :" + running);
		}while(running > 0);
		
		
		
	}

}
