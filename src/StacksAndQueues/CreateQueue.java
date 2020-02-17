package StacksAndQueues;

import java.util.NoSuchElementException;

public class CreateQueue {

	public static void main(String...args) {
		CreateQueue cs = new CreateQueue();
		cs.add(5);
		cs.add(2);
		cs.add(7);
		System.out.println(cs.remove());
		System.out.println(cs.remove());
		System.out.println(cs.remove());
	}
	
	QueueNode first;
	QueueNode last;
	
	public void add(Integer val) {
		QueueNode t = new QueueNode(val);
		if(last!=null) {
			last.next = t;
		}
		last = t;
		if(first==null) {
			first=last;
		}
	}
	
	public Integer remove() {
		if(first==null) throw new NoSuchElementException();
		Integer data = first.data;
		first = first.next;
		if(first==null) {
			last = null;
		}
		return data;
	}

	public Integer peek() {
		if(first==null) throw new NoSuchElementException();
		Integer data = first.data;
		return data;
	}
	
	public boolean isEmpty() {
		if(first==null) return false;
		return true;
	}
}

class QueueNode{
	int data;
	QueueNode next;
	
	public QueueNode(int data) {
		this.data = data;
	}
}
