import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

//recursive DFS
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if(root==null) return res;

		helper(root, 0, res);

		return res;
	}

	private void helper(TreeNode node, int level, List<Integer> res){
		if(node==null) return;
		//since right node has been add into res, so the level of left node will be always less than res.size()
		//for same level, the operation will be executed only once
		if(level==res.size())
			res.add(node.val);
		//traverse right node firstly, so that right node will be added into res firstly
		if(node.right!=null)
			helper(node.right, level+1, res);
		//left nodes have no chance to be added
		if(node.left!=null)
			helper(node.left, level+1, res);
	}
}

//iterative BFS
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
         List<Integer> res =new ArrayList<>();

         if(root==null) return res;

         Queue<TreeNode> queue = new LinkedList<>();

         queue.add(root);

         while(!queue.isEmpty()){
             //because of BFS, the queue only contains nodes on same level
             int levelLength = queue.size();

             for(int i=0;i<levelLength;i++){
                 TreeNode node = queue.poll();
                 //if it is the rightmost element
                 if(i==levelLength-1) res.add(node.val);

                 //add nodes on left subtree
                 if(node.left!=null) queue.add(node.left);
                //add nodes on right subtree
                 if(node.right!=null) queue.add(node.right);
             }
         }
         return res;
	}
}
