
 //                4
//			  /	          \
//           2            7
//        /    \          / \
//       1      3         6   9


//dfs recursion postorder
// 一直go deep到最左边的root[1]， swap 它的两个 null node；
// 到达root[3]， swap它的两个 null node；
// 返回到root[2],  swap root[1] 和 root[3]；
// 到达root[6]，swap 它的两个 null node；
// 到达root[9]，swap 它的两个 null node；
// 返回到root[7]， swap root[6] 和 root[9]；
// 返回到root[4] , swap root[2] 和 root[7]；

class Solution {
	public TreeNode invertTree(TreeNode root) {
		//base case
		if (root == null) return root;

		//DFS go deep until null
		//first recur on left subtree
		TreeNode left = invertTree(root.left);
		//then recur on right subtree
		TreeNode right = invertTree(root.right);

		//swap
		root.left = right;
		root.right = left;

		return root;
	}
}

 //BFS iteration
 class Solution {
	 public TreeNode invertTree(TreeNode root) {
		 if(root==null) return root;

		 Queue<TreeNode> queue = new LinkedList<>();
		 queue.add(root);

		 while(!queue.isEmpty()){
			 TreeNode node = queue.poll();

			 TreeNode tmp = node.left;
			 node.left = node.right;
			 node.right = tmp;

			 if(node.left!=null) queue.add(node.left);
			 if(node.right!=null) queue.add(node.right);
		 }
		 return root;
	 }
 }