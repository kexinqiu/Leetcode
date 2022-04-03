
//dfs inorder recursion
class Solution {
	// the smallest (first) and the largest (last) nodes
	Node first = null;
	Node last = null;

	public void helper(Node node) {
		if (node != null) {
			// left
			helper(node.left);
			// node
			if (last != null) {
				// link the previous node (last)
				// with the current one (node)
				last.right = node;
				node.left = last;
			}
			else {
				// keep the smallest node
				// to close DLL later on
				first = node;
			}
			last = node;
			// right
			helper(node.right);
		}
	}

	public Node treeToDoublyList(Node root) {
		if (root == null) return null;

		helper(root);
		// close DLL
		last.right = first;
		first.left = last;
		return first;
	}
}

//dfs iteration
class Solution {
	public Node treeToDoublyList(Node root) {
		if(root==null) return null;

		Stack<Node> stack = new Stack<>();

		Node first = null;
		Node last = null;
		Node node = root;

		while(!stack.isEmpty() || node!=null){
			while(node!=null){
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();

			if(first!=null){
				last.right = node;
				node.left = last;

			}else{
				first = node;
			}
			last = node;
			node = node.right;
		}
		last.right = first;
		first.left = last;

		return first;
	}
}