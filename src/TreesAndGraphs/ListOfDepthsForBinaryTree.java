package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ListOfDepthsForBinaryTree {
	
	public static void main(String... args) {
		int[] sortedArr = {1,2,3,4,5,6,7,8,9,10,11};
		
		CreateMinHeightBinSearchTree binTree = new CreateMinHeightBinSearchTree();
		
		TreeNode node = binTree.createMinHtBST(sortedArr);
		
		List<ArrayList<TreeNode>> ll = listOfNodesAtEachDepth(node);
		
		System.out.println(ll);
	}

	public static List listOfNodesAtEachDepth(TreeNode node) {
		List<ArrayList<TreeNode>> ll = new ArrayList<ArrayList<TreeNode>>(); 
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.add(node);
		
		while(!stack.isEmpty()) {
			ArrayList<TreeNode> l = new ArrayList<TreeNode>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			
			while(!stack.empty()) {
				queue.add(stack.pop());
			}
			
			while(!queue.isEmpty()) {
				TreeNode currNode = queue.poll();
				if(currNode.left!=null) {
					stack.add(currNode.left);
				}
				if(currNode.right!=null) {
					stack.add(currNode.right);
				}
				l.add(currNode);
			}
			ll.add(l);
		}
		
		return ll;
	}
}
