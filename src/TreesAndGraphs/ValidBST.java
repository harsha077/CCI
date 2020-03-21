package TreesAndGraphs;

public class ValidBST {
	
	public static TreeNode pubRoot = null;
    public static boolean isLeft = true;
	public static boolean isBST = true;
    
	public static void main(String... args) {
		CreateBinaryTree cbt = new CreateBinaryTree();
		Integer[] inpArr = {3,1,5,0,2,4,6,null,null,null,3};
		
		//CreateMinHeightBinSearchTree cbst = new CreateMinHeightBinSearchTree();
		
		//TreeNode node = cbst.createMinHtBST(sortedArr);
		TreeNode node = cbt.createBinTreeFromArr(inpArr);
		
	}
	
    public static boolean isValidBST(TreeNode node) {
    	
    	if(node==null) {
    		return true;
    	}
    	
    	
    	
    	
    	return false;
    }
	/*public static boolean isValidBST(TreeNode root) {
        pubRoot = root;
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            isBST = true;
        }
        return validBST(root,null);
    }
    
    public static boolean validBST(TreeNode node,TreeNode parent) {
        
    	
		if(node == null) {
			return isBST;
		}
        
		if(node.left!=null && isBST == true) {
            if(isLeft == false && node.left.value <= pubRoot.value){
            	isBST = false;
            }
			if(node.left.value < node.value && isBST == true) {
				isBST = true;
				isBST = validBST(node.left,node);
			}else {
				isBST = false;
			}
		}
        
        if(parent == null){
            if(isLeft == true){
                isLeft = false;
            }
        }
		
		if(node.right!=null && isBST == true) {
            if(isLeft == true && node.right.value >= pubRoot.value){
                isBST = false;
            }
			if(node.value < node.right.value && isBST == true) {
				isBST = true;
				isBST = validBST(node.right,node);
			}else {
				isBST = false;
			}
		}
    	
		return isBST;
	}*/
    
    /*public static boolean validBST(TreeNode node,TreeNode parent, boolean isBST) {
        
		if(node == null) {
			return isBST;
		}
        
        if(node.left == null && node.right == null){
            isBST = true;
        }
        
		if(node.left!=null) {
            if(isLeft == false && node.left.value <= pubRoot.value){
               return false;
            }
			if(node.left.value < node.value) {
				isBST = true;
				isBST = validBST(node.left,node,isBST);
			}else {
				return false;
			}
		}
        
        if(parent == null){
            if(isLeft == true){
                isLeft = false;
            }
        }
		
		if(node.right!=null) {
            if(isLeft == true && node.right.value >= pubRoot.value){
                return false;
            }
			if(node.value < node.right.value) {
				isBST = true;
				isBST = validBST(node.right,node,isBST);
			}else {
				return false;
			}
		}
        
		return isBST;
	}*/
	
	/*public static boolean validBST(TreeNode node) {
		return validBST(node,false);
	}

	public static boolean validBST(TreeNode node, boolean isBST) {
		
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
	}*/
}
