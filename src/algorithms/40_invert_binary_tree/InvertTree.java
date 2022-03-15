class Solution {
	public TreeNode invertTree(TreeNode root) {

		if(root==0) return root;

		//DFS go deep until null
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		//swap
		root.left = right;
		root.right= left;

		return root;

	}