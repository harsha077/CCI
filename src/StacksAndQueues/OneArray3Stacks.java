package StacksAndQueues;

public class OneArray3Stacks {

	int[] inpArr = null;
	int stack1 = -1,stack2 =-1, stack3 = -1;
	int stackInd1 = 0,stackInd2 = 0,stackInd3=0,sizeOfSubArr=0;
	public OneArray3Stacks(int capacity) {
		inpArr = new int[capacity];
		
		sizeOfSubArr = capacity/3;
		stack1=sizeOfSubArr;
		stack2=sizeOfSubArr+sizeOfSubArr;
		stack3=inpArr.length;
		
		stackInd1 = 0;
		stackInd2 =  sizeOfSubArr;
		stackInd3 =  stackInd2+sizeOfSubArr;
	}
	
	public void InsertToStack1(int val) {
		if(stackInd1<stack1) {
			inpArr[stackInd1] = val;
			stackInd1 = stackInd1+1;
		}
	}
	
	public int popStack1() {
		int val = -1;
		if(stackInd1>0) {
			stackInd1 = stackInd1-1;
			val = inpArr[stackInd1];
			inpArr[stackInd1] = '\0';
		}else if (stackInd1==0){
			val = inpArr[stackInd1];
			inpArr[stackInd1] = '\0';
			stackInd1--;
		}
		return val;
	}
	
	public void InsertToStack2(int val) {
		if(stackInd2<stack2) {
			inpArr[stackInd2] = val;
			stackInd2 = stackInd2+1;
		}
	}
	
	public int popStack2() {
		int val = -1;
		if(stackInd2>stack1) {
			stackInd2 = stackInd2-1;
			val = inpArr[stackInd2];
			inpArr[stackInd2] = '\0';
		}else if(stackInd2==stack1) {
			val = inpArr[stackInd2];
			inpArr[stackInd2] = '\0';
			stackInd2--;
		}
		return val;
	}
	
	public void InsertToStack3(int val) {
		if(stackInd3<stack3) {
			inpArr[stackInd3] = val;
			stackInd3 = stackInd3+1;
		}
	}
	
	public int popStack3() {
		int val = -1;
		if(stackInd3>stack2) {
			stackInd3 = stackInd3-1;
			val = inpArr[stackInd3];
			inpArr[stackInd3] = '\0';
		}else if(stackInd3==stack2) {
			val = inpArr[stackInd3];
			inpArr[stackInd3] = '\0';
			stackInd3--;
		}
		return val;
	}
	
	public static void main(String...args) {
		OneArray3Stacks s3 = new OneArray3Stacks(10);
		
		s3.InsertToStack1(3);
		s3.InsertToStack1(7);
		System.out.println(s3.popStack1());
		s3.InsertToStack3(9);
		s3.InsertToStack1(4);
		s3.InsertToStack3(10);
		System.out.println(s3.popStack3());
		System.out.println(s3.popStack2());
		
		int[] inpArr = s3.inpArr;
		for(int i=0;i<inpArr.length;i++) {
			System.out.println(inpArr[i]);
		}
	}
	
}
