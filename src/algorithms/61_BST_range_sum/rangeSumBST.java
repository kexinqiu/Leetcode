//iteration DFS 1
//traversing all nodes is not necessary, if the root value is less than the low, there is no need to check left subtree;
//if the root value is large than the high, there is no need to check right subtree.

//dfs iteration
class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {
		Stack<TreeNode> stack = new Stack<>();
		int sum = 0;
		TreeNode node = root;

		while(!stack.isEmpty()||node!=null){
			while(node!=null){
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			if(node.val>=low&&node.val<=high) sum = sum+node.val;
			node = node.right;
		}
		return sum;
	}
}

//iteration DFS 2
class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		int sum = 0;

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();

			if(node != null){
				int n = node.val;

				if(n>=low && n<=high) sum = sum + n;
				// left child is a possible candidate.
				if(n>low)  stack.push(node.left);
				// right child is a possible candidate
				if(n<high) stack.push(node.right);
			}
		}
		return sum;
	}
}

//recursion
class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {
		int res = helper(root, low, high);

		return res;
	}

	private int helper(TreeNode node, int low, int high){
		if(node==null) return 0;
		int sum = 0;
		if(low<=node.val && node.val<=high) sum = sum + node.val;
		if(low<node.val) sum = sum + helper(node.left, low, high);
		if(node.val<high) sum = sum + helper(node.right, low, high);

		return sum;
	}
}