package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		cal();
		//intToChar(97);
		/*int[] intArr = {3,5,7,9};
		arrToList(intArr);
		char[] charr = chararr("somestring");
		System.out.println("==========");
		System.out.println(string(charr));
		int ia = ascii('a');
		char ca = ascii('a');
		System.out.println(ia);
		System.out.println(ca);*/
	}
	
	public static void cal() {
		System.out.println((4*100/24));
		float v = 17/10;
		System.out.println(v);
	}
	
	public static char ascii(char c) {
		return (char)((int)c);
	}
	
	public static char[] chararr(String str) {
		char[] chararr = str.toCharArray();
		
		for (int i = 0; i < chararr.length; i++) {
			System.out.println(chararr[i]);
		}
		return chararr;
	}
	
	public static String string(char[] charr) {
		return String.valueOf(charr);
	}
	
	public static void arrToList(int[] intArr) {
		List<Integer> list = Arrays.stream(intArr).boxed().collect(Collectors.toList());
		System.out.println(list);
	}
	
	public static void intToChar(int num) {
		char c = (char)num;
		System.out.println(c);
	}
	
	public static void charToint(char c) {
		int num = Character.getNumericValue(c);
		System.out.println(num);
		System.out.println(c-'0');
		
		float v = 0;
	}
}
