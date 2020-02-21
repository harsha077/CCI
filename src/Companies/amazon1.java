package Companies;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;


public class amazon1 {
	
	public static void main(String ...args) {
		amazon1 am = new amazon1();
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(20);
		al.add(25);
		al.add(35);
		al.add(60);
		int truckSize = 90;
		
		/*al.add(20);
		al.add(70);
		al.add(90);
		al.add(30);
		al.add(60);
		al.add(110);
		int truckSize = 110;*/
		
		/*al.add(100);
		al.add(180);
		al.add(40);
		al.add(120);
		al.add(10);
		int truckSize = 250;*/
		
		System.out.println(am.getMatchingBoxes(al, truckSize));
	}

	public List getMatchingBoxes(List<Integer> packageSpaceSizeList, int truckSize) {
		
		List<Integer> resultList = new ArrayList<Integer>();
		Map<Integer,Integer> mp1 = new HashMap<Integer, Integer>();
		
		//My initial thought was to create a additional map to hold all the results and 
		int maxPack1 = 0;
		int maxPack2 = 0;
		int maxPackInd1 = 0;
		int maxPackInd2 = 0;

		/*If the requirement is to search through a list of elements frequently. Better convert that list to a hashmap as its search time complexity O(1).
		 * That is why i have created a hashmap to search through the given list of elements.
		 * */
		Integer maxVal = truckSize - 30;
		for(int i=0;i<packageSpaceSizeList.size();i++) {
			int val = (int) packageSpaceSizeList.get(i);
			mp1.put(val, i);
		}
		
		for(Entry item: mp1.entrySet()) {
			Integer pck1 = (Integer) item.getKey();
			Integer pck2 = maxVal - pck1;
			
			if(mp1.containsKey(pck2)) {
				if(maxPack1==0 && maxPack2==0) {
					maxPack1 = pck1;
					maxPack2 = pck2;
					maxPackInd1 = (int)item.getValue();
					maxPackInd2 = (int)mp1.get(pck2);
				}else {
					if((pck1>maxPack1 && pck1>maxPack2) || (pck2>maxPack1 && pck2>maxPack2)) {
						maxPackInd1 = (int)item.getValue();
						maxPackInd2 = (int)mp1.get(pck2);
						
						maxPack1 = pck1;
						maxPack2 = pck2;
					}
				}
			}
		}
		
		resultList.add(maxPackInd1);
		resultList.add(maxPackInd2);
		
		return resultList;
	}
}
