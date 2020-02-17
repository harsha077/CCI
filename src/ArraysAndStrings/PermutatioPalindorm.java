package ArraysAndStrings;

public class PermutatioPalindorm {

	/**
	 * CCI  Arrays and Strings question 4
	 */
	public static void main(String[] args) {
		int[] charrCountArr = new int[5];
		
		System.out.println(getIfPalindrome("catocat "));
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
	
	public static char getAscii(char c){
		return (char)((int)c);
	}

}
