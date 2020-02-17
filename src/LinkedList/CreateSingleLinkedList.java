package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateSingleLinkedList implements Cloneable{

	//static SingleLinkedListNode head=null;
	
	public static SingleLinkedListNode createSLLusingArray(int[] arr) {
		SingleLinkedListNode head=null;
		SingleLinkedListNode temp = null;
		for (int i = 0; i < arr.length; i++) {
			if(null==head) {
				head = new SingleLinkedListNode(arr[i]);
				temp = head;
			}else {
				temp.next = new SingleLinkedListNode(arr[i]);
				temp = temp.next;
			}
		}
		return head;
	}
	
	public static SingleLinkedListNode createSLLusingList(List<Integer> list) {
		SingleLinkedListNode head=null;
		SingleLinkedListNode temp = null;
		for(Integer val:list) {
			if(null==head) {
				head = new SingleLinkedListNode(val);
				temp = head;
			}else {
				temp.next = new SingleLinkedListNode(val);
				temp = temp.next;
			}
		}
		return head;
	}
	
	public static void printSingleLinkedList(SingleLinkedListNode temp) {
		while(null!=temp) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String...args) {
		int[] arr = {3,9,7,0,2,1,7};
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(8);
		list.add(5);
		
		//CreateSingleLinkedList.createSLLusingArray(arr);
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingList(list);
		
		SingleLinkedListNode temp = head;
		while(null!=temp) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

class SingleLinkedListNode{
	int data;
	SingleLinkedListNode next=null;
	
	SingleLinkedListNode(){
	}
	
	SingleLinkedListNode(int data) {
		this.data = data;
	}
}
