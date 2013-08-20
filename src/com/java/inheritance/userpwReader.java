package com.java.inheritance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class userpwReader {
	public static void main(String[] args) throws Exception {
    Map<String, String> map = new HashMap<String, String>();
    BufferedReader in = new BufferedReader(new FileReader("/Users/rjha/workspace/inheritancetest/src/com/java/inheritance/usercredentials.txt"));
    String line = "";
    while ((line = in.readLine()) != null) {
        String parts[] = line.split(",");
        map.put(parts[0], parts[1]);
    }
    in.close();
    System.out.println(map.toString());
}

}
