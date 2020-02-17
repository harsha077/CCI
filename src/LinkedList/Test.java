package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String...args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(7);
		list.add(9);
		System.out.println(list);
		list.remove(1);
		list.remove(0);
		System.out.println(list);
	}
	
	public static void test1(List<String> list) {
		list.add("hanuman");
	}
	
	public void test() {
		int[] arr = {3,5,8,5,10,2,5,1};
		int k=5;
		SingleLinkedListNode head = CreateSingleLinkedList.createSLLusingArray(arr);
		
		SingleLinkedListNode temp2 = head;
		SingleLinkedListNode newHead = null;
		SingleLinkedListNode temp3 = null;
		
		while(null!=temp2) {
			if(temp2.data==k) {
				if(newHead==null)
				{
					newHead = new SingleLinkedListNode(temp2.data);
					temp3=newHead;
				}else {
					//SingleLinkedListNode currentNode = temp3.next;
					temp3.next = new SingleLinkedListNode(temp2.data);
					temp3 = temp3.next;
				}
			}
			temp2 = temp2.next;
			
			/*if(temp2.data == 3) {
				head = temp2.next;
				temp2 = temp2.next;
				
			}*/
			
		}
		
		while(newHead!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
		/*while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}*/
	}
}
