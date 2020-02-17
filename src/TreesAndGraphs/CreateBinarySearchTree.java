package TreesAndGraphs;

public class CreateBinarySearchTree {
	
	//===========================Binary search tree===================================//
	public TreeNode root;
	
	public void addNode(int value) {
		addNode(root,value);
	}
	
	public void addNode(TreeNode node, int value) {
		if(root == null) {
			root = new TreeNode(value);
			return;
		}
		
		if(node.value >= value) {
			if(node.left == null) {
				node.left = new TreeNode(value);
			}else {
				addNode(node.left,value);
			}
		}else {
			if(node.right == null) {
				node.right = new TreeNode(value);
			}else {
				addNode(node.right,value);
			}
		}
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.value+",");
		inOrderTraversal(node.right);
	}
	
	public void removeMin() {
		removeMin(null,root);
	}
	
	public void removeMin(TreeNode parentNode, TreeNode currentNode) {
		
		if(currentNode.left!=null) {
			parentNode = currentNode;
			removeMin(parentNode,currentNode.left);
		}else {
			parentNode.left = null;
		}
	}
	
	public void removeNode(int value) {
		//finding node to be removed
		TreeNode nodeToBeRemoved = findNodeAndReturnIt(value);
		
		TreeNode minNodeInRightSubtree = null;
		TreeNode maxNodeInLeftSubtree = null;
		TreeNode rightChild = null;
		TreeNode leftChild = null;
		
		if(nodeToBeRemoved.right!=null) {
			rightChild = nodeToBeRemoved.right;
			//finding minimum node in right subtree of the node to be removed
			minNodeInRightSubtree = findMinNodeInCST(rightChild);
			
			//replacing the nodeTobeRemoved value with its right subtree's minimum node(moving it to nodeToBeRemoved)
			nodeToBeRemoved.value = minNodeInRightSubtree.value;
		}else if (nodeToBeRemoved.left != null){
			leftChild = nodeToBeRemoved.left;
			
			maxNodeInLeftSubtree = findMaxNodeInCST(leftChild);
			
			//replacing the nodeTobeRemoved value with its right subtree's minimum node(moving it to nodeToBeRemoved)
			nodeToBeRemoved.value = maxNodeInLeftSubtree.value;
		}else {
			removeLeaf(nodeToBeRemoved);
		}
		
		//removing the right subtrees minimum node original or removing the left subtrees maximum node original
		//If condition to check if immediate right child is a min node in the right subtree
		if(rightChild!=null && rightChild == minNodeInRightSubtree) {
			if(nodeToBeRemoved.right.right!=null) {
				nodeToBeRemoved.right = nodeToBeRemoved.right.right;
			}else {
				nodeToBeRemoved.right = null;
			}
		}else if(leftChild!=null && leftChild == maxNodeInLeftSubtree){
			if(nodeToBeRemoved.left.left!=null) {
				nodeToBeRemoved.left = nodeToBeRemoved.left.left;
			}else {
				nodeToBeRemoved.left = null;
			}
		}else if(rightChild != null){
			removeMinNodeInCST(rightChild, rightChild.left,minNodeInRightSubtree);
		}else if(leftChild != null){
			removeMaxNodeInCST(leftChild, leftChild.right, maxNodeInLeftSubtree);
		}
	}
	
	/**
	 * find and return it
	 * @param value
	 * @return
	 */
	public TreeNode findNodeAndReturnIt(int value) {
		return findNodeAndReturnIt(root, value);
	}
	
	public TreeNode findNodeAndReturnIt(TreeNode node, int value) {
		
		if(node.value==value) {
			return node;
		}
		
		if(node.value >= value) {
			if(node.left!=null) {
				node = findNodeAndReturnIt(node.left,value);
			}else {
				return null;
			}
		}else {
			if(node.right!=null) {
				node = findNodeAndReturnIt(node.right,value);
			}else {
				return null;
			}
		}
		return node;
	}
	
	public TreeNode findMinNodeInCST(TreeNode currentNode) {
		if(currentNode.left == null) {
			return currentNode;
		}else {
			currentNode = findMinNodeInCST(currentNode.left);
		}
		return currentNode;
	}
	
	public TreeNode findMaxNodeInCST(TreeNode currentNode) {
		if(currentNode.right == null) {
			return currentNode;
		}else {
			currentNode = findMaxNodeInCST(currentNode.right);
		}
		return currentNode;
	}
	
	public void removeMinNodeInCST(TreeNode parentNode, TreeNode currentNode, TreeNode minNode) {
		if(currentNode == minNode && currentNode.left == null) {
			parentNode.left = null;
		}else if (currentNode.left!=null) {
			parentNode = currentNode;
			removeMinNodeInCST(parentNode,currentNode.left,minNode);
		}
	}
	
	public void removeMaxNodeInCST(TreeNode parentNode, TreeNode currentNode, TreeNode maxNode) {
		if(currentNode == maxNode && currentNode.right == null) {
			parentNode.right = null;
		}else if (currentNode.right!=null) {
			parentNode = currentNode;
			removeMinNodeInCST(parentNode,currentNode.right,maxNode);
		}
	}
	
	public void removeLeaf(TreeNode nodeTobeRemoved) {
		removeLeaf(null,root,nodeTobeRemoved);
	}
	
	public void removeLeaf(TreeNode parentNode,TreeNode currentNode,TreeNode nodeTobeRemoved) {
		if(currentNode==nodeTobeRemoved) {
			if(parentNode.value >= nodeTobeRemoved.value)
			{
				parentNode.left = null;
			}else {
				parentNode.right = null;
			}
		}
		
		if(currentNode.value >= nodeTobeRemoved.value) {
			if(currentNode.left!=null) {
				removeLeaf(currentNode,currentNode.left,nodeTobeRemoved);
			}
		}else {
			if(currentNode.right!=null) {
				removeLeaf(currentNode,currentNode.right,nodeTobeRemoved);
			}
		}
	}
	//===========================Binary search tree===================================//
	/**
	 * find and return its parent
	 * @param value
	 * @return
	 */
	public TreeNode findNodeAndReturnItsParent(int value) {
		return findNodeAndReturnItsParent(null, root, value);
	}
	
	public TreeNode findNodeAndReturnItsParent(TreeNode parentNode, TreeNode node, int value) {
		
		if(node.value==value) {
			return parentNode;
		}
		
		if(node.value >= value) {
			if(node.left!=null) {
				parentNode = findNodeAndReturnItsParent(node,node.left,value);
			}else {
				return null;
			}
		}else {
			if(node.right!=null) {
				parentNode = findNodeAndReturnItsParent(node,node.right,value);
			}else {
				return null;
			}
		}
		return parentNode;
	}
}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
}
