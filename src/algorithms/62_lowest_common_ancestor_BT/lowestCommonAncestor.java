import javax.swing.tree.TreeNode;

//recursion DFS
//tc：o（n）
//sc：o（1）

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// for the first level recursion, if p(or q) is exactly the whole tree's root, return the root(because root is the lowest node).
		// for deeper(higher nodes) recursions, it indicates:
		// (1) we find p(or q), which is fine because this node will not be returned(to output) instantly since it belongs to a deeper recursion but will be used for determinations of shallower(lower nodes) recursions
		// (2) we reach the bottom of the tree, terminate the current track instantly and "null" will also be used for shallower recursions' determine statements.
		//只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
		if (root == null || root == p || root == q)
			return root;
		//根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
		TreeNode left = lowestCommonAncestor( root.left,  p,  q);
		TreeNode right = lowestCommonAncestor( root.right,  p,  q);

		// determine statements

		//p和q都没找到，那就没有
		if(left == null && right == null) {
			return null;
		}

		// 说明在同一条tree上。which means p,q exist below the same subtree;
		//左子树没有p也没有q，就返回右子树的结果
		if(left == null)
			return right;
			//右子树没有p也没有q，就返回左子树的结果
		else if (right == null)
			return left;
			// which means p,q exist below different subtrees;
			//左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
		else
			return root;
	}
}