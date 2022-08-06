
                                        Binary Tree Traversals
                                    /                           \
                                  DFS                            BFS
              /                     |              \                    |
          Preorder              Inorder           Postorder         Iterative with queue
    /      |         \         /   |   \           /   |   \ 
Iterative  Recursive  Morris   
with stack


DFS Preorder:               DFS Inorder:             DFS Postorder:
1.base case                 1.base case              1.base case
2. operation                2.recursion on left      2.recursion on left
3. recursive on left        3.operation              3.recursion on right
4. recursive on right       4.recursion on right     4.operation

DFS recursion:
Inorder:
    //leetcode 94
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		helper(root, res);
		return res;
	}
	private void helper(TreeNode node, List<Integer> res){
		if(node==null) return;
        //当不需要对node本身进行操作时，不需要store left subtree node
		//like left_subtree = helper(node.left, res);
		//recursion on left 
		helper(node.left, res);
		//operation
		res.add(node.val);
		//recursion on right
		helper(node.right, res);
	}

Postorder:
	//leetcode 226:
	public TreeNode invertTree(TreeNode root) {
		if(root==null) return null;
		TreeNode node = helper(root);
		return node;
	}

    public TreeNode helper(TreeNode root){
        if(root==null) return root;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root; 
    }

preorder：
//leetcode 144

    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		helper(root, res);
		return res;
	}
	private void helper(TreeNode node, List<Integer> res){
		if(node==null) return;
		//operation
		res.add(node.val);
		// recursion on left
		helper(node.left, res);
		// recursion on left
		helper(node.right, res);
	}



DFS iteration:
Inorder:
public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(!stack.isEmpty()||curr!=null){
            while(curr!=null){
                stack.push(curr);
				//traverse on left
                curr=curr.left;
            }
            curr=stack.pop();

            //operation
            res.add(curr.val);

			//traverse on right
            curr=curr.right;
        }
        return res;
    }

preorder

public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            //先进后出，右先进，左后进！！

            if(node.right!=null) stack.add(node.right);
            if(node.left!=null) stack.add(node.left);
        }
        return res;
    }


BFS iteration:
public TreeNode bfs(TreeNode root) {
		if(root==null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            operation();
            
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
       return root;
    }