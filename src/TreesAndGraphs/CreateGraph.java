package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CreateGraph<T> {

	public Map<T, ArrayList<T>> map;
	
	public CreateGraph() {
		map = new HashMap<T,ArrayList<T>>();
	}
	
	public void addVertex(T label) {
		if(label!=null)
		{
			map.putIfAbsent(label, new ArrayList<T>());
		}
	}
	
	public void addEdge(T source, T destination) {
		if(!map.containsKey(source)) {
			map.put(source, new ArrayList<T>());
		}
		if(!map.containsKey(destination)) {
			map.put(destination, new ArrayList<T>());
		}
		
		//uni-directional
		map.get(source).add(destination);
		//bi-directional
		//map.get(destination).add(source);
	}
	
	public void removeVertex(T label) {
		if(map.containsKey(label)) {
			map.values().forEach(e->e.remove(label));
			map.remove(label);
		}
	}
	
	public void removeEdge(T source, T destination) {
		if(map.containsKey(source)) {
			map.get(source).remove(destination);
		}
		
		if(map.containsKey(destination)) {
			map.get(destination).remove(source);
		}
	}
	
	public void printAllLinks() {
		for(Entry<T, ArrayList<T>> item: map.entrySet()) {
			ArrayList<T> list = item.getValue();
			for(T t: list) {
				System.out.println(item.getKey()+"->"+t);
			}
		}
	}
}


