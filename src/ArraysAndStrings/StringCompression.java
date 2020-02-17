package ArraysAndStrings;

public class StringCompression {
	
	/*
	 * CCI Arrays and Strings Question 6
	 */
	public static void main(String[] args) {
		System.out.println(compressString("aaabbbcccaa"));
	}
	
	/*
	 * My Solution 
	 * Runtime: O(n)
	 * Solving time: more than 2 hours
	 */
	public static String compressString(String str) {
		char[] charArr = new char[str.length()];
		String resultString=null;
		int i=-2,j=0;
		while(j<str.length()) {
			if(i>=0 && charArr[i]==str.charAt(j)) {
				int num = charArr[i+1] - '0';
				num=num+1;
				charArr[i+1] = (char)(num +'0') ;
			}else {
				i=i+2;
				charArr[i] = str.charAt(j);
				charArr[i+1] = (char)(1+'0');
			}
			j++;
		}
		
		resultString = String.valueOf(charArr);
		
		return resultString;
	}
}
