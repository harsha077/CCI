package StacksAndQueues;

public class StackMin {
	
	public int min=-1;
	public StackMinNode head;
	
	public void push(int val) {
		if(head==null) {
			head = new StackMinNode(val,val);
			min = val;
			return;
		}
		StackMinNode temp = head;
		if(val<min) {
			head = new StackMinNode(val,min);
			min=val;
		}else {
			head = new StackMinNode(val,-78967987);
		}
		head.next = temp;
	}
	
	public int pop() {
		if(head==null) return -1;
		int val = head.data;
		if(val==min) {
			min = head.nextMin;
		}
		head = head.next;
		return val;
	}
	
	public int min() {
		return min;
	}
	
	public static void main(String...args) {
		StackMin sm = new StackMin();
		sm.push(2);
		sm.push(7);
		printStack(sm.head);
		System.out.print("pop:"+sm.pop());System.out.print(",");System.out.println("min:"+sm.min);
		printStack(sm.head);System.out.println();
		
		sm.push(3);
		printStack(sm.head);
		System.out.print("pop:"+sm.pop());System.out.print(",");System.out.println("min:"+sm.min);
		printStack(sm.head);System.out.println();
		
		sm.push(1);
		printStack(sm.head);
		System.out.print("min:"+sm.min);System.out.print(",");System.out.print("pop:"+sm.pop());System.out.print(",");System.out.println("min:"+sm.min);
		printStack(sm.head);System.out.println();
		
		sm.push(4);
		
	}
	
	public static void printStack(StackMinNode head) {
		StackMinNode temp = head;
		while(null!=temp) {
			System.out.print(temp.data+",");
			temp=temp.next;
		}
		System.out.println();
	}
}

class StackMinNode{
	int data;
	int nextMin;
	StackMinNode next;
	
	public StackMinNode() {}
	
	public StackMinNode(int data,int nextMin) {
		this.data = data;
		this.nextMin = nextMin;
	}
}

