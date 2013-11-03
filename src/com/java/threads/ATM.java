package com.java.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
	private double balance = 0.0;
	private Lock atmLock;
	
	ATM(){
		atmLock = new ReentrantLock();
	}
	
	public double deposit(double d){
		atmLock.lock();
		try{
			Thread.sleep(5000);
			balance+=d;
			Thread.sleep(5000);
		}catch(InterruptedException ex){}
		atmLock.unlock();
		return balance;
	}
	
	public double withdraw(double d) throws Exception{
		atmLock.lock();
		try{
			if(balance < d || balance == 0){
				throw new Exception("Not enough balance in the account!");
			}
			else{
				balance-=d;
			}
		}catch(InterruptedException ex){}
		return balance;
	}
	
	public static void main(String[] args) throws Exception{
		ATM atm = new ATM();
		System.out.println("New Balance after deposit is :" + atm.deposit(100));
		System.out.println("New Balance after withdraw is :" + atm.withdraw(50));
	}

}
