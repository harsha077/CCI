package Arrays;

public class ZeroMatrix {

	/**
	 * CCI Arrays and Strings Question 8
	 */
	public static void main(String[] args) {
		int[][] inpMatrix = {{1,2,0},{4,0,6},{7,8,9}};
		
		int[][] resultMatrix = makeZeroMatrix(inpMatrix);
		
		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[i].length; j++) {
				System.out.print(resultMatrix[i][j]+",");
			}
			System.out.println();
		}
	}
	
	/*
	 * My Solution 
	 * Runtime: O(n)
	 * Solution time: 40 mins
	 * Comments: Have to go test step by step on paper and before running in the IDE
	 */
	public static int[][] makeZeroMatrix(int[][] inpMatrix){
		int[][] resultMatrix = inpMatrix;
		int RL = resultMatrix.length;
		int CL = resultMatrix[0].length;
		
		for(int i=0;i<resultMatrix.length;i++){
			for(int j=0;j<resultMatrix[i].length;j++){
				if(inpMatrix[i][j]==0){
					int trl = i;
					int tcl = 0;
					while(tcl<CL){
						resultMatrix[trl][tcl]=0;
						tcl=tcl+1;
					}
					break;	
				}
			}
		}
		return resultMatrix;
	}

}
