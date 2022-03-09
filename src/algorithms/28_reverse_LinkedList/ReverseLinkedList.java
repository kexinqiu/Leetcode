class Solution {
	public ListNode reverseList(ListNode head) {
		//prev always point to the node in the front of head
		ListNode prev = null;


		//head.next point into prev node
		//prev points into head node
		//head always point into next_node


		while(head != null){
			//pass reference to head.next in next_node
			ListNode next_node = head.next;
			//point head.next into prev
			head.next = prev;
			//point prev into head node
			prev = head;
			//point head into next_node
			head = next_node;
		}
		return prev;
	}

}