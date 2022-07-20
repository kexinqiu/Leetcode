//tc: o(2^n)
//tree 只需要在意左边的node，因为右边是‘）’
//左边的node数量是2^n，但因为剪枝，最多2^n / 2

//sc: o(n)

// 做减法
class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		// 特判
		if (n == 0) {
			return res;
		}
		// 执行深度优先遍历，搜索可能的结果
		backtracking("", res, n, n);

		return res;
	}

	public void backtracking(String str, List<String> res, int left, int right){
		// 因为每一次尝试，都使用新的字符串变量，所以无需回溯
		if(left==0 && right==0) {
			res.add(str);
			return;
		}
		// 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
		if(left>right){
			return;
		}

		if(left>0){
			backtracking(str+'(', res, left-1, right);
		}

		if(right>0){
			backtracking(str+')', res, left, right-1);
		}
	}
}


//bfs
class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		// 特判
		if (n == 0) {
			return res;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node("", n, n));

		while(!queue.isEmpty()){
			Node node = queue.poll();

			if(node.left==0 && node.right==0){
				res.add(node.str);
			}

			if(node.left>0) queue.offer(new Node(node.str+'(', node.left-1, node.right));

			if(node.right>0 && node.left<node.right) queue.offer(new Node(node.str+')', node.left, node.right-1));
		}

		return res;
	}
}

class Node{
	String str;
	int left;
	int right;

	public Node(String str, int k1, int k2){
		this.str = str;
		this.left = k1;
		this.right = k2;
	}
}