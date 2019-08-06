package Arrays;

public class PermutationPalindorm {

	/**
	 * CCI  Arrays and Strings question 4
	 */
	public static void main(String[] args) {
		int[] charrCountArr = new int[5];
		
		System.out.println(getIfPalindrome3("Tact coa"));
	}
	
	/**
	 * My Solution without considering the extra space given in the CCI Arrays and Strings question 4
	 * O(n)
	 * 	 */
	public static boolean getIfPalindrome(String str){
		
		int len = str.length();
		boolean even = false;
		int[] charCountArr = new int[128];
		if(len%2==0){even=true;}
		
		for (int i = 0; i < str.length(); i++) {
			int ascii = getAscii(str.charAt(i));
			int num = charCountArr[ascii];
			num=num+1;
			charCountArr[ascii] = num;
		}
		
		if(even){
			for (int i = 0; i < charCountArr.length; i++) {
				if(charCountArr[i]%2!=0){
					return false;
				}
			}
		}else{
			boolean isOneOdd = true;
			for(int i=0; i<charCountArr.length;i++){
				if(charCountArr[i] == 1 && isOneOdd == true){
					isOneOdd = false;
					continue;
				}
				
				if(charCountArr[i]%2!=0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * My Solution 2 which considers special characters too, But it cannot handle if cases are different.
	 * Runtime: O(n) 
	 */
	public static boolean getIfPalindrome2(String str){
		int charArrCharCount = 0;
		int[] charAsciiArr = new int[128];
		int totalChars = 0;
		for(int i=0;i<str.length();i++){
			int num = 0;
			
			int ascii = getAscii(str.charAt(i));
			if((ascii>65 && ascii<90) || (ascii>97 && ascii<122)){
				totalChars = totalChars + 1;
				if(charAsciiArr[ascii] == 0){
					charAsciiArr[ascii] = 1; 
					charArrCharCount = charArrCharCount + 1;
				}else if(charAsciiArr[ascii] > 0){
					num = charAsciiArr[ascii];
					num = num - 1;
					charAsciiArr[ascii] = num;
					charArrCharCount = charArrCharCount - 1;
				}
			}
		}
		if(totalChars%2 == 0 && charArrCharCount == 0){
			return true;
		}else if(totalChars%2 == 1 && charArrCharCount == 1){
			return true;
		}
		return false;
	}
	
	/*
	 * My Solution 3, It considers spaces and capitol letters also.
	 * Runtime: O(n) 
	 */
	public static boolean getIfPalindrome3(String str){
		int totalCharCount = 0;
		int charAsciiArrCharCount = 0;
		int[] charAsciiArr = new int[128];
		
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(c.isLetter(c)){
				totalCharCount = totalCharCount + 1;
				if(c.isUpperCase(c)){
					c = c.toLowerCase(c);
				}
				
				int ascii = getAscii(c);
				int num = charAsciiArr[ascii];
				
				if(num == 0){
					charAsciiArr[ascii] = 1;
					charAsciiArrCharCount = charAsciiArrCharCount + 1;
				}else if(num > 0){
					num = num - 1;
					charAsciiArr[ascii] = num;
					charAsciiArrCharCount = charAsciiArrCharCount - 1;
				}
			}
		}
		
		if(totalCharCount%2 == 0 && charAsciiArrCharCount == 0){
			return true;
		}else if(totalCharCount%2 == 1 && charAsciiArrCharCount == 1){
			return true;
		}
		
		return false;
	}
	
	public static char getAscii(char c){
		return (char)((int)c);
	}

}
