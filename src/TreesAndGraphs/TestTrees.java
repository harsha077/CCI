package TreesAndGraphs;

public class TestTrees {
	public static void main(String...args) {
		//removeMinCST();
		//findNodeAndReturn();
		//findNodeAndReturnItsParent();
		//findMinNodeInCST();
		//removeNode();
		//inOrderTraversal();
	}
	
	public static void removeMinCST() {
		CreateBinarySearchTree bst = createTree1();
		
		bst.inOrderTraversal(bst.root);
		
		bst.removeMin();
		System.out.println("====");
		bst.inOrderTraversal(bst.root);
	}
	
	public static void findNodeAndReturn() {
		CreateBinarySearchTree bst = createTree1();
		
		TreeNode node = bst.findNodeAndReturnIt(5);
		
		if(node!=null) {System.out.println(node.value);}
		else {System.out.println("value not found");}
	}
	
	public static void findNodeAndReturnItsParent() {
		CreateBinarySearchTree bst = createTree1();
		
		TreeNode node = bst.findNodeAndReturnItsParent(9);
		
		if(node!=null) {System.out.println(node.value);}
		else {System.out.println("value not found");}
	}
	
	public static void findMinNodeInCST() {
		CreateBinarySearchTree bst = createTree1();
		
		System.out.println(bst.findMinNodeInCST(bst.root).value);
		bst.removeMin();
		System.out.println("====");
		System.out.println(bst.findMinNodeInCST(bst.root).value);
	}
	
	public static void removeNode() {
		CreateBinarySearchTree bst = createTree2();
		
		bst.inOrderTraversal(bst.root);
		System.out.println();
		System.out.println("====");
		bst.removeNode(5);
		bst.inOrderTraversal(bst.root);
	}
	
	public static CreateBinarySearchTree createTree1() {
		CreateBinarySearchTree bst = new CreateBinarySearchTree();
		
		bst.addNode(5);
		bst.addNode(3);
		bst.addNode(4);
		bst.addNode(1);
		bst.addNode(7);
		bst.addNode(6);
		bst.addNode(9);
		
		return bst;
	}
	
	public static CreateBinarySearchTree createTree2() {
		CreateBinarySearchTree bst = new CreateBinarySearchTree();
		
		bst.addNode(11);
		bst.addNode(5);
		bst.addNode(3);
		bst.addNode(4);
		bst.addNode(2);
		bst.addNode(7);
		bst.addNode(6);
		bst.addNode(9);
		bst.addNode(15);
		bst.addNode(13);
		bst.addNode(14);
		bst.addNode(12);
		bst.addNode(17);
		bst.addNode(16);
		bst.addNode(19);
		
		return bst;
	}
	
	public static void inOrderTraversal() {
		CreateBinarySearchTree bst = createTree2();
		inOrderTraversal(bst.root);
	}
	
	public static void inOrderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.println(node.value);
		inOrderTraversal(node.right);
	}
}
