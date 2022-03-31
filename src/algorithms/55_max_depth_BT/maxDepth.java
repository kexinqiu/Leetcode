tc:O(N)

//recursion dfs
class Solution {
	public int maxDepth(TreeNode root) {
		//base case
		if(root==null) return 0;

		//go deep until root==null
		//H(root) = Max(H(level1- left-subtree),H(level1- right-subtree))+1
		//H(level1- left-subtree) = Max(H(level2- left-subtree),H(level2- right-subtree))+1
		//until the root of subtree is null
		//get maximum depth of root's left and right subtrees and add to 1
		int left_height = maxDepth(root.left);
		int right_height = maxDepth(root.right);
		return Math.max(left_height, right_height)+1;

	}
}

//iteration bfs
class Solution {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;

		int depth = 1;

		Queue<TreeNode> qNode = new LinkedList<>();
		Queue<Integer> qDepth = new LinkedList<>();

		qNode.offer(root);
		qDepth.offer(depth);

		while(!qNode.isEmpty()){

			TreeNode node = qNode.poll();
			depth = qDepth.poll();

			if(node.left!=null){
				qNode.offer(node.left);
				qDepth.offer(depth+1);
			}

			if(node.right!=null){
				qNode.offer(node.right);
				qDepth.offer(depth+1);
			}
		}
		return depth;
	}
}

//dfs iteration
class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;

		int max = 1;

		Stack<TreeNode> nodes = new Stack<>();
		Stack<Integer> depths = new Stack<>();

		nodes.push(root);
		depths.push(1);

		while (!nodes.empty()) {
			TreeNode curr = nodes.pop();
			int depth = depths.pop();
			//this is dfs, so we need to compare the depth of left subtree and right subtree
			//for bfs, this is not necessary, because level first, we can always get max depth
			if (curr.left == null && curr.right == null) {
				max = Math.max(max, depth);
			}

			if (curr.right != null) {
				nodes.push(curr.right);
				depths.push(depth + 1);
			}
			if (curr.left != null) {
				nodes.push(curr.left);
				depths.push(depth + 1);
			}
		}

		return max;

	}
}
