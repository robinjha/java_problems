package com.java.graphs;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class StdOut {
	
	// send output here
    private static PrintWriter out;
    
    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out), true);
        }
        catch (Exception e) { System.out.println(e); }
    }
    
    public static void print(float x) {
        out.print(x);
        out.flush();
    }

    public static void print(String x) {
        out.print(x);
        out.flush();
    }
    
    public static void print(int x) {
        out.print(x);
        out.flush();
    }
    
    public static void print(long x) {
        out.print(x);
        out.flush();
    }

    public static void print(short x) {
        out.print(x);
        out.flush();
    }
    
    public static void println() {
        out.println();
    }

    public static void println(Object x) {
        out.println(x);
    }

    public static void println(boolean x) {
        out.println(x);
    }

    public static void println(char x) {
        out.println(x);
    }

    public static void println(double x) {
        out.println(x);
    }

    public static void println(float x) {
        out.println(x);
    }

    public static void println(int x) {
        out.println(x);
    }

    public static void println(long x) {
        out.println(x);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
