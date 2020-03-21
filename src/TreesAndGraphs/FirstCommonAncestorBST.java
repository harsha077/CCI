package TreesAndGraphs;

public class FirstCommonAncestorBST {
	
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
		
		TreeNode commonAns = findCommonAnscestorBST(tree);
		System.out.println(commonAns.value);
	}
	
	public static TreeNode findCommonAnscestorBST(CreateBinarySearchTree tree) {
		TreeNode p = tree.findNodeAndReturnIt(2);
		TreeNode q = tree.findNodeAndReturnIt(5);
		
		int depthP = tree.findDepth(p);
		int depthQ = tree.findDepth(q);
		
		int depth = depthP > depthQ ? depthQ : depthP;
		TreeNode commonAns = helperBST(tree.root,tree.root,tree.root,p,q,depth);
		return commonAns;
	}
	
	public static TreeNode helperBST(TreeNode root1, TreeNode root2, TreeNode parent,TreeNode p, TreeNode q, int depth) {
		TreeNode tempRoot1 = null;
		TreeNode tempRoot2 = null;
		
		if(depth < 0) {
			return parent;
		}
		
		if(root1==null || root2==null || p == null || q== null) {
			return null;
		}
		
		if(root1 != root2) {
			return parent;
		}else {
			parent = root1;
		}
		
		if(p.value <= root1.value) {
			if(root1.left!=null) {
				tempRoot1 = root1.left;
			}else {
				tempRoot1 = null;
			}
		}else {
			if(root1.right!=null) {
				tempRoot1 = root1.right;
			}else {
				tempRoot1 = null;
			}
		}
		
		if(q.value < root2.value) {
			if(root2.left!=null) {
				tempRoot2 = root2.left;
			}else {
				tempRoot2 = null;
			}
		}else {
			if(root2.right!=null) {
				tempRoot2 = root2.right;
			}else {
				tempRoot2 = null;
			}
		}
		
		parent = helperBST(tempRoot1,tempRoot2,parent,p,q,depth-1);
		
		return parent;
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