package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BuildOrder {

	public static void main(String[] args) {
		//List<Character> projects = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f'));
		List<Character> projects = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h'));
		
		List<ArrayList<Character>> dependencies = new ArrayList<ArrayList<Character>>();
		
		dependencies.add(new ArrayList<Character>(Arrays.asList('f','c')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('f','b')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('f','a')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('c','a')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('b','e')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('b','a')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('b','h')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('a','e')));
		dependencies.add(new ArrayList<Character>(Arrays.asList('d','g')));
		
		Stack<Vertex> stack = buildOrder(projects,dependencies);
		for(Vertex v: stack) {
			System.out.println(v.getValue());
		}
	}
	
	public static Stack<Vertex> buildOrder(List<Character> projects, List<ArrayList<Character>> dependencies) {
		CreateNodeGraph<Character> cng = new CreateNodeGraph<Character>();
		
		for(ArrayList listItem: dependencies) {
			Character nodeLabel = (Character) listItem.get(1);
			Character dependencyLabel = (Character) listItem.get(0);
			cng.getOrCreateNode(nodeLabel);
			cng.addEdge1D(dependencyLabel, nodeLabel);
		}
		
		return orderProjects(cng);
	}
	
	public static Stack<Vertex> orderProjects(CreateNodeGraph<Character> cng) {
		Stack<Vertex> stack = new Stack<Vertex>();
		
		for(Vertex project: cng.adjecentNodes) {
			if(project.getState() == State.unvisited) {
				if(!doDFS(project,stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	
	public static boolean doDFS(Vertex project,Stack<Vertex> stack) {
		if(project.getState() == State.visiting) {
			return false;
		}
		
		if(project.getState() == State.unvisited) {
			project.setState(State.visiting);
			ArrayList<Vertex> children = project.getChildren();
			for(Vertex child: children) {
				if(!doDFS(child,stack)) {
					return false;
				}
			}
			project.setState(State.visited);
			stack.add(project);
		}
		return true;
	}
}
