class Solution {
	//we get the root node that is the at last index of postorder array
	//and then we need use the inorder array to get left subtree and right subtree
	//update root node, left subtree and right subtree recursively
	public TreeNode buildTree(int[] inorder, int[] postorder) {

		HashMap<Integer, Integer> map = new HashMap<>();
		//add the value and index of elements in inorder array into hashmap
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i], i);
		}

		return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1, map);
	}

	private TreeNode helper(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd, HashMap<Integer, Integer> map){
		//postStart is the last element in array, which is different from preorder
		//if postStart<0 means there is no element in postorder
		if(postStart<0 || inStart>inEnd) return null;
		//The last element in postorder is the root.
		TreeNode root = new TreeNode(postorder[postStart]);

		int rootIndex = map.get(root.val);
		//build right and left subtrees recursively
		root.left = helper(inorder, postorder, postStart-(inEnd-rootIndex)-1, inStart, rootIndex-1, map );
		root.right = helper(inorder, postorder, postStart-1, rootIndex+1, inEnd, map);

		return root;
	}
}