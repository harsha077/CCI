package TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

enum State { unvisited, visiting, visited }

public class CreateNodeGraph<T>{
	public List<Vertex> listOfNodes;
	
	public CreateNodeGraph(){
		listOfNodes = new CopyOnWriteArrayList<Vertex>();
	}
	
	public void addNode(T label) {
		Vertex v = new Vertex(label);
		v.setAdjVertices(new LinkedList<Vertex>());
		v.setVisitStatus(State.unvisited);
		listOfNodes.add(v);
	}
	
	public void removeNode(T label) {
		Vertex v = null;
		for(Vertex item: listOfNodes) {
			if(item.getLabel().equals(label)) {
				listOfNodes.remove(item);
				break;
			}
		}
	}
	
	public void addEdge(T label1, T label2) {
		boolean label1Present = false;
		boolean label2Present = false;
		Vertex v1 = null;
		Vertex v2 = null;
		for(Vertex item: listOfNodes) {
			if(item.getLabel().equals(label1)) {
				label1Present = true;
				v1 = item;
			}
			if(item.getLabel().equals(label2)) {
				label2Present = true;
				v2 = item;
			}
		}
		if(!label1Present) {
			v1 = new Vertex(label1);
			listOfNodes.add(v1);
		}
		if(!label2Present) {
			v2 = new Vertex(label2);
			listOfNodes.add(v2);
		}
		
		v1.getAdjVertices().add(v2);
		v2.getAdjVertices().add(v1);
	}
	
	public void removeEdge(T label1, T label2) {
		Vertex v1 = null;
		Vertex v2 = null;
		for(Vertex item: listOfNodes) {
			if(item.getLabel().equals(label1)) {
				v1 = new Vertex(label1);
			}
			if(item.getLabel().equals(label2)) {
				v2 = new Vertex(label2);
			}
		}
		
		if(v1!=null) {
			v1.getAdjVertices().remove(v2);
		}
		if(v2!=null) {
			v2.getAdjVertices().remove(v1);
		}
	}
	
	public Vertex findNode(String label) {
		for(Vertex item: listOfNodes) {
			if(item.getLabel().equals(label)) {
				return item;
			}
		}
		return null;
	}
	
	public void printAllEdges() {
		for(Vertex item: listOfNodes) {
			LinkedList<Vertex> list = item.getAdjVertices();
			for(Vertex adjV:list)
			{
				if(!adjV.getVisitStatus().equals(State.visited)) {
					System.out.println(item.getLabel() +"->"+adjV.getLabel());
					adjV.setVisitStatus(State.visited);
				}
			}
			item.setVisitStatus(State.visited);
		}
	}
	
	public void clearVisitStatus() {
		for(Vertex item: listOfNodes) {
			item.setVisitStatus(State.unvisited);
		}
	}
}

class Vertex<T>{
	private State visitStatus;
	private LinkedList<Vertex> adjVertices;
	private T label;
	
	public Vertex(T label) {
		this.label = label;
		adjVertices = new LinkedList<Vertex>();
		visitStatus = State.unvisited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((adjVertices == null) ? 0 : adjVertices.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		//result = prime * result + ((visitStatus == null) ? 0 : visitStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (adjVertices == null) {
			if (other.adjVertices != null)
				return false;
		} else if (!adjVertices.equals(other.adjVertices))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (visitStatus != other.visitStatus)
			return false;
		return true;
	}

	public State getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(State visitStatus) {
		this.visitStatus = visitStatus;
	}

	public LinkedList<Vertex> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(LinkedList<Vertex> adjVertices) {
		this.adjVertices = adjVertices;
	}

	public T getLabel() {
		return label;
	}

	public void setLabel(T label) {
		this.label = label;
	}
}
/*public class CreateNodeGraph<T> {
	public Map<Vertex, ArrayList<Vertex>> map;
	
	public CreateNodeGraph() {
		map = new ConcurrentHashMap<Vertex, ArrayList<Vertex>>(); 
	}
	
	public void addVertex(T label) {
		map.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
	}
	
	public void removeVertex(T label) {
		map.values().forEach(e->e.remove(new Vertex(label)));
		map.remove(new Vertex(label));
	}
	
	//bidirectional
	public void addEdge(T label1, T label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		if(v1!=null)
		{
			map.get(v1).add(v2);
		}
		if(v2!=null)
		{
			map.get(v2).add(v1);
		}
	}
	
	public Vertex setVertexAsVisited(Vertex node) {
		for(Entry<Vertex, ArrayList<Vertex>> item: map.entrySet()) {
			if(item.getKey().equals(node)) {
				item.getKey().visited = true;
				node = item.getKey();
			}
		}
		return node;
	}
	
	public void printAllLinks(){
		for(Entry<Vertex, ArrayList<Vertex>> item: map.entrySet()) {
			Vertex v = item.getKey();
			for(Vertex adjV: item.getValue()) {
				System.out.println(v.value + "->"+ adjV.value);
			}
		}
	}
	
	//
	public Vertex createVertex(T label) {
		Vertex v = null;
		if(label!=null) v = new Vertex(label);
		return v;
	}
	
	public Vertex isVisited(Vertex v) {
		if(v!=null)	v.visited = true;
		return v;
	}
}

class Vertex<T>{
	State visitStatus = State.unvisited;
	T value;
	
	public Vertex(T value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		//result = prime * result + ((visited == null) ? 0 : visited.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (visitStatus == null) {
			if (other.visitStatus != null)
				return false;
		} else if (!visitStatus.equals(other.visitStatus))
			return false;
		return true;
	}
}*/
