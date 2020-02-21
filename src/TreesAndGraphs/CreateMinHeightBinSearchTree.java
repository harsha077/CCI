package TreesAndGraphs;

public class CreateMinHeightBinSearchTree {

	public static TreeNode root;
	
	public static void main(String... args) {
						// 0,1,2,3,4,5,6,7,8,9,10
		int[] sortedArr = {1,2,3,4,5,6,7,8,9,10,11};
		//int[] sortedArr = {1,2,3};
		
		System.out.println(createMinHtBST(sortedArr));
	}
	
	public static TreeNode createMinHtBST(int[] sortedArr) {
		
		root = createMinHtBST(sortedArr, root, 0, sortedArr.length-1,sortedArr.length-1);
		
		return root;
	}
	
	public static TreeNode createMinHtBST(int[] sortedArr, TreeNode node, int low, int high, int len) {
		if(low>high || low<0 || low>len || high<0 || high>len) {
			return null;
		}
		
		int mid = (low+high)/2;
		
		if(node == null) {
			node = new TreeNode(sortedArr[mid]);
		}
		
		node.left = createMinHtBST(sortedArr,null,low,mid-1,len);
		node.right = createMinHtBST(sortedArr,null,mid+1,high,len);
		
		return node;
	}
}
