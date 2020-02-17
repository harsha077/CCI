package LinkedList;

import java.util.HashSet;

public class RemoveDuplicates {

	public static void main(String...args) {
		int[] array = {5,5,7,4,6,8,8,7,4};
		
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingArray(array);
		
		head = removeDuplicates(head);
		
		CreateSingleLinkedList.printSingleLinkedList(head);
	}
	
	public static SingleLinkedListNode removeDuplicates(SingleLinkedListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		SingleLinkedListNode temp1 = head;
		SingleLinkedListNode prev = null;
		boolean isDupRemvoed = false;
		
		while(null!=temp1) {
			if(set.contains(temp1.data)) {
				prev.next = temp1.next;
				isDupRemvoed = true;
			}
			if(!set.contains(temp1.data)) 
				set.add(temp1.data);
			
			if(isDupRemvoed==false)
				prev = temp1;
			
			isDupRemvoed = false;
			temp1 = temp1.next;
		}
		return head;
	}
}
