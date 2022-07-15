package basic.graph;
//template


// 节点访问标识,访问过的节点无需访问（剪枝）
int[][] visited = new int[m][n];
// 队列初始化
	Queue<Node> queue = new LinkedList();

// 【第1步】将起点加入队列, 非空进入循环
	queue.add(第一个数据)
	while(!queue.isEmpty()) {
	// 【第2步】 获取当前队列长度即同一层级（辈分）节点个数，并遍历
	int size = queue.size(); // 一定要先获取，queue后面要加入下一层级节点
	for (int i = 0; i < size; i++) {
	// 【第3步】 对同一层级节点逐个寻找下一层有效**路径节点**，找到目标直接返回结果终止搜索。
	Node node = queue.poll();
	// 下一层节点 比如网格上下左右移动
	Node nextNode = node.x + xj;
	//  1. 不符合要求的下一层节点直接过滤（比如越界、已经被visited[][]标记访问了）
	//  2. 找到目标节点 直接返回结果
	//  3. 符合要求的下一层节点放入队列
	queue.offer(nextNode)
	}
	}
// 【第4步】 BFS搜索完成没找到结果，返回-1
	return -1;
所有。商业转载请联系作者获得授权，非商业转载请注明出处。