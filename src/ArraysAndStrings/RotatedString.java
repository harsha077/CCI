package ArraysAndStrings;

public class RotatedString {

	/*
	 * CCI Arrays and Strings 
	 */
	public static void main(String[] args) {
		System.out.println(isSubstring("water", "erwater"));
	}
	
	/*
	 * My Solution 
	 * Runtime: O(n)
	 * Solving time: 1hr 5minutes
	 */
	public static boolean isSubstring(String str1,String str2) {
		
	if(str1.length() != str2.length()) {
		return false;
	}
	
	boolean isRoated = false;
	int endIndexStr2=0;
	int i=0;
	
		for(int k=0;k<str2.length();k++) {
			if(str1.charAt(i)==str2.charAt(k)) {
				if(isRoated == false) {
					endIndexStr2 = k;
				}
				i=i+1;
				isRoated = true;
			}else {
				endIndexStr2 = 0;
				i=0;
				isRoated = false;
			}
		}
	
		for (int k = 0; k < endIndexStr2; k++) {
			if(str1.charAt(i) != str2.charAt(k)) {
				isRoated = false;
			}
			i=i+1;
		}
		
		
		if(isRoated == true) {
			return true;
		}
		return false;
	}
	
}
