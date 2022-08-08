import javax.swing.tree.TreeNode;
//inorder ：将当前node和上一个node相比，确保比上一个node大


class Solution {
	public boolean isValidBST(TreeNode root) {
		//use stack as data structure to traverse the tree
		Stack<TreeNode> stack = new Stack<>();

		TreeNode pre = null;
		//go deep, traverse all left nodes and push them into stack
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			//pop the top node of the stack
			root = stack.pop();
			if(pre != null && pre.val>=root.val) return false;
			//use pre to store the previous left node, so that we can compare the value of nodes
			pre = root;
			//traverse right node
			root = root.right;
		}
		return true;
	}
}