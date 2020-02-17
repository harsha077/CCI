package ArraysAndStrings;

import java.util.Arrays;
import java.util.Collections;


public class CheckIfStringHasDupChars {

	/**
	 * CCI  Arrays and Strings question 1
	 */
	public static void main(String[] args) {
		//getDuplicateChars("stringg");
		getDuplicates("string");
	}
	
	/*
	 * My solution with using getting ascii characters and Arrays API for sorting
	 * We Sort the ascii array
	 * Runtime: O(N Log N) 
	 */
	public static void getDuplicateChars(String value){
		int[] asciiArr = new int[value.length()];
		
		for (int i = 0; i < value.length(); i++) {
			asciiArr[i] = getAsciiValue(value.charAt(i));
		}
		
		Arrays.sort(asciiArr);
		
		for (int i = 0; i < asciiArr.length; i++) {
			if(i+1 > asciiArr.length-1){
				return;
			}
			
			if(asciiArr[i] == asciiArr[i+1]){
				System.out.println("Not Unique");
			}
		}
	}
	
	public static char getAsciiValue(char c){
		return (char)((int)c);
	}
	
	/*
	 *Cracking Coding interview solution using boolean array/Bitset vector 
	 *Runtime: O(N)
	 */
	public static void getDuplicates(String value){
		int[] asciiarr = new int[value.length()];
		boolean[] boolarr = new boolean[128];
		
		for(int i=0;i<value.length();i++){
			asciiarr[i] = getAsciiValue(value.charAt(i));
		}
		
		for (int i = 0; i < asciiarr.length; i++) {
			int asciiVal = asciiarr[i];
			if(boolarr[asciiVal] == true){
				System.out.println("All Characters are not unique");
			}
			boolarr[asciiVal] = true;
		}
		
	}

}
