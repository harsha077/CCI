package ArraysAndStrings;

public class ReplaceSpaceWith20Percent {

	/**
	 * CCI  Arrays and Strings question 3
	 */
	public static void main(String[] args) {
		getString("Mr Smith John      ",13);
	}
	
	public static void getString(String str, int Len){
		int strLen = Len;
		char[] charArr1 = new char[str.length()];
		char[] charArr2 = new char[strLen];
		int j=0;
		String resultString = null;
		
		for(int i=0;i<str.length();i++){
			if(i<strLen){
				charArr2[i] = str.charAt(i);
			}else{
				break;
			}
		}
		
		for(int i=0;i<charArr2.length;i++){
			if(j<charArr1.length){
				if(charArr2[i]!=' '){
					charArr1[j]=charArr2[i];
					j=j+1;
				}else{
					charArr1[j]='%';
					j=j+1;
					charArr1[j]='2';
					j=j+1;
					charArr1[j]='0';
					j=j+1;
				}
			}
		}
		
		resultString = String.copyValueOf(charArr1);
		System.out.println(resultString);
	}

}
