//preorder 在反序列化时更容易定位出根节点的值
//根结点 ｜ 左子树 ｜ 右子树
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

	private TreeNode buildTree(Queue<String> queue){

		String s = queue.poll();
		if(s.equals("X")) return null;

		TreeNode node = new TreeNode(Integer.parseInt(s));

		node.left = buildTree(queue);
		node.right = buildTree(queue);

		return node;
	}
}
