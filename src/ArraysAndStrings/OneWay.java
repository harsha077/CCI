package ArraysAndStrings;

public class OneWay {

	/**
	 * CCI Arrays and Strings question 5
	 */
	public static void main(String[] args) {
		System.out.println(getOneWay("pale","bake"));
	}
	 
	/**
	 * My Solution which satisfies all the conditions in the question
	 * O(n)
	 */
	public static boolean getOneWay(String str1, String str2){
		
		int strLen1 = str1.length();
		int strLen2 = str2.length();
		int totalChanges = 0;
		int lenDiff = strLen1 - strLen2;
		
		if(lenDiff < -1 || lenDiff > 1){
			return false;
		}
		
		char[] charArr = null;
		String bigStr = null;
		String smallStr = null;
		
		if(strLen1 > strLen2){
			charArr = new char[strLen1];
			bigStr = str1;
			smallStr = str2;
			totalChanges = DiffLengthStrings(bigStr, smallStr);
		}else if(strLen1 < strLen2){
			charArr = new char[strLen2];
			bigStr = str2;
			smallStr = str1;
			totalChanges = DiffLengthStrings(bigStr, smallStr);
		}else{
			totalChanges = sameLengths(str1, str2);
		}
		
		if(totalChanges > 1){
			return false;
		}

		return true;
	}
	
	public static int sameLengths(String str1, String str2){
		int totalChanges = 0;
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)){
				totalChanges = totalChanges + 1;
			}
		}
		return totalChanges;
	}
	
	public static int DiffLengthStrings(String bigStr, String smallStr){
		int j=0;
		int totalChanges = 0;
		for(int i=0;i<bigStr.length();i++){
			if(j < smallStr.length() && bigStr.charAt(i) == smallStr.charAt(j)){
				j=j+1;
			}else{
				totalChanges = totalChanges + 1;
			}
		}
		
		return totalChanges;
	}
	
	public static char getAscii(char c){
		return (char)((int)c);
	}

}
