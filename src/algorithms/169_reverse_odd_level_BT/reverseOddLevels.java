class Solution {
	public TreeNode reverseOddLevels(TreeNode root) {
		if (root == null) return root;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int level = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();
			TreeNode[] arr = new TreeNode[size];

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				arr[i] = node;

				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}

			if(level % 2 != 0) {

				int left = 0;
				int right = size - 1;

				while (left < right) {
					int tmp = arr[left].val;
					arr[left].val = arr[right].val;
					arr[right].val = tmp;

					left++;
					right--;
				}
			}
			level++;
		}
		return root;
	}
}