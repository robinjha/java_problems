package com.java.dssd;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.util.Date;
/**
 * 1. Write a brief program in one of the above programming languages that, given a list of file 

names, will display the name of the mostly recently accessed file. For example, if /tmp/a was the 

most recently accessed file, then

 $ program /tmp/a /tmp/b /tmp/c

 /tmp/a
 */
import java.util.ArrayList;
import java.util.Date;


public class MostRecentAccessed {
	
	public static File mostRecentFile(ArrayList<File> filePaths){
		
		long lastMod = Long.MIN_VALUE;
		File choise = null;
		for (File file : filePaths) {
			if (file.lastModified() > lastMod) {
				choise = file;
				lastMod = file.lastModified();
			}
		}
		return choise;
	}
	
	public static ArrayList<File> createFileObjs(String[] args){
		ArrayList<File> fileList = new ArrayList<File>();
		if(args.length < 1){
			System.err.println( "Enter at least one file name");

		}else if(args.length == 1){
			File f = new File(args[0]);
			if(f.isFile()) //checks if the argument is a file
				fileList.add(new File(args[0])); //adds it to the list if it is
			return fileList;
		}else{

			int i = 0;
			
			System.out.println("~~~~~FILES IN THE LIST~~~~~~~~~~~");
			for (i = 0; i < args.length; i++){
				File f = new File(args[i]);
				if(f.isFile()){
					System.out.println(args[i]);
					fileList.add(new File(args[i]));
				}
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Most recently accessed : " + mostRecentFile(fileList));
		}
		return fileList;
	}

	public static void main(String[] args) {
		mostRecentFile(createFileObjs(args));
		
	}

}
