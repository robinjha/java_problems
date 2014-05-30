package com.java.discountoffers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class HelperFunctions {
	private static String[] products;
	private static String[] customers;
    private static final String consonants = "bcdfghjklmnpqrstvwxz";
    private static final String vowels = "aeiou";

	/**
	 * function to find the gcd of two numbers
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int gcd(int num1, int num2){
		return BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2)).intValue();
	}

	/**
	 * takes in the location of the file and separates the 
	 * customers and products
	 * @param filePath
	 */
	public static void populateProductsAndCustomers(String filePath){
		BufferedReader file = null;

		try{
			file = new BufferedReader(new FileReader(filePath));
			String line = null;
			System.out.println("----------Lines read from the file------------");
			while ((line = file.readLine()) != null){
				System.out.println(line);
				if (line.contains(";")) {  // to test beforehand if the string contains ; before attempting to split
					String[] parts = line.split(";");
					setCustomers(parts[0].split(","));
					setProducts(parts[1].split(","));
				}else {
					throw new IllegalArgumentException("String " + line + " does not contain ;");
				}
			}
			System.out.println("-----------------------------------------------");

		}catch (FileNotFoundException ex){
			System.err.println("Cannot open file!");
		}catch (IOException ex){
			System.exit(0);
		}finally{
			System.out.println("Customers: " + Arrays.toString(customers)); //printing out to check out the values
			System.out.println("Products: " + Arrays.toString(products));  //printing out to check out the values
			try{
				if(file != null)
					file.close();
			}catch (IOException ex){
				System.err.println(ex);
			}
		}

	}

	public static String[] getCustomers() {
		return customers;
	}

	public static void setCustomers(String[] customers) {
		HelperFunctions.customers = customers;
	}

	public static String[] getProducts() {
		return products;
	}

	public static void setProducts(String[] products) {
		HelperFunctions.products = products;
	}

	public static float numberOfConsonants(String str) {
		return count(str.toLowerCase(), consonants);
	}
	
	public static float numberOfVowels(String str) {
		return count(str.toLowerCase(), vowels);
	}

	public static int count(String str, String pattern) {
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(pattern.indexOf(c) != -1)
				count++;
		}
		return count;
	}
}
