package StacksAndQueues;

import java.util.EmptyStackException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelAttribute;

public class CreateaStack implements Cloneable{

	public static void main(String...args) {
		CreateaStack cs = new CreateaStack();
		cs.push(5);
		cs.push(2);
		cs.push(7);
		System.out.println(cs.peek());
		System.out.println(cs.pop());
		System.out.println(cs.peek());
	}
	
	StackNode top = new StackNode();
	
	public void push(int val) {
		StackNode temp = top;
		top = new StackNode(val);
		top.next = temp;
	}
	
	public Integer pop() {
		//if(top==null) throw new EmptyStackException();
		if(top==null) return null;
		
		int val = top.data;
		top = top.next;
		return val;
	}
	
	public Integer peek() {
		if(top==null) {
			return null;
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		boolean isempty = false;
		if(top!=null) {
			isempty = true;
		}
		return isempty;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class StackNode{
	int data;
	StackNode next;
	
	public StackNode() {}
	
	public StackNode(int data) {
		this.data = data;
	}
}
