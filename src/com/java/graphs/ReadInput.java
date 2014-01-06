package com.java.graphs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;

public class ReadInput {
	private Scanner scanner;
	
	public ReadInput() {
        scanner = new Scanner(new BufferedInputStream(System.in));
    }

	public int readInt() {
        return scanner.nextInt();
    }
	
	public ReadInput(File file) {
        try {
            scanner = new Scanner(file);
        }
        catch (IOException ioe) {
            System.err.println("Could not open " + file);
        }
    }
	
	public ReadInput(String s) {
        try {
            // first try to read file from local file system
            File file = new File(s);
            if (file.exists()) {
                scanner = new Scanner(file);
                return;
            }

            // next try for files included in jar
            URL url = getClass().getResource(s);

            // or URL from web
            if (url == null) { url = new URL(s); }
            URLConnection site = url.openConnection();
            InputStream is     = site.getInputStream();
            scanner            = new Scanner(new BufferedInputStream(is));
        }
        catch (IOException ioe) {
            System.err.println("Could not open " + s);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
