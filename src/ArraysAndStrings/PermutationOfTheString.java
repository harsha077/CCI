package ArraysAndStrings;

public class PermutationOfTheString {

	/*
	 * CCI  Arrays and Strings question 2
	 */
	public static void main(String[] args) {
		System.out.println(getIfPermuted("tr\\s", "\\str"));
	}
	
	/**
	 * My Solutiion using Boolean arr/BitSet
	 * Runtime: O(n)
	 */
	public static boolean getIfPermuted(String str1,String str2){
		
		if((str1.length() != str2.length()) || (str1.length()==0 || str2.length()==0)){
			return false;
		}
		
		int[] asciiarr1 = new int[str1.length()];
		int[] asciiarr2 = new int[str2.length()];
		boolean[] boolarr = new boolean[128];
		
		for(int i=0;i<str1.length();i++){
			int asciival1 = getAscii(str1.charAt(i));
			int asciival2 = getAscii(str2.charAt(i));
			asciiarr1[i] = asciival1;
			asciiarr2[i] = asciival2;
			boolarr[asciival1] = true;
		}
		
		for(int i=0;i<asciiarr2.length;i++){
			if(boolarr[asciiarr2[i]] != true){
				return false;
			}
		}
		
		return true;
	}
	
	public static char getAscii(char c){
		return (char)((int)c);
	}

}
