//BFS with hashmap and queue
//tc: O(nlogn)
//the first part of BFS is O(n); the second part of BFS is O(nlogn)
 class Solution {
     public List<List<Integer>> verticalOrder(TreeNode root) {

         List<List<Integer>> res = new ArrayList();

         if (root == null) {
             return res;
         }
         // creat a hash table to store the pair of [column and nodes]
         Map<Integer, ArrayList> colTable =new HashMap<>();
         //store the pair of node and column
         Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();

         //add root and its column into queue.
         int col = 0;
         queue.offer(new Pair(root, col));

         //get the node in queue BFS
         while(!queue.isEmpty()){
             Pair<TreeNode, Integer> p = queue.poll();
             TreeNode node = p.getKey();
             col = p.getValue();

             if(!colTable.containsKey(col)){
                 colTable.put(col, new ArrayList<Integer>());
             }

             colTable.get(col).add(node.val);

             if(node.left!=null){
                 queue.offer(new Pair(node.left, col-1));
             }

             if(node.right!=null){
                 queue.offer(new Pair(node.right, col+1));
             }
         }

         List<Integer> storeCol = new ArrayList<Integer>(colTable.keySet());
         Collections.sort(storeCol);
         for(int c: storeCol){
             res.add(colTable.get(c));
         }
         return res;
     }
 }

//BFS without sorting
//tc: O(nlogn)
class Solution {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if(root==null) return res;

		Map<Integer, ArrayList<Integer>> colTable = new HashMap<>();
		//queue can't be implemented by ArrayList
		Queue<TreeNode> qNode = new LinkedList<>();
		Queue<Integer> qCol = new LinkedList<>();

		int col = 0;
		qNode.offer(root);
		qCol.offer(col);

		int min = 0;
		int max = 0;

		while(!qNode.isEmpty()){

			TreeNode node = qNode.poll();
			col = qCol.poll();

			if(!colTable.containsKey(col)) {
				colTable.put(col, new ArrayList<Integer>());
			}

			colTable.get(col).add(node.val);

			if(node.left!=null){
				qNode.offer(node.left);
				qCol.offer(col-1);
				min = Math.min(min, col-1);
			}

			if(node.right!=null){
				qNode.offer(node.right);
				qCol.offer(col+1);
				max = Math.max(max, col+1);
			}
		}

		for(int i=min;i<=max;i++){
			res.add(colTable.get(i));
		}
		return res;
	}
}