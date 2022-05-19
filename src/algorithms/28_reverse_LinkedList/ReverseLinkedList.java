//tc: O(N)

class Solution {
	public ListNode reverseList(ListNode head) {
		//prev always point to the node in the front of head
		ListNode prev = null;
		ListNode curr = head;

		while(curr != null){
			//pass reference to head.next in next_node
			ListNode next_node = curr.next;
			//point head.next into prev
			curr.next = prev;
			//point prev into head node
			prev = curr;
			//point head into next_node
			curr = next_node;
		}
		return prev;
	}
}