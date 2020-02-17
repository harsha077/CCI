package LinkedList;

import java.util.HashSet;

public class Intersection {

	/**
	 * I did it using a hashSet. 
	 * 
	 */
	public static void main(String ...args) {
		int[] arr1 = {3,8,5,10,2,1};
		int[] arr2 = {9,21,7};
		
		SingleLinkedListNode head1 = CreateSingleLinkedList.createSLLusingArray(arr1);
		SingleLinkedListNode head2 = CreateSingleLinkedList.createSLLusingArray(arr2);
		
		SingleLinkedListNode temp1 = head1;
		SingleLinkedListNode temp2 = head2;
		
		while(null!=temp1) {
			if(temp1.data==5) {
				while(temp2!=null) {
					if(temp2.next==null) {
						temp2.next = temp1;
						break;
					}
					temp2 = temp2.next;
				}
			}
			temp1=temp1.next;
		}
		
		SingleLinkedListNode temp3 = head1;
		SingleLinkedListNode temp4 = head2;
		
		intersectionUsingHashSet(temp3,temp4);
	}
	
	/**
	 * My Solution: using a hashSet
	 * Runtime: O(A+B)
	 * Space: O(A)
	 */
	public static void intersectionUsingHashSet(SingleLinkedListNode temp3,SingleLinkedListNode temp4) {
		HashSet<SingleLinkedListNode> set = new HashSet<SingleLinkedListNode>();
		boolean intrsct = false;
		while(temp3!=null) {
			set.add(temp3);
			temp3=temp3.next;
		}
		
		while(temp4!=null) {
			if(set.contains(temp4)) {
				intrsct = true;
				break;
			}
			temp4=temp4.next;
		}
		
		if(intrsct == true)
		{
			System.out.println("they intersect");
		}else {
			System.out.println("they do not intersect");
		}
	}
	
	public static void intersectionUsingLengths(SingleLinkedListNode temp3,SingleLinkedListNode temp4) {
		
	}
	
	public static int listLen(SingleLinkedListNode temp) {
		int i=0;
		while(temp!=null) {
			i++;
			temp=temp.next;
		}
		return i;
	}
}
