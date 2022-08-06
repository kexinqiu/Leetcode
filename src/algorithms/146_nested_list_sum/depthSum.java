//tc:o(n)
//sc:o(n)
// at most O(D) recursive calls are placed on the stack, where D is the maximum level of nesting in the input.

//dfs
class Solution {
	public int depthSum(List<NestedInteger> nestedList) {

		return dfs(nestedList, 1);
	}

	public int dfs(List<NestedInteger> list, int depth){
		int total = 0;

		for(NestedInteger nested : list){
			if(nested.isInteger()){
				total += depth * nested.getInteger();
			}else{
				total += dfs(nested.getList(), depth+1);
			}
		}
		return total;
	}
}

//bfs
class Solution {
	public int depthSum(List<NestedInteger> nestedList) {

		int total = 0;
		int depth = 1;

		Queue<NestedInteger> queue = new LinkedList<>();

		queue.addAll(nestedList);

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0;i<size;i++){
				NestedInteger nested = queue.poll();
				if(nested.isInteger()){
					total += nested.getInteger() * depth;
				}else{
					queue.addAll(nested.getList());
				}
			}
			depth++;
		}
		return total;
	}
}