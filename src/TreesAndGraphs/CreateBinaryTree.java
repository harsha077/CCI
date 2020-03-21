package TreesAndGraphs;

public class CreateBinaryTree {
	
	public static TreeNode root;
	
	public static void main(String... args) {
		Integer[] inpArr = {3,1,5,0,2,4,6,null,null,null,3};
		root = createBinTreeFromArr(inpArr);
		System.out.println(root);
	}
	
	/**
	 * 
	 * @param inpArr
	 * @return
	 */
	public static TreeNode createBinTreeFromArr(Integer[] inpArr) {
			
		return root;
	}
	
	/**
	 * Another approach where nodes are arranged randonly in the tree.(unpredictable on which node will go where)
	 */
	/*public static TreeNode createBinTreeFromArr(Integer[] inpArr) {
		int i = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = new TreeNode(inpArr[i]);
		queue.add(node);
		
		TreeNode currentNode = null;
		int j = i;
		while(j<inpArr.length-1) {
			currentNode = queue.poll();
			j = j+1;
			if(j < inpArr.length) {
				if(currentNode.left == null && inpArr[j] != null) {
					currentNode.left = new TreeNode(inpArr[j]);
					queue.add(currentNode.left);
				}
			}
			j = j+1;
			if(j < inpArr.length) {
				if(currentNode.right == null && inpArr[j] != null) {
					currentNode.right = new TreeNode(inpArr[j]);
					queue.add(currentNode.right);
				}
			}
		}
		return node;
	}
	
	public void addNode(int value) {
		Random rnd = new Random();
		String direction = leftOrRight(rnd.nextInt());
		addNode(root,value,direction);
	}
	
	public void addNode(TreeNode node, int value ,String direction) {
		Random rnd = new Random();
		if(root == null) {
			root = node;
			return;
		}
		
		if(direction.equals("left")) {
			if(node.left != null) {
				addNode(node.left, value, leftOrRight(rnd.nextInt()));
			}else {
				node.left = new TreeNode(value);
			}
		}else {
			if(node.right != null) {
				addNode(node.right, value, leftOrRight(rnd.nextInt()));
			}else {
				node.right = new TreeNode(value);
			}
		}
	}
	
	public static String leftOrRight(int randomNum) {
		if(randomNum%2==0) {
			return "left";
		}else {
			return "right";
		}
	}*/
	
	
}
