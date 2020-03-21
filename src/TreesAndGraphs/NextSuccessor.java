package TreesAndGraphs;

public class NextSuccessor {
	public static TreeNode root = null;
	public static TreeNode resultNode = new TreeNode(-1);
	public static int minValue = -1;
	
	public static void main(String[] args) {
		CreateBinaryTree cbt = new CreateBinaryTree();
		//Integer[] inpArrforBST = {3,1,5,0,null,4,6,null};
		Integer[] inpArrforBT = {3,5,0,1,2,24,12};
		TreeNode node = cbt.createBinTreeFromArr(inpArrforBT);
		nextSuccessor(node);
	}
	
	public static void nextSuccessor(TreeNode root) {
		helper(root, new TreeNode(1));
		System.out.println(resultNode.value);
	}
	
	public static void helper(TreeNode node,TreeNode targetNode) {
		if(node==null) {
			return;
		}
		
		helper(node.left,targetNode);
		if(node.value > targetNode.value) {
			if(resultNode.value == -1) {
				resultNode = node;
			}
			if(resultNode.value > node.value) {
				resultNode = node;
			}
		}
		helper(node.right,targetNode);
	}
	
	/*public static void helper(TreeNode node,TreeNode targetNode) {
		if(node==null) {
			return;
		}
		
		helper(node.left,targetNode);
		if(node.value > targetNode.value) {
			if(minValue == -1) {
				minValue = node.value;
			}
			if(minValue > node.value) {
				minValue = node.value;
			}
		}
		helper(node.right,targetNode);
	}*/
}

/*class TreeNode{
	TreeNode left;
	TreeNode right;
	int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	
}*/
