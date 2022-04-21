import java.util.ArrayList;

//recursion1
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		helper(root, res);
		return res;
	}

	private void helper(TreeNode node, List<Integer> res){
		if(node==null) return;

		res.add(node.val);
		helper(node.left, res);
		helper(node.right, res);
	}
}

//recursion2
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if(root==null) return res;

		res.add(root.val);
		res.addAll(preorderTraversal(root.left));
		res.addAll(preorderTraversal(root.right));
		return res;
	}
}

//dfs iteration1
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode node = root;
		while(!stack.isEmpty()||node!=null){
			while(node!=null){
				//preorder
				res.add(node.val);
				stack.push(node);
				node=node.left;
			}
			node=stack.pop();
			node=node.right;
		}
		return res;
	}
}

//dfs iteration2
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			//preorder
			res.add(node.val);

			if(node.right!=null)
				stack.push(node.right);

			if(node.left!=null)
				stack.push(node.left);
		}
		return res;
	}
}