package TreesAndGraphs;

import java.util.Stack;

public class FirstCommonAncestorBT {
	
	/*static boolean depthFound = false;
	static int actualDepth = 0;*/
	static TreeNode root;
	static Stack<TreeNode> stack1 = new Stack<TreeNode>();
	static Stack<TreeNode> stack2 = new Stack<TreeNode>();
	
	public static void main(String[] args) {
		CreateBinarySearchTree tree = new CreateBinarySearchTree();
		tree.addNode(6);
		tree.addNode(2);
		tree.addNode(0);
		tree.addNode(4);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(11);
		
		TreeNode node1 = tree.findNodeAndReturnIt(9);
		TreeNode node2 = tree.findNodeAndReturnIt(5);
		TreeNode commonAns = findCommonAnscestor(tree.root,node1,node2);
		System.out.println(commonAns.value);
	}
	
	public static TreeNode findCommonAnscestor(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode commonAns = null;

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1 = fillStack(root, node1, stack1);
		stack2 = fillStack(root, node2, stack2);
		
		int depth = stack1.size() < stack2.size()? stack1.size(): stack2.size();
		
		while(depth > 0) {
			if(stack1.peek() == stack2.peek()) {
				commonAns = stack1.pop();
				stack2.pop();
			}else {
				return commonAns;
			}
			depth--;
		}
		return commonAns;
	}
	
	public static Stack<TreeNode> fillStack(TreeNode root,TreeNode targetNode,Stack<TreeNode> stack) {
		if(root == null) {
			return null;
		}
		
		if(root == targetNode) {
			stack = new Stack<TreeNode>();
			stack.add(root);
			return stack;
		}
		
		if(stack == null || stack.isEmpty()) {
			stack = fillStack(root.left,targetNode,stack);
			if(stack != null) {
				stack.add(root);
			}
		}
		
		if(stack == null || stack.isEmpty()) {
			stack = fillStack(root.right,targetNode,stack);
			if(stack != null) {
				stack.add(root);
			}
		}
		
		return stack;
	}
	
	public static int findDepthBT(TreeNode cRoot, TreeNode targetNode, int depth) {
		if(cRoot == null || targetNode == null) {
			return 0;
		}
		
		if(cRoot == targetNode) {
			return depth;
		}
		
		int depthlevel = findDepthBT(cRoot.left,targetNode,depth+1);
		if(depthlevel!=0) {
			return depthlevel;
		}
		depthlevel = findDepthBT(cRoot.right, targetNode, depth+1);
		return depthlevel;
	}
}
