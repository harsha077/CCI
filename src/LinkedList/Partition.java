package LinkedList;

public class Partition {

	public static void main(String ...args) {
		int[] arr = {3,5,8,5,10,2,1};
		
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingArray(arr);
		
		SingleLinkedListNode temp2 = head;
		while(null!=temp2) {
			System.out.print(temp2.data+" ");
			temp2 = temp2.next;
		}
		System.out.println();
		System.out.println("===============");
		
		partition(head,5);
	}
	
	public static void partition(SingleLinkedListNode head, int partitionVal) {
		SingleLinkedListNode pointer1 = head;
		SingleLinkedListNode pointer2 = head;
		
		if(head==null) {
			return;
		}
		
		while(null!=pointer2) {
			if(pointer2.data < partitionVal) {
				int val2 = pointer2.data;
				int val1 = pointer1.data;
				pointer2.data = val1;
				pointer1.data = val2;
				pointer1 = pointer1.next;
			}
			pointer2 = pointer2.next;
		}
		
		while(null!=head) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}
