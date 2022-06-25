//tc:o(n)
//sc:o(1) 因为只new了一个node，一直在复用

//1.
class Solution {
	public Node copyRandomList(Node head) {

		if(head==null) return null;

		Node p = head;
		//1.copy new node after the original one
		while(p!=null){
			Node newNode = new Node(p.val);
			newNode.next = p.next;
			p.next = newNode;
			p = newNode.next;
		}

		//2.copy the pointers
		p = head;
		while(p!=null){
			if(p.random!=null){
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}

		//3.split
		Node dummy = new Node(0);
		p = head;
		Node curr = dummy;

		while(p!=null){
			curr.next = p.next;
			curr= curr.next;
			p.next = curr.next;
			p = p.next;
		}

		return dummy.next;
	}
}

//2.hashmap
// tc: o(n)
// sc: o(n)
class Solution {
	public Node copyRandomList(Node head) {

		if(head==null) return null;

		HashMap<Node, Node> map = new HashMap<>();

		Node p = head;

		while(p!=null){
			Node newNode = new Node(p.val);
			map.put(p, newNode);
			p = p.next;
		}

		p = head;

		while(p!=null){
			Node newNode = map.get(p);

			if(p.next!=null) {
				newNode.next = map.get(p.next);
			}

			if(p.random!=null) {
				newNode.random = map.get(p.random);
			}

			p = p.next;
		}
		return  map.get(head);
	}
}