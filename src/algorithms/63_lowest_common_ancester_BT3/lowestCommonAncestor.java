import java.util.Set;

//there are 3 situations
//1. p and q are in different subtree, then common valu the set containing is the value of root
//2. p is above p
//3. p is below p
class Solution {
	public Node lowestCommonAncestor(Node p, Node q) {

		Set<Integer> set = new HashSet<>();
		//store all the value of nodes in path from p to root
		while(p!=null){
			set.add(p.val);
			p = p.parent;
		}
		//traverse the path from q to the root
		while(q!=null){
			//the first common point of the two paths is the LCA
			if(set.contains(q.val)) return q;
			q = q.parent;
		}
		return null;
	}
}

class Solution {
	public Node lowestCommonAncestor(Node p, Node q) {
		int pHeight = getHeight(p);
		int qHeight = getHeight(q);

		int height = Math.abs(pHeight-qHeight);
		// Make sure "p" always points to deeper node (for less code duplication)
		if(pHeight<qHeight){
			Node tmp = p;
			p = q;
			q = tmp;
		}
		// Move up to ensure the we start our search from same level for both the nodes
		while(height>0){
			p = p.parent;
			height--;
		}
		//if q and p are in the same subtree, they are equal at first
		//if they are not, we need to search upwards till the paths intersect
		while(p!=q){
			p = p.parent;
			q = q.parent;
		}
		return p;
	}

	private int getHeight(Node n){
		int height = 0;
		while(n!=null){
			n = n.parent;
			height++;
		}
		return height;
	}
}