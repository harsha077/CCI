package TreesAndGraphs;

public class ValidBST {

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
