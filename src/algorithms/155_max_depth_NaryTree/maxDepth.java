
//dfs
//tc：o（n）
//sc：o（n）in the worst case, the tree is completely unbalanced
class Solution {
	public int maxDepth(Node root) {

		return dfs(root);
	}

	public int dfs(Node root){
		if(root==null){
			return 0;
		}

		int max = 0;
		//和binary tree不一样，不是left和right，要用for loop
		for(Node c : root.children){
			max = Math.max(max, dfs(c));
		}
		return max+1;
	}
}

//bfs
class Solution {
	public int maxDepth(Node root) {

		if(root==null) return 0;
		int depth = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			int size = queue.size();
			depth++;
			for(int i=0;i<size;i++){
				Node node = queue.poll();
				for(Node c : node.children){
					if(c!=null){
						queue.add(c);
					}
				}
			}
		}
		return depth;
	}
}