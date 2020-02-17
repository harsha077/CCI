package LinkedList;

public class RemoveMiddleNode {

	
	public static void main(String...args) {
		int[] arr = {3,9,7,0,2,1,7};
		
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingArray(arr);
		SingleLinkedListNode newHead = head;
		SingleLinkedListNode itrHead = newHead;
		SingleLinkedListNode targetNode = null;
		
		while(itrHead!=null) {
			if(itrHead.data==0) {
				targetNode = itrHead;
			}
			itrHead = itrHead.next;
		}
		SingleLinkedListNode itrHead1 = newHead;
		
		removeValue(targetNode,head,itrHead1);
		
	}
	
	public static void removeValue(SingleLinkedListNode targetNode, SingleLinkedListNode head,SingleLinkedListNode itrHead) {
		
		SingleLinkedListNode itrHead1 = head;
		SingleLinkedListNode prev = null;
		boolean delNode = false;
		while(itrHead!=null) {
			if(itrHead==targetNode)
			{
				delNode = true;
			}
			if(delNode==true) {
				if(itrHead.next!=null)
				{
					itrHead.data = itrHead.next.data;
					prev = itrHead;
				}else {
					prev.next = itrHead.next;
				}
			}
			itrHead = itrHead.next;
		}
		
		while(itrHead1!=null) {
			System.out.println(itrHead1.data);
			itrHead1 = itrHead1.next;
		}
	}
}
