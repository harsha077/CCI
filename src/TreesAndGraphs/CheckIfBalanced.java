package TreesAndGraphs;

import Exception.BisketException;

public class CheckIfBalanced {
	
	public static int maxHeight = 0;
	public static boolean isBalanced = false;
	public static void main(String... args) {
		CreateBinarySearchTree tree = new CreateBinarySearchTree();
		tree.addNode(5);
		//tree.addNode(3);
		//tree.addNode(4);
		//tree.addNode(2);
		//tree.addNode(1);
		tree.addNode(7);
		//tree.addNode(6);
		//tree.addNode(9);
		//tree.addNode(10);
		//tree.addNode(11);
		
		checkIfBal(tree.root,0);
		//getMaxHeight(tree.root,0);
		//System.out.println(maxHeight);
	}
	
	/*
	 * 4.4 My Solution
	 * Runtime: O(n)
	 */
	public static int checkIfBal(TreeNode node, int height) {
		int leftHeight = 0;
		int rightHeight = 0;
		try {
			if(height == 0 && (node.left == null || node.right == null)) {
				throw new BisketException("not balanced");
			}
			
			if(node == null) {
				return height-1;
			}
			
			leftHeight = checkIfBal(node.left, height+1);
			rightHeight = checkIfBal(node.right, height+1);
			
			int diff = Math.max(leftHeight, rightHeight) - Math.min(leftHeight, rightHeight);
		
		
			if(diff == 0 || diff == 1) {
				isBalanced = true;
				if(height == 0) {
					System.out.println(isBalanced);
				}
			}else {
				throw new BisketException("not balanced");
			}
		}catch(BisketException e) {
			System.out.println(e.getMessage());
		}
		
		return Math.max(leftHeight, rightHeight);
	}
	
	public static void getMaxHeight(TreeNode node, int height) {
		
		if(node==null) {
			return;
		}
		
		getMaxHeight(node.left, height+1);
		getMaxHeight(node.right, height+1);
		
		if(height > maxHeight) {
			maxHeight = height;
		}
	}
	
	
	
	/*public static int checkIfBal(TreeNode node, int left, int right) {
		int isBalanced = 0;
		if(node==null) {
			return 0;
		}
		
		int leftVal = left + checkIfBal(node.left,left+1,right);
	
		int rightVal = right + checkIfBal(node.right,left,right+1);
		
		isBalanced = Math.max(leftVal, rightVal) - Math.min(leftVal, rightVal);
		
		return isBalanced;
	}*/
}
