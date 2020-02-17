package StacksAndQueues;

public class QueueUsing2Stacks {

	public int[] stack1 = null;
	public int[] stack2 = null;
	public int qLen = 0;
	public int stack1Len = 0;
	public int stack2Len = 0;
	
	public QueueUsing2Stacks(int qLen) {
		this.qLen = qLen;
		stack1 = new int[qLen];
		stack2 = new int[qLen];
	}
	
	public void Push(int val) {
		if(stack2Len!=0) {
			System.arraycopy(stack2, 0, stack1, 0, stack2Len);
			stack1Len = stack2Len;
			stack2Len = 0;
		}
		stack1[stack1Len] = val;
		stack1Len=stack1Len+1;
	}
	
	/*public int Pop() {
		
		
		return val;
	}*/
}
