package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

enum State { unvisited, visiting, visited }

class CreateNodeGraph<T>{
	ArrayList<Vertex> adjecentNodes = new ArrayList<Vertex>();
	HashMap<T, Vertex> map = new HashMap<T, Vertex>();
	
	public Vertex getOrCreateNode(T label) {
		if(!map.containsKey(label))
		{
			Vertex v = new Vertex(label);
			map.put(label, v);
			adjecentNodes.add(v);
		}
		return map.get(label);
	}
	
	public void addEdge1D(T startLabel, T endLabel) {
		Vertex start = getOrCreateNode(startLabel);
		Vertex end = getOrCreateNode(endLabel);
		start.addNeighbour(end);
	}
}

class Vertex<T>{
	private ArrayList<Vertex> children = new ArrayList<Vertex>();
	private HashMap<T, Vertex> map = new HashMap<T, Vertex>();
	private T value;
	private int dependencies = 0;
	private State state = State.unvisited;
	
	public Vertex(T label) {
		value = label;
	}
	
	public void addNeighbour(Vertex node) {
		if(!map.containsKey(node.getValue())) {
			children.add(node);
			map.put((T) node.getValue(), node);
			node.incrementDependencies();
		}
	}
	
	public void incrementDependencies() {
		dependencies++;
	}
	public void decrementDependencies() {
		dependencies--;
	}
	
	public T getValue() {
		return value;
	}
	public ArrayList<Vertex> getChildren(){
		return children;
	}
	public int getDependencies() {
		return dependencies;
	}
	public void setState(State st) {
		state = st;
	}
	public State getState() {
		return state;
	}
}
/*public class CreateNodeGraph<T>{
	public List<Vertex> listOfNodes;
	
	public CreateNodeGraph(){
		listOfNodes = new CopyOnWriteArrayList<Vertex>();
	}
	
	public void getOrCreate(T label) {
		
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
	
	public void addEdge2D(T label1, T label2) {
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
	
	public void addEdge1D(T label1, T label2) {
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
	
	public Vertex findNode(T label) {
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
}*/

/*class Vertex<T>{
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
}*/
