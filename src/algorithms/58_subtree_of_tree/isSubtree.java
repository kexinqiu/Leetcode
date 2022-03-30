import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//recursion DSF
//TC:O(m+n) m is the number of nodes in subtree, n is the number of nodes in tree

class Solution {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		//base case
		if(root==null) return false;
		//check if the tree and subtree match
		if(isSameTree(root, subRoot)) return true;
		//recursion
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}
	//check if the tree and subtree match
	private boolean isSameTree(TreeNode root, TreeNode subRoot){
		//same as leetcode 100
		if(root==null && subRoot==null) return true;
		if(root==null || subRoot==null) return false;
		if(root.val != subRoot.val) return false;

		return isSameTree(root.left, subRoot.left)&&isSameTree(root.right, subRoot.right);
	}
}

//iteration
class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		Queue<TreeNode> nodes = new ArrayDeque<>();
		nodes.offer(s);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			if (isSameTree(node, t)) {
				return true;
			}
			if (node.left != null) {
				nodes.offer(node.left);
			}
			if (node.right != null) {
				nodes.offer(node.right);
			}
		}
		return false;
	}
	public boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;

		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}