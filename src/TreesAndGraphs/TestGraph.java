package TreesAndGraphs;

public class TestGraph {

	public static void main(String ...args) {
		testCreateGraph2();
	}
	
	public static void testCreateGraph1() {
		CreateGraph cg = new CreateGraph();
		cg.addVertex("harsha");
		cg.addVertex("raja");
		cg.addVertex("daddy");
		cg.addVertex("relatives");
		cg.addVertex("matrimony");
		cg.addVertex("rupa");
		cg.addEdge("harsha", "raja");
		cg.addEdge("harsha", "daddy");
		cg.addEdge("harsha", "matrimony");
		cg.addEdge("raja", "relatives");
		cg.addEdge("daddy", "relatives");
		cg.addEdge("relatives", "rupa");
		cg.addEdge("matrimony", "rupa");
		
		//cg.shortestDistanceBWTwoNodes("harsha", "rupa");
	}
	
	public static void testCreateGraph2() {
		
	}
	
	
}
