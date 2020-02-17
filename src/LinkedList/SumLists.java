package LinkedList;

public class SumLists {

	public static void main(String[] args) throws CloneNotSupportedException{
		int[] arr1 = {7,1,6};
		//int[] arr2 = {5,9,2};
		int[] arr2 = {5,9};
		
		CreateSingleLinkedList CSLL1 = new CreateSingleLinkedList();
		CreateSingleLinkedList CSLL2 = (CreateSingleLinkedList)CSLL1.clone();
		
		SingleLinkedListNode head1 = CSLL1.createSLLusingArray(arr1);
		SingleLinkedListNode head2 = CSLL2.createSLLusingArray(arr2);
		
		sumListsWithReverseOrder(head1,head2);
	}
	
	static void sumListsWithReverseOrder(SingleLinkedListNode head1,SingleLinkedListNode head2) {
		SingleLinkedListNode headTemp1 = head1;
		SingleLinkedListNode headTemp2 = head2;
		SingleLinkedListNode newHead = null;
		SingleLinkedListNode newHeadTemp1 = null;
		int quotient = 0;
		
		while(headTemp1!=null || headTemp2!=null) {
			int val1 = (null!=headTemp1)?headTemp1.data:0;
			int val2 = (null!=headTemp2)?headTemp2.data:0;
			
			int sum = val1+val2+quotient;
			quotient = sum/10;
			
			int remainder = sum%10;
			
			if(newHead==null) {
				newHead = new SingleLinkedListNode(remainder);
				newHeadTemp1 = newHead;
			}else {
				newHeadTemp1.next = new SingleLinkedListNode(remainder);
				newHeadTemp1 = newHeadTemp1.next;
			}
			
			headTemp1 = null!=headTemp1&&null!=headTemp1.next?headTemp1.next:null;
			headTemp2 = null!=headTemp2&&null!=headTemp2.next?headTemp2.next:null;
		}
		
		while(newHead!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}
	
	
	

}
