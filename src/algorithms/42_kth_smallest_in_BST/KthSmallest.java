class Solution {
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root!=null){
			//go deep on left, put left nodes into stack
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			//pop the top node and get it as root
			root = stack.pop();
			//if k=0, means we get the node we want, break
			if(--k==0) break;
			//traverse right branch
			root = root.right;
		}
		return root.val;
	}
}