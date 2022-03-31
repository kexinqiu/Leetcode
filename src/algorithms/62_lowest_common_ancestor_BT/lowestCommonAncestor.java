import javax.swing.tree.TreeNode;

//recursion DFS
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// for the first level recursion, if p(or q) is exactly the whole tree's root, return the root(because root is the lowest node).
		// for deeper(higher nodes) recursions, it indicates:
		// (1) we find p(or q), which is fine because this node will not be returned(to output) instantly since it belongs to a deeper recursion but will be used for determinations of shallower(lower nodes) recursions
		// (2) we reach the bottom of the tree, terminate the current track instantly and "null" will also be used for shallower recursions' determine statements.
		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor( root.left,  p,  q);
		TreeNode right = lowestCommonAncestor( root.right,  p,  q);

		// determine statements
		// which means p,q exist below the same subtree;
		if(left == null)
			return right;
		else if (right == null)
			return left;
			// which means p,q exist below different subtrees;
		else
			return root;
	}
}