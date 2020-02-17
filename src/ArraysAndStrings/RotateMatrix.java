package ArraysAndStrings;

public class RotateMatrix {

	/*
	 * CCI Arrays and Strings Question 7
	 */
	public static void main(String[] args) {
		int[][] inpMatrix = {{1,2,3,4},
						     {5,6,7,8},
						     {9,10,11,12}};
		
		int[][] outputpMatrix = rotateMatrix(inpMatrix);
		
		for (int i = 0; i < outputpMatrix.length; i++) {
			for (int j = 0; j < outputpMatrix[i].length; j++) {
				System.out.print(outputpMatrix[i][j]+",");
			}
			System.out.println();
		}
	}
	
	/*
	 * My Solution. This solution creates a separate output matrix and copies results to it. This is not real time copying.
	 * Runtime: O(n)
	 * Solving time: 45 mins
	 */
	public static int[][] rotateMatrix(int[][] inpMatrix){
		int rowLenInpMatrix = inpMatrix.length;
		int colLenInpMatrix = inpMatrix[0].length;
		
		int[][] resultMatrix = new int[colLenInpMatrix][rowLenInpMatrix];
		
		int NR = 0;
		int NC = rowLenInpMatrix-1;
		
		for(int i=0;i<inpMatrix.length;i++) {
			for(int j=0;j<inpMatrix[i].length;j++) {
				 resultMatrix[NR][NC] = inpMatrix[i][j];
				 NR = NR + 1;
			}
			NC = NC - 1;
			NR = 0;
		}
		
		return resultMatrix;
	}
}
