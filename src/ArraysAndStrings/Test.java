package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

import com.sun.jmx.snmp.Timestamp;

public class Test {

	public static void main(String[] args) {
		String str = "hanuman";
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(12);
		list.add(5);
		
		System.out.println(str.substring(5));
		System.out.println(list.size());
		System.out.println(list.get(0));
		/*int val = 457;
		int len = 0;
		int tempVal = val;
		while(tempVal>1) {
			tempVal = tempVal/10;
			//System.out.println(val);
			len++;
		}
		
		System.out.println(len);
		
		
		
		while(len>0) {
			int templen = len-1;
			int hunderds = 1;
			while(templen>0) {
				hunderds = hunderds*10;
				templen--;
			}
			System.out.println(val/hunderds);
			val = val%hunderds;
			len--;
		}*/
		time();
	}
	
	public static void time() {
		Timestamp t = new Timestamp(1175806884);
		System.out.println(t.getDate());
	}
}

class Node{
	int data;
	Node next;
}
