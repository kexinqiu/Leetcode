import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


TC:O(n)
SC:O(n)

//iteration BSF
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new LinkedList<>();
		if(root==null) return res;
		//stores all nodes in same level
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			List<Integer> level = new LinkedList<>();
			//queue only contains nodes in same level
			//so the size the number of the nodes in same level
			int size = queue.size();
			//iterate every level
			//for every level: first step, poll() and get the node, and then add it into the list
			//second step, get the left subtree and right subtree of the node you removed, add them into queue;
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				level.add(node.val);

				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
			//add every level list into result list
			res.add(level);
		}
		return res;
	}
}


//recursion DSF
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new LinkedList<>();
		if(root==null) return res;

		levelHelper(res, root, 0);
		return res;
	}

	private void levelHelper(List<List<Integer>> res, TreeNode root, int level){
		//base case
		if(root==null) return;

		int size = res.size();
		//start the current level
		if(level==size){
			res.add(new LinkedList<>());
		}
		//fulfil the current level
		res.get(level).add(root.val);
		//recursion
		levelHelper(res, root.left, level+1);
		levelHelper(res, root.right, level+1);
	}
}