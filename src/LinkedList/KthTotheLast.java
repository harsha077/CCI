package LinkedList;

public class KthTotheLast {

	public static void main(String...args) {
		int[] array = {5,5,7,4,6,9,8,7,4};
		int k=4;
		/*int[] newarr = new int[array.length+1];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}*/
		
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingArray(array);
		
		KthtotheLast(head,k);
		
		//CreateSingleLinkedList.printSingleLinkedList(head);
	}
	
	public static void KthtotheLast(SingleLinkedListNode head,int k) {
		SingleLinkedListNode temp1 = head;
		SingleLinkedListNode temp2 = head;
		int listLen = 0;
		
		while(null!=temp1) {
			temp1 = temp1.next;
			listLen++;
		}
		
		listLen = listLen-k;
		System.out.println(listLen);
		while(null!=temp2 && listLen>=1) {
			temp2 = temp2.next;
			listLen--;
		}
		
		System.out.println(temp2.data);
	}
}
