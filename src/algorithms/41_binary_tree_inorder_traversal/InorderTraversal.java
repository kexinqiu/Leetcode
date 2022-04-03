import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

//iterative
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		//go deep on left, put left nodes into stack
		while(root != null || !stack.isEmpty()){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			//pop the top node and get it as root
			root = stack.pop();
			//add the value of root into list
			list.add(root.val);
			//traverse right node
			root = root.right;
		}
		return list;
	}
}

//recursive
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		help(root, res);
		return res;
	}

	private void helper(TreeNode node, List<Integer> res){
		if(node==null) return;
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);
	}
}