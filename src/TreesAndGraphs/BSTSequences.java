package TreesAndGraphs;

public class BSTSequences {
	public static int count = 0;
	public static void main(String[] args) {
		int[] inputArray = {1,2,3};
		combinations(inputArray);
	}
	
	public static void combinations(int[] inputArray) {
		int len = inputArray.length;
		int[] inpArr = inputArray;
		int i=0;
		while(i<len) {
			int k = 0;
			int[] tempArr = new int[inpArr.length];
			combinationsForArrSiz3(inpArr);
			tempArr[k] = inpArr[len-1];
			k++;
			for(int j=0;j<=inpArr.length-2;j++) {
				tempArr[k] = inpArr[j];
				k++;
			}
			inpArr = tempArr;
			i++;
		}
	}
	
	public static void combinationsForArrSiz3(int[] inpArr) {
		int len = inpArr.length;
		int v1=len-3,v2=len-2,v3=len-1;
		while(v1<len) {
			helper(v1,v2,v3,inpArr);
			if(v2==len-1) 
				v2=len-3;
			else 
				v2++;
			
			if(v3==len-1) 
				v3=len-3;
			else 
				v3++;
			
			v1++;
		}
	}
	
	public static void helper(int i, int j, int k, int[] inpArr) {
		int stableArrLen = inpArr.length-4;
		StringBuilder sb = new StringBuilder();
		for(int l=0;l<=stableArrLen;l++) {
			sb.append(inpArr[l]).append(",");
		}
		System.out.println(++count +":" + sb.toString()+inpArr[i]+","+inpArr[j]+","+inpArr[k]);
		System.out.println(++count +":" + sb.toString()+inpArr[i]+","+inpArr[k]+","+inpArr[j]);
	}

	/*public static int[][] combinationsForArrSiz3(int[] inpArr) {
		int[][] resultArr = new int[6][3];
		int resultArrInd = 0;
		int len = inpArr.length;
		int v1=0,v2=1,v3=2;
		while(v1<len) {
			int[][] arr = helper(v1,v2,v3,inpArr);
			for(int i=0;i<arr.length;i++) {
				resultArr[resultArrInd] = arr[i];
				resultArrInd++;
			}
			if(v2==len-1) 
				v2=0;
			else 
				v2++;
			
			if(v3==len-1) 
				v3=0;
			else 
				v3++;
			
			v1++;
		}
		return resultArr;
	}
	
	public static int[][] helper(int i, int j, int k, int[] inpArr) {
		int[][] resultArr = new int[2][3];
		int[] arr1 = {inpArr[i],inpArr[j],inpArr[k]};
		int[] arr2 = {inpArr[i],inpArr[k],inpArr[j]};
		resultArr[0] = arr1;resultArr[1]=arr2;
		return resultArr;
	}*/
}
