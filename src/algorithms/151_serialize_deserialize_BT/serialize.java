//DFS
//preorder 在反序列化时更容易定位出根节点的值
//根结点 ｜ 左子树 ｜ 右子树
// 1 | 2 X X | 3 4 X X 5 X X|
//        1
//  2          3
//           4   5
//tc：o（n）
//sc：o（n）
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		//base
		if(root==null) return "X,";

		String left = serialize(root.left);
		String right = serialize(root.right);

		return root.val + "," + left + right;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		List<String> list = new ArrayList<>();
		String[] nodes = data.split(",");

		Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));

		return buildTree(queue);
	}
	//poll()出 list 的首项，构建当前子树的根节点，顺着 list，构建顺序是根节点，左子树，右子树。
	//如果弹出的字符为 "X"，则返回 null 节点。
	//如果弹出的字符是数值，则创建root节点，并递归构建root的左右子树，最后返回root。
	private TreeNode buildTree(Queue<String> queue){

		String s = queue.poll();
		if(s.equals("X")) return null;

		TreeNode node = new TreeNode(Integer.parseInt(s));

		node.left = buildTree(queue);
		node.right = buildTree(queue);

		return node;
	}
}

//BFS
//序列化：存入string list
// 1 | 2 3 | X X 4 5 | X X X X
//     1
// 2      3
//       4  5
//反序列化：
//先让根结点入列，然后根结点出列，若左节点和右节点非null，则左右节点入列
//不断循环 将每一个父节点和左右子节点绑定


public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root==null) return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node==null) sb.append("X,");
			else{
				sb.append(node.val+",");
				queue.add(node.left);
				queue.add(node.right);
			}

		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data=="") return null;

		String[] str = data.split(",");
		Queue<String> nodes = new LinkedList<>(Arrays.asList(str));

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			String left = nodes.poll();
			String right = nodes.poll();
			if(!left.equals("X")){
				TreeNode leftNode = new TreeNode(Integer.parseInt(left));
				node.left = leftNode;
				queue.add(leftNode);
			}
			if(!right.equals("X")){
				TreeNode rightNode = new TreeNode(Integer.parseInt(right));
				node.right = rightNode;
				queue.add(rightNode);
			}
		}

		return root;
	}
}