//change the directed graph to undirected graph by using hashtable
//so that we are able to bounce from a node to its parent, from a parent to its node whichever way

//turn BT into undirected graph by using hash table to know parent of nodes

//because a child node can be other nodes' parent node, we need a seen list to avoid duplication

//https://www.youtube.com/watch?v=nPtARJ2cYrg&t=48s&ab_channel=BackToBackSWE

//tc:O(n)
//sc:O(n)

//1. dfs+hashmap buils a undirected graph, so that you can get all nodes connected to the one node: parent-child and
// child-parent
//2. do bfs to find all nodes within distance k
class Solution {
	//here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure
	Map<TreeNode, List<TreeNode>> parentMap = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> res = new ArrayList<>();

		if(root==null || k<0) return res;

		buildParentMap(root, null);

		if (!parentMap.containsKey(target)) return res;

		Set<TreeNode> seen = new HashSet<>();
		//target node as the start of our undirected graph
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(target);
		seen.add(target);

		while(!queue.isEmpty()){
			int size = queue.size();
			//reach the level whose distance is k from the target node
			if(k==0){
				for(int i=0;i<size;i++){
					TreeNode node = queue.poll();
					res.add(node.val);
				}
				return res;
			}

			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				//fulfil the queue with nodes on same level
				for(TreeNode next:parentMap.get(node)){
					//avoid duplication
					if(!seen.contains(next)){
						queue.add(next);
						seen.add(next);
					}
				}
			}
			k--;
		}
		return res;
	}

	private void buildParentMap(TreeNode node, TreeNode parent){
		if(node==null) return;
		if(!parentMap.containsKey(node)) {
			parentMap.put(node, new ArrayList<>());
			if(parent!=null) {
				parentMap.get(node).add(parent);
				parentMap.get(parent).add(node);
			}
			buildParentMap(node.left, node);
			buildParentMap(node.right, node);
		}
	}
}