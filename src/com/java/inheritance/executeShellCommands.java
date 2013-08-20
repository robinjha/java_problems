package com.java.inheritance;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class executeShellCommands {
	public static void main(String[] args){
		String s;
		Process p;
		try{
			p = Runtime.getRuntime().exec("ls -al");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((s = br.readLine()) != null){
				System.out.println("Line :" + s);
				p.waitFor();
				p.destroy();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
