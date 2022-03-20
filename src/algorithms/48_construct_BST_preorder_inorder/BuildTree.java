class Solution {
	//firstly, in preorder array, we can get root node in preorder[0]
	//then, in inorder array,  we fine the index of root, and we know the nodes before the root is left side, the node after the root is right side
	//then get the root2 of left side in preorder, get the index of the root in inorder, and get the left side and right side of this root2.
	//recursively doing this on subarrays, we can build a tree

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		HashMap<Integer, Integer> map = new HashMap<>();
		//key is the number in inorder array, value is the index
		//we can do this, because preorder and inorder consist of unique values
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i], i);
		}

		return helper(preorder, inorder, 0, 0, inorder.length-1, map);

	}
	//preStart is the root of subtree in preorder
	//intStart is the start index of subtree in inorder, intEnd is the end index of subtree in inorder
	private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd,  HashMap<Integer, Integer> map){
		//when the recursion will stop
		if(preStart>preorder.length-1 || inStart>inEnd ) return null;
		//get the root node
		TreeNode root = new TreeNode(preorder[preStart]);
		//get the index of root in inorder
		int rootIndex = map.get(preorder[preStart]);

		root.left = helper(preorder, inorder, preStart+1, inStart, rootIndex-1, map);
		//the root node of right side is the index skiping all the nodes on left side
		//it should be the number of nodes on left is (rootIndex-intStart)
		root.right = helper(preorder, inorder, preStart+rootIndex-inStart+1, rootIndex+1, inEnd, map);

		return root;

	}
}