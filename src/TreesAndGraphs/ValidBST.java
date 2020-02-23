package TreesAndGraphs;

public class ValidBST {
	
	public static void main(String... args) {
		CreateBinaryTree cbt = new CreateBinaryTree();
		cbt.addNode(7);
		cbt.addNode(8);
		cbt.addNode(2);
		cbt.addNode(3);
		cbt.addNode(10);
		cbt.addNode(1);
		
		CreateMinHeightBinSearchTree cbst = new CreateMinHeightBinSearchTree();
		int[] sortedArr = {1,2,3,4,5,6,7};
		TreeNode node = cbst.createMinHtBST(sortedArr);
		
		System.out.println(validBST(node,false));
	}

	public static boolean validBST(TreeNode node, boolean isBST) {
		//boolean isBST = false;
		if(node == null) {
			return isBST;
		}
		
		if(node.left!=null) {
			if(node.value >= node.left.value) {
				isBST = true;
				isBST = validBST(node.left,isBST);
			}else {
				return false;
			}
		}
		
		if(node.right!=null) {
			if(node.value < node.right.value) {
				isBST = true;
				isBST = validBST(node.right,isBST);
			}else {
				return false;
			}
		}
		return isBST;
	}
}
