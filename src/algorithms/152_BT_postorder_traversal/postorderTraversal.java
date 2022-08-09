//tc:o(n)
//sc:o(1)

//dfs recursion
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		dfs(root, res);
		return res;
	}

	private TreeNode dfs(TreeNode root, List<Integer> res){
		//base
		if(root==null) return root;

		TreeNode left = dfs(root.left, res);
		TreeNode right = dfs(root.right, res);

		res.add(root.val);

		return root;

	}
}

//iteration
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if(root==null) return res;

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			res.addFirst(node.val);

			if(node.left!=null) stack.add(node.left);
			if(node.right!=null) stack.add(node.right);
		}
		return res;
	}
}