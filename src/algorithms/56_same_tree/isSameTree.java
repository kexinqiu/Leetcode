import javax.swing.tree.TreeNode;
import java.util.Queue;

//recursion DFS
//tc O(n)
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//p and q both null
		if(p==null && q==null) return true;
		//p or q is null
		if(p==null || q==null) return false;
		//the value of q and p are different
		if(p.val != q.val) return false;
		//recursion in left subtree and right subtree
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}

//iteration BFS
//O(n)
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<>();
		//nulls are not allowed in queue
		if(p==null&&q==null) return true;
		if(p==null || q==null) return false;
		queue.add(p);
		queue.add(q);

		while(!queue.isEmpty()){
			TreeNode first= queue.poll();
			TreeNode second= queue.poll();

			if(first==null && second==null) continue;
			if(first==null || second==null) return false;
			if(first.val != second.val) return false;

			queue.add(first.left);
			queue.add(second.left);
			queue.add(first.right);
			queue.add(second.right);
		}
		return true;
	}
}
