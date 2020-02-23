package TreesAndGraphs;

import java.util.Random;

public class CreateBinaryTree {
	
	public static TreeNode root;
	
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
	}
}
