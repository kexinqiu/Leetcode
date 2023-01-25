package basic.recursion;

// divide : divide the problem into a set of subproblems
// conquer: solve each subproblem recursively
// combine: combine the result of each subproblems

public class DivideAndConquer {
	public boolean isValidBST(TreeNode root) {

		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	private boolean dfs(TreeNode node, long min, long max) {
		/*
		conquer
		 */
		if (node == null) return true;
		if (node.val <= min || node.val >= max) return false;

		/*
		divide & combine
		 */
		return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
	}

}


