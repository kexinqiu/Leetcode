//properties of a BST:
//1. Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
//2. Right subtree of a node N contains nodes whose values are greater than node N's value.
//3. Both left and right subtrees are also BSTs.

//recursion
//TC:O(n)
//PC:O(n)
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Value of current node or parent node.
		int parentVal = root.val;

		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;

		if (pVal > parentVal && qVal > parentVal) {
			// If both p and q are greater than parent
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < parentVal && qVal < parentVal) {
			// If both p and q are lesser than parent
			return lowestCommonAncestor(root.left, p, q);
		} else {
			// We have found the split point, i.e. the LCA node.
			return root;
		}
	}
}

//iteration
//TC:O(n)
//PC:O(n)
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;

		// Start from the root node of the tree
		TreeNode node = root;

		// Traverse the tree
		while (node != null) {

			// Value of ancestor/parent node.
			int parentVal = node.val;

			if (pVal > parentVal && qVal > parentVal) {
				// If both p and q are greater than parent
				node = node.right;
			} else if (pVal < parentVal && qVal < parentVal) {
				// If both p and q are lesser than parent
				node = node.left;
			} else {
				// We have found the split point, i.e. the LCA node.
				return node;
			}
		}
		return null;
	}
}