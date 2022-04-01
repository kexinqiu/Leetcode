//recursion DFS
//tc:O(n)
//sc:O(n)

//place all the values in their respective positions by sorting them based on their heights
//placing each element (val) to its correct index in the solution array
class Solution {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		getHeight(root, res);
		return res;
	}

	public int getHeight(TreeNode root, List<List<Integer>> res){
		//it will return -1, when reach the deepest node
		if(root==null) return -1;

		//get height of current left and right node
		int leftHeight = getHeight(root.left, res);
		int rightHeight = getHeight(root.right, res);
		//leftHeight and rightHeight will be different, when traverse root and last node on right subtree
		//make sure the root node will be places in correct index in array
		int height = Math.max(leftHeight, rightHeight)+1;
		//when height<res.size(), means the leaf nodes on same level already exist
		if(res.size()==height)
			res.add(new ArrayList<Integer>());
		//add the ndoe into array
		res.get(height).add(root.val);
		//get the leftHeight and rightHeight
		return height;
	}
}