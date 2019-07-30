package time;

public class PrintSortedStrings {

	
	int numChars = 26;
	
	public static void main(String[] args) {
		PrintSortedStrings pss = new PrintSortedStrings();
		
		pss.printSortedStrngs(2);
	}
	
	void printSortedStrngs(int remaining) {
		printSortedStrngs(remaining,"");
			
	}
	
	void printSortedStrngs(int remaining, String prefix) {
		if(remaining == 0) {
			if(isInOrder(prefix)) {
				System.out.println(prefix);
			}
		}else {
			for (int i = 0; i < numChars; i++) {
				char c = ithLetter(i);
				printSortedStrngs(remaining-1,prefix+c);
			}
		}
	}
	
	boolean isInOrder(String s) {
		for (int i = 1; i < s.length(); i++) {
			int prev = ithLetter(s.charAt(i-1));
			int curr = ithLetter(s.charAt(i));
		
			if(prev > curr) {
				return false;
			}
		}
		return true;
	}
	
	char ithLetter(int i) {
		return (char) (((int)'a')+i);
	}
}