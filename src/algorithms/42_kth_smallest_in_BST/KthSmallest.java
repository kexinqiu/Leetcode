//BST   左边的node永远比右边的小， 因此kth smallest要dfs 从left subtree 开始

//iteration
class Solution {
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root!=null){
			//go deep on left, put left nodes into stack
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			//pop the top node and get it as root
			root = stack.pop();
			//if k=0, means we get the node we want, break
			if(--k==0) break;
			//traverse right branch
			root = root.right;
		}
		return root.val;
	}
}

//recursion DFS
class Solution {
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> array = inorder(root, new ArrayList<Integer>());
		return array.get(k-1);
	}

	private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> array){
		//base case
		if(root==null) return array;

		inorder(root.left, array);
		array.add(root.val);

		inorder(root.right, array);

		return array;
	}
}