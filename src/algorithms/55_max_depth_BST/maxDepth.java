tc:O(N)

class Solution {
	public int maxDepth(TreeNode root) {
		//base case
		if(root==null) return 0;
		else{
			//go deep until root==null
			//H(root) = Max(H(level1-left-subtree),H(level1-right-subtree))+1
			//H(level1-left-subtree) = Max(H(level2-left-subtree),H(level2-right-subtree))+1
			//until the root of subtree is null
			//get maximum depth of root's left and right subtrees and add to 1
			int left_height = maxDepth(root.left);
			int right_height = maxDepth(root.right);
			return Math.max(left_height, right_height)+1;
		}
	}
}